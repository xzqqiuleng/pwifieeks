package com.peek.camera.view.p037a;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.peek.camera.R;
import com.peek.camera.model.PipeDefectImage;

import java.util.ArrayList;

/* renamed from: com.bmw.peek2.view.a.i */
public class C1193i extends RecyclerView.Adapter<C1193i.C1196b> {

    /* renamed from: a */
    private ArrayList<PipeDefectImage> f3246a = new ArrayList<>();

    /* renamed from: b */
    private Context f3247b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f3248c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1195a f3249d;





    /* renamed from: com.bmw.peek2.view.a.i$a */
    public interface C1195a {
        /* renamed from: a */
        void mo4587a(int i);
    }

    /* renamed from: com.bmw.peek2.view.a.i$b */
    public class C1196b extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */

        /* renamed from: m */
        public ImageView f3253m;

        /* renamed from: n */
        private RelativeLayout f3254n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public FrameLayout f3255o;

        public C1196b(View view) {
            super(view);
            this.f3253m = (ImageView) view.findViewById(R.id.img_quexianPic_item);
            this.f3254n = (RelativeLayout) view.findViewById(R.id.rl_container_quexianPic);
            this.f3255o = (FrameLayout) view.findViewById(R.id.fl_container_quexianPic_item);
        }
    }

    public C1193i(Context context) {
        this.f3247b = context;
    }

    @Override
    public int getItemCount() {
      return   this.f3246a.size();
    }


    /* renamed from: a */
    public void mo5039a(C1195a aVar) {
        this.f3249d = aVar;
    }

    /* renamed from: a */
    public void mo2827a(C1196b bVar, final int i) {
        if (this.f3248c == i) {
            bVar.f3255o.setBackgroundColor(this.f3247b.getResources().getColor(R.color.btn_press));
        } else {
            bVar.f3255o.setBackgroundColor(this.f3247b.getResources().getColor(R.color.nothing));
        }
        if (this.f3246a.get(i) != null) {

            Glide.with(this.f3247b).load(this.f3246a.get(i).getFilename()).into(bVar.f3253m);
        }
        if (this.f3249d != null) {
            bVar.f3255o.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    C1193i.this.f3249d.mo4587a(i);
                    int unused = C1193i.this.f3248c = i;
                }
            });
        }
    }
    @NonNull
    @Override
    public C1196b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C1196b(LayoutInflater.from(this.f3247b).inflate(R.layout.item_pic_quexian_list, (ViewGroup) null));
    }

    @Override
    public void onBindViewHolder(@NonNull C1196b bVar, final int i) {
        if (this.f3248c == i) {
            bVar.f3255o.setBackgroundColor(this.f3247b.getResources().getColor(R.color.btn_press));
        } else {
            bVar.f3255o.setBackgroundColor(this.f3247b.getResources().getColor(R.color.nothing));
        }
        if (this.f3246a.get(i) != null) {

            Glide.with(this.f3247b).load(this.f3246a.get(i).getFilename()).into(bVar.f3253m);
        }
        if (this.f3249d != null) {
            bVar.f3255o.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    C1193i.this.f3249d.mo4587a(i);
                    int unused = C1193i.this.f3248c = i;
                }
            });
        }
    }
    /* renamed from: a */
    public void mo5041a(ArrayList<PipeDefectImage> arrayList) {
        this.f3248c = -1;
        this.f3246a = arrayList;
        notifyDataSetChanged();
    }


    /* renamed from: c */
    public void mo5043c(int i) {
        this.f3248c = i;
        notifyDataSetChanged();
    }

    /* renamed from: d */
    public ArrayList<PipeDefectImage> mo5044d() {
        return this.f3246a;
    }
}
