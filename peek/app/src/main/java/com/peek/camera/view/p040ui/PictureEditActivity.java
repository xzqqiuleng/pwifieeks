package com.peek.camera.view.p040ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.model.FileInfo;
import com.peek.camera.model.Login_info;
import com.peek.camera.model.PipeDefectDetail;
import com.peek.camera.model.PipeDefectImage;
import com.peek.camera.p034b.C1104a;
import com.peek.camera.p034b.C1125c;
import com.peek.camera.p034b.C1129g;
import com.peek.camera.p034b.C1130h;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1148s;
import com.peek.camera.p034b.C1155v;
import com.peek.camera.view.fragments.C1329a;
import com.peek.camera.view.fragments.DialogBiaojiFragment;
import com.peek.camera.view.fragments.DialogNormalFragment;
import com.peek.camera.view.fragments.DialogQuexianEditFragment;
import com.peek.camera.view.p037a.C1189h;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.cookie.ClientCookie;

/* renamed from: com.bmw.peek2.view.ui.PictureEditActivity */
public class PictureEditActivity extends BaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public String f3772A = "";

    /* renamed from: B */
    private Intent f3773B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public PipeDefectImage f3774C;

    /* renamed from: D */
    private Unbinder f3775D;

    /* renamed from: E */
    private BroadcastReceiver f3776E = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            C1104a.m5161a(PictureEditActivity.this.mo5210l(), intent, PictureEditActivity.this.battery_terminal, PictureEditActivity.this.battery_terminal_title);
            C1104a.m5162b(PictureEditActivity.this.mo5210l(), intent, PictureEditActivity.this.battery_device, PictureEditActivity.this.battery_device_title);
        }
    };
    @BindView(R.id.tv_battery_device)
    TextView battery_device;
    @BindView(R.id.tv_battery_device_title)
    TextView battery_device_title;
    @BindView(R.id.tv_battery_terminal)
    TextView battery_terminal;
    @BindView(R.id.tv_battery_terminal_title)
    TextView battery_terminal_title;
    @BindView(R.id.capture_image)
    ImageView captureImage;
    @BindView(R.id.pic_show_clock)
    TextView mClock;
    @BindView(R.id.pic_show_detail)
    TextView mDetail;
    @BindView(R.id.pic_show_distance)
    TextView mDistance;
    @BindView(R.id.pic_show_grade)
    TextView mGrade;
    @BindView(R.id.pic_show_guandaoId)
    TextView mGuandaoId;
    @BindView(R.id.pic_show_length)
    TextView mLength;
    @BindView(R.id.pic_show_name)
    TextView mName;
    @BindView(R.id.pipe_id)
    EditText mPipeIdEdt;
    @BindView(R.id.pic_show_style)
    TextView mStyle;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Bitmap f3777o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Bitmap f3778p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public C1189h f3779q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f3780r = -1;
    @BindView(R.id.capture_recyclerview)
    RecyclerView recyListView;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Handler f3781s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public List<PipeDefectDetail> f3782t;

    /* renamed from: u */
    private String f3783u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Canvas f3784v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public float f3785w = 30.0f;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public float f3786x = 30.0f;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public String f3787y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f3788z = 30;

    /* renamed from: com.bmw.peek2.view.ui.PictureEditActivity$a */
    public class C1392a extends GestureDetector.SimpleOnGestureListener {
        public C1392a() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float f3;
            Canvas unused = PictureEditActivity.this.f3784v = null;
            float unused2 = PictureEditActivity.this.f3785w = (-f) + PictureEditActivity.this.f3785w;
            float unused3 = PictureEditActivity.this.f3786x = (-f2) + PictureEditActivity.this.f3786x;
            Paint paint = new Paint();
            paint.setTextSize((float) PictureEditActivity.this.f3788z);
            Rect rect = new Rect();
            paint.getTextBounds(PictureEditActivity.this.f3787y, 0, PictureEditActivity.this.f3787y.length(), rect);
            float width = (float) rect.width();
            float height = (float) rect.height();
            if (PictureEditActivity.this.f3785w >= ((float) PictureEditActivity.this.f3777o.getWidth()) - width) {
                float unused4 = PictureEditActivity.this.f3785w = ((float) PictureEditActivity.this.f3777o.getWidth()) - width;
            }
            if (((float) PictureEditActivity.this.f3777o.getWidth()) - width <= 0.0f) {
                f3 = ((((float) ((int) (width % ((float) PictureEditActivity.this.f3777o.getWidth()) == 0.0f ? (width / ((float) PictureEditActivity.this.f3777o.getWidth())) + 0.0f : (width / ((float) PictureEditActivity.this.f3777o.getWidth())) + 1.0f))) * height) * 2.0f) - height;
            } else {
                f3 = height;
            }
            if (PictureEditActivity.this.f3786x >= ((float) PictureEditActivity.this.f3777o.getHeight()) - f3) {
                float unused5 = PictureEditActivity.this.f3786x = ((float) PictureEditActivity.this.f3777o.getHeight()) - f3;
            }
            if (PictureEditActivity.this.f3785w <= 0.0f) {
                float unused6 = PictureEditActivity.this.f3785w = 0.0f;
            }
            if (PictureEditActivity.this.f3786x <= 0.0f) {
                float unused7 = PictureEditActivity.this.f3786x = 0.0f;
            }
            PictureEditActivity.this.m5895a(PictureEditActivity.this.f3778p, PictureEditActivity.this.f3787y, PictureEditActivity.this.f3788z, PictureEditActivity.this.f3785w, PictureEditActivity.this.f3786x);
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5895a(Bitmap bitmap, String str, int i, float f, float f2) {
        if (this.f3777o != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.f3784v = new Canvas(this.f3778p);
            Paint paint = new Paint();
            paint.setDither(true);
            paint.setAntiAlias(true);
            this.f3784v.drawBitmap(this.f3777o, new Rect(0, 0, this.f3777o.getWidth(), this.f3777o.getHeight()), new Rect(0, 0, width, height), paint);
            m5896a(this.f3784v, m5904c(i), str, f, f2, width);
            this.f3784v.save(31);
            this.f3784v.restore();
            this.captureImage.setImageBitmap(this.f3778p);
        }
    }

    /* renamed from: a */
    private void m5896a(Canvas canvas, TextPaint textPaint, String str, float f, float f2, int i) {
        StaticLayout staticLayout = new StaticLayout(str, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.5f, 0.0f, false);
        canvas.translate(f, f2);
        staticLayout.draw(canvas);
    }

    /* renamed from: b */
    private void m5902b(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(C1129g.m5220a()).append(Login_info.local_picture_path).append(this.f3783u);
        this.f3773B.putExtra("KEY_ACTIVITY_RESULT_PIC_PATH", sb.toString() + FileInfo.EXTEND_JPG);
        if (z) {
            this.f3773B.putExtra("KEY_ACTIVITY_RESULT_XML_PATH", sb.toString() + ".xml");
            if (this.f3780r != -1) {
                String valueOf = String.valueOf(this.f3774C.getPipeDefectDetails().size());
                Intent intent = this.f3773B;
                if (C1155v.m5330a(valueOf)) {
                    valueOf = getString(R.string.noFlaw);
                }
                intent.putExtra("KEY_ACTIVITY_RESULT_PIC_QUEXIAN_CODE", valueOf);
            }
        }
        setResult(2, this.f3773B);
    }

    /* renamed from: c */
    private TextPaint m5904c(int i) {
        TextPaint textPaint = new TextPaint(257);
        textPaint.setTextSize((float) i);
        textPaint.setTypeface(Typeface.DEFAULT);
        textPaint.setColor(-1);
        return textPaint;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5906d(final int i) {
        new Thread(new Runnable() {
            public void run() {
                List unused = PictureEditActivity.this.f3782t = PictureEditActivity.this.f3774C.getPipeDefectDetails();
                if (PictureEditActivity.this.f3782t != null) {
                    PictureEditActivity.this.f3781s.sendEmptyMessage(i);
                    if (i != 4) {
                        int unused2 = PictureEditActivity.this.f3780r = -1;
                        return;
                    }
                    return;
                }
                int unused3 = PictureEditActivity.this.f3780r = -1;
            }
        }).start();
    }

    /* renamed from: q */
    private void m5915q() {
        C1104a.m5162b(mo5210l(), getIntent(), this.battery_device, this.battery_device_title);
    }

    /* renamed from: r */
    private void m5916r() {
        final GestureDetector gestureDetector = new GestureDetector(this, new C1392a());
        this.captureImage.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    /* renamed from: s */
    private void m5917s() {
        if (this.f3784v != null) {
            this.f3784v = null;
            this.f3778p.recycle();
            this.f3778p = null;
        }
    }

    /* renamed from: t */
    private void m5918t() {
        this.mPipeIdEdt.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                String unused = PictureEditActivity.this.f3772A = PictureEditActivity.this.mPipeIdEdt.getText().toString();
                PictureEditActivity.this.mGuandaoId.setText(PictureEditActivity.this.f3772A);
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    /* renamed from: u */
    private void m5919u() {
        this.f3781s = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        if (PictureEditActivity.this.f3780r != -1) {
                            PictureEditActivity.this.recyListView.scrollToPosition(PictureEditActivity.this.f3780r);
                            return;
                        }
                        return;
                    case 1:
                        PictureEditActivity.this.f3779q.mo5034a((List<PipeDefectDetail>) PictureEditActivity.this.f3782t);
                        return;
                    case 2:
                        PictureEditActivity.this.f3779q.mo5034a((List<PipeDefectDetail>) PictureEditActivity.this.f3782t);
                        PictureEditActivity.this.f3779q.mo5036c(0);
                        return;
                    case 3:
                        PictureEditActivity.this.f3779q.mo5034a((List<PipeDefectDetail>) PictureEditActivity.this.f3782t);
                        PictureEditActivity.this.f3779q.mo5036c(PictureEditActivity.this.f3782t.size() - 1);
                        return;
                    case 4:
                        PictureEditActivity.this.f3779q.mo5034a((List<PipeDefectDetail>) PictureEditActivity.this.f3782t);
                        PictureEditActivity.this.f3779q.mo5036c(PictureEditActivity.this.f3780r);
                        return;
                    case 5:
                        BaseApplication.m4926a(PictureEditActivity.this.getResources().getString(R.string.please_choose_ont_from_list_first));
                        return;
                    default:
                        return;
                }
            }
        };
    }

    /* renamed from: v */
    private void m5920v() {
        DialogNormalFragment a = DialogNormalFragment.m5724a(getString(R.string.exitingApp), getString(R.string.exitAppSure), (String) null, (String) null, true);
        a.mo5175a((C1329a) new C1329a() {
            /* renamed from: a */
            public void mo4542a() {
                PictureEditActivity.this.mo5213o();
            }

            /* renamed from: b */
            public void mo4543b() {
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), a, "DialogNormalFragment");
    }

    /* renamed from: w */
    private void m5921w() {
        if (this.f3780r >= 0 || (!TextUtils.isEmpty(this.mPipeIdEdt.getText().toString()) && !this.mPipeIdEdt.getText().toString().equals(""))) {
            BaseApplication.f2900c.execute(new Runnable() {
                public void run() {
                    C1148s.m5293a(PictureEditActivity.this.f3774C);
                }
            });
            m5902b(true);
            finish();
            return;
        }
        m5902b(false);
        finish();
    }

    /* renamed from: x */
    private void m5922x() {
        IntentFilter intentFilter = new IntentFilter("data.receiver");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        registerReceiver(this.f3776E, intentFilter);
    }

    @OnClick({R.id.add_textToImg, R.id.capture_add, R.id.capture_change, R.id.capture_delete, R.id.preview_closeApp, R.id.tv_picEdit_goback, R.id.capture_image})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_textToImg:
                DialogBiaojiFragment b = DialogBiaojiFragment.m5661b(this.f3787y);
                b.mo5140a((DialogBiaojiFragment.C1259a) new DialogBiaojiFragment.C1259a() {
                    /* renamed from: a */
                    public void mo5143a(String str) {
                        String unused = PictureEditActivity.this.f3787y = str;
                        PictureEditActivity.this.m5895a(PictureEditActivity.this.f3778p, str, PictureEditActivity.this.f3788z, PictureEditActivity.this.f3785w, PictureEditActivity.this.f3786x);
                    }
                });
                C1130h.m5241a(getSupportFragmentManager(), b, "DialogBiaojiFragment");
                return;
            case R.id.capture_add:
                if (this.f3780r != -1) {
                    DialogQuexianEditFragment a = DialogQuexianEditFragment.m5741a(false, this.f3782t.get(this.f3780r));
                    a.mo5180a((DialogQuexianEditFragment.C1308a) new DialogQuexianEditFragment.C1308a() {
                        /* renamed from: a */
                        public void mo5187a(PipeDefectDetail pipeDefectDetail) {
                            PictureEditActivity.this.f3774C.addDefectDetail(pipeDefectDetail);
                            PictureEditActivity.this.m5906d(3);
                        }

                        /* renamed from: b */
                        public void mo5188b(PipeDefectDetail pipeDefectDetail) {
                        }
                    });
                    C1130h.m5241a(getSupportFragmentManager(), a, "DialogQuexianEditFragment");
                    return;
                }
                DialogQuexianEditFragment a2 = DialogQuexianEditFragment.m5741a(false, (PipeDefectDetail) null);
                a2.mo5180a((DialogQuexianEditFragment.C1308a) new DialogQuexianEditFragment.C1308a() {
                    /* renamed from: a */
                    public void mo5187a(PipeDefectDetail pipeDefectDetail) {
                        PictureEditActivity.this.f3774C.addDefectDetail(pipeDefectDetail);
                        PictureEditActivity.this.m5906d(3);
                    }

                    /* renamed from: b */
                    public void mo5188b(PipeDefectDetail pipeDefectDetail) {
                    }
                });
                C1130h.m5241a(getSupportFragmentManager(), a2, "DialogQuexianEditFragment");
                return;
            case R.id.capture_change:
                if (this.f3780r == -1) {
                    this.f3781s.sendEmptyMessage(5);
                    return;
                }
                DialogQuexianEditFragment a3 = DialogQuexianEditFragment.m5741a(true, this.f3774C.getPipeDefectDetails().get(this.f3780r));
                a3.mo5180a((DialogQuexianEditFragment.C1308a) new DialogQuexianEditFragment.C1308a() {
                    /* renamed from: a */
                    public void mo5187a(PipeDefectDetail pipeDefectDetail) {
                    }

                    /* renamed from: b */
                    public void mo5188b(PipeDefectDetail pipeDefectDetail) {
                        ArrayList<PipeDefectDetail> pipeDefectDetails = PictureEditActivity.this.f3774C.getPipeDefectDetails();
                        pipeDefectDetails.remove(PictureEditActivity.this.f3780r);
                        pipeDefectDetails.add(PictureEditActivity.this.f3780r, pipeDefectDetail);
                        PictureEditActivity.this.f3774C.setPipeDefectDetails(pipeDefectDetails);
                        PictureEditActivity.this.m5906d(4);
                    }
                });
                C1130h.m5241a(getSupportFragmentManager(), a3, "DialogQuexianEditFragment");
                return;
            case R.id.capture_delete:
                if (this.f3780r != -1) {
                    ArrayList<PipeDefectDetail> pipeDefectDetails = this.f3774C.getPipeDefectDetails();
                    pipeDefectDetails.remove(this.f3780r);
                    this.f3774C.setPipeDefectDetails(pipeDefectDetails);
                    C1140n.m5267a("数据库：删除成功", this.f3780r);
                    this.f3780r = -1;
                    m5906d(2);
                    return;
                }
                return;
            case R.id.preview_closeApp:
                m5920v();
                return;
            case R.id.tv_picEdit_goback:
                String str = this.f3783u + FileInfo.EXTEND_JPG;
                if (TextUtils.isEmpty(this.f3772A) || this.f3772A.equals("")) {
                    this.f3783u = this.f3783u;
                } else {
                    this.f3783u += "_" + this.f3772A;
                    this.f3774C.setPipeSection(this.f3772A);
                }
                String str2 = this.f3783u + FileInfo.EXTEND_JPG;
                if (!str.equals(str2)) {
                    C1129g.m5228a(C1129g.m5220a() + Login_info.local_picture_path, str, str2);
                    C1129g.m5227a(C1129g.m5220a() + Login_info.local_picture_path + str);
                }
                if (this.f3787y != null && !TextUtils.isEmpty(this.f3787y)) {
                    try {
                        C1125c.m5214a(C1129g.m5220a() + Login_info.local_picture_path, str2, this.f3778p);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                C1129g.m5227a(C1129g.m5220a() + Login_info.local_picture_path + str2);
                this.f3773B.putExtra("KEY_ACTIVITY_RESULT_PIC_PATH", C1129g.m5220a() + Login_info.local_picture_path + str2);
                this.f3774C.setFilename(C1129g.m5220a() + Login_info.local_picture_path + str2);
                m5921w();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_picture_edit);
        this.f3775D = ButterKnife.bind((Activity) this);
        this.f3773B = new Intent();
        m5922x();
        m5915q();
        m5919u();
        this.f3774C = new PipeDefectImage();
        String stringExtra = getIntent().getStringExtra(ClientCookie.PATH_ATTR);
        this.f3783u = stringExtra.substring(stringExtra.lastIndexOf("/") + 1, stringExtra.lastIndexOf("."));
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f3777o = BitmapFactory.decodeFile(stringExtra);
            this.captureImage.setImageBitmap(this.f3777o);
        }
        this.recyListView.setLayoutManager(new LinearLayoutManager(this));
        this.f3779q = new C1189h(this);
        this.recyListView.setAdapter(this.f3779q);
        this.f3779q.mo5032a((C1189h.C1191a) new C1189h.C1191a() {
            /* renamed from: a */
            public void mo5038a(int i) {
                int unused = PictureEditActivity.this.f3780r = i;
                PictureEditActivity.this.f3781s.sendEmptyMessage(0);
            }
        });
        m5906d(1);
        m5918t();
        this.f3778p = Bitmap.createBitmap(this.f3777o.getWidth(), this.f3777o.getHeight(), Bitmap.Config.ARGB_8888);
        m5916r();
        this.f3787y = "";
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f3775D.unbind();
        unregisterReceiver(this.f3776E);
        m5917s();
        this.f3777o.recycle();
        this.f3777o = null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            m5921w();
            return true;
        } else if (i != 3) {
            return super.onKeyDown(i, keyEvent);
        } else {
            return true;
        }
    }
}
