package com.peek.camera;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.peek.camera.model.Login_info;
import com.peek.camera.p034b.C1127e;
import com.peek.camera.p034b.C1134k;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BaseApplication extends Application {

    /* renamed from: a */
    static Context f2898a;

    /* renamed from: b */
    static Resources f2899b;

    /* renamed from: c */
    public static Executor f2900c = Executors.newFixedThreadPool(5);

    /* renamed from: d */
    public static Executor f2901d = Executors.newSingleThreadExecutor();

    /* renamed from: e */
    private static long f2902e;

    /* renamed from: f */
    private static String f2903f;

    /* renamed from: g */
    private List<Activity> f2904g;

    /* renamed from: h */
    private String f2905h;

    /* renamed from: a */
    public static synchronized BaseApplication m4925a() {
        BaseApplication baseApplication;
        synchronized (BaseApplication.class) {
            baseApplication = (BaseApplication) f2898a;
        }
        return baseApplication;
    }

    /* renamed from: a */
    public static void m4926a(String str) {
        m4927a(str, 0);
    }

    /* renamed from: a */
    public static void m4927a(String str, int i) {
        if (str != null && !str.equalsIgnoreCase("")) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!str.equalsIgnoreCase(f2903f) || currentTimeMillis - f2902e > 2000) {
                View inflate = LayoutInflater.from(m4925a()).inflate(R.layout.toast_view, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.toast_tv)).setText(str);
                Toast toast = new Toast(m4925a());
                toast.setView(inflate);
                toast.setDuration(i);
                toast.show();
                f2902e = System.currentTimeMillis();
                f2903f = str;
            }
        }
    }

    /* renamed from: b */
    public static SharedPreferences m4928b() {
        return m4925a().getSharedPreferences("PREF_PEEK2S", 0);
    }

    /* renamed from: a */
    public void mo4479a(Activity activity) {
        if (!this.f2904g.contains(activity)) {
            this.f2904g.add(activity);
        }
    }

    /* renamed from: b */
    public void mo4480b(Activity activity) {
        if (this.f2904g.contains(activity)) {
            this.f2904g.remove(activity);
            activity.finish();
        }
    }

    /* renamed from: b */
    public void mo4481b(String str) {
        this.f2905h = str;
    }

    /* renamed from: c */
    public void mo4482c() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f2904g.size()) {
                this.f2904g.get(i2).finish();
                i = i2 + 1;
            } else {
                C1127e.m5217a().close();
                Login_info.getInstance().release();
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(1100);
                            System.exit(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                return;
            }
        }
    }

    /* renamed from: c */
    public void mo4483c(Activity activity) {
        for (Activity next : this.f2904g) {
            if (next != activity) {
                next.finish();
            }
        }
    }

    /* renamed from: d */
    public String mo4484d() {
        return this.f2905h;
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;
    }

    public void onCreate() {
        super.onCreate();
        C1127e.m5218a(getApplicationContext());
        f2898a = getApplicationContext();
        f2899b = f2898a.getResources();
        this.f2904g = new ArrayList();
        C1134k.m5255a((Context) m4925a(), m4928b().getInt(C1057a.f2931h, -1));
    }
}
