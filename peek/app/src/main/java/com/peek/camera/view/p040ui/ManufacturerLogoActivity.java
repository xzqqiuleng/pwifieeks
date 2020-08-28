package com.peek.camera.view.p040ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.model.FileInfo;
import com.peek.camera.p034b.C1129g;
import com.peek.camera.view.p037a.C1171c;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.List;

/* renamed from: com.bmw.peek2.view.ui.ManufacturerLogoActivity */
public class ManufacturerLogoActivity extends BaseActivity {
    @BindView(R.id.gv)

    /* renamed from: gv */
    GridView f3763gv;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C1171c f3764o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public List<FileInfo> f3765p;
    @BindView(R.id.pb_img)
    ProgressBar pbImg;

    /* renamed from: q */
    private Unbinder f3766q;

    /* renamed from: com.bmw.peek2.view.ui.ManufacturerLogoActivity$a */
    class C1379a extends AsyncTask<String, Integer, List<FileInfo>> {

        /* renamed from: a */
        Context f3768a = null;

        /* renamed from: b */
        List<FileInfo> f3769b = null;

        public C1379a(Context context) {
            this.f3768a = context;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public List doInBackground(String... strArr) {
            this.f3769b = C1129g.m5226a(this.f3768a, new String[]{FileInfo.EXTEND_JPG, FileInfo.EXTEND_JPEG, FileInfo.EXTEND_PNG});
            this.f3769b = C1129g.m5225a(this.f3768a, this.f3769b, 2);
            List unused = ManufacturerLogoActivity.this.f3765p = this.f3769b;
            return this.f3769b;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(List<FileInfo> list) {
            ManufacturerLogoActivity.this.m5885q();
            if (this.f3769b != null && this.f3769b.size() > 0) {
                C1171c unused = ManufacturerLogoActivity.this.f3764o = new C1171c(this.f3768a, this.f3769b, 2);
                ManufacturerLogoActivity.this.f3763gv.setAdapter(ManufacturerLogoActivity.this.f3764o);
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            ManufacturerLogoActivity.this.m5886r();
            super.onPreExecute();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m5885q() {
        if (this.pbImg != null) {
            this.pbImg.setVisibility(View.GONE);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m5886r() {
        if (this.pbImg != null) {
            this.pbImg.setVisibility(View.VISIBLE);
        }
    }

    /* access modifiers changed from: protected */

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_manufacturer_logo);
        this.f3766q = ButterKnife.bind((Activity) this);
        this.f3763gv.setColumnWidth(6);
        this.f3763gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                intent.putExtra("IMG_PATH_FLAG", ((FileInfo) ManufacturerLogoActivity.this.f3765p.get(i)).getFilePath());
                ManufacturerLogoActivity.this.setResult(119, intent);
                ManufacturerLogoActivity.this.finish();
            }
        });
        new C1379a(getApplicationContext()).executeOnExecutor(BaseApplication.f2900c, new String[0]);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f3766q.unbind();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }
}
