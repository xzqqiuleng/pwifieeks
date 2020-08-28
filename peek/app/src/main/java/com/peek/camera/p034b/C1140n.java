package com.peek.camera.p034b;

import android.util.Log;

import com.peek.camera.view.p040ui.BaseActivity;

/* renamed from: com.bmw.peek2.b.n */
public class C1140n {

    /* renamed from: a */
    private static final String f3099a = BaseActivity.f3636m;

    /* renamed from: b */
    private static StringBuilder f3100b;

    /* renamed from: a */
    private static synchronized void m5265a() {
        synchronized (C1140n.class) {
            if (f3100b.toString().length() >= 0) {
                f3100b.delete(0, f3100b.toString().length());
            }
        }
    }

    /* renamed from: a */
    public static void m5266a(String str) {
        Log.i(f3099a, str);
    }

    /* renamed from: a */
    public static void m5267a(String str, int i) {
    }

    /* renamed from: a */
    public static void m5268a(String str, String str2) {
    }

    /* renamed from: b */
    public static void m5269b(String str) {
        Log.e(f3099a, str);
    }

    /* renamed from: b */
    public static void m5270b(String str, int i) {
        if (f3100b == null) {
            f3100b = new StringBuilder();
        }
        Log.e(f3099a, f3100b.append(str).append(i).toString());
        m5265a();
    }

    /* renamed from: b */
    public static void m5271b(String str, String str2) {
        if (f3100b == null) {
            f3100b = new StringBuilder();
        }
        Log.e(f3099a, f3100b.append(str).append(str2).toString());
        m5265a();
    }
}
