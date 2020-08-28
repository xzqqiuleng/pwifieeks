package com.peek.camera.p034b;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/* renamed from: com.bmw.peek2.b.ab */
public class C1117ab {

    /* renamed from: a */
    FileOutputStream f3083a = null;

    /* renamed from: b */
    BufferedOutputStream f3084b = null;

    /* renamed from: c */
    FileWriter f3085c = null;

    /* renamed from: d */
    BufferedWriter f3086d = null;

    public C1117ab() {
    }

    public C1117ab(String str, String str2) {
        C1140n.m5266a("setFilePath");
        m5199a(str2);
        m5200b(str);
    }

    /* renamed from: a */
    private void m5199a(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                this.f3085c = new FileWriter(file, true);
                this.f3086d = new BufferedWriter(this.f3085c);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m5200b(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                this.f3083a = new FileOutputStream(file, true);
                this.f3084b = new BufferedOutputStream(this.f3083a);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo4626a() {
        try {
            if (this.f3084b != null) {
                this.f3084b.close();
            }
            if (this.f3083a != null) {
                this.f3083a.close();
            }
            if (this.f3086d != null) {
                this.f3086d.close();
            }
            if (this.f3085c != null) {
                this.f3085c.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo4627a(int i) {
        String valueOf = String.valueOf(i);
        try {
            this.f3086d.write(valueOf, 0, valueOf.length());
            this.f3086d.newLine();
            this.f3086d.flush();
            this.f3085c.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /* renamed from: a */
    public void mo4628a(byte[] bArr, int i) {
        try {
            this.f3084b.write(bArr, 0, i);
            this.f3084b.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
