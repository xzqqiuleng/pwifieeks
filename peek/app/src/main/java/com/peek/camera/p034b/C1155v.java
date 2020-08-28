package com.peek.camera.p034b;

/* renamed from: com.bmw.peek2.b.v */
public class C1155v {
    /* renamed from: a */
    public static int m5329a(String str, char c) {
        char[] charArray = str.toCharArray();
        int i = 0;
        for (char c2 : charArray) {
            if (c2 == c) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m5330a(String str) {
        return str == null || str.equals("") || str.length() <= 0;
    }
}
