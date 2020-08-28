package com.peek.camera.p034b;

import android.graphics.Bitmap;
import android.util.LruCache;

/* renamed from: com.bmw.peek2.b.j */
public class C1132j {

    /* renamed from: a */
    private LruCache<String, Bitmap> f3095a = new LruCache<String, Bitmap>(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 4) {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
        }
    };

    /* renamed from: a */
    public synchronized Bitmap mo4653a(String str) {
        return str == null ? null : this.f3095a.get(str);
    }

    /* renamed from: a */
    public void mo4654a() {
        if (this.f3095a != null && this.f3095a.size() != 0) {
            this.f3095a.evictAll();
            this.f3095a = null;
        }
    }

    /* renamed from: a */
    public synchronized void mo4655a(Bitmap bitmap, String str) {
        if (!(str == null || bitmap == null)) {
            if (this.f3095a.get(str) == null) {
                this.f3095a.put(str, bitmap);
            }
        }
    }
}
