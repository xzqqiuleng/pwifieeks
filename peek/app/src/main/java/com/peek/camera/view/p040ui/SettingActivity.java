package com.peek.camera.view.p040ui;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.peek.camera.R;
import com.peek.camera.p034b.C1104a;
import com.peek.camera.p034b.C1130h;
import com.peek.camera.view.fragments.AdvanceSetFragment;
import com.peek.camera.view.fragments.BasicSetFragment;
import com.peek.camera.view.fragments.C1329a;
import com.peek.camera.view.fragments.DialogNormalFragment;
import com.peek.camera.view.fragments.EnvironmentSetFragment;
import java.io.PrintWriter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/* renamed from: com.bmw.peek2.view.ui.SettingActivity */
public class SettingActivity extends BaseActivity {
    @BindView(R.id.tv_battery_device)
    TextView battery_device;
    @BindView(R.id.tv_battery_device_title)
    TextView battery_device_title;
    @BindView(R.id.tv_battery_terminal)
    TextView battery_terminal;
    @BindView(R.id.tv_battery_terminal_title)
    TextView battery_terminal_title;
    @BindView(R.id.setting_containerRg)
    RadioGroup containerRg;
    @BindView(R.id.setting_fragment_contain)
    FrameLayout fragmentContain;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public EnvironmentSetFragment f4045o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public AdvanceSetFragment f4046p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public BasicSetFragment f4047q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public FragmentManager f4048r;

    /* renamed from: s */
    private Unbinder f4049s;

    /* renamed from: t */
    private BroadcastReceiver f4050t = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            C1104a.m5161a(SettingActivity.this.mo5210l(), intent, SettingActivity.this.battery_terminal, SettingActivity.this.battery_terminal_title);
            C1104a.m5162b(SettingActivity.this.mo5210l(), intent, SettingActivity.this.battery_device, SettingActivity.this.battery_device_title);
        }
    };

    /* renamed from: q */
    private void m6103q() {
        IntentFilter intentFilter = new IntentFilter("data.receiver");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        registerReceiver(this.f4050t, intentFilter);
    }

    /* renamed from: r */
    private void m6104r() {
        C1104a.m5162b(mo5210l(), getIntent(), this.battery_device, this.battery_device_title);
    }

    /* renamed from: s */
    private void m6105s() {
        this.f4047q = new BasicSetFragment();
        this.f4048r = getSupportFragmentManager();
        FragmentTransaction a = this.f4048r.beginTransaction();
        a.replace((int) R.id.setting_fragment_contain,  this.f4047q);
        a.commit();
    }

    /* renamed from: t */
    private void m6106t() {

        this.containerRg.check(R.id.basic_setingRd);
        this.containerRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentTransaction a = SettingActivity.this.f4048r.beginTransaction();
                Fragment a2 = SettingActivity.this.f4048r.findFragmentById((int) R.id.setting_fragment_contain);
                switch (i) {
                    case R.id.advance_settingRd:
                        if (SettingActivity.this.f4046p == null) {
                            AdvanceSetFragment unused = SettingActivity.this.f4046p = new AdvanceSetFragment();
                        }
                        a.replace
                                ((int) R.id.setting_fragment_contain,  SettingActivity.this.f4046p);
//                        a.hide(a2);
                        break;
                    case R.id.basic_setingRd:
                        a.replace((int) R.id.setting_fragment_contain, SettingActivity.this.f4047q);
//                        a.hide(a2);
                        break;
                    case R.id.environment_settingRd:
                        if (SettingActivity.this.f4045o == null) {
                            EnvironmentSetFragment unused2 = SettingActivity.this.f4045o = new EnvironmentSetFragment();
                        }
                        a.replace((int) R.id.setting_fragment_contain, SettingActivity.this.f4045o);
//                        a.hide(a2);
                        break;
                }
                a.commit();
            }
        });
    }

    /* renamed from: u */
    private void m6107u() {
        DialogNormalFragment a = DialogNormalFragment.m5724a(getString(R.string.exitingApp), getString(R.string.exitAppSure), (String) null, (String) null, true);
        a.mo5175a((C1329a) new C1329a() {
            /* renamed from: a */
            public void mo4542a() {
                SettingActivity.this.mo5213o();
            }

            /* renamed from: b */
            public void mo4543b() {
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), a, "DialogNormalFragment");
    }

    @OnClick({R.id.preview_closeApp, R.id.setting_goback})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.preview_closeApp:
                m6107u();
                return;
            case  R.id.setting_goback:
                mo5212n();
                return;
            default:
                return;


        }
    }

    /* access modifiers changed from: protected */
    @Override
    public void onCreate(Bundle bundle) {

        super.onCreate(bundle);
        setContentView((int) R.layout.activity_setting);
        this.f4049s = ButterKnife.bind((Activity) this);


    }

    /* access modifiers changed from: protected */

    @Override
    public void onDestroy() {

        super.onDestroy();
        this.f4049s.unbind();
        unregisterReceiver(this.f4050t);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            mo5212n();
            return true;
        } else if (i != 3) {
            return super.onKeyDown(i, keyEvent);
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override
    public void onResume() {
        super.onResume();
        m6104r();
        m6103q();
        m6105s();
        m6106t();
    }
}
