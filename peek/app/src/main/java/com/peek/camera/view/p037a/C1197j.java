package com.peek.camera.view.p037a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.peek.camera.R;


/* renamed from: com.bmw.peek2.view.a.j */
public class C1197j extends ArrayAdapter {

    /* renamed from: a */
    private LayoutInflater f3256a;

    /* renamed from: b */
    private int f3257b;

    /* renamed from: c */
    private int f3258c;

    /* renamed from: d */
    private String[] f3259d;

    public C1197j(Context context, int i, int i2, String[] strArr) {
        super(context, i, i2, strArr);
        this.f3257b = i;
        this.f3258c = i2;
        this.f3259d = strArr;
        this.f3256a = LayoutInflater.from(context);
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {

            view = this.f3256a.inflate(17367043, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(16908308);
        textView.setText(this.f3259d[i]);
        textView.setTextColor(getContext().getResources().getColor(R.color.colorText));
        return view;
    }
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f3256a.inflate(this.f3257b, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(this.f3258c);
        textView.setText(this.f3259d[i]);
        textView.setTextColor(getContext().getResources().getColor(R.color.colorText));
        return view;
    }
}
