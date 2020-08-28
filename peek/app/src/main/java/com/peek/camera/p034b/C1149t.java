package com.peek.camera.p034b;

import android.content.Context;
import android.content.Intent;

import com.peek.camera.BaseApplication;
import com.peek.camera.model.All_id_Info;
import com.peek.camera.model.Login_info;
import com.peek.camera.p034b.p036b.C1122b;
import com.peek.camera.p034b.p036b.C1123c;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bmw.peek2.b.t */
public class C1149t {

    /* renamed from: a */
    public ExecutorService f3109a = new C1122b(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue()));

    /* renamed from: b */
    public C1153a f3110b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Socket f3111c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OutputStream f3112d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public InputStream f3113e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f3114f;

    /* renamed from: g */
    private Login_info f3115g = Login_info.getInstance();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f3116h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f3117i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ArrayList<Integer> f3118j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public byte[] f3119k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Integer f3120l;

    /* renamed from: m */
    private boolean f3121m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f3122n;

    /* renamed from: o */
    private C1159z f3123o = new C1159z(BaseApplication.m4925a());

    /* renamed from: com.bmw.peek2.b.t$a */
    public interface C1153a {
        /* renamed from: a */
        void mo4520a(byte[] bArr);
    }

    public C1149t() {
        mo4671a();
        mo4677d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5302a(int i) {
        try {
            Thread.sleep((long) i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5304a(String str) {
        if (Login_info.getInstance().isPermisionLog()) {
            C1140n.m5266a(str);
        }
    }

    /* renamed from: a */
    private void m5305a(String str, String str2) {
        C1140n.m5271b(str, str2);
    }

    /* renamed from: e */
    private void m5312e() {
        Intent intent = new Intent("data.receiver");
        intent.putExtra("isReLoginHK", true);
        BaseApplication.m4925a().sendBroadcast(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m5315f() {
        Intent intent = new Intent("data.receiver");
        intent.putExtra("isLogoutHK", true);
        BaseApplication.m4925a().sendBroadcast(intent);
    }

    /* renamed from: a */
    public void mo4671a() {
        if (this.f3109a == null || this.f3109a.isShutdown()) {
            this.f3109a = new C1122b(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue()));
        }
        this.f3114f = true;
    }

    /* renamed from: a */
    public void mo4672a(C1153a aVar) {
        this.f3110b = aVar;
    }

    /* renamed from: a */
    public void mo4673a(byte[] bArr, int i, String str, int i2) {
        if (this.f3111c != null) {
            if (this.f3113e == null) {
                try {
                    this.f3113e = this.f3111c.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (this.f3113e != null && this.f3111c != null) {
                if (this.f3109a == null || this.f3109a.isShutdown()) {
                    m5305a("singleThreadExecutor || shutdown", "");
                    return;
                }
                final String str2 = str;
                final byte[] bArr2 = bArr;
                final int i3 = i2;
                this.f3109a.execute(new C1123c(i) {
                    public void run() {
                        while (str2.contains("停止") && System.currentTimeMillis() - C1149t.this.f3116h <= 150) {
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (!str2.contains("停止")) {
                            while (System.currentTimeMillis() - C1149t.this.f3116h <= 100) {
                                C1149t.this.m5302a(5);
                            }
                        }
                        C1149t.this.mo4674a(bArr2, str2);
                        if (i3 == 1) {
                            C1149t.this.m5302a(20);
                        }
                        if (str2.contains("停止")) {
                            C1149t.this.m5302a(50);
                        }
                        long unused = C1149t.this.f3116h = System.currentTimeMillis();
                        String unused2 = C1149t.this.f3117i = str2;
                    }
                });
            }
        } else if (this.f3114f) {
            if (Login_info.getInstance().isWifi_auto()) {
                if (!C1116aa.m5197a(this.f3123o, Login_info.getInstance().isWifiIsRepeater() ? Login_info.baseRepeaterWifiSSID : Login_info.baseMainFrameWifiSSID) && !All_id_Info.getInstance().isWifiConnectRunning()) {
                    C1116aa.m5196a((Context) BaseApplication.m4925a());
                }
            }
            if (!this.f3121m) {
                synchronized (this) {
                    if (!this.f3121m) {
                        C1140n.m5269b("开启socket重连线程！");
                        new Thread(new Runnable() {
                            public void run() {
                                if (C1149t.this.f3114f) {
//                                    C1149t.this.mo4675b();
                                }
                            }
                        }).start();
                        this.f3121m = true;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4674a(byte[] bArr, String str) {
        if (this.f3111c == null) {
            m5305a("数据:发送", str + "命令失败：sendcmd: socket is null");
            return;
        }
        if (this.f3112d == null) {
            try {
                this.f3112d = this.f3111c.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.f3112d == null) {
            m5305a("数据:socketWriter == null", str);
            return;
        }
        try {
            this.f3112d.write(bArr);
            this.f3112d.flush();
        } catch (IOException e2) {
            if (this.f3111c != null && !this.f3111c.isClosed()) {
                m5305a("数据:socketService is already closed!  ", str);
                this.f3111c = null;
                try {
                    if (this.f3113e != null) {
                        this.f3113e.close();
                    }
                    if (this.f3112d != null) {
                        this.f3112d.close();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                this.f3113e = null;
                this.f3112d = null;
                mo4671a();
            }
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0122, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0123, code lost:
        com.bmw.peek2.p034b.C1139m.m5264a("socket connect fail! e = " + r0.toString());
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01ed, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01ee, code lost:
        com.bmw.peek2.p034b.C1139m.m5264a("socket connect fail! e = " + r0.toString());
        com.bmw.peek2.p034b.C1140n.m5269b("socket连接超时：" + r0.toString());
        r7.f3111c = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0226, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0227, code lost:
        com.bmw.peek2.p034b.C1139m.m5264a("socket connect fail! e = " + r0.toString());
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0246, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0247, code lost:
        com.bmw.peek2.p034b.C1139m.m5264a("socket connect fail! e = " + r0.toString());
        com.bmw.peek2.p034b.C1140n.m5269b("其他错误");
        r7.f3111c = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0122 A[ExcHandler: UnknownHostException (r0v11 'e' java.net.UnknownHostException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01ed A[ExcHandler: SocketTimeoutException (r0v7 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0246 A[ExcHandler: Exception (r0v1 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4675b() {
        /*
            r7 = this;
            r6 = 0
            r1 = 0
            boolean r0 = r7.f3114f
            if (r0 == 0) goto L_0x011b
            java.net.Socket r0 = r7.f3111c     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            if (r0 == 0) goto L_0x000f
            java.net.Socket r0 = r7.f3111c     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r0.close()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
        L_0x000f:
            com.bmw.peek2.b.o r0 = com.bmw.peek2.p034b.C1141o.m5272a()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r2 = 0
            r0.mo4666b((boolean) r2)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            com.bmw.peek2.b.o r0 = com.bmw.peek2.p034b.C1141o.m5272a()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r2 = 0
            r0.mo4664a((boolean) r2)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r0 = 0
            r7.f3111c = r0     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.io.InputStream r0 = r7.f3113e     // Catch:{ IOException -> 0x011c, UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, Exception -> 0x0246 }
            if (r0 == 0) goto L_0x002b
            java.io.InputStream r0 = r7.f3113e     // Catch:{ IOException -> 0x011c, UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, Exception -> 0x0246 }
            r0.close()     // Catch:{ IOException -> 0x011c, UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, Exception -> 0x0246 }
        L_0x002b:
            java.io.OutputStream r0 = r7.f3112d     // Catch:{ IOException -> 0x011c, UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, Exception -> 0x0246 }
            if (r0 == 0) goto L_0x0034
            java.io.OutputStream r0 = r7.f3112d     // Catch:{ IOException -> 0x011c, UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, Exception -> 0x0246 }
            r0.close()     // Catch:{ IOException -> 0x011c, UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, Exception -> 0x0246 }
        L_0x0034:
            r0 = 0
            r7.f3113e = r0     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r0 = 0
            r7.f3112d = r0     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            com.bmw.peek2.model.Login_info r0 = com.bmw.peek2.model.Login_info.getInstance()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            boolean r0 = r0.isWifi_auto()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            if (r0 == 0) goto L_0x004f
            r0 = r1
        L_0x0045:
            if (r0 != 0) goto L_0x004f
            boolean r0 = r7.f3114f     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            if (r0 == 0) goto L_0x004f
            java.io.InputStream r0 = r7.f3113e     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            if (r0 == 0) goto L_0x0141
        L_0x004f:
            com.bmw.peek2.b.o r0 = com.bmw.peek2.p034b.C1141o.m5272a()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r0.mo4665b()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r0 = r1
        L_0x0057:
            if (r0 != 0) goto L_0x005d
            boolean r0 = r7.f3114f     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            if (r0 != 0) goto L_0x01a4
        L_0x005d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r0.<init>()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r1 = "数据:socket连接:  开始连接..... this = "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            long r2 = r1.getId()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r0 = r0.toString()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            com.bmw.peek2.p034b.C1140n.m5266a(r0)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r0 = "start socket connect!"
            com.bmw.peek2.p034b.C1139m.m5264a(r0)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.net.Socket r0 = new java.net.Socket     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r0.<init>()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r7.f3111c = r0     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.net.Socket r0 = r7.f3111c     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r1 = 5000(0x1388, float:7.006E-42)
            r0.setSoTimeout(r1)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.net.Socket r0 = r7.f3111c     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.net.InetSocketAddress r1 = new java.net.InetSocketAddress     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            com.bmw.peek2.model.Login_info r2 = r7.f3115g     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r2 = r2.getSocket_ip()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.net.InetAddress r2 = java.net.InetAddress.getByName(r2)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            com.bmw.peek2.model.Login_info r3 = r7.f3115g     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            int r3 = r3.getSocket_port()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r1.<init>(r2, r3)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r0.connect(r1)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.net.Socket r0 = r7.f3111c     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r1 = 1
            r0.setKeepAlive(r1)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r0.<init>()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r1 = "数据socket连接："
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.net.Socket r1 = r7.f3111c     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            boolean r1 = r1.isConnected()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r0 = r0.toString()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            com.bmw.peek2.p034b.C1140n.m5266a(r0)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.net.Socket r0 = r7.f3111c     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.io.OutputStream r0 = r0.getOutputStream()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r7.f3112d = r0     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.net.Socket r0 = r7.f3111c     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r7.f3113e = r0     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.net.Socket r0 = r7.f3111c     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r1 = 6000(0x1770, float:8.408E-42)
            r0.setSoTimeout(r1)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.net.Socket r0 = r7.f3111c     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            if (r0 == 0) goto L_0x01e8
            java.io.OutputStream r0 = r7.f3112d     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            if (r0 == 0) goto L_0x01e8
            java.lang.String r0 = "socket connect success!"
            com.bmw.peek2.p034b.C1139m.m5264a(r0)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r0 = "数据:socket连接:  连接成功!"
            java.lang.String r1 = ""
            com.bmw.peek2.p034b.C1140n.m5268a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r0 = 0
            r7.f3121m = r0     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r0 = 0
            r7.f3122n = r0     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            com.bmw.peek2.b.o r0 = com.bmw.peek2.p034b.C1141o.m5272a()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r0.mo4665b()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            com.bmw.peek2.model.All_id_Info r0 = com.bmw.peek2.model.All_id_Info.getInstance()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            int r0 = r0.getM_iLogID()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            if (r0 >= 0) goto L_0x010f
            r7.m5312e()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
        L_0x010f:
            java.net.Socket r0 = r7.f3111c
            if (r0 != 0) goto L_0x011b
            r0 = 50
            r7.m5302a((int) r0)
            r7.mo4675b()
        L_0x011b:
            return
        L_0x011c:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            goto L_0x0034
        L_0x0122:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "socket connect fail! e = "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r0.toString()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.bmw.peek2.p034b.C1139m.m5264a(r1)
            r0.printStackTrace()
            goto L_0x010f
        L_0x0141:
            com.bmw.peek2.model.Login_info r0 = com.bmw.peek2.model.Login_info.getInstance()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            boolean r0 = r0.isWifiIsRepeater()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            if (r0 == 0) goto L_0x01a1
            java.lang.String r0 = "Peek2S_Relay_AP"
        L_0x014d:
            com.bmw.peek2.b.z r2 = r7.f3123o     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r2 = r2.mo4690g()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            boolean r2 = r2.contains(r0)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r3.<init>()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r4 = "检查WiFi是否连接：ssid = "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r3 = "  currentSsid = "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            com.bmw.peek2.b.z r3 = r7.f3123o     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r3 = r3.mo4690g()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r3 = " this = "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            long r4 = r3.getId()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r0 = r0.toString()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            com.bmw.peek2.p034b.C1140n.m5266a(r0)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r0 = 2000(0x7d0, float:2.803E-42)
            r7.m5302a((int) r0)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            com.bmw.peek2.model.Login_info r0 = com.bmw.peek2.model.Login_info.getInstance()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            boolean r0 = r0.isWifi_auto()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            if (r0 == 0) goto L_0x004f
            r0 = r2
            goto L_0x0045
        L_0x01a1:
            java.lang.String r0 = "Peek2S_AP"
            goto L_0x014d
        L_0x01a4:
            com.bmw.peek2.b.o r0 = com.bmw.peek2.p034b.C1141o.m5272a()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            boolean r0 = r0.mo4668d()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r1.<init>()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r2 = "检查ip是否联通： "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.StringBuilder r1 = r1.append(r0)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r2 = " this = "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            long r2 = r2.getId()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            java.lang.String r1 = r1.toString()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            com.bmw.peek2.p034b.C1140n.m5266a(r1)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            com.bmw.peek2.b.o r1 = com.bmw.peek2.p034b.C1141o.m5272a()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r1.mo4665b()     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            r1 = 2000(0x7d0, float:2.803E-42)
            r7.m5302a((int) r1)     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            if (r0 != 0) goto L_0x005d
            java.io.InputStream r1 = r7.f3113e     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            if (r1 == 0) goto L_0x0057
            goto L_0x005d
        L_0x01e8:
            r0 = 0
            r7.f3111c = r0     // Catch:{ UnknownHostException -> 0x0122, SocketTimeoutException -> 0x01ed, IOException -> 0x0226, Exception -> 0x0246 }
            goto L_0x010f
        L_0x01ed:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "socket connect fail! e = "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r0.toString()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.bmw.peek2.p034b.C1139m.m5264a(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "socket连接超时："
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.bmw.peek2.p034b.C1140n.m5269b(r0)
            r7.f3111c = r6
            goto L_0x010f
        L_0x0226:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "socket connect fail! e = "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r0.toString()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.bmw.peek2.p034b.C1139m.m5264a(r1)
            r0.printStackTrace()
            goto L_0x010f
        L_0x0246:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "socket connect fail! e = "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.bmw.peek2.p034b.C1139m.m5264a(r0)
            java.lang.String r0 = "其他错误"
            com.bmw.peek2.p034b.C1140n.m5269b(r0)
            r7.f3111c = r6
            goto L_0x010f
        */
//        throw new UnsupportedOperationException("Method not decompiled: com.bmw.peek2.p034b.C1149t.mo4675b():void");
    }

    /* renamed from: c */
    public void mo4676c() {
        this.f3114f = false;
        if (this.f3111c != null) {
            try {
                this.f3109a.shutdownNow();
                if (this.f3111c != null) {
                    this.f3111c.shutdownInput();
                    this.f3111c.shutdownOutput();
                    this.f3111c.close();
                }
                this.f3111c = null;
                try {
                    if (this.f3113e != null) {
                        this.f3113e.close();
                    }
                    if (this.f3112d != null) {
                        this.f3112d.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.f3113e = null;
                this.f3112d = null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        C1140n.m5268a("数据:socket断开连接: Socket已经释放内存！", "");
    }

    /* renamed from: d */
    public void mo4677d() {
        this.f3118j = new ArrayList<>();
        this.f3119k = new byte[1];
        this.f3114f = true;
        new Thread(new Runnable() {
            public void run() {
                C1140n.m5266a("开启socket读取线程！socket = " + C1149t.this.f3111c);
                while (C1149t.this.f3114f) {
                    if (!(C1149t.this.f3111c == null || C1149t.this.f3113e == null)) {
                        try {
                            C1149t.this.f3113e.read(C1149t.this.f3119k);
                            if (C1149t.this.f3118j.size() != 0) {
                                C1149t.this.f3118j.add(Integer.valueOf(C1149t.this.f3119k[0] & 255));
                            } else if ((C1149t.this.f3119k[0] & 255) == 1) {
                                C1149t.this.f3118j.add(Integer.valueOf(C1149t.this.f3119k[0] & 255));
                                C1149t.this.m5304a("socket读取，头校验成功");
                            }
                            if (C1149t.this.f3118j.size() == 3) {
                                Integer unused = C1149t.this.f3120l = (Integer) C1149t.this.f3118j.get(2);
                            }
                            if (C1149t.this.f3118j.size() > 3 && C1149t.this.f3118j.size() == C1149t.this.f3120l.intValue() + 3) {
                                int i = 0;
                                for (int i2 = 0; i2 < C1149t.this.f3118j.size() - 1; i2++) {
                                    i += ((Integer) C1149t.this.f3118j.get(i2)).intValue();
                                }
                                if (i % 256 == ((Integer) C1149t.this.f3118j.get(C1149t.this.f3118j.size() - 1)).intValue()) {
                                    C1149t.this.m5304a("socket读取，数据校验成功！");
                                    byte[] bArr = new byte[C1149t.this.f3118j.size()];
                                    for (int i3 = 0; i3 < C1149t.this.f3118j.size(); i3++) {
                                        bArr[i3] = (byte) ((Integer) C1149t.this.f3118j.get(i3)).intValue();
                                    }
                                    if (C1149t.this.f3110b != null) {
                                        C1149t.this.f3110b.mo4520a(bArr);
                                    } else {
                                        C1140n.m5269b("数据校验：listener监听为null");
                                    }
                                }
                                C1149t.this.f3118j.clear();
                                Integer unused2 = C1149t.this.f3120l = 0;
                            }
                        } catch (SocketTimeoutException e) {
                            C1139m.m5264a("socket read and parse out of time! e = " + e.toString());
                            C1140n.m5269b("socket连接超时：" + e.toString());
                            if (!C1149t.this.f3122n) {
                                C1141o.m5272a().mo4665b();
                                boolean unused3 = C1149t.this.f3122n = true;
                                if (C1149t.this.f3111c != null) {
                                    try {
                                        C1149t.this.f3111c.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                Socket unused4 = C1149t.this.f3111c = null;
                                try {
                                    if (C1149t.this.f3113e != null) {
                                        C1149t.this.f3113e.close();
                                    }
                                    if (C1149t.this.f3112d != null) {
                                        C1149t.this.f3112d.close();
                                    }
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                                InputStream unused5 = C1149t.this.f3113e = null;
                                OutputStream unused6 = C1149t.this.f3112d = null;
                                C1149t.this.m5315f();
                            }
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            C1140n.m5269b("socket read error: " + e4.toString());
                            C1149t.this.m5302a(2000);
                        }
                    }
                }
            }
        }).start();
    }
}
