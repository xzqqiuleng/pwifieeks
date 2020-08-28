package com.peek.camera.view.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.peek.camera.R;
import com.peek.camera.view.p040ui.ManufacturerLogoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.Unbinder;
import java.util.Timer;
import java.util.TimerTask;

public class DialogManufacturerFragment extends DialogFragment {

    /* renamed from: aj */
    private View f3510aj;

    /* renamed from: ak */
    private boolean f3511ak;

    /* renamed from: al */
    private Timer f3512al;

    /* renamed from: am */
    private TimerTask f3513am;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public int f3514an = 6;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public String f3515ao;

    /* renamed from: ap */
    private String f3516ap = null;

    /* renamed from: aq */
    private Unbinder f3517aq;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public C1293a f3518ar;

    /* renamed from: as */
    private String f3519as;
    @BindView(R.id.edt_deviceName)
    TextInputEditText edtDeviceName;
    @BindView(R.id.img_manufacturer)
    ImageView img_manufacturer;
    @BindView(R.id.normal_dialog_cancel)
    TextView mCancel;
    @BindView(R.id.edt_message)
    TextInputEditText mMessage;
    @BindView(R.id.normal_dialog_sure)
    TextView mSure;
    @BindView(R.id.tv_title)
    TextView mTitle;

    /* renamed from: com.bmw.peek2.view.fragments.DialogManufacturerFragment$a */
    public interface C1293a {
        /* renamed from: a */
        void mo5172a();

        /* renamed from: a */
        void mo5173a(String str, String str2, String str3);
    }

    /* renamed from: a */
    private void m5711a(Dialog dialog) {
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

    /* renamed from: b */
    private void m5713b(String str) {
        if (this.img_manufacturer != null) {
            Glide.with(getContext()).load(str).error(R.mipmap.add_pic).into(this.img_manufacturer);

        }
    }

    /* renamed from: c */
    private void m5715c(String str) {
        Glide.with(getContext()).load(str).diskCacheStrategy(DiskCacheStrategy.NONE).error(R.mipmap.add_pic).into(this.img_manufacturer);

    }

    /* renamed from: d */
    static /* synthetic */ int m5716d(DialogManufacturerFragment dialogManufacturerFragment) {
        int i = dialogManufacturerFragment.f3514an;
        dialogManufacturerFragment.f3514an = i - 1;
        return i;
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        if (getArguments().getBoolean("isAutoCancel")) {
            this.f3512al = new Timer();
            this.f3513am = new TimerTask() {
                public void run() {
                    if (DialogManufacturerFragment.this.mCancel != null) {
                        DialogManufacturerFragment.this.mCancel.post(new Runnable() {
                            public void run() {
                                if (DialogManufacturerFragment.this.f3514an == 0) {
                                    DialogManufacturerFragment.this.getDialog().dismiss();
                                    if (DialogManufacturerFragment.this.f3518ar != null) {
                                        DialogManufacturerFragment.this.f3518ar.mo5172a();
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append(DialogManufacturerFragment.this.f3515ao).append("(").append(DialogManufacturerFragment.this.f3514an).append("s)");
                                DialogManufacturerFragment.this.mCancel.setText(sb.toString());
                                DialogManufacturerFragment.m5716d(DialogManufacturerFragment.this);
                            }
                        });
                    }
                }
            };
            this.f3512al.schedule(this.f3513am, 0, 1000);
        }
        return super.show(transaction, tag);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        this.f3510aj = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_manufacturer, (ViewGroup) null);
        this.f3517aq = ButterKnife.bind((Object) this, this.f3510aj);
        this.mTitle.setText(getArguments().getString("title"));
        this.mMessage.setText(getArguments().getString("message"));
        String string = getArguments().getString("sureName");
        this.f3516ap = string;
        String string2 = getArguments().getString("cancelName");
        if (string != null) {
            this.mSure.setText(string);
        }
        if (string2 != null) {
            this.mCancel.setText(string2);
            this.f3515ao = string2;
        } else {
            this.f3515ao = getString((int) R.string.cancel);
        }
        this.edtDeviceName.setText(getArguments().getString("deviceName"));
        this.f3519as = getArguments().getString("imgPath");
        if (this.f3519as != null) {
            m5715c(this.f3519as);
        }
        Dialog b = new AlertDialog.Builder(getActivity()).setView(this.f3510aj).create();
        b.setCanceledOnTouchOutside(false);
        m5711a((Dialog) b);
        return b;
    }



    /* renamed from: a */
    public void mo718a(int i, int i2, Intent intent) {
        if (i2 == 119 && intent != null) {
            this.f3519as = intent.getStringExtra("IMG_PATH_FLAG");
            m5713b(this.f3519as);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.f3517aq.unbind();
    }



    @OnClick({R.id.img_manufacturer, R.id.normal_dialog_cancel, R.id.normal_dialog_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_manufacturer:
                startActivityForResult(new Intent(getActivity(), ManufacturerLogoActivity.class), 110);
                return;
            case  R.id.normal_dialog_cancel:
                getDialog().dismiss();
                if (this.f3518ar != null) {
                    this.f3518ar.mo5172a();
                    return;
                }
                return;
            case  R.id.normal_dialog_sure:
                getDialog().dismiss();
                if (this.f3518ar != null) {
                    this.f3518ar.mo5173a(this.mMessage.getText().toString(), this.f3519as, this.edtDeviceName.getText().toString());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f3511ak && this.f3518ar != null) {
            this.f3518ar.mo5172a();
        }
        if (this.f3513am != null) {
            this.f3513am.cancel();
        }
        if (this.f3512al != null) {
            this.f3512al.cancel();
        }
    }

    @OnLongClick({ R.id.img_manufacturer})
    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.img_manufacturer:
                this.f3519as = null;
                if (this.img_manufacturer == null) {
                    return true;
                }
                this.img_manufacturer.post(new Runnable() {
                    public void run() {
                        DialogManufacturerFragment.this.img_manufacturer.setImageResource(R.mipmap.add_pic);
                    }
                });
                return true;
            default:
                return true;
        }
    }
}
