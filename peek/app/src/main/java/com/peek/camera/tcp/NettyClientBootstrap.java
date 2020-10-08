package com.peek.camera.tcp;

import android.os.Handler;
import android.os.Message;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
public class NettyClientBootstrap {
    private static int port;
    private static String host;
    public static SocketChannel socketChannel;
    private static Handler msgHandler;

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

    public static void setPort(int port) {
        NettyClientBootstrap.port = port;
    }

    public static void setHost(String host) {
        NettyClientBootstrap.host = host;
    }

    private static final EventExecutorGroup group = new DefaultEventExecutorGroup(20);

    private static NettyClientBootstrap bootstrap = null;

    public static SocketChannel getSocketChannel() {
        return socketChannel;
    }

    public static NettyClientBootstrap getBootstrap() {
        return bootstrap;
    }


    //静态工厂方法
    public static void Init(int port, String host, Handler msgHandler) throws Exception {
        if (bootstrap == null) {
            bootstrap = new NettyClientBootstrap(port, host, msgHandler);
        } else {
            setHost(host);
            setPort(port);
            bootstrap.start();
        }
    }

    //静态工厂方法
    public static NettyClientBootstrap getInstance() throws Exception {
        if (bootstrap == null) {
            bootstrap = new NettyClientBootstrap(port, host, msgHandler);
        }
        return bootstrap;
    }

    public NettyClientBootstrap(int port, String host, Handler msgHandler) throws Exception {
        this.port = port;
        this.host = host;
        this.msgHandler = msgHandler;
        start();
    }

    private void start() throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.group(eventLoopGroup);
        bootstrap.remoteAddress(host, port);

        bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        final ClientReconnectHandler clientReconnectHandler = new ClientReconnectHandler(bootstrap, host, port, msgHandler) {
            @Override
            public ChannelHandler[] channelHandlers() {
                return new ChannelHandler[]{
                        this, //重连的handler
                        new LoggingHandler(LogLevel.INFO),                //日志handler
                        new StringDecoder(),                             //编码handler
                        new StringEncoder(),                             //解码handler
                        new IdleStateHandler(0, 4, 0, TimeUnit.SECONDS), //心跳检查handler
//                        new ClientUserEventTriggeredHandler()            //心跳检查失败handler
                };
            }
        };

        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
//                socketChannel.pipeline().addLast(new IdleStateHandler(5, 5, 10, TimeUnit.SECONDS));
//                socketChannel.pipeline().addLast(new ObjectEncoder());
//                socketChannel.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
//                socketChannel.pipeline().addLast(new NettyClientHandler());
                socketChannel.pipeline().addLast(clientReconnectHandler.channelHandlers());//正常情况时的连接绑定

            }
        });
        ChannelFuture future = bootstrap.connect(host, port).sync();
        if (future.isSuccess()) {
            socketChannel = (SocketChannel) future.channel();
            System.out.println("connect server  成功---------");

            Message message = new Message();
            message.what = 0;
            message.obj = "连接成功";
            msgHandler.sendMessage(message);
        } else {
            Message message = new Message();
            message.what = 1;
            message.obj = "连接失败";
            msgHandler.sendMessage(message);
        }

    }

    public void stop(){
        socketChannel.pipeline().removeFirst();
        socketChannel.close();
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