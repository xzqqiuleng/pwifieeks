package com.peek.camera.view.p037a;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.p034b.C1129g;
import com.peek.camera.p034b.C1140n;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bmw.peek2.view.a.d */
public class C1173d extends RecyclerView.Adapter<C1173d.C1180b> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<File> f3182a;

    /* renamed from: b */
    private Context f3183b;

    /* renamed from: c */
    private boolean f3184c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f3185d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<Integer> f3186e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f3187f = -1;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C1179a f3188g;



    /* renamed from: com.bmw.peek2.view.a.d$a */
    public interface C1179a {
        /* renamed from: a */
        void mo4538a();

        /* renamed from: a */
        void mo4539a(int i);

        /* renamed from: a */
        void mo4540a(String str);

        /* renamed from: b */
        void mo4541b();
    }

    /* renamed from: com.bmw.peek2.view.a.d$b */
    public class C1180b extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */

        /* renamed from: m */
        public ImageView f3200m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public TextView f3201n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public LinearLayout f3202o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public ImageView f3203p;

        public C1180b(View view) {
            super(view);
            this.f3200m = (ImageView) view.findViewById(R.id.item_img);
            this.f3201n = (TextView) view.findViewById(R.id.item_text);
            this.f3202o = (LinearLayout) view.findViewById(R.id.item);
            this.f3203p = (ImageView) view.findViewById(R.id.item_choose);
        }
    }

    public C1173d(Context context, boolean z) {
        this.f3183b = context;
        this.f3184c = z;
        this.f3186e = new ArrayList();
        this.f3182a = new ArrayList();
    }

    /* renamed from: a */
    private void m5418a(String str) {
        if (this.f3184c) {
            File file = new File(str.substring(0, str.lastIndexOf(".")) + ".xml");
            if (file.exists()) {
                file.delete();
                C1129g.m5227a(file.getAbsolutePath());
            }
        }
    }

    /* renamed from: a */

    @Override
    public int getItemCount() {
        return this.f3182a.size();
    }
    /* renamed from: a */
    public void mo5001a(C1179a aVar) {
        this.f3188g = aVar;
    }





    @Override
    public void onBindViewHolder(@NonNull C1180b bVar, final int i) {
        bVar.f3200m.setTag(this.f3182a.get(i).getName());
        if (this.f3185d) {
            bVar.f3200m.setClickable(false);
            bVar.f3202o.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (C1173d.this.f3186e.contains(Integer.valueOf(i))) {
                        C1173d.this.f3186e.remove(C1173d.this.f3186e.indexOf(Integer.valueOf(i)));
                        if (C1173d.this.f3188g != null) {
                            C1173d.this.f3188g.mo4540a((String) null);
                        }
                        if (!(C1173d.this.f3186e.size() == C1173d.this.f3182a.size() || C1173d.this.f3188g == null)) {
                            C1173d.this.f3188g.mo4538a();
                            int unused = C1173d.this.f3187f = -1;
                        }
                        C1173d.this.notifyDataSetChanged();
                        return;
                    }
                    C1173d.this.f3186e.add(Integer.valueOf(i));
                    if (C1173d.this.f3188g != null) {
                        C1173d.this.f3188g.mo4540a(((File) C1173d.this.f3182a.get(i)).getAbsolutePath());
                        int unused2 = C1173d.this.f3187f = -1;
                    }
                    if (C1173d.this.f3186e.size() == C1173d.this.f3182a.size() && C1173d.this.f3188g != null) {
                        C1173d.this.f3188g.mo4541b();
                    }
                    C1173d.this.notifyDataSetChanged();
                }
            });
        }
        if (this.f3182a != null && this.f3182a.size() > 0) {
            if (!this.f3185d) {
                bVar.f3203p.setVisibility(View.GONE);
                if (this.f3187f == i) {
                    bVar.f3202o.setBackgroundColor(this.f3183b.getResources().getColor(R.color.btn_press));
                } else {
                    bVar.f3202o.setBackgroundColor(this.f3183b.getResources().getColor(R.color.nothing));
                }
            } else if (this.f3186e == null || !this.f3186e.contains(Integer.valueOf(i))) {
                bVar.f3203p.setVisibility(View.GONE);
                bVar.f3202o.setBackgroundColor(this.f3183b.getResources().getColor(R.color.nothing));
            } else {
                bVar.f3203p.setVisibility(View.VISIBLE);
                Log.d("FileListAdapter", "onBindViewHolder: " + i);
                bVar.f3202o.setBackgroundColor(this.f3183b.getResources().getColor(R.color.btn_press));
            }
        }
        if (this.f3184c) {
            String name = this.f3182a.get(i).getName();
            String substring = name.substring(0, name.indexOf("."));
            bVar.f3200m.setImageResource(R.mipmap.picture_item);
            bVar.f3201n.setText(substring);
        } else {
            bVar.f3200m.setImageResource(R.mipmap.video);
            String name2 = this.f3182a.get(i).getName();
            if (name2.indexOf(".") > 0) {
                name2 = name2.substring(0, name2.indexOf("."));
            }
            bVar.f3201n.setText(name2);
        }
        if (this.f3185d) {
            return;
        }
        if (this.f3184c) {
            bVar.f3202o.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    C1140n.m5266a("clicking porition = " + i);
                    int unused = C1173d.this.f3187f = i;
                    C1173d.this.notifyDataSetChanged();
                    if (C1173d.this.f3188g != null) {
                        C1173d.this.f3188g.mo4540a(((File) C1173d.this.f3182a.get(i)).getAbsolutePath());
                    }
                }
            });
            bVar.f3202o.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (C1173d.this.f3185d || C1173d.this.f3188g == null) {
                        return true;
                    }
                    C1173d.this.f3188g.mo4539a(i);
                    return true;
                }
            });
            return;
        }
        bVar.f3202o.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                Log.d("FileListAdapter", "onLongClick: ");
                if (C1173d.this.f3185d || C1173d.this.f3188g == null) {
                    return true;
                }
                C1173d.this.f3188g.mo4539a(i);
                return true;
            }
        });
        bVar.f3202o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int unused = C1173d.this.f3187f = i;
                if (C1173d.this.f3188g != null) {
                    C1173d.this.f3188g.mo4540a(((File) C1173d.this.f3182a.get(i)).getAbsolutePath());
                }
                int unused2 = C1173d.this.f3187f = i;
                C1173d.this.notifyDataSetChanged();
            }
        });
    }



    /* renamed from: a */
    public void mo5003a(List<File> list) {
        if (list != null) {
            this.f3182a = list;
        } else {
            this.f3182a = null;
            this.f3182a = new ArrayList();
        }
        this.f3187f = -1;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void mo5004a(boolean z) {
        this.f3185d = z;
        if (this.f3187f != -1) {
            this.f3186e.add(Integer.valueOf(this.f3187f));
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public C1180b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C1180b(LayoutInflater.from(this.f3183b).inflate(R.layout.file_item, (ViewGroup) null));
    }


    /* renamed from: c */
    public void mo5006c(int i) {
        this.f3186e.add(Integer.valueOf(i));
    }

    /* renamed from: d */
    public List<Integer> mo5007d() {
        return this.f3186e;
    }

    /* renamed from: e */
    public void mo5008e() {
        for (int i = 0; i < this.f3182a.size(); i++) {
            if (!this.f3186e.contains(Integer.valueOf(i))) {
                System.out.println("adapter:choose = " + i);
                this.f3186e.add(Integer.valueOf(i));
                System.out.println("adapter:choose = " + this.f3186e.toString() + " " + this.f3186e.size());
            }
        }
        notifyDataSetChanged();
        if (this.f3188g != null) {
            this.f3188g.mo4540a((String) null);
        }
    }

    /* renamed from: f */
    public void mo5009f() {
        this.f3186e.clear();
        this.f3187f = -1;
        notifyDataSetChanged();
        if (this.f3188g != null) {
            this.f3188g.mo4540a((String) null);
        }
    }

    /* renamed from: g */
    public int mo5010g() {
        Log.d("FileListAdapter", "deleteFile1: " + this.f3186e.toString());
        int size = this.f3186e.size();
        for (Integer next : this.f3186e) {
            m5418a(this.f3182a.get(next.intValue()).getAbsolutePath());
            this.f3182a.get(next.intValue()).delete();
            C1129g.m5227a(this.f3182a.get(next.intValue()).getAbsolutePath());
        }
        if (this.f3184c) {
            if (this.f3186e.size() == this.f3182a.size()) {
                BaseApplication.m4928b().edit().putInt("KEY_PICTURE_FILE_COUNT", 1).commit();
            }
        } else if (this.f3186e.size() == this.f3182a.size()) {
            BaseApplication.m4928b().edit().putInt("KEY_VIDEO_FILE_COUNT", 1).commit();
        }
        mo5009f();
        Log.d("FileListAdapter", "deleteFile: " + this.f3186e.toString());
        return size;
    }

    /* renamed from: h */
    public int mo5011h() {
        if (this.f3182a == null || this.f3182a.size() == 0) {
            return -1;
        }
        if (this.f3187f == 0) {
            this.f3187f = this.f3182a.size() - 1;
        } else {
            this.f3187f--;
        }
        notifyDataSetChanged();
        if (this.f3188g != null) {
            this.f3188g.mo4540a(this.f3182a.get(this.f3187f).getAbsolutePath());
        }
        return this.f3187f;
    }

    /* renamed from: i */
    public int mo5012i() {
        if (this.f3182a == null || this.f3182a.size() == 0) {
            return -1;
        }
        if (this.f3187f == this.f3182a.size() - 1) {
            this.f3187f = 0;
        } else {
            this.f3187f++;
        }
        notifyDataSetChanged();
        if (this.f3188g != null) {
            this.f3188g.mo4540a(this.f3182a.get(this.f3187f).getAbsolutePath());
        }
        return this.f3187f;
    }

    /* renamed from: j */
    public List<File> mo5013j() {
        return this.f3182a;
    }
}
