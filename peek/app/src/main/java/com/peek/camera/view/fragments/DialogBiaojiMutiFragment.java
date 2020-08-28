package com.peek.camera.view.fragments;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;

import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.model.BZInfo;
import com.peek.camera.p034b.C1118b;
import com.peek.camera.view.p037a.C1202l;
import com.peek.camera.view.view.EditSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import java.util.List;

public class DialogBiaojiMutiFragment extends DialogFragment {

    /* renamed from: aj */
    private View f3434aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public C1202l f3435ak;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public C1202l f3436al;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public C1202l f3437am;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public C1202l f3438an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public C1118b f3439ao;

    /* renamed from: ap */
    private int f3440ap;

    /* renamed from: aq */
    private int f3441aq;

    /* renamed from: ar */
    private Unbinder f3442ar;

    /* renamed from: as */
    private C1272a f3443as;
    @BindView(R.id.tiEdt_row1)
    EditSpinner tiEdtRow1;
    @BindView(R.id.tiEdt_row2)
    EditSpinner tiEdtRow2;
    @BindView(R.id.tiEdt_row3)
    EditSpinner tiEdtRow3;
    @BindView(R.id.tiEdt_row4)
    EditSpinner tiEdtRow4;
    @BindView(R.id.tl_row3)
    TextInputLayout tl_row3;
    @BindView(R.id.tl_row4)
    TextInputLayout tl_row4;

    /* renamed from: com.bmw.peek2.view.fragments.DialogBiaojiMutiFragment$a */
    public interface C1272a {
        /* renamed from: a */
        void mo5155a(String str, String str2, String str3, String str4);
    }

    /* renamed from: O */
    private void m5667O() {
        this.f3435ak = new C1202l(getContext());
        this.tiEdtRow1.setAdapter(this.f3435ak);
        this.f3436al = new C1202l(getContext());
        this.tiEdtRow2.setAdapter(this.f3436al);
        this.f3437am = new C1202l(getContext());
        this.tiEdtRow3.setAdapter(this.f3437am);
        this.f3438an = new C1202l(getContext());
        this.tiEdtRow4.setAdapter(this.f3438an);
    }

    /* renamed from: P */
    private void m5668P() {
        this.f3435ak.mo5061a(this.f3439ao.mo4632a(1));
        this.f3436al.mo5061a(this.f3439ao.mo4632a(2));
        this.f3437am.mo5061a(this.f3439ao.mo4632a(3));
        this.f3438an.mo5061a(this.f3439ao.mo4632a(4));
    }

    /* renamed from: Q */
    private void m5669Q() {
        this.tiEdtRow1.setOnItemSelectedListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                DialogBiaojiMutiFragment.this.tiEdtRow1.setText(DialogBiaojiMutiFragment.this.f3435ak.mo5060a(i));
                DialogBiaojiMutiFragment.this.tiEdtRow1.mo5371b();
            }
        });
        this.tiEdtRow1.setOnItemLongSelectecListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                DialogBiaojiMutiFragment.this.f3439ao.mo4631a(DialogBiaojiMutiFragment.this.f3435ak.mo5060a(i), 1);
                DialogBiaojiMutiFragment.this.f3435ak.mo5061a(DialogBiaojiMutiFragment.this.f3439ao.mo4632a(1));
                DialogBiaojiMutiFragment.this.tiEdtRow1.mo5371b();
                DialogBiaojiMutiFragment.this.tiEdtRow1.mo5370a();
                return true;
            }
        });
        this.tiEdtRow2.setOnItemSelectedListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                DialogBiaojiMutiFragment.this.tiEdtRow2.setText(DialogBiaojiMutiFragment.this.f3436al.mo5060a(i));
                DialogBiaojiMutiFragment.this.tiEdtRow2.mo5371b();
            }
        });
        this.tiEdtRow2.setOnItemLongSelectecListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                DialogBiaojiMutiFragment.this.f3439ao.mo4631a(DialogBiaojiMutiFragment.this.f3436al.mo5060a(i), 2);
                DialogBiaojiMutiFragment.this.f3436al.mo5061a(DialogBiaojiMutiFragment.this.f3439ao.mo4632a(2));
                DialogBiaojiMutiFragment.this.tiEdtRow2.mo5371b();
                DialogBiaojiMutiFragment.this.tiEdtRow2.mo5370a();
                return true;
            }
        });
        this.tiEdtRow3.setOnItemSelectedListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                DialogBiaojiMutiFragment.this.tiEdtRow3.setText(DialogBiaojiMutiFragment.this.f3437am.mo5060a(i));
                DialogBiaojiMutiFragment.this.tiEdtRow3.mo5371b();
            }
        });
        this.tiEdtRow3.setOnItemLongSelectecListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                DialogBiaojiMutiFragment.this.f3439ao.mo4631a(DialogBiaojiMutiFragment.this.f3437am.mo5060a(i), 3);
                DialogBiaojiMutiFragment.this.f3437am.mo5061a(DialogBiaojiMutiFragment.this.f3439ao.mo4632a(3));
                DialogBiaojiMutiFragment.this.tiEdtRow3.mo5371b();
                DialogBiaojiMutiFragment.this.tiEdtRow3.mo5370a();
                return true;
            }
        });
        this.tiEdtRow4.setOnItemSelectedListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                DialogBiaojiMutiFragment.this.tiEdtRow4.setText(DialogBiaojiMutiFragment.this.f3438an.mo5060a(i));
                DialogBiaojiMutiFragment.this.tiEdtRow4.mo5371b();
            }
        });
        this.tiEdtRow4.setOnItemLongSelectecListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                DialogBiaojiMutiFragment.this.f3439ao.mo4631a(DialogBiaojiMutiFragment.this.f3438an.mo5060a(i), 4);
                DialogBiaojiMutiFragment.this.f3438an.mo5061a(DialogBiaojiMutiFragment.this.f3439ao.mo4632a(4));
                DialogBiaojiMutiFragment.this.tiEdtRow4.mo5371b();
                DialogBiaojiMutiFragment.this.tiEdtRow4.mo5370a();
                return true;
            }
        });
    }

    /* renamed from: a */
    public static DialogBiaojiMutiFragment m5671a(String str, String str2, String str3, String str4) {
        DialogBiaojiMutiFragment dialogBiaojiMutiFragment = new DialogBiaojiMutiFragment();
        Bundle bundle = new Bundle();
        bundle.putString("biaojiText1", str);
        bundle.putString("biaojiText2", str2);
        bundle.putString("biaojiText3", str3);
        bundle.putString("biaojiText4", str4);
        dialogBiaojiMutiFragment.setArguments(bundle);
        return dialogBiaojiMutiFragment;
    }

    /* renamed from: a */
    private void m5672a(Dialog dialog) {
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

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        this.f3434aj = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_biaoji_four, (ViewGroup) null);
        this.f3442ar = ButterKnife.bind((Object) this, this.f3434aj);
        if (BaseApplication.m4928b().getBoolean("KEY_IS_RECORDHEADER_ALWAYS_SHOW", true)) {
            this.tl_row3.setVisibility(View.GONE);
            this.tl_row4.setVisibility(View.GONE);
        }
        this.tiEdtRow1.setText(getArguments().getString("biaojiText1"));
        this.tiEdtRow2.setText(getArguments().getString("biaojiText2"));
        this.tiEdtRow3.setText(getArguments().getString("biaojiText3"));
        this.tiEdtRow4.setText(getArguments().getString("biaojiText4"));
        this.f3439ao = new C1118b();
        m5667O();
        m5668P();
        m5669Q();
        Dialog b = new AlertDialog.Builder(getActivity()).setView(this.f3434aj).create();
        m5672a((Dialog) b);
        return b;
    }


    /* renamed from: a */
    public void mo5144a(C1272a aVar) {
        this.f3443as = aVar;
    }

    /* renamed from: e */

    @Override
    public void onStart() {
        super.onStart();
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        if (this.f3441aq == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.f3441aq = displayMetrics.heightPixels;
            this.f3440ap = displayMetrics.widthPixels;
        }
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.width = (int) (((double) this.f3440ap) * 0.6d);
        getDialog().getWindow().setAttributes(attributes);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.f3442ar.unbind();
    }

    /* renamed from: g */

    @OnClick({R.id.biaoji_cancel,  R.id.biaoji_clear, R.id.biaoji_clear_history, R.id.biaoji_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.biaoji_cancel:
                dismiss();
                return;
            case  R.id.biaoji_clear:
                this.tiEdtRow1.post(new Runnable() {
                    public void run() {
                        DialogBiaojiMutiFragment.this.tiEdtRow1.setText("");
                        DialogBiaojiMutiFragment.this.tiEdtRow2.setText("");
                        DialogBiaojiMutiFragment.this.tiEdtRow3.setText("");
                        DialogBiaojiMutiFragment.this.tiEdtRow4.setText("");
                    }
                });
                return;
            case  R.id.biaoji_clear_history:
                this.f3439ao.mo4629a();
                this.f3435ak.mo5061a(this.f3439ao.mo4632a(1));
                this.f3436al.mo5061a(this.f3439ao.mo4632a(2));
                this.f3437am.mo5061a(this.f3439ao.mo4632a(3));
                this.f3438an.mo5061a(this.f3439ao.mo4632a(4));
                return;
            case  R.id.biaoji_sure:
                dismiss();
                if (this.f3443as != null) {
                    this.f3443as.mo5155a(this.tiEdtRow1.getText().toString(), this.tiEdtRow2.getText().toString(), this.tiEdtRow3.getText().toString(), this.tiEdtRow4.getText().toString());
                }
                if (!TextUtils.isEmpty(this.tiEdtRow1.getText().toString())) {
                    this.f3439ao.mo4630a(new BZInfo(0, this.tiEdtRow1.getText().toString(), System.currentTimeMillis(), 1), (List<BZInfo>) null);
                }
                if (!TextUtils.isEmpty(this.tiEdtRow2.getText().toString())) {
                    this.f3439ao.mo4630a(new BZInfo(0, this.tiEdtRow2.getText().toString(), System.currentTimeMillis(), 2), (List<BZInfo>) null);
                }
                if (!TextUtils.isEmpty(this.tiEdtRow3.getText().toString())) {
                    this.f3439ao.mo4630a(new BZInfo(0, this.tiEdtRow3.getText().toString(), System.currentTimeMillis(), 3), (List<BZInfo>) null);
                }
                if (!TextUtils.isEmpty(this.tiEdtRow4.getText().toString())) {
                    this.f3439ao.mo4630a(new BZInfo(0, this.tiEdtRow4.getText().toString(), System.currentTimeMillis(), 4), (List<BZInfo>) null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
