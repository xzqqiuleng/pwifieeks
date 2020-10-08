package com.peek.camera;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;


public class WIFIAutoConnectionService extends Service {

    private static final String KEY_SSID = "KEY_SSID";

    private static final String KEY_PWD = "KEY_PWD";

    /**
     * wifi名
     */
    private String mSsid ="";
    /**
     * 密码
     */
    private String mPwd ="";


    /**
     * 负责不断尝试连接指定wifi
     */
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            WIFIConnectionManager.getInstance(WIFIAutoConnectionService.this).connect(mSsid, mPwd);
            boolean connected =  WIFIConnectionManager.getInstance(WIFIAutoConnectionService.this).isConnected(mSsid);
            Log.d("fxp", "handleMessage: wifi connected = " + connected);
            if (!connected) {
                Log.d("fxp", "handleMessage: re-try in 15 seconds");
                mHandler.sendEmptyMessageDelayed(0, 15000);//15s循环
            }
            return true;
        }
    });

    /**
     * 连接指定wifi热点, 失败后5s循环
     *
     * @param context 用于启动服务的上下文
     * @param ssid    默认HUD-WIFI
     * @param pwd     (WPA加密)默认12345678
     */
    public static void start(Context context, String ssid, String pwd) {
        Intent starter = new Intent(context,WIFIAutoConnectionService.class);
        starter.putExtra(KEY_SSID, ssid).putExtra(KEY_PWD, pwd);
        context.startService(starter);
        Log.d("fxp", "start: ");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * @return always null
     */

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mSsid = intent.getStringExtra(KEY_SSID);
        mPwd = intent.getStringExtra(KEY_PWD);
        mHandler.sendEmptyMessage(0);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("fxp", "onDestroy: ");
    }

}