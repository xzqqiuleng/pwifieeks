package com.peek.camera.p032a.p033a;

import android.content.Context;
import android.content.Intent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;
import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_DEVICEINFO_V30;
import com.peek.camera.R;
import com.peek.camera.model.All_id_Info;
import com.peek.camera.model.Login_info;
import com.peek.camera.p032a.C1098c;
import com.peek.camera.p032a.C1099d;
import com.peek.camera.p034b.C1139m;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1141o;
import com.peek.camera.p034b.C1159z;
import com.peek.camera.view.p039c.C1237b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.MediaPlayer.PlayM4.Player;

/* renamed from: com.bmw.peek2.a.a.d */
public class C1073d implements C1098c {

    /* renamed from: a */
    private final Toast f2972a;

    /* renamed from: b */
    private C1237b f2973b;

    /* renamed from: c */
    private All_id_Info f2974c = All_id_Info.getInstance();

    /* renamed from: d */
    private C1099d f2975d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f2976e;

    /* renamed from: f */
    private Login_info f2977f = Login_info.getInstance();

    /* renamed from: g */
    private ExecutorService f2978g = Executors.newCachedThreadPool();

    /* renamed from: h */
    private C1159z f2979h;
    public  static  boolean hK_State = false;
    public C1073d(final Context context, C1237b bVar, final SurfaceView surfaceView) {
        this.f2973b = bVar;
        this.f2979h = new C1159z(context);
        m5034e();
        this.f2972a = Toast.makeText(context, context.getString(R.string.connectFallCheckWifi), 0);
        this.f2975d = new C1077e(context, bVar, surfaceView, new C1077e.C1080a() {
            /* renamed from: a */
            public void mo4548a() {
                C1073d.this.mo4544a();
                if (surfaceView != null && !surfaceView.isShown() && Player.getInstance().getLastError(All_id_Info.getInstance().getM_iPort()) == 0) {
                    surfaceView.post(new Runnable() {
                        public void run() {
                            hK_State = true;
                            surfaceView.setVisibility(View.VISIBLE);
                            C1141o.m5272a().mo4665b();
                            C1140n.m5266a("justNetConnect after preview false!");
                            Intent intent = new Intent("data.receiver");
                            intent.putExtra("KEY_ERROR_PAUSE_CLOSE", true);
                            context.sendBroadcast(intent);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5030a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m5034e() {
        if (!HCNetSDK.getInstance().NET_DVR_Init()) {
            C1140n.m5269b("海康：HCNetSDK setFilePath is failed!");
            this.f2973b.mo5119q();
            return;
        }
        HCNetSDK.getInstance().NET_DVR_SetLogToFile(3, "/mnt/sdcard/sdklog/", true);
        C1140n.m5266a("海康：HCNetSDK setFilePath is success!");
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m5035f() {
        boolean z;
        while (true) {
            if (All_id_Info.getInstance().getM_iLogID() >= 0 || this.f2976e) {
                break;
            } else if (C1141o.m5272a().mo4663a(Login_info.base_video_ip) == 0) {
                synchronized (this) {
                    if (All_id_Info.getInstance().getM_iLogID() < 0) {
                        if (this.f2979h != null) {
                            if (Login_info.getInstance().isWifi_auto()) {
                                z = this.f2979h != null && this.f2979h.mo4690g().contains(Login_info.getInstance().isWifiIsRepeater() ? Login_info.baseRepeaterWifiSSID : Login_info.baseMainFrameWifiSSID);
                            } else {
                                z = true;
                            }
                            if (z && mo4547d()) {
                                m5030a(100);
                                this.f2975d.mo4551a();
                            }
                        }
                    }
                }
            } else {
                m5030a(3000);
            }
        }
        C1140n.m5266a("预览线程结束");
    }

    /* renamed from: g */
    private int m5036g() {
        NET_DVR_DEVICEINFO_V30 net_dvr_deviceinfo_v30 = new NET_DVR_DEVICEINFO_V30();
        if (net_dvr_deviceinfo_v30 == null) {
            C1140n.m5269b("海康：HKNetDvrDeviceInfoV30对象创建失败!");
            return -1;
        }
        int NET_DVR_Login_V30 = HCNetSDK.getInstance().NET_DVR_Login_V30(this.f2977f.getVideo_ip(), this.f2977f.getVideo_port(), this.f2977f.getVideo_account(), this.f2977f.getVideo_password(), net_dvr_deviceinfo_v30);
        if (NET_DVR_Login_V30 < 0) {
            C1140n.m5269b("海康：登录失败!Err:" + HCNetSDK.getInstance().NET_DVR_GetLastError() + " " + NET_DVR_Login_V30);
            return -1;
        }
        this.f2974c.setM_oNetDvrDeviceInfoV30(net_dvr_deviceinfo_v30);
        if (net_dvr_deviceinfo_v30.byChanNum > 0) {
            this.f2974c.setM_iStartChan(net_dvr_deviceinfo_v30.byStartChan);
            this.f2974c.setM_iChanNum(net_dvr_deviceinfo_v30.byChanNum);
            return NET_DVR_Login_V30;
        } else if (net_dvr_deviceinfo_v30.byIPChanNum <= 0) {
            return NET_DVR_Login_V30;
        } else {
            this.f2974c.setM_iStartChan(net_dvr_deviceinfo_v30.byStartDChan);
            this.f2974c.setM_iChanNum(net_dvr_deviceinfo_v30.byIPChanNum + (net_dvr_deviceinfo_v30.byHighDChanNum * 256));
            return NET_DVR_Login_V30;
        }
    }

    /* renamed from: a */
    public void mo4544a() {
        this.f2978g.execute(new Runnable() {
            public void run() {
                if (All_id_Info.getInstance().getM_iLogID() >= 0) {
                    C1073d.this.mo4545b();
                    boolean unused = C1073d.this.f2976e = true;
                    C1073d.this.m5030a(3000);
                }
                boolean unused2 = C1073d.this.f2976e = false;
                C1073d.this.m5035f();
            }
        });
    }

    /* renamed from: b */
    public void mo4545b() {
        C1139m.m5264a("hcnetsdk logout!");
        this.f2975d.mo4553b();
        if (!HCNetSDK.getInstance().NET_DVR_Logout_V30(this.f2974c.getM_iLogID())) {
            C1140n.m5269b("海康： 退出登录失败!");
            return;
        }
        C1140n.m5266a("海康：退出登录成功!");
        this.f2974c.setM_iLogID(-1);
        this.f2974c.resetData();
    }

    /* renamed from: c */
    public void mo4546c() {
        this.f2979h = null;
        if (this.f2978g != null) {
            this.f2978g.shutdownNow();
        }
        this.f2972a.cancel();
        this.f2976e = true;
        mo4545b();
        HCNetSDK.getInstance().NET_DVR_Cleanup();
        C1140n.m5266a("海康：release");
    }

    /* renamed from: d */
    public boolean mo4547d() {
        int g = m5036g();
        if (g < 0) {
            return false;
        }
        this.f2972a.cancel();
        C1140n.m5266a("海康：登录成功！");
        this.f2974c.setM_iLogID(g);
        if (this.f2973b != null) {
            this.f2973b.mo5120r();
        }
        C1139m.m5264a("hcnetsdk login!");
        return true;
    }
}
