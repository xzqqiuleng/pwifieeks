package com.peek.camera.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class CustomerVideoView extends VideoView {
    public CustomerVideoView(Context context) {
        super(context);
    }

    public CustomerVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomerVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
    }
}
