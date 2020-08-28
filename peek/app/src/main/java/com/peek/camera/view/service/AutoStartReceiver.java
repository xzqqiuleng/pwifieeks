package com.peek.camera.view.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.peek.camera.jna.SystemTransformByJNA;
import com.peek.camera.jna.SystemTransformJNAInstance;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.view.p040ui.PreviewActivity;

public class AutoStartReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Intent intent2 = new Intent(context, PreviewActivity.class);
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        }
        if (intent.getAction().equals("android.intent.action.ACTION_SHUTDOWN")) {
            SystemTransformJNAInstance.getInstance().SYSTRANS_Stop(SystemTransformByJNA.handle.getValue());
            SystemTransformJNAInstance.getInstance().SYSTRANS_Release(SystemTransformByJNA.handle.getValue());
            C1140n.m5266a("正在关机！");
        }
    }
}
