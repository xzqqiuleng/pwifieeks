package com.peek.camera.view.p037a;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.model.Environment;
import com.peek.camera.view.p038b.C1221e;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bmw.peek2.view.a.b */
public class C1166b extends RecyclerView.Adapter<C1166b.C1170b> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<Environment> f3159a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f3160b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1221e f3161c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1169a f3162d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f3163e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f3164f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f3165g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f3166h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public SharedPreferences f3167i;


    /* renamed from: com.bmw.peek2.view.a.b$a */
    public interface C1169a {
        /* renamed from: a */
        void mo5000a();
    }

    /* renamed from: com.bmw.peek2.view.a.b$b */
    public class C1170b extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */

        /* renamed from: m */
        public ImageView f3172m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public TextView f3173n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public TextView f3174o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public TextView f3175p;
        /* access modifiers changed from: private */

        /* renamed from: q */
        public TextView f3176q;
        /* access modifiers changed from: private */

        /* renamed from: r */
        public TextView f3177r;
        /* access modifiers changed from: private */

        /* renamed from: s */
        public TextView f3178s;

        public C1170b(View view) {
            super(view);
            this.f3172m = (ImageView) view.findViewById(R.id.stat_img);
            this.f3173n = (TextView) view.findViewById(R.id.name);
            this.f3174o = (TextView) view.findViewById(R.id.current_num);
            this.f3175p = (TextView) view.findViewById(R.id.min_num);
            this.f3176q = (TextView) view.findViewById(R.id.max_num);
            this.f3177r = (TextView) view.findViewById(R.id.stat);
            this.f3178s = (TextView) view.findViewById(R.id.item_set);
        }
    }

    public C1166b(Context context) {
        this.f3160b = context;
        this.f3167i = BaseApplication.m4928b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5386a(String str) {
        Toast.makeText(this.f3160b, str, Toast.LENGTH_SHORT).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5387a(String str, float f, float f2) {
        SharedPreferences.Editor edit = this.f3167i.edit();
        edit.putFloat(Environment.QIYA_MIN, f);
        edit.putFloat(Environment.QIYA_MAX, f2);
        edit.commit();
    }

    /* renamed from: a */


    @Override
    public int getItemCount() {
        return this.f3159a.size();
    }

    /* renamed from: a */
    public void mo4994a(C1169a aVar) {
        this.f3162d = aVar;
    }



    @NonNull
    @Override
    public C1170b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C1170b(LayoutInflater.from(this.f3160b).inflate(R.layout.environment_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull C1170b bVar, final int i) {
        Environment environment = this.f3159a.get(i);
        bVar.f3173n.setText(environment.getName());
        bVar.f3175p.setText(String.valueOf(environment.getMin_num()));
        bVar.f3176q.setText(String.valueOf(environment.getMax_num()));
        bVar.f3174o.setText(String.valueOf(environment.getCurrent_num()));
        if (environment.getCurrent_num() < environment.getMin_num()) {
            bVar.f3172m.setImageResource(R.drawable.circle_red);
            bVar.f3177r.setText(this.f3160b.getString(R.string.tooLow));
            bVar.f3177r.setTextColor(-65536);
        } else if (environment.getCurrent_num() > environment.getMax_num()) {
            bVar.f3172m.setImageResource(R.drawable.circle_red);
            bVar.f3177r.setText(this.f3160b.getString(R.string.tooHigh));
            bVar.f3177r.setTextColor(-65536);
        } else {
            bVar.f3172m.setImageResource(R.drawable.circle_green);
            bVar.f3177r.setText(this.f3160b.getString(R.string.normal));
            bVar.f3177r.setTextColor(-16711936);
        }
        bVar.f3178s.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String unused = C1166b.this.f3163e = ((Environment) C1166b.this.f3159a.get(i)).getName();
                if (C1166b.this.f3163e.equals(C1166b.this.f3160b.getString(R.string.airPressure))) {
                    float unused2 = C1166b.this.f3165g = C1166b.this.f3167i.getFloat(Environment.QIYA_MIN, 0.0f);
                    float unused3 = C1166b.this.f3166h = C1166b.this.f3167i.getFloat(Environment.QIYA_MAX, 16.48f);
                    String unused4 = C1166b.this.f3164f = "PSI";
                }
                C1221e unused5 = C1166b.this.f3161c = new C1221e(C1166b.this.f3160b, C1166b.this.f3163e, C1166b.this.f3164f, C1166b.this.f3165g, C1166b.this.f3166h);
                C1166b.this.f3161c.mo5085a((C1221e.C1223a) new C1221e.C1223a() {
                    /* renamed from: a */
                    public void mo4999a(String str, String str2) {
                        if (str.equals("") || str2.equals("")) {
                            C1166b.this.m5386a("输入值不能为空！请重新输入！");
                            return;
                        }
                        float floatValue = Float.valueOf(str).floatValue();
                        float floatValue2 = Float.valueOf(str2).floatValue();
                        float round = ((float) Math.round(floatValue * 100.0f)) / 100.0f;
                        float round2 = ((float) Math.round(floatValue2 * 100.0f)) / 100.0f;
                        if (round > round2) {
                            C1166b.this.m5386a("输入值格式错误！请重新输入！");
                            return;
                        }
                        C1166b.this.m5387a(C1166b.this.f3163e, round, round2);
                        C1166b.this.f3161c.mo5084a();
                        if (C1166b.this.f3162d != null) {
                            C1166b.this.f3162d.mo5000a();
                        }
                    }
                });
            }
        });
    }

    /* renamed from: a */
    public void mo4996a(List<Environment> list) {
        this.f3159a = list;
        notifyDataSetChanged();
    }


}