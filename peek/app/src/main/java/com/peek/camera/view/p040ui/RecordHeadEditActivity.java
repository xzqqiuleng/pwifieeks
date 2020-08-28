package com.peek.camera.view.p040ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.model.RecordTaskInfo;
import com.peek.camera.p034b.C1127e;
import com.peek.camera.p034b.C1130h;
import com.peek.camera.view.fragments.C1329a;
import com.peek.camera.view.fragments.DialogNormalFragment;
import com.peek.camera.view.p037a.C1198k;
import com.peek.camera.view.p037a.C1202l;
import com.peek.camera.view.view.MySpinner;

import java.util.Collections;
import java.util.List;

/* renamed from: com.bmw.peek2.view.ui.RecordHeadEditActivity */
public class RecordHeadEditActivity extends BaseActivity implements View.OnFocusChangeListener, TextView.OnEditorActionListener {

    /* renamed from: A */
    private Unbinder f3976A;
    @BindView(R.id.record_start_record_btn)
    TextView commitBtn;
    @BindView(R.id.iv_goback)
    ImageView ivGoBack;
    @BindView(R.id.record_task_conputer_edt)
    EditText mComputerEdt;
    @BindView(R.id.record_task_diameter_edt)
    EditText mDiameterEdt;
    @BindView(R.id.record_task_direction_edt)
    EditText mDirectionEdt;
    @BindView(R.id.record_task_direction_sp)
    MySpinner mDirectionSp;
    @BindView(R.id.record_task_end_edt)
    EditText mEndEdt;
    @BindView(R.id.record_task_guancai_edt)
    EditText mGuancaiEdt;
    @BindView(R.id.record_task_guancai_sp)
    MySpinner mGuancaiSp;
    @BindView(R.id.record_task_id_edt)
    EditText mIdEdt;
    @BindView(R.id.record_task_id_tv)
    TextView mIdTv;
    @BindView(R.id.record_task_name_edt)
    EditText mNameEdt;
    @BindView(R.id.record_task_people_edt)
    EditText mPeopleEdt;
    @BindView(R.id.record_task_place_edt)
    EditText mPlaceEdt;
    @BindView(R.id.record_task_sort_edt)
    EditText mSortEdt;
    @BindView(R.id.record_task_sort_sp)
    MySpinner mSortSp;
    @BindView(R.id.record_task_start_edt)
    EditText mStartEdt;
    @BindView(R.id.record_recylerView)
    RecyclerView mTaskListView;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public DbUtils f3977o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C1198k f3978p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public List<RecordTaskInfo> f3979q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Handler f3980r;
    @BindView(R.id.rl_containerRBantouMain)
    RelativeLayout rlContainerRBantouMain;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f3981s = -1;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f3982t;
    @BindView(R.id.dialog_record_title)
    TextView title;

    /* renamed from: u */
    private Intent f3983u;

    /* renamed from: v */
    private boolean f3984v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public C1202l f3985w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public C1202l f3986x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public C1202l f3987y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public TextView f3988z;

    /* renamed from: A */
    private void m6054A() {
        m6092z();
        this.mSortSp.setAdapter(this.f3985w);
        this.mDirectionSp.setAdapter(this.f3986x);
        this.mGuancaiSp.setAdapter(this.f3987y);
        this.mSortSp.setText(getString(R.string.pleaseChoose));
        this.mDirectionSp.setText(getString(R.string.pleaseChoose));
        this.mGuancaiSp.setText(getString(R.string.pleaseChoose));
        this.mSortSp.setOnItemSelectedListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RecordHeadEditActivity.this.m6059a((View) RecordHeadEditActivity.this.rlContainerRBantouMain);
                if (i != 0) {
                    RecordHeadEditActivity.this.mSortSp.setText(RecordHeadEditActivity.this.f3985w.mo5060a(i).equals(RecordHeadEditActivity.this.getString(R.string.pleaseChoose)) ? "" : RecordHeadEditActivity.this.f3985w.mo5060a(i));
                    RecordHeadEditActivity.this.mSortSp.mo5379a();
                    return;
                }
                RecordHeadEditActivity.this.mSortSp.mo5379a();
                RecordHeadEditActivity.this.mSortEdt.setVisibility(View.VISIBLE);
                RecordHeadEditActivity.this.mSortEdt.requestFocus();
                TextView unused = RecordHeadEditActivity.this.f3988z = RecordHeadEditActivity.this.mSortEdt;
            }
        });
        this.mDirectionSp.setOnItemSelectedListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RecordHeadEditActivity.this.m6059a((View) RecordHeadEditActivity.this.rlContainerRBantouMain);
                if (i != 0) {
                    RecordHeadEditActivity.this.mDirectionSp.setText(RecordHeadEditActivity.this.f3986x.mo5060a(i).equals(RecordHeadEditActivity.this.getString(R.string.pleaseChoose)) ? "" : RecordHeadEditActivity.this.f3986x.mo5060a(i));
                    RecordHeadEditActivity.this.mDirectionSp.mo5379a();
                    return;
                }
                RecordHeadEditActivity.this.mDirectionSp.mo5379a();
                RecordHeadEditActivity.this.mDirectionEdt.setVisibility(View.VISIBLE);
                RecordHeadEditActivity.this.mDirectionEdt.requestFocus();
                TextView unused = RecordHeadEditActivity.this.f3988z = RecordHeadEditActivity.this.mDirectionEdt;
            }
        });
        this.mGuancaiSp.setOnItemSelectedListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RecordHeadEditActivity.this.m6059a((View) RecordHeadEditActivity.this.rlContainerRBantouMain);
                if (i != 0) {
                    RecordHeadEditActivity.this.mGuancaiSp.setText(RecordHeadEditActivity.this.f3987y.mo5060a(i).equals(RecordHeadEditActivity.this.getString(R.string.pleaseChoose)) ? "" : RecordHeadEditActivity.this.f3987y.mo5060a(i));
                    RecordHeadEditActivity.this.mGuancaiSp.mo5379a();
                    return;
                }
                RecordHeadEditActivity.this.mGuancaiSp.mo5379a();
                RecordHeadEditActivity.this.mGuancaiEdt.setVisibility(View.VISIBLE);
                RecordHeadEditActivity.this.mGuancaiEdt.requestFocus();
                TextView unused = RecordHeadEditActivity.this.f3988z = RecordHeadEditActivity.this.mGuancaiEdt;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6059a(View view) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) mo5210l().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* renamed from: a */
    private void m6060a(TextView textView) {
        if (textView.isShown()) {
            textView.setVisibility(View.GONE);
            String charSequence = textView.getText().toString();
            switch (textView.getId()) {
                case R.id.record_task_direction_edt:
                    MySpinner mySpinner = this.mDirectionSp;
                    if (TextUtils.isEmpty(charSequence)) {
                        charSequence = getString(R.string.pleaseChoose);
                    }
                    mySpinner.setText(charSequence);
                    return;
                case  R.id.record_task_guancai_edt:
                    MySpinner mySpinner2 = this.mGuancaiSp;
                    if (TextUtils.isEmpty(charSequence)) {
                        charSequence = getString(R.string.pleaseChoose);
                    }
                    mySpinner2.setText(charSequence);
                    return;
                case  R.id.record_task_sort_edt:
                    MySpinner mySpinner3 = this.mSortSp;
                    if (TextUtils.isEmpty(charSequence)) {
                        charSequence = getString(R.string.pleaseChoose);
                    }
                    mySpinner3.setText(charSequence);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private void m6063a(String str, String str2, final Runnable runnable, final Runnable runnable2) {
        DialogNormalFragment a = DialogNormalFragment.m5724a(str, str2, getString(R.string.yes), getString(R.string.no), false);
        a.mo5175a((C1329a) new C1329a() {
            /* renamed from: a */
            public void mo4542a() {
                runnable.run();
            }

            /* renamed from: b */
            public void mo4543b() {
                runnable2.run();
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), a, "DialogNormalFragment");
    }

    /* renamed from: a */
    private boolean m6064a(RecordTaskInfo recordTaskInfo) {
        if (this.f3981s < 0) {
            return false;
        }
        RecordTaskInfo recordTaskInfo2 = this.f3979q.get(this.f3981s);
        if (recordTaskInfo2 == null) {
            return false;
        }
        return !(recordTaskInfo.getTask_id().equals(recordTaskInfo2.getTask_id()) && recordTaskInfo.getTask_name().equals(recordTaskInfo2.getTask_name()) && recordTaskInfo.getTask_place().equals(recordTaskInfo2.getTask_place()) && recordTaskInfo.getTask_start().equals(recordTaskInfo2.getTask_start()) && recordTaskInfo.getTask_end().equals(recordTaskInfo2.getTask_end()) && recordTaskInfo.getTask_direction().equals(recordTaskInfo2.getTask_direction()) && recordTaskInfo.getTask_sort().equals(recordTaskInfo2.getTask_sort()) && recordTaskInfo.getTask_guancai().equals(recordTaskInfo2.getTask_guancai()) && recordTaskInfo.getTask_diameter().equals(recordTaskInfo2.getTask_diameter()) && recordTaskInfo.getTask_computer().equals(recordTaskInfo2.getTask_computer()) && recordTaskInfo.getTask_people().equals(recordTaskInfo2.getTask_people()));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6068b(final boolean z) {
        new Thread(new Runnable() {
            public void run() {
                RecordTaskInfo j = RecordHeadEditActivity.this.m6091y();
                if (!RecordHeadEditActivity.this.m6069b(j)) {
                    try {
                        if (!z) {
                            RecordHeadEditActivity.this.f3977o.save(j);
                            RecordHeadEditActivity.this.m6072c(1);
                            return;
                        }
                        j.setId(RecordHeadEditActivity.this.f3982t);
                        RecordHeadEditActivity.this.f3977o.update(j, new String[0]);
                        RecordHeadEditActivity.this.m6072c(2);
                    } catch (DbException e) {
                        BaseActivity.m5795c("数据库保存失败：" + e);
                        e.printStackTrace();
                    }
                } else {
                    RecordHeadEditActivity.this.f3980r.sendEmptyMessage(5);
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m6069b(RecordTaskInfo recordTaskInfo) {
        return TextUtils.isEmpty(recordTaskInfo.getTask_id()) && TextUtils.isEmpty(recordTaskInfo.getTask_name()) && TextUtils.isEmpty(recordTaskInfo.getTask_people()) && TextUtils.isEmpty(recordTaskInfo.getTask_place()) && TextUtils.isEmpty(recordTaskInfo.getTask_computer()) && TextUtils.isEmpty(recordTaskInfo.getTask_start()) && TextUtils.isEmpty(recordTaskInfo.getTask_end()) && TextUtils.isEmpty(recordTaskInfo.getTask_direction()) && TextUtils.isEmpty(recordTaskInfo.getTask_sort()) && TextUtils.isEmpty(recordTaskInfo.getTask_diameter()) && TextUtils.isEmpty(recordTaskInfo.getTask_guancai());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6072c(final int i) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    List unused = RecordHeadEditActivity.this.f3979q = RecordHeadEditActivity.this.f3977o.findAll(RecordTaskInfo.class);
                    if (RecordHeadEditActivity.this.f3979q != null) {
                        Collections.sort(RecordHeadEditActivity.this.f3979q);
                    }
                    RecordHeadEditActivity.this.f3980r.sendEmptyMessage(i);
                    int unused2 = RecordHeadEditActivity.this.f3981s = -1;
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m6083q() {
        RecordTaskInfo recordTaskInfo;
        if (this.f3981s >= 0 && (recordTaskInfo = this.f3979q.get(this.f3981s)) != null) {
            this.mNameEdt.setText(recordTaskInfo.getTask_name());
            this.mPeopleEdt.setText(recordTaskInfo.getTask_people());
            this.mComputerEdt.setText(recordTaskInfo.getTask_computer());
            this.mPlaceEdt.setText(recordTaskInfo.getTask_place());
            this.mStartEdt.setText(recordTaskInfo.getTask_start());
            this.mEndEdt.setText(recordTaskInfo.getTask_end());
            this.mDiameterEdt.setText(recordTaskInfo.getTask_diameter());
            this.mIdEdt.setText(recordTaskInfo.getTask_id());
            this.mSortSp.setText(TextUtils.isEmpty(recordTaskInfo.getTask_sort()) ? getString(R.string.pleaseChoose) : recordTaskInfo.getTask_sort());
            this.mDirectionSp.setText(TextUtils.isEmpty(recordTaskInfo.getTask_direction()) ? getString(R.string.pleaseChoose) : recordTaskInfo.getTask_direction());
            this.mGuancaiSp.setText(TextUtils.isEmpty(recordTaskInfo.getTask_guancai()) ? getString(R.string.pleaseChoose) : recordTaskInfo.getTask_guancai());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m6084r() {
        this.mNameEdt.setText("");
        this.mPeopleEdt.setText("");
        this.mComputerEdt.setText("");
        this.mPlaceEdt.setText("");
        this.mStartEdt.setText("");
        this.mEndEdt.setText("");
        this.mDiameterEdt.setText("");
        this.mIdEdt.setText("");
        this.mSortSp.setText(getString(R.string.pleaseChoose));
        this.mDirectionSp.setText(getString(R.string.pleaseChoose));
        this.mGuancaiSp.setText(getString(R.string.pleaseChoose));
    }

    /* renamed from: s */
    private void m6085s() {
        this.mTaskListView.setLayoutManager(new LinearLayoutManager(this));
        this.f3978p = new C1198k(this);
        this.mTaskListView.setAdapter(this.f3978p);
        this.f3978p.mo5048a((C1198k.C1200a) new C1198k.C1200a() {
            /* renamed from: a */
            public void mo5059a(int i) {
                int unused = RecordHeadEditActivity.this.f3981s = i;
                RecordHeadEditActivity.this.f3980r.sendEmptyMessage(3);
            }
        });
    }

    /* renamed from: t */
    private void m6086t() {
        InputMethodManager inputMethodManager = (InputMethodManager) mo5210l().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mIdEdt.getWindowToken(), 0);
        }
    }

    /* renamed from: u */
    private void m6087u() {
        if (this.f3981s >= 0) {
            RecordTaskInfo y = m6091y();
            if (!m6069b(y)) {
                if (m6064a(y)) {
                    m6063a(getString(R.string.dataHasChange), getString(R.string.isUpdateToList), new Runnable() {
                        public void run() {
                            RecordHeadEditActivity.this.m6068b(true);
                            RecordHeadEditActivity.this.m6089w();
                        }
                    }, new Runnable() {
                        public void run() {
                            RecordHeadEditActivity.this.m6089w();
                        }
                    });
                } else {
                    m6089w();
                }
            } else if (!this.f3984v) {
                m6088v();
            } else {
                finish();
            }
        } else if (!m6069b(m6091y())) {
            m6063a(getString(R.string.dataNoSave), getString(R.string.isAddToList), new Runnable() {
                public void run() {
                    RecordHeadEditActivity.this.m6068b(false);
                    RecordHeadEditActivity.this.m6089w();
                }
            }, new Runnable() {
                public void run() {
                    RecordHeadEditActivity.this.m6089w();
                }
            });
        } else if (this.f3984v) {
            finish();
        } else {
            m6088v();
        }
    }

    /* renamed from: v */
    private void m6088v() {
        m6063a(getString(R.string.headDataIsEmpty), getString(R.string.isAbandonAddHead), new Runnable() {
            public void run() {
                RecordHeadEditActivity.this.setResult(1);
                RecordHeadEditActivity.this.finish();
            }
        }, new Runnable() {
            public void run() {
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m6089w() {
        this.f3983u.putExtra("record_head", new RecordTaskInfo((long) this.f3982t, this.mIdEdt.getText().toString(), this.mNameEdt.getText().toString(), this.mPlaceEdt.getText().toString(), this.mStartEdt.getText().toString(), this.mEndEdt.getText().toString(), getString(R.string.pleaseChoose).equals(this.mDirectionSp.getText().toString()) ? "" : this.mDirectionSp.getText().toString(), getString(R.string.pleaseChoose).equals(this.mSortSp.getText().toString()) ? "" : this.mSortSp.getText().toString(), getString(R.string.pleaseChoose).equals(this.mGuancaiSp.getText().toString()) ? "" : this.mGuancaiSp.getText().toString(), this.mDiameterEdt.getText().toString(), this.mComputerEdt.getText().toString(), this.mPeopleEdt.getText().toString()));
        setResult(1, this.f3983u);
        finish();
    }

    /* renamed from: x */
    private void m6090x() {
        this.f3980r = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        RecordHeadEditActivity.this.f3978p.mo5050a((List<RecordTaskInfo>) RecordHeadEditActivity.this.f3979q);
                        return;
                    case 1:
                        if (RecordHeadEditActivity.this.f3979q != null) {
                            RecordHeadEditActivity.this.f3978p.mo5050a((List<RecordTaskInfo>) RecordHeadEditActivity.this.f3979q);
                            RecordHeadEditActivity.this.f3978p.mo5052c(RecordHeadEditActivity.this.f3979q.size() - 1);
                            if (RecordHeadEditActivity.this.f3979q.size() == 0) {
                                RecordHeadEditActivity.this.m6084r();
                                return;
                            }
                            return;
                        }
                        return;
                    case 2:
                        RecordHeadEditActivity.this.f3978p.mo5050a((List<RecordTaskInfo>) RecordHeadEditActivity.this.f3979q);
                        RecordHeadEditActivity.this.f3978p.mo5054d(RecordHeadEditActivity.this.f3982t);
                        return;
                    case 3:
                        if (RecordHeadEditActivity.this.f3981s != -1) {
                            int unused = RecordHeadEditActivity.this.f3982t = ((RecordTaskInfo) RecordHeadEditActivity.this.f3979q.get(RecordHeadEditActivity.this.f3981s)).getId();
                            RecordHeadEditActivity.this.mTaskListView.scrollToPosition(RecordHeadEditActivity.this.f3981s);
                            RecordHeadEditActivity.this.m6083q();
                            return;
                        }
                        RecordHeadEditActivity.this.m6084r();
                        return;
                    case 4:
                        BaseApplication.m4926a(RecordHeadEditActivity.this.getString(R.string.pleaseChooseOneItemFirst));
                        return;
                    case 5:
                        RecordHeadEditActivity.this.mo5206a(RecordHeadEditActivity.this.getString(R.string.info_is_empty));
                        return;
                    default:
                        return;
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public RecordTaskInfo m6091y() {
        return new RecordTaskInfo((long) this.f3982t, this.mIdEdt.getText().toString(), this.mNameEdt.getText().toString(), this.mPlaceEdt.getText().toString(), this.mStartEdt.getText().toString(), this.mEndEdt.getText().toString(), getString(R.string.pleaseChoose).equals(this.mDirectionSp.getText().toString()) ? "" : this.mDirectionSp.getText().toString(), getString(R.string.pleaseChoose).equals(this.mSortSp.getText().toString()) ? "" : this.mSortSp.getText().toString(), getString(R.string.pleaseChoose).equals(this.mGuancaiSp.getText().toString()) ? "" : this.mGuancaiSp.getText().toString(), this.mDiameterEdt.getText().toString(), this.mComputerEdt.getText().toString(), this.mPeopleEdt.getText().toString());
    }

    /* renamed from: z */
    private void m6092z() {
        this.f3985w = new C1202l(this);
        this.f3986x = new C1202l(this);
        this.f3987y = new C1202l(this);
        this.f3985w.mo5061a(getResources().getStringArray(R.array.record_task_sort));
        this.f3986x.mo5061a(getResources().getStringArray(R.array.record_task_direction));
        this.f3987y.mo5061a(getResources().getStringArray(R.array.record_task_guancai));
    }

    /* renamed from: k */
    public boolean mo5209k() {
        return true;
    }

    @OnClick({R.id.iv_goback, R.id.record_add_page_btn, R.id.record_cancel_record_btn, R.id.record_change_page_btn, R.id.record_delete_all_page_btn, R.id.record_delete_page_btn, R.id.record_end_page_btn, R.id.record_last_page_btn, R.id.record_next_page_btn, R.id.record_start_page_btn, R.id.record_start_record_btn})
    public void onClick(View view) {
        if (this.f3988z != null && this.f3988z.isShown()) {
            m6086t();
            m6060a(this.f3988z);
        }
        switch (view.getId()) {
            case R.id.iv_goback:
                m6087u();
                return;
            case R.id.record_add_page_btn:
                m6068b(false);
                return;
            case R.id.record_cancel_record_btn:
                setResult(100);
                finish();
                return;
            case R.id.record_change_page_btn:
                if (this.f3981s == -1) {
                    this.f3980r.sendEmptyMessage(4);
                    return;
                } else if (m6069b(m6091y())) {
                    m6063a(getString(R.string.changeEmptyData), getString(R.string.isDeleteItem), new Runnable() {
                        public void run() {
                            try {
                                RecordHeadEditActivity.this.f3977o.delete(RecordHeadEditActivity.this.f3979q.get(RecordHeadEditActivity.this.f3981s));
                                RecordHeadEditActivity.this.m6072c(1);
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Runnable() {
                        public void run() {
                        }
                    });
                    return;
                } else {
                    this.f3982t = this.f3979q.get(this.f3981s).getId();
                    m6068b(true);
                    return;
                }
            case R.id.record_delete_all_page_btn:
                try {
                    this.f3977o.deleteAll((Class<?>) RecordTaskInfo.class);
                    m6072c(0);
                    return;
                } catch (DbException e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.record_delete_page_btn:
                if (this.f3981s != -1) {
                    try {
                        this.f3977o.delete(this.f3979q.get(this.f3981s));
                        m6072c(1);
                        return;
                    } catch (DbException e2) {
                        e2.printStackTrace();
                        return;
                    }
                } else {
                    this.f3980r.sendEmptyMessage(4);
                    return;
                }
            case R.id.record_end_page_btn:
                this.f3978p.mo5055e();
                return;
            case R.id.record_last_page_btn:
                this.f3978p.mo5056f();
                return;
            case R.id.record_next_page_btn:
                this.f3978p.mo5057g();
                return;
            case R.id.record_start_page_btn:
                this.f3978p.mo5053d();
                return;
            case R.id.record_start_record_btn:
                m6087u();
                return;
            default:
                return;
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_add_record_head);
        this.f3976A = ButterKnife.bind((Activity) this);
        this.title.setText(getString(R.string.record_title));
        this.ivGoBack.setVisibility(View.GONE);
        this.f3984v = getIntent().getBooleanExtra("RECORD_IS_EDIT_MODEL", false);
        if (this.f3984v) {
            this.title.setText(getString(R.string.record_title_edit));
            this.commitBtn.setVisibility(View.GONE);
            this.ivGoBack.setVisibility(View.VISIBLE);
        }
        this.f3977o = C1127e.m5217a();
        this.f3983u = new Intent();
        this.mTaskListView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                RecordHeadEditActivity.this.m6059a(view);
                return false;
            }
        });
        this.rlContainerRBantouMain.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                RecordHeadEditActivity.this.m6059a(view);
                return false;
            }
        });
        this.mDirectionEdt.setOnFocusChangeListener(this);
        this.mDirectionEdt.setOnEditorActionListener(this);
        this.mSortEdt.setOnFocusChangeListener(this);
        this.mSortEdt.setOnEditorActionListener(this);
        this.mGuancaiEdt.setOnFocusChangeListener(this);
        this.mGuancaiEdt.setOnEditorActionListener(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f3976A.unbind();
        this.f3983u = null;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            InputMethodManager inputMethodManager = (InputMethodManager) mo5210l().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 0);
            }
            m6060a(textView);
        }
        return false;
    }

    public void onFocusChange(View view, boolean z) {
        if (!z) {
            m6060a((TextView) view);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.f3981s != -1) {
                m6089w();
            } else {
                setResult(1);
            }
            finish();
            return true;
        } else if (i != 3) {
            return super.onKeyDown(i, keyEvent);
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m6054A();
        m6090x();
        m6085s();
        m6072c(0);
        m6083q();
    }
}
