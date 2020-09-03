package com.peek.camera.p034b;

import android.content.Intent;

import com.peek.camera.BaseApplication;
import com.peek.camera.model.Login_info;

import java.io.IOException;

/* renamed from: com.bmw.peek2.b.o */
public class C1141o {

    /* renamed from: a */
    private static C1141o f3101a;

    /* renamed from: b */
    private boolean f3102b;

    /* renamed from: c */
    private boolean f3103c;

    /* renamed from: d */
    private Intent f3104d = new Intent("data.receiver");

    /* renamed from: e */
    private C1159z f3105e = new C1159z(BaseApplication.m4925a());

    private C1141o() {
    }

    /* renamed from: a */
    public static C1141o m5272a() {
        if (f3101a == null) {
            synchronized (C1141o.class) {
                f3101a = new C1141o();
            }
        }
        return f3101a;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m5276e() {
        this.f3104d.putExtra("KEY_WIFI_STATE_JUST_FINISH_PREVIEW", true);
        BaseApplication.m4925a().sendBroadcast(this.f3104d);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m5277f() {
//        if (Login_info.getInstance().isWifi_auto()) {
//            String str = Login_info.getInstance().isWifiIsRepeater() ? Login_info.baseRepeaterWifiSSID : Login_info.baseMainFrameWifiSSID;
//            if (this.f3105e != null && !this.f3105e.mo4690g().contains(str)) {
//                this.f3102b = false;
//                return;
//            }
//        }
        int a = mo4663a(Login_info.getInstance().getVideo_ip());
        synchronized (C1141o.class) {
            this.f3102b = a == 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m5278g() {
        if (Login_info.getInstance().isWifi_auto()) {
            String str = Login_info.getInstance().isWifiIsRepeater() ? Login_info.baseRepeaterWifiSSID : Login_info.baseMainFrameWifiSSID;
            if (this.f3105e != null && !this.f3105e.mo4690g().contains(str)) {
                this.f3103c = false;
                return;
            }
        }
        int a = mo4663a(Login_info.getInstance().getSocket_ip());
        synchronized (C1141o.class) {
            this.f3103c = a == 0;
        }
    }

    /* renamed from: a */
    public int mo4663a(String str) {
        try {
            return Runtime.getRuntime().exec(new StringBuilder().append("ping -c 1 -w 3 ").append(str).toString()).waitFor() == 0 ? 0 : 1;
        } catch (IOException | InterruptedException e) {
            return -1;
        }
    }

    /* renamed from: a */
    public void mo4664a(boolean z) {
        this.f3102b = z;
    }

    /* renamed from: b */
    public void mo4665b() {
        new Thread(new Runnable() {
            public void run() {
                C1140n.m5266a("ping主机！！！");
                C1141o.this.m5277f();
                C1141o.this.m5278g();
                C1141o.this.m5276e();
            }
        }).start();
    }

    /* renamed from: b */
    public void mo4666b(boolean z) {
        this.f3103c = z;
    }

    /* renamed from: c */
    public boolean mo4667c() {
        return this.f3102b;
    }

    /* renamed from: d */
    public boolean mo4668d() {
        return this.f3103c;
    }
}
