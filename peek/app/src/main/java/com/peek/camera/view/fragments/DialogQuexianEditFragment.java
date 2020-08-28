package com.peek.camera.view.fragments;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.model.PipeDefectDetail;
import com.peek.camera.model.QueXianInfo;
import com.peek.camera.p034b.C1134k;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1148s;
import com.peek.camera.view.p037a.C1202l;
import com.peek.camera.view.p038b.C1214c;
import com.peek.camera.view.view.MySpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import java.io.IOException;
import java.util.List;

public class DialogQuexianEditFragment extends DialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public boolean f3555aj;

    /* renamed from: ak */
    private PipeDefectDetail f3556ak;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public String[] f3557al;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public int f3558am = -1;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public int f3559an = -1;

    /* renamed from: ao */
    private C1202l f3560ao;

    /* renamed from: ap */
    private C1202l f3561ap;

    /* renamed from: aq */
    private C1202l f3562aq;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public int f3563ar = -1;
    /* access modifiers changed from: private */

    /* renamed from: as */
    public List<QueXianInfo> f3564as;

    /* renamed from: at */
    private View f3565at;
    /* access modifiers changed from: private */

    /* renamed from: au */
    public Handler f3566au = new Handler();

    /* renamed from: av */
    private int f3567av;

    /* renamed from: aw */
    private int f3568aw;

    /* renamed from: ax */
    private Unbinder f3569ax;
    /* access modifiers changed from: private */

    /* renamed from: ay */
    public C1308a f3570ay;
    @BindView(R.id.capture_quexian_clock_edt)
    EditText mClockEdt;
    @BindView(R.id.capture_quexian_clock_tv)
    TextView mClockTv;
    @BindView(R.id.capture_quexian_detail_edt)
    TextView mDetailEdt;
    @BindView(R.id.capture_quexian_detail_tv)
    TextView mDetailTv;
    @BindView(R.id.capture_quexian_distance_edt)
    EditText mDistanceEdt;
    @BindView(R.id.capture_quexian_grade_sp)
    MySpinner mGradeSp;
    @BindView(R.id.capture_quexian_grade_tv)
    TextView mGradeTv;
    @BindView(R.id.capture_quexian_length_edt)
    EditText mLengthEdt;
    @BindView(R.id.capture_quexian_length_tv)
    TextView mLengthTv;
    @BindView(R.id.capture_quexian_name_sp)
    MySpinner mNameSp;
    @BindView(R.id.capture_quexian_name_tv)
    TextView mNameTv;
    @BindView(R.id.capture_quexian_style_sp)
    MySpinner mStyleSp;

    /* renamed from: com.bmw.peek2.view.fragments.DialogQuexianEditFragment$a */
    public interface C1308a {
        /* renamed from: a */
        void mo5187a(PipeDefectDetail pipeDefectDetail);

        /* renamed from: b */
        void mo5188b(PipeDefectDetail pipeDefectDetail);
    }

    /* renamed from: O */
    private void m5735O() {
        this.f3557al = getActivity().getResources().getStringArray(R.array.que_xian_style);
        try {
            if (C1134k.m5256a()) {
                this.f3564as = C1148s.m5292a(getActivity().getAssets().open("assets/DefectTypes.xml"));
            } else {
                this.f3564as = C1148s.m5292a(getActivity().getAssets().open("assets/DefectTypes_en.xml"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: P */
    private void m5736P() {
        this.f3560ao = new C1202l(getActivity());
        this.f3561ap = new C1202l(getActivity());
        this.f3562aq = new C1202l(getActivity());
        this.mGradeSp.setAdapter(this.f3561ap);
        this.mNameSp.setAdapter(this.f3560ao);
        this.mStyleSp.setAdapter(this.f3562aq);
        this.f3562aq.mo5061a(this.f3557al);
    }

    /* renamed from: Q */
    private void m5737Q() {
        if (TextUtils.isEmpty(this.mStyleSp.getText().toString())) {
            this.mStyleSp.setText(getResources().getString(R.string.pleaseChoose));
        }
        this.mStyleSp.setOnItemSelectedListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                DialogQuexianEditFragment.this.mStyleSp.setText(DialogQuexianEditFragment.this.f3557al[i]);
                int unused = DialogQuexianEditFragment.this.f3558am = i;
                DialogQuexianEditFragment.this.m5748c(i);
                if (i != 0) {
                    DialogQuexianEditFragment.this.mNameSp.setText(DialogQuexianEditFragment.this.getResources().getString(R.string.pleaseChoose));
                } else {
                    int unused2 = DialogQuexianEditFragment.this.f3563ar = -1;
                    int unused3 = DialogQuexianEditFragment.this.f3559an = -1;
                }
                DialogQuexianEditFragment.this.mStyleSp.mo5379a();
            }
        });
        this.mNameSp.setOnItemSelectedListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int unused = DialogQuexianEditFragment.this.f3563ar = i;
                DialogQuexianEditFragment.this.mNameSp.setText(((QueXianInfo) DialogQuexianEditFragment.this.f3564as.get(DialogQuexianEditFragment.this.f3558am)).getStyleList().get(i).getName());
                DialogQuexianEditFragment.this.m5744b(i);
                DialogQuexianEditFragment.this.mGradeSp.setText(DialogQuexianEditFragment.this.getResources().getString(R.string.pleaseChoose));
                DialogQuexianEditFragment.this.mNameSp.mo5379a();
            }
        });
        this.mGradeSp.setOnItemSelectedListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int unused = DialogQuexianEditFragment.this.f3559an = i;
                DialogQuexianEditFragment.this.mGradeSp.setText(((QueXianInfo) DialogQuexianEditFragment.this.f3564as.get(DialogQuexianEditFragment.this.f3558am)).getStyleList().get(DialogQuexianEditFragment.this.f3563ar).getGradeList().get(DialogQuexianEditFragment.this.f3559an).getLevel() + "");
                if (DialogQuexianEditFragment.this.f3558am != 0) {
                    DialogQuexianEditFragment.this.mDetailEdt.setText(((QueXianInfo) DialogQuexianEditFragment.this.f3564as.get(DialogQuexianEditFragment.this.f3558am)).getStyleList().get(DialogQuexianEditFragment.this.f3563ar).getGradeList().get(DialogQuexianEditFragment.this.f3559an).getContent());
                }
                DialogQuexianEditFragment.this.mGradeSp.mo5379a();
            }
        });
    }

    /* renamed from: R */
    private void m5738R() {
        this.mDistanceEdt.setText(this.f3556ak.getDistance());
        for (int i = 0; i < this.f3564as.size(); i++) {
            if (this.f3564as.get(i).getName().equals(this.f3556ak.getDefectType())) {
                this.mStyleSp.setText(this.f3564as.get(i).getName());
                this.f3558am = i;
            }
        }
        if (this.f3558am > 0) {
            for (int i2 = 0; i2 < this.f3564as.get(this.f3558am).getStyleList().size(); i2++) {
                if (this.f3564as.get(this.f3558am).getStyleList().get(i2).getName().equals(this.f3556ak.getDefectCode())) {
                    this.mNameSp.setText(this.f3564as.get(this.f3558am).getStyleList().get(i2).getName());
                    this.f3563ar = i2;
                }
            }
            if (this.f3563ar != -1) {
                for (int i3 = 0; i3 < this.f3564as.get(this.f3558am).getStyleList().get(this.f3563ar).getGradeList().size(); i3++) {
                    if (!TextUtils.isEmpty(this.f3556ak.getDefectLevel()) && this.f3564as.get(this.f3558am).getStyleList().get(this.f3563ar).getGradeList().get(i3).getLevel() == Integer.valueOf(this.f3556ak.getDefectLevel()).intValue()) {
                        this.mGradeSp.setText(String.valueOf(this.f3564as.get(this.f3558am).getStyleList().get(this.f3563ar).getGradeList().get(i3).getLevel()));
                        this.f3559an = i3;
                    }
                }
            }
            this.mClockEdt.setText(this.f3556ak.getClockExpression());
            this.mLengthEdt.setText(this.f3556ak.getDefectLength());
            this.mDetailEdt.setText(this.f3556ak.getDefectDescription());
            if (this.f3558am > -1) {
                this.f3562aq.mo5061a(this.f3557al);
                this.mStyleSp.setText(this.f3557al[this.f3558am]);
                m5748c(this.f3558am);
                this.mNameSp.setText(getResources().getString(R.string.pleaseChoose));
            }
            if (this.f3563ar > -1) {
                this.mNameSp.setText(this.f3564as.get(this.f3558am).getStyleList().get(this.f3563ar).getName());
                m5744b(this.f3563ar);
                this.mGradeSp.setText(getResources().getString(R.string.pleaseChoose));
            }
            if (this.f3559an > -1) {
                m5744b(this.f3559an);
                this.mGradeSp.setText(String.valueOf(this.f3564as.get(this.f3558am).getStyleList().get(this.f3563ar).getGradeList().get(this.f3559an).getLevel()));
            }
        }
    }

    /* renamed from: a */
    public static DialogQuexianEditFragment m5741a(boolean z, PipeDefectDetail pipeDefectDetail) {
        DialogQuexianEditFragment dialogQuexianEditFragment = new DialogQuexianEditFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isChange", z);
        bundle.putSerializable("PipeDefectDetail", pipeDefectDetail);
        dialogQuexianEditFragment.setArguments(bundle);
        return dialogQuexianEditFragment;
    }

    /* renamed from: a */
    private void m5742a(Dialog dialog) {
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        window.setBackgroundDrawableResource(17170445);
        window.setGravity(17);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5744b(int i) {
        if (this.f3558am != 0) {
            String[] strArr = new String[this.f3564as.get(this.f3558am).getStyleList().get(i).getGradeList().size()];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < strArr.length) {
                    strArr[i3] = String.valueOf(this.f3564as.get(this.f3558am).getStyleList().get(i).getGradeList().get(i3).getLevel());
                    i2 = i3 + 1;
                } else {
                    this.f3561ap.mo5061a(strArr);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m5748c(int i) {
        int i2 = 0;
        switch (i) {
            case 0:
                m5755g(false);
                return;
            case 1:
                m5755g(true);
                String[] strArr = new String[this.f3564as.get(1).getStyleList().size()];
                while (i2 < strArr.length) {
                    strArr[i2] = this.f3564as.get(1).getStyleList().get(i2).getName();
                    i2++;
                }
                this.f3560ao.mo5061a(strArr);
                return;
            case 2:
                m5755g(true);
                String[] strArr2 = new String[this.f3564as.get(2).getStyleList().size()];
                while (i2 < strArr2.length) {
                    strArr2[i2] = this.f3564as.get(2).getStyleList().get(i2).getName();
                    i2++;
                }
                this.f3560ao.mo5061a(strArr2);
                return;
            default:
                return;
        }
    }

    /* renamed from: g */
    private void m5755g(boolean z) {
        this.mNameSp.setEnabled(z);
        this.mGradeSp.setEnabled(z);
        this.mClockEdt.setEnabled(z);
        this.mLengthEdt.setEnabled(z);
        this.mDetailEdt.setEnabled(z);
        this.mNameSp.setText("");
        this.mGradeSp.setText("");
        if (!z) {
            this.mNameTv.setTextColor(getActivity().getResources().getColor(R.color.gray_10));
            this.mClockTv.setTextColor(getActivity().getResources().getColor(R.color.gray_10));
            this.mGradeTv.setTextColor(getActivity().getResources().getColor(R.color.gray_10));
            this.mLengthTv.setTextColor(getActivity().getResources().getColor(R.color.gray_10));
            this.mDetailTv.setTextColor(getActivity().getResources().getColor(R.color.gray_10));
            this.mDetailEdt.setText("");
            this.mClockEdt.setText("");
            this.mLengthEdt.setText("");
            return;
        }
        this.mNameTv.setTextColor(getActivity().getResources().getColor(R.color.colorText));
        this.mClockTv.setTextColor(getActivity().getResources().getColor(R.color.colorText));
        this.mGradeTv.setTextColor(getActivity().getResources().getColor(R.color.colorText));
        this.mLengthTv.setTextColor(getActivity().getResources().getColor(R.color.colorText));
        this.mDetailTv.setTextColor(getActivity().getResources().getColor(R.color.colorText));
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        this.f3565at = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_picture_quexian_edit, (ViewGroup) null);
        this.f3569ax = ButterKnife.bind((Object) this, this.f3565at);
        Dialog b = new AlertDialog.Builder(getActivity()).setView(this.f3565at).create();
        m5742a((Dialog) b);
        m5736P();
        m5737Q();
        if (this.f3556ak != null) {
            m5738R();
        }
        return b;
    }



    /* renamed from: a */
    public void mo5180a(C1308a aVar) {
        this.f3570ay = aVar;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C1140n.m5266a("aaaaaasdsd  onCreate = " + savedInstanceState);
        this.f3556ak = (PipeDefectDetail) getArguments().getSerializable("PipeDefectDetail");
        this.f3555aj = getArguments().getBoolean("isChange");
        m5735O();
    }


    @Override
    public void onStart() {
        super.onStart();
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        if (this.f3567av == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.f3568aw = displayMetrics.heightPixels;
            this.f3567av = displayMetrics.widthPixels;
        }
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.height = this.f3568aw;
        attributes.width = (int) (((double) this.f3567av) * 0.4d);
        getDialog().getWindow().setAttributes(attributes);
        ViewGroup.LayoutParams layoutParams = this.f3565at.getLayoutParams();
        layoutParams.height = this.f3568aw;
        this.f3565at.setLayoutParams(layoutParams);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.f3569ax.unbind();
    }


    @OnClick({R.id.quexian_cancel,  R.id.quexian_sure,  R.id.tv_quexianEdit_clockShow})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.quexian_cancel:
                dismiss();
                return;
            case  R.id.quexian_sure:
                new Thread(new Runnable() {
                    public void run() {
                        if (TextUtils.isEmpty(DialogQuexianEditFragment.this.mStyleSp.getText().toString()) || DialogQuexianEditFragment.this.mStyleSp.getText().equals(DialogQuexianEditFragment.this.getString((int) R.string.pleaseChoose))) {
                            DialogQuexianEditFragment.this.f3566au.post(new Runnable() {
                                public void run() {
                                    BaseApplication.m4926a(DialogQuexianEditFragment.this.getResources().getString(R.string.chooseQuexianSort));
                                }
                            });
                            return;
                        }
                        PipeDefectDetail pipeDefectDetail = new PipeDefectDetail(DialogQuexianEditFragment.this.mDistanceEdt.getText().toString(), DialogQuexianEditFragment.this.mStyleSp.getText().toString(), DialogQuexianEditFragment.this.mNameSp.getText().toString(), DialogQuexianEditFragment.this.mGradeSp.getText().toString(), DialogQuexianEditFragment.this.mClockEdt.getText().toString(), DialogQuexianEditFragment.this.mLengthEdt.getText().toString(), DialogQuexianEditFragment.this.mDetailEdt.getText().toString());
                        if (DialogQuexianEditFragment.this.f3558am == -1) {
                            pipeDefectDetail.setDefectType("");
                        }
                        if (DialogQuexianEditFragment.this.f3563ar == -1) {
                            pipeDefectDetail.setDefectCode("");
                        }
                        if (DialogQuexianEditFragment.this.f3559an == -1) {
                            pipeDefectDetail.setDefectLevel("");
                        }
                        switch (DialogQuexianEditFragment.this.f3558am) {
                            case 0:
                                pipeDefectDetail.setDefectLevel("");
                                pipeDefectDetail.setDefectCode("");
                                break;
                            case 1:
                                if (DialogQuexianEditFragment.this.f3563ar >= 0) {
                                    pipeDefectDetail.setDefectCode(((QueXianInfo) DialogQuexianEditFragment.this.f3564as.get(DialogQuexianEditFragment.this.f3558am)).getStyleList().get(DialogQuexianEditFragment.this.f3563ar).getName());
                                    if (DialogQuexianEditFragment.this.f3559an >= 0) {
                                        pipeDefectDetail.setDefectLevel(String.valueOf(((QueXianInfo) DialogQuexianEditFragment.this.f3564as.get(DialogQuexianEditFragment.this.f3558am)).getStyleList().get(DialogQuexianEditFragment.this.f3563ar).getGradeList().get(DialogQuexianEditFragment.this.f3559an).getLevel()));
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                if (DialogQuexianEditFragment.this.f3563ar >= 0) {
                                    pipeDefectDetail.setDefectCode(((QueXianInfo) DialogQuexianEditFragment.this.f3564as.get(DialogQuexianEditFragment.this.f3558am)).getStyleList().get(DialogQuexianEditFragment.this.f3563ar).getName());
                                    if (DialogQuexianEditFragment.this.f3559an >= 0) {
                                        pipeDefectDetail.setDefectLevel(String.valueOf(((QueXianInfo) DialogQuexianEditFragment.this.f3564as.get(DialogQuexianEditFragment.this.f3558am)).getStyleList().get(DialogQuexianEditFragment.this.f3563ar).getGradeList().get(DialogQuexianEditFragment.this.f3559an).getLevel()));
                                        break;
                                    }
                                }
                                break;
                        }
                        if (!DialogQuexianEditFragment.this.f3555aj) {
                            if (DialogQuexianEditFragment.this.f3570ay != null) {
                                DialogQuexianEditFragment.this.f3570ay.mo5187a(pipeDefectDetail);
                            }
                        } else if (DialogQuexianEditFragment.this.f3570ay != null) {
                            DialogQuexianEditFragment.this.f3570ay.mo5188b(pipeDefectDetail);
                        }
                        C1140n.m5268a("数据保存完成", "");
                        DialogQuexianEditFragment.this.dismiss();
                    }
                }).start();
                return;
            case R.id.tv_quexianEdit_clockShow:
                new C1214c(getActivity());
                return;
            default:
                return;
        }
    }
}
