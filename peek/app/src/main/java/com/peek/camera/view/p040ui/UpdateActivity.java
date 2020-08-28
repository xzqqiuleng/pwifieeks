package com.peek.camera.view.p040ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.peek.camera.R;
import com.peek.camera.model.UpdateInfo;
import com.peek.camera.p032a.C1101f;
import com.peek.camera.p032a.p033a.C1082f;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1143p;
import com.peek.camera.p034b.C1159z;
import com.peek.camera.service.MyIntentService;
import com.peek.camera.view.p039c.C1238c;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import java.io.File;

/* renamed from: com.bmw.peek2.view.ui.UpdateActivity */
public class UpdateActivity extends BaseActivity {
    @BindView(R.id.updateActivity_content)
    TextView mContent;
    @BindView(R.id.update_progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.updateActivity_reCheck)
    Button mReCheckBtn;

    /* renamed from: o */
    private C1159z f4061o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f4062p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f4063q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public C1101f f4064r;

    /* renamed from: s */
    private Unbinder f4065s;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6112a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m6115a(UpdateInfo updateInfo) {
        String version = updateInfo.getVersion();
        if (!version.contains("V") || !version.contains("F")) {
            return false;
        }
        String substring = version.substring(version.indexOf("V") + 1, version.indexOf("F"));
        String substring2 = version.substring(version.indexOf("F") + 1, version.indexOf("D"));
        int intValue = Integer.valueOf(substring).intValue();
        int intValue2 = Integer.valueOf(substring2).intValue();
        String u = m6124u();
        String substring3 = u.substring(version.indexOf("V") + 1, version.indexOf("F"));
        String substring4 = u.substring(version.indexOf("F") + 1, version.indexOf("D"));
        int intValue3 = Integer.valueOf(substring3).intValue();
        int intValue4 = Integer.valueOf(substring4).intValue();
        C1140n.m5266a(" firstNum = " + intValue + " secondNum = " + intValue2 + " lfirst = " + intValue3 + " lsecond = " + intValue4);
        return intValue3 != intValue ? intValue3 < intValue : intValue4 < intValue2;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m6120e(final String str) {
        if (this.mContent != null) {
            runOnUiThread(new Runnable() {
                public void run() {
                    UpdateActivity.this.mContent.setText(str);
                }
            });
        }
    }

    /* renamed from: r */
    private void m6121r() {
        this.f4061o = new C1159z(this);
        this.f4061o.mo4682a(this.f4061o.mo4689f());
        MyIntentService.m5357a(mo5210l());
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m6122s() {
        this.f4062p = true;
        int a = C1143p.m5285a(this);
        this.f4062p = false;
        switch (a) {
            case 0:
                this.f4063q = true;
                m6123t();
                return;
            case 1:
                mo5113q();
                return;
            case 2:
                m6121r();
                mo5113q();
                return;
            default:
                return;
        }
    }

    /* renamed from: t */
    private void m6123t() {
        if (this.mContent != null) {
            runOnUiThread(new Runnable() {
                public void run() {
                    UpdateActivity.this.mContent.setText(UpdateActivity.this.getResources().getString(R.string.checkUpdateInfo));
                    C1101f unused = UpdateActivity.this.f4064r = new C1082f(new C1238c() {
                        /* renamed from: a */
                        public void mo5123a() {
                            boolean unused = UpdateActivity.this.f4063q = false;
                            if (UpdateActivity.this.mContent != null) {
                                UpdateActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        UpdateActivity.this.mContent.setText(UpdateActivity.this.getString(R.string.noInternet));
                                        UpdateActivity.this.mReCheckBtn.setText(UpdateActivity.this.getString(R.string.reTry));
                                        UpdateActivity.this.mReCheckBtn.setVisibility(View.VISIBLE);
                                    }
                                });
                            }
                        }

                        /* renamed from: a */
                        public void mo5124a(final int i) {
                            UpdateActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    if (UpdateActivity.this.mProgressBar != null) {
                                        UpdateActivity.this.mProgressBar.setProgress(i);
                                    }
                                }
                            });
                        }

                        /* renamed from: a */
                        public void mo5125a(UpdateInfo updateInfo) {
                            if (updateInfo == null) {
                                boolean unused = UpdateActivity.this.f4063q = false;
                                mo5123a();
                            } else if (UpdateActivity.this.m6115a(updateInfo)) {
                                UpdateActivity.this.m6120e(UpdateActivity.this.getResources().getString(R.string.updateToVersion) + updateInfo.getVersion() + "?\n\n更新信息：\n" + updateInfo.getDescription() + "");
                                UpdateActivity.this.mReCheckBtn.setText(UpdateActivity.this.getString(R.string.updateSure));
                                UpdateActivity.this.mReCheckBtn.setVisibility(View.VISIBLE);
                            } else {
                                UpdateActivity.this.m6120e(UpdateActivity.this.getString(R.string.noNeedUpdate));
                            }
                        }

                        /* renamed from: a */
                        public void mo5126a(String str) {
                            UpdateActivity.this.mo5345d(str);
                            UpdateActivity.this.mo5213o();
                        }

                        /* renamed from: b */
                        public void mo5127b() {
                            UpdateActivity.this.m6120e(UpdateActivity.this.getString(R.string.noNeedUpdate));
                        }
                    }, UpdateActivity.this, UpdateActivity.this.m6124u());
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public String m6124u() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return getString(R.string.noVersion);
        }
    }

    /* renamed from: v */
    private void m6125v() {
        final int[] iAsrr = {0};
        String string = getString(R.string.isCheckingInternet);
        final String[] strArr = {string + " . . .", string + " . .", string + " .", string + " . ."};
        this.f4062p = true;
        new Thread(new Runnable() {
            public void run() {
                UpdateActivity.this.m6122s();
            }
        }).start();
        if (this.f4062p) {
            new Thread(new Runnable() {
                public void run() {
                    while (UpdateActivity.this.f4062p) {
                        if (UpdateActivity.this.mContent != null) {
                            UpdateActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    int[] iArr = iAsrr;
                                    iArr[0] = iArr[0] + 1;
                                    if (iArr[0] > 3) {
                                        iArr[0] = 0;
                                    }
                                    UpdateActivity.this.mContent.setText(strArr[iArr[0]]);
                                }
                            });
                        }
                        UpdateActivity.this.m6112a(1000);
                    }
                }
            }).start();
        }
    }

    /* renamed from: d */
    public void mo5345d(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    @OnClick({R.id.updateActivity_cancel, R.id.updateActivity_reCheck, R.id.updateActivity_content})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.updateActivity_cancel:
                mo5213o();
                return;
            case R.id.updateActivity_reCheck:
                if (!this.f4063q) {
                    m6125v();
                    this.mReCheckBtn.setVisibility(View.INVISIBLE);
                    return;
                } else if (this.f4064r != null) {
                    this.f4064r.mo4563c();
                    this.mReCheckBtn.setVisibility(View.INVISIBLE);
                    this.mProgressBar.setVisibility(View.VISIBLE);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_update);
        this.f4065s = ButterKnife.bind((Activity) this);
        mo5215p();
//        Bmob.initialize(this, "2733df1cda91841bbac921e164dc70d4");
        m6121r();
        this.f4062p = true;
        m6125v();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f4062p = false;
        this.f4065s.unbind();
    }

    /* renamed from: q */
    public void mo5113q() {
        if (this.mContent != null) {
            runOnUiThread(new Runnable() {
                public void run() {
                    UpdateActivity.this.mContent.setText(UpdateActivity.this.getString(R.string.noInternet));
                    UpdateActivity.this.mReCheckBtn.setText(UpdateActivity.this.getString(R.string.reTry));
                    UpdateActivity.this.mReCheckBtn.setVisibility(View.VISIBLE);
                }
            });
        }
    }
}
