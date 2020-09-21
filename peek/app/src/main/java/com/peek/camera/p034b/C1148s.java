package com.peek.camera.p034b;

import android.util.Log;
import android.util.Xml;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hikvision.netsdk.NET_DVR_TIME;
import com.peek.camera.model.CapturePicture;
import com.peek.camera.model.PipeDefectDetail;
import com.peek.camera.model.PipeDefectImage;
import com.peek.camera.model.QueXianInfo;
import com.peek.camera.model.QueXian_StyleInfo;
import com.peek.camera.model.RecordTaskInfo;
import com.peek.camera.model.VideoInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import static java.net.Proxy.Type.HTTP;

/* renamed from: com.bmw.peek2.b.s */
public class C1148s {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0226, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0227, code lost:
        r7 = r0;
        r0 = r1;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        r0 = r1;
        r1 = r5.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0213, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0214, code lost:
        r7 = r0;
        r0 = r1;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x021a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x021b, code lost:
        r7 = r0;
        r0 = r1;
        r1 = r7;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static VideoInfo m5291a(String r8) {
        /*
            r2 = 0
            org.xmlpull.v1.XmlPullParser r5 = android.util.Xml.newPullParser()
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0221, XmlPullParserException -> 0x0203, IOException -> 0x020b }
            r0.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0221, XmlPullParserException -> 0x0203, IOException -> 0x020b }
            java.lang.String r1 = "utf-8"
            r5.setInput(r0, r1)     // Catch:{ FileNotFoundException -> 0x0221, XmlPullParserException -> 0x0203, IOException -> 0x020b }
            int r0 = r5.getEventType()     // Catch:{ FileNotFoundException -> 0x0221, XmlPullParserException -> 0x0203, IOException -> 0x020b }
            r1 = r0
            r3 = r2
            r4 = r2
            r0 = r2
        L_0x0017:
            r6 = 1
            if (r1 == r6) goto L_0x003c
            switch(r1) {
                case 2: goto L_0x0026;
                case 3: goto L_0x01d7;
                default: goto L_0x001d;
            }
        L_0x001d:
            r1 = r0
        L_0x001e:
            int r0 = r5.next()     // Catch:{ FileNotFoundException -> 0x0226, XmlPullParserException -> 0x021a, IOException -> 0x0213 }
            r7 = r0
            r0 = r1
            r1 = r7
            goto L_0x0017
        L_0x0026:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "VideoInfo"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x003d
            com.bmw.peek2.model.VideoInfo r1 = new com.bmw.peek2.model.VideoInfo     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            goto L_0x001e
        L_0x0038:
            r1 = move-exception
        L_0x0039:
            r1.printStackTrace()
        L_0x003c:
            return r0
        L_0x003d:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "Headline"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x0050
            com.bmw.peek2.model.RecordTaskInfo r4 = new com.bmw.peek2.model.RecordTaskInfo     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x0050:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "TaskName"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x0065
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4.setTask_name(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x0065:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "InspectAddress"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x007a
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4.setTask_place(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x007a:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "TaskID"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x008f
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4.setTask_id(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x008f:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "InspectDate"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x00a5
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4.setTask_date(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x00a5:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "StartWellNum"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x00bb
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4.setTask_start(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x00bb:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "EndWellNum"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x00d1
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4.setTask_end(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x00d1:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "InspectDirection"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x00e7
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4.setTask_direction(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x00e7:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "PipeType"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x00fd
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4.setTask_sort(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x00fd:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "PipeStock"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x0113
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4.setTask_guancai(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x0113:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "PipeDiameter"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x0129
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4.setTask_diameter(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x0129:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "InspectUnit"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x013f
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4.setTask_computer(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x013f:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "Inspector"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x0155
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4.setTask_people(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x0155:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "VideoFilename"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x016b
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r0.setVideoFilename(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x016b:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "CapturePicture"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x017f
            com.bmw.peek2.model.CapturePicture r3 = new com.bmw.peek2.model.CapturePicture     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x017f:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "Filename"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x0195
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r3.setFilename(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x0195:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "DefectFilename"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x01ab
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r3.setDefectFilename(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x01ab:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "Timestamp"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x01c1
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r3.setTimestamp(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x01c1:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "PipedefectCount"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x001d
            java.lang.String r1 = r5.nextText()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r3.setPipedefectCode(r1)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r1 = r0
            goto L_0x001e
        L_0x01d7:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "Headline"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x01ec
            if (r0 == 0) goto L_0x001d
            r0.setRecordTaskInfo(r4)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r4 = r2
            r1 = r0
            goto L_0x001e
        L_0x01ec:
            java.lang.String r1 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            java.lang.String r6 = "CapturePicture"
            boolean r1 = r1.equals(r6)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            if (r1 == 0) goto L_0x001d
            if (r3 == 0) goto L_0x001d
            if (r0 == 0) goto L_0x001d
            r0.addCapturePic(r3)     // Catch:{ FileNotFoundException -> 0x0038, XmlPullParserException -> 0x021f, IOException -> 0x0218 }
            r3 = r2
            r1 = r0
            goto L_0x001e
        L_0x0203:
            r0 = move-exception
            r1 = r0
            r0 = r2
        L_0x0206:
            r1.printStackTrace()
            goto L_0x003c
        L_0x020b:
            r0 = move-exception
            r1 = r0
            r0 = r2
        L_0x020e:
            r1.printStackTrace()
            goto L_0x003c
        L_0x0213:
            r0 = move-exception
            r7 = r0
            r0 = r1
            r1 = r7
            goto L_0x020e
        L_0x0218:
            r1 = move-exception
            goto L_0x020e
        L_0x021a:
            r0 = move-exception
            r7 = r0
            r0 = r1
            r1 = r7
            goto L_0x0206
        L_0x021f:
            r1 = move-exception
            goto L_0x0206
        L_0x0221:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto L_0x0039
        L_0x0226:
            r0 = move-exception
            r7 = r0
            r0 = r1
            r1 = r7
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bmw.peek2.p034b.C1148s.m5291a(java.lang.String):com.bmw.peek2.model.VideoInfo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r2 = r8.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0089, code lost:
        r0 = e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054 A[SYNTHETIC, Splitter:B:21:0x0054] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */

      static String jsonStr= "[{\n" +
            "\t\t\"Index\": \"0\",\n" +
            "\t\t\"Name\": \"无缺陷\",\n" +
            "\t\t\"Code\": \"WQX\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"Index\": \"1\",\n" +
            "\t\t\"Name\": \"结构性缺陷\",\n" +
            "\t\t\"Code\": \"JGXQX\",\n" +
            "\t\t\"Defect\": [{\n" +
            "\t\t\t\t\"Index\": \"0\",\n" +
            "\t\t\t\t\"Name\": \"破裂\",\n" +
            "\t\t\t\t\"Code\": \"PL\",\n" +
            "\t\t\t\t\"Define\": \"管道的外部压力超过自身的承受力致使管子发生破裂。其形式有纵向、环向和复合3种\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"裂痕--存在下列一个或多个情况：\\n          1) 在管壁上可见细裂痕；\\n          2) 在管壁上由细裂缝处冒出少量沉积物；\\n          3) 轻度剥落。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"裂口--破裂处已形成明显间隙，但管道的形状未受影响且破裂无脱落。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"破碎--管壁破裂或脱落出所剩碎片的环向覆盖范围不大于弧长60°。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"4\",\n" +
            "\t\t\t\t\t\t\"Content\": \"坍塌--存在下列一个或多个情况:\\n          1) 管道材料裂痕、裂口或破碎处边缘环向覆盖范围大于弧长60°；\\n          2) 管壁材料发生脱落的环向范围大于弧长60°。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"1\",\n" +
            "\t\t\t\t\"Name\": \"变形\",\n" +
            "\t\t\t\t\"Code\": \"BX\",\n" +
            "\t\t\t\t\"Define\": \"管道受外力挤压造成形状变异\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"变形不大于管道直径的5%。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"变形为管道直径的5%~15%。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"变形为管道直径的15%~25%\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"4\",\n" +
            "\t\t\t\t\t\t\"Content\": \"变形大于管道直径的25%。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"2\",\n" +
            "\t\t\t\t\"Name\": \"腐蚀\",\n" +
            "\t\t\t\t\"Code\": \"FS\",\n" +
            "\t\t\t\t\"Define\": \"管道内壁受侵蚀而流失或剥落，出现麻面或露出钢筋\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"轻度腐蚀--表面轻微剥落，管壁出现凹凸面。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"中度腐蚀--表面剥落显露粗骨料或钢筋。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"重度腐蚀--粗骨料或钢筋完全显露。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"3\",\n" +
            "\t\t\t\t\"Name\": \"错口\",\n" +
            "\t\t\t\t\"Code\": \"CK\",\n" +
            "\t\t\t\t\"Define\": \"同一接口的两个管口产生横向偏差， 未处于管道的正确位置\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"轻度错口--相接的两个管口偏差不大于管壁厚度的1/2。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"中度错口--相接的两个管口偏差为管壁厚度的1/2~1之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"重度错口--相接的两个管口偏差为管壁厚度的1~2倍。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"4\",\n" +
            "\t\t\t\t\t\t\"Content\": \"严重错口--相接的两个管口偏差为管壁厚度的2倍以上。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"4\",\n" +
            "\t\t\t\t\"Name\": \"起伏\",\n" +
            "\t\t\t\t\"Code\": \"QF\",\n" +
            "\t\t\t\t\"Define\": \"接口位置低处形成洼水\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"起伏高/管径 ≤ 20%。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"20% < 起伏高/管径 ≤ 35%。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"35% < 起伏高/管径 ≤ 50%。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"4\",\n" +
            "\t\t\t\t\t\t\"Content\": \"起伏高/管径 > 50%。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"5\",\n" +
            "\t\t\t\t\"Name\": \"脱节\",\n" +
            "\t\t\t\t\"Code\": \"TJ\",\n" +
            "\t\t\t\t\"Define\": \"两根管道的端部未充分接合或接口脱离\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"轻度脱节--管道端部有少量泥土挤入。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"中度脱节--脱节距离不大于20mm。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"重度脱节--脱节距离为20mm~50mm。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"4\",\n" +
            "\t\t\t\t\t\t\"Content\": \"严重脱节--脱节距离为50mm以上。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"6\",\n" +
            "\t\t\t\t\"Name\": \"接口材料脱落\",\n" +
            "\t\t\t\t\"Code\": \"TL\",\n" +
            "\t\t\t\t\"Define\": \"橡胶圈、沥青、水泥等类似的接口材料进入管道\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"接口材料在管道内水平方向中心线上部可见。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"接口材料在管道内水平方向中心线下部可见。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"7\",\n" +
            "\t\t\t\t\"Name\": \"支管暗接\",\n" +
            "\t\t\t\t\"Code\": \"AJ\",\n" +
            "\t\t\t\t\"Define\": \"支管未通过检查井直接侧向接入主管\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"支管进入主管内的长度不大于主管直径10%。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"支管进入主管内的长度在主管直径的10%~20%之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"支管进入主管内的长度大于主管直径20%。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"8\",\n" +
            "\t\t\t\t\"Name\": \"异物穿入\",\n" +
            "\t\t\t\t\"Code\": \"CR\",\n" +
            "\t\t\t\t\"Define\": \"非管道系统附属设施的物体穿透管壁进入管内\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"异物在管道内且占用过水断面面积不大于10%。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"异物在管道内且占用过水断面面积为10%~30%。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"\\n          异物在管道内且占用过水断面面积大于30%。\\n        \"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"9\",\n" +
            "\t\t\t\t\"Name\": \"渗漏\",\n" +
            "\t\t\t\t\"Code\": \"SL\",\n" +
            "\t\t\t\t\"Define\": \"管外的水流入管道\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"滴漏--水持续从缺陷点滴出。沿管壁流动。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"线漏--水持续从缺陷点流出，并脱离管壁流动。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"涌漏--水从缺陷点涌出，涌漏水面的面积不大于管道断面的1/3。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"4\",\n" +
            "\t\t\t\t\t\t\"Content\": \"喷漏--水从缺陷点大量涌出或喷出，涌漏水面的面积大于管道断面的1/3。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"Index\": \"2\",\n" +
            "\t\t\"Name\": \"功能性缺陷\",\n" +
            "\t\t\"Code\": \"GNXQX\",\n" +
            "\t\t\"Defect\": [{\n" +
            "\t\t\t\t\"Index\": \"0\",\n" +
            "\t\t\t\t\"Name\": \"沉积\",\n" +
            "\t\t\t\t\"Code\": \"CJ\",\n" +
            "\t\t\t\t\"Define\": \"杂质在管道底部沉淀淤积\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"沉积物厚度为管径的20%~30%。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"沉积物厚度在管径的30%~40%之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"沉积物厚度在管径的40%~50%之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"4\",\n" +
            "\t\t\t\t\t\t\"Content\": \"沉积物厚度大于管径的50%。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"1\",\n" +
            "\t\t\t\t\"Name\": \"结垢\",\n" +
            "\t\t\t\t\"Code\": \"JG\",\n" +
            "\t\t\t\t\"Define\": \"管道内壁上的附着物\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"硬质结垢造成的过水断面损失不大于15%；软质结垢造成的过水断面损失在15%~25%之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"硬质结垢造成的过水断面损失在15%~25%之间；软质结垢造成的过水断面损失在25%~50%之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"硬质结垢造成的过水断面损失在25%~50%之间；软质结垢造成的过水断面损失在50%~80%之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"4\",\n" +
            "\t\t\t\t\t\t\"Content\": \"硬质结垢造成的过水断面损失大于50%；软质结垢造成的过水断面损失大于80%。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"2\",\n" +
            "\t\t\t\t\"Name\": \"障碍物\",\n" +
            "\t\t\t\t\"Code\": \"ZW\",\n" +
            "\t\t\t\t\"Define\": \"管道内影响过流的阻挡物\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失不大于15%。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失在15%~25%之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失在25%~50%之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"4\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失在50%。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"3\",\n" +
            "\t\t\t\t\"Name\": \"残墙、坝根\",\n" +
            "\t\t\t\t\"Code\": \"CQ\",\n" +
            "\t\t\t\t\"Define\": \"管道闭水试验时砌筑的临时砖墙封堵，试验后未拆除或拆除不彻底的遗留物\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失不大于15%。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失在15%~25%之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失在25%~50%之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"4\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失在50%。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"4\",\n" +
            "\t\t\t\t\"Name\": \"树根\",\n" +
            "\t\t\t\t\"Code\": \"SG\",\n" +
            "\t\t\t\t\"Define\": \"单根树根或是树根群自然生长进入管道\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失不大于15%。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失在15%~25%之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失在25%~50%之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"4\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失在50%。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"Index\": \"5\",\n" +
            "\t\t\t\t\"Name\": \"浮渣\",\n" +
            "\t\t\t\t\"Code\": \"FZ\",\n" +
            "\t\t\t\t\"Define\": \"管道内水面上的漂浮物（测记录表，不参与计算）\",\n" +
            "\t\t\t\t\"DefectDescribe\": [{\n" +
            "\t\t\t\t\t\t\"Level\": \"1\",\n" +
            "\t\t\t\t\t\t\"Content\": \"零星的漂浮物，漂浮物占水面面积不大于30%。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"2\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失在15%~25%之间。\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"3\",\n" +
            "\t\t\t\t\t\t\"Content\": \"过水断面损失在25%~50%之间。 \"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\"Level\": \"4\",\n" +
            "\t\t\t\t\t\t\"Content\": \" 过水断面损失在50%。\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t]\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t}\n" +
            "]";
    public static java.util.List<QueXianInfo> m5292a(java.io.InputStream r11) {
        Gson gson1=new Gson();
        List<QueXianInfo> list= gson1.fromJson(jsonStr, new TypeToken<List<QueXianInfo>>() {}.getType());

        return  list;


        /*
            r0 = 0
            if (r11 != 0) goto L_0x0004
        L_0x0003:
            return r0
        L_0x0004:
            org.xmlpull.v1.XmlPullParser r8 = android.util.Xml.newPullParser()
            java.lang.String r1 = "utf-8"
            r8.setInput(r11, r1)     // Catch:{ XmlPullParserException -> 0x018a, FileNotFoundException -> 0x0184, IOException -> 0x017e }
            int r1 = r8.getEventType()     // Catch:{ XmlPullParserException -> 0x018a, FileNotFoundException -> 0x0184, IOException -> 0x017e }
            r2 = r1
            r3 = r0
            r4 = r0
            r5 = r0
            r6 = r0
            r7 = r0
            r1 = r0
        L_0x0018:
            r9 = 1
            if (r2 == r9) goto L_0x017b
            switch(r2) {
                case 2: goto L_0x0023;
                case 3: goto L_0x013d;
                default: goto L_0x001e;
            }
        L_0x001e:
            int r2 = r8.next()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            goto L_0x0018
        L_0x0023:
            java.lang.String r2 = "ArrayOfDefectType"
            java.lang.String r9 = r8.getName()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            if (r2 == 0) goto L_0x0036
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r1 = r2
            goto L_0x001e
        L_0x0036:
            java.lang.String r2 = "DefectType"
            java.lang.String r9 = r8.getName()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            if (r2 == 0) goto L_0x005d
            com.bmw.peek2.model.QueXianInfo r5 = new com.bmw.peek2.model.QueXianInfo     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r7.<init>()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            goto L_0x001e
        L_0x004d:
            r0 = move-exception
        L_0x004e:
            r0.printStackTrace()
            r0 = r1
        L_0x0052:
            if (r11 == 0) goto L_0x0003
            r11.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x0003
        L_0x0058:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0003
        L_0x005d:
            java.lang.String r2 = "Index"
            java.lang.String r9 = r8.getName()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            if (r2 == 0) goto L_0x008f
            if (r4 != 0) goto L_0x007d
            java.lang.String r2 = r8.nextText()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r5.setIndex(r2)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            goto L_0x001e
        L_0x0077:
            r0 = move-exception
        L_0x0078:
            r0.printStackTrace()
            r0 = r1
            goto L_0x0052
        L_0x007d:
            java.lang.String r2 = r8.nextText()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r4.setIndex(r2)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            goto L_0x001e
        L_0x0089:
            r0 = move-exception
        L_0x008a:
            r0.printStackTrace()
            r0 = r1
            goto L_0x0052
        L_0x008f:
            java.lang.String r2 = "Name"
            java.lang.String r9 = r8.getName()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            if (r2 == 0) goto L_0x00af
            if (r4 != 0) goto L_0x00a6
            java.lang.String r2 = r8.nextText()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r5.setName(r2)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            goto L_0x001e
        L_0x00a6:
            java.lang.String r2 = r8.nextText()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r4.setName(r2)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            goto L_0x001e
        L_0x00af:
            java.lang.String r2 = "Code"
            java.lang.String r9 = r8.getName()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            if (r2 == 0) goto L_0x00cf
            if (r4 != 0) goto L_0x00c6
            java.lang.String r2 = r8.nextText()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r5.setCode(r2)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            goto L_0x001e
        L_0x00c6:
            java.lang.String r2 = r8.nextText()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r4.setCode(r2)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            goto L_0x001e
        L_0x00cf:
            java.lang.String r2 = "Defect"
            java.lang.String r9 = r8.getName()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            if (r2 == 0) goto L_0x00e7
            com.bmw.peek2.model.QueXian_StyleInfo r4 = new com.bmw.peek2.model.QueXian_StyleInfo     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            goto L_0x001e
        L_0x00e7:
            java.lang.String r2 = "DefectDescribe"
            java.lang.String r9 = r8.getName()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            if (r2 == 0) goto L_0x00fa
            com.bmw.peek2.model.QueXian_GradeInfo r3 = new com.bmw.peek2.model.QueXian_GradeInfo     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            goto L_0x001e
        L_0x00fa:
            java.lang.String r2 = "Level"
            java.lang.String r9 = r8.getName()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            if (r2 == 0) goto L_0x0113
            java.lang.String r2 = r8.nextText()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r3.setLevel(r2)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            goto L_0x001e
        L_0x0113:
            java.lang.String r2 = "Content"
            java.lang.String r9 = r8.getName()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            if (r2 == 0) goto L_0x0128
            java.lang.String r2 = r8.nextText()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r3.setContent(r2)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            goto L_0x001e
        L_0x0128:
            java.lang.String r2 = "Define"
            java.lang.String r9 = r8.getName()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            if (r2 == 0) goto L_0x001e
            java.lang.String r2 = r8.nextText()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r4.setDefine(r2)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            goto L_0x001e
        L_0x013d:
            java.lang.String r2 = "DefectType"
            java.lang.String r9 = r8.getName()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            if (r2 == 0) goto L_0x0153
            r5.setDefect(r7)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r1.add(r5)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r5 = r0
            r7 = r0
            goto L_0x001e
        L_0x0153:
            java.lang.String r2 = "DefectDescribe"
            java.lang.String r9 = r8.getName()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            if (r2 == 0) goto L_0x0165
            r6.add(r3)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r3 = r0
            goto L_0x001e
        L_0x0165:
            java.lang.String r2 = "Defect"
            java.lang.String r9 = r8.getName()     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            if (r2 == 0) goto L_0x001e
            r4.setDefectDescribe(r6)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r7.add(r4)     // Catch:{ XmlPullParserException -> 0x004d, FileNotFoundException -> 0x0077, IOException -> 0x0089 }
            r4 = r0
            r6 = r0
            goto L_0x001e
        L_0x017b:
            r0 = r1
            goto L_0x0052
        L_0x017e:
            r1 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
            goto L_0x008a
        L_0x0184:
            r1 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
            goto L_0x0078
        L_0x018a:
            r1 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
            goto L_0x004e
            */


//        throw new UnsupportedOperationException("Method not decompiled: com.bmw.peek2.p034b.C1148s.m5292a(java.io.InputStream):java.util.List");
  }

    /* renamed from: a */
    public static void m5293a(PipeDefectImage pipeDefectImage) {
        if (pipeDefectImage != null && !C1155v.m5330a(pipeDefectImage.getFilename())) {
            String b = C1129g.m5231b(pipeDefectImage.getFilename(), ".xml");
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(b);
                newSerializer.setOutput(fileOutputStream, "utf-8");
                newSerializer.startDocument("utf-8", (Boolean) null);
                newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                newSerializer.setPrefix("xsd", "http://www.w3.org/2001/XMLSchema");
                newSerializer.setPrefix("xsi", "http://www.w3.org/2001/XMLSchema-instance");
                newSerializer.startTag("", "PipeDefectImage");
                if (!C1155v.m5330a(pipeDefectImage.getPipeSection())) {
                    newSerializer.startTag((String) null, "PipeSection");
                    newSerializer.text(pipeDefectImage.getPipeSection());
                    newSerializer.endTag((String) null, "PipeSection");
                }
                ArrayList<PipeDefectDetail> pipeDefectDetails = pipeDefectImage.getPipeDefectDetails();
                for (int i = 0; i < pipeDefectDetails.size(); i++) {
                    newSerializer.startTag((String) null, "Defect");
                    PipeDefectDetail pipeDefectDetail = pipeDefectDetails.get(i);
                    if (!C1155v.m5330a(pipeDefectDetail.getDistance())) {
                        newSerializer.startTag((String) null, "Distance");
                        newSerializer.text(pipeDefectDetail.getDistance());
                        newSerializer.endTag((String) null, "Distance");
                    }
                    if (!C1155v.m5330a(pipeDefectDetail.getDefectType())) {
                        newSerializer.startTag((String) null, "DefectType");
                        newSerializer.text(pipeDefectDetail.getDefectType());
                        newSerializer.endTag((String) null, "DefectType");
                    }
                    if (!C1155v.m5330a(pipeDefectDetail.getDefectCode())) {
                        newSerializer.startTag((String) null, "DefectCode");
                        newSerializer.text(pipeDefectDetail.getDefectCode());
                        newSerializer.endTag((String) null, "DefectCode");
                    }
                    if (!C1155v.m5330a(pipeDefectDetail.getDefectLevel())) {
                        newSerializer.startTag((String) null, "DefectLevel");
                        newSerializer.text(pipeDefectDetail.getDefectLevel());
                        newSerializer.endTag((String) null, "DefectLevel");
                    }
                    if (!C1155v.m5330a(pipeDefectDetail.getClockExpression())) {
                        newSerializer.startTag((String) null, "ClockExpression");
                        newSerializer.text(pipeDefectDetail.getClockExpression());
                        newSerializer.endTag((String) null, "ClockExpression");
                    }
                    if (!C1155v.m5330a(pipeDefectDetail.getDefectLength())) {
                        newSerializer.startTag((String) null, "DefectLength");
                        newSerializer.text(pipeDefectDetail.getDefectLength());
                        newSerializer.endTag((String) null, "DefectLength");
                    }
                    if (!C1155v.m5330a(pipeDefectDetail.getDefectDescription())) {
                        newSerializer.startTag((String) null, "DefectDescription");
                        newSerializer.text(pipeDefectDetail.getDefectDescription());
                        newSerializer.endTag((String) null, "DefectDescription");
                    }
                    newSerializer.endTag((String) null, "Defect");
                }
                if (!C1155v.m5330a(pipeDefectImage.getFilename())) {
                    newSerializer.startTag((String) null, "Filename");
                    newSerializer.text(pipeDefectImage.getFilename());
                    newSerializer.endTag((String) null, "Filename");
                }
                newSerializer.endTag("", "PipeDefectImage");
                newSerializer.endDocument();
                newSerializer.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            C1129g.m5227a(b);
        }
    }
    public  static  VideoInfo getXmlVIdeo(String xml){
        VideoInfo videoInfo = new VideoInfo();
        try {
            File path = new File(xml);
            FileInputStream fis = new FileInputStream(path);

            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(fis, "utf-8");

            int eventType = parser.getEventType();


            while (eventType != XmlPullParser.END_DOCUMENT) {
                Log.w("fy","while-readxml");
                String tagName = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        Log.w("fy","XmlPullParser.START_TAG");
                            if (parser.getName().equals("DeviceModel")){
                                videoInfo.setDeviceModel(parser.nextText());
                            }else if (parser.getName().equals("InspectionStandard")){
                                videoInfo.setInspectionStandard(parser.nextText());
                            }else if (parser.getName().equals("VideoFilename")){
                                videoInfo.setVideoFilename(parser.nextText());
                            }else if (parser.getName().equals("CapturePictureDirectoryName")){
                                videoInfo.setCapturePictureDirectoryName(parser.nextText());
                            }

                        break;
                    case XmlPullParser.END_TAG:
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return  videoInfo;
    }
    /* renamed from: a */
    public static void m5294a(VideoInfo videoInfo) {
        if (videoInfo != null && !C1155v.m5330a(videoInfo.getVideoFilename())) {
            String b = C1129g.m5231b(videoInfo.getVideoFilename(), ".xml");
            C1140n.m5266a("生成录像文件对应xml路径：" + b);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(b);
                newSerializer.setOutput(fileOutputStream, "utf-8");
                newSerializer.startDocument("utf-8", (Boolean) null);
                newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                newSerializer.setPrefix("xsd", "http://www.w3.org/2001/XMLSchema");
                newSerializer.setPrefix("xsi", "http://www.w3.org/2001/XMLSchema-instance");
                newSerializer.startTag("", "VideoInfo");
                RecordTaskInfo recordTaskInfo = videoInfo.getRecordTaskInfo();
                if (recordTaskInfo != null) {
                    newSerializer.startTag((String) null, "Headline");
                    if (!C1155v.m5330a(recordTaskInfo.getTask_name())) {
                        newSerializer.startTag((String) null, "TaskName");
                        newSerializer.text(recordTaskInfo.getTask_name());
                        newSerializer.endTag((String) null, "TaskName");
                    }
                    if (!C1155v.m5330a(recordTaskInfo.getTask_place())) {
                        newSerializer.startTag((String) null, "InspectAddress");
                        newSerializer.text(recordTaskInfo.getTask_place());
                        newSerializer.endTag((String) null, "InspectAddress");
                    }
                    if (!C1155v.m5330a(recordTaskInfo.getTask_id())) {
                        newSerializer.startTag((String) null, "TaskID");
                        newSerializer.text(recordTaskInfo.getTask_id());
                        newSerializer.endTag((String) null, "TaskID");
                    }
                    NET_DVR_TIME a = C1131i.m5242a();
                    StringBuilder sb = new StringBuilder();
                    if (a != null) {
                        sb.append(a.dwYear).append("年").append(a.dwMonth).append("月").append(a.dwDay).append("日");
                    } else {
                        sb.append(C1158y.m5340b());
                    }
                    newSerializer.startTag((String) null, "InspectDate");
                    newSerializer.text(sb.toString());
                    newSerializer.endTag((String) null, "InspectDate");
                    if (!C1155v.m5330a(recordTaskInfo.getTask_start())) {
                        newSerializer.startTag((String) null, "StartWellNum");
                        newSerializer.text(recordTaskInfo.getTask_start());
                        newSerializer.endTag((String) null, "StartWellNum");
                    }
                    if (!C1155v.m5330a(recordTaskInfo.getTask_end())) {
                        newSerializer.startTag((String) null, "EndWellNum");
                        newSerializer.text(recordTaskInfo.getTask_end());
                        newSerializer.endTag((String) null, "EndWellNum");
                    }
                    if (!C1155v.m5330a(recordTaskInfo.getTask_direction())) {
                        newSerializer.startTag((String) null, "InspectDirection");
                        newSerializer.text(recordTaskInfo.getTask_direction());
                        newSerializer.endTag((String) null, "InspectDirection");
                    }
                    if (!C1155v.m5330a(recordTaskInfo.getTask_sort())) {
                        newSerializer.startTag((String) null, "PipeType");
                        newSerializer.text(recordTaskInfo.getTask_sort());
                        newSerializer.endTag((String) null, "PipeType");
                    }
                    if (!C1155v.m5330a(recordTaskInfo.getTask_guancai())) {
                        newSerializer.startTag((String) null, "PipeStock");
                        newSerializer.text(recordTaskInfo.getTask_guancai());
                        newSerializer.endTag((String) null, "PipeStock");
                    }
                    if (!C1155v.m5330a(recordTaskInfo.getTask_diameter())) {
                        newSerializer.startTag((String) null, "PipeDiameter");
                        newSerializer.text(recordTaskInfo.getTask_diameter());
                        newSerializer.endTag((String) null, "PipeDiameter");
                    }
                    if (!C1155v.m5330a(recordTaskInfo.getTask_computer())) {
                        newSerializer.startTag((String) null, "InspectUnit");
                        newSerializer.text(recordTaskInfo.getTask_computer());
                        newSerializer.endTag((String) null, "InspectUnit");
                    }
                    if (!C1155v.m5330a(recordTaskInfo.getTask_people())) {
                        newSerializer.startTag((String) null, "Inspector");
                        newSerializer.text(recordTaskInfo.getTask_people());
                        newSerializer.endTag((String) null, "Inspector");
                    }
                    newSerializer.endTag((String) null, "Headline");
                }
                if (!C1155v.m5330a(videoInfo.getDeviceModel())) {
                    newSerializer.startTag((String) null, "DeviceModel");
                    newSerializer.text(videoInfo.getDeviceModel());
                    newSerializer.endTag((String) null, "DeviceModel");
                }
                if (!C1155v.m5330a(videoInfo.getInspectionStandard())) {
                    newSerializer.startTag((String) null, "InspectionStandard");
                    newSerializer.text(videoInfo.getInspectionStandard());
                    newSerializer.endTag((String) null, "InspectionStandard");
                }
                if (!C1155v.m5330a(videoInfo.getVideoFilename())) {
                    newSerializer.startTag((String) null, "VideoFilename");
                    newSerializer.text(videoInfo.getVideoFilename());
                    newSerializer.endTag((String) null, "VideoFilename");
                }
                if (!C1155v.m5330a(videoInfo.getCapturePictureDirectoryName())) {
                    newSerializer.startTag((String) null, "CapturePictureDirectoryName");
                    newSerializer.text(videoInfo.getCapturePictureDirectoryName());
                    newSerializer.endTag((String) null, "CapturePictureDirectoryName");
                }
                ArrayList<CapturePicture> capturePictures = videoInfo.getCapturePictures();
                for (int i = 0; i < capturePictures.size(); i++) {
                    newSerializer.startTag((String) null, "CapturePicture");
                    CapturePicture capturePicture = capturePictures.get(i);
                    if (!C1155v.m5330a(capturePicture.getFilename())) {
                        newSerializer.startTag((String) null, "Filename");
                        newSerializer.text(capturePicture.getFilename());
                        newSerializer.endTag((String) null, "Filename");
                    }
                    if (!C1155v.m5330a(capturePicture.getDefectFilename())) {
                        newSerializer.startTag((String) null, "DefectFilename");
                        newSerializer.text(capturePicture.getDefectFilename());
                        newSerializer.endTag((String) null, "DefectFilename");
                    }
                    if (!C1155v.m5330a(capturePicture.getTimestamp())) {
                        newSerializer.startTag((String) null, "Timestamp");
                        newSerializer.text(capturePicture.getTimestamp());
                        newSerializer.endTag((String) null, "Timestamp");
                    }
                    if (!C1155v.m5330a(capturePicture.getPipedefectCode())) {
                        newSerializer.startTag((String) null, "PipedefectCount");
                        newSerializer.text(capturePicture.getPipedefectCode());
                        newSerializer.endTag((String) null, "PipedefectCount");
                    }
                    newSerializer.endTag((String) null, "CapturePicture");
                }
                newSerializer.endTag("", "VideoInfo");
                newSerializer.endDocument();
                newSerializer.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r0 = r1;
        r1 = r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0137, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0138, code lost:
        r6 = r0;
        r0 = r1;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013f, code lost:
        r6 = r0;
        r0 = r1;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x014b, code lost:
        r6 = r0;
        r0 = r1;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        r1 = r0;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static PipeDefectImage m5295b(String r7) {
        /*
            r2 = 0
            org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0145, XmlPullParserException -> 0x0127, IOException -> 0x012f }
            r0.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0145, XmlPullParserException -> 0x0127, IOException -> 0x012f }
            java.lang.String r1 = "utf-8"
            r4.setInput(r0, r1)     // Catch:{ FileNotFoundException -> 0x0145, XmlPullParserException -> 0x0127, IOException -> 0x012f }
            int r0 = r4.getEventType()     // Catch:{ FileNotFoundException -> 0x0145, XmlPullParserException -> 0x0127, IOException -> 0x012f }
            r1 = r0
            r3 = r2
            r0 = r2
        L_0x0016:
            r5 = 1
            if (r1 == r5) goto L_0x003b
            switch(r1) {
                case 2: goto L_0x0025;
                case 3: goto L_0x0112;
                default: goto L_0x001c;
            }
        L_0x001c:
            r1 = r0
        L_0x001d:
            int r0 = r4.next()     // Catch:{ FileNotFoundException -> 0x014a, XmlPullParserException -> 0x013e, IOException -> 0x0137 }
            r6 = r0
            r0 = r1
            r1 = r6
            goto L_0x0016
        L_0x0025:
            java.lang.String r1 = r4.getName()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            java.lang.String r5 = "PipeDefectImage"
            boolean r1 = r1.equals(r5)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            if (r1 == 0) goto L_0x003c
            com.bmw.peek2.model.PipeDefectImage r1 = new com.bmw.peek2.model.PipeDefectImage     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            goto L_0x001d
        L_0x0037:
            r1 = move-exception
        L_0x0038:
            r1.printStackTrace()
        L_0x003b:
            return r0
        L_0x003c:
            java.lang.String r1 = r4.getName()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            java.lang.String r5 = "PipeSection"
            boolean r1 = r1.equals(r5)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            if (r1 == 0) goto L_0x0051
            java.lang.String r1 = r4.nextText()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r0.setPipeSection(r1)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r1 = r0
            goto L_0x001d
        L_0x0051:
            java.lang.String r1 = r4.getName()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            java.lang.String r5 = "Defect"
            boolean r1 = r1.equals(r5)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            if (r1 == 0) goto L_0x0064
            com.bmw.peek2.model.PipeDefectDetail r3 = new com.bmw.peek2.model.PipeDefectDetail     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r1 = r0
            goto L_0x001d
        L_0x0064:
            java.lang.String r1 = r4.getName()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            java.lang.String r5 = "Distance"
            boolean r1 = r1.equals(r5)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            if (r1 == 0) goto L_0x0079
            java.lang.String r1 = r4.nextText()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r3.setDistance(r1)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r1 = r0
            goto L_0x001d
        L_0x0079:
            java.lang.String r1 = r4.getName()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            java.lang.String r5 = "DefectType"
            boolean r1 = r1.equals(r5)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            if (r1 == 0) goto L_0x008e
            java.lang.String r1 = r4.nextText()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r3.setDefectType(r1)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r1 = r0
            goto L_0x001d
        L_0x008e:
            java.lang.String r1 = r4.getName()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            java.lang.String r5 = "DefectCode"
            boolean r1 = r1.equals(r5)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            if (r1 == 0) goto L_0x00a4
            java.lang.String r1 = r4.nextText()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r3.setDefectCode(r1)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r1 = r0
            goto L_0x001d
        L_0x00a4:
            java.lang.String r1 = r4.getName()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            java.lang.String r5 = "DefectLevel"
            boolean r1 = r1.equals(r5)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            if (r1 == 0) goto L_0x00ba
            java.lang.String r1 = r4.nextText()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r3.setDefectLevel(r1)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r1 = r0
            goto L_0x001d
        L_0x00ba:
            java.lang.String r1 = r4.getName()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            java.lang.String r5 = "ClockExpression"
            boolean r1 = r1.equals(r5)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            if (r1 == 0) goto L_0x00d0
            java.lang.String r1 = r4.nextText()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r3.setClockExpression(r1)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r1 = r0
            goto L_0x001d
        L_0x00d0:
            java.lang.String r1 = r4.getName()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            java.lang.String r5 = "DefectLength"
            boolean r1 = r1.equals(r5)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            if (r1 == 0) goto L_0x00e6
            java.lang.String r1 = r4.nextText()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r3.setDefectLength(r1)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r1 = r0
            goto L_0x001d
        L_0x00e6:
            java.lang.String r1 = r4.getName()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            java.lang.String r5 = "DefectDescription"
            boolean r1 = r1.equals(r5)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            if (r1 == 0) goto L_0x00fc
            java.lang.String r1 = r4.nextText()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r3.setDefectDescription(r1)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r1 = r0
            goto L_0x001d
        L_0x00fc:
            java.lang.String r1 = r4.getName()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            java.lang.String r5 = "Filename"
            boolean r1 = r1.equals(r5)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = r4.nextText()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r0.setFilename(r1)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r1 = r0
            goto L_0x001d
        L_0x0112:
            java.lang.String r1 = r4.getName()     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            java.lang.String r5 = "Defect"
            boolean r1 = r1.equals(r5)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            if (r1 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x001c
            r0.addDefectDetail(r3)     // Catch:{ FileNotFoundException -> 0x0037, XmlPullParserException -> 0x0143, IOException -> 0x013c }
            r3 = r2
            r1 = r0
            goto L_0x001d
        L_0x0127:
            r0 = move-exception
            r1 = r0
            r0 = r2
        L_0x012a:
            r1.printStackTrace()
            goto L_0x003b
        L_0x012f:
            r0 = move-exception
            r1 = r0
            r0 = r2
        L_0x0132:
            r1.printStackTrace()
            goto L_0x003b
        L_0x0137:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L_0x0132
        L_0x013c:
            r1 = move-exception
            goto L_0x0132
        L_0x013e:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L_0x012a
        L_0x0143:
            r1 = move-exception
            goto L_0x012a
        L_0x0145:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto L_0x0038
        L_0x014a:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bmw.peek2.p034b.C1148s.m5295b(java.lang.String):com.bmw.peek2.model.PipeDefectImage");
    }
}
