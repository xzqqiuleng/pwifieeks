package com.peek.camera.p034b;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

import com.peek.camera.BaseApplication;
import com.peek.camera.C1057a;

import java.util.Locale;

/* renamed from: com.bmw.peek2.b.k */
public class C1134k {
    /* renamed from: a */
    public static ContextWrapper m5253a(Context context, Locale locale) {
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(locale);
            LocaleList localeList = new LocaleList(new Locale[]{locale});
            LocaleList.setDefault(localeList);
            configuration.setLocales(localeList);
            context = context.createConfigurationContext(configuration);
        } else if (Build.VERSION.SDK_INT >= 19) {
            configuration.setLocale(locale);
            context = context.createConfigurationContext(configuration);
        }
        return new ContextWrapper(context);
    }

    /* renamed from: a */
    public static void m5254a(int i) {
        BaseApplication.m4928b().edit().putInt(C1057a.f2931h, i).commit();
    }

    /* renamed from: a */
    public static void m5255a(Context context, int i) {
        Locale locale;
        switch (i) {
            case 0:
                locale = Locale.CHINESE;
                break;
            case 1:
                locale = Locale.ENGLISH;
                break;
            default:
                if (Build.VERSION.SDK_INT < 24) {
                    locale = Locale.getDefault();
                    break;
                } else {
                    locale = LocaleList.getDefault().get(0);
                    break;
                }
        }
        m5253a(context, locale);
    }

    /* renamed from: a */
    public static boolean m5256a() {
        int i = BaseApplication.m4928b().getInt(C1057a.f2931h, -1);
        if (i == -1) {
            return m5257a((Context) BaseApplication.m4925a());
        }
        switch (i) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return m5257a((Context) BaseApplication.m4925a());
        }
    }

    /* renamed from: a */
    private static boolean m5257a(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }
}
