package com.peek.camera.view.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.peek.camera.R;


public class CompositeImageText extends FrameLayout {

    /* renamed from: a */
    private ImageView f4089a;

    /* renamed from: b */
    private TextView f4090b;

    /* renamed from: c */
    private int f4091c;

    /* renamed from: d */
    private int f4092d;

    /* renamed from: e */
    private int f4093e;

    /* renamed from: f */
    private int f4094f;

    /* renamed from: g */
    private int f4095g;

    /* renamed from: h */
    private int f4096h;

    /* renamed from: i */
    private int f4097i;

    /* renamed from: j */
    private int f4098j;

    /* renamed from: k */
    private int f4099k;

    /* renamed from: l */
    private int f4100l;

    /* renamed from: m */
    private int f4101m;

    /* renamed from: n */
    private int f4102n;

    /* renamed from: o */
    private int f4103o;

    /* renamed from: p */
    private String f4104p;

    public CompositeImageText(Context context) {
        super(context);
        m6133a(context);
    }

    public CompositeImageText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6134a(context, attributeSet);
        m6133a(context);
    }

    public CompositeImageText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6134a(context, attributeSet);
        m6133a(context);
    }

    /* renamed from: a */
    private void m6133a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.composite_image_text, this, true);
        this.f4089a = (ImageView) findViewById(R.id.compositeImageText_img);
        this.f4090b = (TextView) findViewById(R.id.compositeImageText_tv);
        this.f4089a.setImageResource(this.f4101m);
        this.f4089a.setPadding(this.f4091c, this.f4093e, this.f4092d, this.f4094f);
        LayoutParams layoutParams = new LayoutParams(this.f4099k, this.f4100l);
        layoutParams.setMargins(this.f4095g, this.f4097i, this.f4096h, this.f4098j);
        layoutParams.gravity = 1;
        this.f4089a.setLayoutParams(layoutParams);
        this.f4090b.setText(this.f4104p);
        this.f4090b.setTextColor(this.f4103o);
        this.f4090b.setTextSize(0, (float) this.f4102n);
    }

    /* renamed from: a */
    @SuppressLint("ResourceType")
    private void m6134a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CompositeImageText);
        this.f4094f = 0;
        this.f4093e = 0;
        this.f4091c = 0;
        this.f4092d = 0;
        this.f4098j = 0;
        this.f4097i = 0;
        this.f4095g = 0;
        this.f4096h = 0;
        this.f4099k = 20;
        this.f4100l = 20;
//        this.f4101m = obtainStyledAttributes.getResourceId(1, R.mipmap.ic_launcher);
        this.f4102n = 12;
        this.f4103o = obtainStyledAttributes.getColor(R.styleable.CompositeImageText_textColor, -256);
        this.f4104p = obtainStyledAttributes.getString(R.styleable.CompositeImageText_textString);
        this.f4101m = obtainStyledAttributes.getResourceId(R.styleable.CompositeImageText_imgImage, R.mipmap.ic_launcher);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setImage(int i) {
        if (this.f4089a != null) {
            this.f4089a.setImageResource(i);
        }
    }

    public void setText(String str) {
        if (this.f4090b != null) {
            this.f4090b.setText(str);
        }
    }

    public void setTextColor(int i) {
        if (this.f4090b != null) {
            this.f4090b.setTextColor(getResources().getColor(i));
        }
    }

    public void setTextSize(int i) {
        if (this.f4090b != null) {
            this.f4090b.setTextSize((float) i);
        }
    }
}
