package com.peek.camera.view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.hikvision.netsdk.HCNetSDK;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1155v;

import java.util.ArrayList;

public class CustomPotSeekBar extends View {

    /* renamed from: A */
    private int f4105A;

    /* renamed from: B */
    private ArrayList<Integer> f4106B;

    /* renamed from: C */
    private int f4107C;

    /* renamed from: D */
    private int f4108D;

    /* renamed from: E */
    private int f4109E;

    /* renamed from: F */
    private int f4110F;

    /* renamed from: G */
    private int f4111G;

    /* renamed from: H */
    private int f4112H;

    /* renamed from: I */
    private int f4113I;

    /* renamed from: J */
    private boolean f4114J;

    /* renamed from: K */
    private int f4115K;

    /* renamed from: a */
    private final String f4116a;

    /* renamed from: b */
    private int f4117b;

    /* renamed from: c */
    private int f4118c;

    /* renamed from: d */
    private int f4119d;

    /* renamed from: e */
    private int f4120e;

    /* renamed from: f */
    private int f4121f;

    /* renamed from: g */
    private int f4122g;

    /* renamed from: h */
    private int f4123h;

    /* renamed from: i */
    private int f4124i;

    /* renamed from: j */
    private float f4125j;

    /* renamed from: k */
    private int f4126k;

    /* renamed from: l */
    private Paint f4127l;

    /* renamed from: m */
    private Paint f4128m;

    /* renamed from: n */
    private Paint f4129n;

    /* renamed from: o */
    private Bitmap f4130o;

    /* renamed from: p */
    private Bitmap f4131p;

    /* renamed from: q */
    private Bitmap f4132q;

    /* renamed from: r */
    private int f4133r;

    /* renamed from: s */
    private int f4134s;

    /* renamed from: t */
    private C1507a f4135t;

    /* renamed from: u */
    private int f4136u;

    /* renamed from: v */
    private int f4137v;

    /* renamed from: w */
    private int[] f4138w;

    /* renamed from: x */
    private int f4139x;

    /* renamed from: y */
    private int f4140y;

    /* renamed from: z */
    private ArrayList<String> f4141z;

    /* renamed from: com.bmw.peek2.view.view.CustomPotSeekBar$a */
    public interface C1507a {
        /* renamed from: a */
        void mo4588a(int i);

        /* renamed from: b */
        void mo4589b(int i);
    }

    public CustomPotSeekBar(Context context) {
        super(context);
        this.f4116a = "CustomSeekBar";
        this.f4119d = 0;
        this.f4120e = 0;
        this.f4121f = 0;
        this.f4122g = 0;
        this.f4123h = 0;
        this.f4124i = 0;
        this.f4125j = 0.0f;
        this.f4126k = 0;
        this.f4133r = 100;
        this.f4134s = -1;
        this.f4136u = 38;
        this.f4137v = 60;
        this.f4138w = new int[]{-26368, 855638016};
        this.f4105A = 100;
        this.f4107C = 0;
        this.f4108D = -7829368;
        this.f4109E = -65536;
        this.f4110F = -26368;
        this.f4111G = -26368;
        this.f4112H = -26368;
        this.f4113I = 25;
    }

    public CustomPotSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPotSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4116a = "CustomSeekBar";
        this.f4119d = 0;
        this.f4120e = 0;
        this.f4121f = 0;
        this.f4122g = 0;
        this.f4123h = 0;
        this.f4124i = 0;
        this.f4125j = 0.0f;
        this.f4126k = 0;
        this.f4133r = 100;
        this.f4134s = -1;
        this.f4136u = 38;
        this.f4137v = 60;
        this.f4138w = new int[]{-26368, 855638016};
        this.f4105A = 100;
        this.f4107C = 0;
        this.f4108D = -7829368;
        this.f4109E = -65536;
        this.f4110F = -26368;
        this.f4111G = -26368;
        this.f4112H = -26368;
        this.f4113I = 25;
        this.f4134s = -1;
        this.f4130o = m6137a(this.f4113I, this.f4113I, this.f4109E);
        this.f4131p = m6137a(16, 16, this.f4108D);
        this.f4132q = m6137a(16, 16, this.f4110F);
        this.f4136u = 24;
        this.f4137v = this.f4136u + 22;
        this.f4139x = (int) TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics());
        this.f4140y = (int) TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
        this.f4127l = new Paint(4);
        this.f4127l.setAntiAlias(true);
        this.f4127l.setStrokeWidth(3.0f);
        this.f4128m = new Paint(4);
        this.f4128m.setAntiAlias(true);
        this.f4128m.setTextSize((float) this.f4139x);
        this.f4128m.setColor(this.f4111G);
        this.f4129n = new Paint(4);
        this.f4129n.setAntiAlias(true);
        this.f4129n.setColor(this.f4109E);
    }

    /* renamed from: a */
    private int m6135a(int i) {
        if (this.f4106B == null || this.f4106B.size() == 0) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f4106B.size()) {
                return -1;
            }
            int intValue = (int) ((((double) (this.f4117b - this.f4136u)) * (((double) this.f4106B.get(i3).intValue()) / ((double) this.f4105A))) + ((double) (this.f4136u / 2)));
            C1140n.m5266a("currentPlace: " + i + " potPlace = " + intValue);
            if (Math.abs(i - intValue) <= 100) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    /* renamed from: a */
    private int m6136a(int i, int i2) {
        if (i < this.f4136u / 2 || i > this.f4117b - (this.f4136u / 2)) {
            return -1;
        }
        int a = m6135a(i - (this.f4136u / 2));
        if (a != -1) {
            this.f4134s = a;
        }
        if (this.f4134s >= 0) {
            this.f4107C = this.f4106B.get(this.f4134s).intValue();
        }
        return a;
    }

    /* renamed from: a */
    private Bitmap m6137a(int i, int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i3);
        paint.setStyle(Paint.Style.FILL);
        new Canvas(createBitmap).drawCircle((float) (i / 2), (float) (i2 / 2), (float) Math.min(i / 2, i2 / 2), paint);
        return createBitmap;
    }

    /* renamed from: a */
    public void mo5360a(ArrayList<String> arrayList, ArrayList<Integer> arrayList2) {
        if (arrayList == null || arrayList2 == null) {
            String[] strArr = {"低", "中", "高"};
            Integer[] numArr = {0, 50, 100};
            this.f4141z = new ArrayList<>();
            this.f4106B = new ArrayList<>();
            for (int i = 0; i < strArr.length; i++) {
                this.f4141z.add(strArr[i]);
                this.f4106B.add(numArr[i]);
            }
        } else {
            this.f4141z = arrayList;
            this.f4106B = arrayList2;
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4127l.setColor(-1);
        this.f4127l.setStyle(Paint.Style.FILL);
        this.f4127l.setAlpha(0);
        canvas.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), this.f4127l);
        this.f4127l.setAlpha(HCNetSDK.STEP_SEARCH);
        this.f4127l.setColor(this.f4138w[1]);
        canvas.drawLine((float) this.f4136u, (float) ((this.f4118c * 2) / 3), (float) (this.f4117b - (this.f4136u / 2)), (float) ((this.f4118c * 2) / 3), this.f4127l);
        if (this.f4107C != 0) {
            this.f4127l.setColor(this.f4138w[0]);
            canvas.drawLine((float) (this.f4136u / 2), (float) ((this.f4118c * 2) / 3), (float) ((int) (((((double) this.f4107C) / ((double) this.f4105A)) * ((double) (this.f4117b - this.f4136u))) + ((double) (this.f4136u / 2)))), (float) ((this.f4118c * 2) / 3), this.f4127l);
        }
        if (this.f4106B != null && this.f4106B.size() > 0) {
            if (this.f4134s != -1) {
                int intValue = ((int) ((((double) this.f4106B.get(this.f4134s).intValue()) / ((double) this.f4105A)) * ((double) (this.f4117b - this.f4136u)))) + (this.f4136u / 2);
            }
            for (int i = 0; i < this.f4106B.size(); i++) {
                int intValue2 = (this.f4136u / 2) + ((int) (((double) (this.f4117b - this.f4136u)) * (((double) this.f4106B.get(i).intValue()) / ((double) this.f4105A))));
                if (this.f4107C < this.f4106B.get(i).intValue()) {
                    this.f4127l.setAlpha(HCNetSDK.STEP_SEARCH);
                    canvas.drawBitmap(this.f4131p, (float) (intValue2 - (this.f4132q.getWidth() / 2)), (float) (((this.f4118c * 2) / 3) - (this.f4131p.getHeight() / 2)), this.f4127l);
                } else {
                    this.f4127l.setColor(this.f4138w[0]);
                    canvas.drawBitmap(this.f4132q, (float) (intValue2 - (this.f4132q.getWidth() / 2)), (float) (((this.f4118c * 2) / 3) - (this.f4132q.getHeight() / 2)), this.f4127l);
                }
                if (i == this.f4134s) {
                    this.f4129n.setColor(this.f4109E);
                    canvas.drawBitmap(this.f4130o, (float) (intValue2 - (this.f4130o.getWidth() / 2)), (float) (((this.f4118c * 2) / 3) - (this.f4113I / 2)), this.f4129n);
                }
                String str = this.f4141z.get(i);
                if (!C1155v.m5330a(str)) {
                    canvas.drawText(str, (float) (intValue2 - (this.f4139x / 4)), (float) (((this.f4118c * 2) / 3) - this.f4137v), this.f4128m);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        this.f4117b = size;
        this.f4125j = Math.max((float) (size / 1080), (float) (size2 / 1920));
        this.f4118c = (int) TypedValue.applyDimension(1, 62.0f, getResources().getDisplayMetrics());
        setMeasuredDimension(this.f4117b, this.f4118c);
        this.f4117b = this.f4117b;
    }

    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 1:
                this.f4121f = (int) motionEvent.getX();
                this.f4122g = (int) motionEvent.getY();
                int a = m6136a(this.f4123h, this.f4124i);
                if (!(this.f4135t == null || a == -1)) {
                    if (this.f4114J) {
                        this.f4114J = false;
                    }
                    this.f4135t.mo4588a(this.f4134s);
                    this.f4115K = this.f4134s;
                    break;
                }
            case 2:
                this.f4123h = (int) motionEvent.getX();
                this.f4124i = (int) motionEvent.getY();
                break;
        }
        invalidate();
        return true;
    }

    public void setMax(int i) {
        this.f4105A = i;
    }

    public void setProgress(int i) {
        this.f4107C = i;
        if (this.f4106B != null && this.f4106B.size() > 0 && this.f4106B.get(0).intValue() > i) {
            this.f4134s = -1;
        }
        if (this.f4106B != null && this.f4106B.size() > 0) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f4106B.size(); i2++) {
                if (Math.abs(this.f4106B.get(i2).intValue() - i) <= 1500) {
                    this.f4134s = i2;
                    if (!this.f4114J) {
                        this.f4115K = this.f4134s;
                        if (this.f4135t != null) {
                            this.f4135t.mo4589b(this.f4134s);
                        }
                    } else if (this.f4115K != i2) {
                        this.f4114J = false;
                    }
                    z = true;
                }
            }
            if (!z) {
                this.f4134s = -1;
            }
        }
        if (i == 0) {
            this.f4134s = -1;
        }
        postInvalidate();
    }

    public void setResponseOnTouch(C1507a aVar) {
        this.f4135t = aVar;
    }

    public void setmIsNoShowOnThisSections(boolean z) {
        if (z && this.f4134s != -1) {
            this.f4114J = z;
        }
        if (!z && this.f4114J) {
            this.f4114J = z;
        }
    }
}
