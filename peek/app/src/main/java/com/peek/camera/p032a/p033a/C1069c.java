package com.peek.camera.p032a.p033a;

import android.content.Context;

import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.model.FileInfo;
import com.peek.camera.model.Login_info;
import com.peek.camera.p032a.C1103h;
import com.peek.camera.p034b.C1128f;
import com.peek.camera.p034b.C1129g;
import com.peek.camera.p034b.C1130h;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1158y;
import com.peek.camera.view.fragments.C1329a;
import com.peek.camera.view.fragments.DialogNormalFragment;
import com.peek.camera.view.p037a.C1173d;
import com.peek.camera.view.p039c.C1236a;
import com.peek.camera.view.p040ui.FileShowNewActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bmw.peek2.a.a.c */
public class C1069c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1173d f2960a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f2961b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1236a f2962c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f2963d;

    /* renamed from: e */
    private Context f2964e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1103h f2965f;

    public C1069c(C1173d dVar, boolean z, C1236a aVar, Context context, C1103h hVar) {
        this.f2961b = z;
        this.f2960a = dVar;
        this.f2962c = aVar;
        this.f2964e = context;
        this.f2965f = hVar;
    }

    /* renamed from: i */
    private List<File> m5011i() {
        List<File> arrayList;
        List<File> arrayList2;
        if (this.f2961b) {
            List<File> a = C1158y.m5339a(C1129g.m5220a() + Login_info.local_picture_path);
            ArrayList arrayList3 = new ArrayList();
            if (a != null) {
                for (int i = 0; i < a.size(); i++) {
                    String name = a.get(i).getName();
                    if (name.substring(name.lastIndexOf("."), name.length()).equals(FileInfo.EXTEND_JPG)) {
                        arrayList3.add(a.get(i));
                    } else {
                        boolean z = true;
                        for (File name2 : a) {
                            String name3 = a.get(i).getName();
                            String substring = name3.substring(name3.lastIndexOf("/") + 1, name3.lastIndexOf("."));
                            String name4 = name2.getName();
                            z = (!name4.substring(name4.lastIndexOf("/") + 1, name4.lastIndexOf(".")).equals(substring) || !name4.substring(name4.lastIndexOf("."), name4.length()).equals(FileInfo.EXTEND_JPG)) ? z : false;
                        }
                        if (z) {
                            a.get(i).delete();
                            C1129g.m5227a(a.get(i).getAbsolutePath());
                            a.remove(i);
                        }
                    }
                }
                arrayList2 = arrayList3;
            } else {
                arrayList2 = a;
            }
            arrayList = arrayList2;
        } else {
            List<File> a2 = C1158y.m5339a(C1129g.m5220a() + Login_info.local_video_path);
            ArrayList arrayList4 = new ArrayList();
            if (a2 != null) {
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    String name5 = a2.get(i2).getName();
                    String substring2 = name5.substring(name5.lastIndexOf("."), name5.length());
                    if (substring2.equals(".avi") || substring2.equals(".AVI") || substring2.equals(".mp4") || substring2.equals("MP4")) {
                        arrayList4.add(a2.get(i2));
                    } else {
                        boolean z2 = true;
                        for (File name6 : a2) {
                            String name7 = a2.get(i2).getName();
                            String substring3 = name7.substring(name7.lastIndexOf("/") + 1, name7.lastIndexOf("."));
                            String name8 = name6.getName();
                            z2 = (!name8.substring(name8.lastIndexOf("/") + 1, name8.lastIndexOf(".")).equals(substring3) || name8.substring(name8.lastIndexOf("."), name8.length()).equals(".xml")) ? z2 : false;
                        }
                        if (z2) {
                            a2.get(i2).delete();
                            C1129g.m5227a(a2.get(i2).getAbsolutePath());
                            a2.remove(i2);
                        }
                    }
                }
                arrayList = arrayList4;
            } else {
                arrayList = a2;
            }
        }
        if (arrayList != null) {
            Collections.sort(arrayList, new C1128f());
        }
        if (this.f2961b) {
            if (arrayList != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= arrayList.size()) {
                        break;
                    }
                    String name9 = arrayList.get(i3).getName();
                    int indexOf = name9.indexOf("-");
                    BaseApplication.m4928b().getInt("KEY_PICTURE_FILE_COUNT", 1);
                    if (indexOf >= 1 && indexOf <= 5) {
                        try {
                            BaseApplication.m4928b().edit().putInt("KEY_PICTURE_FILE_COUNT", Integer.valueOf(name9.substring(0, indexOf)).intValue() + 1).commit();
                            break;
                        } catch (Exception e) {
                        }
                    }
                    i3++;
                }
            }
        } else if (arrayList != null) {
            int i4 = 0;
            while (true) {
                if (i4 >= arrayList.size()) {
                    break;
                }
                String name10 = arrayList.get(i4).getName();
                int indexOf2 = name10.indexOf("-");
                BaseApplication.m4928b().getInt("KEY_VIDEO_FILE_COUNT", 1);
                if (indexOf2 >= 1 && indexOf2 <= 5) {
                    try {
                        BaseApplication.m4928b().edit().putInt("KEY_VIDEO_FILE_COUNT", Integer.valueOf(name10.substring(0, indexOf2)).intValue() + 1).commit();
                        break;
                    } catch (Exception e2) {
                    }
                }
                i4++;
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    private void m5012j() {
        if (this.f2960a.mo5007d().size() != 0) {
            DialogNormalFragment a = DialogNormalFragment.m5724a(this.f2964e.getResources().getString(R.string.isDeleteAllFile), this.f2964e.getResources().getString(R.string.isdeleteChooseFile), this.f2964e.getResources().getString(R.string.yes), this.f2964e.getResources().getString(R.string.no), true);
            a.mo5175a((C1329a) new C1329a() {
                /* renamed from: a */
                public void mo4542a() {
                    C1069c.this.f2960a.mo5010g();
                    String unused = C1069c.this.f2963d = null;
                    C1069c.this.mo4531c();
                    C1069c.this.mo4529b();
                    C1069c.this.f2962c.mo5113q();
                }

                /* renamed from: b */
                public void mo4543b() {
                }
            });
            C1130h.m5241a(((FileShowNewActivity) this.f2964e).getSupportFragmentManager(), a, "DialogNormalFragment");
        }
    }

    /* renamed from: a */
    public void mo4526a(final String str) {
        final List<File> j = this.f2960a.mo5013j();
        final List<Integer> d = this.f2960a.mo5007d();
        if (d != null && j != null) {
            if (d.size() == 0) {
                BaseApplication.m4926a(this.f2964e.getString(R.string.choose_file));
            } else {
                new Thread(new Runnable() {
                    public void run() {
                        C1069c.this.f2962c.mo5104d(d.size());
                        for (int i = 0; i < d.size(); i++) {
                            C1069c.this.f2962c.mo5107e(i);
                            File file = new File(str, ((File) j.get(((Integer) d.get(i)).intValue())).getName());
                            if (!file.exists()) {
                                try {
                                    file.createNewFile();
                                } catch (IOException e) {
                                    C1140n.m5269b("create file error: " + e.toString());
                                    e.printStackTrace();
                                }
                            }
                            try {
                                FileInputStream fileInputStream = new FileInputStream((File) j.get(((Integer) d.get(i)).intValue()));
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                byte[] bArr = new byte[1024];
                                int i2 = 0;
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    i2 += read;
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileInputStream.close();
                                fileOutputStream.close();
                            } catch (FileNotFoundException e2) {
                                e2.printStackTrace();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        C1069c.this.f2962c.mo5114r();
                    }
                }).start();
            }
        }
    }

    /* renamed from: a */
    public void mo4527a(boolean z) {
        this.f2960a.mo5004a(z);
    }

    /* renamed from: a */
    public boolean mo4528a() {
        return this.f2963d != null;
    }

    /* renamed from: b */
    public void mo4529b() {
        this.f2960a.mo5003a(m5011i());
        this.f2960a.mo5001a((C1173d.C1179a) new C1173d.C1179a() {
            /* renamed from: a */
            public void mo4538a() {
                if (C1069c.this.f2962c != null) {
                    C1069c.this.f2962c.mo5106d(false);
                }
            }

            /* renamed from: a */
            public void mo4539a(int i) {
                C1069c.this.f2962c.mo5102b(true);
                if (C1069c.this.f2965f != null) {
                    C1069c.this.f2965f.mo4578c();
                }
                C1069c.this.f2960a.mo5004a(true);
                C1069c.this.f2960a.mo5006c(i);
                if (C1069c.this.f2962c != null) {
                    C1069c.this.f2962c.mo5103c(true);
                }
            }

            /* renamed from: a */
            public void mo4540a(String str) {
                if (str == null) {
                    if (!(C1069c.this.f2962c == null || C1069c.this.f2963d == null || !C1069c.this.f2961b)) {
                        C1069c.this.f2962c.mo5113q();
                    }
                    String unused = C1069c.this.f2963d = null;
                    if (!C1069c.this.f2961b) {
                        C1069c.this.mo4531c();
                    }
                } else if (str.equals(C1069c.this.f2963d)) {
                    C1069c.this.f2962c.mo5102b(true);
                } else {
                    String unused2 = C1069c.this.f2963d = str;
                    C1069c.this.f2962c.mo5102b(true);
                    if (C1069c.this.f2961b) {
                        C1069c.this.f2962c.mo5105d(str);
                        return;
                    }
                    C1069c.this.mo4531c();
                    C1069c.this.f2965f.mo4577b();
                }
            }

            /* renamed from: b */
            public void mo4541b() {
                if (C1069c.this.f2962c != null) {
                    C1069c.this.f2962c.mo5106d(true);
                }
            }
        });
    }

    /* renamed from: b */
    public void mo4530b(String str) {
        List<File> i = m5011i();
        if (str.equals("")) {
            this.f2960a.mo5003a(i);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (i != null) {
            for (File next : i) {
                if (next.getName().contains(str)) {
                    arrayList.add(next);
                }
            }
        }
        this.f2960a.mo5003a((List<File>) arrayList);
    }

    /* renamed from: c */
    public void mo4531c() {
        if (this.f2965f != null) {
            this.f2965f.mo4576a(this.f2963d);
            this.f2965f.mo4578c();
            this.f2965f.mo4583h();
        }
    }

    /* renamed from: d */
    public void mo4532d() {
        m5012j();
    }

    /* renamed from: e */
    public int mo4533e() {
        if (this.f2963d != null) {
            return this.f2960a.mo5011h();
        }
        return -1;
    }

    /* renamed from: f */
    public int mo4534f() {
        if (this.f2963d != null) {
            return this.f2960a.mo5012i();
        }
        return -1;
    }

    /* renamed from: g */
    public void mo4535g() {
        this.f2960a.mo5008e();
    }

    /* renamed from: h */
    public void mo4536h() {
        this.f2960a.mo5009f();
    }
}
