package com.peek.camera.p032a.p033a;

import android.content.Context;

import com.peek.camera.model.UpdateInfo;
import com.peek.camera.model.impl.UpdateInfoImpl;
import com.peek.camera.model.model.UpdateMode;
import com.peek.camera.p032a.C1100e;
import com.peek.camera.p032a.C1101f;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.view.p039c.C1238c;



/* renamed from: com.bmw.peek2.a.a.f */
public class C1082f implements C1100e, C1101f {

    /* renamed from: a */
    private UpdateMode f3002a = new UpdateInfoImpl();

    /* renamed from: b */
    private String f3003b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1238c f3004c;

    /* renamed from: d */
    private Context f3005d;

    /* renamed from: e */
    private String f3006e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f3007f;

    public C1082f(C1238c cVar, Context context, String str) {
        this.f3004c = cVar;
        this.f3005d = context;
        this.f3003b = str;
        C1140n.m5266a("正在检查更新！");
        mo4564d();
    }

    /* renamed from: b */
    private boolean m5065b(UpdateInfo updateInfo) {
        return !updateInfo.getVersion().equals(this.f3003b);
    }

    /* renamed from: a */
    public void mo4560a() {
        this.f3004c.mo5123a();
    }

    /* renamed from: a */
    public void mo4561a(UpdateInfo updateInfo) {
        this.f3004c.mo5125a(updateInfo);
        if (updateInfo == null) {
            return;
        }
        if (m5065b(updateInfo)) {
            this.f3006e = updateInfo.getUrl();
            this.f3007f = updateInfo.getApkName();
            return;
        }
        C1140n.m5266a("已经是最新版本！");
    }

    /* renamed from: b */
    public void mo4562b() {
        this.f3004c.mo5127b();
    }

    /* renamed from: c */
    public void mo4563c() {
//        new OkHttpClient().newCall(new Request.Builder().url(this.f3006e).build()).enqueue(new Callback() {
//            public void onFailure(Call call, IOException iOException) {
//                C1140n.m5268a("h_bl", "onFailure");
//            }
//
//            /* JADX WARNING: Removed duplicated region for block: B:22:0x00c7 A[SYNTHETIC, Splitter:B:22:0x00c7] */
//            /* JADX WARNING: Removed duplicated region for block: B:25:0x00cc A[SYNTHETIC, Splitter:B:25:0x00cc] */
//            /* JADX WARNING: Removed duplicated region for block: B:39:0x00fb A[SYNTHETIC, Splitter:B:39:0x00fb] */
//            /* JADX WARNING: Removed duplicated region for block: B:42:0x0100 A[SYNTHETIC, Splitter:B:42:0x0100] */
//            /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
//            /* Code decompiled incorrectly, please refer to instructions dump. */
//            public void onResponse(okhttp3.Call r14, okhttp3.Response r15) {
//                /*
//                    r13 = this;
//                    r0 = 0
//                    r1 = 2048(0x800, float:2.87E-42)
//                    byte[] r3 = new byte[r1]
//                    java.lang.String r1 = com.bmw.peek2.p034b.C1129g.m5220a()
//                    okhttp3.ResponseBody r2 = r15.body()     // Catch:{ Exception -> 0x011b, all -> 0x00f4 }
//                    java.io.InputStream r2 = r2.byteStream()     // Catch:{ Exception -> 0x011b, all -> 0x00f4 }
//                    okhttp3.ResponseBody r4 = r15.body()     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    long r6 = r4.contentLength()     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.String r4 = "h_bl"
//                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    r5.<init>()     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.String r8 = "total= "
//                    java.lang.StringBuilder r5 = r5.append(r8)     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    com.bmw.peek2.p034b.C1140n.m5268a((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    com.bmw.peek2.a.a.f r4 = com.bmw.peek2.p032a.p033a.C1082f.this     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.String r4 = r4.f3007f     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    boolean r4 = com.bmw.peek2.p034b.C1155v.m5330a(r4)     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    if (r4 == 0) goto L_0x0044
//                    com.bmw.peek2.a.a.f r4 = com.bmw.peek2.p032a.p033a.C1082f.this     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.String r5 = "peek2s"
//                    java.lang.String unused = r4.f3007f = r5     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                L_0x0044:
//                    com.bmw.peek2.a.a.f r4 = com.bmw.peek2.p032a.p033a.C1082f.this     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.String r4 = r4.f3007f     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.String r5 = ".apk"
//                    boolean r4 = r4.endsWith(r5)     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    if (r4 != 0) goto L_0x0070
//                    com.bmw.peek2.a.a.f r4 = com.bmw.peek2.p032a.p033a.C1082f.this     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    r5.<init>()     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    com.bmw.peek2.a.a.f r8 = com.bmw.peek2.p032a.p033a.C1082f.this     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.String r8 = r8.f3007f     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.StringBuilder r5 = r5.append(r8)     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.String r8 = ".apk"
//                    java.lang.StringBuilder r5 = r5.append(r8)     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.String unused = r4.f3007f = r5     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                L_0x0070:
//                    java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    com.bmw.peek2.a.a.f r4 = com.bmw.peek2.p032a.p033a.C1082f.this     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.lang.String r4 = r4.f3007f     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    r8.<init>(r1, r4)     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    r1.<init>(r8)     // Catch:{ Exception -> 0x011e, all -> 0x010e }
//                    r4 = 0
//                L_0x0082:
//                    int r0 = r2.read(r3)     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    r9 = -1
//                    if (r0 == r9) goto L_0x00d0
//                    r9 = 0
//                    r1.write(r3, r9, r0)     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    long r10 = (long) r0     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    long r4 = r4 + r10
//                    float r0 = (float) r4     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    r9 = 1065353216(0x3f800000, float:1.0)
//                    float r0 = r0 * r9
//                    float r9 = (float) r6     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    float r0 = r0 / r9
//                    r9 = 1120403456(0x42c80000, float:100.0)
//                    float r0 = r0 * r9
//                    int r0 = (int) r0     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    java.lang.String r9 = "h_bl"
//                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    r10.<init>()     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    java.lang.String r11 = "progress="
//                    java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    java.lang.StringBuilder r10 = r10.append(r0)     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    android.util.Log.d(r9, r10)     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    com.bmw.peek2.a.a.f r9 = com.bmw.peek2.p032a.p033a.C1082f.this     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    com.bmw.peek2.view.c.c r9 = r9.f3004c     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    r9.mo5124a((int) r0)     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    goto L_0x0082
//                L_0x00bb:
//                    r0 = move-exception
//                    r0 = r1
//                    r1 = r2
//                L_0x00be:
//                    java.lang.String r2 = "h_bl"
//                    java.lang.String r3 = "文件下载失败"
//                    com.bmw.peek2.p034b.C1140n.m5268a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0115 }
//                    if (r1 == 0) goto L_0x00ca
//                    r1.close()     // Catch:{ IOException -> 0x0106 }
//                L_0x00ca:
//                    if (r0 == 0) goto L_0x00cf
//                    r0.close()     // Catch:{ IOException -> 0x0108 }
//                L_0x00cf:
//                    return
//                L_0x00d0:
//                    r1.flush()     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    com.bmw.peek2.a.a.f r0 = com.bmw.peek2.p032a.p033a.C1082f.this     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    com.bmw.peek2.view.c.c r0 = r0.f3004c     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    java.lang.String r3 = r8.getAbsolutePath()     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    r0.mo5126a((java.lang.String) r3)     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    java.lang.String r0 = "h_bl"
//                    java.lang.String r3 = "文件下载成功"
//                    com.bmw.peek2.p034b.C1140n.m5268a((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x00bb, all -> 0x0113 }
//                    if (r2 == 0) goto L_0x00ec
//                    r2.close()     // Catch:{ IOException -> 0x0104 }
//                L_0x00ec:
//                    if (r1 == 0) goto L_0x00cf
//                    r1.close()     // Catch:{ IOException -> 0x00f2 }
//                    goto L_0x00cf
//                L_0x00f2:
//                    r0 = move-exception
//                    goto L_0x00cf
//                L_0x00f4:
//                    r1 = move-exception
//                    r2 = r0
//                    r12 = r0
//                    r0 = r1
//                    r1 = r12
//                L_0x00f9:
//                    if (r2 == 0) goto L_0x00fe
//                    r2.close()     // Catch:{ IOException -> 0x010a }
//                L_0x00fe:
//                    if (r1 == 0) goto L_0x0103
//                    r1.close()     // Catch:{ IOException -> 0x010c }
//                L_0x0103:
//                    throw r0
//                L_0x0104:
//                    r0 = move-exception
//                    goto L_0x00ec
//                L_0x0106:
//                    r1 = move-exception
//                    goto L_0x00ca
//                L_0x0108:
//                    r0 = move-exception
//                    goto L_0x00cf
//                L_0x010a:
//                    r2 = move-exception
//                    goto L_0x00fe
//                L_0x010c:
//                    r1 = move-exception
//                    goto L_0x0103
//                L_0x010e:
//                    r1 = move-exception
//                    r12 = r1
//                    r1 = r0
//                    r0 = r12
//                    goto L_0x00f9
//                L_0x0113:
//                    r0 = move-exception
//                    goto L_0x00f9
//                L_0x0115:
//                    r2 = move-exception
//                    r12 = r2
//                    r2 = r1
//                    r1 = r0
//                    r0 = r12
//                    goto L_0x00f9
//                L_0x011b:
//                    r1 = move-exception
//                    r1 = r0
//                    goto L_0x00be
//                L_0x011e:
//                    r1 = move-exception
//                    r1 = r2
//                    goto L_0x00be
//                */
//                throw new UnsupportedOperationException("Method not decompiled: com.bmw.peek2.p032a.p033a.C1082f.C10831.onResponse(okhttp3.Call, okhttp3.Response):void");
//            }
//        });
    }

    /* renamed from: d */
    public void mo4564d() {
        this.f3002a.getUpdateInfo(this);
    }
}
