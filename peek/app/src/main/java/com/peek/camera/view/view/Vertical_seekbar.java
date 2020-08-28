package com.peek.camera.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.SeekBar;

public class Vertical_seekbar extends SeekBar {

    /* renamed from: a */
    private OnSeekBarChangeListener f4214a;

    public Vertical_seekbar(Context context) {
        super(context);
    }

    public Vertical_seekbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Vertical_seekbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m6179a(MotionEvent motionEvent) {
        setProgress(getMax() - ((int) ((((float) getMax()) * motionEvent.getY()) / ((float) getHeight()))));
        Log.i("Progress", getProgress() + "");
        onSizeChanged(getWidth(), getHeight(), 0, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5444a() {
        if (this.f4214a != null) {
            this.f4214a.onStopTrackingTouch(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5445a(SeekBar seekBar, int i, boolean z) {
        if (this.f4214a != null) {
            this.f4214a.onProgressChanged(seekBar, i, z);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.rotate(-90.0f);
        canvas.translate((float) (-getHeight()), 0.0f);
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i2, i, i4, i3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                m6179a(motionEvent);
                return true;
            case 1:
                m6179a(motionEvent);
                mo5444a();
                return true;
            case 2:
                m6179a(motionEvent);
                mo5445a(this, getProgress(), true);
                return true;
            case 3:
                mo5444a();
                return true;
            default:
                return true;
        }
    }

    public void setOnSeekBarChangeListener(OnSeekBarChangeListener onSeekBarChangeListener) {
        super.setOnSeekBarChangeListener(onSeekBarChangeListener);
        this.f4214a = onSeekBarChangeListener;
    }
}
