package com.peek.camera.view.p037a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

/* renamed from: com.bmw.peek2.view.a.a */
public abstract class BaseMAdapter<T> extends BaseAdapter {

    /* renamed from: a */
    Context f3157a;

    /* renamed from: b */
    List<T> f3158b;

    public BaseMAdapter(Context context, List<T> list) {
        this.f3157a = context;
        this.f3158b = list;
    }

    /* renamed from: a */
    public Context mo4987a() {
        return this.f3157a;
    }

    /* renamed from: a */
    public abstract View mo4988a(int i, View view);

    /* renamed from: b */
    public List<T> mo4989b() {
        return this.f3158b;
    }

    public int getCount() {
        return this.f3158b.size();
    }

    public Object getItem(int i) {
        return this.f3158b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return mo4988a(i, view);
    }
}
