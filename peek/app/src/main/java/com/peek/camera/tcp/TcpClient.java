package com.peek.camera.tcp;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpClient {

    public static Socket socket;
    public static Handler handler;
    public static boolean isReconnect = true;
    public static int reconnectSecond = 3;
    public static int reconnectTimes = 5;
    public static boolean isRun = false;
    public static int reconnectTime = 0;

    public static void setHandle(Handler msgHandler){
        handler = msgHandler;
    }

    public static void startClient(final String address , final int port){
        if (address == null){
            return;
        }
        isRun = true;
        if (socket == null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log.i("tcp", "启动客户端");
//                        SocketAddress socketAddress = new InetSocketAddress(address, port);
//                        socket = new Socket();
//                        socket.connect(socketAddress, 5000);
                        socket = new Socket(address, port);
                        Log.i("tcp", "客户端连接成功");

                        Message message = new Message();
                        message.what = 0;
                        message.obj = "连接成功";
                        handler.sendMessage(message);

                        reconnectTime = 0;
                        PrintWriter pw = new PrintWriter(socket.getOutputStream());
                        InputStream inputStream = socket.getInputStream();
                        byte[] buffer = new byte[1024];
                        int len = -1;
                        while ((len = inputStream.read(buffer)) != -1) {
                            DecodeData(buffer, len);
                            String data = new String(buffer, 0, len);
                            Log.i("tcp", "收到服务器的数据---------------------------------------------:" + data);

                        }

                        Log.i("tcp", "客户端断开连接");
                        pw.close();

                    } catch (Exception EE) {
                        EE.printStackTrace();
                        Log.i("tcp", "客户端无法连接服务器");
                    }finally {
                        if(isRun){
                            try {
                                if(socket != null)
                                    socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            socket = null;
                        }
                        if(isReconnect){
                            if(reconnectTime < reconnectTimes){
                                reconnectTime++;
                                Message message = new Message();
                                message.what = 2;
                                message.obj = "重连第"+reconnectTime+"次";
                                handler.sendMessage(message);
                                try {
                                    Thread.sleep(1000 * reconnectSecond);
                                }catch (Exception ex){
                                    ex.printStackTrace();
                                }
                                startClient(address, port);
                            }else{
                                Message message = new Message();
                                message.what = 1;
                                message.obj = "连接失败";
                                handler.sendMessage(message);
                            }
                        }else{
                            isReconnect = true;
                        }
                    }
                }
            }).start();
        }
    }

    public static void sendTcpMessage(final byte[] data){
        if (socket != null && socket.isConnected()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log.i("tcp", "发送数据");
                        socket.getOutputStream().write(data);
                        socket.getOutputStream().flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void stop(){
        isReconnect = false;
        isRun = false;
        try {
            if(socket != null)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(socket != null){
            socket = null;
        }
    }

    public static void sendMessage(int cmd){
        switch (cmd){
            case CMD_UP:
                sendTcpMessage(UP);
                break;
            case CMD_UP_RLS:
                sendTcpMessage(UP_RLS);
                break;
            case CMD_DOWN:
                sendTcpMessage(DOWN);
                break;
            case CMD_DOWN_RLS:
                sendTcpMessage(DOWN_RLS);
                break;
            case CMD_DISTANCE:
                sendTcpMessage(DISTANCE);
                break;
            case CMD_TANTOU:
                sendTcpMessage(TANTOU);
                break;
            case CMD_ZHONGJI:
                sendTcpMessage(ZHONGJI);
                break;
        }
    }


    public static void DecodeData(byte[] arrays, int len)  {
        byte[] data = null;

        //设备问题，返回数据有自动添加帧头现象，见过 三种情况 ： 00 00  、  08  00  、 04 00
        if( (arrays[0] == 0x00 && arrays[1] == 0x00)
                || ((arrays[0] & 0x00ff) == 0x40 && arrays[1] == 0x00)
                || ((arrays[0] & 0x00ff) == 0x80 && arrays[1] == 0x00)
        )  {
            data = new byte[arrays.length - 2];
            for (int i = 0; i < arrays.length - 2; i++) {
                data[i] = arrays[i+2];
            }
        }else{
            data = arrays;
        }

        //中继电量
        if(data.length >= 4 && (data[0]&0x00FF) == 0x008f && (data[1]&0x00FF) == 0x00bb ){
            // 8F bb 电量 FF
            int voltage = data[2] & 0x00FF;
            if(voltage < 0){
                voltage = 0;
            }
            if(voltage > 100){
                voltage = 100;
            }

            System.out.println("收到中继电量:" + voltage);

            Message message = new Message();
            message.what = 5;
            message.obj = voltage;
            handler.sendMessage(message);
            return;
        }else if(data.length >= 7 && data[0] == 0x01 && data[1] == 0x03 && data[2] == 0x02){
            // 01 03 02 0H 0L CRC
            //电量取值范围 9-12.5, 精度0.01
            int voltage = ((data[3] & 0x00FF) << 8) + (data[4] & 0x00FF);
            int power = (int)Math.round((voltage - 900) * 100.0 / (1250 - 900));
            if(power < 0){
                power = 0;
            }
            if(power > 100){
                power = 100;
            }
            System.out.println("收到探头电量:" + power);

            Message message = new Message();
            message.what = 4;
            message.obj = power;
            handler.sendMessage(message);
        }else if(data.length >= 15 && data[0] == 0x3A && data[7] == 0x6D){
//        接收到的数据共有15位，是由ascii码转化为16进制数的。开头为“：”冒号，转化为3A;“m”字符转化为6D。
//        比如   :0.598m,0.578 转为
//        3A 20 30 2E 35 39 38 6D 2C 30 35 37 38 0D 0A
//        保存3A和6D（包括）之间的8位数。
            byte[] distant = new byte[7];
            for (int i = 0; i < 7; i++) {
                distant[i] = data[1+i];
            }
            String strDistant = new String(distant);
            System.out.println("收到测距返回:" + strDistant);

            Message message = new Message();
            message.what = 3;
            message.obj = strDistant;
            handler.sendMessage(message);
        }else{

        }

    }



    public final static int CMD_UP = 0;
    public final static int CMD_UP_RLS = 1;
    public final static int CMD_DOWN = 2;
    public final static int CMD_DOWN_RLS = 3;
    public final static int CMD_DISTANCE = 4;
    public final static int CMD_TANTOU = 5;
    public final static int CMD_ZHONGJI = 6;

    public final static int FRAME_LEN_CMD = 4;

    //按住“上”不放	发送命令：0x8f  0x52  0x00  0xff
    //   “上”放开	发送命令：0x8f  0x54  0x00  0xff
    //按住“下”不放	发送命令：0x8f  0x53  0x00  0xff
    //   “下”放开	发送命令：0x8f  0x54  0x00  0xff
    //按住上不放
    public final static byte[] UP          = {(byte)0x8f, (byte)0x52, (byte)0x00, (byte)0xff};
    //上放开
    public final static byte[] UP_RLS      = {(byte)0x8f, (byte)0x54, (byte)0x00, (byte)0xff};
    //按住下不放
    public final static byte[] DOWN        = {(byte)0x8f, (byte)0x53, (byte)0x00, (byte)0xff};
    //下放开
    public final static byte[] DOWN_RLS    = {(byte)0x8f, (byte)0x54, (byte)0x00, (byte)0xff};
    //测距
    public final static byte[] DISTANCE    = {(byte)0x8f, (byte)0x22, (byte)0x00, (byte)0xff};

    //中继电量
    public final static byte[] ZHONGJI     = {(byte)0x8f, (byte)0xbb, (byte)0x00, (byte)0xff};

    //电量 01 03 00 00 00 01 84 0A
    public final static int FRAME_LEN_TANTOU = 8;
    public final static byte[] TANTOU       = {(byte)0x01, (byte)0x03, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x84, (byte)0x0A};

    public final static int FRAME_LEN_LIGHT   = 23;

    // bFog 是否是除雾状态，
    // bright_jin 近光亮度，
    // bright_yuan 远光亮度，
    public static byte[] getLightData(int bright_jin, int bright_yuan, boolean bFog){
        byte[] data = new byte[FRAME_LEN_LIGHT];
        data[0] = (byte)0x01;
        data[1] = (byte)0x10;
        data[2] = (byte)0x00;
        data[3] = (byte)0x05;
        data[4] = (byte)0x00;
        data[5] = (byte)0x07;
        data[6] = (byte)0x0E;

        data[7] = (byte)0x00;
        data[8] = (byte)0x00;
        data[9] = (byte)0x00;
        data[10] = (byte)0x00;

        switch (bright_jin){
            case 0:
                data[7] = (byte)0x00;
                data[8] = (byte)0xC8;
                break;
            case 1:
                data[7] = (byte)0x00;
                data[8] = (byte)0xFA;
                break;
            case 2:
                data[7] = (byte)0x01;
                data[8] = (byte)0x04;
                break;
            case 3:
                data[7] = (byte)0x01;
                data[8] = (byte)0x0E;
                break;
            case 4:
                data[7] = (byte)0x01;
                data[8] = (byte)0x18;
                break;
            case 5:
                data[7] = (byte)0x01;
                data[8] = (byte)0x22;
                break;
            case 6:
                data[7] = (byte)0x01;
                data[8] = (byte)0x2C;
                break;
            case 7:
                data[7] = (byte)0x01;
                data[8] = (byte)0x31;
                break;
            case 8:
                data[7] = (byte)0x01;
                data[8] = (byte)0x36;
                break;
            case 9:
                data[7] = (byte)0x01;
                data[8] = (byte)0x3B;
                break;
        }
        switch (bright_yuan){
            case 0:
                data[9] = (byte)0x02;
                data[10] = (byte)0x4E;
                break;
            case 1:
                data[9] = (byte)0x02;
                data[10] = (byte)0x58;
                break;
            case 2:
                data[9] = (byte)0x02;
                data[10] = (byte)0x62;
                break;
            case 3:
                data[9] = (byte)0x02;
                data[10] = (byte)0x6C;
                break;
            case 4:
                data[9] = (byte)0x02;
                data[10] = (byte)0x76;
                break;
            case 5:
                data[9] = (byte)0x02;
                data[10] = (byte)0x7B;
                break;
            case 6:
                data[9] = (byte)0x02;
                data[10] = (byte)0x80;
                break;
            case 7:
                data[9] = (byte)0x02;
                data[10] = (byte)0x85;
                break;
            case 8:
                data[9] = (byte)0x02;
                data[10] = (byte)0x8A;
                break;
            case 9:
                data[9] = (byte)0x02;
                data[10] =(byte)0x8F;
                break;
        }

        data[11] = (byte)0x00;
        data[12] = (byte)0x96;
        data[13] = (byte)0x00;
        data[14] = (byte)0x96;

        data[15] = (byte)0x00;
        data[16] = (byte)0x00;
        data[17] = (byte)0x00;
        data[18] = (byte)0x00;

        //非除雾状态，正常灯光控制即可
        if(!bFog) {
            data[15] = (byte) 0x00;
            data[16] = (byte) 0x01;  //近光打开
            data[17] = (byte) 0x00;
            data[18] = (byte) 0x01;  //远光打开
            data[19] = (byte) 0x00;
            data[20] = (byte) 0x00;  //除雾关闭

            //远光灯灯光0档
            if(bright_yuan == 0){
                data[17] = (byte) 0x00;
                data[18] = (byte) 0x00;  //远光关闭
            }
        }
        //处于除雾状态，近光灯仍可调节，远光灯关闭
        if(bFog){
            //关闭远光灯，近光灯状态不变
            data[15] = (byte) 0x00;
            data[16] = (byte) 0x01;  //近光打开
            data[17] = (byte) 0x00;
            data[18] = (byte) 0x00;  //远光关闭
            data[19] = (byte) 0x00;
            data[20] = (byte) 0x01;  //除雾打开
        }


        int crc16 = CRC16_MODBUS(data, 21);
        data[21] = (byte)(crc16 & 0x00FF);
        data[22] = (byte)((crc16 & 0xFF00) >> 8);

        return data;
    }

    public static int CRC16_MODBUS(byte[] buffer, int length) {
        int wCRCin = 0xffff;
        int POLYNOMIAL = 0xa001;
        for (int i=0; i<length; i++) {
            byte b = buffer[i];
            wCRCin ^= ((int) b & 0x00ff);
            for (int j = 0; j < 8; j++) {
                if ((wCRCin & 0x0001) != 0) {
                    wCRCin >>= 1;
                    wCRCin ^= POLYNOMIAL;
                } else {
                    wCRCin >>= 1;
                }
            }
        }

        return wCRCin ^= 0x0000;
    }


}
