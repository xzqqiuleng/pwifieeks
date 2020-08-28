package com.peek.camera.view.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.peek.camera.R;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.view.p037a.C1202l;


public class EditSpinner extends TextInputEditText {

    /* renamed from: a */
    private Context f4142a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1202l f4143b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ListView f4144c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AdapterView.OnItemClickListener f4145d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AdapterView.OnItemLongClickListener f4146e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public PopupWindow f4147f;

    /* renamed from: g */
    private int f4148g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f4149h;

    public EditSpinner(Context context) {
        super(context);
    }

    public EditSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4142a = context;
    }

    public EditSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public static int m6141a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    /* renamed from: c */
    private void m6146c() {
        post(new Runnable() {
            public void run() {
                if (!EditSpinner.this.f4149h) {
                    boolean unused = EditSpinner.this.f4149h = true;
                    EditSpinner.this.m6148d();
                    if (EditSpinner.this.f4144c.getAdapter() == null && EditSpinner.this.f4143b != null) {
                        EditSpinner.this.f4144c.setAdapter(EditSpinner.this.f4143b);
                    }
                    if (EditSpinner.this.f4144c.getOnItemClickListener() == null && EditSpinner.this.f4145d != null) {
                        EditSpinner.this.f4144c.setOnItemClickListener(EditSpinner.this.f4145d);
                    }
                    if (EditSpinner.this.f4144c.getOnItemLongClickListener() == null && EditSpinner.this.f4146e != null) {
                        EditSpinner.this.f4144c.setOnItemLongClickListener(EditSpinner.this.f4146e);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6148d() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f4142a).inflate(R.layout.spinner_content, (ViewGroup) null);
        this.f4144c = (ListView) linearLayout.findViewById(R.id.spinner_content);
        if (this.f4148g != 0) {
            this.f4147f = new PopupWindow(linearLayout, this.f4148g, -2);
            C1140n.m5267a("自定义view: ", this.f4148g);
        } else {
            this.f4147f = new PopupWindow(linearLayout, 500, -2);
        }
        this.f4147f.setBackgroundDrawable(new BitmapDrawable());
        this.f4147f.setOutsideTouchable(true);
        this.f4147f.setOutsideTouchable(true);
        this.f4147f.setTouchable(true);
        linearLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                EditSpinner.this.mo5371b();
            }
        });
        setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1 || !TextUtils.isEmpty(EditSpinner.this.getText().toString())) {
                    return false;
                }
                if (EditSpinner.this.f4147f.isShowing()) {
                    EditSpinner.this.mo5371b();
                    return false;
                }
                EditSpinner.this.mo5370a();
                return false;
            }
        });
        this.f4147f.update();
    }

    /* renamed from: a */
    public void mo5370a() {
        if (this.f4143b != null) {
            ViewGroup.LayoutParams layoutParams = this.f4144c.getLayoutParams();
            int a = this.f4143b.getCount() <= 5 ? m6141a(getContext(), 45.0f) * this.f4143b.getCount() : m6141a(getContext(), 45.0f) * 5;
            layoutParams.height = a;
            this.f4144c.setLayoutParams(layoutParams);
            @SuppressLint("WrongConstant") WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            windowManager.getDefaultDisplay().getWidth();
            int height = windowManager.getDefaultDisplay().getHeight();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (height - iArr[1] >= a) {
                this.f4147f.showAsDropDown(this);
            } else {
                this.f4147f.showAtLocation(this, 0, iArr[0], iArr[1] - a);
            }
        }
    }

    /* renamed from: b */
    public void mo5371b() {
        if (this.f4147f.isShowing()) {
            this.f4147f.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f4148g = MeasureSpec.getSize(i);
        this.f4148g = getWidth();
        if (this.f4148g != 0) {
            m6146c();
        }
    }

    public void setAdapter(C1202l lVar) {
        if (lVar != null) {
            this.f4143b = lVar;
            if (this.f4144c != null) {
                this.f4144c.setAdapter(this.f4143b);
            }
        }
    }

    public void setOnItemLongSelectecListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener != null) {
            this.f4146e = onItemLongClickListener;
            if (this.f4144c != null) {
                this.f4144c.setOnItemLongClickListener(onItemLongClickListener);
            }
        }
    }

    public void setOnItemSelectedListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener != null) {
            this.f4145d = onItemClickListener;
            if (this.f4144c != null) {
                this.f4144c.setOnItemClickListener(onItemClickListener);
            }
        }
    }
}
