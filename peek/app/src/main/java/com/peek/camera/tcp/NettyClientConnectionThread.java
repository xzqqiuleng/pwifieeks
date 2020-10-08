package com.peek.camera.tcp;


import android.content.Context;
import android.os.Handler;
import android.os.Message;


public class NettyClientConnectionThread extends Thread {
    private static final String TAG = "ConnectionThread";
    private Context context;
    private Handler handler;
    private int port;
    private String host;

    public NettyClientConnectionThread(Context context,  String host,  int port, Handler handler) {
        this.context = context;
        this.host = host;
        this.port = port;
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();

        try {
            startConnection();
        } catch (Exception e) {
            e.printStackTrace();

            Message message = new Message();
            message.what = 1;
            message.obj = "连接失败";
            handler.sendMessage(message);
        }
    }

    private void startConnection() throws Exception {
        NettyClientBootstrap.Init(port, host, handler);

    }

    public void stopConnection() throws Exception {
        NettyClientBootstrap.getInstance().stop();
    }
}