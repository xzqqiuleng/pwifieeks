package com.peek.camera.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.SeekBar;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.Unbinder;
import com.hikvision.netsdk.HCNetSDK;
import com.peek.camera.BaseApplication;
import com.peek.camera.C1057a;
import com.peek.camera.R;
import com.peek.camera.p032a.p033a.C1062b;
import com.peek.camera.p034b.C1130h;
import com.peek.camera.p034b.C1134k;
import com.peek.camera.view.p038b.C1224f;
import com.peek.camera.view.p038b.C1228g;
import com.peek.camera.view.p038b.C1229h;
import com.peek.camera.view.p038b.C1235i;
import com.peek.camera.view.p040ui.PreviewActivity;
import com.peek.camera.view.p040ui.SettingActivity;
import com.peek.camera.view.p040ui.UpdateActivity;

import java.lang.ref.WeakReference;

public class BasicSetFragment extends Fragment {

    /* renamed from: a */
    Handler f3390a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private View f3391b;

    /* renamed from: c */
    private Unbinder f3392c;

    /* renamed from: a */
    private void m5650a() {
        new C1228g(getActivity(), Settings.System.getInt(getContext().getContentResolver(), "screen_brightness", HCNetSDK.STEP_SEARCH)).mo5091a(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                int i = 40;
                int progress = seekBar.getProgress();
                if (progress >= 40) {
                    i = progress;
                }
                Settings.System.putInt(BasicSetFragment.this.getContext().getContentResolver(), "screen_brightness", i);
                int i2 = Settings.System.getInt(BasicSetFragment.this.getContext().getContentResolver(), "screen_brightness", -1);
                WindowManager.LayoutParams attributes = BasicSetFragment.this.getActivity().getWindow().getAttributes();
                float f = ((float) i2) / 255.0f;
                if (f > 0.0f && f <= 1.0f) {
                    attributes.screenBrightness = f;
                }
                BasicSetFragment.this.getActivity().getWindow().setAttributes(attributes);
            }
        });
    }

    /* renamed from: b */
    private String m5651b() {
        try {
            return getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return getString((int) R.string.noVersion);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.f3391b = inflater.inflate(R.layout.fragment_basic_setting, container, false);
        this.f3392c = ButterKnife.bind((Object) this, this.f3391b);
        return this.f3391b;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        this.f3392c.unbind();
    }



    @OnClick({R.id.light_set, R.id.sys_stat, R.id.sys_update, R.id.systemTest_set, R.id.tv_jixin_time,  R.id.tv_languageSet})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.light_set:
                m5650a();
                return;
            case R.id.sys_stat:
                new C1235i(getContext(), m5651b());
                return;
            case R.id.sys_update:
                DialogNormalFragment a = DialogNormalFragment.m5724a(getString((int) R.string.isUpdateApp), getString((int) R.string.updateAppAndClosePreview), getString((int) R.string.sure), getString((int) R.string.cancel), true);
                a.mo5175a((C1329a) new C1329a() {
                    /* renamed from: a */
                    public void mo4542a() {
                        BasicSetFragment.this.startActivity(new Intent(BasicSetFragment.this.getContext(), UpdateActivity.class));
                    }

                    /* renamed from: b */
                    public void mo4543b() {
                    }
                });
                C1130h.m5241a(getActivity().getSupportFragmentManager(), a, "DialogNormalFragment");
                return;
            case R.id.systemTest_set:
                new C1229h(getContext()).mo5093a((C1229h.C1234a) new C1229h.C1234a() {
                    /* renamed from: a */
                    public void mo5099a(boolean z) {
                        if (z) {
                            new C1062b().mo4515n();
                        }
                    }
                });
                return;
            case R.id.tv_jixin_time:
                DialogTimeSetlFragment dialogTimeSetlFragment = new DialogTimeSetlFragment();
                if (getContext() != null) {
                    C1130h.m5241a(((SettingActivity) new WeakReference((SettingActivity) getContext()).get()).getSupportFragmentManager(), dialogTimeSetlFragment, "DialogTimeSetlFragment");
                    return;
                }
                return;
            case  R.id.tv_languageSet:
                if (getContext() != null) {
                    new C1224f(getContext(), BaseApplication.m4928b().getInt(C1057a.f2931h, -1)).mo5087a((C1224f.C1227a) new C1224f.C1227a() {
                        /* renamed from: a */
                        public void mo5090a(int i) {
                            if (BasicSetFragment.this.getContext()!= null) {
                                C1134k.m5254a(i);
                                C1134k.m5255a((Context) BasicSetFragment.this.getContext(), i);
                                Intent intent = new Intent(BasicSetFragment.this.getContext(), PreviewActivity.class);
                                intent.setFlags(268468224);
                                BasicSetFragment.this.startActivity(intent);
                            }
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

//    @OnLongClick({2131231122})
//    public boolean onLongClick(View view) {
//        return true;
//    }

}
