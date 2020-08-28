package com.peek.camera.view.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.model.Login_info;
import com.peek.camera.view.p037a.C1197j;
import com.peek.camera.view.p040ui.RecordHeadEditActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class DialogRecordSetFragment extends DialogFragment {

    /* renamed from: aj */
    private View f3597aj;

    /* renamed from: ak */
    private int f3598ak;

    /* renamed from: al */
    private int f3599al;

    /* renamed from: am */
    private Unbinder f3600am;
    @BindView(R.id.sp_file_name_set_model)
    Spinner spinnerResetName;
    @BindView(R.id.tv_advance_recordKanban)
    Switch switchKanban;
    @BindView(R.id.tv_advance_recordName)
    Switch switchRecordName;
    @BindView(R.id.tv_advance_recordPause)
    Switch switchRecordPause;
    @BindView(R.id.tv_advance_recordAlwayShowHeader)
    Switch switchShowRecordHeader;

    /* renamed from: O */
    private void m5769O() {
        m5773S();
        m5772R();
        m5771Q();
        m5770P();
    }

    /* renamed from: P */
    private void m5770P() {
        this.switchKanban.setChecked(BaseApplication.m4928b().getBoolean("KEY_IS_OPEN_RECORD_KANBAN", false));
        this.switchKanban.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BaseApplication.m4928b().edit().putBoolean("KEY_IS_OPEN_RECORD_KANBAN", z).commit();
            }
        });
    }

    /* renamed from: Q */
    private void m5771Q() {
        this.switchShowRecordHeader.setChecked(BaseApplication.m4928b().getBoolean("KEY_IS_RECORDHEADER_ALWAYS_SHOW", true));
        this.switchShowRecordHeader.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BaseApplication.m4928b().edit().putBoolean("KEY_IS_RECORDHEADER_ALWAYS_SHOW", z).commit();
            }
        });
    }

    /* renamed from: R */
    private void m5772R() {
        this.switchRecordPause.setChecked(BaseApplication.m4928b().getBoolean("RECORD_CAN_PAUSE", false));
        this.switchRecordPause.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BaseApplication.m4928b().edit().putBoolean("RECORD_CAN_PAUSE", z).commit();
            }
        });
    }

    /* renamed from: S */
    private void m5773S() {
        this.switchRecordName.setChecked(Login_info.getInstance().isShowFirstName());
        this.switchRecordName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Login_info.getInstance().setShowFirstName(z);
            }
        });
    }

    /* renamed from: a */
    private void m5774a(Dialog dialog) {
        Window window = dialog.getWindow();
        window.setWindowAnimations(R
                .style.dialog_anim);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = displayMetrics.heightPixels;
        attributes.width = (int) (((double) displayMetrics.widthPixels) * 0.5d);
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(17170445);
        window.setGravity(17);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        this.f3597aj = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_record_setting, (ViewGroup) null);
        this.f3600am = ButterKnife.bind((Object) this, this.f3597aj);
        C1197j jVar = new C1197j(getContext(), 17367048, 16908308, getResources().getStringArray(R.array.file_name_set_model));
        jVar.setDropDownViewResource(17367049);
        this.spinnerResetName.setAdapter(jVar);
        this.spinnerResetName.setSelection(BaseApplication.m4928b().getInt("KEY_FILE_NAME_MODEL_MINESET", 0), true);
        this.spinnerResetName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                BaseApplication.m4928b().edit().putInt("KEY_FILE_NAME_MODEL_MINESET", i).commit();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        m5769O();
        Dialog b = new AlertDialog.Builder(getActivity()).setView(this.f3597aj).create();
        b.setCanceledOnTouchOutside(true);
        m5774a((Dialog) b);
        return b;
    }

    @Override
    public void onStart() {
        super.onStart();
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        if (this.f3599al == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.f3599al = displayMetrics.heightPixels;
            this.f3598ak = displayMetrics.widthPixels;
        }
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.width = (int) (((double) this.f3598ak) * 0.6d);
        getDialog().getWindow().setAttributes(attributes);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.f3600am.unbind();
    }


    @OnClick({R.id.tv_advance_recordHeadEdit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_advance_recordHeadEdit:
                Intent intent = new Intent(getActivity(), RecordHeadEditActivity.class);
                intent.putExtra("RECORD_IS_EDIT_MODEL", true);
                startActivity(intent);
                return;
            default:
                return;
        }
    }
}
