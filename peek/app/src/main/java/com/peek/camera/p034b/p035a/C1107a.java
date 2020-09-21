package com.peek.camera.p034b.p035a;

import android.util.Log;

import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_COMPRESSIONCFG_V30;
import com.hikvision.netsdk.NET_DVR_COMPRESSION_INFO_V30;
import com.hikvision.netsdk.NET_DVR_CONFIG;
import com.hikvision.netsdk.NET_DVR_PICCFG_V30;
import com.hikvision.netsdk.NET_DVR_SHOWSTRING_V30;
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
    public void mo4597a(java.util.List<OsdHkInfo> arg10, int r11, int r12) {
        String v0_1;
        int v8 = 44;
        if(arg10 != null) {
            int v4 = arg10.size();
            NET_DVR_SHOWSTRING_V30 v5 = new NET_DVR_SHOWSTRING_V30();
            int v3;
            for(v3 = 0; v3 < 6; ++v3) {
                if(v4 != 0) {
                    try {
                        if(v3 < arg10.size()) {
                            v0_1 = arg10.get(v3).getsString();
                        }
                        else {
                            label_35:
                            v0_1 = "";
                        }

                        byte[] v0_2 = v0_1 == null || v0_1.length() <= 0 ? new byte[44] : v0_1.getBytes("gb2312");
                        int v1;
                        for(v1 = 0; v1 < v5.struStringInfo[v3].sString.length; ++v1) {
                            v5.struStringInfo[v3].sString[v1] = v1 < v0_2.length ? v0_2[v1] : 0;
                        }

                        v5.struStringInfo[v3].wStringSize = v0_2.length <= v8 ? v0_2.length : 44;
                        if(v4 != 0 && v3 < arg10.size()) {
                            v5.struStringInfo[v3].wShowStringTopLeftX = arg10.get(v3).getOsdX();
                            v5.struStringInfo[v3].wShowStringTopLeftY = arg10.get(v3).getOsdY();
                            v5.struStringInfo[v3].wShowString = arg10.get(v3).getShowStr();
                            continue;
                        }

                        v5.struStringInfo[v3].wShowStringTopLeftX = 0;
                        v5.struStringInfo[v3].wShowStringTopLeftY = 0;
                        v5.struStringInfo[v3].wShowString = 0;
                    }
                    catch(UnsupportedEncodingException v0) {
                        v0.printStackTrace();
                    }
                }
                else {
                    v0_1 = "";
                }


            }

            HCNetSDK v0_3 = HCNetSDK.getInstance();
            HCNetSDK.getInstance();
            if(v0_3.NET_DVR_SetDVRConfig(r11, 0x407, r12, ((NET_DVR_CONFIG)v5))) {
                return;
            }

            C1140n.m5269b("字符叠加添加版头：NET_DVR_GET_SHOWSTRING_V30 faild!  err: " + HCNetSDK.getInstance().NET_DVR_GetLastError());
        }
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
