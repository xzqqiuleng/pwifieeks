package com.peek.camera.view.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.model.Environment;
import com.peek.camera.view.p037a.C1166b;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.ArrayList;
import java.util.List;

public class EnvironmentSetFragment extends Fragment {

    /* renamed from: a */
    private View f3628a;

    /* renamed from: b */
    private C1166b f3629b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public float f3630c;

    /* renamed from: d */
    private Unbinder f3631d;

    /* renamed from: e */
    private BroadcastReceiver f3632e = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            float floatExtra = intent.getFloatExtra("environment_qiya", -10000.0f);
            if (floatExtra != -10000.0f) {
                EnvironmentSetFragment.this.mo5203a(floatExtra);
            }
        }
    };
    @BindView(R.id.environment_recyclerview)
    RecyclerView eRecyclerview;

    /* renamed from: a */
    private Environment m5785a(String str, float f, String str2) {
        Environment environment = new Environment();
        environment.setCurrent_num(f);
        environment.setName(str);
        char c = 65535;
        switch (str2.hashCode()) {
            case 879095:
                if (str2.equals("气压")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                environment.setMin_num(BaseApplication.m4928b().getFloat(Environment.QIYA_MIN, 0.0f));
                environment.setMax_num(BaseApplication.m4928b().getFloat(Environment.QIYA_MAX, 16.48f));
                break;
        }
        return environment;
    }

    /* renamed from: a */
    private void m5786a() {
        getActivity().registerReceiver(this.f3632e, new IntentFilter("data.receiver"));
    }

    /* renamed from: b */
    private void m5787b() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(1);
        this.eRecyclerview.setLayoutManager(linearLayoutManager);
        this.f3629b = new C1166b(getActivity());
        this.eRecyclerview.setAdapter(this.f3629b);
        this.f3629b.mo4994a((C1166b.C1169a) new C1166b.C1169a() {
            /* renamed from: a */
            public void mo5000a() {
                EnvironmentSetFragment.this.mo5203a(EnvironmentSetFragment.this.f3630c);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.f3628a = inflater.inflate(R.layout.fragment_environment, container, false);
        this.f3631d = ButterKnife.bind((Object) this, this.f3628a);
        m5786a();
        m5787b();
        return this.f3628a;
    }

    /* renamed from: a */
    public void mo5203a(float f) {
        this.f3630c = f;
        ArrayList arrayList = new ArrayList();
        Environment[] environmentArr = {null};
        environmentArr[0] = m5785a(getString((int) R.string.airPressure), f, "气压");
        if (arrayList != null) {
            if (arrayList.size() != 0) {
                arrayList.clear();
            }
            arrayList.add(environmentArr[0]);
            if (this.f3629b != null) {
                this.f3629b.mo4996a((List<Environment>) arrayList);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.f3631d.unbind();
        getActivity().unregisterReceiver(this.f3632e);
    }

}
