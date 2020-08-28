package com.peek.camera.p032a.p033a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.peek.camera.BaseApplication;
import com.peek.camera.C1057a;
import com.peek.camera.R;
import com.peek.camera.p032a.C1058a;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.service.MyServiceGetGPS;
import com.peek.camera.view.p040ui.PreviewActivity;

import java.util.Iterator;

/* renamed from: com.bmw.peek2.a.a.a */
public class C1059a implements C1058a {

    /* renamed from: a */
    GpsStatus.Listener f2934a = new GpsStatus.Listener() {
        @SuppressLint("MissingPermission")
        public void onGpsStatusChanged(int i) {
            switch (i) {
                case 4:
                    @SuppressLint("MissingPermission") GpsStatus gpsStatus = C1059a.this.f2937d.getGpsStatus((GpsStatus) null);
                    int maxSatellites = gpsStatus.getMaxSatellites();
                    Iterator<GpsSatellite> it = gpsStatus.getSatellites().iterator();
                    int unused = C1059a.this.f2939f = 0;
                    while (it.hasNext() && C1059a.this.f2939f <= maxSatellites) {
                        GpsSatellite next = it.next();
                        C1059a.m4950c(C1059a.this);
                    }
                    C1059a.this.m4944a(C1059a.this.f2937d.getLastKnownLocation(C1059a.this.f2937d.getBestProvider(C1059a.this.m4954g(), true)));
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: b */
    private Intent f2935b;

    /* renamed from: c */
    private Context f2936c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LocationManager f2937d;

    /* renamed from: e */
    private LocationListener f2938e = new LocationListener() {
        public void onLocationChanged(Location location) {
            C1059a.this.m4944a(location);
            C1059a.this.m4947a("时间：" + location.getTime());
            C1059a.this.m4947a("经度：" + location.getLongitude());
            C1059a.this.m4947a("纬度：" + location.getLatitude());
            C1059a.this.m4947a("海拔：" + location.getAltitude());
        }

        public void onProviderDisabled(String str) {
            C1059a.this.m4944a((Location) null);
        }

        @SuppressLint("MissingPermission")
        public void onProviderEnabled(String str) {
            C1059a.this.m4944a(C1059a.this.f2937d.getLastKnownLocation(str));
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            switch (i) {
                case 0:
                    C1059a.this.m4947a("当前GPS状态为服务区外状态");
                    return;
                case 1:
                    C1059a.this.m4947a("当前GPS状态为暂停服务状态");
                    return;
                case 2:
                    C1059a.this.m4947a("当前GPS状态为可见状态");
                    return;
                default:
                    return;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f2939f;

    public C1059a(Context context) {
        this.f2936c = context;
        m4952e();
        m4947a("经纬度： 初始化完成");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4944a(Location location) {
        if (location != null) {
            C1140n.m5266a("GPS 定位成功");
            m4949b(location);
            return;
        }
        Location d = mo4491d();
        if (d != null) {
            m4949b(d);
        } else {
            MyServiceGetGPS.m5363a(this.f2936c);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4947a(String str) {
        C1140n.m5266a(str);
    }

    /* renamed from: b */
    private void m4949b(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        if (longitude > 0.0d && latitude > 0.0d) {
            this.f2935b.putExtra(C1057a.f2927d, latitude);
            this.f2935b.putExtra(C1057a.f2928e, longitude);
            BaseApplication.m4925a().sendBroadcast(this.f2935b);
            this.f2935b.removeExtra(C1057a.f2927d);
            this.f2935b.removeExtra(C1057a.f2928e);
        }
    }

    /* renamed from: c */
    static /* synthetic */ int m4950c(C1059a aVar) {
        int i = aVar.f2939f;
        aVar.f2939f = i + 1;
        return i;
    }

    /* renamed from: e */
    private void m4952e() {
        this.f2935b = new Intent();
        this.f2935b.setAction(C1057a.f2926c);
    }

    /* renamed from: f */
    @SuppressLint({"MissingPermission", "WrongConstant"})
    private void m4953f() {
        m4947a("GPS定位！");
        if (this.f2937d == null) {
            this.f2937d = (LocationManager) this.f2936c.getSystemService("location");
        }
        if (!this.f2937d.isProviderEnabled("gps")) {
            Toast.makeText(this.f2936c, this.f2936c.getString(R.string.pleaseOpenGps), 0).show();
            ((PreviewActivity) this.f2936c).startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 0);
            this.f2935b.putExtra("isNotGetLocate", true);
            this.f2936c.sendBroadcast(this.f2935b);
            return;
        }
        String bestProvider = this.f2937d.getBestProvider(m4954g(), true);
        m4944a(this.f2937d.getLastKnownLocation(bestProvider));
        this.f2937d.addGpsStatusListener(this.f2934a);
        this.f2937d.requestLocationUpdates(bestProvider, 30000, 1.0f, this.f2938e);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public Criteria m4954g() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setSpeedRequired(false);
        criteria.setCostAllowed(false);
        criteria.setBearingRequired(false);
        criteria.setAltitudeRequired(false);
        criteria.setPowerRequirement(1);
        return criteria;
    }

    /* renamed from: a */
    public void mo4488a() {
        m4947a("经纬度：  a开始定位");
        m4953f();
    }

    /* renamed from: b */
    public void mo4489b() {
        m4947a("经纬度：  a停止定位");
        if (this.f2937d != null) {
            this.f2937d.removeUpdates(this.f2938e);
            this.f2937d.removeGpsStatusListener(this.f2934a);
        }
    }

    /* renamed from: c */
    public void mo4490c() {
        m4947a("经纬度：  a销毁");
        mo4489b();
        this.f2935b = null;
    }

    /* renamed from: d */
    @SuppressLint("MissingPermission")
    public Location mo4491d() {
        if (this.f2937d.isProviderEnabled("network")) {
            return this.f2937d.getLastKnownLocation("network");
        }
        return null;
    }
}
