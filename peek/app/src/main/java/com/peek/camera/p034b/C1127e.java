package com.peek.camera.p034b;

import android.content.Context;

import com.lidroid.xutils.DbUtils;


/* renamed from: com.bmw.peek2.b.e */
public class C1127e {

    /* renamed from: a */
    private static DbUtils f3092a;

    /* renamed from: a */
    public static DbUtils m5217a() {
        return f3092a;
    }

    /* renamed from: a */
    public static void m5218a(Context context) {
        DbUtils.DaoConfig daoConfig = new DbUtils.DaoConfig(context);
        daoConfig.setDbName("BMW_Peek_Task_Data");
        daoConfig.setDbVersion(1);
        f3092a = DbUtils.create(daoConfig);
    }
}
