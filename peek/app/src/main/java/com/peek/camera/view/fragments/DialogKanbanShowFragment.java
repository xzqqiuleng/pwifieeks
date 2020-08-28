package com.peek.camera.view.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.model.Login_info;
import com.peek.camera.p034b.C1129g;
import com.peek.camera.view.p037a.C1181e;
import com.peek.camera.view.p040ui.KanbanPreviewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.cookie.ClientCookie;

public class DialogKanbanShowFragment extends DialogFragment {

    /* renamed from: aj */
    private View f3484aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public String f3485ak;

    /* renamed from: al */
    private int f3486al;

    /* renamed from: am */
    private int f3487am;

    /* renamed from: an */
    private Unbinder f3488an;

    /* renamed from: ao */
    private C1283a f3489ao;
    @BindView(R.id.ll_kanbanMenu)
    LinearLayout llKanbanMenu;
    @BindView(R.id.rcv_list)
    RecyclerView rcvList;
    @BindView(R.id.tv_addNewKanban)
    TextView tvAddNewKanban;
    @BindView(R.id.tv_btn_addNewKanban)
    TextView tvBtnAddNewKanban;

    /* renamed from: com.bmw.peek2.view.fragments.DialogKanbanShowFragment$a */
    public interface C1283a {
        /* renamed from: a */
        void mo5164a();

        /* renamed from: a */
        void mo5165a(String str);

        /* renamed from: b */
        void mo5166b();
    }

    /* renamed from: O */
    public static DialogKanbanShowFragment m5694O() {
        DialogKanbanShowFragment dialogKanbanShowFragment = new DialogKanbanShowFragment();
        dialogKanbanShowFragment.setArguments(new Bundle());
        return dialogKanbanShowFragment;
    }

    /* renamed from: P */
    private void m5695P() {
        this.llKanbanMenu.setVisibility(View.GONE);
        this.tvAddNewKanban.setVisibility(View.GONE);
        this.tvBtnAddNewKanban.setVisibility(View.VISIBLE);
    }

    /* renamed from: Q */
    private String m5696Q() {
        return C1129g.m5220a() + Login_info.local_kanban_path;
    }

    /* renamed from: a */
    private void m5698a(Dialog dialog) {
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

    /* renamed from: a */
    private boolean m5699a(File[] fileArr, String str) {
        for (File name : fileArr) {
            if (name.getName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private List<File> m5700b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File[] listFiles = file.listFiles();
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            if (file2.isFile() && !file2.getName().endsWith("_index") && !file2.getName().endsWith(".avi")) {
                if (m5699a(listFiles, file2.getName() + "_index")) {
                    arrayList.add(file2);
                } else {
                    if (m5699a(listFiles, file2.getName() + ".avi")) {
                        new File(file2.getName() + ".avi").delete();
                    }
                    file2.delete();
                }
            }
        }
        if (arrayList.size() == 0) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
        return arrayList;
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        return super.show(transaction, tag);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        this.f3484aj = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_kanban_show, (ViewGroup) null);
        this.f3488an = ButterKnife.bind((Object) this, this.f3484aj);
        this.rcvList.setLayoutManager(new GridLayoutManager(getContext(), 3));
        List b = m5700b(m5696Q());
        if (b == null) {
            b = new ArrayList();
        }
        if (b.size() == 0) {
            m5695P();
        }
        C1181e eVar = new C1181e(getContext(), b);
        this.rcvList.setAdapter(eVar);
        eVar.mo5019a((C1181e.C1183a) new C1181e.C1183a() {
            /* renamed from: a */
            public void mo5024a(String str) {
                String unused = DialogKanbanShowFragment.this.f3485ak = str;
            }
        });
        Dialog b2 = new AlertDialog.Builder(getActivity()).setView(this.f3484aj).create();
        b2.setCanceledOnTouchOutside(false);
        m5698a((Dialog) b2);
        return b2;
    }


    /* renamed from: a */
    public void mo5162a(C1283a aVar) {
        this.f3489ao = aVar;
    }

    @Override
    public void onStart() {
        super.onStart();
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        if (this.f3487am == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.f3487am = displayMetrics.heightPixels;
            this.f3486al = displayMetrics.widthPixels;
        }
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.width = (int) (((double) this.f3486al) * 0.6d);
        getDialog().getWindow().setAttributes(attributes);
    }

    @Override
    public void onDestroy() {
        this.f3488an.unbind();
        super.onDestroy();
    }



    @OnClick({R.id.img_cancel, R.id.normal_dialog_delete, R.id.normal_dialog_preview, R.id.normal_dialog_sure, R.id.tv_addNewKanban, R.id.tv_btn_addNewKanban})
    public void onClick(View view) {
        if (this.f3485ak != null || view.getId() == R.id.tv_addNewKanban || view.getId() == R.id.img_cancel || view.getId() == R.id.tv_btn_addNewKanban) {
            switch (view.getId()) {
                case R.id.img_cancel:
                    if (this.f3489ao != null) {
                        this.f3489ao.mo5166b();
                    }
                    getDialog().dismiss();
                    return;
                case R.id.normal_dialog_delete:
                    ((C1181e) this.rcvList.getAdapter()).mo5022d();
                    this.f3485ak = null;
                    return;
                case R.id.normal_dialog_preview:
                    Intent intent = new Intent(getActivity(), KanbanPreviewActivity.class);
                    intent.putExtra(ClientCookie.PATH_ATTR, this.f3485ak + ".avi");
                    startActivity(intent);
                    return;
                case R.id.normal_dialog_sure:
                    if (!new File(this.f3485ak + "_index").exists()) {
                        BaseApplication.m4926a(getString((int) R.string.kanbanFileBreak));
                        return;
                    }
                    if (this.f3489ao != null) {
                        this.f3489ao.mo5165a(this.f3485ak);
                    }
                    getDialog().dismiss();
                    return;
                case R.id.tv_addNewKanban:
                case R.id.tv_btn_addNewKanban:
                    if (this.f3489ao != null) {
                        this.f3489ao.mo5164a();
                    }
                    if (this.rcvList.getAdapter().getItemCount() < 5) {
                        getDialog().dismiss();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (this.rcvList.getAdapter().getItemCount() == 0) {
            BaseApplication.m4926a(getString((int) R.string.kanbanListIsEmpty));
        } else {
            BaseApplication.m4926a(getString((int) R.string.pleaseChooseOneKanbanItem));
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
