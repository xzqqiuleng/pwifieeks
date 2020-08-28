package com.peek.camera.p032a.p033a;

import android.content.Context;
import android.content.Intent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_PREVIEWINFO;
import com.hikvision.netsdk.RealPlayCallBack;
import com.hikvision.netsdk.StdDataCallBack;
import com.lidroid.xutils.bitmap.BitmapGlobalConfig;
import com.peek.camera.BaseApplication;
import com.peek.camera.C1057a;
import com.peek.camera.jna.SystemTransformByJNA;
import com.peek.camera.jna.SystemTransformJNAInstance;
import com.peek.camera.model.All_id_Info;
import com.peek.camera.model.Login_info;
import com.peek.camera.p032a.C1099d;
import com.peek.camera.p034b.C1117ab;
import com.peek.camera.p034b.C1129g;
import com.peek.camera.p034b.C1139m;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.view.p039c.C1237b;

import java.io.IOException;
import org.MediaPlayer.PlayM4.Player;

/* renamed from: com.bmw.peek2.a.a.e */
public class C1077e implements C1099d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public SurfaceView f2985a;

    /* renamed from: b */
    private Context f2986b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public All_id_Info f2987c;

    /* renamed from: d */
    private Login_info f2988d = Login_info.getInstance();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f2989e;

    /* renamed from: f */
    private int f2990f;

    /* renamed from: g */
    private boolean f2991g;

    /* renamed from: h */
    private Intent f2992h;

    /* renamed from: i */
    private C1117ab f2993i;

    /* renamed from: j */
    private C1237b f2994j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Player.MPInteger f2995k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Player.MPInteger f2996l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f2997m;

    /* renamed from: n */
    private C1080a f2998n;

    /* renamed from: com.bmw.peek2.a.a.e$a */
    public interface C1080a {
        /* renamed from: a */
        void mo4548a();
    }

    /* renamed from: com.bmw.peek2.a.a.e$b */
    private class C1081b implements SurfaceHolder.Callback {
        private C1081b() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            C1077e.this.f2985a.getHolder().setFormat(-3);
            int m_iPort = C1077e.this.f2987c.getM_iPort();
            C1140n.m5266a("海康：PreviewPresentImpl: surface is created" + m_iPort);
            if (-1 != m_iPort && true == surfaceHolder.getSurface().isValid() && !Player.getInstance().setVideoWindow(m_iPort, 0, surfaceHolder)) {
                C1140n.m5269b("海康：PreviewPresentImpl: Player setVideoWindow failed!" + Player.getInstance().getLastError(m_iPort));
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            int m_iPort = C1077e.this.f2987c.getM_iPort();
            C1140n.m5266a("海康：PreviewPresentImpl: Player setVideoWindow release!" + m_iPort);
            if (-1 != m_iPort && true == surfaceHolder.getSurface().isValid() && !Player.getInstance().setVideoWindow(m_iPort, 0, (SurfaceHolder) null)) {
                C1140n.m5269b("海康：PreviewPresentImpl: Player setVideoWindow failed!");
            }
        }
    }

    public C1077e(Context context, C1237b bVar, SurfaceView surfaceView, C1080a aVar) {
        this.f2986b = context;
        this.f2985a = surfaceView;
        this.f2987c = All_id_Info.getInstance();
        this.f2998n = aVar;
        this.f2994j = bVar;
        this.f2992h = new Intent();
        this.f2992h.setAction("BROCAST_IS_RECORD_HAS_DATA");
    }

    /* renamed from: a */
    private void m5044a(int i, byte[] bArr, int i2) {
        if (!Player.getInstance().inputData(i, bArr, i2) && Player.getInstance().getLastError(i) == 11) {
            int i3 = 0;
            while (i3 < 4000) {
                if (Player.getInstance().resetSourceBuffer(i)) {
                    C1140n.m5266a("海康：清空缓冲区所有剩余数据！");
                }
                if (!Player.getInstance().inputData(i, bArr, i2)) {
                    if (i3 % 100 == 0) {
                        C1140n.m5269b("海康：PreviewPresentImpl: inputData failed with: " + Player.getInstance().getLastError(i) + ", i:" + i3);
                        this.f2990f++;
                        if (this.f2990f > 3 && this.f2998n != null) {
                            this.f2998n.mo4548a();
                            this.f2990f = 0;
                            return;
                        }
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m5045a(byte[] bArr, int i) {
        if (this.f2993i == null) {
            m5054f();
        }
        try {
            this.f2993i.mo4628a(bArr, i);
            this.f2993i.mo4627a(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m5048b(byte[] bArr, int i) {
        SystemTransformJNAInstance.getInstance().SYSTRANS_InputData(SystemTransformByJNA.handle.getValue(), 0, bArr, i);
        m5055g();
    }

    /* renamed from: d */
    private StdDataCallBack m5051d() {
        return new StdDataCallBack() {
            public void fStdDataCallback(int i, int i2, byte[] bArr, int i3) {
                long currentTimeMillis = System.currentTimeMillis() - C1077e.this.f2989e;
                if (currentTimeMillis > 500 && C1077e.this.f2989e != 0) {
                    C1139m.m5264a("hcnetsdk preview out of time = " + currentTimeMillis);
                    C1140n.m5269b("海康时间：" + currentTimeMillis);
                }
                long unused = C1077e.this.f2989e = System.currentTimeMillis();
                C1077e.this.mo4552a(1, i2, bArr, i3, 0);
            }
        };
    }

    /* renamed from: e */
    private void m5053e() {
        this.f2993i.mo4626a();
        this.f2993i = null;
    }

    /* renamed from: f */
    private void m5054f() {
        StringBuilder sb = new StringBuilder();
        sb.append(C1129g.m5220a());
        sb.append(Login_info.local_kanban_path);
        String d = BaseApplication.m4925a().mo4484d();
        int i = 1;
        while (C1129g.m5229a(sb.toString(), d)) {
            d = d + "_" + i;
            i++;
        }
        sb.append(d);
        String sb2 = sb.toString();
        this.f2993i = new C1117ab(sb2, sb2 + "_index");
        m5055g();
    }

    /* renamed from: g */
    private void m5055g() {
        this.f2992h.putExtra("KEY_IS_RECORD_HAS_DATA", 1);
        this.f2986b.sendBroadcast(this.f2992h);
    }

    /* renamed from: h */
    private void m5056h() {
        Player.getInstance().stopSound();
        int m_iPort = this.f2987c.getM_iPort();
        if (!Player.getInstance().stop(m_iPort)) {
            C1140n.m5269b("海康：PreviewPresentImpl: stopSinglePlayer is failed!,error code:" + Player.getInstance().getLastError(m_iPort));
        }
        if (!Player.getInstance().setHardDecode(m_iPort, 0)) {
            C1140n.m5269b("海康：PreviewPresentImpl: stopHardDecode is failed!");
        }
        if (!Player.getInstance().closeStream(m_iPort)) {
            C1140n.m5269b("海康：PreviewPresentImpl: stopSinglePlayer closeStream is failed!");
        }
        if (!Player.getInstance().freePort(m_iPort)) {
            C1140n.m5269b("海康：PreviewPresentImpl: stopSinglePlayer freePort is failed!" + m_iPort);
        }
        this.f2987c.setM_iPort(-1);
    }

    /* renamed from: a */
    public void mo4551a() {
        int m_iLogID = this.f2987c.getM_iLogID();
        if (m_iLogID >= 0) {
            StdDataCallBack d = m5051d();
            if (d == null) {
                C1140n.m5269b("海康：PreviewPresentImpl: fRealDataCallBack object is failed!");
                return;
            }
            NET_DVR_PREVIEWINFO net_dvr_previewinfo = new NET_DVR_PREVIEWINFO();
            net_dvr_previewinfo.lChannel = this.f2987c.getM_iStartChan();
            if (C1057a.m4936a()) {
                net_dvr_previewinfo.dwStreamType = 1;
            } else {
                net_dvr_previewinfo.dwStreamType = 0;
            }
            net_dvr_previewinfo.bBlocked = 1;
            int NET_DVR_RealPlay_V40 = HCNetSDK.getInstance().NET_DVR_RealPlay_V40(m_iLogID, net_dvr_previewinfo, (RealPlayCallBack) null);
            if (NET_DVR_RealPlay_V40 < 0) {
                C1140n.m5269b("海康：PreviewPresentImpl: NET_DVR_RealPlay is failed!Err:" + HCNetSDK.getInstance().NET_DVR_GetLastError());
                this.f2998n.mo4548a();
                return;
            }
            HCNetSDK.getInstance().NET_DVR_SetStandardDataCallBack(NET_DVR_RealPlay_V40, d);
            this.f2987c.setM_iPlayID(NET_DVR_RealPlay_V40);
            C1140n.m5266a("海康：PreviewPresentImpl: NetSdk Play sucess" + NET_DVR_RealPlay_V40);
            if (!this.f2991g) {
                mo4554c();
            }
            C1140n.m5266a("海康：预览完成！");
        }
    }

    /* renamed from: a */
    public void mo4552a(int i, int i2, byte[] bArr, int i3, int i4) {
        int m_iPort = this.f2987c.getM_iPort();
        if (1 == i2) {
            if (m_iPort < 0) {
                int port = Player.getInstance().getPort();
                if (port == -1) {
                    C1140n.m5269b("海康：PreviewPresentImpl: getPort is failed with: " + Player.getInstance().getLastError(port));
                    if (this.f2998n != null) {
                        this.f2998n.mo4548a();
                        return;
                    }
                    return;
                }
                this.f2987c.setM_iPort(port);
                if (i3 > 0) {
                    if (!Player.getInstance().setStreamOpenMode(port, i4)) {
                        C1140n.m5266a("海康：PreviewPresentImpl: setStreamOpenMode failed");
                    }
                    if (!Player.getInstance().openStream(port, bArr, i3, BitmapGlobalConfig.MIN_MEMORY_CACHE_SIZE)) {
                        C1140n.m5269b("海康：PreviewPresentImpl: openStream failed");
                        if (this.f2998n != null) {
                            this.f2998n.mo4548a();
                            return;
                        }
                        return;
                    }
                    if (!Player.getInstance().setDisplayBuf(port, 1)) {
                        C1140n.m5269b("海康：设置播放缓冲区最大缓冲帧数！" + Player.getInstance().getLastError(port));
                    }
                    if (Player.getInstance().resetSourceBuffer(port)) {
                    }
                    if (Login_info.getInstance().isYingJieMa()) {
                        if (Player.getInstance().setMaxHardDecodePort(0)) {
                            C1140n.m5266a("设置最大硬解码路数为0！");
                        }
                        if (Player.getInstance().setHardDecode(port, 1)) {
                            C1140n.m5266a("启用硬解码优先！");
                        }
                    }
                    if (!Player.getInstance().play(port, this.f2985a.getHolder())) {
                        C1140n.m5269b("海康：PreviewPresentImpl: play failed,error code:" + Player.getInstance().getLastError(port));
                        if (this.f2998n != null) {
                            this.f2998n.mo4548a();
                        }
                    } else if (!Player.getInstance().playSound(port)) {
                        C1140n.m5269b("海康：PreviewPresentImpl: playSound failed with ierror code:" + Player.getInstance().getLastError(port));
                    }
                }
            }
        } else if (m_iPort != -1) {
            if (!Login_info.isPause) {
                m5048b(bArr, i3);
            }
            if (Login_info.isAddKanban) {
                m5045a(bArr, i3);
            } else if (this.f2993i != null) {
                m5053e();
            }
            m5044a(m_iPort, bArr, i3);
            this.f2995k = new Player.MPInteger();
            this.f2996l = new Player.MPInteger();
            Player.getInstance().getPictureSize(All_id_Info.getInstance().getM_iPort(), this.f2995k, this.f2996l);
            if (this.f2995k.value == 352 && this.f2996l.value == 288) {
                this.f2997m = true;
            } else if (this.f2985a != null && this.f2997m) {
                synchronized (C1077e.class) {
                    this.f2985a.post(new Runnable() {
                        public void run() {
                            C1140n.m5266a("海康播放:  width = " + C1077e.this.f2995k.value + " height = " + C1077e.this.f2996l.value);
                            ViewGroup.LayoutParams layoutParams = C1077e.this.f2985a.getLayoutParams();
                            float f = ((float) C1077e.this.f2995k.value) / ((float) C1077e.this.f2996l.value);
                            int width = C1077e.this.f2985a.getWidth();
                            int height = C1077e.this.f2985a.getHeight();
                            C1140n.m5266a("current surface:  surfceview size   width = " + width + " height = " + height);
                            int i = (int) (((float) height) * f);
                            int i2 = (int) (((float) width) / f);
                            if (width == 0 || height == 0 || i2 == 0 || i == 0) {
                                C1140n.m5269b("重置SurfaceView参数获取错误！");
                                return;
                            }
                            C1140n.m5266a("重置surface大小:  width = " + C1077e.this.f2995k.value + " height = " + C1077e.this.f2996l.value);
                            C1140n.m5266a("重置surface大小:  surfceview size   width = " + width + " height = " + height);
                            if (i <= width) {
                                layoutParams.width = i;
                                layoutParams.height = height;
                            } else {
                                layoutParams.width = width;
                                layoutParams.height = i2;
                            }
                            C1077e.this.f2985a.setLayoutParams(layoutParams);
                            boolean unused = C1077e.this.f2997m = false;
                        }
                    });
                }
            }
        }
    }

    /* renamed from: b */
    public void mo4553b() {
        int m_iPlayID = this.f2987c.getM_iPlayID();
        if (m_iPlayID < 0) {
            C1140n.m5269b("海康：PreviewPresentImpl: stopSingle:m_iPlayID < 0");
        }
        if (!HCNetSDK.getInstance().NET_DVR_StopRealPlay(m_iPlayID)) {
            C1140n.m5269b("海康：PreviewPresentImpl: StopRealPlay is failed!Err:" + HCNetSDK.getInstance().NET_DVR_GetLastError());
        }
        this.f2987c.setM_iPlayID(-1);
        m5056h();
        C1140n.m5266a("海康：退出预览成功！");
    }

    /* renamed from: c */
    public void mo4554c() {
        this.f2991g = true;
        this.f2985a.getHolder().addCallback(new C1081b());
    }
}
