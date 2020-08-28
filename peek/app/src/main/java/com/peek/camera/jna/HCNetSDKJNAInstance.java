package com.peek.camera.jna;

import com.sun.jna.Native;

public enum HCNetSDKJNAInstance {
    CLASS;
    
    private static HCNetSDKByJNA netSdk;

    static {
        netSdk = null;
    }

    public static HCNetSDKByJNA getInstance() {
        if (netSdk == null) {
            synchronized (HCNetSDKByJNA.class) {
                netSdk = (HCNetSDKByJNA) Native.loadLibrary("hcnetsdk", HCNetSDKByJNA.class);
            }
        }
        return netSdk;
    }
}
