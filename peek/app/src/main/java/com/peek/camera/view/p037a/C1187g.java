package com.peek.camera.view.p037a;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.peek.camera.R;
import com.peek.camera.model.PipeDefectDetail;
import com.peek.camera.p034b.C1155v;

import java.util.ArrayList;

/* renamed from: com.bmw.peek2.view.a.g */
public class C1187g extends RecyclerView.Adapter<C1187g.C1188a> {

    /* renamed from: a */
    private ArrayList<PipeDefectDetail> f3224a = new ArrayList<>();

    /* renamed from: b */
    private Context f3225b;





    /* renamed from: com.bmw.peek2.view.a.g$a */
    public class C1188a extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */

        /* renamed from: m */
        public TextView f3227m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public TextView f3228n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public TextView f3229o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public TextView f3230p;
        /* access modifiers changed from: private */

        /* renamed from: q */
        public TextView f3231q;
        /* access modifiers changed from: private */

        /* renamed from: r */
        public TextView f3232r;
        /* access modifiers changed from: private */

        /* renamed from: s */
        public TextView f3233s;

        public C1188a(View view) {
            super(view);
            this.f3227m = (TextView) view.findViewById(R.id.tv_item_xuhao);
            this.f3228n = (TextView) view.findViewById(R.id.tv_item_quexianStyle);
            this.f3229o = (TextView) view.findViewById(R.id.tv_item_quexianName);
            this.f3230p = (TextView) view.findViewById(R.id.tv_item_quexianGrade);
            this.f3231q = (TextView) view.findViewById(R.id.tv_item_quexianDistance);
            this.f3232r = (TextView) view.findViewById(R.id.tv_item_quexianClock);
            this.f3233s = (TextView) view.findViewById(R.id.tv_item_quexianLength);
        }
    }

    public C1187g(Context context) {
        this.f3225b = context;
    }


    @Override
    public int getItemCount() {
        return this.f3224a.size();
    }

    @NonNull
    @Override
    public C1188a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C1188a(LayoutInflater.from(this.f3225b).inflate(R.layout.item_pic_quexian_show_horizontal, (ViewGroup) null));
    }

    @Override
    public void onBindViewHolder(@NonNull C1188a aVar, int i) {
        aVar.f3227m.setText(String.valueOf(i + 1));
        PipeDefectDetail pipeDefectDetail = this.f3224a.get(i);
        if (!C1155v.m5330a(pipeDefectDetail.getDefectType())) {
            aVar.f3228n.setText(pipeDefectDetail.getDefectType());
        }
        if (!C1155v.m5330a(pipeDefectDetail.getDefectCode())) {
            aVar.f3229o.setText(pipeDefectDetail.getDefectCode());
        }
        if (!C1155v.m5330a(pipeDefectDetail.getDefectLevel())) {
            aVar.f3230p.setText(pipeDefectDetail.getDefectLevel());
        }
        if (!C1155v.m5330a(pipeDefectDetail.getDistance())) {
            aVar.f3231q.setText(pipeDefectDetail.getDistance());
        }
        if (!C1155v.m5330a(pipeDefectDetail.getClockExpression())) {
            aVar.f3232r.setText(pipeDefectDetail.getClockExpression());
        }
        if (!C1155v.m5330a(pipeDefectDetail.getDefectLength())) {
            aVar.f3233s.setText(pipeDefectDetail.getDefectLength());
        }
    }
    /* renamed from: a */
    public void mo5030a(ArrayList<PipeDefectDetail> arrayList) {
        this.f3224a = arrayList;
        notifyDataSetChanged();
    }

    /* renamed from: c */
}
