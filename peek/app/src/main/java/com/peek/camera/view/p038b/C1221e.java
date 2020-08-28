package com.peek.camera.view.p038b;

import android.app.AlertDialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.peek.camera.R;

/* renamed from: com.bmw.peek2.view.b.e */
public class C1221e {

    /* renamed from: a */
    private AlertDialog f3325a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1223a f3326b;

    /* renamed from: c */
    private TextView f3327c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public EditText f3328d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public EditText f3329e;

    /* renamed from: com.bmw.peek2.view.b.e$a */
    public interface C1223a {
        /* renamed from: a */
        void mo4999a(String str, String str2);
    }

    public C1221e(Context context, String str, String str2, float f, float f2) {
        this.f3325a = new AlertDialog.Builder(context).create();
        Window window = this.f3325a.getWindow();
        window.setWindowAnimations(R.style.dialog_anim);
        this.f3325a.setView(new EditText(context));
        this.f3325a.show();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        window.setAttributes(this.f3325a.getWindow().getAttributes());
        window.setBackgroundDrawableResource(17170445);
        window.setGravity(17);
        window.setContentView(R.layout.environment_set_item);
        this.f3327c = (TextView) window.findViewById(R.id.dialog_set);
        this.f3328d = (EditText) window.findViewById(R.id.dialog_min);
        this.f3329e = (EditText) window.findViewById(R.id.dialog_max);
        this.f3328d.setText(String.valueOf(f));
        this.f3328d.setSelection(String.valueOf(f).length());
        this.f3329e.setText(String.valueOf(f2));
        this.f3329e.setSelection(String.valueOf(f2).length());
        ((TextView) window.findViewById(R.id.dialog_name)).setText(str);
        ((TextView) window.findViewById(R.id.dialog_unit)).setText(str2);
        this.f3327c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (C1221e.this.f3326b != null) {
                    C1221e.this.f3326b.mo4999a(C1221e.this.f3328d.getText().toString(), C1221e.this.f3329e.getText().toString());
                }
            }
        });
    }

    /* renamed from: a */
    public void mo5084a() {
        this.f3325a.dismiss();
    }

    /* renamed from: a */
    public void mo5085a(C1223a aVar) {
        this.f3326b = aVar;
    }
}
