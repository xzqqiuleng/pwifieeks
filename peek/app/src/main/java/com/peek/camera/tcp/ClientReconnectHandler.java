package com.peek.camera.tcp;

import android.os.Handler;
import android.os.Message;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.util.HashedWheelTimer;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

@ChannelHandler.Sharable
public abstract class ClientReconnectHandler extends ChannelInboundHandlerAdapter implements TimerTask, FireChannelHandlers {

    public static volatile boolean CONNECTION_STATE = false;//对外提供连接标志
    protected final HashedWheelTimer timer = new HashedWheelTimer();
    private int reconnectCount;
    private final Bootstrap bootstrap;
    private final String host;
    private final int port;
    private Message message;
    private final Handler msgHandler;

    public ClientReconnectHandler(Bootstrap bootstrap, String host, int port, Handler msgHandler) {
        this.bootstrap = bootstrap;
        this.host = host;
        this.port = port;
        this.msgHandler = msgHandler;
    }

    //当通道建立时
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("当前链路已经激活了，重连尝试次数重新置为0");
        reconnectCount = 0;
        CONNECTION_STATE = true;
        ctx.fireChannelActive();
    }
    //通道关闭时启动重连
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("通道关闭,将再次进行重连");
        CONNECTION_STATE = false;
        if (reconnectCount < 4) {
            reconnectCount++;
            System.out.println("重连第"+reconnectCount+"次");

            message = new Message();
            message.what = 2;
            message.obj = "重连第"+reconnectCount+"次";
            msgHandler.sendMessage(message);

            int timeout = 2 << reconnectCount;
            timeout = 3;
            timer.newTimeout(this, timeout, TimeUnit.MILLISECONDS);
        }else{
            message = new Message();
            message.what = 1;
            message.obj = "重连失败";
            msgHandler.sendMessage(message);
        }
        ctx.fireChannelInactive();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buffer = (ByteBuf) msg;
        byte[] data = buffer.array();

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

            message = new Message();
            message.what = 5;
            message.obj = voltage;
            msgHandler.sendMessage(message);
            return;
        }else if(data.length >= 7 && data[0] == 0x01 && data[1] == 0x03 && data[2] == 0x02){
            // 01 03 02 0H 0L CRC
            //电量取值范围 9-12.5, 精度0.01
            int voltage = (((int)data[3]) << 8) + (int)data[4];
            int power = (int) Math.round((voltage - 900) * 100.0 / (1250 - 900));
            if(power < 0){
                power = 0;
            }
            if(power > 100){
                power = 100;
            }
            System.out.println("收到探头电量:" + power);

            message = new Message();
            message.what = 4;
            message.obj = power;
            msgHandler.sendMessage(message);
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

            message = new Message();
            message.what = 3;
            message.obj = strDistant;
            msgHandler.sendMessage(message);
        }else{
            ReferenceCountUtil.release(msg);
        }

    }

    @Override
    public void run(Timeout timeout) throws Exception {
        ChannelFuture channelFuture;
        synchronized (bootstrap) {
            bootstrap.handler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast(channelHandlers());
                }
            });
            channelFuture = bootstrap.connect(host,port);
        }

        //添加重连监听
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                boolean success = channelFuture.isSuccess();
                if(!success){
                    System.out.println("重连失败");
                    channelFuture.channel().pipeline().fireChannelInactive();
                }else{
                    CONNECTION_STATE = true;
                    System.out.println("重连成功");
                }
            }
        });
    }
}