package com.peek.camera.p034b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* renamed from: com.bmw.peek2.b.u */
public class C1154u {
    /* renamed from: a */
    public static void m5328a(String str, String str2) {
        File file = new File(str2);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                C1140n.m5269b("create file is failed!!!");
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(str2, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(str);
            bufferedWriter.flush();
            fileWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
