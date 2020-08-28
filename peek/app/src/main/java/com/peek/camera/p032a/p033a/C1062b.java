package com.peek.camera.p032a.p033a;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.peek.camera.BaseApplication;
import com.peek.camera.p032a.C1097b;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1149t;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.MediaPlayer.PlayM4.Player;

/* renamed from: com.bmw.peek2.a.a.b */
public class C1062b implements C1097b {

    /* renamed from: a */
    private C1149t f2942a;

    /* renamed from: b */
    private String f2943b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f2944c;

    /* renamed from: d */
    private ScheduledExecutorService f2945d;

    /* renamed from: e */
    private Executor f2946e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f2947f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f2948g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Intent f2949h = new Intent();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Handler f2950i = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                switch (bArr[1]) {
                    case 30:
                        float a = C1062b.this.m4971c(Integer.valueOf(bArr[4] & 255).intValue() | (Integer.valueOf(bArr[3] & 255).intValue() << 8));
                        if (a <= 0.0f) {
                            a = 0.0f;
                        }
                        if (C1062b.this.f2951j == 0.0f) {
                            float unused = C1062b.this.f2951j = a;
                            C1062b.this.m4962a(a);
                            return;
                        } else if (Math.abs(C1062b.this.f2951j - a) <= 5.0f) {
                            float unused2 = C1062b.this.f2951j = a;
                            C1062b.m4977g(C1062b.this);
                            System.out.println("aaaaaaaaa right count  = " + C1062b.this.f2952k);
                            if (C1062b.this.f2952k >= 3) {
                                int unused3 = C1062b.this.f2952k = 0;
                                int unused4 = C1062b.this.f2953l = 0;
                                C1062b.this.m4962a(a);
                                return;
                            }
                            return;
                        } else {
                            C1062b.m4979i(C1062b.this);
                            System.out.println("aaaaaaaaa error count  = " + C1062b.this.f2953l);
                            if (C1062b.this.f2953l >= 4) {
                                int unused5 = C1062b.this.f2953l = 0;
                                float unused6 = C1062b.this.f2951j = a;
                                return;
                            }
                            return;
                        }
                    case 31:
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[]{bArr[6], bArr[5], bArr[4], bArr[3]});
                        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                        try {
                            C1062b.this.f2949h.putExtra("angle", ((float) Math.round(dataInputStream.readFloat() * 10.0f)) / 10.0f);
                            BaseApplication.m4925a().sendBroadcast(C1062b.this.f2949h);
                            C1062b.this.f2949h.removeExtra("angle");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return;
                        }
                        return;
                    case 32:
                        try {
                            C1062b.this.f2949h.putExtra("rangingSize", new String(new byte[]{(byte) (bArr[3] & 255), (byte) (bArr[4] & 255), (byte) (bArr[5] & 255), (byte) (bArr[6] & 255), (byte) (bArr[7] & 255)}, "ascii"));
                            BaseApplication.m4925a().sendBroadcast(C1062b.this.f2949h);
                            C1062b.this.f2949h.removeExtra("rangingSize");
                            return;
                        } catch (UnsupportedEncodingException e3) {
                            e3.printStackTrace();
                            return;
                        }
                    case 35:
                        if (bArr.length == 5 && bArr[1] == 35 && bArr[4] != 0) {
                            C1062b.this.f2949h.putExtra("batteryNum", Integer.valueOf(bArr[3]).intValue());
                            BaseApplication.m4925a().sendBroadcast(C1062b.this.f2949h);
                            C1062b.this.f2949h.removeExtra("batteryNum");
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j */
    public float f2951j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f2952k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f2953l;

    public C1062b() {
        this.f2949h.setAction("data.receiver");
        this.f2945d = Executors.newScheduledThreadPool(3);
        this.f2946e = Executors.newCachedThreadPool();
        this.f2942a = new C1149t();
        this.f2942a.mo4672a((C1149t.C1153a) new C1149t.C1153a() {
            /* renamed from: a */
            public void mo4520a(byte[] bArr) {
                Message message = new Message();
                message.obj = bArr;
                C1062b.this.f2950i.sendMessage(message);
            }
        });
        this.f2944c = true;
        this.f2945d.scheduleAtFixedRate(new Runnable() {
            public void run() {
                C1062b.this.mo4516o();
            }
        }, 0, 1500, TimeUnit.MILLISECONDS);
        this.f2945d.scheduleAtFixedRate(new Runnable() {
            public void run() {
                if (C1062b.this.f2948g) {
                    C1062b.this.mo4519r();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);
        this.f2946e.execute(new Runnable() {
            public void run() {
                while (C1062b.this.f2944c) {
                    if (C1062b.this.f2947f) {
                        C1062b.this.mo4518q();
                    }
                    C1062b.this.m4963a(800);
                }
            }
        });
        this.f2945d.scheduleAtFixedRate(new Runnable() {
            public void run() {
                C1062b.this.mo4517p();
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4962a(float f) {
        this.f2949h.putExtra("environment_qiya", f);
        BaseApplication.m4925a().sendBroadcast(this.f2949h);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4963a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m4965a(String str, int i, int i2, int[] iArr, boolean z) {
        this.f2943b = str;
        int i3 = 0;
        for (int i4 = 0; i4 < i2 - 1; i4++) {
            i3 += iArr[i4];
        }
        byte[] bArr = new byte[(i2 + 3)];
        bArr[0] = 1;
        bArr[1] = (byte) i;
        bArr[2] = (byte) i2;
        bArr[i2 + 2] = (byte) ((((i + 1) + i2) + i3) % 256);
        for (int i5 = 3; i5 < i2 + 2; i5++) {
            bArr[i5] = (byte) iArr[i5 - 3];
        }
        if (z) {
            m4966a(bArr);
        } else {
            m4969b(bArr);
        }
    }

    /* renamed from: a */
    private void m4966a(byte[] bArr) {
        this.f2942a.mo4673a(bArr, 1, this.f2943b, 0);
    }

    /* renamed from: b */
    private void m4969b(byte[] bArr) {
        this.f2942a.mo4673a(bArr, 5, "接收" + this.f2943b, 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public float m4971c(int i) {
        return ((float) Math.round(((float) (((((double) (((float) ((32768 & i) != 0 ? 0 - (i & Player.VOLUME_DEFAULT) : i & Player.VOLUME_DEFAULT)) * 10.0f)) - 101325.0d) * 0.1450376957654953d) / 1000.0d)) * 100.0f)) / 100.0f;
    }

    /* renamed from: g */
    static /* synthetic */ int m4977g(C1062b bVar) {
        int i = bVar.f2952k;
        bVar.f2952k = i + 1;
        return i;
    }

    /* renamed from: i */
    static /* synthetic */ int m4979i(C1062b bVar) {
        int i = bVar.f2953l;
        bVar.f2953l = i + 1;
        return i;
    }

    /* renamed from: a */
    public void mo4497a() {
        m4965a("上命令", 16, 2, new int[]{0, 19}, true);
    }

    /* renamed from: a */
    public void mo4498a(int i) {
        m4965a("近光灯开", 25, 2, new int[]{i}, true);
    }

    /* renamed from: a */
    public void mo4499a(Boolean bool) {
        this.f2947f = bool.booleanValue();
        this.f2949h.putExtra("rangingSize", "00.00");
        BaseApplication.m4925a().sendBroadcast(this.f2949h);
        this.f2949h.removeExtra("rangingSize");
    }

    /* renamed from: a */
    public void mo4500a(boolean z) {
    }

    /* renamed from: b */
    public void mo4501b() {
        m4965a("下命令", 17, 2, new int[]{0, 20}, true);
    }

    /* renamed from: b */
    public void mo4502b(int i) {
        m4965a("远光灯开", 27, 2, new int[]{i}, true);
    }

    /* renamed from: b */
    public void mo4503b(boolean z) {
        this.f2948g = z;
    }

    /* renamed from: c */
    public void mo4504c() {
        m4965a("变倍变长", 20, 2, new int[]{0, 23}, true);
    }

    /* renamed from: d */
    public void mo4505d() {
        m4965a("变倍变短", 21, 2, new int[]{0, 24}, true);
    }

    /* renamed from: e */
    public void mo4506e() {
        m4965a("聚焦近", 23, 2, new int[]{0, 26}, true);
    }

    /* renamed from: f */
    public void mo4507f() {
        m4965a("聚焦远", 22, 2, new int[]{0, 25}, true);
    }

    /* renamed from: g */
    public void mo4508g() {
        m4965a("停止命令", 28, 2, new int[]{0, 31}, true);
    }

    /* renamed from: h */
    public void mo4509h() {
        m4965a("近光灯关", 24, 2, new int[]{0}, true);
    }

    /* renamed from: i */
    public void mo4510i() {
        m4965a("远光灯关", 26, 2, new int[]{0}, true);
    }

    /* renamed from: j */
    public void mo4511j() {
        m4965a("开启除雾", 37, 2, new int[]{1}, true);
    }

    /* renamed from: k */
    public void mo4512k() {
        m4965a("关闭除雾", 37, 2, new int[]{0}, true);
    }

    /* renamed from: l */
    public void mo4513l() {
        this.f2942a.mo4676c();
        this.f2945d.shutdownNow();
        this.f2945d = null;
        C1140n.m5266a("release: ControlPresentImpl");
    }

    /* renamed from: m */
    public void mo4514m() {
        m4965a("自动水平", 33, 2, new int[]{0}, true);
    }

    /* renamed from: n */
    public void mo4515n() {
        this.f2942a.mo4675b();
    }

    /* renamed from: o */
    public void mo4516o() {
        m4965a("获取俯仰角", 31, 2, new int[]{0}, false);
    }

    /* renamed from: p */
    public void mo4517p() {
        m4965a("获取电量", 35, 2, new int[]{0}, false);
    }

    /* renamed from: q */
    public void mo4518q() {
        m4965a("激光测距", 32, 2, new int[]{0}, false);
    }

    /* renamed from: r */
    public void mo4519r() {
        m4965a("获取环境数据", 30, 2, new int[]{0}, false);
    }
}
