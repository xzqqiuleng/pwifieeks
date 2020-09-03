package com.peek.camera.p034b.p035a;

import android.os.Handler;
import android.text.TextUtils;

import com.peek.camera.C1057a;
import com.peek.camera.model.OsdHkInfo;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.p036b.C1122b;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bmw.peek2.b.a.b */
public class C1110b {

    /* renamed from: a */
    private ExecutorService f3059a = new C1122b(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue()));
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f3060b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f3061c;

    /* renamed from: d */
    private String f3062d;

    /* renamed from: e */
    private String f3063e;

    /* renamed from: f */
    private double f3064f;

    /* renamed from: g */
    private double f3065g;

    /* renamed from: h */
    private String f3066h;

    /* renamed from: i */
    private String f3067i;

    /* renamed from: j */
    private String f3068j;

    /* renamed from: k */
    private String f3069k;

    /* renamed from: l */
    private String f3070l;

    /* renamed from: m */
    private String f3071m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f3072n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Runnable f3073o = new Runnable() {
        public void run() {
            C1140n.m5266a("mSetHeadShow_StopRunnable");
            new Thread(new Runnable() {
                public void run() {
                    C1110b.this.mo4600a();
                    boolean unused = C1110b.this.f3072n = false;
//                    C1110b.this.mo4618h();
                }
            }).start();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Handler f3074p;

    public C1110b(int i, int i2, Handler handler) {
        this.f3060b = i;
        this.f3061c = i2;
        this.f3074p = handler;
//        mo4618h();
        new Thread(new Runnable() {
            public void run() {
                C1110b.this.mo4600a();
            }
        }).start();
        if (this.f3059a == null || this.f3059a.isShutdown()) {
            this.f3059a = new C1122b(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue()));
        }
    }

    /* renamed from: i */
    private boolean m5173i(String str) {
        return TextUtils.isEmpty(str) || str.equals("");
    }

    /* renamed from: a */
    public void mo4600a() {
        if (C1057a.m4936a()) {
            C1107a.m5163a().mo4596a((OsdHkInfo) null, new OsdHkInfo("", 1, 0, 0, 544), this.f3060b, this.f3061c);
        } else {
            C1107a.m5163a().mo4596a((OsdHkInfo) null, new OsdHkInfo("", 1, 1, 512, 544), this.f3060b, this.f3061c);
        }
    }

    /* renamed from: a */
    public void mo4601a(double d) {
        this.f3064f = d;
    }

    /* renamed from: a */
    public void mo4602a(int i, int i2) {
        this.f3060b = i;
        this.f3061c = i2;
    }

    /* renamed from: a */
    public void mo4603a(String str) {
        this.f3062d = str;
    }

    /* renamed from: a */
    public void mo4604a(String[] strArr) {
        int i = 6;
        if (strArr != null && strArr.length != 0) {
            if (strArr.length <= 6) {
                i = strArr.length;
            }
            final ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                if (!TextUtils.isEmpty(strArr[i2]) && !strArr[i2].equals("")) {
                    arrayList.add(new OsdHkInfo(strArr[i2], 1, 32, ((i2 * 1) + 1) * 32));
                }
            }
            this.f3072n = true;
            new Thread(new Runnable() {
                public void run() {
                    C1107a.m5163a().mo4596a((OsdHkInfo) null, (OsdHkInfo) null, C1110b.this.f3060b, C1110b.this.f3061c);
//                    C1107a.m5163a().mo4597a(arrayList, C1110b.this.f3060b, C1110b.this.f3061c);
                    C1110b.this.f3074p.removeCallbacks(C1110b.this.f3073o);
                    C1140n.m5266a("start wait hide head!!!");
                    C1110b.this.f3074p.postDelayed(C1110b.this.f3073o, 9000);
                }
            }).start();
        }
    }

    /* renamed from: b */
    public String mo4605b() {
        return this.f3063e;
    }

    /* renamed from: b */
    public void mo4606b(double d) {
        this.f3065g = d;
    }

    /* renamed from: b */
    public void mo4607b(String str) {
        this.f3063e = str;
    }

    /* renamed from: c */
    public String mo4608c() {
        return this.f3066h;
    }

    /* renamed from: c */
    public void mo4609c(String str) {
        this.f3066h = str;
    }

    /* renamed from: d */
    public String mo4610d() {
        return this.f3067i;
    }

    /* renamed from: d */
    public void mo4611d(String str) {
        this.f3067i = str;
    }

    /* renamed from: e */
    public String mo4612e() {
        return this.f3068j;
    }

    /* renamed from: e */
    public void mo4613e(String str) {
        this.f3068j = str;
    }

    /* renamed from: f */
    public String mo4614f() {
        return this.f3069k;
    }

    /* renamed from: f */
    public void mo4615f(String str) {
        this.f3069k = str;
    }

    /* renamed from: g */
    public void mo4616g() {
        this.f3074p.removeCallbacks(this.f3073o);
        this.f3070l = null;
        this.f3071m = null;
        this.f3074p.postDelayed(this.f3073o, 0);
    }

    /* renamed from: g */
    public void mo4617g(String str) {
        this.f3070l = str;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4618h() {
        /*
            r13 = this;
            r12 = 32
            r0 = 0
            r10 = 0
            r9 = 64
            r8 = 1
            boolean r1 = r13.f3072n
            if (r1 == 0) goto L_0x000d
        L_0x000c:
            return
        L_0x000d:
            java.lang.String r1 = "showNormalTitle!"
            com.bmw.peek2.p034b.C1140n.m5266a(r1)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2 = r0
            r1 = r0
        L_0x0019:
            r0 = 6
            if (r2 >= r0) goto L_0x01e1
            com.bmw.peek2.model.OsdHkInfo r4 = new com.bmw.peek2.model.OsdHkInfo
            r4.<init>()
            switch(r2) {
                case 0: goto L_0x002f;
                case 1: goto L_0x0070;
                case 2: goto L_0x00b1;
                case 3: goto L_0x00f5;
                case 4: goto L_0x0139;
                case 5: goto L_0x0157;
                default: goto L_0x0024;
            }
        L_0x0024:
            r0 = r1
        L_0x0025:
            if (r4 == 0) goto L_0x002a
            r3.add(r4)
        L_0x002a:
            int r1 = r2 + 1
            r2 = r1
            r1 = r0
            goto L_0x0019
        L_0x002f:
            r4.setOsdX(r9)
            int r0 = r1 * 1
            int r0 = r0 + 1
            int r0 = r0 * 32
            r4.setOsdY(r0)
            android.content.SharedPreferences r0 = com.bmw.peek2.BaseApplication.m4928b()
            java.lang.String r5 = "KEY_IS_RECORDHEADER_ALWAYS_SHOW"
            boolean r0 = r0.getBoolean(r5, r8)
            if (r0 == 0) goto L_0x005d
            java.lang.String r0 = r13.f3070l
            boolean r0 = r13.m5173i(r0)
            if (r0 == 0) goto L_0x0051
            r0 = r1
            goto L_0x002a
        L_0x0051:
            java.lang.String r0 = r13.f3070l
            r4.setsString(r0)
            r4.setShowStr(r8)
        L_0x0059:
            int r1 = r1 + 1
            r0 = r1
            goto L_0x0025
        L_0x005d:
            java.lang.String r0 = r13.f3066h
            boolean r0 = r13.m5173i(r0)
            if (r0 == 0) goto L_0x0067
            r0 = r1
            goto L_0x002a
        L_0x0067:
            java.lang.String r0 = r13.f3066h
            r4.setsString(r0)
            r4.setShowStr(r8)
            goto L_0x0059
        L_0x0070:
            r4.setOsdX(r9)
            int r0 = r1 * 1
            int r0 = r0 + 1
            int r0 = r0 * 32
            r4.setOsdY(r0)
            android.content.SharedPreferences r0 = com.bmw.peek2.BaseApplication.m4928b()
            java.lang.String r5 = "KEY_IS_RECORDHEADER_ALWAYS_SHOW"
            boolean r0 = r0.getBoolean(r5, r8)
            if (r0 == 0) goto L_0x009e
            java.lang.String r0 = r13.f3071m
            boolean r0 = r13.m5173i(r0)
            if (r0 == 0) goto L_0x0092
            r0 = r1
            goto L_0x002a
        L_0x0092:
            java.lang.String r0 = r13.f3071m
            r4.setsString(r0)
            r4.setShowStr(r8)
        L_0x009a:
            int r1 = r1 + 1
            r0 = r1
            goto L_0x0025
        L_0x009e:
            java.lang.String r0 = r13.f3067i
            boolean r0 = r13.m5173i(r0)
            if (r0 == 0) goto L_0x00a8
            r0 = r1
            goto L_0x002a
        L_0x00a8:
            java.lang.String r0 = r13.f3067i
            r4.setsString(r0)
            r4.setShowStr(r8)
            goto L_0x009a
        L_0x00b1:
            r4.setOsdX(r9)
            int r0 = r1 * 1
            int r0 = r0 + 1
            int r0 = r0 * 32
            r4.setOsdY(r0)
            android.content.SharedPreferences r0 = com.bmw.peek2.BaseApplication.m4928b()
            java.lang.String r5 = "KEY_IS_RECORDHEADER_ALWAYS_SHOW"
            boolean r0 = r0.getBoolean(r5, r8)
            if (r0 == 0) goto L_0x00e1
            java.lang.String r0 = r13.f3066h
            boolean r0 = r13.m5173i(r0)
            if (r0 == 0) goto L_0x00d4
            r0 = r1
            goto L_0x002a
        L_0x00d4:
            java.lang.String r0 = r13.f3066h
            r4.setsString(r0)
            r4.setShowStr(r8)
        L_0x00dc:
            int r1 = r1 + 1
            r0 = r1
            goto L_0x0025
        L_0x00e1:
            java.lang.String r0 = r13.f3068j
            boolean r0 = r13.m5173i(r0)
            if (r0 == 0) goto L_0x00ec
            r0 = r1
            goto L_0x002a
        L_0x00ec:
            java.lang.String r0 = r13.f3068j
            r4.setsString(r0)
            r4.setShowStr(r8)
            goto L_0x00dc
        L_0x00f5:
            r4.setOsdX(r9)
            int r0 = r1 * 1
            int r0 = r0 + 1
            int r0 = r0 * 32
            r4.setOsdY(r0)
            android.content.SharedPreferences r0 = com.bmw.peek2.BaseApplication.m4928b()
            java.lang.String r5 = "KEY_IS_RECORDHEADER_ALWAYS_SHOW"
            boolean r0 = r0.getBoolean(r5, r8)
            if (r0 == 0) goto L_0x0125
            java.lang.String r0 = r13.f3067i
            boolean r0 = r13.m5173i(r0)
            if (r0 == 0) goto L_0x0118
            r0 = r1
            goto L_0x002a
        L_0x0118:
            java.lang.String r0 = r13.f3067i
            r4.setsString(r0)
            r4.setShowStr(r8)
        L_0x0120:
            int r1 = r1 + 1
            r0 = r1
            goto L_0x0025
        L_0x0125:
            java.lang.String r0 = r13.f3069k
            boolean r0 = r13.m5173i(r0)
            if (r0 == 0) goto L_0x0130
            r0 = r1
            goto L_0x002a
        L_0x0130:
            java.lang.String r0 = r13.f3069k
            r4.setsString(r0)
            r4.setShowStr(r8)
            goto L_0x0120
        L_0x0139:
            java.lang.String r0 = r13.f3063e
            boolean r0 = r13.m5173i(r0)
            if (r0 == 0) goto L_0x0144
            r0 = r1
            goto L_0x002a
        L_0x0144:
            r4.setOsdX(r12)
            r0 = 512(0x200, float:7.175E-43)
            r4.setOsdY(r0)
            java.lang.String r0 = r13.f3063e
            r4.setsString(r0)
            r4.setShowStr(r8)
            r0 = r1
            goto L_0x0025
        L_0x0157:
            java.lang.String r0 = r13.f3062d
            if (r0 == 0) goto L_0x0163
            java.lang.String r0 = r13.f3062d
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0167
        L_0x0163:
            java.lang.String r0 = "00.00"
            r13.f3062d = r0
        L_0x0167:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = r13.f3062d
            java.lang.String r6 = "00.00"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0190
            com.bmw.peek2.BaseApplication r5 = com.bmw.peek2.BaseApplication.m4925a()
            r6 = 2131493006(0x7f0c008e, float:1.860948E38)
            java.lang.String r5 = r5.getString(r6)
            java.lang.StringBuilder r5 = r0.append(r5)
            java.lang.String r6 = r13.f3062d
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = "M "
            r5.append(r6)
        L_0x0190:
            double r6 = r13.f3064f
            int r5 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r5 > 0) goto L_0x019c
            double r6 = r13.f3065g
            int r5 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x01bc
        L_0x019c:
            com.bmw.peek2.BaseApplication r5 = com.bmw.peek2.BaseApplication.m4925a()
            r6 = 2131493068(0x7f0c00cc, float:1.8609606E38)
            java.lang.String r5 = r5.getString(r6)
            java.lang.StringBuilder r5 = r0.append(r5)
            double r6 = r13.f3065g
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = ","
            java.lang.StringBuilder r5 = r5.append(r6)
            double r6 = r13.f3064f
            r5.append(r6)
        L_0x01bc:
            java.lang.String r0 = r0.toString()
            boolean r5 = r13.m5173i(r0)
            if (r5 == 0) goto L_0x01c9
            r0 = r1
            goto L_0x002a
        L_0x01c9:
            r4.setsString(r0)
            r4.setOsdX(r12)
            r0 = 544(0x220, float:7.62E-43)
            boolean r5 = com.bmw.peek2.C1057a.m4936a()
            if (r5 == 0) goto L_0x01d9
            r0 = 512(0x200, float:7.175E-43)
        L_0x01d9:
            r4.setOsdY(r0)
            r4.setShowStr(r8)
            goto L_0x0024
        L_0x01e1:
            java.util.concurrent.ExecutorService r0 = r13.f3059a
            if (r0 == 0) goto L_0x000c
            java.util.concurrent.ExecutorService r0 = r13.f3059a
            boolean r0 = r0.isShutdown()
            if (r0 != 0) goto L_0x000c
            java.util.concurrent.ExecutorService r0 = r13.f3059a
            com.bmw.peek2.b.a.b$4 r1 = new com.bmw.peek2.b.a.b$4
            r2 = 5
            r1.<init>(r2, r3)
            r0.execute(r1)
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bmw.peek2.p034b.p035a.C1110b.mo4618h():void");
    }

    /* renamed from: h */
    public void mo4619h(String str) {
        this.f3071m = str;
    }

    /* renamed from: i */
    public void mo4620i() {
        this.f3059a.shutdownNow();
        this.f3059a = null;
    }
}
