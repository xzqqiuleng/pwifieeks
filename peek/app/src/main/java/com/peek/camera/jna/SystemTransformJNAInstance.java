package com.peek.camera.jna;

import com.sun.jna.Native;

public enum SystemTransformJNAInstance {
    CLASS;
    
    private static SystemTransformByJNA transform;

    static {
        transform = null;
    }

    public static SystemTransformByJNA getInstance() {
        if (transform == null) {
            synchronized (HCNetSDKByJNA.class) {
                transform = (SystemTransformByJNA) Native.loadLibrary("SystemTransform", SystemTransformByJNA.class);
            }
        }
        return transform;
    }
}
