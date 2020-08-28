package com.peek.camera.view.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.peek.camera.R;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.view.p037a.C1202l;

@SuppressLint({"AppCompatCustomView"})
public class MySpinner extends TextView {

    /* renamed from: a */
    private Context f4153a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1202l f4154b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ListView f4155c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AdapterView.OnItemClickListener f4156d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public PopupWindow f4157e;

    /* renamed from: f */
    private int f4158f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f4159g;

    public MySpinner(Context context) {
        super(context);
        C1140n.m5266a("spinner MySpinner contruct!!!");
    }

    public MySpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4153a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MySpinner);
        this.f4158f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
    }

    public MySpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public static int m6154a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    /* renamed from: c */
    private void m6159c() {
        post(new Runnable() {
            public void run() {
                if (!MySpinner.this.f4159g) {
                    boolean unused = MySpinner.this.f4159g = true;
                    MySpinner.this.m6161d();
                    if (MySpinner.this.f4155c.getAdapter() == null && MySpinner.this.f4154b != null) {
                        MySpinner.this.f4155c.setAdapter(MySpinner.this.f4154b);
                    }
                    if (MySpinner.this.f4155c.getOnItemClickListener() == null && MySpinner.this.f4156d != null) {
                        MySpinner.this.f4155c.setOnItemClickListener(MySpinner.this.f4156d);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6161d() {
        View inflate = LayoutInflater.from(this.f4153a).inflate(R.layout.spinner_content, (ViewGroup) getParent(), false);
        this.f4155c = (ListView) inflate.findViewById(R.id.spinner_content);
        if (this.f4158f != 0) {
            this.f4157e = new PopupWindow(inflate, this.f4158f, -2);
            C1140n.m5267a("自定义view: ", this.f4158f);
        } else {
            this.f4157e = new PopupWindow(inflate, 500, -2);
        }
        this.f4157e.setContentView(inflate);
        this.f4157e.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        this.f4157e.setOutsideTouchable(true);
        inflate.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MySpinner.this.mo5379a();
            }
        });
        setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MySpinner.this.f4157e.isShowing()) {
                    MySpinner.this.mo5379a();
                    return;
                }
                InputMethodManager inputMethodManager = (InputMethodManager) MySpinner.this.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(MySpinner.this.getRootView().getWindowToken(), 0);
                }
                MySpinner.this.mo5380b();
            }
        });
        this.f4157e.update();
    }

    /* renamed from: a */
    public void mo5379a() {
        if (this.f4157e.isShowing()) {
            this.f4157e.dismiss();
        }
    }

    /* renamed from: b */
    public void mo5380b() {
        ViewGroup.LayoutParams layoutParams = this.f4155c.getLayoutParams();
        int a = this.f4154b.getCount() <= 5 ? m6154a(getContext(), 45.0f) * this.f4154b.getCount() : m6154a(getContext(), 45.0f) * 5;
        layoutParams.height = a;
        this.f4155c.setLayoutParams(layoutParams);
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        if (height - iArr[1] >= a + 50) {
            this.f4157e.showAsDropDown(this);
        } else {
            this.f4157e.showAtLocation(this, 0, iArr[0], iArr[1] - a);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f4158f = MeasureSpec.getSize(i);
        this.f4158f = getMeasuredWidth();
        if (this.f4158f != 0) {
            m6159c();
        }
    }

    public void setAdapter(C1202l lVar) {
        if (lVar != null) {
            this.f4154b = lVar;
            if (this.f4155c != null) {
                this.f4155c.setAdapter(this.f4154b);
            }
        }
    }

    public void setHint(String str) {
        setText(str);
    }

    public void setOnItemSelectedListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener != null) {
            this.f4156d = onItemClickListener;
            if (this.f4155c != null) {
                this.f4155c.setOnItemClickListener(onItemClickListener);
            }
        }
    }
}
