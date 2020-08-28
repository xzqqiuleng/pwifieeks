package com.peek.camera.p034b;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.peek.camera.R;

/* renamed from: com.bmw.peek2.b.a */
public class C1104a {
    /* renamed from: a */
    public static int m5160a(int i) {
        return i == 0 ? R.drawable.ic_battery_0 : i <= 10 ? R.drawable.ic_battery_1 : i <= 20 ? R.drawable.ic_battery_2 : i <= 30 ? R.drawable.ic_battery_3 : i <= 40 ? R.drawable.ic_battery_4 : i <= 50 ? R.drawable.ic_battery_5 : i <= 60 ? R.drawable.ic_battery_6 : i <= 70 ? R.drawable.ic_battery_7 : i <= 80 ? R.drawable.ic_battery_8 : i <= 90 ? R.drawable.ic_battery_9 : R.drawable.ic_battery_10;
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
