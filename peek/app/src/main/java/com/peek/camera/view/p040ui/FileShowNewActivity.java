package com.peek.camera.view.p040ui;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import uk.co.senab.photoview.PhotoView;
import com.bumptech.glide.Glide;
import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_LOG_TYPE;
import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.model.FileInfo;
import com.peek.camera.model.Login_info;
import com.peek.camera.model.PipeDefectImage;
import com.peek.camera.p032a.C1103h;
import com.peek.camera.p032a.p033a.C1069c;
import com.peek.camera.p032a.p033a.C1087h;
import com.peek.camera.p034b.C1104a;
import com.peek.camera.p034b.C1129g;
import com.peek.camera.p034b.C1130h;
import com.peek.camera.p034b.C1132j;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1144q;
import com.peek.camera.p034b.C1148s;
import com.peek.camera.view.fragments.C1329a;
import com.peek.camera.view.fragments.DialogEdtNormalFragment;
import com.peek.camera.view.fragments.DialogNormalFragment;
import com.peek.camera.view.p037a.C1173d;
import com.peek.camera.view.p037a.C1185f;
import com.peek.camera.view.p037a.C1187g;
import com.peek.camera.view.p037a.C1193i;
import com.peek.camera.view.p038b.C1210b;
import com.peek.camera.view.p039c.C1236a;
import com.peek.camera.view.view.CompositeImageText;
import com.peek.camera.view.view.CustomPotSeekBar;
import java.io.File;
import java.util.List;
import org.apache.http.cookie.ClientCookie;
/* renamed from: com.bmw.peek2.view.ui.FileShowNewActivity */
public class FileShowNewActivity extends BaseActivity implements C1236a {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public String f3641A;

    /* renamed from: B */
    private Unbinder f3642B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public Handler f3643C = new Handler();

    /* renamed from: D */
    private BroadcastReceiver f3644D = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            C1104a.m5161a(FileShowNewActivity.this.mo5210l(), intent, FileShowNewActivity.this.battery_terminal, FileShowNewActivity.this.battery_terminal_title);
            C1104a.m5162b(FileShowNewActivity.this.mo5210l(), intent, FileShowNewActivity.this.battery_device, FileShowNewActivity.this.battery_device_title);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: E */
    public String f3645E;

    /* renamed from: F */
    private boolean f3646F;

    /* renamed from: G */
    private TextView f3647G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public Runnable f3648H = new Runnable() {
        public void run() {
            if (FileShowNewActivity.this.searchEdit != null && FileShowNewActivity.this.f3652o != null) {
                FileShowNewActivity.this.f3652o.mo4530b(FileShowNewActivity.this.searchEdit.getText().toString());
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: I */
    public long f3649I;

    /* renamed from: J */
    private SeekBar.OnSeekBarChangeListener f3650J = new SeekBar.OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            boolean unused = FileShowNewActivity.this.f3654q = true;
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            FileShowNewActivity.this.mo5112h(seekBar.getProgress());
            FileShowNewActivity.this.mCustomPotSeekBar.setmIsNoShowOnThisSections(false);
            BaseActivity.m5794b("stopTouch seekbar!");
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: K */
    public String f3651K;
    @BindView(R.id.tv_battery_device)
    TextView battery_device;
    @BindView(R.id.tv_battery_device_title)
    TextView battery_device_title;
    @BindView(R.id.tv_battery_terminal)
    TextView battery_terminal;
    @BindView(R.id.tv_battery_terminal_title)
    TextView battery_terminal_title;
    @BindView(R.id.cit_file_all_choose)
    CompositeImageText cit_file_all_choose;
    @BindView(R.id.cit_file_copy)
    CompositeImageText cit_file_copy;
    @BindView(R.id.container_picturePlayer)
    RelativeLayout containerPicturePlayer;
    @BindView(R.id.container_video_player)
    RelativeLayout containerVideoPlayer;
    @BindView(R.id.cpsb_picPot)
    CustomPotSeekBar mCustomPotSeekBar;
    @BindView(R.id.img_quexianPicInVideo)
    PhotoView mImgQuexianPicInVideo;
    @BindView(R.id.ll_container_quexianShow)
    LinearLayout mLlContainerQuexianShow;
    @BindView(R.id.ll_file_edit)
    LinearLayout mLl_file_edit;
    @BindView(R.id.rcy_quexianDetailShow)
    RecyclerView mQuexianShow;
    @BindView(R.id.recyclerView_queXianPic)
    RecyclerView mRecyPicQuexian;
    @BindView(R.id.recy_picQuexianShowInVideo)
    RecyclerView mRecyPicQuexianShowInVideo;
    @BindView(R.id.rl_container_queXianPic)
    RelativeLayout mRlContainerQueXianPic;
    @BindView(R.id.rl_file_edit_normal)
    RelativeLayout mRl_file_edit_normal;
    @BindView(R.id.tv_title_picQuexian)
    TextView mTvQuexianCount;
    @BindView(R.id.tv_quexian_show_invideo)
    TextView mTvXmlInfoShow;
    @BindView(R.id.ff_container_centerShow)
    View mXmlInfoContainer;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C1069c f3652o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f3653p;
    @BindView(R.id.photoView_pic)
    PhotoView photoViewPic;
    @BindView(R.id.pic_show_bottom_container)
    LinearLayout picShowBottomContainer;
    @BindView(R.id.play_start)
    ImageView playStart;
    @BindView(R.id.player_seekbar)
    SeekBar playerSeekbar;
    @BindView(R.id.player_surface)
    VideoView playerSurface;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f3654q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public C1103h f3655r;
    @BindView(R.id.recyclerView_pic)
    RecyclerView recyclerViewPic;

    /* renamed from: s */
    private C1132j f3656s;
    @BindView(R.id.search_edit)
    EditText searchEdit;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f3657t = 1;
    @BindView(R.id.tv_fileActivty_diskSize)
    TextView tvDiskSize;
    @BindView(R.id.tv_video_allTime)
    TextView tvVideoAllTime;
    @BindView(R.id.tv_video_currentTime)
    TextView tvVideoCurrentTime;
    @BindView(R.id.tv_video_playSpeed)
    TextView tvVideoPlaySpeed;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f3658u = 1;

    /* renamed from: v */
    private boolean f3659v;

    /* renamed from: w */
    private PopupWindow f3660w;

    /* renamed from: x */
    private int f3661x;

    /* renamed from: y */
    private int f3662y;

    /* renamed from: z */
    private String f3663z;

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m5806A() {
        if (this.f3646F) {
            this.f3645E += Login_info.local_picture_path;
        } else {
            this.f3645E += Login_info.local_video_path;
        }
        this.f3652o.mo4526a(this.f3645E);
    }

    /* renamed from: B */
    private void m5807B() {
        DialogNormalFragment a = DialogNormalFragment.m5724a(getString(R.string.exitingApp), getString(R.string.exitAppSure), (String) null, (String) null, true);
        a.mo5175a((C1329a) new C1329a() {
            /* renamed from: a */
            public void mo4542a() {
                FileShowNewActivity.this.mo5213o();
            }

            /* renamed from: b */
            public void mo4543b() {
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), a, "DialogNormalFragment");
    }

    /* renamed from: C */
    private void m5808C() {
        this.f3652o.mo4529b();
        m5809D();
    }

    /* renamed from: D */
    private void m5809D() {
        StringBuilder sb = new StringBuilder();
        List<Float> e = C1129g.m5239e();
        sb.append(Login_info.getInstance().isSaveToExSdcard() ? getResources().getString(R.string.outStorage) : getResources().getString(R.string.inStorage)).append("\n").append(e.get(2)).append("G").append("/").append(e.get(0)).append("G");
        this.tvDiskSize.setText(sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m5810E() {
        Bitmap a = this.f3656s.mo4653a("empty");
        if (a == null) {
            a = Bitmap.createBitmap(1280, 720, Bitmap.Config.ARGB_8888);
            this.f3656s.mo4655a(a, "empty");
        }
        this.photoViewPic.setImageBitmap(a);
    }

    /* renamed from: F */
    private void m5811F() {
        this.searchEdit.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                FileShowNewActivity.this.f3643C.removeCallbacks(FileShowNewActivity.this.f3648H);
                FileShowNewActivity.this.f3643C.postDelayed(FileShowNewActivity.this.f3648H, 2000);
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    /* renamed from: G */
    private void m5812G() {
        this.mLlContainerQuexianShow.setVisibility(View.GONE);
        this.mTvQuexianCount.setText("");
        C1185f fVar = (C1185f) this.mQuexianShow.getAdapter();
        if (fVar != null) {
            fVar.mo5028d();
        }
    }

    /* renamed from: H */
    private void m5813H() {
        this.playerSeekbar.setOnSeekBarChangeListener(this.f3650J);
        this.playerSeekbar.setMax(1000);
        new Thread(new Runnable() {
            public void run() {
                while (!FileShowNewActivity.this.f3653p) {
                    if (FileShowNewActivity.this.mXmlInfoContainer.isShown() && System.currentTimeMillis() - FileShowNewActivity.this.f3649I > 1000 && FileShowNewActivity.this.playerSurface.isPlaying()) {
                        FileShowNewActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                FileShowNewActivity.this.m5814I();
                            }
                        });
                    }
                    if (!FileShowNewActivity.this.f3654q) {
                        int i = 0;
                        try {
                            if (FileShowNewActivity.this.playerSurface.isPlaying()) {
                                i = FileShowNewActivity.this.playerSurface.getCurrentPosition();
                            }
                        } catch (IllegalStateException e) {
                            C1140n.m5269b("获取当前播放位置异常：Error：" + e.toString());
                        }
                        if (FileShowNewActivity.this.f3657t != 1) {
                            FileShowNewActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    FileShowNewActivity.this.playerSurface.pause();
                                    int currentPosition = FileShowNewActivity.this.playerSurface.getCurrentPosition();
                                    FileShowNewActivity.this.mo5112h(((FileShowNewActivity.this.f3657t / 2) * NET_DVR_LOG_TYPE.MINOR_SCREEN_GET_LAYOUT) + currentPosition);
                                    FileShowNewActivity.this.mo5111g(((FileShowNewActivity.this.f3657t / 2) * HCNetSDK.NET_DVR_GET_DEVICECFG_V40) + currentPosition);
                                    if (FileShowNewActivity.this.playerSeekbar.getMax() <= currentPosition + ((FileShowNewActivity.this.f3657t / 2) * HCNetSDK.NET_DVR_GET_DEVICECFG_V40)) {
                                        FileShowNewActivity.this.f3655r.mo4578c();
                                    }
                                }
                            });
                        } else if (FileShowNewActivity.this.f3658u != 1) {
                            FileShowNewActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    FileShowNewActivity.this.playerSurface.pause();
                                }
                            });
                            FileShowNewActivity.this.m5817a((long) (FileShowNewActivity.this.f3658u * 15));
                            final int finalI = i;
                            FileShowNewActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    FileShowNewActivity.this.playerSurface.start();
                                    FileShowNewActivity.this.mo5111g(finalI);
                                }
                            });
                        }
                        if (FileShowNewActivity.this.f3657t == 1 && FileShowNewActivity.this.f3658u == 1 && FileShowNewActivity.this.f3655r.mo4581f()) {
                            FileShowNewActivity.this.mo5111g(i);
                        }
                        FileShowNewActivity.this.tvVideoCurrentTime.post(new Runnable() {
                            public void run() {
                                if (FileShowNewActivity.this.tvVideoCurrentTime != null) {
                                    FileShowNewActivity.this.tvVideoCurrentTime.setText(FileShowNewActivity.this.f3655r.mo4579d());
                                }
                            }
                        });
                    }
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: I */
    public void m5814I() {
        this.mXmlInfoContainer.setVisibility(View.GONE);
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public void m5815J() {
        this.tvVideoCurrentTime.setText(this.f3655r.mo4579d());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5817a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5825b(final String str, final String str2) {
        DialogEdtNormalFragment a = DialogEdtNormalFragment.m5683a(getString(R.string.pleaseInputFileName), str2, (String) null, (String) null, false);
        a.mo5156a((DialogEdtNormalFragment.C1279a) new DialogEdtNormalFragment.C1279a() {
            /* renamed from: a */
            public void mo5160a() {
                FileShowNewActivity.this.m5833f(str + str2 + FileInfo.EXTEND_JPG);
            }

            /* renamed from: a */
            public void mo5161a(String str) {
                if (TextUtils.isEmpty(str) || str.equals(str2)) {
                    FileShowNewActivity.this.m5833f(str + str2 + FileInfo.EXTEND_JPG);
                    return;
                }
                File file = new File(str + str + FileInfo.EXTEND_JPG);
                if (file.exists()) {
                    int i = 0;
                    while (file.exists()) {
                        i++;
                        file = new File(str + str + "_" + i + FileInfo.EXTEND_JPG);
                    }
                    str = str + "_" + i;
                }
                C1129g.m5228a(str, str2 + FileInfo.EXTEND_JPG, str + FileInfo.EXTEND_JPG);
                C1129g.m5227a(str + str2 + FileInfo.EXTEND_JPG);
                C1129g.m5227a(str + str + FileInfo.EXTEND_JPG);
                FileShowNewActivity.this.m5833f(str + str + FileInfo.EXTEND_JPG);
            }
        });
        C1130h.m5241a(getSupportFragmentManager(), a, "DialogEdtNormalFragment");
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m5833f(final String str) {
        final C1210b bVar = new C1210b(mo5210l(), getResources().getString(R.string.isEditPicture), str);
        bVar.mo5074a((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(FileShowNewActivity.this.mo5210l(), PictureEditActivity.class);
                intent.putExtra(ClientCookie.PATH_ATTR, str);
                FileShowNewActivity.this.startActivityForResult(intent, 0);
                bVar.mo5073a();
            }
        });
        bVar.mo5075b((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                C1129g.m5227a(str);
                bVar.mo5073a();
            }
        });
    }

    /* renamed from: f */
    private void m5834f(boolean z) {
        if (z) {
            this.containerPicturePlayer.setVisibility(View.VISIBLE);
            this.containerVideoPlayer.setVisibility(View.GONE);
            return;
        }
        this.containerPicturePlayer.setVisibility(View.GONE);
        this.containerVideoPlayer.setVisibility(View.VISIBLE);
    }

    /* renamed from: g */
    private C1173d m5835g(boolean z) {
        this.recyclerViewPic.setLayoutManager(new GridLayoutManager(mo5210l(), 3));
        C1173d dVar = new C1173d(mo5210l(), z);
        this.recyclerViewPic.setAdapter(dVar);
        return dVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m5836g(String str) {
        if (str != null) {
            String str2 = str.substring(0, str.lastIndexOf(".")) + ".xml";
            if (new File(str2).exists()) {
                PipeDefectImage b = C1148s.m5295b(str2);
                if (b != null) {
                    String pipeSection = b.getPipeSection();
                    this.mTvQuexianCount.setText(getString(R.string.pic_quexian_count).replace("${count}", String.valueOf(b.getPipeDefectDetails().size())).replace("${guandaohao}", TextUtils.isEmpty(pipeSection) ? "" : getString(R.string.guandaohaowei).replace("${guandaohao}", pipeSection)));
                    this.mLlContainerQuexianShow.setVisibility(View.VISIBLE);
                    ((C1185f) this.mQuexianShow.getAdapter()).mo5026a(b.getPipeDefectDetails());
                    return;
                }
                return;
            }
            m5812G();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m5839i(int i) {
        this.mCustomPotSeekBar.setProgress(i);
    }

    /* renamed from: t */
    private void m5847t() {
        IntentFilter intentFilter = new IntentFilter("data.receiver");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        registerReceiver(this.f3644D, intentFilter);
    }

    /* renamed from: u */
    private void m5848u() {
        C1104a.m5162b(mo5210l(), getIntent(), this.battery_device, this.battery_device_title);
    }

    /* renamed from: v */
    private void m5849v() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.mRecyPicQuexianShowInVideo.setLayoutManager(linearLayoutManager);
        this.mRecyPicQuexianShowInVideo.setAdapter(new C1187g(this));
        this.mRecyPicQuexian.setLayoutManager(new LinearLayoutManager(mo5210l()));
        this.mRecyPicQuexian.setAdapter(new C1193i(mo5210l()));
    }

    /* renamed from: w */
    private void m5850w() {
        this.mQuexianShow.setLayoutManager(new LinearLayoutManager(this));
        this.mQuexianShow.setAdapter(new C1185f(this));
    }

    /* renamed from: x */
    private void m5851x() {
        View inflate = View.inflate(mo5210l(), R.layout.save_copy_path_choose, (ViewGroup) null);
        this.f3647G = (TextView) inflate.findViewById(R.id.tv_usb);
        ((TextView) inflate.findViewById(R.id.tv_sdcard)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String unused = FileShowNewActivity.this.f3641A = FileShowNewActivity.this.mo5210l().getString(R.string.sdCard);
                String unused2 = FileShowNewActivity.this.f3645E = C1129g.m5222a(FileShowNewActivity.this.mo5210l(), "EXT");
                FileShowNewActivity.this.m5853z();
                FileShowNewActivity.this.m5806A();
            }
        });
        this.f3647G.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Login_info.getInstance().isSaveToExSdcard()) {
                    String unused = FileShowNewActivity.this.f3641A = FileShowNewActivity.this.mo5210l().getString(R.string.localSave);
                    String unused2 = FileShowNewActivity.this.f3645E = C1129g.m5224a(FileShowNewActivity.this.mo5210l()).get(0);
                } else {
                    String unused3 = FileShowNewActivity.this.f3641A = FileShowNewActivity.this.mo5210l().getString(R.string.usb);
                    String unused4 = FileShowNewActivity.this.f3645E = C1129g.m5222a(FileShowNewActivity.this.mo5210l(), "USB");
                }
                FileShowNewActivity.this.m5853z();
                FileShowNewActivity.this.m5806A();
            }
        });
        this.f3660w = new PopupWindow(inflate, C1144q.m5286a(mo5210l(), 100.0f), C1144q.m5286a(mo5210l(), 70.0f));
        this.f3660w.setBackgroundDrawable(new BitmapDrawable());
        this.f3660w.setFocusable(true);
        this.f3660w.setOutsideTouchable(true);
        this.f3660w.setOutsideTouchable(true);
        this.f3660w.setTouchable(true);
        m5852y();
    }

    /* renamed from: y */
    private void m5852y() {
        int[] iArr = new int[2];
        this.recyclerViewPic.getLocationOnScreen(iArr);
        this.f3661x = iArr[0];
        this.f3662y = (iArr[1] + this.recyclerViewPic.getHeight()) - C1144q.m5286a(mo5210l(), 70.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m5853z() {
        for (String next : C1129g.m5224a(mo5210l())) {
            if (next.contains(this.f3645E)) {
                this.f3645E = next;
            }
        }
    }

    /* renamed from: a */
    public void mo5100a(final PipeDefectImage pipeDefectImage) {
        if (pipeDefectImage != null) {
            this.f3649I = System.currentTimeMillis();
            runOnUiThread(new Runnable() {
                public void run() {
                    StringBuilder sb = new StringBuilder();
                    if (pipeDefectImage.getPipeSection() != null) {
                        sb.append(FileShowNewActivity.this.getString(R.string.capture_guandao_id_e)).append(pipeDefectImage.getPipeSection()).append("  ");
                    }
                    String filename = pipeDefectImage.getFilename();
                    if (FileShowNewActivity.this.f3651K == null || FileShowNewActivity.this.f3651K != filename) {
                        String unused = FileShowNewActivity.this.f3651K = filename;

                        Glide.with(FileShowNewActivity.this.mo5210l()).load(filename).into((ImageView) FileShowNewActivity.this.mImgQuexianPicInVideo);
                    }
                    if (pipeDefectImage.getPipeDefectDetails().size() > 0) {
                        sb.append(FileShowNewActivity.this.getString(R.string.quexianTitleRemindFirst)).append(pipeDefectImage.getPipeDefectDetails().size()).append(FileShowNewActivity.this.getString(R.string.quexianTitleRemindSecond) + "\n");
                    }
                    FileShowNewActivity.this.mTvXmlInfoShow.setText(sb.toString());
                    FileShowNewActivity.this.mXmlInfoContainer.setVisibility(View.VISIBLE);
                    ((C1187g) FileShowNewActivity.this.mRecyPicQuexianShowInVideo.getAdapter()).mo5030a(pipeDefectImage.getPipeDefectDetails());
                }
            });
        }
    }

    /* renamed from: a */
    public void mo5101a(final String str, final String str2) {
        runOnUiThread(new Runnable() {
            public void run() {
                if (BaseApplication.m4928b().getInt("KEY_FILE_NAME_MODEL_MINESET", 0) != 2) {
                    FileShowNewActivity.this.m5833f(str + str2 + FileInfo.EXTEND_JPG);
                } else {
                    FileShowNewActivity.this.m5825b(str, str2);
                }
            }
        });
    }

    /* renamed from: b */
    public void mo5102b(boolean z) {
    }

    /* renamed from: c */
    public void mo5217c(int i) {
        switch (i) {
            case -16:
                this.tvVideoPlaySpeed.setText("1/16X");
                return;
            case -8:
                this.tvVideoPlaySpeed.setText("1/8X");
                return;
            case -4:
                this.tvVideoPlaySpeed.setText("1/4X");
                return;
            case -2:
                this.tvVideoPlaySpeed.setText("1/2X");
                return;
            case 1:
                this.tvVideoPlaySpeed.setText("1X");
                return;
            case 2:
                this.tvVideoPlaySpeed.setText("2X");
                return;
            case 4:
                this.tvVideoPlaySpeed.setText("4X");
                return;
            case 8:
                this.tvVideoPlaySpeed.setText("8X");
                return;
            case 16:
                this.tvVideoPlaySpeed.setText("16X");
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    public void mo5103c(boolean z) {
        if (z) {
            this.mRl_file_edit_normal.setVisibility(View.GONE);
            this.mLl_file_edit.setVisibility(View.VISIBLE);
            return;
        }
        this.mRl_file_edit_normal.setVisibility(View.VISIBLE);
        this.mLl_file_edit.setVisibility(View.GONE);
    }

    /* renamed from: d */
    public void mo5104d(int i) {
        runOnUiThread(new Runnable() {
            public void run() {
                FileShowNewActivity.this.mo5206a(FileShowNewActivity.this.getString(R.string.startcopy));
            }
        });
    }

    /* renamed from: d */
    public void mo5105d(String str) {
        if (str != null) {
            Bitmap a = this.f3656s.mo4653a(str);
            if (a == null) {
                a = BitmapFactory.decodeFile(str);
                this.f3656s.mo4655a(a, str);
            }
            this.photoViewPic.setImageBitmap(a);
            if (this.f3646F) {
                m5836g(str);
                return;
            }
            return;
        }
        this.photoViewPic.setImageDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
    }

    /* renamed from: d */
    public void mo5106d(boolean z) {
        if (z) {
            this.cit_file_all_choose.setImage(R.mipmap.file_all_choose);
            this.f3659v = true;
            return;
        }
        this.cit_file_all_choose.setImage(R.mipmap.file_all_choose_normal);
        this.f3659v = false;
    }

    /* renamed from: e */
    public void mo5107e(final int i) {
        runOnUiThread(new Runnable() {
            public void run() {
                FileShowNewActivity.this.mo5206a(FileShowNewActivity.this.getString(R.string.copyRemindFirst) + i + FileShowNewActivity.this.getString(R.string.copyremindSecond));
            }
        });
    }

    /* renamed from: e */
    public void mo5108e(String str) {
        this.tvVideoAllTime.setText(str);
    }

    /* renamed from: e */
    public void mo5109e(boolean z) {
        if (this.playStart != null) {
            if (!z) {
                this.playStart.setImageResource(R.mipmap.play_start);
            } else {
                this.playStart.setImageResource(R.mipmap.play_pause);
            }
        }
    }

    /* renamed from: f */
    public void mo5110f(int i) {
        if (this.playerSeekbar != null) {
            this.playerSeekbar.setMax(i);
            this.mCustomPotSeekBar.setMax(i);
        }
    }

    /* renamed from: g */
    public void mo5111g(int i) {
        this.playerSeekbar.setProgress(i);
        m5839i(i);
    }

    /* renamed from: h */
    public void mo5112h(final int i) {
        runOnUiThread(new Runnable() {
            public void run() {
                FileShowNewActivity.this.m5839i(i);
                FileShowNewActivity.this.f3655r.mo4575a((float) i);
                FileShowNewActivity.this.m5815J();
                boolean unused = FileShowNewActivity.this.f3654q = false;
            }
        });
    }

    @OnClick({R.id.cit_file_all_choose, R.id.cit_file_copy, R.id.cit_file_delete, R.id.cit_file_edit_cancel,  R.id.compositeImgTv_pic_edit, R.id.compositeImgTv_pic_goBack, R.id.img_cancleX_quexianPicList, R.id.img_cancle_inVisible, R.id.play_cut, R.id.play_fast, R.id.play_last, R.id.play_next,  R.id. play_slow ,  R.id.play_start,  R.id.play_stop,  R.id.preview_closeApp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cit_file_all_choose:
                if (!this.f3659v) {
                    this.f3652o.mo4535g();
                    this.f3659v = true;
                    this.cit_file_all_choose.setImage(R.mipmap.file_all_choose);
                } else {
                    this.f3652o.mo4536h();
                    this.f3659v = false;
                    this.cit_file_all_choose.setImage(R.mipmap.file_all_choose_normal);
                }
                m5812G();
                return;
            case R.id.cit_file_copy:
                String a = C1129g.m5222a(mo5210l(), "USB");
                String a2 = C1129g.m5222a(mo5210l(), "EXT");
                String str = C1129g.m5224a(mo5210l()).get(0);
                if (TextUtils.isEmpty(a2) && TextUtils.isEmpty(a)) {
                    mo5206a(getString(R.string.noOutSdcard));
                    return;
                } else if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a)) {
                    this.f3663z = mo5210l().getString(R.string.localSave);
                    if (Login_info.getInstance().isSaveToExSdcard()) {
                        this.f3663z = mo5210l().getString(R.string.usb);
                        if (this.f3647G != null) {
                            this.f3647G.setText("本机");
                        }
                    }
                    this.f3660w.showAtLocation(this.cit_file_all_choose, 0, this.f3661x, this.f3662y);
                    return;
                } else if (!TextUtils.isEmpty(a2) || !TextUtils.isEmpty(a)) {
                    if (!TextUtils.isEmpty(a2)) {
                        if (Login_info.getInstance().isSaveToExSdcard()) {
                            this.f3663z = mo5210l().getString(R.string.sdCard);
                            this.f3641A = mo5210l().getString(R.string.localSave);
                            this.f3645E = str;
                        } else {
                            this.f3663z = mo5210l().getString(R.string.localSave);
                            this.f3641A = mo5210l().getString(R.string.sdCard);
                            this.f3645E = a2;
                        }
                    } else if (Login_info.getInstance().isSaveToExSdcard()) {
                        this.f3663z = mo5210l().getString(R.string.usb);
                        this.f3641A = mo5210l().getString(R.string.localSave);
                        this.f3645E = str;
                    } else {
                        this.f3663z = mo5210l().getString(R.string.localSave);
                        this.f3641A = mo5210l().getString(R.string.usb);
                        this.f3645E = a;
                    }
                    m5853z();
                    m5806A();
                    return;
                } else {
                    return;
                }
            case R.id.cit_file_delete:
                this.f3652o.mo4532d();
                return;
            case R.id.cit_file_edit_cancel:
                this.mRl_file_edit_normal.setVisibility(View.VISIBLE);
                this.mLl_file_edit.setVisibility(View.GONE);
                this.f3652o.mo4527a(false);
                this.cit_file_all_choose.setImage(R.mipmap.file_all_choose_normal);
                this.f3659v = false;
                this.f3652o.mo4536h();
                this.mRlContainerQueXianPic.setVisibility(View.GONE);
                m5812G();
                return;
            case R.id.compositeImgTv_pic_edit:
                this.mRl_file_edit_normal.setVisibility(View.GONE);
                this.mLl_file_edit.setVisibility(View.VISIBLE);
                this.f3652o.mo4527a(true);
                return;
            case R.id.compositeImgTv_pic_goBack:
                mo5212n();
                return;
            case R.id.img_cancleX_quexianPicList:
                this.mRlContainerQueXianPic.setVisibility(View.GONE);
                return;
            case R.id.img_cancle_inVisible:
                m5814I();
                this.mCustomPotSeekBar.setmIsNoShowOnThisSections(true);
                return;
            case R.id.play_cut:
                this.f3655r.mo4580e();
                return;
            case R.id.play_fast:
                if (!this.f3652o.mo4528a()) {
                    return;
                }
                if (this.f3658u != 1) {
                    this.f3658u /= 2;
                    mo5217c(-this.f3658u);
                    if (this.f3658u == 1) {
                        this.playerSurface.start();
                        return;
                    }
                    return;
                }
                this.playerSurface.pause();
                if (this.f3657t < 16) {
                    this.f3657t *= 2;
                } else {
                    this.f3657t = 16;
                }
                mo5217c(this.f3657t);
                return;
            case R.id.play_last:
                int e = this.f3652o.mo4533e();
                if (e >= 0) {
                    this.recyclerViewPic.scrollToPosition(e);
                    return;
                }
                return;
            case R.id.play_next:
                int f = this.f3652o.mo4534f();
                if (f >= 0) {
                    this.recyclerViewPic.scrollToPosition(f);
                    return;
                }
                return;
            case R.id.play_slow:
                if (!this.f3652o.mo4528a()) {
                    return;
                }
                if (this.f3657t != 1) {
                    this.playerSurface.pause();
                    this.f3657t /= 2;
                    mo5217c(this.f3657t);
                    if (this.f3657t == 1) {
                        this.playerSurface.start();
                        return;
                    }
                    return;
                }
                this.playerSurface.start();
                if (this.f3658u < 16) {
                    this.f3658u *= 2;
                } else {
                    this.f3658u = 16;
                }
                mo5217c(-this.f3658u);
                return;
            case R.id.play_start:
                this.f3655r.mo4574a();
                return;
            case R.id.play_stop:
                this.mRlContainerQueXianPic.setVisibility(View.GONE);
                this.f3655r.mo4578c();
                this.f3657t = 1;
                this.f3658u = 1;
                return;
            case R.id.preview_closeApp:
                m5807B();
                return;
            default:
                return;
        }
    }


    /* access modifiers changed from: protected */
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView( R.layout.activity_file_show_new);
        this.f3642B = ButterKnife.bind((Activity) this);
        this.f3656s = new C1132j();
        m5848u();
        this.f3646F = getIntent().getBooleanExtra("picture", true);
        m5834f(this.f3646F);
        m5847t();
        C1173d g = m5835g(this.f3646F);
        m5811F();
        if (!this.f3646F) {
            m5849v();
            this.f3655r = new C1087h(this, (String) null, this.playerSurface, this.playerSeekbar, this.mCustomPotSeekBar, this.mRecyPicQuexian, this.mRlContainerQueXianPic);
            m5813H();
        } else {
            m5850w();
        }
        this.f3652o = new C1069c(g, this.f3646F, this, mo5210l(), this.f3655r);
        m5808C();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f3653p = true;
        this.f3642B.unbind();
        unregisterReceiver(this.f3644D);
        this.f3656s.mo4654a();
        if (this.f3655r != null) {
            this.f3655r.mo4582g();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            mo5212n();
            return true;
        } else if (i != 3) {
            return super.onKeyDown(i, keyEvent);
        } else {
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m5851x();
    }

    /* renamed from: q */
    public void mo5113q() {
        runOnUiThread(new Runnable() {
            public void run() {
                FileShowNewActivity.this.m5810E();
                FileShowNewActivity.this.m5836g((String) null);
                FileShowNewActivity.this.mRlContainerQueXianPic.setVisibility(View.GONE);
            }
        });
    }

    /* renamed from: r */
    public void mo5114r() {
        runOnUiThread(new Runnable() {
            public void run() {
                FileShowNewActivity.this.mo5206a(FileShowNewActivity.this.getString(R.string.copyFileSuccess));
            }
        });
    }

    /* renamed from: s */
    public void mo5115s() {
        if (this.tvVideoAllTime != null) {
            this.f3657t = 1;
            this.f3658u = 1;
            runOnUiThread(new Runnable() {
                public void run() {
                    FileShowNewActivity.this.tvVideoCurrentTime.setText("00:00");
                    FileShowNewActivity.this.tvVideoPlaySpeed.setText("1X");
                    FileShowNewActivity.this.playStart.setImageResource(R.mipmap.play_start);
                    FileShowNewActivity.this.m5814I();
                    FileShowNewActivity.this.mo5111g(0);
                }
            });
        }
    }
}
