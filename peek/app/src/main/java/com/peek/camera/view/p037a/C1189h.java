package com.peek.camera.view.p037a;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.peek.camera.R;
import com.peek.camera.model.PipeDefectDetail;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bmw.peek2.view.a.h */
public class C1189h extends RecyclerView.Adapter<C1189h.C1192b> {

    /* renamed from: a */
    private Context f3234a;

    /* renamed from: b */
    private List<PipeDefectDetail> f3235b;

    /* renamed from: c */
    private List<Boolean> f3236c;

    /* renamed from: d */
    private int f3237d = -1;

    /* renamed from: e */
    private C1191a f3238e;



    /* renamed from: com.bmw.peek2.view.a.h$a */
    public interface C1191a {
        /* renamed from: a */
        void mo5038a(int i);
    }

    /* renamed from: com.bmw.peek2.view.a.h$b */
    public class C1192b extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */

        /* renamed from: m */
        public TextView f3242m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public TextView f3243n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public TextView f3244o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public LinearLayout f3245p;

        public C1192b(View view) {
            super(view);
            this.f3242m = (TextView) view.findViewById(R.id.picture_edit_item_leixing);
            this.f3243n = (TextView) view.findViewById(R.id.picture_edit_item_quexianName);
            this.f3244o = (TextView) view.findViewById(R.id.picture_edit_item_dengji);
            this.f3245p = (LinearLayout) view.findViewById(R.id.picture_edit_item_container);
        }
    }

    public C1189h(Context context) {
        this.f3234a = context;
        this.f3235b = new ArrayList();
        this.f3236c = new ArrayList();
    }

    /* renamed from: a */
    private void m5488a(boolean z, C1192b bVar) {
        int color = z ? this.f3234a.getResources().getColor(R.color.colorText) : this.f3234a.getResources().getColor(17170444);
        bVar.f3242m.setTextColor(color);
        bVar.f3243n.setTextColor(color);
        bVar.f3244o.setTextColor(color);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5489d(int i) {
        if (i < this.f3236c.size()) {
            if (this.f3236c.get(i).booleanValue()) {
                this.f3236c.set(i, false);
                this.f3237d = -1;
            } else {
                for (int i2 = 0; i2 < this.f3236c.size(); i2++) {
                    this.f3236c.set(i2, false);
                }
                this.f3236c.set(i, true);
                this.f3237d = i;
            }
            notifyDataSetChanged();
            if (this.f3238e != null) {
                this.f3238e.mo5038a(this.f3237d);
            }
        }
    }
    @Override
    public int getItemCount() {
        return this.f3235b.size();
    }

    /* renamed from: a */
    public void mo5032a(C1191a aVar) {
        this.f3238e = aVar;
    }



    @NonNull
    @Override
    public C1192b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C1192b(LayoutInflater.from(this.f3234a).inflate(R.layout.picture_edit_item, (ViewGroup) null));
    }

    @Override
    public void onBindViewHolder(@NonNull C1192b bVar, final int i) {
        bVar.f3242m.setText(this.f3235b.get(i).getDefectType());
        bVar.f3243n.setText(this.f3235b.get(i).getDefectCode());
        bVar.f3244o.setText(this.f3235b.get(i).getDefectLevel());
        if (!this.f3236c.get(i).booleanValue()) {
            bVar.f3245p.setBackgroundColor(this.f3234a.getResources().getColor(R.color.nothing));
            m5488a(true, bVar);
        } else {
            bVar.f3245p.setBackgroundColor(this.f3234a.getResources().getColor(R.color.colorText));
            m5488a(false, bVar);
        }
        bVar.f3245p.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C1189h.this.m5489d(i);
            }
        });
    }

    /* renamed from: a */
    public void mo5034a(List<PipeDefectDetail> list) {
        if (list != null) {
            this.f3235b = list;
            this.f3236c.clear();
            for (int i = 0; i < list.size(); i++) {
                this.f3236c.add(false);
            }
            notifyDataSetChanged();
        }
    }


    /* renamed from: c */
    public void mo5036c(int i) {
        if (i >= 0 && i < this.f3235b.size()) {
            m5489d(i);
        }
    }
}
