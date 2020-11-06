package com.peek.camera.p034b;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.peek.camera.R;

/* renamed from: com.bmw.peek2.b.a */
public class C1104a {
    /* renamed from: a */
    public static int m5160a(int i) {
        return i == 0 ? R.mipmap.bc1 : i <= 10 ? R.mipmap.bc2 : i <= 30 ? R.mipmap.bc3: i <= 50 ? R.mipmap.bc4 : i <= 80 ? R.mipmap.bc5 : i <= 100 ? R.mipmap.ba6:R.mipmap.bc6;
    }
    public static int getZjbattery(int i) {
        return i == 0 ? R.mipmap.bb1 : i <= 10 ? R.mipmap.bb2 : i <= 30 ? R.mipmap.bb3: i <= 50 ? R.mipmap.bb4 : i <= 80 ? R.mipmap.bb5 : i <= 100 ? R.mipmap.ba6:R.mipmap.bb6;
    }
    public static int getTtbattert(int i) {
        return i == 0 ? R.mipmap.ba1 : i <= 10 ? R.mipmap.ba2 : i <= 30 ? R.mipmap.ba3: i <= 50 ? R.mipmap.ba4 : i <= 80 ? R.mipmap.ba5 : i <= 100 ? R.mipmap.ba6:R.mipmap.ba6;
    }
    /* renamed from: a */
    public static void m5161a(final Context context, Intent intent, final TextView textView, final TextView textView2) {
        if (textView != null) {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1 && intExtra2 != -1) {
                final float f = (((float) intExtra) / ((float) intExtra2)) * 100.0f;
                textView.post(new Runnable() {
                    public void run() {
                        textView.setBackgroundResource(C1104a.m5160a((int) f));
                        textView.setText(((int) f) + "%");
                        if (f <= 10.0f) {
                            textView.setTextColor(context.getResources().getColor(R.color.imageRed));
                            textView2.setTextColor(context.getResources().getColor(R.color.imageRed));
                            return;
                        }
                        textView.setTextColor(context.getResources().getColor(R.color.white));
                        textView2.setTextColor(context.getResources().getColor(R.color.colorText));
                    }
                });
            }
        }
    }

    /* renamed from: b */
    public static int m5162b(final Context context, Intent intent, final TextView textView, final TextView textView2) {
        final int intExtra = intent.getIntExtra("batteryNum", -10000);
        if (!(intExtra == -10000 || textView == null)) {
            textView.post(new Runnable() {
                public void run() {
                    textView.setBackgroundResource(C1104a.m5160a(intExtra));
                    textView.setText(intExtra + "%");
                    if (intExtra <= 10) {
                        textView.setTextColor(context.getResources().getColor(R.color.imageRed));
                        textView2.setTextColor(context.getResources().getColor(R.color.imageRed));
                        return;
                    }
                    textView.setTextColor(context.getResources().getColor(R.color.white));
                    textView2.setTextColor(context.getResources().getColor(R.color.colorText));
                }
            });
        }
        return intExtra;
    }
}
