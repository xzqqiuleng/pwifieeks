package com.peek.camera.view.p038b;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.WIFIAutoConnectionService;
import com.peek.camera.model.Login_info;
import com.peek.camera.p034b.C1116aa;
import com.peek.camera.p034b.C1141o;
import com.peek.camera.p034b.C1159z;


/* renamed from: com.bmw.peek2.view.b.d */
public class C1215d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AlertDialog f3311a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f3312b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f3313c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f3314d;

    /* renamed from: e */
    private RadioGroup f3315e;

    /* renamed from: f */
    private RadioButton f3316f;

    /* renamed from: g */
    private RadioButton f3317g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Context f3318h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C1159z f3319i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C1220a f3320j;

    /* renamed from: com.bmw.peek2.view.b.d$a */
    public interface C1220a {
        /* renamed from: a */
        void mo5083a();
    }
    boolean isCanCon;
    public C1215d(final Context context) {
        this.f3318h = context;
        this.f3319i = new C1159z(context);
        this.f3311a = new AlertDialog.Builder(context).create();
        Window window = this.f3311a.getWindow();
        window.setWindowAnimations(R.style.dialog_anim);
        this.f3311a.show();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        WindowManager.LayoutParams attributes = this.f3311a.getWindow().getAttributes();
        attributes.width = (int) (((double) displayMetrics.widthPixels) * 0.5d);
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(17170445);
        window.setGravity(17);
        window.setContentView(R.layout.dialog_connect_state);
        this.f3312b = (ImageView) window.findViewById(R.id.connect_video_connect);
        this.f3313c = (ImageView) window.findViewById(R.id.connect_control_connect);
        this.f3315e = (RadioGroup) window.findViewById(R.id.radioGroup_dialog_connectStatic);
        this.f3316f = (RadioButton) window.findViewById(R.id.rb_connect_mainFrame);
        this.f3317g = (RadioButton) window.findViewById(R.id.rb_connect_repeater);
        new C1159z(context);
        if (Login_info.getInstance().isWifi_auto()) {
            this.f3315e.setVisibility(0);
        } else {
            this.f3315e.setVisibility(4);
        }
//        m5576c();
//        m5569a();
         isCanCon = false;
        f3315e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 switch (checkedId){
                     case R.id.rb_connect_mainFrame:
                         if (BaseApplication.m4928b().getString("VIDEO_IP1","").equals("")){
                             Toast.makeText(context,"你还没有进行中继网路设置",Toast.LENGTH_SHORT).show();
                         }else {
                             isCanCon = true;
                         }
                         break;

                     case R.id.rb_connect_repeater:
                         if (BaseApplication.m4928b().getString("VIDEO_IP2","").equals("")){
                             Toast.makeText(context,"你还没有进行主机网路设置",Toast.LENGTH_SHORT).show();
                         }else {
                             isCanCon = true;
                         }
                         break;
                 }
            }
        });
        this.f3311a.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
              boolean checked1 =  f3316f.isChecked();
              boolean checked2 =  f3317g.isChecked();

              int type = BaseApplication.m4928b().getInt("TCP_PORT1",0);
              if (type == 0 && checked2){
                  BaseApplication.m4928b().edit().putString(Login_info.VIDEO_IP,BaseApplication.m4928b().getString("VIDEO_IP1","")).commit();
                  BaseApplication.m4928b().edit().putString(Login_info.VIDEO_ACCOUNT,BaseApplication.m4928b().getString("VIDEO_ACCOUNT1","")).commit();
                  BaseApplication.m4928b().edit().putString(Login_info.VIDEO_PASSWORD,BaseApplication.m4928b().getString("VIDEO_PASSWORD1","")).commit();
                  BaseApplication.m4928b().edit().putString(Login_info.baseMainFrameWifiSSID,BaseApplication.m4928b().getString("baseMainFrameWifiSSID1","")).commit();
                  BaseApplication.m4928b().edit().putString(Login_info.baseRepeaterWifiSSID,BaseApplication.m4928b().getString("baseMainFrameWifiSSID1","")).commit();
                  BaseApplication.m4928b().edit().putString("TCP_IP",BaseApplication.m4928b().getString("TCP_IP1","")).commit();

                  BaseApplication.m4928b().edit().putInt("TCP_PORT",BaseApplication.m4928b().getInt("TCP_PORT1",-1)).commit();
                  BaseApplication.m4928b().edit().putString("WIFIPD",BaseApplication.m4928b().getString("WIFIPD1","")).commit();
                  WIFIAutoConnectionService.start(context,BaseApplication.m4928b().getString("baseMainFrameWifiSSID1",""),BaseApplication.m4928b().getString("WIFIPD1",""));
              }else  if(type == 1 && checked1){
                  BaseApplication.m4928b().edit().putString(Login_info.VIDEO_IP,BaseApplication.m4928b().getString("VIDEO_IP2","")).commit();
                  BaseApplication.m4928b().edit().putString(Login_info.VIDEO_ACCOUNT,BaseApplication.m4928b().getString("VIDEO_ACCOUNT2","")).commit();
                  BaseApplication.m4928b().edit().putString(Login_info.VIDEO_PASSWORD,BaseApplication.m4928b().getString("VIDEO_PASSWORD2","")).commit();
                  BaseApplication.m4928b().edit().putString(Login_info.baseMainFrameWifiSSID,BaseApplication.m4928b().getString("baseMainFrameWifiSSID2","")).commit();
                  BaseApplication.m4928b().edit().putString(Login_info.baseRepeaterWifiSSID,BaseApplication.m4928b().getString("baseMainFrameWifiSSID2","")).commit();
                  BaseApplication.m4928b().edit().putString("TCP_IP",BaseApplication.m4928b().getString("TCP_IP2","")).commit();

                  BaseApplication.m4928b().edit().putInt("TCP_PORT",BaseApplication.m4928b().getInt("TCP_PORT2",-1)).commit();
                  BaseApplication.m4928b().edit().putString("WIFIPD",BaseApplication.m4928b().getString("WIFIPD2","")).commit();
                  WIFIAutoConnectionService.start(context,BaseApplication.m4928b().getString("baseMainFrameWifiSSID2",""),BaseApplication.m4928b().getString("WIFIPD2",""));
              }



            }
        });
        m5578d();
    }

    /* renamed from: a */
    private void m5569a() {
        if (Login_info.getInstance().isWifiIsRepeater()) {
            this.f3315e.check(R.id.rb_connect_repeater);
        } else {
            this.f3315e.check(R.id.rb_connect_mainFrame);
        }
        this.f3315e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                C1159z zVar = new C1159z(C1215d.this.f3318h);
                switch (i) {
                    case R.id.rb_connect_mainFrame:
                        Login_info.getInstance().setWifiIsRepeater(false);
                        C1215d.this.m5570a(zVar, Login_info.baseMainFrameWifiSSID);
                        C1215d.this.m5575b();
                        return;
                    case R.id.rb_connect_repeater:
                        Login_info.getInstance().setWifiIsRepeater(true);
                        C1215d.this.m5570a(zVar, Login_info.baseRepeaterWifiSSID);
                        C1215d.this.m5575b();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5570a(C1159z zVar, String str) {
        if (Login_info.getInstance().isWifi_auto()) {
            String g = zVar.mo4690g();
            if (!TextUtils.isEmpty(g) && !g.contains(str)) {
                zVar.mo4682a(zVar.mo4689f());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5575b() {
        if (Login_info.getInstance().isWifi_auto()) {
            C1116aa.m5196a(this.f3318h);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5576c() {
        /*
            r7 = this;
            r5 = 2131427344(0x7f0b0010, float:1.8476302E38)
            r4 = 2131427341(0x7f0b000d, float:1.8476296E38)
            r1 = 0
            com.bmw.peek2.b.o r0 = com.bmw.peek2.p034b.C1141o.m5272a()
            boolean r3 = r0.mo4667c()
            com.bmw.peek2.b.o r0 = com.bmw.peek2.p034b.C1141o.m5272a()
            boolean r2 = r0.mo4668d()
            com.bmw.peek2.model.Login_info r0 = com.bmw.peek2.model.Login_info.getInstance()
            boolean r0 = r0.isWifi_auto()
            if (r0 == 0) goto L_0x0055
            com.bmw.peek2.b.z r0 = r7.f3319i
            if (r0 == 0) goto L_0x0055
            com.bmw.peek2.model.Login_info r0 = com.bmw.peek2.model.Login_info.getInstance()
            boolean r0 = r0.isWifiIsRepeater()
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = "Peek2S_Relay_AP"
        L_0x0031:
            com.bmw.peek2.b.z r6 = r7.f3319i
            java.lang.String r6 = r6.mo4690g()
            boolean r0 = r6.contains(r0)
            if (r0 != 0) goto L_0x0055
            r0 = r1
        L_0x003e:
            android.widget.ImageView r2 = r7.f3312b
            if (r1 == 0) goto L_0x0051
            r1 = r4
        L_0x0043:
            r2.setImageResource(r1)
            android.widget.ImageView r1 = r7.f3313c
            if (r0 == 0) goto L_0x0053
        L_0x004a:
            r1.setImageResource(r4)
            return
        L_0x004e:
            java.lang.String r0 = "Peek2S_AP"
            goto L_0x0031
        L_0x0051:
            r1 = r5
            goto L_0x0043
        L_0x0053:
            r4 = r5
            goto L_0x004a
        L_0x0055:
            r0 = r2
            r1 = r3
            goto L_0x003e
        */
//        throw new UnsupportedOperationException("Method not decompiled: com.bmw.peek2.view.p038b.C1215d.m5576c():void");
    }

    /* renamed from: d */
    private void m5578d() {
        new Thread(new Runnable() {
            public void run() {
                while (!C1215d.this.f3314d) {
                    C1141o.m5272a().mo4665b();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (C1215d.this.f3312b != null) {
                        C1215d.this.f3312b.post(new Runnable() {
                            /* JADX WARNING: Removed duplicated region for block: B:12:0x0054  */
                            /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
                            /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public void run() {
                                /*
                                    r7 = this;
                                    r5 = 2131427344(0x7f0b0010, float:1.8476302E38)
                                    r4 = 2131427341(0x7f0b000d, float:1.8476296E38)
                                    r1 = 0
                                    com.bmw.peek2.b.o r0 = com.bmw.peek2.p034b.C1141o.m5272a()
                                    boolean r3 = r0.mo4667c()
                                    com.bmw.peek2.b.o r0 = com.bmw.peek2.p034b.C1141o.m5272a()
                                    boolean r2 = r0.mo4668d()
                                    com.bmw.peek2.model.Login_info r0 = com.bmw.peek2.model.Login_info.getInstance()
                                    boolean r0 = r0.isWifi_auto()
                                    if (r0 == 0) goto L_0x006d
                                    com.bmw.peek2.view.b.d$3 r0 = com.bmw.peek2.view.p038b.C1215d.C12183.this
                                    com.bmw.peek2.view.b.d r0 = com.bmw.peek2.view.p038b.C1215d.this
                                    com.bmw.peek2.b.z r0 = r0.f3319i
                                    if (r0 == 0) goto L_0x006d
                                    com.bmw.peek2.model.Login_info r0 = com.bmw.peek2.model.Login_info.getInstance()
                                    boolean r0 = r0.isWifiIsRepeater()
                                    if (r0 == 0) goto L_0x0066
                                    java.lang.String r0 = "Peek2S_Relay_AP"
                                L_0x0037:
                                    com.bmw.peek2.view.b.d$3 r6 = com.bmw.peek2.view.p038b.C1215d.C12183.this
                                    com.bmw.peek2.view.b.d r6 = com.bmw.peek2.view.p038b.C1215d.this
                                    com.bmw.peek2.b.z r6 = r6.f3319i
                                    java.lang.String r6 = r6.mo4690g()
                                    boolean r0 = r6.contains(r0)
                                    if (r0 != 0) goto L_0x006d
                                    r0 = r1
                                L_0x004a:
                                    com.bmw.peek2.view.b.d$3 r2 = com.bmw.peek2.view.p038b.C1215d.C12183.this
                                    com.bmw.peek2.view.b.d r2 = com.bmw.peek2.view.p038b.C1215d.this
                                    android.widget.ImageView r2 = r2.f3312b
                                    if (r1 == 0) goto L_0x0069
                                    r1 = r4
                                L_0x0055:
                                    r2.setImageResource(r1)
                                    com.bmw.peek2.view.b.d$3 r1 = com.bmw.peek2.view.p038b.C1215d.C12183.this
                                    com.bmw.peek2.view.b.d r1 = com.bmw.peek2.view.p038b.C1215d.this
                                    android.widget.ImageView r1 = r1.f3313c
                                    if (r0 == 0) goto L_0x006b
                                L_0x0062:
                                    r1.setImageResource(r4)
                                    return
                                L_0x0066:
                                    java.lang.String r0 = "Peek2S_AP"
                                    goto L_0x0037
                                L_0x0069:
                                    r1 = r5
                                    goto L_0x0055
                                L_0x006b:
                                    r4 = r5
                                    goto L_0x0062
                                L_0x006d:
                                    r0 = r2
                                    r1 = r3
                                    goto L_0x004a
                                */
//                                throw new UnsupportedOperationException("Method not decompiled: com.bmw.peek2.view.p038b.C1215d.C12183.C12191.run():void");
                            }
                        });
                    }
                }
            }
        }).start();
    }
}
