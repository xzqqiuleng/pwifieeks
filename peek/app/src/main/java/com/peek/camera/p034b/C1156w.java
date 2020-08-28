package com.peek.camera.p034b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

import com.peek.camera.R;

import java.util.List;

/* renamed from: com.bmw.peek2.b.w */
public class C1156w {
    /* renamed from: a */
    private static String m5331a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(8);
        if (installedPackages == null) {
            return null;
        }
        for (PackageInfo packageInfo : installedPackages) {
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (str.equals(providerInfo.readPermission) || str.equals(providerInfo.writePermission)) {
                        return providerInfo.authority;
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m5332a(Context context) {
        Exception e;
        boolean z;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://" + m5331a(context, "com.android.launcher.permission.READ_SETTINGS") + "/favorites?notify=true"), new String[]{"title"}, "title=?", new String[]{context.getString(R.string.app_name)}, (String) null);
            z = query != null && query.getCount() > 0;
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e2) {
                    e = e2;
                    C1140n.m5269b("check is add shortCut error:" + e.toString());
                    return z;
                }
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            C1140n.m5269b("check is add shortCut error:" + e.toString());
            return z;
        }
        return z;
    }
}
