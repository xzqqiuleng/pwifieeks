package com.peek.camera.p034b;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/* renamed from: com.bmw.peek2.b.h */
public class C1130h {
    /* renamed from: a */
    public static void m5241a(FragmentManager pVar, DialogFragment dialogFragment, String str) {
        FragmentTransaction a = pVar.beginTransaction();
        Fragment a2 = pVar.findFragmentByTag(str);
        if (a2 != null) {
            a.hide(a2);
        }
        dialogFragment.show(a, str);
    }
}
