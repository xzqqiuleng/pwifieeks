package com.peek.camera.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;

import com.google.gson.Gson;
import com.peek.camera.C1057a;
import com.peek.camera.model.TianAddrInfo;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1145r;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;

public class MyServiceGetPlaceName extends IntentService {

    /* renamed from: a */
    private int f3147a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ConnectivityManager f3148b;

    /* renamed from: c */
    private ConnectivityManager.NetworkCallback f3149c;

    /* renamed from: d */
    private String f3150d = "http://www.tianditu.com/query.shtml";

    /* renamed from: e */
    private String f3151e = "{'lon':%s,'lat':%s,'appkey':8a7b9aac0db21f9dd995e61a14685f05,'ver':1}";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f3152f = -1;

    /* renamed from: g */
    private HashMap<String, String> f3153g;

    /* renamed from: h */
    private Intent f3154h;

    public MyServiceGetPlaceName() {
        super("MyIntentService");
    }

    /* renamed from: a */
    private void m5371a() {
        this.f3154h = new Intent();
        this.f3154h.setAction("data.receiver");
    }

    /* renamed from: a */
    public static void m5372a(Context context, double d, double d2) {
        Intent intent = new Intent(context, MyServiceGetPlaceName.class);
        intent.setAction("com.bmw.peek2.service.MyServiceGetPlaceName.ACTION.GETPLACENAME");
        intent.putExtra("com.bmw.peek2.service.MyServiceGetPlaceName.LATITUDE", d);
        intent.putExtra("com.bmw.peek2.service.MyServiceGetPlaceName.LONTITUDE", d2);
        context.startService(intent);
    }

    /* renamed from: a */
    private void m5373a(TianAddrInfo tianAddrInfo) {
        TianAddrInfo.ResultBean.AddressComponentBean addressComponent = tianAddrInfo.getResult().getAddressComponent();
        m5374a(addressComponent.getRoad() + "," + addressComponent.getPoi() + addressComponent.getPoi_position() + addressComponent.getPoi_distance() + "米");
    }

    /* renamed from: a */
    private void m5374a(String str) {
        this.f3154h.putExtra(C1057a.f2924a, str);
        sendBroadcast(this.f3154h);
        this.f3154h.removeExtra(C1057a.f2924a);
    }

    /* renamed from: b */
    private void m5375b() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (200 == ((HttpURLConnection) new URL("https://www.baidu.com/".trim()).openConnection()).getResponseCode()) {
                        C1140n.m5266a("天地图获取位置测试网络 ************ ok  ********");
                        int unused = MyServiceGetPlaceName.this.f3152f = 0;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    int unused2 = MyServiceGetPlaceName.this.f3152f = 1;
                    C1140n.m5269b("天地图获取位置测试网络不成功：onBind Thread: MyService connectResult  = " + e.toString());
                }
            }
        }).start();
    }

    /* renamed from: c */
    @SuppressLint("WrongConstant")
    private void m5376c() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f3148b = (ConnectivityManager) getSystemService("connectivity");
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addTransportType(0);
            NetworkRequest build = builder.build();
            this.f3149c = new ConnectivityManager.NetworkCallback() {
                @TargetApi(23)
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    Log.i("test", "已根据功能和传输类型找到合适的网络");
                    if (Build.VERSION.SDK_INT >= 23) {
                        ConnectivityManager.setProcessDefaultNetwork(network);
                        MyServiceGetPlaceName.this.f3148b.bindProcessToNetwork(network);
                        return;
                    }
                    ConnectivityManager.setProcessDefaultNetwork(network);
                }
            };
            this.f3148b.requestNetwork(build, this.f3149c);
        }
    }

    /* renamed from: d */
    private void m5377d() {
        if (Build.VERSION.SDK_INT >= 21 && this.f3148b != null) {
            this.f3148b.unregisterNetworkCallback(this.f3149c);
        }
    }

    public void onCreate() {
        super.onCreate();
        m5371a();
        this.f3147a = new Random().nextInt();
        C1140n.m5266a("onCreate: " + this.f3147a);
        m5376c();
        m5375b();
    }

    public void onDestroy() {
        super.onDestroy();
        m5377d();
        C1140n.m5266a("onDestroy: " + this.f3147a);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        while (this.f3152f == -1) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.f3152f != -1) {
                break;
            }
        }
        if (intent.getAction().equals("com.bmw.peek2.service.MyServiceGetPlaceName.ACTION.GETPLACENAME")) {
            double doubleExtra = intent.getDoubleExtra("com.bmw.peek2.service.MyServiceGetPlaceName.LATITUDE", -1.0d);
            double doubleExtra2 = intent.getDoubleExtra("com.bmw.peek2.service.MyServiceGetPlaceName.LONTITUDE", -1.0d);
            if (doubleExtra == -1.0d || doubleExtra2 == -1.0d) {
                C1140n.m5269b("天地图，经纬度有误：" + doubleExtra + " " + doubleExtra2);
                return;
            }
            if (this.f3153g == null) {
                this.f3153g = new HashMap<>();
                this.f3153g.put("type", "geocode");
            }
            this.f3151e = String.format(this.f3151e, new Object[]{String.valueOf(doubleExtra2), String.valueOf(doubleExtra)});
            this.f3153g.put("postStr", this.f3151e);
            try {
                TianAddrInfo tianAddrInfo = (TianAddrInfo) new Gson().fromJson(C1145r.m5287a().mo4670a(this.f3150d, this.f3153g), TianAddrInfo.class);
                if (tianAddrInfo.getStatus().equals("0")) {
                    m5373a(tianAddrInfo);
                } else {
                    C1140n.m5269b("天地图获取地址失败！");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                C1140n.m5269b("天地图http请求异常！error: " + e2.toString());
            }
        }
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        C1140n.m5266a("onStart: " + this.f3147a);
    }
}
