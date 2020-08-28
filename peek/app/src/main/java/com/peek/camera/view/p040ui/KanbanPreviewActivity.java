package com.peek.camera.view.p040ui;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.SeekBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.peek.camera.R;
import com.peek.camera.view.view.CustomerVideoView;

import java.io.File;
import org.apache.http.cookie.ClientCookie;

/* renamed from: com.bmw.peek2.view.ui.KanbanPreviewActivity */
public class KanbanPreviewActivity extends BaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f3749o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f3750p;

    /* renamed from: q */
    private Unbinder f3751q;

    /* renamed from: r */
    private SeekBar.OnSeekBarChangeListener f3752r = new SeekBar.OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            KanbanPreviewActivity.this.videoView.seekTo((seekBar.getProgress() * KanbanPreviewActivity.this.f3749o) / 100);
            if (!KanbanPreviewActivity.this.videoView.isPlaying()) {
                KanbanPreviewActivity.this.videoView.start();
            }
        }
    };
    @BindView(R.id.sb_kanbanPlayer)
    SeekBar seekBar;
    @BindView(R.id.vdv_kanban)
    CustomerVideoView videoView;

    /* renamed from: d */
    public void mo5247d(String str) {
        if (str == null) {
            mo5206a(getString(R.string.fileNoFound));
            return;
        }
        this.videoView.setVideoURI(Uri.parse(str));
        this.videoView.start();
    }

    @OnClick({R.id.img_goback})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_goback:
                finish();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView((int) R.layout.activity_kanban_preview);
        this.f3751q = ButterKnife.bind((Activity) this);
        String stringExtra = getIntent().getStringExtra(ClientCookie.PATH_ATTR);
        if (!new File(stringExtra).exists()) {
            mo5206a(getString(R.string.fileNoFound));
            return;
        }
        mo5247d(stringExtra);
        this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                int unused = KanbanPreviewActivity.this.f3749o = (int) ((long) mediaPlayer.getDuration());
            }
        });
        this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                KanbanPreviewActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        KanbanPreviewActivity.this.videoView.seekTo(KanbanPreviewActivity.this.f3749o);
                    }
                });
            }
        });
        this.seekBar.setOnSeekBarChangeListener(this.f3752r);
        new Thread(new Runnable() {
            public void run() {
                while (!KanbanPreviewActivity.this.f3750p) {
                    KanbanPreviewActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            int currentPosition = KanbanPreviewActivity.this.videoView.getCurrentPosition();
                            if (KanbanPreviewActivity.this.f3749o != 0) {
                                KanbanPreviewActivity.this.seekBar.setProgress((currentPosition * 100) / KanbanPreviewActivity.this.f3749o);
                            }
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    /* access modifiers changed from: protected */
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.f3750p = true;
        this.f3751q.unbind();
    }
}
