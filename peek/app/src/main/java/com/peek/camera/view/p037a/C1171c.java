package com.peek.camera.view.p037a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.peek.camera.R;
import com.peek.camera.model.FileInfo;

import java.util.List;

/* renamed from: com.bmw.peek2.view.a.c */
public class C1171c extends BaseMAdapter<FileInfo> {

    /* renamed from: c */
    private int f3179c = 2;

    /* renamed from: com.bmw.peek2.view.a.c$a */
    static class C1172a {

        /* renamed from: a */
        ImageView f3180a;

        /* renamed from: b */
        ImageView f3181b;

        C1172a() {
        }
    }

    public C1171c(Context context, List<FileInfo> list, int i) {
        super(context, list);
        this.f3179c = i;
    }

    /* renamed from: a */
    public View mo4988a(int i, View view) {
        C1172a aVar;
        FileInfo fileInfo = (FileInfo) mo4989b().get(i);
        if (this.f3179c == 2) {
            if (view == null) {
                view = View.inflate(mo4987a(), R.layout.item_jpg, (ViewGroup) null);
                C1172a aVar2 = new C1172a();
                aVar2.f3181b = (ImageView) view.findViewById(R.id.iv_ok_tick);
                aVar2.f3180a = (ImageView) view.findViewById(R.id.iv_shortcut);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1172a) view.getTag();
            }
            if (!(mo4989b() == null || mo4989b().get(i) == null || fileInfo.getSize() <= 0)) {
//                C1757e.m6931b(mo4987a()).mo5942a(fileInfo.getFilePath()).mo5451a().mo5463b((int) R.mipmap.picture1).mo5472c().mo5461a(aVar.f3180a);
                Glide.with(mo4987a()).load(fileInfo.getFilePath()).error(R.mipmap.picture1).into(aVar.f3180a);
            }
        }
        return view;
    }
}
