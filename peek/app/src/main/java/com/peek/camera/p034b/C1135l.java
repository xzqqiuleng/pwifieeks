package com.peek.camera.p034b;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: com.bmw.peek2.b.l */
public class C1135l {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static C1137a f3097a;

    /* renamed from: b */
    private static LocationListener f3098b = new C1138b();

    /* renamed from: com.bmw.peek2.b.l$a */
    public interface C1137a {
        /* renamed from: a */
        void mo4658a(Location location);
    }

    /* renamed from: com.bmw.peek2.b.l$b */
    private static class C1138b implements LocationListener {
        private C1138b() {
        }

        public void onLocationChanged(Location location) {
            if (C1135l.f3097a != null) {
                C1135l.f3097a.mo4658a(location);
            }
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* renamed from: a */
    public static Location m5258a(Context context) {
        LocationManager b = m5261b(context);
        if (b.isProviderEnabled("network")) {
            return b.getLastKnownLocation("network");
        }
        return null;
    }

    /* renamed from: a */
    public static Location m5259a(Context context, Criteria criteria) {
        LocationManager b = m5261b(context);
        if (criteria == null) {
            criteria = new Criteria();
        }
        String bestProvider = b.getBestProvider(criteria, true);
        return TextUtils.isEmpty(bestProvider) ? m5258a(context) : b.getLastKnownLocation(bestProvider);
    }

    /* renamed from: b */
    private static LocationManager m5261b(Context context) {
        return (LocationManager) context.getSystemService("location");
    }
}
