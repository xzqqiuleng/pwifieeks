package com.peek.camera.view.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.peek.camera.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;;
import java.util.Timer;
import java.util.TimerTask;

public class DialogEdtNormalFragment extends DialogFragment {

    /* renamed from: aj */
    private View f3466aj;

    /* renamed from: ak */
    private boolean f3467ak;

    /* renamed from: al */
    private Timer f3468al;

    /* renamed from: am */
    private TimerTask f3469am;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public int f3470an = 6;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public String f3471ao;

    /* renamed from: ap */
    private String f3472ap = null;

    /* renamed from: aq */
    private Unbinder f3473aq;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public C1279a f3474ar;
    @BindView(R.id.normal_dialog_cancel)
    TextView mCancel;
    @BindView(R.id.edt_message)
    EditText mMessage;
    @BindView(R.id.normal_dialog_sure)
    TextView mSure;
    @BindView(R.id.tv_title)
    TextView mTitle;

    /* renamed from: com.bmw.peek2.view.fragments.DialogEdtNormalFragment$a */
    public interface C1279a {
        /* renamed from: a */
        void mo5160a();

        /* renamed from: a */
        void mo5161a(String str);
    }

    /* renamed from: a */
    public static DialogEdtNormalFragment m5683a(String str, String str2, String str3, String str4, boolean z) {
        DialogEdtNormalFragment dialogEdtNormalFragment = new DialogEdtNormalFragment();
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
        dialogEdtNormalFragment.setArguments(bundle);
        return dialogEdtNormalFragment;
    }

    /* renamed from: a */
    private void m5684a(Dialog dialog) {
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
    static /* synthetic */ int m5687d(DialogEdtNormalFragment dialogEdtNormalFragment) {
        int i = dialogEdtNormalFragment.f3470an;
        dialogEdtNormalFragment.f3470an = i - 1;
        return i;
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        if (getArguments().getBoolean("isAutoCancel")) {
            this.f3468al = new Timer();
            this.f3469am = new TimerTask() {
                public void run() {
                    if (DialogEdtNormalFragment.this.mCancel != null) {
                        DialogEdtNormalFragment.this.mCancel.post(new Runnable() {
                            public void run() {
                                if (DialogEdtNormalFragment.this.f3470an == 0) {
                                    DialogEdtNormalFragment.this.getDialog().dismiss();
                                    if (DialogEdtNormalFragment.this.f3474ar != null) {
                                        DialogEdtNormalFragment.this.f3474ar.mo5160a();
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append(DialogEdtNormalFragment.this.f3471ao).append("(").append(DialogEdtNormalFragment.this.f3470an).append("s)");
                                DialogEdtNormalFragment.this.mCancel.setText(sb.toString());
                                DialogEdtNormalFragment.m5687d(DialogEdtNormalFragment.this);
                            }
                        });
                    }
                }
            };
            this.f3468al.schedule(this.f3469am, 0, 1000);
        }
        return super.show(transaction, tag);
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        this.f3466aj = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_edit_normal, (ViewGroup) null);
        this.f3473aq = ButterKnife.bind((Object) this, this.f3466aj);
        this.mTitle.setText(getArguments().getString("title"));
        this.mMessage.setText(getArguments().getString("message"));
        String string = getArguments().getString("sureName");
        this.f3472ap = string;
        String string2 = getArguments().getString("cancelName");
        if (string != null) {
            this.mSure.setText(string);
        }
        if (string2 != null) {
            this.mCancel.setText(string2);
            this.f3471ao = string2;
        } else {
            this.f3471ao = getString((int) R.string.cancel);
        }
        Dialog b = new AlertDialog.Builder(getActivity()).setView(this.f3466aj).create();
        b.setCanceledOnTouchOutside(false);
        m5684a((Dialog) b);
        return b;
    }


    /* renamed from: a */
    public void mo5156a(C1279a aVar) {
        this.f3474ar = aVar;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.f3473aq.unbind();
    }


    @OnClick({ R.id.normal_dialog_cancel,  R.id.normal_dialog_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.normal_dialog_cancel:
                getDialog().dismiss();
                if (this.f3474ar != null) {
                    this.f3474ar.mo5160a();
                    return;
                }
                return;
            case  R.id.normal_dialog_sure:
                getDialog().dismiss();
                if (this.f3474ar != null) {
                    String obj = this.mMessage.getText().toString();
                    if (!TextUtils.isEmpty(obj)) {
                        this.f3474ar.mo5161a(obj);
                        return;
                    } else {
                        this.f3474ar.mo5161a(this.f3472ap);
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f3467ak && this.f3474ar != null) {
            this.f3474ar.mo5160a();
        }
        if (this.f3469am != null) {
            this.f3469am.cancel();
        }
        if (this.f3468al != null) {
            this.f3468al.cancel();
        }
    }
}
