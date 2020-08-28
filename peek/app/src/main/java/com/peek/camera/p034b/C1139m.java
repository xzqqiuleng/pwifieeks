package com.peek.camera.p034b;

import java.io.File;

/* renamed from: com.bmw.peek2.b.m */
public class C1139m {
    /* renamed from: a */
    public static void m5263a() {
        File[] listFiles;
        String c = C1157x.m5336c();
        String d = C1157x.m5337d();
        File file = new File(C1129g.m5220a(), "/peek2s_data/");
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith("log.txt") && !file2.getName().contains(c) && !file2.getName().contains(d)) {
                    file2.delete();
                    C1129g.m5227a(file2.getAbsolutePath());
                }
            }
        }
    }

    /* renamed from: a */
    public static void m5264a(String str) {
        String c = C1157x.m5336c();
        String str2 = C1157x.m5335b() + ": " + str;
        File file = new File(C1129g.m5220a(), "/peek2s_data/");
        if (!file.exists()) {
            file.mkdirs();
        }
        C1154u.m5328a(str2, new File(file, c + "log.txt").getAbsolutePath());
    }
}
