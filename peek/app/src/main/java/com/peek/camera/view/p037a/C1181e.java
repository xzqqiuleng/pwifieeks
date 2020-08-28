package com.peek.camera.view.p037a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.peek.camera.R;

import java.io.File;
import java.util.List;

/* renamed from: com.bmw.peek2.view.a.e */
public class C1181e extends RecyclerView.Adapter<C1181e.C1184b> {

    /* renamed from: a */
    private Context f3204a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<File> f3205b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f3206c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1183a f3207d;




    /* renamed from: com.bmw.peek2.view.a.e$a */
    public interface C1183a {
        /* renamed from: a */
        void mo5024a(String str);
    }

    /* renamed from: com.bmw.peek2.view.a.e$b */
    public class C1184b extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */

        /* renamed from: m */
        public ImageView f3211m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public TextView f3212n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public LinearLayout f3213o;

        public C1184b(View view) {
            super(view);
            this.f3211m = (ImageView) view.findViewById(R.id.item_img);
            this.f3212n = (TextView) view.findViewById(R.id.item_text);
            this.f3213o = (LinearLayout) view.findViewById(R.id.item);
        }
    }

    public C1181e(Context context, List<File> list) {
        this.f3204a = context;
        this.f3205b = list;
    }
    @Override
    public int getItemCount() {
        return this.f3205b.size();
    }


    /* renamed from: a */
    public void mo5019a(C1183a aVar) {
        this.f3207d = aVar;


    }
    @NonNull
    @Override
    public C1184b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C1184b(LayoutInflater.from(this.f3204a).inflate(R.layout.kanban_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull C1184b bVar, final int i) {
        if (this.f3205b != null && this.f3205b.size() > 0) {
            if (this.f3206c == i) {
                bVar.f3213o.setBackgroundColor(this.f3204a.getResources().getColor(R.color.btn_press));
            } else {
                bVar.f3213o.setBackgroundColor(this.f3204a.getResources().getColor(R.color.nothing));
            }
        }
        bVar.f3211m.setImageResource(R.mipmap.video);
        bVar.f3212n.setText(this.f3205b.get(i).getName());
        bVar.f3213o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int unused = C1181e.this.f3206c = i;
                if (C1181e.this.f3207d != null) {
                    C1181e.this.f3207d.mo5024a(((File) C1181e.this.f3205b.get(i)).getAbsolutePath());
                }
                C1181e.this.notifyDataSetChanged();
            }
        });
    }


    /* renamed from: d */
    public void mo5022d() {
        if (this.f3206c != -1) {
            String absolutePath = this.f3205b.get(this.f3206c).getAbsolutePath();
            File file = new File(absolutePath);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(absolutePath + "_index");
            if (file2.exists()) {
                file2.delete();
            }
            File file3 = new File(absolutePath + ".avi");
            if (file3.exists()) {
                file3.delete();
            }
            this.f3205b.remove(this.f3206c);
            this.f3206c = -1;
            notifyDataSetChanged();
        }
    }
}
