package com.peek.camera.view.fragments;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

import com.peek.camera.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import java.util.Timer;
import java.util.TimerTask;

public class DialogNormalFragment extends DialogFragment {

    /* renamed from: aj */
    private View f3535aj;

    /* renamed from: ak */
    private boolean f3536ak;

    /* renamed from: al */
    private Timer f3537al;

    /* renamed from: am */
    private TimerTask f3538am;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public int f3539an = 6;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public String f3540ao;

    /* renamed from: ap */
    private Unbinder f3541ap;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public C1329a f3542aq;
    @BindView(R.id.img2Btn_cancel_normalDialog)
    ImageView imgCancel;
    @BindView(R.id.normal_dialog_cancel)
    TextView mCancel;
    @BindView(R.id.normal_dialog_message)
    TextView mMessage;
    @BindView(R.id.normal_dialog_sure)
    TextView mSure;
    @BindView(R.id.normal_dialog_title)
    TextView mTitle;

    /* renamed from: a */
    public static DialogNormalFragment m5724a(String str, String str2, String str3, String str4, boolean z) {
        DialogNormalFragment dialogNormalFragment = new DialogNormalFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("message", str2);
        if (str3 != null) {
            bundle.putString("sureName", str3);
        }
        if (str4 != null) {
            bundle.putString("cancelName", str4);
        }
        bundle.putBoolean("isAutoCancel", z);
        dialogNormalFragment.setArguments(bundle);
        return dialogNormalFragment;
    }

    /* renamed from: a */
    public static DialogNormalFragment m5725a(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        DialogNormalFragment dialogNormalFragment = new DialogNormalFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("message", str2);
        if (str3 != null) {
            bundle.putString("sureName", str3);
        }
        if (str4 != null) {
            bundle.putString("cancelName", str4);
        }
        bundle.putBoolean("isAutoCancel", z);
        bundle.putBoolean("isShowImgCancel", z2);
        dialogNormalFragment.setArguments(bundle);
        return dialogNormalFragment;
    }

    /* renamed from: a */
    private void m5726a(Dialog dialog) {
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

    /* renamed from: d */
    static /* synthetic */ int m5729d(DialogNormalFragment dialogNormalFragment) {
        int i = dialogNormalFragment.f3539an;
        dialogNormalFragment.f3539an = i - 1;
        return i;
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        if (getArguments().getBoolean("isAutoCancel")) {
            this.f3537al = new Timer();
            this.f3538am = new TimerTask() {
                public void run() {
                    if (DialogNormalFragment.this.mCancel != null) {
                        DialogNormalFragment.this.mCancel.post(new Runnable() {
                            public void run() {
                                if (DialogNormalFragment.this.f3539an < 0) {
                                    DialogNormalFragment.this.getDialog().dismiss();
                                    if (DialogNormalFragment.this.f3542aq != null) {
                                        DialogNormalFragment.this.f3542aq.mo4543b();
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append(DialogNormalFragment.this.f3540ao).append("(").append(DialogNormalFragment.this.f3539an).append("s)");
                                DialogNormalFragment.this.mCancel.setText(sb.toString());
                                DialogNormalFragment.m5729d(DialogNormalFragment.this);
                            }
                        });
                    }
                }
            };
            this.f3537al.schedule(this.f3538am, 0, 1000);
        }
        return super.show(transaction, tag);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        this.f3535aj = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_nomal, (ViewGroup) null);
        this.f3541ap = ButterKnife.bind((Object) this, this.f3535aj);
        this.mTitle.setText(getArguments().getString("title"));
        this.mMessage.setText(getArguments().getString("message"));
        String string = getArguments().getString("sureName");
        String string2 = getArguments().getString("cancelName");
        if (getArguments().getBoolean("isShowImgCancel", false)) {
            this.imgCancel.setVisibility(View.VISIBLE);
        }
        if (string != null) {
            this.mSure.setText(string);
        }
        if (string2 != null) {
            this.mCancel.setText(string2);
            this.f3540ao = string2;
        } else {
            this.f3540ao = getString((int) R.string.cancel);
        }
        Dialog b = new AlertDialog.Builder(getActivity()).setView(this.f3535aj).create();
        b.setCanceledOnTouchOutside(false);
        m5726a((Dialog) b);
        return b;
    }


    /* renamed from: a */
    public void mo5175a(C1329a aVar) {
        this.f3542aq = aVar;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.f3541ap.unbind();
    }

    /* renamed from: g */
    public void mo5176g(boolean z) {
        this.f3536ak = z;
    }

    @OnClick({R.id.img2Btn_cancel_normalDialog, R.id.normal_dialog_cancel, R.id.normal_dialog_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img2Btn_cancel_normalDialog:
                dismiss();
                return;
            case  R.id.normal_dialog_cancel:
                getDialog().dismiss();
                if (this.f3542aq != null) {
                    this.f3542aq.mo4543b();
                    return;
                }
                return;
            case  R.id.normal_dialog_sure:
                getDialog().dismiss();
                if (this.f3542aq != null) {
                    this.f3542aq.mo4542a();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f3536ak && this.f3542aq != null) {
            this.f3542aq.mo4543b();
        }
        if (this.f3538am != null) {
            this.f3538am.cancel();
        }
        if (this.f3537al != null) {
            this.f3537al.cancel();
        }
    }
}
