package com.peek.camera.view.p038b;

import android.app.AlertDialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.peek.camera.R;

/* renamed from: com.bmw.peek2.view.b.c */
public class C1214c {

    /* renamed from: a */
    private final AlertDialog f3310a;

    public C1214c(Context context) {
        this.f3310a = new AlertDialog.Builder(context).create();
        this.f3310a.setCanceledOnTouchOutside(true);
        Window window = this.f3310a.getWindow();
        window.setWindowAnimations(R.style.dialog_anim);
        this.f3310a.setView(new EditText(context));
        this.f3310a.show();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        window.setAttributes(this.f3310a.getWindow().getAttributes());
        window.setBackgroundDrawableResource(17170445);
        window.setGravity(17);
        window.setContentView(R.layout.dialog_clock_show);
    }
}
