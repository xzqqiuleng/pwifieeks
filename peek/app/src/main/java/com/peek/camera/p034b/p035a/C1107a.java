package com.peek.camera.p034b.p035a;

import android.util.Log;

import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_COMPRESSIONCFG_V30;
import com.hikvision.netsdk.NET_DVR_COMPRESSION_INFO_V30;
import com.hikvision.netsdk.NET_DVR_PICCFG_V30;
import com.peek.camera.BaseApplication;
import com.peek.camera.C1057a;
import com.peek.camera.model.All_id_Info;
import com.peek.camera.model.OsdHkInfo;
import com.peek.camera.p034b.C1140n;

import java.io.UnsupportedEncodingException;

/* renamed from: com.bmw.peek2.b.a.a */
public class C1107a {

    /* renamed from: com.bmw.peek2.b.a.a$1 */
    class C11081 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f3056a = false;

        /* renamed from: b */
        final /* synthetic */ int f3057b = 0;

        public void run() {
            if (this.f3056a) {
                HCNetSDK.getInstance().NET_DVR_PTZControl(this.f3057b, 12, 0);
            } else {
                HCNetSDK.getInstance().NET_DVR_PTZControl(this.f3057b, 12, 1);
            }
        }
    }

    /* renamed from: com.bmw.peek2.b.a.a$a */
    private static class C1109a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C1107a f3058a = new C1107a((C11081) null);
    }

    private C1107a() {
    }

    /* synthetic */ C1107a(C11081 r1) {
        this();
    }

    /* renamed from: a */
    public static C1107a m5163a() {
        return C1109a.f3058a;
    }

    /* renamed from: a */
    public void mo4596a(OsdHkInfo osdHkInfo, OsdHkInfo osdHkInfo2, int i, int i2) {
        int i3 = 0;
        if (All_id_Info.getInstance().getM_iLogID() >= 0) {
            NET_DVR_PICCFG_V30 net_dvr_piccfg_v30 = new NET_DVR_PICCFG_V30();
            HCNetSDK instance = HCNetSDK.getInstance();
            int m_iLogID = All_id_Info.getInstance().getM_iLogID();
            HCNetSDK.getInstance();
            instance.NET_DVR_GetDVRConfig(m_iLogID, 1002, All_id_Info.getInstance().getM_iChanNum(), net_dvr_piccfg_v30);
            byte[] bArr = null;
            String str = osdHkInfo == null ? "" : osdHkInfo.getsString();
            if (str == null) {
                str = "";
            }
            try {
                bArr = str.getBytes("gb2312");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (bArr != null) {
                for (int i4 = 0; i4 < net_dvr_piccfg_v30.sChanName.length; i4++) {
                    if (i4 < bArr.length) {
                        net_dvr_piccfg_v30.sChanName[i4] = bArr[i4];
                    } else {
                        net_dvr_piccfg_v30.sChanName[i4] = 0;
                    }
                }
                net_dvr_piccfg_v30.dwShowChanName = osdHkInfo == null ? 0 : osdHkInfo.getShowStr();
                net_dvr_piccfg_v30.wShowNameTopLeftX = osdHkInfo == null ? 0 : osdHkInfo.getOsdX();
                net_dvr_piccfg_v30.wShowNameTopLeftY = osdHkInfo == null ? 0 : osdHkInfo.getOsdY();
                if (BaseApplication.m4928b().getBoolean("KEY_OSD_IS_SHOW_TIME_ON_DEVICE", false)) {
                    net_dvr_piccfg_v30.dwShowOsd = 0;
                } else {
                    if (osdHkInfo2 != null) {
                        i3 = osdHkInfo2.getShowStr();
                    }
                    net_dvr_piccfg_v30.dwShowOsd = i3;
                }
                net_dvr_piccfg_v30.byFontSize = osdHkInfo2 == null ? 1 : (byte) osdHkInfo2.getStrSize();
                net_dvr_piccfg_v30.wOSDTopLeftX = osdHkInfo2 == null ? 16 : osdHkInfo2.getOsdX();
                net_dvr_piccfg_v30.wOSDTopLeftY = osdHkInfo2 == null ? 544 : osdHkInfo2.getOsdY();
            }
            HCNetSDK instance2 = HCNetSDK.getInstance();
            int m_iLogID2 = All_id_Info.getInstance().getM_iLogID();
            HCNetSDK.getInstance();
            if (!instance2.NET_DVR_SetDVRConfig(m_iLogID2, 1003, All_id_Info.getInstance().getM_iChanNum(), net_dvr_piccfg_v30)) {
                C1140n.m5270b("OSD标记：e= ", HCNetSDK.getInstance().NET_DVR_GetLastError());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[Catch:{ UnsupportedEncodingException -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A[Catch:{ UnsupportedEncodingException -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050 A[Catch:{ UnsupportedEncodingException -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006a A[Catch:{ UnsupportedEncodingException -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0079 A[Catch:{ UnsupportedEncodingException -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00aa A[Catch:{ UnsupportedEncodingException -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b3 A[Catch:{ UnsupportedEncodingException -> 0x005f }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4597a(java.util.List<OsdHkInfo> r10, int r11, int r12) {
        /*
            r9 = this;
            r8 = 44
            r2 = 0
            if (r10 != 0) goto L_0x0006
        L_0x0005:
            return
        L_0x0006:
            int r4 = r10.size()
            com.hikvision.netsdk.NET_DVR_SHOWSTRING_V30 r5 = new com.hikvision.netsdk.NET_DVR_SHOWSTRING_V30
            r5.<init>()
            r3 = r2
        L_0x0010:
            r0 = 6
            if (r3 >= r0) goto L_0x00c9
            if (r4 == 0) goto L_0x004d
            int r0 = r10.size()     // Catch:{ UnsupportedEncodingException -> 0x005f }
            if (r3 >= r0) goto L_0x004d
            java.lang.Object r0 = r10.get(r3)     // Catch:{ UnsupportedEncodingException -> 0x005f }
            com.bmw.peek2.model.OsdHkInfo r0 = (com.bmw.peek2.model.OsdHkInfo) r0     // Catch:{ UnsupportedEncodingException -> 0x005f }
            java.lang.String r0 = r0.getsString()     // Catch:{ UnsupportedEncodingException -> 0x005f }
        L_0x0025:
            if (r0 == 0) goto L_0x0050
            int r1 = r0.length()     // Catch:{ UnsupportedEncodingException -> 0x005f }
            if (r1 <= 0) goto L_0x0050
            java.lang.String r1 = "gb2312"
            byte[] r0 = r0.getBytes(r1)     // Catch:{ UnsupportedEncodingException -> 0x005f }
        L_0x0033:
            r1 = r2
        L_0x0034:
            com.hikvision.netsdk.NET_DVR_SHOWSTRINGINFO[] r6 = r5.struStringInfo     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r6 = r6[r3]     // Catch:{ UnsupportedEncodingException -> 0x005f }
            byte[] r6 = r6.sString     // Catch:{ UnsupportedEncodingException -> 0x005f }
            int r6 = r6.length     // Catch:{ UnsupportedEncodingException -> 0x005f }
            if (r1 >= r6) goto L_0x0067
            int r6 = r0.length     // Catch:{ UnsupportedEncodingException -> 0x005f }
            if (r1 >= r6) goto L_0x0055
            com.hikvision.netsdk.NET_DVR_SHOWSTRINGINFO[] r6 = r5.struStringInfo     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r6 = r6[r3]     // Catch:{ UnsupportedEncodingException -> 0x005f }
            byte[] r6 = r6.sString     // Catch:{ UnsupportedEncodingException -> 0x005f }
            byte r7 = r0[r1]     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r6[r1] = r7     // Catch:{ UnsupportedEncodingException -> 0x005f }
        L_0x004a:
            int r1 = r1 + 1
            goto L_0x0034
        L_0x004d:
            java.lang.String r0 = ""
            goto L_0x0025
        L_0x0050:
            r0 = 44
            byte[] r0 = new byte[r0]     // Catch:{ UnsupportedEncodingException -> 0x005f }
            goto L_0x0033
        L_0x0055:
            com.hikvision.netsdk.NET_DVR_SHOWSTRINGINFO[] r6 = r5.struStringInfo     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r6 = r6[r3]     // Catch:{ UnsupportedEncodingException -> 0x005f }
            byte[] r6 = r6.sString     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r7 = 0
            r6[r1] = r7     // Catch:{ UnsupportedEncodingException -> 0x005f }
            goto L_0x004a
        L_0x005f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0063:
            int r0 = r3 + 1
            r3 = r0
            goto L_0x0010
        L_0x0067:
            int r1 = r0.length     // Catch:{ UnsupportedEncodingException -> 0x005f }
            if (r1 > r8) goto L_0x00aa
            com.hikvision.netsdk.NET_DVR_SHOWSTRINGINFO[] r1 = r5.struStringInfo     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r1 = r1[r3]     // Catch:{ UnsupportedEncodingException -> 0x005f }
            int r0 = r0.length     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r1.wStringSize = r0     // Catch:{ UnsupportedEncodingException -> 0x005f }
        L_0x0071:
            if (r4 == 0) goto L_0x00b3
            int r0 = r10.size()     // Catch:{ UnsupportedEncodingException -> 0x005f }
            if (r3 >= r0) goto L_0x00b3
            com.hikvision.netsdk.NET_DVR_SHOWSTRINGINFO[] r0 = r5.struStringInfo     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r1 = r0[r3]     // Catch:{ UnsupportedEncodingException -> 0x005f }
            java.lang.Object r0 = r10.get(r3)     // Catch:{ UnsupportedEncodingException -> 0x005f }
            com.bmw.peek2.model.OsdHkInfo r0 = (com.bmw.peek2.model.OsdHkInfo) r0     // Catch:{ UnsupportedEncodingException -> 0x005f }
            int r0 = r0.getOsdX()     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r1.wShowStringTopLeftX = r0     // Catch:{ UnsupportedEncodingException -> 0x005f }
            com.hikvision.netsdk.NET_DVR_SHOWSTRINGINFO[] r0 = r5.struStringInfo     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r1 = r0[r3]     // Catch:{ UnsupportedEncodingException -> 0x005f }
            java.lang.Object r0 = r10.get(r3)     // Catch:{ UnsupportedEncodingException -> 0x005f }
            com.bmw.peek2.model.OsdHkInfo r0 = (com.bmw.peek2.model.OsdHkInfo) r0     // Catch:{ UnsupportedEncodingException -> 0x005f }
            int r0 = r0.getOsdY()     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r1.wShowStringTopLeftY = r0     // Catch:{ UnsupportedEncodingException -> 0x005f }
            com.hikvision.netsdk.NET_DVR_SHOWSTRINGINFO[] r0 = r5.struStringInfo     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r1 = r0[r3]     // Catch:{ UnsupportedEncodingException -> 0x005f }
            java.lang.Object r0 = r10.get(r3)     // Catch:{ UnsupportedEncodingException -> 0x005f }
            com.bmw.peek2.model.OsdHkInfo r0 = (com.bmw.peek2.model.OsdHkInfo) r0     // Catch:{ UnsupportedEncodingException -> 0x005f }
            int r0 = r0.getShowStr()     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r1.wShowString = r0     // Catch:{ UnsupportedEncodingException -> 0x005f }
            goto L_0x0063
        L_0x00aa:
            com.hikvision.netsdk.NET_DVR_SHOWSTRINGINFO[] r0 = r5.struStringInfo     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r0 = r0[r3]     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r1 = 44
            r0.wStringSize = r1     // Catch:{ UnsupportedEncodingException -> 0x005f }
            goto L_0x0071
        L_0x00b3:
            com.hikvision.netsdk.NET_DVR_SHOWSTRINGINFO[] r0 = r5.struStringInfo     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r0 = r0[r3]     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r1 = 0
            r0.wShowStringTopLeftX = r1     // Catch:{ UnsupportedEncodingException -> 0x005f }
            com.hikvision.netsdk.NET_DVR_SHOWSTRINGINFO[] r0 = r5.struStringInfo     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r0 = r0[r3]     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r1 = 0
            r0.wShowStringTopLeftY = r1     // Catch:{ UnsupportedEncodingException -> 0x005f }
            com.hikvision.netsdk.NET_DVR_SHOWSTRINGINFO[] r0 = r5.struStringInfo     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r0 = r0[r3]     // Catch:{ UnsupportedEncodingException -> 0x005f }
            r1 = 0
            r0.wShowString = r1     // Catch:{ UnsupportedEncodingException -> 0x005f }
            goto L_0x0063
        L_0x00c9:
            com.hikvision.netsdk.HCNetSDK r0 = com.hikvision.netsdk.HCNetSDK.getInstance()
            com.hikvision.netsdk.HCNetSDK.getInstance()
            r1 = 1031(0x407, float:1.445E-42)
            boolean r0 = r0.NET_DVR_SetDVRConfig(r11, r1, r12, r5)
            if (r0 != 0) goto L_0x0005
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "字符叠加添加版头：NET_DVR_GET_SHOWSTRING_V30 faild!  err: "
            java.lang.StringBuilder r0 = r0.append(r1)
            com.hikvision.netsdk.HCNetSDK r1 = com.hikvision.netsdk.HCNetSDK.getInstance()
            int r1 = r1.NET_DVR_GetLastError()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.bmw.peek2.p034b.C1140n.m5269b(r0)
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bmw.peek2.p034b.p035a.C1107a.mo4597a(java.util.List, int, int):void");
    }

    /* renamed from: b */
    public boolean mo4598b() {
        NET_DVR_COMPRESSIONCFG_V30 net_dvr_compressioncfg_v30 = new NET_DVR_COMPRESSIONCFG_V30();
        Log.e("yyyy", "setVideoValue: get   = " + HCNetSDK.getInstance().NET_DVR_GetDVRConfig(All_id_Info.getInstance().getM_iLogID(), HCNetSDK.NET_DVR_GET_COMPRESSCFG_V30, All_id_Info.getInstance().getM_iChanNum(), net_dvr_compressioncfg_v30) + " error = " + HCNetSDK.getInstance().NET_DVR_GetLastError());
        NET_DVR_COMPRESSION_INFO_V30 net_dvr_compression_info_v30 = net_dvr_compressioncfg_v30.struNormHighRecordPara;
        net_dvr_compression_info_v30.byStreamType = 0;
        if (C1057a.m4938b()) {
            net_dvr_compression_info_v30.byResolution = 19;
        } else {
            net_dvr_compression_info_v30.byResolution = 20;
        }
        net_dvr_compression_info_v30.byBitrateType = 0;
        net_dvr_compression_info_v30.byPicQuality = 0;
        net_dvr_compression_info_v30.dwVideoBitrate = 23;
        net_dvr_compression_info_v30.dwVideoFrameRate = 17;
        net_dvr_compression_info_v30.wIntervalFrameI = 50;
        net_dvr_compression_info_v30.byVideoEncComplexity = 2;
        return HCNetSDK.getInstance().NET_DVR_SetDVRConfig(All_id_Info.getInstance().getM_iLogID(), HCNetSDK.NET_DVR_SET_COMPRESSCFG_V30, All_id_Info.getInstance().getM_iChanNum(), net_dvr_compressioncfg_v30);
    }
}
