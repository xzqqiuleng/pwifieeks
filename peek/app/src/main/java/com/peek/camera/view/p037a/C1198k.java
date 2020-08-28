package com.peek.camera.view.p037a;

import android.annotation.SuppressLint;
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
import com.peek.camera.model.RecordTaskInfo;
import com.peek.camera.p034b.C1140n;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bmw.peek2.view.a.k */
public class C1198k extends RecyclerView.Adapter<C1198k.C1201b> {

    /* renamed from: a */
    private Context f3260a;

    /* renamed from: b */
    private List<RecordTaskInfo> f3261b;

    /* renamed from: c */
    private List<Boolean> f3262c;

    /* renamed from: d */
    private int f3263d = -1;

    /* renamed from: e */
    private C1200a f3264e;







    /* renamed from: com.bmw.peek2.view.a.k$a */
    public interface C1200a {
        /* renamed from: a */
        void mo5059a(int i);
    }

    /* renamed from: com.bmw.peek2.view.a.k$b */
    public class C1201b extends RecyclerView.ViewHolder{
        /* access modifiers changed from: private */

        /* renamed from: m */
        public TextView f3268m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public TextView f3269n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public TextView f3270o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public TextView f3271p;
        /* access modifiers changed from: private */

        /* renamed from: q */
        public TextView f3272q;
        /* access modifiers changed from: private */

        /* renamed from: r */
        public TextView f3273r;
        /* access modifiers changed from: private */

        /* renamed from: s */
        public TextView f3274s;
        /* access modifiers changed from: private */

        /* renamed from: t */
        public TextView f3275t;
        /* access modifiers changed from: private */

        /* renamed from: u */
        public TextView f3276u;
        /* access modifiers changed from: private */

        /* renamed from: v */
        public TextView f3277v;
        /* access modifiers changed from: private */

        /* renamed from: w */
        public TextView f3278w;
        /* access modifiers changed from: private */

        /* renamed from: x */
        public LinearLayout f3279x;

        public C1201b(View view) {
            super(view);
            this.f3268m = (TextView) view.findViewById(R.id.record_item_task_id);
            this.f3269n = (TextView) view.findViewById(R.id.record_item_task_name);
            this.f3270o = (TextView) view.findViewById(R.id.record_item_task_place);
            this.f3271p = (TextView) view.findViewById(R.id.record_item_task_start);
            this.f3272q = (TextView) view.findViewById(R.id.record_item_task_end);
            this.f3273r = (TextView) view.findViewById(R.id.record_item_task_direction);
            this.f3274s = (TextView) view.findViewById(R.id.record_item_task_sort);
            this.f3275t = (TextView) view.findViewById(R.id.record_item_task_guancai);
            this.f3276u = (TextView) view.findViewById(R.id.record_item_task_diameter);
            this.f3277v = (TextView) view.findViewById(R.id.record_item_task_computer);
            this.f3278w = (TextView) view.findViewById(R.id.record_item_task_people);
            this.f3279x = (LinearLayout) view.findViewById(R.id.record_item_container);
        }
    }

    public C1198k(Context context) {
        this.f3260a = context;
        this.f3261b = new ArrayList();
        this.f3262c = new ArrayList();
    }

    /* renamed from: a */
    private void m5518a(boolean z, C1201b bVar) {
        int color = z ? this.f3260a.getResources().getColor(R.color.colorText) : this.f3260a.getResources().getColor(17170444);
        bVar.f3268m.setTextColor(color);
        bVar.f3269n.setTextColor(color);
        bVar.f3270o.setTextColor(color);
        bVar.f3271p.setTextColor(color);
        bVar.f3272q.setTextColor(color);
        bVar.f3273r.setTextColor(color);
        bVar.f3274s.setTextColor(color);
        bVar.f3275t.setTextColor(color);
        bVar.f3276u.setTextColor(color);
        bVar.f3277v.setTextColor(color);
        bVar.f3278w.setTextColor(color);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m5519e(int i) {
        if (i < this.f3262c.size()) {
            if (this.f3262c.get(i).booleanValue()) {
                this.f3262c.set(i, false);
                this.f3263d = -1;
            } else {
                for (int i2 = 0; i2 < this.f3262c.size(); i2++) {
                    this.f3262c.set(i2, false);
                }
                this.f3262c.set(i, true);
                this.f3263d = i;
            }
            notifyDataSetChanged();
            if (this.f3264e != null) {
                this.f3264e.mo5059a(this.f3263d);
            }
        }
    }

    /* renamed from: f */
    private void m5520f(int i) {
        if (this.f3262c.size() != 0) {
            for (int i2 = 0; i2 < this.f3262c.size(); i2++) {
                this.f3262c.set(i2, false);
            }
            m5519e(i);
        }
    }
    @Override
    public int getItemCount() {
        return this.f3261b.size();
    }

    /* renamed from: a */
    public void mo5048a(C1200a aVar) {
        this.f3264e = aVar;
    }

    @Override
    public void onBindViewHolder(@NonNull C1201b bVar, @SuppressLint("RecyclerView") final int i) {
        bVar.f3268m.setText(this.f3261b.get(i).getTask_id());
        bVar.f3269n.setText(this.f3261b.get(i).getTask_name());
        bVar.f3270o.setText(this.f3261b.get(i).getTask_place());
        bVar.f3271p.setText(this.f3261b.get(i).getTask_start());
        bVar.f3272q.setText(this.f3261b.get(i).getTask_end());
        bVar.f3273r.setText(this.f3261b.get(i).getTask_direction());
        bVar.f3274s.setText(this.f3261b.get(i).getTask_sort());
        bVar.f3275t.setText(this.f3261b.get(i).getTask_guancai());
        bVar.f3276u.setText(this.f3261b.get(i).getTask_diameter());
        bVar.f3277v.setText(this.f3261b.get(i).getTask_computer());
        bVar.f3278w.setText(this.f3261b.get(i).getTask_people());
        if (!this.f3262c.get(i).booleanValue()) {
            bVar.f3279x.setBackgroundColor(this.f3260a.getResources().getColor(R.color.nothing));
            m5518a(true, bVar);
        } else {
            bVar.f3279x.setBackgroundColor(this.f3260a.getResources().getColor(R.color.colorText));
            m5518a(false, bVar);
        }
        bVar.f3279x.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C1198k.this.m5519e(i);
            }
        });
    }


    /* renamed from: a */
    public void mo5050a(List<RecordTaskInfo> list) {
        if (list != null) {
            this.f3261b = list;
            this.f3262c.clear();
            for (int i = 0; i < list.size(); i++) {
                this.f3262c.add(false);
            }
            notifyDataSetChanged();
        }
    }
    @NonNull
    @Override
    public C1201b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C1201b(LayoutInflater.from(this.f3260a).inflate(R.layout.dialog_record_item, (ViewGroup) null));
    }

    /* renamed from: c */
    public void mo5052c(int i) {
        if (i >= 0 && i < this.f3261b.size()) {
            m5519e(i);
        }
    }

    /* renamed from: d */
    public void mo5053d() {
        m5520f(0);
    }

    /* renamed from: d */
    public void mo5054d(int i) {
        C1140n.m5267a("recordHeadIdFind：comeId = ", i);
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.f3261b.size()) {
                    C1140n.m5267a("recordHeadIdFind：findId " + i3 + " = ", this.f3261b.get(i3).getId());
                    if (i == this.f3261b.get(i3).getId()) {
                        C1140n.m5267a("adapter：", i);
                        m5519e(i3);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: e */
    public void mo5055e() {
        m5520f(this.f3262c.size() - 1);
    }

    /* renamed from: f */
    public void mo5056f() {
        if (this.f3263d != -1) {
            if (this.f3263d == 0) {
                mo5055e();
            } else {
                m5520f(this.f3263d - 1);
            }
        }
    }

    /* renamed from: g */
    public void mo5057g() {
        if (this.f3263d != -1) {
            if (this.f3263d == this.f3262c.size() - 1) {
                mo5053d();
            } else {
                m5520f(this.f3263d + 1);
            }
        }
    }
}
