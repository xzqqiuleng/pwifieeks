package com.peek.camera.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;

import com.peek.camera.BaseApplication;
import com.peek.camera.C1057a;
import com.peek.camera.p034b.C1135l;
import com.peek.camera.p034b.C1140n;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class MyServiceGetGPS extends IntentService {

    /* renamed from: a */
    private int f3141a;

    /* renamed from: b */
    private Intent f3142b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ConnectivityManager f3143c;

    /* renamed from: d */
    private ConnectivityManager.NetworkCallback f3144d;

    public MyServiceGetGPS() {
        super("MyIntentService");
    }

    /* renamed from: a */
    private Criteria m5361a() {
        Criteria criteria = new Criteria();
        criteria.setPowerRequirement(1);
        criteria.setAltitudeRequired(false);
        criteria.setBearingAccuracy(3);
        criteria.setAccuracy(1);
        return criteria;
    }

    /* renamed from: a */
    public static void m5363a(Context context) {
        context.startService(new Intent(context, MyServiceGetGPS.class));
    }

    /* renamed from: a */
    private void m5364a(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        if (longitude <= 0.0d || latitude <= 0.0d) {
            C1140n.m5269b("经纬度：获取值为0！");
            return;
        }
        this.f3142b.putExtra(C1057a.f2927d, latitude);
        this.f3142b.putExtra(C1057a.f2928e, longitude);
        BaseApplication.m4925a().sendBroadcast(this.f3142b);
        this.f3142b.removeExtra(C1057a.f2927d);
        this.f3142b.removeExtra(C1057a.f2928e);
    }

    /* renamed from: b */
    private void m5365b() {
        this.f3142b = new Intent();
        this.f3142b.setAction(C1057a.f2926c);
    }

    /* renamed from: c */
    private void m5366c() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (200 == ((HttpURLConnection) new URL("https://www.baidu.com/".trim()).openConnection()).getResponseCode()) {
                        C1140n.m5266a("网络方式Gps定位测试网络 ************ ok  ********");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    C1140n.m5269b("网络方式Gps定位测试网络不成功：onBind Thread: MyService connectResult  = " + e.toString());
                }
            }
        }).start();
    }

    /* renamed from: d */
    @SuppressLint("WrongConstant")
    private void m5367d() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f3143c = (ConnectivityManager) getSystemService("connectivity");
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addTransportType(0);
            NetworkRequest build = builder.build();
            this.f3144d = new ConnectivityManager.NetworkCallback() {
                @TargetApi(23)
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    Log.i("test", "已根据功能和传输类型找到合适的网络");
                    if (Build.VERSION.SDK_INT >= 23) {
                        ConnectivityManager.setProcessDefaultNetwork(network);
                        MyServiceGetGPS.this.f3143c.bindProcessToNetwork(network);
                        return;
                    }
                    ConnectivityManager.setProcessDefaultNetwork(network);
                }
            };
            this.f3143c.requestNetwork(build, this.f3144d);
        }
    }

    /* renamed from: e */
    private void m5368e() {
        if (Build.VERSION.SDK_INT >= 21 && this.f3143c != null) {
            this.f3143c.unregisterNetworkCallback(this.f3144d);
        }
    }

    public void onCreate() {
        super.onCreate();
        this.f3141a = new Random().nextInt();
        C1140n.m5266a("onCreate: " + this.f3141a);
        m5367d();
        m5366c();
        m5365b();
    }

    public void onDestroy() {
        super.onDestroy();
        m5368e();
        C1140n.m5266a("onDestroy: " + this.f3141a);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        Location a = C1135l.m5259a(this, m5361a());
        if (a == null) {
            a = C1135l.m5258a(this);
        }
        if (a != null) {
            C1140n.m5266a("使用移动网络定位成功！");
            m5364a(a);
            return;
        }
        C1140n.m5266a("使用移动网络定位失败！");
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        C1140n.m5266a("onStart: " + this.f3141a);
    }
}
