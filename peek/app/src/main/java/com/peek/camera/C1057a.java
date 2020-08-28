package com.peek.camera;

/* renamed from: com.bmw.peek2.a */
public class C1057a {

    /* renamed from: a */
    public static final String f2924a = (C1057a.class.getSimpleName() + "KEY_TIAN_MAP_PLACENAME");

    /* renamed from: b */
    public static final String f2925b = (C1057a.class.getSimpleName() + "KEY_GEOINVERSECODE_SWITCH");

    /* renamed from: c */
    public static final String f2926c = (C1057a.class.getSimpleName() + "ACTION_JING_WEI_DU");

    /* renamed from: d */
    public static final String f2927d = (C1057a.class.getSimpleName() + "KEY_LATITUDE_JINGWEIDU");

    /* renamed from: e */
    public static final String f2928e = (C1057a.class.getSimpleName() + "KEY_LONTITUDE_JINGWEIDU");

    /* renamed from: f */
    public static final String f2929f = (C1057a.class.getSimpleName() + "KEY_IS_OPEN_KUANDONGTAI");

    /* renamed from: g */
    public static final String f2930g = (C1057a.class.getSimpleName() + "KEY_IS_OPEN_DIGTITALMAX");

    /* renamed from: h */
    public static final String f2931h = (C1057a.class.getSimpleName() + "KEY_LANGUGE_CHOOSE");

    /* renamed from: i */
    public static final String f2932i = (C1057a.class.getSimpleName() + "KEY_SUBSTREAM_SWITCH");

    /* renamed from: j */
    public static final String f2933j = (C1057a.class.getSimpleName() + "KEY_OPEN_WIDESCREEN");

    /* renamed from: a */
    public static void m4935a(boolean z) {
        BaseApplication.m4928b().edit().putBoolean(f2932i, z).commit();
    }

    /* renamed from: a */
    public static boolean m4936a() {
        return BaseApplication.m4928b().getBoolean(f2932i, false);
    }

    /* renamed from: b */
    public static void m4937b(boolean z) {
        BaseApplication.m4928b().edit().putBoolean(f2933j, z).commit();
    }

    /* renamed from: b */
    public static boolean m4938b() {
        return BaseApplication.m4928b().getBoolean(f2933j, true);
    }
}
