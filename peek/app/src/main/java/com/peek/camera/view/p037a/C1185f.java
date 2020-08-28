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

/* renamed from: com.bmw.peek2.view.a.f */
public class C1185f extends RecyclerView.Adapter<C1185f.C1186a> {

    /* renamed from: a */
    private ArrayList<PipeDefectDetail> f3214a = new ArrayList<>();

    /* renamed from: b */
    private Context f3215b;





    /* renamed from: com.bmw.peek2.view.a.f$a */
    public class C1186a extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */

        /* renamed from: m */
        public TextView f3217m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public TextView f3218n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public TextView f3219o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public TextView f3220p;
        /* access modifiers changed from: private */

        /* renamed from: q */
        public TextView f3221q;
        /* access modifiers changed from: private */

        /* renamed from: r */
        public TextView f3222r;
        /* access modifiers changed from: private */

        /* renamed from: s */
        public TextView f3223s;

        public C1186a(View view) {
            super(view);
            this.f3217m = (TextView) view.findViewById(R.id.tv_item_xuhao);
            this.f3218n = (TextView) view.findViewById(R.id.tv_item_quexianStyle);
            this.f3219o = (TextView) view.findViewById(R.id.tv_item_quexianName);
            this.f3220p = (TextView) view.findViewById(R.id.tv_item_quexianGrade);
            this.f3221q = (TextView) view.findViewById(R.id.tv_item_quexianDistance);
            this.f3222r = (TextView) view.findViewById(R.id.tv_item_quexianClock);
            this.f3223s = (TextView) view.findViewById(R.id.tv_item_quexianLength);
        }
    }

    public C1185f(Context context) {
        this.f3215b = context;
    }
    @Override
    public int getItemCount() {
        return this.f3214a.size();
    }
    /* renamed from: a */



    @NonNull
    @Override
    public C1186a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C1186a(LayoutInflater.from(this.f3215b).inflate(R.layout.item_pic_quexian_show, (ViewGroup) null));
    }

    @Override
    public void onBindViewHolder(@NonNull C1186a aVar, int i) {
        aVar.f3217m.setText(String.valueOf(i + 1));
        PipeDefectDetail pipeDefectDetail = this.f3214a.get(i);
        if (!C1155v.m5330a(pipeDefectDetail.getDefectType())) {
            aVar.f3218n.setText(pipeDefectDetail.getDefectType());
        }
        if (!C1155v.m5330a(pipeDefectDetail.getDefectCode())) {
            aVar.f3219o.setText(pipeDefectDetail.getDefectCode());
        }
        if (!C1155v.m5330a(pipeDefectDetail.getDefectLevel())) {
            aVar.f3220p.setText(pipeDefectDetail.getDefectLevel());
        }
        if (!C1155v.m5330a(pipeDefectDetail.getDistance())) {
            aVar.f3221q.setText(pipeDefectDetail.getDistance());
        }
        if (!C1155v.m5330a(pipeDefectDetail.getClockExpression())) {
            aVar.f3222r.setText(pipeDefectDetail.getClockExpression());
        }
        if (!C1155v.m5330a(pipeDefectDetail.getDefectLength())) {
            aVar.f3223s.setText(pipeDefectDetail.getDefectLength());
        }
    }
    /* renamed from: a */
    public void mo5026a(ArrayList<PipeDefectDetail> arrayList) {
        this.f3214a = arrayList;
        notifyDataSetChanged();
    }


    /* renamed from: d */
    public void mo5028d() {
        this.f3214a = new ArrayList<>();
        notifyDataSetChanged();
    }
}
