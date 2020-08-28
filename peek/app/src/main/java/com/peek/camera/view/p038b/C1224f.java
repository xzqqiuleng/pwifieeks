package com.peek.camera.view.p038b;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.peek.camera.R;

/* renamed from: com.bmw.peek2.view.b.f */
public class C1224f {

    /* renamed from: a */
    private AlertDialog f3331a;

    /* renamed from: b */
    private RadioGroup f3332b;

    /* renamed from: c */
    private RadioButton f3333c;

    /* renamed from: d */
    private RadioButton f3334d;

    /* renamed from: e */
    private RadioButton f3335e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f3336f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f3337g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1227a f3338h;

    /* renamed from: com.bmw.peek2.view.b.f$a */
    public interface C1227a {
        /* renamed from: a */
        void mo5090a(int i);
    }

    public C1224f(Context context, int i) {
        this.f3331a = new AlertDialog.Builder(context).create();
        Window window = this.f3331a.getWindow();
        window.setWindowAnimations(R.style.dialog_anim);
        this.f3331a.show();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        window.setAttributes(this.f3331a.getWindow().getAttributes());
        window.setGravity(17);
        window.setContentView(R.layout.dialog_language_set);
        this.f3332b = (RadioGroup) window.findViewById(R.id.radio_groud);
        this.f3335e = (RadioButton) window.findViewById(R.id.rbtn_default);
        this.f3333c = (RadioButton) window.findViewById(R.id.rbtn_zh);
        this.f3334d = (RadioButton) window.findViewById(R.id.rbtn_en);
        if (i == 0) {
            this.f3336f = 0;
            this.f3333c.setChecked(true);
        } else if (i == 1) {
            this.f3336f = 1;
            this.f3334d.setChecked(true);
        } else {
            this.f3336f = -1;
            this.f3335e.setChecked(true);
        }
        this.f3337g = i;
        this.f3332b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbtn_default:
                        int unused = C1224f.this.f3337g = -1;
                        return;
                    case R.id.rbtn_en:
                        int unused2 = C1224f.this.f3337g = 1;
                        return;
                    case R.id.rbtn_zh:
                        int unused3 = C1224f.this.f3337g = 0;
                        return;
                    default:
                        return;
                }
            }
        });
        this.f3331a.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (C1224f.this.f3338h == null) {
                    return;
                }
                if (C1224f.this.f3336f != 0 || C1224f.this.f3337g != 0) {
                    if (C1224f.this.f3336f != 1 || C1224f.this.f3337g != 1) {
                        if (C1224f.this.f3336f != -1 || C1224f.this.f3337g != -1) {
                            C1224f.this.f3338h.mo5090a(C1224f.this.f3337g);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void mo5087a(C1227a aVar) {
        this.f3338h = aVar;
    }
}
