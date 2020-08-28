package com.peek.camera.view.p040ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.peek.camera.BaseApplication;
import com.peek.camera.jna.SystemTransformByJNA;
import com.peek.camera.jna.SystemTransformJNAInstance;
import com.peek.camera.p034b.C1140n;


/* renamed from: com.bmw.peek2.view.ui.BaseActivity */
public class BaseActivity extends AppCompatActivity {

    /* renamed from: m */
    public static String f3636m = "peek2s_debug";

    /* renamed from: n */
    Toast f3637n;

    /* renamed from: o */
    private BaseApplication f3638o;

    /* renamed from: p */
    private BaseActivity f3639p;

    /* renamed from: b */
    public static void m5794b(String str) {
        C1140n.m5266a(str);
    }

    /* renamed from: c */
    public static void m5795c(String str) {
        C1140n.m5269b(str);
    }

    /* renamed from: q */
    private void mo5113q() {
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            public void onSystemUiVisibilityChange(int i) {
                BaseActivity.m5794b("system ui visibility change = " + i);
                BaseActivity.this.mo5208j();
            }
        });
    }

    /* renamed from: a */
    public void mo5206a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f3637n == null) {
                this.f3637n = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT);
            } else {
                this.f3637n.setText(str);
            }
            this.f3637n.show();
        }
    }

    /* renamed from: b */
    public void mo5207b(int i) {
        if (this.f3637n == null) {
            this.f3637n = Toast.makeText(getApplicationContext(), i, Toast.LENGTH_SHORT);
        } else {
            this.f3637n.setText(i);
        }
        this.f3637n.show();
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo5208j() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            getWindow().getDecorView().setSystemUiVisibility(8);
        } else if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(5126);
        }
    }

    /* renamed from: k */
    public boolean mo5209k() {
        return true;
    }

    /* renamed from: l */
    public Context mo5210l() {
        return this.f3639p;
    }

    /* renamed from: m */
    public void mo5211m() {
        this.f3638o.mo4479a((Activity) this.f3639p);
    }

    /* renamed from: n */
    public void mo5212n() {
        this.f3638o.mo4480b((Activity) this.f3639p);
    }

    /* renamed from: o */
    public void mo5213o() {
        SystemTransformJNAInstance.getInstance().SYSTRANS_Stop(SystemTransformByJNA.handle.getValue());
        SystemTransformJNAInstance.getInstance().SYSTRANS_Release(SystemTransformByJNA.handle.getValue());
        this.f3638o.mo4482c();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        getWindow().getDecorView().setSystemUiVisibility(2);
        if (this.f3638o == null) {
            this.f3638o = (BaseApplication) getApplication();
        }
        this.f3639p = this;
        mo5211m();
        if (mo5209k()) {
            mo5113q();
        }
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int i) {
        if (mo5209k()) {
            mo5208j();
        }
        return super.onCreateDialog(i);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        mo5212n();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (mo5209k()) {
            mo5208j();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (mo5209k()) {
            mo5208j();
        }
        super.onResume();
    }

    /* renamed from: p */
    public void mo5215p() {
        this.f3638o.mo4483c(this.f3639p);
    }
}
