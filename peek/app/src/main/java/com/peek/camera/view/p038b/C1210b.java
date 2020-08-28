package com.peek.camera.view.p038b;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.peek.camera.R;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.bmw.peek2.view.b.b */
public class C1210b {

    /* renamed from: a */
    private AlertDialog f3297a;

    /* renamed from: b */
    private TextView f3298b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f3299c;

    /* renamed from: d */
    private TextView f3300d;

    /* renamed from: e */
    private ImageView f3301e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Bitmap f3302f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Timer f3303g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TimerTask f3304h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f3305i = 6;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Context f3306j;

    public C1210b(Context context, String str, String str2) {
        this.f3306j = context;
        this.f3297a = new AlertDialog.Builder(context).create();
        this.f3297a.setCanceledOnTouchOutside(false);
        Window window = this.f3297a.getWindow();
        window.setWindowAnimations(R.style.dialog_anim);
        this.f3297a.setView(new EditText(context));
        this.f3297a.show();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        WindowManager.LayoutParams attributes = this.f3297a.getWindow().getAttributes();
        attributes.width = (int) (((double) displayMetrics.widthPixels) * 0.5d);
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(17170445);
        window.setGravity(17);
        window.setContentView(R.layout.dialog_capture_tishi);
        this.f3298b = (TextView) window.findViewById(R.id.dialog_captureTishi_sure);
        this.f3299c = (TextView) window.findViewById(R.id.dialog_captureTishi_cancel);
        this.f3300d = (TextView) window.findViewById(R.id.dialog_captureTishi_title);
        this.f3301e = (ImageView) window.findViewById(R.id.dialog_captureTishi_image);
        this.f3300d.setText(str);
        this.f3302f = BitmapFactory.decodeFile(str2);
        this.f3301e.setImageBitmap(this.f3302f);
        m5557b();
        this.f3297a.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (C1210b.this.f3302f != null) {
                    C1210b.this.f3302f.recycle();
                }
                C1210b.this.f3304h.cancel();
                C1210b.this.f3303g.cancel();
            }
        });
    }

    /* renamed from: b */
    private void m5557b() {
        this.f3303g = new Timer();
        this.f3304h = new TimerTask() {
            public void run() {
                if (C1210b.this.f3299c != null) {
                    C1210b.this.f3299c.post(new Runnable() {
                        public void run() {
                            if (C1210b.this.f3305i < 0) {
                                C1210b.this.mo5073a();
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(C1210b.this.f3306j.getResources().getString(R.string.cancel)).append("(").append(C1210b.this.f3305i).append("s)");
                            C1210b.this.f3299c.setText(sb.toString());
                            C1210b.m5562g(C1210b.this);
                        }
                    });
                }
            }
        };
        this.f3303g.schedule(this.f3304h, 0, 1000);
    }

    /* renamed from: g */
    static /* synthetic */ int m5562g(C1210b bVar) {
        int i = bVar.f3305i;
        bVar.f3305i = i - 1;
        return i;
    }

    /* renamed from: a */
    public void mo5073a() {
        this.f3297a.dismiss();
    }

    /* renamed from: a */
    public void mo5074a(View.OnClickListener onClickListener) {
        this.f3298b.setOnClickListener(onClickListener);
    }

    /* renamed from: b */
    public void mo5075b(View.OnClickListener onClickListener) {
        this.f3299c.setOnClickListener(onClickListener);
    }
}
