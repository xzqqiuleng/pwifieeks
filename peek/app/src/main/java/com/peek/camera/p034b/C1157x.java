package com.peek.camera.p034b;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* renamed from: com.bmw.peek2.b.x */
public class C1157x {
    /* renamed from: a */
    public static String m5333a() {
        return new SimpleDateFormat("ss").format(new Date());
    }

    /* renamed from: a */
    public static String m5334a(Long l, boolean z) {
        Integer num = 1000;
        Integer valueOf = Integer.valueOf(num.intValue() * 60);
        Integer valueOf2 = Integer.valueOf(valueOf.intValue() * 60);
        Integer valueOf3 = Integer.valueOf(valueOf2.intValue() * 24);
        Long valueOf4 = Long.valueOf(l.longValue() / ((long) valueOf3.intValue()));
        Long valueOf5 = Long.valueOf((l.longValue() - (valueOf4.longValue() * ((long) valueOf3.intValue()))) / ((long) valueOf2.intValue()));
        Long valueOf6 = Long.valueOf(((l.longValue() - (valueOf4.longValue() * ((long) valueOf3.intValue()))) - (valueOf5.longValue() * ((long) valueOf2.intValue()))) / ((long) valueOf.intValue()));
        Long valueOf7 = Long.valueOf((((l.longValue() - (valueOf4.longValue() * ((long) valueOf3.intValue()))) - (valueOf5.longValue() * ((long) valueOf2.intValue()))) - (valueOf6.longValue() * ((long) valueOf.intValue()))) / ((long) num.intValue()));
        Long.valueOf((((l.longValue() - (valueOf4.longValue() * ((long) valueOf3.intValue()))) - (((long) valueOf2.intValue()) * valueOf5.longValue())) - (valueOf6.longValue() * ((long) valueOf.intValue()))) - (((long) num.intValue()) * valueOf7.longValue()));
        StringBuffer stringBuffer = new StringBuffer();
        if (valueOf4.longValue() > 0) {
            stringBuffer.append(valueOf4).append(":");
        }
        if (valueOf5.longValue() >= 0 && (z || valueOf5.longValue() != 0)) {
            if (valueOf5.longValue() < 10) {
                stringBuffer.append("0").append(valueOf5).append(":");
            } else {
                stringBuffer.append(valueOf5).append(":");
            }
        }
        if (valueOf6.longValue() >= 0) {
            if (valueOf6.longValue() < 10) {
                stringBuffer.append("0").append(valueOf6).append(":");
            } else {
                stringBuffer.append(valueOf6).append(":");
            }
        }
        if (valueOf7.longValue() >= 0) {
            if (valueOf7.longValue() < 10) {
                stringBuffer.append("0").append(valueOf7);
            } else {
                stringBuffer.append(valueOf7);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static String m5335b() {
        return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SSS").format(new Date());
    }

    /* renamed from: c */
    public static String m5336c() {
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
    }

    /* renamed from: d */
    public static String m5337d() {
        Calendar instance = Calendar.getInstance();
        instance.add(5, -1);
        return new SimpleDateFormat("yyyy年MM月dd日").format(instance.getTime());
    }
}
