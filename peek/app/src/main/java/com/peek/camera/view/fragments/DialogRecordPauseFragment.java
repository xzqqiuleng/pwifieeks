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

import com.peek.camera.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class DialogRecordPauseFragment extends DialogFragment {

    /* renamed from: aj */
    private View f3586aj;

    /* renamed from: ak */
    private Unbinder f3587ak;

    /* renamed from: al */
    private View.OnClickListener f3588al;

    /* renamed from: am */
    private View.OnClickListener f3589am;

    /* renamed from: a */
    private void m5765a(Dialog dialog) {
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
        this.f3586aj = LayoutInflater.from(getActivity()).inflate(R.layout.record_end_layout, (ViewGroup) null);
        this.f3587ak = ButterKnife.bind((Object) this, this.f3586aj);
        Dialog b = new AlertDialog.Builder(getActivity()).setView(this.f3586aj).create();
        b.setCanceledOnTouchOutside(false);
        m5765a((Dialog) b);
        return b;
    }


    /* renamed from: a */
    public void mo5189a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f3588al = onClickListener;
        this.f3589am = onClickListener2;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.f3587ak.unbind();
    }

    @OnClick({2131231188, 2131231189})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_record_pause:
                this.f3588al.onClick(view);
                break;
            case R.id.tv_record_stop:
                this.f3589am.onClick(view);
                break;
        }
        dismiss();
    }
}
