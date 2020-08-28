package com.peek.camera.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;

import com.peek.camera.model.All_id_Info;
import com.peek.camera.model.Login_info;
import com.peek.camera.p034b.C1116aa;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1141o;
import com.peek.camera.p034b.C1159z;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MyIntentService extends IntentService {

    /* renamed from: a */
    private int f3139a;

    /* renamed from: b */
    private boolean f3140b;

    public MyIntentService() {
        super("MyIntentService");
    }

    /* renamed from: a */
    private void m5355a(int i) {
        for (int i2 = 0; i2 < i && !this.f3140b; i2++) {
            m5356a(1000);
        }
    }

    /* renamed from: a */
    private void m5356a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m5357a(Context context) {
        context.stopService(new Intent(context, MyIntentService.class));
    }

    /* renamed from: a */
    public static void m5358a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction("example.bmw.wifiservice.MyIntentService.wifiConnect");
        intent.putExtra("example.bmw.wifiservice.MyIntentService.wifiConnect_params_ssid", str);
        intent.putExtra("example.bmw.wifiservice.MyIntentService.wifiConnect_params_password", str2);
        intent.putExtra("example.bmw.wifiservice.MyIntentService.wifiConnect_params_testIp", str3);
        context.startService(intent);
    }

    /* renamed from: a */
    private void m5359a(C1159z zVar, String str, String str2, String str3) {
        int i;
        if (Login_info.getInstance().isWifi_auto()) {
            zVar.mo4685b();
        }
        int i2 = 0;
        while (!C1116aa.m5198a(zVar, str, str3) && !this.f3140b) {
            All_id_Info.getInstance().setWifiConnectRunning(true);
            C1140n.m5266a("wifi thread running " + this.f3139a);
            if (Login_info.getInstance().isWifi_auto()) {
                zVar.mo4685b();
            }
            if (!zVar.mo4690g().contains(str)) {
                C1140n.m5266a("Disconnect wifi ssid = " + zVar.mo4690g() + " thread:" + this.f3139a);
                zVar.mo4682a(zVar.mo4689f());
                C1141o.m5272a().mo4665b();
            }
            zVar.mo4686c();
            List<ScanResult> d = zVar.mo4687d();
            if (d == null || d.size() <= 0) {
                C1140n.m5269b(" scan wifi list is null!");
                zVar.mo4683a(zVar.mo4680a(str, str2, 3));
                m5355a(6);
            } else {
                Iterator<ScanResult> it = d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().SSID.contains(str)) {
                        C1140n.m5266a("connectWifi: connect ssid :" + str);
                        if (i2 >= 3) {
                            C1140n.m5266a("connectWifi: remove Config: " + str);
                            zVar.mo4684a(str);
                            i = 0;
                        } else {
                            i = i2;
                        }
                        zVar.mo4683a(zVar.mo4680a(str, str2, 3));
                        m5355a(6);
                        i2 = i + 1;
                    }
                }
            }
            m5355a(3);
        }
        All_id_Info.getInstance().setWifiConnectRunning(false);
        if (this.f3140b) {
            C1140n.m5266a("connectWifi: wifiThread is finish!!!" + this.f3139a);
        } else {
            C1140n.m5266a("connectWifi: wifi already connected!!!" + this.f3139a);
        }
    }

    /* renamed from: a */
    private boolean m5360a(C1159z zVar, String str, String str2) {
        return C1116aa.m5198a(zVar, str, str2);
    }

    public void onCreate() {
        super.onCreate();
        this.f3139a = new Random().nextInt();
        C1140n.m5266a("onCreate: " + this.f3139a);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f3140b = true;
        C1140n.m5266a("onDestroy: " + this.f3139a);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null && intent.getAction().equals("example.bmw.wifiservice.MyIntentService.wifiConnect")) {
            String stringExtra = intent.getStringExtra("example.bmw.wifiservice.MyIntentService.wifiConnect_params_ssid");
            String stringExtra2 = intent.getStringExtra("example.bmw.wifiservice.MyIntentService.wifiConnect_params_password");
            String stringExtra3 = intent.getStringExtra("example.bmw.wifiservice.MyIntentService.wifiConnect_params_testIp");
            C1159z zVar = new C1159z(this);
            if (!m5360a(zVar, stringExtra, stringExtra3)) {
                m5359a(zVar, stringExtra, stringExtra2, stringExtra3);
            }
        }
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        C1140n.m5266a("onStart: " + this.f3139a);
    }
}
