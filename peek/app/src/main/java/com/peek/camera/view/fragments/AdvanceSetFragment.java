package com.peek.camera.view.fragments;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import com.peek.camera.BaseApplication;
import com.peek.camera.C1057a;
import com.peek.camera.R;
import com.peek.camera.model.Login_info;
import com.peek.camera.p034b.C1116aa;
import com.peek.camera.p034b.C1129g;
import com.peek.camera.p034b.C1130h;
import com.peek.camera.service.MyIntentService;
import com.peek.camera.view.p038b.C1203a;
import com.peek.camera.view.p040ui.SettingActivity;

import java.lang.ref.WeakReference;
import java.util.List;

public class AdvanceSetFragment extends Fragment {

    /* renamed from: a */
    private View f3373a;

    /* renamed from: b */
    private Intent f3374b;

    /* renamed from: c */
    private Unbinder f3375c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f3376d;
    @BindView(R.id.switch_advance_geoinverseCode)
    Switch swGeoinverseCode;
    @BindView(R.id.switch_advance_subStream)
    Switch swSubStream;
    @BindView(R.id.switch_advance_autoWifi)
    Switch switchAutoWifi;
    @BindView(R.id.tv_advance_fileSavePath)
    Switch switchSavePath;
    @BindView(R.id.switch_advance_yingjiema)
    Switch switchYingjiema;

    /* renamed from: O */
    private void m5633O() {
        this.switchSavePath.setChecked(Login_info.getInstance().isSaveToExSdcard());
        this.switchSavePath.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    AdvanceSetFragment.this.m5634P();
                } else {
                    Login_info.getInstance().setSaveToExSdcard(z);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public void m5634P() {
        List<String> a = C1129g.m5224a( getContext());
        if (a.size() <= 1) {
            m5635Q();
        } else if (!a.get(a.size() - 1).contains("Android/data")) {
            Login_info.getInstance().setSaveToExSdcard(true);
            C1129g.m5232b();
            C1129g.m5235c();
        } else {
            DialogNormalFragment a2 = DialogNormalFragment.m5724a(getString((int) R.string.alarm), getString((int) R.string.fileSaveDangerousIn4) + "\n\n  " + getString((int) R.string.fileSaveTo) + "\n" + a.get(1) + getString((int) R.string.canMove) + " \n\n " + getString((int) R.string.fileDeleteAfterAppDelete) + "\n\n " + getString((int) R.string.sureSaveToSdcard), (String) null, (String) null, true);
            a2.mo5176g(true);
            a2.mo5175a((C1329a) new C1329a() {
                /* renamed from: a */
                public void mo4542a() {
                    Login_info.getInstance().setSaveToExSdcard(true);
                    C1129g.m5232b();
                    C1129g.m5235c();
                }

                /* renamed from: b */
                public void mo4543b() {
                    if (!Login_info.getInstance().isSaveToExSdcard()) {
                        AdvanceSetFragment.this.switchSavePath.setChecked(false);
                    }
                }
            });
            m5641a((DialogFragment) a2, "DialogNormalFragment");
        }
    }

    /* renamed from: Q */
    private void m5635Q() {
        BaseApplication.m4926a(getString((int) R.string.noOutSdcard));
        this.switchSavePath.setChecked(false);
    }

    /* renamed from: R */
    private void m5636R() {
        this.switchYingjiema.setChecked(Login_info.getInstance().isYingJieMa());
        this.switchYingjiema.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Login_info.getInstance().setYingJieMa(z);
                boolean unused = AdvanceSetFragment.this.f3376d = true;
            }
        });
    }

    /* renamed from: S */
    private void m5637S() {
        Intent intent = new Intent();
        intent.setAction("data.receiver");
        intent.putExtra("isReLoginHK", true);
        getContext().sendBroadcast(intent);
    }

    /* renamed from: T */
    private void m5638T() {
    }

    /* renamed from: U */
    private void m5639U() {
        this.f3374b = new Intent();
        this.f3374b.setAction("data.receiver");
    }

    /* renamed from: a */
    private void m5640a() {
        this.swSubStream.setChecked(C1057a.m4936a());
        this.swSubStream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C1057a.m4935a(z);
                boolean unused = AdvanceSetFragment.this.f3376d = true;
            }
        });
    }

    /* renamed from: a */
    private void m5641a(DialogFragment dialogFragment, String str) {
//        C0200u a = mo757k().mo790e().mo871a();
//        C0176k a2 = mo757k().mo790e().mo870a(str);
//        if (a2 != null) {
//            a.mo669a(a2);
//        }
//        dialogFragment.mo627a(a, str);
        FragmentTransaction a =getActivity().getSupportFragmentManager().beginTransaction();
        Fragment a2 = getActivity().getSupportFragmentManager().findFragmentByTag(str);
        if (a2 != null) {
            a.hide(a2);
        }
        dialogFragment.show(a, str);
    }

    /* renamed from: b */
    private void m5644b() {
        this.swGeoinverseCode.setChecked(BaseApplication.m4928b().getBoolean(C1057a.f2925b, false));
        this.swGeoinverseCode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BaseApplication.m4928b().edit().putBoolean(C1057a.f2925b, z).commit();
            }
        });
    }

    /* renamed from: c */
    private void m5645c() {
        this.switchAutoWifi.setChecked(Login_info.getInstance().isWifi_auto());
        this.switchAutoWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Login_info.getInstance().setWifi_auto(z, true);
                if (z) {
                    C1116aa.m5196a(AdvanceSetFragment.this.getContext());
                } else {
                    MyIntentService.m5357a(AdvanceSetFragment.this.getContext());
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.f3373a = inflater.inflate(R.layout.fragment_advance_setting, container, false);
        this.f3375c = ButterKnife.bind((Object) this, this.f3373a);
        m5639U();
        m5638T();
        m5636R();
        m5633O();
        m5645c();
        m5644b();
        m5640a();
        return this.f3373a;
    }



    @Override
    public void onDestroy() {
        if (this.f3376d) {
            m5637S();
        }
        super.onDestroy();
        this.f3375c.unbind();
    }


    @OnClick({R.id.tv_advance_cameraSet, R.id.tv_advance_recordSet})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_advance_cameraSet:
                new C1203a(getContext());
                return;
            case R.id.tv_advance_recordSet:
                DialogRecordSetFragment dialogRecordSetFragment = new DialogRecordSetFragment();
                if (getContext() != null) {
                    C1130h.m5241a(((SettingActivity) new WeakReference((SettingActivity) getActivity()).get()).getSupportFragmentManager(), dialogRecordSetFragment, "DialogRecordSetFragment");

                    return;
                }
                return;
            default:
                return;
        }
    }
}
