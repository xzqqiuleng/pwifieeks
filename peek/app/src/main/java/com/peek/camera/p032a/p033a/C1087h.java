package com.peek.camera.p032a.p033a;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.VideoView;

import com.peek.camera.BaseApplication;
import com.peek.camera.model.CapturePicture;
import com.peek.camera.model.FileInfo;
import com.peek.camera.model.Login_info;
import com.peek.camera.model.PipeDefectImage;
import com.peek.camera.model.VideoInfo;
import com.peek.camera.p032a.C1103h;
import com.peek.camera.p034b.C1125c;
import com.peek.camera.p034b.C1129g;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1148s;
import com.peek.camera.p034b.C1155v;
import com.peek.camera.p034b.C1157x;
import com.peek.camera.view.p037a.C1193i;
import com.peek.camera.view.p039c.C1236a;
import com.peek.camera.view.view.CustomPotSeekBar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.MediaPlayer.PlayM4.Player;

/* renamed from: com.bmw.peek2.a.a.h */
public class C1087h implements C1103h {

    /* renamed from: a */
    private final int f3020a = Player.getInstance().getPort();

    /* renamed from: b */
    private boolean f3021b;

    /* renamed from: c */
    private boolean f3022c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1236a f3023d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f3024e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SeekBar f3025f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public VideoView f3026g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f3027h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CustomPotSeekBar f3028i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public RecyclerView f3029j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public VideoInfo f3030k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ArrayList<String> f3031l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ArrayList<Integer> f3032m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public ArrayList<PipeDefectImage> f3033n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C1193i f3034o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public RelativeLayout f3035p;

    public C1087h(final C1236a aVar, String str, VideoView videoView, SeekBar seekBar, CustomPotSeekBar customPotSeekBar, RecyclerView recyclerView, RelativeLayout relativeLayout) {
        this.f3023d = aVar;
        this.f3024e = str;
        this.f3026g = videoView;
        this.f3025f = seekBar;
        this.f3029j = recyclerView;
        this.f3035p = relativeLayout;
        this.f3034o = (C1193i) this.f3029j.getAdapter();
        m5098i();
        this.f3028i = customPotSeekBar;
        this.f3031l = new ArrayList<>();
        this.f3032m = new ArrayList<>();
        this.f3033n = new ArrayList<>();
        m5100j();
        this.f3026g.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                long duration = (long) mediaPlayer.getDuration();
                long unused = C1087h.this.f3027h = duration;
                C1087h.this.f3023d.mo5108e(C1157x.m5334a(Long.valueOf(duration), false));
                aVar.mo5110f((int) C1087h.this.f3027h);
                if (C1087h.this.f3028i != null) {
                    C1087h.this.f3028i.post(new Runnable() {
                        public void run() {
                            C1087h.this.f3028i.mo5360a((ArrayList<String>) C1087h.this.f3031l, (ArrayList<Integer>) C1087h.this.f3032m);
                            if (C1087h.this.f3033n != null && C1087h.this.f3033n.size() > 0) {
                                C1087h.this.f3034o.mo5041a((ArrayList<PipeDefectImage>) C1087h.this.f3033n);
                            }
                        }
                    });
                }
            }
        });
        this.f3026g.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                C1087h.this.f3035p.setVisibility(View.GONE);
                C1087h.this.mo4578c();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5087a(final int i) {
        if (i >= 0 && i < this.f3034o.mo5044d().size() && this.f3029j != null) {
            this.f3029j.post(new Runnable() {
                public void run() {
                    C1087h.this.f3034o.mo5043c(i);
                    C1087h.this.f3029j.scrollToPosition(i);
                }
            });
        }
    }

    /* renamed from: b */
    private void m5090b(String str) {
        this.f3032m.clear();
        this.f3031l.clear();
        this.f3033n.clear();
        if (str != null) {
            String b = C1129g.m5231b(str, ".xml");
            C1140n.m5266a("xml适当放松的立法 path = " + b);
            File file = new File(b);
            if (file.exists()) {
                final String absolutePath = file.getAbsolutePath();
                this.f3028i.setVisibility(View.VISIBLE);
                this.f3035p.setVisibility(View.VISIBLE);
                BaseApplication.f2900c.execute(new Runnable() {
                    public void run() {
                        VideoInfo unused = C1087h.this.f3030k = C1148s.m5291a(absolutePath);
                        ArrayList<CapturePicture> capturePictures = C1087h.this.f3030k.getCapturePictures();
                        if (capturePictures == null || capturePictures.size() <= 0) {
                            C1087h.this.f3029j.post(new Runnable() {
                                public void run() {
                                    C1087h.this.f3034o.mo5041a((ArrayList<PipeDefectImage>) new ArrayList());
                                    C1087h.this.f3028i.setVisibility(View.GONE);
                                    C1087h.this.f3035p.setVisibility(View.GONE);
                                }
                            });
                            return;
                        }
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < capturePictures.size()) {
                                CapturePicture capturePicture = capturePictures.get(i2);
                                if (!C1155v.m5330a(capturePicture.getDefectFilename())) {
                                    C1087h.this.f3031l.add(capturePicture.getPipedefectCode());
                                    int intValue = Integer.valueOf(capturePicture.getTimestamp()).intValue();
                                    if (intValue >= 2) {
                                        intValue--;
                                    }
                                    C1087h.this.f3032m.add(Integer.valueOf(intValue * 1000));
                                    C1087h.this.f3033n.add(C1148s.m5295b(capturePicture.getDefectFilename()));
                                }
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                });
                return;
            }
            this.f3034o.mo5041a((ArrayList<PipeDefectImage>) new ArrayList());
            this.f3028i.setVisibility(View.GONE);
            this.f3035p.setVisibility(View.GONE);
        }
    }

    /* renamed from: i */
    private void m5098i() {
        this.f3034o.mo5039a((C1193i.C1195a) new C1193i.C1195a() {
            /* renamed from: a */
            public void mo4587a(int i) {
                if (i >= 0 && i < C1087h.this.f3032m.size() && C1087h.this.f3032m.get(i) != null) {
                    C1087h.this.f3023d.mo5112h(((Integer) C1087h.this.f3032m.get(i)).intValue());
                    C1087h.this.f3025f.setProgress(((Integer) C1087h.this.f3032m.get(i)).intValue());
                }
                if (i >= 0 && i < C1087h.this.f3033n.size() && C1087h.this.f3033n.get(i) != null) {
                    C1087h.this.f3023d.mo5100a((PipeDefectImage) C1087h.this.f3033n.get(i));
                }
            }
        });
    }

    /* renamed from: j */
    private void m5100j() {
        this.f3028i.setResponseOnTouch(new CustomPotSeekBar.C1507a() {
            /* renamed from: a */
            public void mo4588a(int i) {
                if (i >= 0 && i < C1087h.this.f3032m.size() && C1087h.this.f3032m.get(i) != null) {
                    C1087h.this.f3023d.mo5112h(((Integer) C1087h.this.f3032m.get(i)).intValue());
                    C1087h.this.f3025f.setProgress(((Integer) C1087h.this.f3032m.get(i)).intValue());
                }
                if (i >= 0 && i < C1087h.this.f3033n.size() && C1087h.this.f3033n.get(i) != null) {
                    C1087h.this.f3023d.mo5100a((PipeDefectImage) C1087h.this.f3033n.get(i));
                }
                C1087h.this.m5087a(i);
            }

            /* renamed from: b */
            public void mo4589b(int i) {
                if (i >= 0 && i < C1087h.this.f3033n.size() && C1087h.this.f3033n.get(i) != null) {
                    C1087h.this.f3023d.mo5100a((PipeDefectImage) C1087h.this.f3033n.get(i));
                }
                C1087h.this.m5087a(i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public String m5102k() {
        int i = BaseApplication.m4928b().getInt("KEY_PICTURE_FILE_COUNT", 1);
        if (i != 10000) {
            return i < 10 ? "0" + i : String.valueOf(i);
        }
        BaseApplication.m4928b().edit().putInt("KEY_PICTURE_FILE_COUNT", 1).commit();
        return "00";
    }

    /* renamed from: a */
    public void mo4574a() {
        if (this.f3021b) {
            if (!this.f3022c) {
                this.f3026g.start();
                this.f3022c = true;
                this.f3023d.mo5109e(true);
                if (this.f3029j != null && this.f3034o.mo5044d().size() > 0) {
                    this.f3035p.setVisibility(View.VISIBLE);
                    return;
                }
                return;
            }
            this.f3026g.pause();
            this.f3022c = false;
            this.f3023d.mo5109e(false);
        } else if (this.f3024e != null) {
            this.f3023d.mo5111g(0);
            mo4577b();
        }
    }

    /* renamed from: a */
    public void mo4575a(float f) {
        this.f3026g.seekTo((int) f);
    }

    /* renamed from: a */
    public void mo4576a(String str) {
        this.f3024e = str;
        this.f3028i.setmIsNoShowOnThisSections(false);
        m5090b(this.f3024e);
    }

    /* renamed from: b */
    public void mo4577b() {
        if (this.f3024e != null) {
            if (this.f3021b) {
                this.f3026g.stopPlayback();
            }
            if (this.f3024e.contains(":")) {
                String replaceAll = this.f3024e.replaceAll(":", "：");
                new File(this.f3024e).renameTo(new File(replaceAll));
                C1129g.m5227a(this.f3024e);
                C1129g.m5227a(replaceAll);
                String b = C1129g.m5231b(this.f3024e, ".xml");
                String b2 = C1129g.m5231b(replaceAll, ".xml");
                File file = new File(b);
                if (file.exists()) {
                    file.renameTo(new File(b2));
                    C1129g.m5227a(b);
                    C1129g.m5227a(b2);
                }
                this.f3024e = replaceAll;
            }
            this.f3026g.setVideoPath(this.f3024e);
            this.f3026g.setAlpha(1.0f);
            if (this.f3029j != null && this.f3034o.mo5044d().size() > 0) {
                this.f3035p.setVisibility(View.VISIBLE);
            }
            this.f3026g.start();
            this.f3021b = true;
            this.f3023d.mo5109e(true);
            this.f3022c = true;
        }
    }

    /* renamed from: c */
    public void mo4578c() {
        this.f3026g.stopPlayback();
        this.f3023d.mo5115s();
        this.f3021b = false;
        this.f3022c = false;
    }

    /* renamed from: d */
    public String mo4579d() {
        return C1157x.m5334a(Long.valueOf((long) this.f3026g.getCurrentPosition()), false);
    }

    /* renamed from: e */
    public void mo4580e() {
        C1129g.m5235c();
        if (this.f3021b) {
            mo4574a();
            new Thread(new Runnable() {
                public void run() {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(BaseApplication.m4925a(), Uri.parse(C1087h.this.f3024e));
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime((long) (C1087h.this.f3026g.getCurrentPosition() * 1000), 2);
                    StringBuilder sb = new StringBuilder();
                    if (C1087h.this.f3024e == null || !C1087h.this.f3024e.contains(".")) {
                        C1140n.m5269b("截图路径错误！");
                        return;
                    }
                    String substring = C1087h.this.f3024e.substring(C1087h.this.f3024e.lastIndexOf("/") + 1, C1087h.this.f3024e.length());
                    if (BaseApplication.m4928b().getInt("KEY_FILE_NAME_MODEL_MINESET", 0) == 1) {
                        sb.append(C1087h.this.m5102k()).append("-");
                    }
                    sb.append("cut(");
                    sb.append(substring.substring(0, substring.lastIndexOf(".")));
                    String str = C1129g.m5220a() + Login_info.local_picture_path;
                    File file = new File(str + sb.toString() + ").jpg");
                    if (file.exists()) {
                        File file2 = file;
                        int i = 0;
                        while (file2.exists()) {
                            i++;
                            file2 = new File(str + sb.toString() + "-" + i + ").jpg");
                        }
                        sb.append("-").append(i);
                    }
                    sb.append(")");
                    String sb2 = sb.toString();
                    try {
                        C1125c.m5214a(str, sb2 + FileInfo.EXTEND_JPG, frameAtTime);
                        if (frameAtTime != null) {
                            frameAtTime.recycle();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (frameAtTime != null) {
                            frameAtTime.recycle();
                        }
                    } catch (Throwable th) {
                        if (frameAtTime != null) {
                            frameAtTime.recycle();
                        }
                        throw th;
                    }
                    if (BaseApplication.m4928b().getInt("KEY_FILE_NAME_MODEL_MINESET", 0) == 1) {
                        BaseApplication.m4928b().edit().putInt("KEY_PICTURE_FILE_COUNT", BaseApplication.m4928b().getInt("KEY_VIDEO_FILE_COUNT", 1) + 1).commit();
                    }
                    C1087h.this.f3023d.mo5101a(str, sb2);
                }
            }).start();
        }
    }

    /* renamed from: f */
    public boolean mo4581f() {
        return this.f3022c;
    }

    /* renamed from: g */
    public void mo4582g() {
        this.f3021b = false;
        this.f3022c = false;
        this.f3026g.destroyDrawingCache();
    }

    /* renamed from: h */
    public void mo4583h() {
        if (this.f3026g != null) {
            this.f3026g.setAlpha(0.0f);
        }
    }
}
