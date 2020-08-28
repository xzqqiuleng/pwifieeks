package com.peek.camera.p034b;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.bmw.peek2.b.f */
public class C1128f implements Comparator<File> {
    /* renamed from: a */
    public int compare(File file, File file2) {
        return file.lastModified() >= file2.lastModified() ? -1 : 1;
    }
}
