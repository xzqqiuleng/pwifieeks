package com.peek.camera.view.p038b;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.peek.camera.BaseApplication;
import com.peek.camera.C1057a;
import com.peek.camera.R;
import com.peek.camera.p034b.p035a.C1107a;

/* renamed from: com.bmw.peek2.view.b.a */
public class C1203a {

    /* renamed from: a */
    private Switch f3282a;

    /* renamed from: b */
    private Switch f3283b;

    /* renamed from: c */
    private Switch f3284c;

    /* renamed from: d */
    private Switch f3285d;

    /* renamed from: e */
    private Switch f3286e;

    /* renamed from: f */
    private Switch f3287f;

    /* renamed from: g */
    private Switch f3288g;

    /* renamed from: h */
    private AlertDialog f3289h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f3290i;

    public C1203a(Context context) {
        this.f3289h = new AlertDialog.Builder(context).create();
        Window window = this.f3289h.getWindow();
        window.setWindowAnimations(R.style.dialog_anim);
        this.f3289h.show();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        window.setAttributes(this.f3289h.getWindow().getAttributes());
        window.setGravity(17);
        window.setContentView(R.layout.advance_setting);
        this.f3282a = (Switch) window.findViewById(R.id.fangdou_switch);
        this.f3283b = (Switch) window.findViewById(R.id.kuandongtai_switch);
        this.f3284c = (Switch) window.findViewById(R.id.qiangguangyizhi_switch);
        this.f3285d = (Switch) window.findViewById(R.id.touwu_switch);
        this.f3286e = (Switch) window.findViewById(R.id.gaoganguang_switch);
        this.f3287f = (Switch) window.findViewById(R.id.sw_digtital_setMax);
        this.f3288g = (Switch) window.findViewById(R.id.sw_open_wide_screen);
        m5552c();
        window.findViewById(R.id.advance_back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C1203a.this.mo5066a();
            }
        });
        this.f3289h.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (C1203a.this.f3290i != C1057a.m4938b()) {
                    new Thread(new Runnable() {
                        public void run() {
                            boolean b = C1107a.m5163a().mo4598b();
                            int i = 0;
                            while (!b && i < 5) {
                                b = C1107a.m5163a().mo4598b();
                                try {
                                    Thread.sleep(1500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                i++;
                            }
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            C1203a.this.m5553d();
                        }
                    }).start();
                }
            }
        });
        m5550b();
    }

    /* renamed from: b */
    private void m5550b() {
        this.f3283b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BaseApplication.m4928b().edit().putBoolean(C1057a.f2929f, z).commit();
            }
        });
        this.f3287f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BaseApplication.m4928b().edit().putBoolean(C1057a.f2930g, z).commit();
            }
        });
        this.f3288g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C1057a.m4937b(z);
            }
        });
    }

    /* renamed from: c */
    private void m5552c() {
        boolean z = BaseApplication.m4928b().getBoolean(C1057a.f2929f, true);
        boolean z2 = BaseApplication.m4928b().getBoolean(C1057a.f2930g, false);
        this.f3290i = C1057a.m4938b();
        this.f3288g.setChecked(this.f3290i);
        this.f3283b.setChecked(z);
        this.f3287f.setChecked(z2);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5553d() {
        Intent intent = new Intent();
        intent.setAction("data.receiver");
        intent.putExtra("isReLoginHK", true);
        BaseApplication.m4925a().sendBroadcast(intent);
    }

    /* renamed from: a */
    public void mo5066a() {
        this.f3289h.dismiss();
    }
}
