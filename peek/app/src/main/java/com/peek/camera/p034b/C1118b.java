package com.peek.camera.p034b;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.peek.camera.model.BZInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.bmw.peek2.b.b */
public class C1118b {

    /* renamed from: a */
    private DbUtils f3087a = C1127e.m5217a();

    /* renamed from: b */
    private List<BZInfo> f3088b;

    /* renamed from: com.bmw.peek2.b.b$a */
    private class C1120a implements Comparator<BZInfo> {
        private C1120a() {
        }

        /* renamed from: a */
        public int compare(BZInfo bZInfo, BZInfo bZInfo2) {
            return Long.valueOf(bZInfo2.getTime()).compareTo(Long.valueOf(bZInfo.getTime()));
        }
    }

    public C1118b() {
        try {
            this.f3088b = this.f3087a.findAll(BZInfo.class);
        } catch (DbException e) {
            e.printStackTrace();
            C1140n.m5269b("BZInfo find all Data false!!!");
        }
    }

    /* renamed from: a */
    private void m5204a(BZInfo bZInfo) {
        try {
            this.f3087a.delete(bZInfo);
        } catch (DbException e) {
            e.printStackTrace();
            C1140n.m5269b("BZInfo delete Data false!!!");
        }
    }

    /* renamed from: a */
    private boolean m5205a(String str, List<BZInfo> list) {
        for (BZInfo msg : list) {
            if (msg.getMsg().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private List<BZInfo> m5206b(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.f3088b != null) {
            for (BZInfo next : this.f3088b) {
                C1140n.m5266a("mlist size = " + this.f3088b.size() + "  bzinfo = " + next);
                if (next != null && next.getRow() == i) {
                    arrayList.add(next);
                }
            }
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, new C1120a());
            }
            if (arrayList.size() > 5) {
                for (int size = arrayList.size() - 1; size >= 5; size--) {
                    m5204a((BZInfo) arrayList.get(size));
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private void m5207b(BZInfo bZInfo) {
        C1140n.m5266a("add BZInfo " + bZInfo);
        try {
            this.f3087a.save(bZInfo);
        } catch (DbException e) {
            e.printStackTrace();
            C1140n.m5269b("BZInfo add Data false!!!");
        }
    }

    /* renamed from: a */
    public void mo4629a() {
        try {
            this.f3087a.deleteAll((Class<?>) BZInfo.class);
        } catch (DbException e) {
            e.printStackTrace();
            C1140n.m5269b("delete BZInfo All false!!!");
        }
        if (this.f3088b != null) {
            this.f3088b.clear();
        }
    }

    /* renamed from: a */
    public void mo4630a(BZInfo bZInfo, List<BZInfo> list) {
        if (list == null) {
            list = m5206b(bZInfo.getRow());
        }
        if (!m5205a(bZInfo.getMsg(), list)) {
            m5207b(bZInfo);
        }
    }

    /* renamed from: a */
    public void mo4631a(String str, int i) {
        if (this.f3088b != null) {
            for (int size = this.f3088b.size() - 1; size >= 0; size--) {
                BZInfo bZInfo = this.f3088b.get(size);
                if (bZInfo.getRow() == i && bZInfo.getMsg().equals(str)) {
                    m5204a(bZInfo);
                    this.f3088b.remove(bZInfo);
                }
            }
        }
    }

    /* renamed from: a */
    public String[] mo4632a(int i) {
        List<BZInfo> b = m5206b(i);
        String[] strArr = new String[b.size()];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= b.size()) {
                return strArr;
            }
            strArr[i3] = b.get(i3).getMsg();
            i2 = i3 + 1;
        }
    }
}
