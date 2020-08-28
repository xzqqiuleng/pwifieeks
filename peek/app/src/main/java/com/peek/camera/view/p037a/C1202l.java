package com.peek.camera.view.p037a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.peek.camera.R;

/* renamed from: com.bmw.peek2.view.a.l */
public class C1202l extends BaseAdapter {

    /* renamed from: a */
    public Context f3280a;

    /* renamed from: b */
    private String[] f3281b = new String[0];

    public C1202l(Context context) {
        this.f3280a = context;
    }

    /* renamed from: a */
    public String mo5060a(int i) {
        if (this.f3281b == null || i < 0 || i >= this.f3281b.length) {
            return null;
        }
        return this.f3281b[i];
    }

    /* renamed from: a */
    public void mo5061a(String[] strArr) {
        this.f3281b = strArr;
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f3281b.length;
    }

    public Object getItem(int i) {
        return this.f3281b[i];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view == null) {
            view = LayoutInflater.from(this.f3280a).inflate(R.layout.spinner_item, viewGroup, false);
            textView = (TextView) view.findViewById(R.id.spinner_itemName);
            view.setTag(textView);
        } else {
            textView = (TextView) view.getTag();
        }
        textView.setText(this.f3281b[i]);
        return view;
    }
}
