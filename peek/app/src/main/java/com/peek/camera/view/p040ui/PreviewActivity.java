package com.peek.camera.view.p040ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;
import butterknife.Unbinder;
import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_TIME;
import com.peek.camera.BaseApplication;
import com.peek.camera.C1057a;
import com.peek.camera.R;
import com.peek.camera.model.All_id_Info;
import com.peek.camera.model.CapturePicture;
import com.peek.camera.model.Login_info;
import com.peek.camera.model.RecordTaskInfo;
import com.peek.camera.model.VideoInfo;
import com.peek.camera.p032a.C1058a;
import com.peek.camera.p032a.C1097b;
import com.peek.camera.p032a.C1098c;
import com.peek.camera.p032a.C1102g;
import com.peek.camera.p032a.p033a.C1059a;
import com.peek.camera.p032a.p033a.C1062b;
import com.peek.camera.p032a.p033a.C1073d;
import com.peek.camera.p032a.p033a.C1084g;
import com.peek.camera.p034b.C1104a;
import com.peek.camera.p034b.C1116aa;
import com.peek.camera.p034b.C1129g;
import com.peek.camera.p034b.C1130h;
import com.peek.camera.p034b.C1131i;
import com.peek.camera.p034b.C1134k;
import com.peek.camera.p034b.C1139m;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1141o;
import com.peek.camera.p034b.C1148s;
import com.peek.camera.p034b.C1155v;
import com.peek.camera.p034b.C1156w;
import com.peek.camera.p034b.C1157x;
import com.peek.camera.p034b.C1158y;
import com.peek.camera.p034b.C1159z;
import com.peek.camera.p034b.p035a.C1107a;
import com.peek.camera.p034b.p035a.C1110b;
import com.peek.camera.service.MyServiceGetPlaceName;
import com.peek.camera.view.fragments.C1329a;
import com.peek.camera.view.fragments.DialogBiaojiMutiFragment;
import com.peek.camera.view.fragments.DialogEdtNormalFragment;
import com.peek.camera.view.fragments.DialogKanbanShowFragment;
import com.peek.camera.view.fragments.DialogNormalFragment;
import com.peek.camera.view.fragments.DialogRecordPauseFragment;
import com.peek.camera.view.p038b.C1210b;
import com.peek.camera.view.p038b.C1215d;
import com.peek.camera.view.p039c.C1237b;
import com.peek.camera.view.view.CompositeImageText;
import com.peek.camera.view.view.Vertical_seekbar;

import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.cookie.ClientCookie;

/* renamed from: com.bmw.peek2.view.ui.PreviewActivity */
public class PreviewActivity extends BaseActivity implements C1237b {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public String f3826A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public String f3827B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public Timer f3828C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public TimerTask f3829D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public long f3830E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public long f3831F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f3832G;

    /* renamed from: H */
    private boolean f3833H;

    /* renamed from: I */
    private String f3834I;

    /* renamed from: J */
    private String f3835J;

    /* renamed from: K */
    private RecordTaskInfo f3836K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public boolean f3837L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f3838M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public boolean f3839N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public boolean f3840O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public boolean f3841P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public VideoInfo f3842Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public CapturePicture f3843R;

    /* renamed from: S */
    private long f3844S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public C1110b f3845T;

    /* renamed from: U */
    private Handler f3846U = new Handler();

    /* renamed from: V */
    private Unbinder f3847V;

    /* renamed from: W */
    private BroadcastReceiver f3848W = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(C1057a.f2926c)) {
                double doubleExtra = intent.getDoubleExtra(C1057a.f2927d, -10000.0d);
                if (doubleExtra != -10000.0d) {
                    double round = ((double) Math.round(1000000.0d * doubleExtra)) / 1000000.0d;
                    if (PreviewActivity.this.f3845T != null && PreviewActivity.this.f3862x) {
                        PreviewActivity.this.f3845T.mo4601a(round);
                        PreviewActivity.this.f3845T.mo4618h();
                    }
                } else {
                    doubleExtra = -1.0d;
                }
                double doubleExtra2 = intent.getDoubleExtra(C1057a.f2928e, -10000.0d);
                if (doubleExtra2 != -10000.0d) {
                    double round2 = ((double) Math.round(1000000.0d * doubleExtra2)) / 1000000.0d;
                    if (doubleExtra != -1.0d) {
                        if (BaseApplication.m4928b().getBoolean(C1057a.f2925b, false)) {
                            MyServiceGetPlaceName.m5372a(PreviewActivity.this.mo5210l(), doubleExtra, doubleExtra2);
                        } else if (!(PreviewActivity.this.f3845T == null || PreviewActivity.this.f3845T.mo4605b() == null)) {
                            PreviewActivity.this.f3845T.mo4607b((String) null);
                            PreviewActivity.this.f3845T.mo4618h();
                        }
                    }
                    if (PreviewActivity.this.f3845T != null && PreviewActivity.this.f3862x) {
                        PreviewActivity.this.f3845T.mo4606b(round2);
                        PreviewActivity.this.f3845T.mo4618h();
                        return;
                    }
                    return;
                }
                return;
            }
            float floatExtra = intent.getFloatExtra("angle", -10000.0f);
            if (!(floatExtra == -10000.0f || PreviewActivity.this.moveAngle == null)) {
                PreviewActivity.this.moveAngle.setText(floatExtra + "°");
            }
            String stringExtra = intent.getStringExtra("rangingSize");
            if (stringExtra != null) {
                PreviewActivity.this.mo5276f(stringExtra);
            }
            String stringExtra2 = intent.getStringExtra(C1057a.f2924a);
            if (!(stringExtra2 == null || stringExtra2 == null || PreviewActivity.this.f3845T == null || !PreviewActivity.this.f3862x)) {
                PreviewActivity.this.f3845T.mo4607b(stringExtra2);
                PreviewActivity.this.f3845T.mo4618h();
            }
            if (intent.getBooleanExtra("isNotGetLocate", false)) {
                PreviewActivity.this.m5970X();
            }
            if (intent.getBooleanExtra("isReLoginHK", false)) {
                if (PreviewActivity.this.surfaceView != null) {
                    PreviewActivity.this.surfaceView.post(new Runnable() {
                        public void run() {
                            ViewGroup.LayoutParams layoutParams = PreviewActivity.this.surfaceView.getLayoutParams();
                            int width = PreviewActivity.this.flSurfaceContainer.getWidth();
                            int height = PreviewActivity.this.flSurfaceContainer.getHeight();
                            if (!(width == 0 || height == 0)) {
                                layoutParams.width = width;
                                layoutParams.height = height;
                            }
                            PreviewActivity.this.surfaceView.setLayoutParams(layoutParams);
                            if (PreviewActivity.this.f3858t.mo4569a()) {
                                PreviewActivity.this.f3858t.mo4568a((String) null, false, (String) null);
                            }
                        }
                    });
                }
                PreviewActivity.this.f3857s.mo4544a();
            }
            if (intent.getBooleanExtra("isLogoutHK", false)) {
                PreviewActivity.this.f3857s.mo4545b();
            }
            C1104a.m5161a(PreviewActivity.this.mo5210l(), intent, PreviewActivity.this.battery_terminal, PreviewActivity.this.battery_terminal_title);
            int unused = PreviewActivity.this.f3863y = C1104a.m5162b(PreviewActivity.this.mo5210l(), intent, PreviewActivity.this.battery_device, PreviewActivity.this.battery_device_title);
            int intExtra = intent.getIntExtra("KEY_IS_RECORD_HAS_DATA", -1);
            if (!(intExtra == -1 || intExtra == 0)) {
                boolean unused2 = PreviewActivity.this.f3837L = true;
                long unused3 = PreviewActivity.this.f3831F = System.currentTimeMillis();
            }
            if (intent.getBooleanExtra("KEY_ERROR_PAUSE_CLOSE", false)) {
            }
            if (intent.getBooleanExtra("KEY_WIFI_STATE_JUST_FINISH_PREVIEW", false)) {
                BaseApplication.f2900c.execute(new Runnable() {
                    public void run() {
                        PreviewActivity.this.m5937C();
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: X */
    public String f3849X;
    /* access modifiers changed from: private */

    /* renamed from: Y */
    public ProgressDialog f3850Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public ConnectivityManager f3851Z;

    /* renamed from: aa */
    private ConnectivityManager.NetworkCallback f3852aa;
    @BindView(R.id.tv_battery_device)
    TextView battery_device;
    @BindView(R.id.tv_battery_device_title)
    TextView battery_device_title;
    @BindView(R.id.tv_battery_terminal)
    TextView battery_terminal;
    @BindView(R.id.tv_battery_terminal_title)
    TextView battery_terminal_title;
    @BindView(R.id.preview_clearFog)
    CompositeImageText clearFogComposite;
    @BindView(R.id.preview_connectState)
    CompositeImageText connectState;
    @BindView(R.id.fl_surfaceContainer)
    FrameLayout flSurfaceContainer;
    @BindView(R.id.img_ConnectHint)
    ImageView imgConnectHint;
    @BindView(R.id.lights_adjust)
    Vertical_seekbar lightAdjust;
    @BindView(R.id.lights_show)
    TextView light_text;
    @BindView(R.id.preview_locate)
    CompositeImageText locateComposite;
    @BindView(R.id.preview_moveAngel)
    CompositeImageText moveAngle;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C1097b f3853o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f3854p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f3855q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f3856r;
    @BindView(R.id.ranging)
    CompositeImageText rangingComposite;
    @BindView(R.id.Records)
    CompositeImageText recordComposite;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C1098c f3857s;
    @BindView(R.id.main_surface)
    SurfaceView surfaceView;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C1102g f3858t;

    /* renamed from: u */
    private boolean f3859u;

    /* renamed from: v */
    private boolean f3860v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f3861w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f3862x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f3863y;

    /* renamed from: z */
    private C1058a f3864z;

    /* renamed from: A */
    private void m5933A() {
        this.surfaceView.getHolder().setFormat(-3);
        this.f3857s = new C1073d(getApplicationContext(), this, this.surfaceView);
        Login_info.getInstance().initLoginInfo(this);
        this.f3853o = new C1062b();
        this.f3858t = new C1084g(this);
        this.f3864z = new C1059a(this);
        m5935B();
        this.f3637n = Toast.makeText(this, R.string.clickAgainToExit, Toast.LENGTH_SHORT);
    }

    /* renamed from: B */
    private void m5935B() {
        C1141o.m5272a().mo4665b();
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public void m5937C() {
        final String g = new C1159z(BaseApplication.m4925a()).mo4690g();
        runOnUiThread(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x007e  */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x009c  */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x00a6  */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa  */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x00e8  */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x00ec  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                    r2 = 1
                    r1 = 0
                    java.lang.String r0 = "netUtil result!!!"
                    com.bmw.peek2.view.p040ui.BaseActivity.m5794b((java.lang.String) r0)
                    com.bmw.peek2.view.ui.PreviewActivity r0 = com.bmw.peek2.view.p040ui.PreviewActivity.this
                    com.bmw.peek2.view.view.CompositeImageText r0 = r0.connectState
                    if (r0 == 0) goto L_0x0094
                    com.bmw.peek2.b.o r0 = com.bmw.peek2.p034b.C1141o.m5272a()
                    boolean r4 = r0.mo4667c()
                    com.bmw.peek2.b.o r0 = com.bmw.peek2.p034b.C1141o.m5272a()
                    boolean r3 = r0.mo4668d()
                    com.bmw.peek2.model.Login_info r0 = com.bmw.peek2.model.Login_info.getInstance()
                    boolean r0 = r0.isWifi_auto()
                    if (r0 == 0) goto L_0x0109
                    com.bmw.peek2.model.Login_info r0 = com.bmw.peek2.model.Login_info.getInstance()
                    boolean r0 = r0.isWifiIsRepeater()
                    if (r0 == 0) goto L_0x0095
                    java.lang.String r0 = "Peek2S_Relay_AP"
                L_0x0033:
                    java.lang.String r5 = r0
                    boolean r0 = r5.contains(r0)
                    if (r0 != 0) goto L_0x0109
                    r0 = r1
                    r4 = r1
                L_0x003d:
                    if (r4 != 0) goto L_0x0041
                    if (r0 == 0) goto L_0x0098
                L_0x0041:
                    r3 = r2
                L_0x0042:
                    if (r4 == 0) goto L_0x0046
                    if (r0 != 0) goto L_0x009a
                L_0x0046:
                    if (r3 == 0) goto L_0x009a
                    r0 = r2
                L_0x0049:
                    if (r0 == 0) goto L_0x009c
                    com.bmw.peek2.view.ui.PreviewActivity r0 = com.bmw.peek2.view.p040ui.PreviewActivity.this
                    android.widget.ImageView r0 = r0.imgConnectHint
                    r0.setVisibility(r1)
                L_0x0052:
                    com.bmw.peek2.view.ui.PreviewActivity r0 = com.bmw.peek2.view.p040ui.PreviewActivity.this
                    com.bmw.peek2.view.view.CompositeImageText r2 = r0.connectState
                    if (r3 == 0) goto L_0x00a6
                    r0 = 2131427341(0x7f0b000d, float:1.8476296E38)
                L_0x005b:
                    r2.setImage(r0)
                    if (r3 != 0) goto L_0x00aa
                    com.bmw.peek2.view.ui.PreviewActivity r0 = com.bmw.peek2.view.p040ui.PreviewActivity.this
                    r2 = 2131493005(0x7f0c008d, float:1.8609478E38)
                    java.lang.String r0 = r0.getString(r2)
                L_0x0069:
                    com.bmw.peek2.view.ui.PreviewActivity r2 = com.bmw.peek2.view.p040ui.PreviewActivity.this
                    com.bmw.peek2.view.view.CompositeImageText r2 = r2.connectState
                    r2.setText(r0)
                    com.bmw.peek2.view.ui.PreviewActivity r0 = com.bmw.peek2.view.p040ui.PreviewActivity.this
                    com.bmw.peek2.view.view.CompositeImageText r2 = r0.connectState
                    if (r3 == 0) goto L_0x00e8
                    r0 = 2131034160(0x7f050030, float:1.767883E38)
                L_0x0079:
                    r2.setTextColor(r0)
                    if (r4 == 0) goto L_0x00ec
                    com.bmw.peek2.view.ui.PreviewActivity r0 = com.bmw.peek2.view.p040ui.PreviewActivity.this
                    android.view.SurfaceView r0 = r0.surfaceView
                    boolean r0 = r0.isShown()
                    if (r0 != 0) goto L_0x0094
                    com.bmw.peek2.view.ui.PreviewActivity r0 = com.bmw.peek2.view.p040ui.PreviewActivity.this
                    android.view.SurfaceView r0 = r0.surfaceView
                    r0.setVisibility(r1)
                    java.lang.String r0 = "显示surfaceView"
                    com.bmw.peek2.p034b.C1140n.m5266a(r0)
                L_0x0094:
                    return
                L_0x0095:
                    java.lang.String r0 = "Peek2S_AP"
                    goto L_0x0033
                L_0x0098:
                    r3 = r1
                    goto L_0x0042
                L_0x009a:
                    r0 = r1
                    goto L_0x0049
                L_0x009c:
                    com.bmw.peek2.view.ui.PreviewActivity r0 = com.bmw.peek2.view.p040ui.PreviewActivity.this
                    android.widget.ImageView r0 = r0.imgConnectHint
                    r2 = 8
                    r0.setVisibility(r2)
                    goto L_0x0052
                L_0x00a6:
                    r0 = 2131427344(0x7f0b0010, float:1.8476302E38)
                    goto L_0x005b
                L_0x00aa:
                    java.lang.String r0 = r0
                    java.lang.String r2 = "Peek2S_Relay_AP"
                    boolean r0 = r0.contains(r2)
                    if (r0 == 0) goto L_0x00c2
                    com.bmw.peek2.view.ui.PreviewActivity r0 = com.bmw.peek2.view.p040ui.PreviewActivity.this
                    android.content.res.Resources r0 = r0.getResources()
                    r2 = 2131493177(0x7f0c0139, float:1.8609827E38)
                    java.lang.String r0 = r0.getString(r2)
                    goto L_0x0069
                L_0x00c2:
                    java.lang.String r0 = r0
                    java.lang.String r2 = "Peek2S_AP"
                    boolean r0 = r0.contains(r2)
                    if (r0 == 0) goto L_0x00da
                    com.bmw.peek2.view.ui.PreviewActivity r0 = com.bmw.peek2.view.p040ui.PreviewActivity.this
                    android.content.res.Resources r0 = r0.getResources()
                    r2 = 2131493075(0x7f0c00d3, float:1.860962E38)
                    java.lang.String r0 = r0.getString(r2)
                    goto L_0x0069
                L_0x00da:
                    com.bmw.peek2.view.ui.PreviewActivity r0 = com.bmw.peek2.view.p040ui.PreviewActivity.this
                    android.content.res.Resources r0 = r0.getResources()
                    r2 = 2131492929(0x7f0c0041, float:1.8609324E38)
                    java.lang.String r0 = r0.getString(r2)
                    goto L_0x0069
                L_0x00e8:
                    r0 = 2131034190(0x7f05004e, float:1.767889E38)
                    goto L_0x0079
                L_0x00ec:
                    com.bmw.peek2.model.All_id_Info r0 = com.bmw.peek2.model.All_id_Info.getInstance()
                    int r0 = r0.getM_iLogID()
                    if (r0 < 0) goto L_0x0100
                    java.util.concurrent.Executor r0 = com.bmw.peek2.BaseApplication.f2900c
                    com.bmw.peek2.view.ui.PreviewActivity$26$1 r1 = new com.bmw.peek2.view.ui.PreviewActivity$26$1
                    r1.<init>()
                    r0.execute(r1)
                L_0x0100:
                    com.bmw.peek2.view.ui.PreviewActivity r0 = com.bmw.peek2.view.p040ui.PreviewActivity.this
                    android.view.SurfaceView r0 = r0.surfaceView
                    r1 = 4
                    r0.setVisibility(r1)
                    goto L_0x0094
                L_0x0109:
                    r0 = r3
                    goto L_0x003d
                */
//                throw new UnsupportedOperationException("Method not decompiled: com.bmw.peek2.view.p040ui.PreviewActivity.C142726.run():void");
            }
        });
    }

    /* renamed from: D */
    private void m5939D() {
        this.f3858t.mo4570b();
        if (this.f3829D != null) {
            this.f3829D.cancel();
        }
        if (this.f3828C != null) {
            this.f3828C.cancel();
        }
        this.f3829D = null;
        this.f3828C = null;
        if (this.f3864z != null) {
            this.f3864z.mo4490c();
        }
        unregisterReceiver(this.f3848W);
        this.f3637n.cancel();
        this.f3853o.mo4513l();
        this.f3853o = null;
        this.f3857s.mo4546c();
        new Thread(new Runnable() {
            public void run() {
                PreviewActivity.this.f3857s.mo4546c();
            }
        }).start();
        this.f3847V.unbind();
        m5794b("onDestroy:finish ");
    }

    /* renamed from: E */
    private void m5942E() {
        this.lightAdjust.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                BaseActivity.m5794b("seekbar: onProgressChanged: running");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                BaseActivity.m5794b("seekbar:  onStartTrackingTouch: ");
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                BaseActivity.m5794b("seekbar: onStopTrackingTouch: ");
                if (PreviewActivity.this.f3854p) {
                    int unused = PreviewActivity.this.f3855q = progress;
                    PreviewActivity.this.f3853o.mo4502b(PreviewActivity.this.f3855q);
                } else {
                    int unused2 = PreviewActivity.this.f3856r = progress;
                    PreviewActivity.this.f3853o.mo4498a(PreviewActivity.this.f3856r);
                }
                if (progress != 0) {
                    return;
                }
                if (PreviewActivity.this.f3854p) {
                    PreviewActivity.this.f3853o.mo4510i();
                } else {
                    PreviewActivity.this.f3853o.mo4509h();
                }
            }
        });
    }

    /* renamed from: F */
    private void m5944F() {
        if (Login_info.getInstance().isWifi_auto()) {
            C1116aa.m5196a((Context) this);
        }
    }

    /* renamed from: G */
    private void m5946G() {
        DialogNormalFragment a = DialogNormalFragment.m5724a(getString(R.string.exitingApp), getString(R.string.exitAppSure), (String) null, (String) null, true);
        a.mo5175a((C1329a) new C1329a() {
            /* renamed from: a */
            public void mo4542a() {
                PreviewActivity.this.mo5213o();
            }

            /* renamed from: b */
            public void mo4543b() {
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), a, "DialogNormalFragment");
    }

    /* renamed from: H */
    private void m5948H() {
        m5794b("回放按钮！");
        Intent intent = new Intent(this, FileShowNewActivity.class);
        intent.putExtra("picture", false);
        intent.putExtra("batteryNum", this.f3863y);
        startActivity(intent);
    }

    /* renamed from: I */
    private void m5950I() {
        m5794b("图片按钮！");
        Intent intent = new Intent(this, FileShowNewActivity.class);
        intent.putExtra("picture", true);
        intent.putExtra("batteryNum", this.f3863y);
        startActivity(intent);
    }

    /* renamed from: J */
    private void m5952J() {
        m5794b("设置按钮！");
        Intent intent = new Intent(this, SettingActivity.class);
        intent.putExtra("batteryNum", this.f3863y);
        this.f3853o.mo4503b(true);
        startActivityForResult(intent, 0);
    }

    /* renamed from: K */
    private void m5953K() {
        m5794b("测距按钮！");
        if (this.f3860v) {
            this.f3860v = false;
            this.rangingComposite.setImage(R.mipmap.ruler_gray);
            this.rangingComposite.setTextColor(R.color.white);
            this.f3853o.mo4499a((Boolean) false);
            return;
        }
        this.f3860v = true;
        this.rangingComposite.setImage(R.mipmap.ruler);
        this.rangingComposite.setTextColor(R.color.colorText);
        this.f3853o.mo4499a((Boolean) true);
    }

    /* renamed from: L */
    private void m5955L() {
        m5794b("标记按钮！");
        String[] strArr = {"", "", "", ""};
        if (this.f3845T != null) {
            strArr[0] = this.f3845T.mo4608c();
            strArr[1] = this.f3845T.mo4610d();
            strArr[2] = this.f3845T.mo4612e();
            strArr[3] = this.f3845T.mo4614f();
        }
        DialogBiaojiMutiFragment a = DialogBiaojiMutiFragment.m5671a(strArr[0], strArr[1], strArr[2], strArr[3]);
        a.mo5144a((DialogBiaojiMutiFragment.C1272a) new DialogBiaojiMutiFragment.C1272a() {
            /* renamed from: a */
            public void mo5155a(String str, String str2, String str3, String str4) {
                if (PreviewActivity.this.f3845T != null) {
                    PreviewActivity.this.f3845T.mo4609c(str);
                    PreviewActivity.this.f3845T.mo4611d(str2);
                    PreviewActivity.this.f3845T.mo4613e(str3);
                    PreviewActivity.this.f3845T.mo4615f(str4);
                    PreviewActivity.this.f3845T.mo4618h();
                    return;
                }
                PreviewActivity.this.mo5206a(PreviewActivity.this.getString(R.string.addBiaojiFalse));
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), a, "DialogBiaojiMutiFragment");
    }

    /* access modifiers changed from: private */
    /* renamed from: M */
    public void m5957M() {
        m5794b("录像按钮！");
        if (!this.f3859u) {
            float floatValue = C1129g.m5239e().get(1).floatValue();
            if (floatValue > 0.15f && floatValue < 0.5f) {
                m5981a(floatValue);
            } else if (floatValue <= 0.15f) {
                mo5206a(getString(R.string.noStorageToRecord));
            } else {
                if (this.f3841P) {
                    this.f3841P = false;
                }
                m5960N();
            }
        } else {
            m5960N();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public void m5960N() {
        if (!this.f3859u) {
            if (BaseApplication.m4928b().getBoolean("KEY_IS_OPEN_RECORD_KANBAN", false)) {
                m5962P();
            } else {
                m5964R();
            }
        } else if (!BaseApplication.m4928b().getBoolean("RECORD_CAN_PAUSE", false)) {
            m5961O();
        } else if (!Login_info.isPause) {
            m5966T();
        } else {
            HCNetSDK.getInstance().NET_DVR_MakeKeyFrame(All_id_Info.getInstance().getM_iLogID(), All_id_Info.getInstance().getM_iChanNum());
            Login_info.isPause = false;
            mo5206a(getString(R.string.record_continue));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public void m5961O() {
        this.f3858t.mo4568a((String) null, this.f3832G, (String) null);
        this.f3826A = null;
        this.f3827B = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public void m5962P() {
        this.f3832G = false;
        this.f3849X = null;
        this.f3838M = false;
        DialogNormalFragment a = DialogNormalFragment.m5725a(getString(R.string.recordRemind), getString(R.string.isAddKanbanToRecord), getString(R.string.startRecord), getString(R.string.addKanbanToRecord), false, true);
        a.mo5175a((C1329a) new C1329a() {
            /* renamed from: a */
            public void mo4542a() {
                PreviewActivity.this.m5964R();
            }

            /* renamed from: b */
            public void mo4543b() {
                DialogKanbanShowFragment O = DialogKanbanShowFragment.m5694O();
                O.mo5162a((DialogKanbanShowFragment.C1283a) new DialogKanbanShowFragment.C1283a() {
                    /* renamed from: a */
                    public void mo5164a() {
                        String unused = PreviewActivity.this.f3849X = null;
                        boolean unused2 = PreviewActivity.this.f3832G = true;
                        if (PreviewActivity.this.m5963Q() / 3 >= 5) {
                            PreviewActivity.this.mo5206a(PreviewActivity.this.getString(R.string.kanban_shangxian));
                        } else {
                            PreviewActivity.this.m5965S();
                        }
                    }

                    /* renamed from: a */
                    public void mo5165a(String str) {
                        String unused = PreviewActivity.this.f3849X = str;
                        PreviewActivity.this.m5964R();
                    }

                    /* renamed from: b */
                    public void mo5166b() {
                        PreviewActivity.this.m5962P();
                    }
                });
                C1130h.m5241a(PreviewActivity.this.getSupportFragmentManager(), O, "DialogKanbanShowFragment");
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), a, "DialogNormalFragment");
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public int m5963Q() {
        return C1129g.m5230b(C1129g.m5220a() + Login_info.local_kanban_path);
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public void m5964R() {
        DialogNormalFragment a = DialogNormalFragment.m5725a(getString(R.string.recordRemind), getString(R.string.isAddRecordHead), getString(R.string.yes), getString(R.string.no), false, true);
        a.mo5175a((C1329a) new C1329a() {
            /* renamed from: a */
            public void mo4542a() {
                PreviewActivity.this.startActivityForResult(new Intent(PreviewActivity.this, RecordHeadEditActivity.class), 1);
            }

            /* renamed from: b */
            public void mo4543b() {
                String a = PreviewActivity.this.m5980a((String) null, (String) null, (String) null, (String) null);
                if (BaseApplication.m4928b().getInt("KEY_FILE_NAME_MODEL_MINESET", 0) != 2 || PreviewActivity.this.f3832G) {
                    PreviewActivity.this.f3858t.mo4568a(PreviewActivity.this.m5989b(a, true), PreviewActivity.this.f3832G, PreviewActivity.this.f3849X);
                    return;
                }
                PreviewActivity.this.m5984a(a, true);
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), a, "DialogNormalFragment");
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public void m5965S() {
        final String c = C1129g.m5234c(C1129g.m5220a() + Login_info.local_kanban_path);
        m5794b(new StringBuilder().append("kanban baseName = ").append(c).toString());
        DialogEdtNormalFragment a = DialogEdtNormalFragment.m5683a(getString(R.string.pleaseAddKanbanName), c, (String) null, (String) null, false);
        a.mo5156a((DialogEdtNormalFragment.C1279a) new DialogEdtNormalFragment.C1279a() {
            /* renamed from: a */
            public void mo5160a() {
            }

            /* renamed from: a */
            public void mo5161a(String str) {
                if (!TextUtils.isEmpty(str)) {
                    BaseApplication.m4925a().mo4481b(str);
                } else {
                    BaseApplication.m4925a().mo4481b(c);
                }
                PreviewActivity.this.m5964R();
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), a, "DialogEdtNormalFragment");
    }

    /* renamed from: T */
    private void m5966T() {
        DialogRecordPauseFragment dialogRecordPauseFragment = new DialogRecordPauseFragment();
        dialogRecordPauseFragment.mo5189a(new View.OnClickListener() {
            public void onClick(View view) {
                Login_info.isPause = true;
                PreviewActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        PreviewActivity.this.recordComposite.setText(PreviewActivity.this.getString(R.string.alreadyPause));
                        PreviewActivity.this.mo5206a(PreviewActivity.this.getString(R.string.record_pause));
                    }
                });
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                PreviewActivity.this.f3858t.mo4568a((String) null, PreviewActivity.this.f3832G, (String) null);
                String unused = PreviewActivity.this.f3826A = null;
                String unused2 = PreviewActivity.this.f3827B = null;
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), dialogRecordPauseFragment, "DialogRecordPauseFragment");
    }

    /* access modifiers changed from: private */
    /* renamed from: U */
    public void m5967U() {
        m5794b("除雾按钮！");
        if (this.f3861w) {
            this.f3861w = false;
            this.clearFogComposite.setImage(R.mipmap.chuwu_off);
            this.clearFogComposite.setTextColor(R.color.white);
            this.f3853o.mo4512k();
            return;
        }
        this.f3861w = true;
        this.clearFogComposite.setImage(R.mipmap.chuwu_on);
        this.clearFogComposite.setTextColor(R.color.colorText);
        this.f3853o.mo4511j();
    }

    /* renamed from: V */
    private void m5968V() {
        if (this.f3861w) {
            new Thread(new Runnable() {
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (PreviewActivity.this.f3861w && System.currentTimeMillis() - currentTimeMillis <= 120000) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    BaseActivity.m5794b("关闭除雾：" + PreviewActivity.this.f3861w);
                    if (PreviewActivity.this.f3861w && PreviewActivity.this.clearFogComposite != null) {
                        PreviewActivity.this.clearFogComposite.post(new Runnable() {
                            public void run() {
                                PreviewActivity.this.m5967U();
                            }
                        });
                    }
                }
            }).start();
        }
    }

    /* renamed from: W */
    private void m5969W() {
        m5794b("灯光按钮！");
        if (this.f3854p) {
            this.light_text.setText(getString(R.string.lowBeam));
            this.f3854p = false;
            this.lightAdjust.setProgress(this.f3856r);
            return;
        }
        this.light_text.setText(getString(R.string.highBeam));
        this.f3854p = true;
        this.lightAdjust.setProgress(this.f3855q);
    }

    /* access modifiers changed from: private */
    /* renamed from: X */
    public void m5970X() {
        m5794b("定位按钮！");
        if (this.f3862x) {
            this.f3862x = false;
            this.locateComposite.setImage(R.mipmap.locate_off);
            this.locateComposite.setTextColor(R.color.white);
            this.f3864z.mo4489b();
            if (this.f3845T != null) {
                this.f3845T.mo4601a(0.0d);
                this.f3845T.mo4606b(0.0d);
                this.f3845T.mo4607b((String) null);
                this.f3845T.mo4618h();
                return;
            }
            return;
        }
        this.f3862x = true;
        this.locateComposite.setImage(R.mipmap.locate_on);
        this.locateComposite.setTextColor(R.color.colorText);
        this.f3864z.mo4488a();
    }

    /* renamed from: a */
    private String m5976a(int i, boolean z) {
        if (i != 10000) {
            return i < 10 ? "0" + i : String.valueOf(i);
        }
        if (z) {
            BaseApplication.m4928b().edit().putInt("KEY_VIDEO_FILE_COUNT", 1).commit();
        } else {
            BaseApplication.m4928b().edit().putInt("KEY_PICTURE_FILE_COUNT", 1).commit();
        }
        return "00";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m5980a(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        if (str != null && !TextUtils.isEmpty(str)) {
            sb.append(str).append("_");
        }
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            sb.append(str2).append("_");
        }
        if (str3 != null && !TextUtils.isEmpty(str3)) {
            sb.append(str3).append("_");
        }
        if (str4 != null && !TextUtils.isEmpty(str4)) {
            sb.append(str4).append("_");
        }
        NET_DVR_TIME a = C1131i.m5242a();
        if (a != null) {
            sb.append(a.dwYear).append(a.dwMonth < 10 ? 0 : "").append(a.dwMonth).append(a.dwDay < 10 ? 0 : "").append(a.dwDay).append(a.dwHour < 10 ? 0 : "").append(a.dwHour).append(a.dwMinute < 10 ? 0 : "").append(a.dwMinute).append(a.dwSecond < 10 ? 0 : "").append(a.dwSecond);
        } else {
            sb.append(C1158y.m5338a());
        }
        return sb.toString();
    }

    /* renamed from: a */
    private void m5981a(float f) {
        DialogNormalFragment a = DialogNormalFragment.m5724a(getString(R.string.lowStorageAlarm), getString(R.string.currentStorageRemind) + ((int) (1024.0f * f)) + getString(R.string.storageClearRemind), getString(R.string.continueRecord), getString(R.string.cancelRecord), false);
        a.mo5175a((C1329a) new C1329a() {
            /* renamed from: a */
            public void mo4542a() {
                PreviewActivity.this.m5960N();
                if (!PreviewActivity.this.f3841P) {
                    boolean unused = PreviewActivity.this.f3841P = true;
                }
            }

            /* renamed from: b */
            public void mo4543b() {
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), a, "DialogNormalFragment");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5982a(RecordTaskInfo recordTaskInfo) {
        int i = 0;
        if (recordTaskInfo != null) {
            StringBuilder sb = new StringBuilder();
            boolean a = C1155v.m5330a(recordTaskInfo.getTask_name());
            boolean a2 = C1155v.m5330a(recordTaskInfo.getTask_id());
            if (!a2 || !a) {
                if (Login_info.getInstance().isShowFirstName()) {
                    if (!a) {
                        sb.append(getResources().getString(R.string.record_task_name_e));
                        if (!a2) {
                            sb.append("/");
                        }
                    }
                    if (!a2) {
                        sb.append(getResources().getString(R.string.task_name_id_a));
                    }
                    sb.append(":");
                }
                if (!a) {
                    sb.append(recordTaskInfo.getTask_name());
                    if (!a2) {
                        sb.append("/");
                    }
                }
                if (!a2) {
                    sb.append(recordTaskInfo.getTask_id());
                }
            }
            StringBuilder sb2 = new StringBuilder();
            if (!C1155v.m5330a(recordTaskInfo.getTask_place())) {
                if (Login_info.getInstance().isShowFirstName()) {
                    sb2.append(getResources().getString(R.string.record_task_place_e));
                }
                sb2.append(recordTaskInfo.getTask_place()).append(" ");
            }
            if (!BaseApplication.m4928b().getBoolean("KEY_OSD_IS_SHOW_TIME_ON_DEVICE", false)) {
                NET_DVR_TIME a3 = C1131i.m5242a();
                StringBuilder sb3 = new StringBuilder();
                if (a3 != null) {
                    sb3.append(a3.dwYear).append("-").append(a3.dwMonth).append("-").append(a3.dwDay).append("");
                } else {
                    sb3.append(C1158y.m5340b());
                }
                this.f3836K.setTask_date(sb3.toString());
                if (Login_info.getInstance().isShowFirstName()) {
                    sb2.append(getResources().getString(R.string.task_date));
                }
                sb2.append(sb3.toString());
            }
            StringBuilder sb4 = new StringBuilder();
            boolean a4 = C1155v.m5330a(recordTaskInfo.getTask_start());
            boolean a5 = C1155v.m5330a(recordTaskInfo.getTask_end());
            if (!a4 || !a5) {
                if (Login_info.getInstance().isShowFirstName()) {
                    if (!a4) {
                        sb4.append(getResources().getString(R.string.task_well_start_end));
                        if (!a5) {
                            sb4.append("-");
                        }
                    }
                    if (!a5) {
                        sb4.append(getResources().getString(R.string.task_well_start_end_a));
                    }
                    sb4.append(":");
                }
                if (!a4) {
                    sb4.append(recordTaskInfo.getTask_start());
                    if (!a5) {
                        sb4.append("-");
                    }
                }
                if (!a5) {
                    sb4.append(recordTaskInfo.getTask_end());
                }
                sb4.append(" ");
            }
            StringBuilder sb5 = new StringBuilder();
            if (!C1155v.m5330a(recordTaskInfo.getTask_direction())) {
                if (Login_info.getInstance().isShowFirstName()) {
                    sb5.append(getResources().getString(R.string.record_task_direction_e));
                }
                sb5.append(recordTaskInfo.getTask_direction()).append(" ");
            }
            if (!C1155v.m5330a(recordTaskInfo.getTask_guancai())) {
                if (Login_info.getInstance().isShowFirstName()) {
                    sb5.append(getResources().getString(R.string.record_task_guancai_e));
                }
                sb5.append(recordTaskInfo.getTask_guancai()).append(" ");
            }
            StringBuilder sb6 = new StringBuilder();
            if (!C1155v.m5330a(recordTaskInfo.getTask_sort())) {
                if (Login_info.getInstance().isShowFirstName()) {
                    sb6.append(getResources().getString(R.string.record_task_sort_e));
                }
                sb6.append(recordTaskInfo.getTask_sort()).append(" ");
            }
            if (!C1155v.m5330a(recordTaskInfo.getTask_diameter())) {
                if (Login_info.getInstance().isShowFirstName()) {
                    sb6.append(getResources().getString(R.string.task_diameter));
                }
                sb6.append(recordTaskInfo.getTask_diameter()).append("mm");
            }
            StringBuilder sb7 = new StringBuilder();
            if (!C1155v.m5330a(recordTaskInfo.getTask_computer())) {
                if (Login_info.getInstance().isShowFirstName()) {
                    sb7.append(getResources().getString(R.string.record_task_computer_e));
                }
                sb7.append(recordTaskInfo.getTask_computer()).append(" ");
            }
            if (!C1155v.m5330a(recordTaskInfo.getTask_people())) {
                if (Login_info.getInstance().isShowFirstName()) {
                    sb7.append(getResources().getString(R.string.record_task_people_e));
                }
                sb7.append(recordTaskInfo.getTask_people());
            }
            String[] strArr = {sb.toString(), sb2.toString(), sb4.toString(), sb5.toString(), sb6.toString(), sb7.toString()};
            String[] strArr2 = new String[6];
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    strArr2[i] = str;
                    i++;
                }
            }
            if (this.f3845T != null) {
                StringBuilder sb8 = new StringBuilder();
                StringBuilder sb9 = new StringBuilder();
                if (!a) {
                    sb8.append(recordTaskInfo.getTask_name());
                    if (!a2) {
                        sb8.append("/");
                    }
                }
                if (!a2) {
                    sb8.append(recordTaskInfo.getTask_id());
                }
                if (!a4) {
                    sb9.append(recordTaskInfo.getTask_start());
                    if (!a5) {
                        sb9.append("-");
                    }
                }
                if (!a5) {
                    sb9.append(recordTaskInfo.getTask_end());
                }
                if (!TextUtils.isEmpty(recordTaskInfo.getTask_guancai())) {
                    sb9.append(" ").append(recordTaskInfo.getTask_guancai());
                }
                if (!TextUtils.isEmpty(recordTaskInfo.getTask_diameter())) {
                    sb9.append(" ").append(recordTaskInfo.getTask_diameter()).append("mm");
                }
                this.f3845T.mo4617g(sb8.toString());
                this.f3845T.mo4619h(sb9.toString());
                this.f3845T.mo4604a(strArr2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5984a(final String str, final boolean z) {
        DialogEdtNormalFragment a = DialogEdtNormalFragment.m5683a(getString(R.string.pleaseInputFileName), str, (String) null, (String) null, false);
        a.mo5156a((DialogEdtNormalFragment.C1279a) new DialogEdtNormalFragment.C1279a() {
            /* renamed from: a */
            public void mo5160a() {
                String a = PreviewActivity.this.m5989b(str, z);
                if (z) {
                    PreviewActivity.this.f3858t.mo4568a(a, PreviewActivity.this.f3832G, PreviewActivity.this.f3849X);
                    boolean unused = PreviewActivity.this.f3839N = true;
                    return;
                }
                PreviewActivity.this.f3858t.mo4567a(a);
            }

            /* renamed from: a */
            public void mo5161a(String str) {
                String a = (TextUtils.isEmpty(str) || str.equals(str)) ? PreviewActivity.this.m5989b(str, z) : PreviewActivity.this.m5989b(str, z);
                if (z) {
                    PreviewActivity.this.f3858t.mo4568a(a, PreviewActivity.this.f3832G, PreviewActivity.this.f3849X);
                    boolean unused = PreviewActivity.this.f3839N = true;
                    return;
                }
                PreviewActivity.this.f3858t.mo4567a(a);
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), a, "DialogEdtNormalFragment");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m5989b(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(C1129g.m5220a());
        if (z) {
            sb.append(Login_info.local_video_path);
            if (BaseApplication.m4928b().getInt("KEY_FILE_NAME_MODEL_MINESET", 0) == 1) {
                sb.append(m5976a(BaseApplication.m4928b().getInt("KEY_VIDEO_FILE_COUNT", 1), true)).append("-");
            }
        } else {
            sb.append(Login_info.local_picture_path);
            if (BaseApplication.m4928b().getInt("KEY_FILE_NAME_MODEL_MINESET", 0) == 1) {
                sb.append(m5976a(BaseApplication.m4928b().getInt("KEY_PICTURE_FILE_COUNT", 1), false)).append("-");
            }
        }
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: b */
    private void m5991b(boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f3851Z = (ConnectivityManager) getSystemService("connectivity");
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            if (!z) {
                builder.addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR); //0
            } else {
                builder.addTransportType(NetworkCapabilities.TRANSPORT_WIFI);//1
            }
            NetworkRequest build = builder.build();
            this.f3852aa = new ConnectivityManager.NetworkCallback() {
                @TargetApi(23)
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    Log.i("test", "已根据功能和传输类型找到合适的网络");
                    if (Build.VERSION.SDK_INT >= 23) {
                        ConnectivityManager.setProcessDefaultNetwork(network);
                        PreviewActivity.this.f3851Z.bindProcessToNetwork(network);
                        return;
                    }
                    ConnectivityManager.setProcessDefaultNetwork(network);
                }
            };
            this.f3851Z.requestNetwork(build, this.f3852aa);
        }
    }

    /* renamed from: m */
    static /* synthetic */ long m6008m(PreviewActivity previewActivity) {
        long j = previewActivity.f3830E;
        previewActivity.f3830E = 1 + j;
        return j;
    }

    /* renamed from: u */
    private void m6017u() {
        IntentFilter intentFilter = new IntentFilter("data.receiver");
        intentFilter.addAction("BROCAST_IS_RECORD_HAS_DATA");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction(C1057a.f2926c);
        registerReceiver(this.f3848W, intentFilter);
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m6019v() {
        m5991b(true);
        setContentView((int) R.layout.activity_preview);
        this.f3847V = ButterKnife.bind((Activity) this);
        m5933A();
        m5944F();
        m6017u();
        m5942E();
        m6026z();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        m5795c("displayMetrics width = " + i + "  height = " + i2 + "  density = " + displayMetrics.density);
        boolean z = getResources().getBoolean(R.bool.isSmall);
        boolean z2 = false;
        if (!z) {
            z2 = getResources().getBoolean(R.bool.is400);
        }
        m5795c(" isSmall = " + z + " is400 = " + z2 + " language = " + C1134k.m5256a());
        C1139m.m5264a("displayMetrics width = " + i + "  height = " + i2 + "  density = " + displayMetrics.density);
        C1139m.m5264a(" isSmall = " + z + " is400 = " + z2 + " language = " + C1134k.m5256a());
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m6020w() {
        this.f3828C = new Timer();
        this.f3829D = new TimerTask() {
            public void run() {
                if (Login_info.isPause) {
                    return;
                }
                if (!PreviewActivity.this.f3841P || PreviewActivity.this.f3830E % 30 != 0 || !PreviewActivity.this.m6025y()) {
                    if (PreviewActivity.this.f3837L && System.currentTimeMillis() - PreviewActivity.this.f3831F > 1500) {
                        boolean unused = PreviewActivity.this.f3837L = false;
                        BaseActivity.m5794b("录像计时中断！");
                    }
                    if (PreviewActivity.this.recordComposite != null) {
                        PreviewActivity.this.recordComposite.post(new Runnable() {
                            public void run() {
                                PreviewActivity.this.recordComposite.setText(C1157x.m5334a(Long.valueOf(PreviewActivity.this.f3830E * 1000), true));
                            }
                        });
                    }
                    if (PreviewActivity.this.f3837L) {
                        PreviewActivity.m6008m(PreviewActivity.this);
                    }
                    if (PreviewActivity.this.f3832G && PreviewActivity.this.f3830E >= 30) {
                        PreviewActivity.this.m5961O();
                    }
                    if (PreviewActivity.this.f3830E != 0 && PreviewActivity.this.f3830E % 1800 == 0) {
                        PreviewActivity.this.m6022x();
                    }
                }
            }
        };
        this.f3828C.schedule(this.f3829D, 0, 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m6022x() {
        float floatValue = C1129g.m5239e().get(1).floatValue();
        m5794b("录像判断剩余存储空间为：" + floatValue);
        if (((double) floatValue) <= 0.5d) {
            this.f3841P = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public boolean m6025y() {
        float floatValue = C1129g.m5239e().get(1).floatValue();
        m5794b("低存储空间时判断剩余量：" + floatValue);
        if (((double) floatValue) > 0.12d) {
            return false;
        }
        runOnUiThread(new Runnable() {
            public void run() {
                PreviewActivity.this.m5957M();
                PreviewActivity.this.mo5206a("存储空间不足，录像已停止！");
            }
        });
        return true;
    }

    /* renamed from: z */
    private void m6026z() {
        if (C1156w.m5332a(this)) {
            m5794b("检测到快捷方式已经创建");
        } else if (!BaseApplication.m4928b().getBoolean("isAddShortCut", false)) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            Intent.ShortcutIconResource fromContext = Intent.ShortcutIconResource.fromContext(this, R.mipmap.peek2s_logo);
            Intent component = new Intent("android.intent.action.MAIN").setComponent(new ComponentName(getPackageName(), getPackageName() + "." + getLocalClassName()));
            component.setClassName(this, getClass().getName());
            component.addCategory("android.intent.category.LAUNCHER");
            intent.putExtra("android.intent.extra.shortcut.NAME", getResources().getString(R.string.app_name));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", fromContext);
            intent.putExtra("android.intent.extra.shortcut.INTENT", component);
            sendBroadcast(intent);
            m5794b("创建快捷方式");
            BaseApplication.m4928b().edit().putBoolean("isAddShortCut", true).commit();
        }
    }

    /* renamed from: a */
    public void mo5116a(int i, boolean z, String str) {
        switch (i) {
            case 0:
                if (z) {
                    this.f3859u = true;
                    if (this.f3832G) {
                        mo5206a(getString(R.string.startRecordKanban));
                    } else {
                        mo5206a(getString(R.string.startRecord));
                        C1140n.m5266a("开始录像，路径：" + str);
                        this.f3842Q = new VideoInfo();
                        this.f3842Q.setVideoFilename(str);
                        this.f3842Q.setRecordTaskInfo(this.f3836K);
                    }
                    if (this.recordComposite != null) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                PreviewActivity.this.recordComposite.setImage(R.mipmap.recordpress);
                                PreviewActivity.this.recordComposite.setText(C1157x.m5334a(0L, true));
                                PreviewActivity.this.m6020w();
                            }
                        });
                        return;
                    }
                    return;
                }
                mo5207b((int) R.string.startRecordFalse);
                if (this.f3845T != null) {
                    this.f3845T.mo4618h();
                }
                this.f3826A = null;
                this.f3827B = null;
                return;
            case 1:
                if (z) {
                    this.f3849X = null;
                    this.f3859u = false;
                    if (this.f3845T != null) {
                        this.f3845T.mo4618h();
                    }
                    if (this.f3832G) {
                        mo5206a(getString(R.string.record_kanban_stop));
                    } else {
                        mo5206a(getString(R.string.record_stop));
                        if (this.f3842Q != null) {
                            m5794b("xml = " + this.f3842Q.toString());
                            BaseApplication.f2900c.execute(new Runnable() {
                                public void run() {
                                    C1148s.m5294a(PreviewActivity.this.f3842Q);
                                    C1129g.m5227a(C1129g.m5231b(PreviewActivity.this.f3842Q.getVideoFilename(), ".xml"));
                                    VideoInfo unused = PreviewActivity.this.f3842Q = null;
                                }
                            });
                        }
                    }
                    if (this.f3845T != null) {
                        this.f3845T.mo4616g();
                    }
                    if (this.recordComposite != null) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                PreviewActivity.this.recordComposite.setImage(R.mipmap.record);
                                if (PreviewActivity.this.f3829D != null) {
                                    PreviewActivity.this.f3829D.cancel();
                                }
                                if (PreviewActivity.this.f3828C != null) {
                                    PreviewActivity.this.f3828C.cancel();
                                }
                                PreviewActivity.this.recordComposite.setText(PreviewActivity.this.getResources().getString(R.string.recording));
                                long unused = PreviewActivity.this.f3830E = 0;
                            }
                        });
                    }
                    if (BaseApplication.m4928b().getInt("KEY_FILE_NAME_MODEL_MINESET", 0) == 1) {
                        BaseApplication.m4928b().edit().putInt("KEY_VIDEO_FILE_COUNT", BaseApplication.m4928b().getInt("KEY_VIDEO_FILE_COUNT", 1) + 1).commit();
                    }
                } else {
                    mo5207b((int) R.string.stopRecordFalse);
                }
                this.f3826A = null;
                this.f3827B = null;
                if (this.f3839N) {
                    this.f3839N = false;
                }
                if (this.f3832G) {
                    this.f3832G = false;
                }
                if (this.f3849X != null) {
                    this.f3849X = null;
                }
                this.f3826A = null;
                this.f3827B = null;
                this.f3834I = null;
                this.f3835J = null;
                this.f3836K = null;
                return;
            default:
                return;
        }
    }

    /* renamed from: d */
    public void mo5117d(final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                PreviewActivity.this.mo5206a(str);
            }
        });
    }

    /* renamed from: e */
    public void mo5118e(final String str) {
        this.f3844S = this.f3830E;
        this.f3843R = new CapturePicture();
        this.f3843R.setTimestamp(String.valueOf(this.f3844S));
        if (BaseApplication.m4928b().getInt("KEY_FILE_NAME_MODEL_MINESET", 0) == 1) {
            BaseApplication.m4928b().edit().putInt("KEY_PICTURE_FILE_COUNT", BaseApplication.m4928b().getInt("KEY_PICTURE_FILE_COUNT", 1) + 1).commit();
        }
        runOnUiThread(new Runnable() {
            public void run() {
                final C1210b bVar = new C1210b(PreviewActivity.this, PreviewActivity.this.getResources().getString(R.string.isEditPicture), str);
                bVar.mo5074a((View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(PreviewActivity.this, PictureEditActivity.class);
                        intent.putExtra(ClientCookie.PATH_ATTR, str);
                        intent.putExtra("batteryNum", PreviewActivity.this.f3863y);
                        PreviewActivity.this.startActivityForResult(intent, 2);
                        bVar.mo5073a();
                    }
                });
                bVar.mo5075b((View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        if (PreviewActivity.this.f3842Q != null) {
                            PreviewActivity.this.f3843R.setFilename(str);
                            PreviewActivity.this.f3843R.setDefectFilename((String) null);
                            if (PreviewActivity.this.f3842Q != null) {
                                PreviewActivity.this.f3842Q.addCapturePic(PreviewActivity.this.f3843R);
                            }
                        }
                        bVar.mo5073a();
                    }
                });
            }
        });
    }

    /* renamed from: f */
    public void mo5276f(String str) {
        if (this.f3860v) {
            if (!this.f3833H) {
                this.f3833H = true;
            }
        } else if (this.f3833H) {
            str = "00.00";
            if (this.f3845T != null) {
                this.f3845T.mo4603a((String) null);
                this.f3845T.mo4618h();
            }
            if (this.f3833H) {
                this.f3833H = false;
            }
        }
        if (this.f3845T != null) {
            this.f3845T.mo4603a(str);
            this.f3845T.mo4618h();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (this.f3853o != null) {
                    this.f3853o.mo4503b(false);
                    return;
                }
                return;
            case 1:
                if (i2 != 100) {
                    if (intent != null) {
                        final RecordTaskInfo recordTaskInfo = (RecordTaskInfo) intent.getSerializableExtra("record_head");
                        this.f3836K = recordTaskInfo;
                        if (this.f3849X != null) {
                            new Thread(new Runnable() {
                                public void run() {
                                    while (!PreviewActivity.this.f3838M) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        if (PreviewActivity.this.f3840O) {
                                            break;
                                        }
                                    }
                                    if (!PreviewActivity.this.f3840O) {
                                        PreviewActivity.this.runOnUiThread(new Runnable() {
                                            public void run() {
                                                PreviewActivity.this.m5982a(recordTaskInfo);
                                            }
                                        });
                                    }
                                }
                            }).start();
                        } else if (BaseApplication.m4928b().getInt("KEY_FILE_NAME_MODEL_MINESET", 0) != 2 || this.f3832G) {
                            m5982a(recordTaskInfo);
                        } else {
                            new Thread(new Runnable() {
                                public void run() {
                                    while (!PreviewActivity.this.f3839N) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        if (PreviewActivity.this.f3840O) {
                                            break;
                                        }
                                    }
                                    if (!PreviewActivity.this.f3840O) {
                                        PreviewActivity.this.runOnUiThread(new Runnable() {
                                            public void run() {
                                                PreviewActivity.this.m5982a(recordTaskInfo);
                                                boolean unused = PreviewActivity.this.f3839N = false;
                                            }
                                        });
                                    }
                                }
                            }).start();
                        }
                        this.f3826A = recordTaskInfo.getTask_name();
                        this.f3827B = recordTaskInfo.getTask_place();
                        this.f3834I = recordTaskInfo.getTask_start();
                        this.f3835J = recordTaskInfo.getTask_end();
                    }
                    String a = m5980a(this.f3826A, this.f3827B, this.f3834I, this.f3835J);
                    if (BaseApplication.m4928b().getInt("KEY_FILE_NAME_MODEL_MINESET", 0) != 2 || this.f3832G) {
                        this.f3858t.mo4568a(m5989b(a, true), this.f3832G, this.f3849X);
                        return;
                    }
                    m5984a(a, true);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("KEY_ACTIVITY_RESULT_PIC_PATH");
                    String stringExtra2 = intent.getStringExtra("KEY_ACTIVITY_RESULT_XML_PATH");
                    String stringExtra3 = intent.getStringExtra("KEY_ACTIVITY_RESULT_PIC_QUEXIAN_CODE");
                    m5794b("picPath = " + stringExtra + " \n xmlPath = " + stringExtra2);
                    if (this.f3843R != null) {
                        this.f3843R.setFilename(stringExtra);
                        this.f3843R.setDefectFilename(stringExtra2);
                        this.f3843R.setPipedefectCode(stringExtra3);
                        if (this.f3842Q != null) {
                            this.f3842Q.addCapturePic(this.f3843R);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @OnClick({R.id.Records, R.id.autoHorizontal, R.id.biaoji, R.id.lights_switch, R.id.preview_clearFog, R.id.preview_closeApp, R.id.preview_connectState, R.id.preview_locate, R.id.preview_picture, R.id.preview_setting, R.id.preview_video ,R.id.ranging, R.id.screenShot  })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Records:
                C1129g.m5232b();
                m5957M();
                return;
            case R.id.autoHorizontal:
                this.f3853o.mo4514m();
                return;
            case R.id.biaoji:
                m5955L();
                return;
            case R.id.lights_switch:
                m5969W();
                return;
            case R.id.preview_clearFog:
                m5967U();
                m5968V();
                return;
            case R.id.preview_closeApp:
                m5946G();
                return;
            case R.id.preview_connectState:
                new C1215d(this);
                return;
            case R.id.preview_locate:
                m5970X();
                return;
            case R.id.preview_picture:
                m5950I();
                return;
            case R.id.preview_setting:
                m5952J();
                return;
            case R.id.preview_video:
                m5948H();
                return;
            case R.id.ranging:
                m5953K();
                return;
            case R.id.screenShot:
                C1129g.m5235c();
                String a = m5980a(this.f3826A, this.f3827B, this.f3834I, this.f3835J);
                if (BaseApplication.m4928b().getInt("KEY_FILE_NAME_MODEL_MINESET", 0) == 2) {
                    m5984a(a, false);
                    return;
                }
                this.f3858t.mo4567a(m5989b(a, false));
                return;
            default:
                return;
        }
    }



    /* access modifiers changed from: protected */
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(128,128);
        setContentView((int) R.layout.welcome);
        new Timer().schedule(new TimerTask() {
            public void run() {
                PreviewActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        PreviewActivity.this.m6019v();
                    }
                });
            }
        }, 2000);
        C1139m.m5263a();
        C1139m.m5264a("app start!");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f3840O = true;
        m5794b("previewActivity finish start!");
        m5939D();
        if (this.f3845T != null) {
            this.f3845T.mo4620i();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if ((i == 4 && keyEvent.getRepeatCount() == 0) || i == 3) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (Login_info.getInstance().isYingJieMa() && this.f3857s != null) {
            this.f3857s.mo4544a();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    @OnTouch({R.id.moveDown, R.id.moveUp, R.id.size_add, R.id.size_sub, R.id.zoom_add, R.id.zoom_sub, R.id.lights_switch})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.moveDown:
                if (motionEvent.getAction() == 0) {
                    this.f3853o.mo4501b();
                }
                if (motionEvent.getAction() == 1) {
                    this.f3853o.mo4508g();
                    break;
                }
                break;
            case R.id.moveUp:
                if (motionEvent.getAction() == 0) {
                    this.f3853o.mo4497a();
                }
                if (motionEvent.getAction() == 1) {
                    this.f3853o.mo4508g();
                    break;
                }
                break;
            case R.id.size_add:
                if (motionEvent.getAction() == 0) {
                    this.f3853o.mo4504c();
                    this.f3853o.mo4500a(true);
                }
                if (motionEvent.getAction() == 1) {
                    this.f3853o.mo4508g();
                    this.f3853o.mo4500a(false);
                    break;
                }
                break;
            case R.id.size_sub:
                if (motionEvent.getAction() == 0) {
                    this.f3853o.mo4505d();
                    this.f3853o.mo4500a(true);
                }
                if (motionEvent.getAction() == 1) {
                    this.f3853o.mo4508g();
                    this.f3853o.mo4500a(false);
                    break;
                }
                break;
            case R.id.zoom_add:
                if (motionEvent.getAction() == 0) {
                    this.f3853o.mo4506e();
                }
                if (motionEvent.getAction() == 1) {
                    this.f3853o.mo4508g();
                    break;
                }
                break;
            case R.id.zoom_sub:
                if (motionEvent.getAction() == 0) {
                    this.f3853o.mo4507f();
                }
                if (motionEvent.getAction() == 1) {
                    this.f3853o.mo4508g();
                    break;
                }
                break;
        }
        return false;
    }

    /* renamed from: q */
    public void mo5119q() {
        DialogNormalFragment a = DialogNormalFragment.m5724a(getString(R.string.noSurpportHaikang), getString(R.string.isExitApp), getString(R.string.yes), getString(R.string.no), false);
        a.mo5175a((C1329a) new C1329a() {
            /* renamed from: a */
            public void mo4542a() {
                System.exit(0);
            }

            /* renamed from: b */
            public void mo4543b() {
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), a, "DialogNormalFragment");
    }

    /* renamed from: r */
    public void mo5120r() {
        if (All_id_Info.getInstance().getM_iLogID() >= 0) {
            Log.i(f3636m, "loginSuccessful: dsdfsdfs ");
            int m_iLogID = All_id_Info.getInstance().getM_iLogID();
            int m_iChanNum = All_id_Info.getInstance().getM_iChanNum();
            if (this.f3845T == null) {
                this.f3845T = new C1110b(m_iLogID, m_iChanNum, this.f3846U);
            }
            this.f3845T.mo4602a(m_iLogID, m_iChanNum);
            this.f3845T.mo4618h();
            this.f3845T.mo4600a();
            BaseApplication.f2900c.execute(new Runnable() {
                public void run() {
                    int i = 0;
                    boolean a = C1131i.m5246a(BaseApplication.m4928b().getBoolean(C1057a.f2929f, true));
                    int i2 = 0;
                    while (!a) {
                        a = C1131i.m5246a(true);
                        i2++;
                        if (i2 >= 10) {
                            break;
                        }
                    }
                    boolean z = BaseApplication.m4928b().getBoolean(C1057a.f2930g, false);
                    boolean b = C1131i.m5248b(z);
                    while (!b) {
                        b = C1131i.m5248b(z);
                        i++;
                        if (i >= 10) {
                            break;
                        }
                    }
                    C1107a.m5163a().mo4598b();
                }
            });
        }
    }

    /* renamed from: s */
    public void mo5121s() {
        runOnUiThread(new Runnable() {
            public void run() {
                if (PreviewActivity.this.f3850Y == null) {
                    ProgressDialog unused = PreviewActivity.this.f3850Y = new ProgressDialog(PreviewActivity.this.mo5210l());
                    PreviewActivity.this.f3850Y.setProgressStyle(0);
                    PreviewActivity.this.f3850Y.setMessage(PreviewActivity.this.getString(R.string.addingKanbanToRecord));
                }
                PreviewActivity.this.f3850Y.show();
            }
        });
    }

    /* renamed from: t */
    public void mo5122t() {
        this.f3838M = true;
        runOnUiThread(new Runnable() {
            public void run() {
                PreviewActivity.this.f3850Y.dismiss();
            }
        });
    }
}
