package com.peek.camera.p034b;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: com.bmw.peek2.b.y */
public class C1158y {
    /* renamed from: a */
    public static String m5338a() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    /* renamed from: a */
    public static List<File> m5339a(String str) {
        ArrayList arrayList = null;
        File file = new File(str);
        if (file.exists() && !file.isFile()) {
            File[] listFiles = file.listFiles();
            if (listFiles.length > 0) {
                arrayList = new ArrayList();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static String m5340b() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
