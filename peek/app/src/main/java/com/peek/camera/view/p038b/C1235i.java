package com.peek.camera.view.p038b;

import android.app.AlertDialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.peek.camera.R;


/* renamed from: com.bmw.peek2.view.b.i */
public class C1235i {

    /* renamed from: a */
    private AlertDialog f3368a;

    /* renamed from: b */
    private TextView f3369b;

    /* renamed from: c */
    private TextView f3370c;

    /* renamed from: d */
    private TextView f3371d;

    /* renamed from: e */
    private TextView f3372e;

    public C1235i(Context context, String str) {
        this.f3368a = new AlertDialog.Builder(context).create();
        Window window = this.f3368a.getWindow();
        window.setWindowAnimations(R.style.dialog_anim);
        this.f3368a.show();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        window.setAttributes(this.f3368a.getWindow().getAttributes());
        window.setGravity(17);
        window.setContentView(R.layout.system_msg);
        this.f3369b = (TextView) window.findViewById(R.id.manufacturer_name);
        this.f3370c = (TextView) window.findViewById(R.id.shengchanshang);
        this.f3371d = (TextView) window.findViewById(R.id.xinghao_text);
        this.f3372e = (TextView) window.findViewById(R.id.xinghao_text_name);
        ((TextView) window.findViewById(R.id.sys_version)).setText(str);
    }
}
