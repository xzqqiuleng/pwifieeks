package com.peek.camera.p034b.p035a;

import android.os.Handler;
import android.text.TextUtils;

import com.peek.camera.BaseApplication;
import com.peek.camera.C1057a;
import com.peek.camera.R;
import com.peek.camera.model.OsdHkInfo;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.p036b.C1122b;
import com.peek.camera.p034b.p036b.C1123c;

import java.util.ArrayList;
import java.util.List;
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
        mo4618h();
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

        int v0;
        int v12 = 0x20;
        final double v10 = 0;
        int v9 = 0x40;
        if(!this.f3072n) {

            final ArrayList v3 = new ArrayList();
            int v2 = 0;
            int v1;
            for(v1 = 0; v2 < 6; v1 = v0) {
                OsdHkInfo v4 = new OsdHkInfo();
                switch(v2) {
                    case 0: {
                        v4.setOsdX(v9);
                        v4.setOsdY((v1 + 1) * 0x20);
                        if(BaseApplication.m4928b().getBoolean("KEY_IS_RECORDHEADER_ALWAYS_SHOW", true)) {
                            if(this.m5173i(this.f3070l)) {
                                v0 = v1;
                                ++v2;
                            }
                            else {
                                v4.setsString(this.f3070l);
                                v4.setShowStr(1);
                            }
                        }
                        else if(this.m5173i(this.f3066h)) {
                            v0 = v1;
                            ++v2;
                        }
                        else {
                            v4.setsString(this.f3066h);
                            v4.setShowStr(1);
                        }

                        v0 = v1 + 1;
                        if(v4 == null) {
                            ++v2;
                        }
                    }
                    case 1: {
                        v4.setOsdX(v9);
                        v4.setOsdY((v1 + 1) * 0x20);
                        if(BaseApplication.m4928b().getBoolean("KEY_IS_RECORDHEADER_ALWAYS_SHOW", true)) {
                            if(this.m5173i(this.f3071m)) {
                                v0 = v1;

                            }
                            else {
                                v4.setsString(this.f3071m);
                                v4.setShowStr(1);
                            }
                        }
                        else if(this.m5173i(this.f3067i)) {
                                 v0 = v1;
                            ++v2;
                        }
                        else {
                            v4.setsString(this.f3067i);
                            v4.setShowStr(1);
                        }

                        v0 = v1 + 1;
                        if(v4 == null) {
                            ++v2;
                        }
                    }
                    case 2: {
                        v4.setOsdX(v9);
                        v4.setOsdY((v1 + 1) * 0x20);
                        if(BaseApplication.m4928b().getBoolean("KEY_IS_RECORDHEADER_ALWAYS_SHOW", true)) {
                            if(this.m5173i(this.f3066h)) {
                                v0 = v1;
                                ++v2;
                            }
                            else {
                                v4.setsString(this.f3066h);
                                v4.setShowStr(1);
                            }
                        }
                        else if(this.m5173i(this.f3068j)) {
                            v0 = v1;
                            ++v2;
                        }
                        else {
                            v4.setsString(this.f3068j);
                            v4.setShowStr(1);
                        }

                        v0 = v1 + 1;
                        if(v4 == null) {
                            ++v2;
                        }
                    }
                    case 3: {
                        v4.setOsdX(v9);
                        v4.setOsdY((v1 + 1) * 0x20);
                        if(BaseApplication.m4928b().getBoolean("KEY_IS_RECORDHEADER_ALWAYS_SHOW", true)) {
                            if(this.m5173i(this.f3067i)) {
                                v0 = v1;
                                ++v2;
                            }
                            else {
                                v4.setsString(this.f3067i);
                                v4.setShowStr(1);
                            }
                        }
                        else if(this.m5173i(this.f3069k)) {
                            v0 = v1;
                            ++v2;
                        }
                        else {
                            v4.setsString(this.f3069k);
                            v4.setShowStr(1);
                        }

                        v0 = v1 + 1;
                        if(v4 == null) {
                            ++v2;
                        }
                    }
                    case 4: {
                        if(this.m5173i(this.f3063e)) {
                            v0 = v1;
                            ++v2;
                        }

                        v4.setOsdX(v12);
                        v4.setOsdY(0x200);
                        v4.setsString(this.f3063e);
                        v4.setShowStr(1);
                        v0 = v1;
                        if(v4 == null) {
                            ++v2;
                        }

                        ((List)v3).add(v4);
                        break;
                    }
                    case 5: {
                        if(this.f3062d == null || (TextUtils.isEmpty(this.f3062d))) {
                            this.f3062d = "00.00";
                        }

                        StringBuilder v0_1 = new StringBuilder();
                        if(!this.f3062d.equals("00.00")) {
                            v0_1.append(BaseApplication.m4925a().getString(R.string.capture_quexian_length)).append(this.f3062d).append("M ");
                        }
                        if(this.f3064f > v10 || this.f3065g > v10) {
                            v0_1.append(BaseApplication.m4925a().getString(R.string.capture_quexian_length)).append(this.f3065g).append(",").append(this.f3064f);
                        }

                        String v0_2 = v0_1.toString();
                        if(this.m5173i(v0_2)) {
                            v0 = v1;
                            ++v2;
                        }

                        v4.setsString(v0_2);
                        v4.setOsdX(v12);
                        v0 = 0x220;
//                        if(C1107a.a()) {
//                            v0 = 0x200;
//                        }
                        v0 = 0x200;
                        v4.setOsdY(v0);
                        v4.setShowStr(1);
                        v0 = v1;
                        if(v4 == null) {
                            ++v2;
                        }
                    }
                    default: {

                        v0 = v1;
                        if(v4 == null) {
                            ++v2;
                        }
                    }
                }


                ++v2;
            }

            if(this.f3059a == null) {
                return;
            }

            if(this.f3059a.isShutdown()) {
                return;
            }

            this.f3059a.execute(new C1123c(5) {
                public void run() {
                    super.run();
//                    com.bmw.peek2.b.a.a.a().a(this.a, b.a(this.b), b.b(this.b));

                    C1107a.m5163a().mo4597a(v3,C1110b.this.f3060b, C1110b.this.f3061c);
                }
            });
        }
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
