package com.peek.camera.view.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.peek.camera.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class DialogBiaojiFragment extends DialogFragment {

    /* renamed from: aj */
    private View f3418aj;

    /* renamed from: ak */
    private int f3419ak;

    /* renamed from: al */
    private int f3420al;

    /* renamed from: am */
    private Unbinder f3421am;

    /* renamed from: an */
    private C1259a f3422an;
    @BindView(R.id.biaoji_editext)
    EditText input;

    /* renamed from: com.bmw.peek2.view.fragments.DialogBiaojiFragment$a */
    public interface C1259a {
        /* renamed from: a */
        void mo5143a(String str);
    }

    /* renamed from: a */
    private void m5660a(Dialog dialog) {
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = displayMetrics.heightPixels;
        attributes.width = (int) (((double) displayMetrics.widthPixels) * 0.6d);
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(17170445);
        window.setGravity(17);
    }

    /* renamed from: b */
    public static DialogBiaojiFragment m5661b(String str) {
        DialogBiaojiFragment dialogBiaojiFragment = new DialogBiaojiFragment();
        Bundle bundle = new Bundle();
        bundle.putString("biaojiText", str);
        dialogBiaojiFragment.setArguments(bundle);
        return dialogBiaojiFragment;
    }

    /* renamed from: a */


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        this.f3418aj = LayoutInflater.from(getContext()).inflate(R.layout.dialog_biaoji, (ViewGroup) null);
        this.f3421am = ButterKnife.bind((Object) this, this.f3418aj);
        this.input.setText(getArguments().getString("biaojiText"));
//        Dialog b = new AlertDialog().C0583a(getActivity()).mo1776b(this.f3418aj).mo1777b();
        Dialog b = new AlertDialog.Builder(getActivity()).setView(this.f3418aj).create();

        m5660a((Dialog) b);
        return b;
    }



    /* renamed from: a */
    public void mo5140a(C1259a aVar) {
        this.f3422an = aVar;
    }

    @Override
    public void onStart() {
        super.onStart();
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        if (this.f3420al == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.f3420al = displayMetrics.heightPixels;
            this.f3419ak = displayMetrics.widthPixels;
        }
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.width = (int) (((double) this.f3419ak) * 0.5d);
        getDialog().getWindow().setAttributes(attributes);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.f3421am.unbind();
    }



    @OnClick({R.id.biaoji_cancel,  R.id.biaoji_clear, R.id.biaoji_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.biaoji_cancel:
                dismiss();
                return;
            case R.id.biaoji_clear:
                this.input.post(new Runnable() {
                    public void run() {
                        DialogBiaojiFragment.this.input.setText("");
                    }
                });
                return;
            case R.id.biaoji_sure:
                dismiss();
                if (this.f3422an != null) {
                    this.f3422an.mo5143a(this.input.getText().toString());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
