package com.peek.camera.view.p038b;

import android.app.AlertDialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import com.hikvision.netsdk.HCNetSDK;
import com.peek.camera.R;

/* renamed from: com.bmw.peek2.view.b.g */
public class C1228g {

    /* renamed from: a */
    private AlertDialog f3341a;

    /* renamed from: b */
    private SeekBar f3342b;

    public C1228g(Context context, int i) {
        this.f3341a = new AlertDialog.Builder(context).create();
        Window window = this.f3341a.getWindow();
        window.setWindowAnimations(R.style.dialog_anim);
        this.f3341a.show();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        window.setAttributes(this.f3341a.getWindow().getAttributes());
        window.setGravity(17);
        window.setContentView(R.layout.screen_light_ajust);
        this.f3342b = (SeekBar) window.findViewById(R.id.screen_seekbar);
        this.f3342b.setMax(HCNetSDK.STEP_SEARCH);
        this.f3342b.setProgress(i);
    }

    /* renamed from: a */
    public void mo5091a(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.f3342b.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }
}
