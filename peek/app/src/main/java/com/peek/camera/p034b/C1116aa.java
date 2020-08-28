package com.peek.camera.p034b;

import android.content.Context;

import com.peek.camera.model.Login_info;
import com.peek.camera.service.MyIntentService;

import java.io.IOException;

/* renamed from: com.bmw.peek2.b.aa */
public class C1116aa {

    /* renamed from: a */
    private static String f3082a = "MyIntentService";

    /* renamed from: a */
    public static int m5195a(String str) {
        try {
            return Runtime.getRuntime().exec(new StringBuilder().append("ping -c 1 -w 3 ").append(str).toString()).waitFor() == 0 ? 0 : 1;
        } catch (IOException | InterruptedException e) {
            return -1;
        }
    }

    /* renamed from: a */
    public static void m5196a(Context context) {
        MyIntentService.m5357a(context);
        MyIntentService.m5358a(context, Login_info.getInstance().isWifiIsRepeater() ? Login_info.baseRepeaterWifiSSID : Login_info.baseMainFrameWifiSSID, "bmwpeek2shost", Login_info.getInstance().getSocket_ip());
    }

    /* renamed from: a */
    public static boolean m5197a(C1159z zVar, String str) {
        return (!zVar.mo4690g().contains(str) || zVar.mo4688e() == 0 || zVar.mo4691h() == -1 || zVar.mo4692i() == -127) ? false : true;
    }

    /* renamed from: a */
    public static boolean m5198a(C1159z zVar, String str, String str2) {
        if (!zVar.mo4690g().contains(str) || zVar.mo4688e() == 0) {
            return false;
        }
        if (str2 == null) {
            return true;
        }
        return m5195a(str2) == 0;
    }
}
