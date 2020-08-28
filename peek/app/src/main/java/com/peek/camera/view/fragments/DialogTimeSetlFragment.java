package com.peek.camera.view.fragments;
import android.app.AlertDialog;
import android.app.Dialog;
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
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hikvision.netsdk.NET_DVR_TIME;
import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.p034b.C1131i;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1157x;

public class DialogTimeSetlFragment extends DialogFragment {

    /* renamed from: aj */
    private View f3613aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public boolean f3614ak;

    /* renamed from: al */
    private Unbinder f3615al;
    @BindView(R.id.new_act_date_picker)
    DatePicker newActDatePicker;
    @BindView(R.id.new_act_time_picker)
    TimePicker newActTimePicker;
    @BindView(R.id.sw_osd_time_show)
    Switch sw_osd_show;
    @BindView(R.id.sys_title)
    TextView sysTitle;
    @BindView(R.id.tv_current_jixin_time)
    TextView tv_current_time;
    @BindView(R.id.tv_osd_time_show)
    TextView tv_osd_show;

    /* renamed from: O */
    private void m5778O() {
        new Thread(new Runnable() {
            public void run() {
                NET_DVR_TIME a = C1131i.m5242a();
                StringBuilder sb = null;
                if (a != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(a.dwYear).append("-").append(a.dwMonth).append("-").append(a.dwDay < 10 ? 0 : "").append(a.dwDay).append(" ").append(a.dwHour < 10 ? 0 : "").append(a.dwHour).append(":").append(a.dwMinute < 10 ? 0 : "").append(a.dwMinute);
                    sb = sb2;
                }
                if (DialogTimeSetlFragment.this.tv_current_time != null) {
                    final StringBuilder finalSb = sb;
                    DialogTimeSetlFragment.this.tv_current_time.post(new Runnable() {
                        public void run() {
                            if (finalSb != null) {
                                DialogTimeSetlFragment.this.tv_current_time.setText(finalSb.toString());
                            } else {
                                DialogTimeSetlFragment.this.tv_current_time.setText(DialogTimeSetlFragment.this.getString((int) R.string.no_get));
                            }
                        }
                    });
                }
            }
        }).start();
        boolean z = BaseApplication.m4928b().getBoolean("KEY_OSD_IS_SHOW_TIME_ON_DEVICE", false);
        this.f3614ak = !z;
        if (z) {
            this.sw_osd_show.setChecked(false);
            this.tv_osd_show.setText(getString((int) R.string.close));
        } else {
            this.sw_osd_show.setChecked(true);
            this.tv_osd_show.setText(getString((int) R.string.open));
        }
        this.sw_osd_show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    DialogTimeSetlFragment.this.tv_osd_show.setText(DialogTimeSetlFragment.this.getString((int) R.string.open));
                } else {
                    DialogTimeSetlFragment.this.tv_osd_show.setText(DialogTimeSetlFragment.this.getString((int) R.string.close));
                }
                boolean unused = DialogTimeSetlFragment.this.f3614ak = z;
            }
        });
    }

    /* renamed from: a */
    private void m5779a(Dialog dialog) {
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.dialog_anim);
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
        this.f3613aj = LayoutInflater.from(getActivity()).inflate(R.layout.time_set, (ViewGroup) null);
        this.f3615al = ButterKnife.bind((Object) this, this.f3613aj);
        this.newActTimePicker.setIs24HourView(true);
        Dialog b = new AlertDialog.Builder(getActivity()).setView(this.f3613aj).create();
        b.setCanceledOnTouchOutside(true);
        m5779a((Dialog) b);
        return b;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.f3615al.unbind();
    }

    @OnClick({ R.id.tv_sure,R.id.tv_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_sure:
                if (this.f3614ak) {
                    C1140n.m5266a("time = " + this.newActDatePicker.getYear() + " " + this.newActDatePicker.getMonth() + " " + this.newActDatePicker.getDayOfMonth() + " " + this.newActTimePicker.getCurrentHour() + " " + this.newActTimePicker.getCurrentMinute() + " " + C1157x.m5333a());
                    C1131i.m5244a(this.newActDatePicker.getYear(), this.newActDatePicker.getMonth() + 1, this.newActDatePicker.getDayOfMonth(), this.newActTimePicker.getCurrentHour().intValue(), this.newActTimePicker.getCurrentMinute().intValue(), Integer.valueOf(C1157x.m5333a()).intValue());
                }
                BaseApplication.m4928b().edit().putBoolean("KEY_OSD_IS_SHOW_TIME_ON_DEVICE", !this.f3614ak).commit();
                new Thread(new Runnable() {
                    public void run() {
                        C1131i.m5243a("", true);
                    }
                }).start();
                break;
        }
        dismiss();
    }

    @Override
    public void onStart() {
        super.onStart();
        m5778O();
    }

}
