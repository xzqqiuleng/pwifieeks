package com.peek.camera;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;


import java.util.List;

public class WIFIStateReceiver extends BroadcastReceiver {

    private Context mContext;

    List<ScanResult> scanResults;

    public WIFIStateReceiver(Context context) {
        this.mContext = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!intent.getAction().equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)) {
            return;
        }
        scanResults =  WIFIConnectionManager.getInstance(mContext).getWifiManager().getScanResults();
        for (int i = 0 ; i < scanResults.size();i++) {
            Log.e("fxp","scanResults:----"+(scanResults.get(i)).SSID);
        }

        String ssid = BaseApplication.m4928b().getString("baseMainFrameWifiSSID","");
        String pwd = BaseApplication.m4928b().getString("WIFIPD","");
        if (!WIFIConnectionManager.getInstance(mContext).isConnected(ssid)) {
            WIFIConnectionManager.getInstance(mContext).connect(ssid, pwd);
        } else {
            Log.e("fxp","成功连接到wifi ：" + ssid);
        }
    }

}
