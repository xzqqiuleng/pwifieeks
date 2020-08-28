package com.peek.camera.view.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.SDKError;
import com.peek.camera.R;
import com.peek.camera.p034b.C1126d;

public class SwitchButton extends CompoundButton {

    /* renamed from: a */
    private static int[] f4163a = {16842912, 16842910, 16842919};

    /* renamed from: b */
    private static int[] f4164b = {-16842912, 16842910, 16842919};

    /* renamed from: A */
    private Paint f4165A;

    /* renamed from: B */
    private boolean f4166B;

    /* renamed from: C */
    private boolean f4167C;

    /* renamed from: D */
    private boolean f4168D = false;

    /* renamed from: E */
    private ObjectAnimator f4169E;

    /* renamed from: F */
    private float f4170F;

    /* renamed from: G */
    private RectF f4171G;

    /* renamed from: H */
    private float f4172H;

    /* renamed from: I */
    private float f4173I;

    /* renamed from: J */
    private float f4174J;

    /* renamed from: K */
    private int f4175K;

    /* renamed from: L */
    private int f4176L;

    /* renamed from: M */
    private Paint f4177M;

    /* renamed from: N */
    private CharSequence f4178N;

    /* renamed from: O */
    private CharSequence f4179O;

    /* renamed from: P */
    private TextPaint f4180P;

    /* renamed from: Q */
    private Layout f4181Q;

    /* renamed from: R */
    private Layout f4182R;

    /* renamed from: S */
    private float f4183S;

    /* renamed from: T */
    private float f4184T;

    /* renamed from: U */
    private float f4185U;

    /* renamed from: V */
    private boolean f4186V = true;

    /* renamed from: W */
    private OnCheckedChangeListener f4187W;

    /* renamed from: c */
    private Drawable f4188c;

    /* renamed from: d */
    private Drawable f4189d;

    /* renamed from: e */
    private ColorStateList f4190e;

    /* renamed from: f */
    private ColorStateList f4191f;

    /* renamed from: g */
    private float f4192g;

    /* renamed from: h */
    private float f4193h;

    /* renamed from: i */
    private RectF f4194i;

    /* renamed from: j */
    private float f4195j;

    /* renamed from: k */
    private long f4196k;

    /* renamed from: l */
    private boolean f4197l;

    /* renamed from: m */
    private int f4198m;

    /* renamed from: n */
    private PointF f4199n;

    /* renamed from: o */
    private int f4200o;

    /* renamed from: p */
    private int f4201p;

    /* renamed from: q */
    private int f4202q;

    /* renamed from: r */
    private int f4203r;

    /* renamed from: s */
    private int f4204s;

    /* renamed from: t */
    private Drawable f4205t;

    /* renamed from: u */
    private Drawable f4206u;

    /* renamed from: v */
    private RectF f4207v;

    /* renamed from: w */
    private RectF f4208w;

    /* renamed from: x */
    private RectF f4209x;

    /* renamed from: y */
    private RectF f4210y;

    /* renamed from: z */
    private RectF f4211z;

    /* renamed from: com.bmw.peek2.view.view.SwitchButton$a */
    static class C1515a extends BaseSavedState {
        public static final Creator<C1515a> CREATOR = new Creator<C1515a>() {
            /* renamed from: a */
            public C1515a createFromParcel(Parcel parcel) {
                return new C1515a(parcel);
            }

            /* renamed from: a */
            public C1515a[] newArray(int i) {
                return new C1515a[i];
            }
        };

        /* renamed from: a */
        CharSequence f4212a;

        /* renamed from: b */
        CharSequence f4213b;

        private C1515a(Parcel parcel) {
            super(parcel);
            this.f4212a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f4213b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        C1515a(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f4212a, parcel, i);
            TextUtils.writeToParcel(this.f4213b, parcel, i);
        }
    }

    public SwitchButton(Context context) {
        super(context);
        m6170a((AttributeSet) null);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6170a(attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6170a(attributeSet);
    }

    /* renamed from: a */
    private int m6166a(double d) {
        return (int) Math.ceil(d);
    }

    /* renamed from: a */
    private int m6167a(int i) {
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int a = m6166a((double) (this.f4199n.x * this.f4195j));
        if (this.f4167C) {
            a = Math.max(a, this.f4189d.getMinimumWidth());
        }
        float width = this.f4181Q != null ? (float) this.f4181Q.getWidth() : 0.0f;
        float width2 = this.f4182R != null ? (float) this.f4182R.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.f4183S = 0.0f;
        } else {
            this.f4183S = Math.max(width, width2) + (this.f4185U * 2.0f);
            float f = ((float) a) - this.f4199n.x;
            if (f < this.f4183S) {
                a = (int) (((float) a) + (this.f4183S - f));
            }
        }
        int max = Math.max(a, m6166a((double) (((float) a) + this.f4194i.left + this.f4194i.right)));
        int max2 = Math.max(Math.max(max, getPaddingLeft() + max + getPaddingRight()), getSuggestedMinimumWidth());
        return mode == 1073741824 ? Math.max(max2, size) : mode == Integer.MIN_VALUE ? Math.min(max2, size) : max2;
    }

    /* renamed from: a */
    private Layout m6168a(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.f4180P, (int) Math.ceil((double) Layout.getDesiredWidth(charSequence, this.f4180P)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    /* renamed from: a */
    private void m6169a() {
        float f = 0.0f;
        float paddingTop = ((float) getPaddingTop()) + Math.max(0.0f, this.f4194i.top);
        float paddingLeft = ((float) getPaddingLeft()) + Math.max(0.0f, this.f4194i.left);
        if (!(this.f4181Q == null || this.f4182R == null || this.f4194i.top + this.f4194i.bottom <= 0.0f)) {
            paddingTop += (((((float) ((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop())) - this.f4199n.y) - this.f4194i.top) - this.f4194i.bottom) / 2.0f;
        }
        if (this.f4166B) {
            this.f4199n.x = Math.max(this.f4199n.x, (float) this.f4188c.getMinimumWidth());
            this.f4199n.y = Math.max(this.f4199n.y, (float) this.f4188c.getMinimumHeight());
        }
        this.f4207v.set(paddingLeft, paddingTop, this.f4199n.x + paddingLeft, this.f4199n.y + paddingTop);
        float f2 = this.f4207v.left - this.f4194i.left;
        float min = Math.min(0.0f, ((Math.max(this.f4199n.x * this.f4195j, this.f4199n.x + this.f4183S) - this.f4207v.width()) - this.f4183S) / 2.0f);
        float min2 = Math.min(0.0f, (((this.f4207v.height() + this.f4194i.top) + this.f4194i.bottom) - this.f4184T) / 2.0f);
        this.f4208w.set(f2 + min, (this.f4207v.top - this.f4194i.top) + min2, (((f2 + this.f4194i.left) + Math.max(this.f4199n.x * this.f4195j, this.f4199n.x + this.f4183S)) + this.f4194i.right) - min, (this.f4207v.bottom + this.f4194i.bottom) - min2);
        this.f4209x.set(this.f4207v.left, 0.0f, (this.f4208w.right - this.f4194i.right) - this.f4207v.width(), 0.0f);
        this.f4193h = Math.min(Math.min(this.f4208w.width(), this.f4208w.height()) / 2.0f, this.f4193h);
        if (this.f4189d != null) {
            this.f4189d.setBounds((int) this.f4208w.left, (int) this.f4208w.top, m6166a((double) this.f4208w.right), m6166a((double) this.f4208w.bottom));
        }
        if (this.f4181Q != null) {
            float width = (this.f4194i.left < 0.0f ? this.f4194i.left * -0.5f : 0.0f) + ((((this.f4208w.width() - this.f4207v.width()) - this.f4194i.right) - ((float) this.f4181Q.getWidth())) / 2.0f) + this.f4208w.left;
            if (!this.f4167C && this.f4186V) {
                width += this.f4193h / 4.0f;
            }
            float height = this.f4208w.top + ((this.f4208w.height() - ((float) this.f4181Q.getHeight())) / 2.0f);
            this.f4210y.set(width, height, ((float) this.f4181Q.getWidth()) + width, ((float) this.f4181Q.getHeight()) + height);
        }
        if (this.f4182R != null) {
            float width2 = (this.f4208w.right - ((((this.f4208w.width() - this.f4207v.width()) - this.f4194i.left) - ((float) this.f4182R.getWidth())) / 2.0f)) - ((float) this.f4182R.getWidth());
            if (this.f4194i.right < 0.0f) {
                f = this.f4194i.right * 0.5f;
            }
            float f3 = width2 + f;
            if (!this.f4167C && this.f4186V) {
                f3 -= this.f4193h / 4.0f;
            }
            float height2 = this.f4208w.top + ((this.f4208w.height() - ((float) this.f4182R.getHeight())) / 2.0f);
            this.f4211z.set(f3, height2, ((float) this.f4182R.getWidth()) + f3, ((float) this.f4182R.getHeight()) + height2);
        }
    }

    /* renamed from: a */
    private void m6170a(AttributeSet attributeSet) {
        ColorStateList colorStateList;
        Drawable drawable;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i;
        String str;
        float f7;
        Drawable drawable2;
        boolean z;
        float f8;
        float f9;
        ColorStateList colorStateList2;
        int i2;
        boolean z2;
        float f10;
        String str2;
        float f11;
        float f12;
        this.f4175K = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f4176L = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.f4165A = new Paint(1);
        this.f4177M = new Paint(1);
        this.f4177M.setStyle(Paint.Style.STROKE);
        this.f4177M.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.f4180P = getPaint();
        this.f4207v = new RectF();
        this.f4208w = new RectF();
        this.f4209x = new RectF();
        this.f4199n = new PointF();
        this.f4194i = new RectF();
        this.f4210y = new RectF();
        this.f4211z = new RectF();
        this.f4169E = ObjectAnimator.ofFloat(this, "process", new float[]{0.0f, 0.0f}).setDuration(250);
        this.f4169E.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f4171G = new RectF();
        float f13 = getResources().getDisplayMetrics().density;
        float f14 = f13 * 2.0f;
        float f15 = f13 * 20.0f;
        float f16 = f13 * 20.0f;
        float f17 = (20.0f * f13) / 2.0f;
        float f18 = f13 * 2.0f;
        TypedArray obtainStyledAttributes = attributeSet == null ? null : getContext().obtainStyledAttributes(attributeSet, R.styleable.SwitchButton);
        if (obtainStyledAttributes != null) {
            Drawable drawable3 = obtainStyledAttributes.getDrawable(11);
            ColorStateList colorStateList3 = obtainStyledAttributes.getColorStateList(10);
            float dimension = obtainStyledAttributes.getDimension(13, f14);
            float dimension2 = obtainStyledAttributes.getDimension(15, dimension);
            float dimension3 = obtainStyledAttributes.getDimension(16, dimension);
            float dimension4 = obtainStyledAttributes.getDimension(17, dimension);
            float dimension5 = obtainStyledAttributes.getDimension(14, dimension);
            float dimension6 = obtainStyledAttributes.getDimension(19, f15);
            float dimension7 = obtainStyledAttributes.getDimension(12, f16);
            float dimension8 = obtainStyledAttributes.getDimension(18, Math.min(dimension6, dimension7) / 2.0f);
            float dimension9 = obtainStyledAttributes.getDimension(5, (2.0f * f13) + dimension8);
            Drawable drawable4 = obtainStyledAttributes.getDrawable(3);
            ColorStateList colorStateList4 = obtainStyledAttributes.getColorStateList(2);
            float f19 = obtainStyledAttributes.getFloat(4, 1.8f);
            int integer = obtainStyledAttributes.getInteger(0, SDKError.NET_DVR_ERROR_DEVICE_NOT_ACTIVATED);
            boolean z3 = obtainStyledAttributes.getBoolean(6, true);
            int color = obtainStyledAttributes.getColor(20, 0);
            String string = obtainStyledAttributes.getString(9);
            String string2 = obtainStyledAttributes.getString(8);
            float dimension10 = obtainStyledAttributes.getDimension(7, Math.max(f18, dimension9 / 2.0f));
            boolean z4 = obtainStyledAttributes.getBoolean(1, true);
            obtainStyledAttributes.recycle();
            drawable = drawable3;
            colorStateList = colorStateList3;
            f2 = dimension2;
            f = dimension3;
            f4 = dimension4;
            f3 = dimension5;
            f6 = dimension8;
            colorStateList2 = colorStateList4;
            i2 = color;
            z2 = z4;
            float f20 = dimension9;
            i = integer;
            str = string2;
            f7 = dimension6;
            f5 = f20;
            boolean z5 = z3;
            f8 = dimension10;
            f9 = dimension7;
            drawable2 = drawable4;
            z = z5;
            float f21 = f19;
            str2 = string;
            f10 = f21;
        } else {
            colorStateList = null;
            drawable = null;
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            f4 = 0.0f;
            f5 = f17;
            f6 = f17;
            i = 250;
            str = null;
            f7 = f15;
            drawable2 = null;
            z = true;
            f8 = f18;
            f9 = f16;
            colorStateList2 = null;
            i2 = 0;
            z2 = true;
            f10 = 1.8f;
            str2 = null;
        }
        TypedArray obtainStyledAttributes2 = attributeSet == null ? null : getContext().obtainStyledAttributes(attributeSet, new int[]{16842970, 16842981});
        if (obtainStyledAttributes2 != null) {
            boolean z6 = obtainStyledAttributes2.getBoolean(0, true);
            boolean z7 = obtainStyledAttributes2.getBoolean(1, z6);
            setFocusable(z6);
            setClickable(z7);
            obtainStyledAttributes2.recycle();
        }
        this.f4178N = str2;
        this.f4179O = str;
        this.f4185U = f8;
        this.f4186V = z2;
        this.f4188c = drawable;
        this.f4191f = colorStateList;
        this.f4166B = this.f4188c != null;
        this.f4198m = i2;
        if (this.f4198m == 0) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true)) {
                this.f4198m = typedValue.data;
            } else {
                this.f4198m = 3309506;
            }
        }
        if (!this.f4166B && this.f4191f == null) {
            this.f4191f = C1126d.m5215a(this.f4198m);
            this.f4200o = this.f4191f.getDefaultColor();
        }
        if (this.f4166B) {
            float max = Math.max(f7, (float) this.f4188c.getMinimumWidth());
            f11 = Math.max(f9, (float) this.f4188c.getMinimumHeight());
            f12 = max;
        } else {
            f11 = f9;
            f12 = f7;
        }
        this.f4199n.set(f12, f11);
        this.f4189d = drawable2;
        this.f4190e = colorStateList2;
        this.f4167C = this.f4189d != null;
        if (!this.f4167C && this.f4190e == null) {
            this.f4190e = C1126d.m5216b(this.f4198m);
            this.f4201p = this.f4190e.getDefaultColor();
            this.f4202q = this.f4190e.getColorForState(f4163a, this.f4201p);
        }
        this.f4194i.set(f2, f4, f, f3);
        this.f4195j = this.f4194i.width() >= 0.0f ? Math.max(f10, 1.0f) : f10;
        this.f4192g = f6;
        this.f4193h = f5;
        this.f4196k = (long) i;
        this.f4197l = z;
        this.f4169E.setDuration(this.f4196k);
        if (isChecked()) {
            setProcess(1.0f);
        }
    }

    /* renamed from: b */
    private int m6171b(int i) {
        int i2;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int a = m6166a((double) Math.max(this.f4199n.y, this.f4199n.y + this.f4194i.top + this.f4194i.right));
        float height = this.f4181Q != null ? (float) this.f4181Q.getHeight() : 0.0f;
        float height2 = this.f4182R != null ? (float) this.f4182R.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.f4184T = 0.0f;
            i2 = a;
        } else {
            this.f4184T = Math.max(height, height2);
            i2 = m6166a((double) Math.max((float) a, this.f4184T));
        }
        int max = Math.max(i2, getSuggestedMinimumHeight());
        int max2 = Math.max(max, getPaddingTop() + max + getPaddingBottom());
        return mode == 1073741824 ? Math.max(max2, size) : mode == Integer.MIN_VALUE ? Math.min(max2, size) : max2;
    }

    /* renamed from: b */
    private void m6172b() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean getStatusBasedOnPos() {
        return getProcess() > 0.5f;
    }

    private void setDrawableState(Drawable drawable) {
        if (drawable != null) {
            drawable.setState(getDrawableState());
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo5389a(float f, float f2) {
        this.f4199n.set(f, f2);
        m6169a();
        requestLayout();
    }

    /* renamed from: a */
    public void mo5390a(float f, float f2, float f3, float f4) {
        this.f4194i.set(f, f2, f3, f4);
        requestLayout();
    }

    /* renamed from: a */
    public void mo5391a(CharSequence charSequence, CharSequence charSequence2) {
        this.f4178N = charSequence;
        this.f4179O = charSequence2;
        this.f4181Q = null;
        this.f4182R = null;
        requestLayout();
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5392a(boolean z) {
        if (this.f4169E != null) {
            if (this.f4169E.isRunning()) {
                this.f4169E.cancel();
            }
            this.f4169E.setDuration(this.f4196k);
            if (z) {
                this.f4169E.setFloatValues(new float[]{this.f4170F, 1.0f});
            } else {
                this.f4169E.setFloatValues(new float[]{this.f4170F, 0.0f});
            }
            this.f4169E.start();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f4166B || this.f4191f == null) {
            setDrawableState(this.f4188c);
        } else {
            this.f4200o = this.f4191f.getColorForState(getDrawableState(), this.f4200o);
        }
        int[] iArr = isChecked() ? f4164b : f4163a;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.f4203r = textColors.getColorForState(f4163a, defaultColor);
            this.f4204s = textColors.getColorForState(f4164b, defaultColor);
        }
        if (this.f4167C || this.f4190e == null) {
            if (!(this.f4189d instanceof StateListDrawable) || !this.f4197l) {
                this.f4206u = null;
            } else {
                this.f4189d.setState(iArr);
                this.f4206u = this.f4189d.getCurrent().mutate();
            }
            setDrawableState(this.f4189d);
            if (this.f4189d != null) {
                this.f4205t = this.f4189d.getCurrent().mutate();
                return;
            }
            return;
        }
        this.f4201p = this.f4190e.getColorForState(getDrawableState(), this.f4201p);
        this.f4202q = this.f4190e.getColorForState(iArr, this.f4201p);
    }

    public long getAnimationDuration() {
        return this.f4196k;
    }

    public ColorStateList getBackColor() {
        return this.f4190e;
    }

    public Drawable getBackDrawable() {
        return this.f4189d;
    }

    public float getBackMeasureRatio() {
        return this.f4195j;
    }

    public float getBackRadius() {
        return this.f4193h;
    }

    public PointF getBackSizeF() {
        return new PointF(this.f4208w.width(), this.f4208w.height());
    }

    public final float getProcess() {
        return this.f4170F;
    }

    public ColorStateList getThumbColor() {
        return this.f4191f;
    }

    public Drawable getThumbDrawable() {
        return this.f4188c;
    }

    public float getThumbHeight() {
        return this.f4199n.y;
    }

    public RectF getThumbMargin() {
        return this.f4194i;
    }

    public float getThumbRadius() {
        return this.f4192g;
    }

    public PointF getThumbSizeF() {
        return this.f4199n;
    }

    public float getThumbWidth() {
        return this.f4199n.x;
    }

    public int getTintColor() {
        return this.f4198m;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4167C) {
            if (!this.f4197l || this.f4205t == null || this.f4206u == null) {
                this.f4189d.setAlpha(HCNetSDK.STEP_SEARCH);
                this.f4189d.draw(canvas);
            } else {
                int process = (int) ((isChecked() ? getProcess() : 1.0f - getProcess()) * 255.0f);
                this.f4205t.setAlpha(process);
                this.f4205t.draw(canvas);
                this.f4206u.setAlpha(255 - process);
                this.f4206u.draw(canvas);
            }
        } else if (this.f4197l) {
            int process2 = (int) ((isChecked() ? getProcess() : 1.0f - getProcess()) * 255.0f);
            this.f4165A.setARGB((Color.alpha(this.f4201p) * process2) / HCNetSDK.STEP_SEARCH, Color.red(this.f4201p), Color.green(this.f4201p), Color.blue(this.f4201p));
            canvas.drawRoundRect(this.f4208w, this.f4193h, this.f4193h, this.f4165A);
            this.f4165A.setARGB(((255 - process2) * Color.alpha(this.f4202q)) / HCNetSDK.STEP_SEARCH, Color.red(this.f4202q), Color.green(this.f4202q), Color.blue(this.f4202q));
            canvas.drawRoundRect(this.f4208w, this.f4193h, this.f4193h, this.f4165A);
            this.f4165A.setAlpha(HCNetSDK.STEP_SEARCH);
        } else {
            this.f4165A.setColor(this.f4201p);
            canvas.drawRoundRect(this.f4208w, this.f4193h, this.f4193h, this.f4165A);
        }
        Layout layout = ((double) getProcess()) > 0.5d ? this.f4181Q : this.f4182R;
        RectF rectF = ((double) getProcess()) > 0.5d ? this.f4210y : this.f4211z;
        if (!(layout == null || rectF == null)) {
            int process3 = (int) ((((double) getProcess()) >= 0.75d ? (getProcess() * 4.0f) - 3.0f : ((double) getProcess()) < 0.25d ? 1.0f - (getProcess() * 4.0f) : 0.0f) * 255.0f);
            int i = ((double) getProcess()) > 0.5d ? this.f4203r : this.f4204s;
            layout.getPaint().setARGB((process3 * Color.alpha(i)) / HCNetSDK.STEP_SEARCH, Color.red(i), Color.green(i), Color.blue(i));
            canvas.save();
            canvas.translate(rectF.left, rectF.top);
            layout.draw(canvas);
            canvas.restore();
        }
        this.f4171G.set(this.f4207v);
        this.f4171G.offset(this.f4170F * this.f4209x.width(), 0.0f);
        if (this.f4166B) {
            this.f4188c.setBounds((int) this.f4171G.left, (int) this.f4171G.top, m6166a((double) this.f4171G.right), m6166a((double) this.f4171G.bottom));
            this.f4188c.draw(canvas);
        } else {
            this.f4165A.setColor(this.f4200o);
            canvas.drawRoundRect(this.f4171G, this.f4192g, this.f4192g, this.f4165A);
        }
        if (this.f4168D) {
            this.f4177M.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.f4208w, this.f4177M);
            this.f4177M.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.f4171G, this.f4177M);
            this.f4177M.setColor(Color.parseColor("#00CC00"));
            canvas.drawRect(((double) getProcess()) > 0.5d ? this.f4210y : this.f4211z, this.f4177M);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f4181Q == null && this.f4178N != null) {
            this.f4181Q = m6168a(this.f4178N);
        }
        if (this.f4182R == null && this.f4179O != null) {
            this.f4182R = m6168a(this.f4179O);
        }
        setMeasuredDimension(m6167a(i), m6171b(i2));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        C1515a aVar = (C1515a) parcelable;
        mo5391a(aVar.f4212a, aVar.f4213b);
        super.onRestoreInstanceState(aVar.getSuperState());
    }

    public Parcelable onSaveInstanceState() {
        C1515a aVar = new C1515a(super.onSaveInstanceState());
        aVar.f4212a = this.f4178N;
        aVar.f4213b = this.f4179O;
        return aVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            m6169a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !isClickable() || !isFocusable()) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX() - this.f4172H;
        float y = motionEvent.getY() - this.f4173I;
        switch (action) {
            case 0:
                m6172b();
                this.f4172H = motionEvent.getX();
                this.f4173I = motionEvent.getY();
                this.f4174J = this.f4172H;
                setPressed(true);
                return true;
            case 1:
            case 3:
                setPressed(false);
                boolean statusBasedOnPos = getStatusBasedOnPos();
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (x < ((float) this.f4175K) && y < ((float) this.f4175K) && eventTime < ((float) this.f4176L)) {
                    performClick();
                    return true;
                } else if (statusBasedOnPos != isChecked()) {
                    playSoundEffect(0);
                    setChecked(statusBasedOnPos);
                    return true;
                } else {
                    mo5392a(statusBasedOnPos);
                    return true;
                }
            case 2:
                float x2 = motionEvent.getX();
                setProcess(getProcess() + ((x2 - this.f4174J) / this.f4209x.width()));
                this.f4174J = x2;
                return true;
            default:
                return true;
        }
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void setAnimationDuration(long j) {
        this.f4196k = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.f4190e = colorStateList;
        if (this.f4190e != null) {
            setBackDrawable((Drawable) null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.f4189d = drawable;
        this.f4167C = this.f4189d != null;
        m6169a();
        refreshDrawableState();
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackMeasureRatio(float f) {
        this.f4195j = f;
        requestLayout();
    }

    public void setBackRadius(float f) {
        this.f4193h = f;
        if (!this.f4167C) {
            invalidate();
        }
    }

    public void setChecked(boolean z) {
        if (isChecked() != z) {
            mo5392a(z);
        }
        super.setChecked(z);
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        if (this.f4169E != null && this.f4169E.isRunning()) {
            this.f4169E.cancel();
        }
        setProcess(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.f4187W == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener((OnCheckedChangeListener) null);
        setCheckedImmediately(z);
        setOnCheckedChangeListener(this.f4187W);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.f4187W == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener((OnCheckedChangeListener) null);
        setChecked(z);
        setOnCheckedChangeListener(this.f4187W);
    }

    public void setDrawDebugRect(boolean z) {
        this.f4168D = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.f4197l = z;
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.f4187W = onCheckedChangeListener;
    }

    public final void setProcess(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.f4170F = f;
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.f4191f = colorStateList;
        if (this.f4191f != null) {
            setThumbDrawable((Drawable) null);
        }
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList( i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f4188c = drawable;
        this.f4166B = this.f4188c != null;
        m6169a();
        refreshDrawableState();
        requestLayout();
        invalidate();
    }

    public void setThumbDrawableRes(int i) {
        setThumbDrawable(getResources().getDrawable( i));
    }

    public void setThumbMargin(RectF rectF) {
        if (rectF == null) {
            mo5390a(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            mo5390a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    public void setThumbRadius(float f) {
        this.f4192g = f;
        if (!this.f4166B) {
            invalidate();
        }
    }

    public void setThumbSize(PointF pointF) {
        if (pointF == null) {
            float f = getResources().getDisplayMetrics().density * 20.0f;
            mo5389a(f, f);
            return;
        }
        mo5389a(pointF.x, pointF.y);
    }

    public void setTintColor(int i) {
        this.f4198m = i;
        this.f4191f = C1126d.m5215a(this.f4198m);
        this.f4190e = C1126d.m5216b(this.f4198m);
        this.f4167C = false;
        this.f4166B = false;
        refreshDrawableState();
        invalidate();
    }
}
