package com.peek.camera.p034b;

import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_CAMERAPARAMCFG_EX;
import com.hikvision.netsdk.NET_DVR_CONFIG;
import com.hikvision.netsdk.NET_DVR_PICCFG_V30;
import com.hikvision.netsdk.NET_DVR_SHOWSTRING_V30;
import com.hikvision.netsdk.NET_DVR_TIME;
import com.hikvision.netsdk.NET_DVR_WDR;
import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.jna.HCNetSDKByJNA;
import com.peek.camera.jna.HCNetSDKJNAInstance;
import com.peek.camera.model.All_id_Info;
import com.peek.camera.model.Login_info;
import com.peek.camera.model.OsdHkInfo;
import com.sun.jna.ptr.IntByReference;
import java.io.UnsupportedEncodingException;

/* renamed from: com.bmw.peek2.b.i */
public class C1131i {
    /* renamed from: a */
    public static NET_DVR_TIME m5242a() {
        if (All_id_Info.getInstance().getM_iLogID() < 0) {
            return null;
        }
        NET_DVR_TIME net_dvr_time = new NET_DVR_TIME();
        HCNetSDK instance = HCNetSDK.getInstance();
        int m_iLogID = All_id_Info.getInstance().getM_iLogID();
        HCNetSDK.getInstance();
        if (!instance.NET_DVR_GetDVRConfig(m_iLogID, 118, All_id_Info.getInstance().getM_iChanNum(), net_dvr_time)) {
            return null;
        }
        if (net_dvr_time.dwYear == 0 && net_dvr_time.dwMonth == 0 && net_dvr_time.dwDay == 0 && net_dvr_time.dwHour == 0) {
            return null;
        }
        return net_dvr_time;
    }

    /* renamed from: a */
    public static void m5243a(String str, boolean z) {
        if (All_id_Info.getInstance().getM_iLogID() >= 0 && !Login_info.getInstance().isBanTouShow()) {
            NET_DVR_PICCFG_V30 net_dvr_piccfg_v30 = new NET_DVR_PICCFG_V30();
            HCNetSDK instance = HCNetSDK.getInstance();
            int m_iLogID = All_id_Info.getInstance().getM_iLogID();
            HCNetSDK.getInstance();
            instance.NET_DVR_GetDVRConfig(m_iLogID, 1002, All_id_Info.getInstance().getM_iChanNum(), net_dvr_piccfg_v30);
            byte[] bArr = null;
            try {
                bArr = str.getBytes("gb2312");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (bArr != null) {
                for (int i = 0; i < net_dvr_piccfg_v30.sChanName.length; i++) {
                    if (i < bArr.length) {
                        net_dvr_piccfg_v30.sChanName[i] = bArr[i];
                    } else {
                        net_dvr_piccfg_v30.sChanName[i] = 0;
                    }
                }
                net_dvr_piccfg_v30.dwShowChanName = 1;
                net_dvr_piccfg_v30.wShowNameTopLeftX = 32;
                net_dvr_piccfg_v30.wShowNameTopLeftY = 544;
                boolean z2 = BaseApplication.m4928b().getBoolean("KEY_OSD_IS_SHOW_TIME_ON_DEVICE", false);
                if (!z) {
                    net_dvr_piccfg_v30.dwShowOsd = 0;
                } else if (z2) {
                    net_dvr_piccfg_v30.dwShowOsd = 0;
                } else {
                    net_dvr_piccfg_v30.dwShowOsd = 1;
                }
                net_dvr_piccfg_v30.byFontSize = 1;
                net_dvr_piccfg_v30.wOSDTopLeftX = 512;
                net_dvr_piccfg_v30.wOSDTopLeftY = 544;
            }
            HCNetSDK instance2 = HCNetSDK.getInstance();
            int m_iLogID2 = All_id_Info.getInstance().getM_iLogID();
            HCNetSDK.getInstance();
            if (!instance2.NET_DVR_SetDVRConfig(m_iLogID2, 1003, All_id_Info.getInstance().getM_iChanNum(), net_dvr_piccfg_v30)) {
                C1140n.m5270b("字符叠加标记：e= ", HCNetSDK.getInstance().NET_DVR_GetLastError());
            }
        }
    }


    public static void showWaterList(java.util.List<OsdHkInfo> arg10) {
        String v0_1;
        int v8 = 44;
        if(arg10 != null) {
            int v4 = arg10.size();
            NET_DVR_SHOWSTRING_V30 v5 = new NET_DVR_SHOWSTRING_V30();
            HCNetSDK instance = HCNetSDK.getInstance();
            int m_iLogID = All_id_Info.getInstance().getM_iLogID();
            HCNetSDK.getInstance();
            instance.NET_DVR_GetDVRConfig(m_iLogID, 1030, All_id_Info.getInstance().getM_iChanNum(), v5);
            int v3;
            for(v3 = 0; v3 < 6; ++v3) {
                if(v4 != 0) {
                    try {
                        if(v3 < arg10.size()) {
                            v0_1 = arg10.get(v3).getsString();
                        }
                        else {

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
            int m_iLogID2 = All_id_Info.getInstance().getM_iLogID();
            HCNetSDK v0_3 = HCNetSDK.getInstance();
            HCNetSDK.getInstance();
            if(v0_3.NET_DVR_SetDVRConfig(m_iLogID2, 1031, All_id_Info.getInstance().getM_iChanNum(), v5)) {
                return;
            }

            C1140n.m5269b("字符叠加添加版头：NET_DVR_GET_SHOWSTRING_V30 faild!  err: " + HCNetSDK.getInstance().NET_DVR_GetLastError());
        }
    }
    public static void showWarter(String str, boolean z) {
        if (All_id_Info.getInstance().getM_iLogID() >= 0 && !Login_info.getInstance().isBanTouShow()) {
            NET_DVR_PICCFG_V30 net_dvr_piccfg_v30 = new NET_DVR_PICCFG_V30();
            HCNetSDK instance = HCNetSDK.getInstance();
            int m_iLogID = All_id_Info.getInstance().getM_iLogID();
            HCNetSDK.getInstance();
            instance.NET_DVR_GetDVRConfig(m_iLogID, 1002, All_id_Info.getInstance().getM_iChanNum(), net_dvr_piccfg_v30);
            byte[] bArr = null;
            try {
                bArr = str.getBytes("gb2312");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (bArr != null) {
                for (int i = 0; i < net_dvr_piccfg_v30.sChanName.length; i++) {
                    if (i < bArr.length) {
                        net_dvr_piccfg_v30.sChanName[i] = bArr[i];
                    } else {
                        net_dvr_piccfg_v30.sChanName[i] = 0;
                    }
                }
                net_dvr_piccfg_v30.dwShowChanName = 1;
                net_dvr_piccfg_v30.wShowNameTopLeftX = 32;
                net_dvr_piccfg_v30.wShowNameTopLeftY = 514;
                boolean z2 = BaseApplication.m4928b().getBoolean("KEY_OSD_IS_SHOW_TIME_ON_DEVICE", false);
                if (!z) {
                    net_dvr_piccfg_v30.dwShowOsd = 0;
                } else if (z2) {
                    net_dvr_piccfg_v30.dwShowOsd = 0;
                } else {
                    net_dvr_piccfg_v30.dwShowOsd = 1;
                }
                net_dvr_piccfg_v30.byFontSize = 1;
                net_dvr_piccfg_v30.wOSDTopLeftX = 512;
                net_dvr_piccfg_v30.wOSDTopLeftY = 544;
            }
            HCNetSDK instance2 = HCNetSDK.getInstance();
            int m_iLogID2 = All_id_Info.getInstance().getM_iLogID();
            HCNetSDK.getInstance();
            if (!instance2.NET_DVR_SetDVRConfig(m_iLogID2, 1003, All_id_Info.getInstance().getM_iChanNum(), net_dvr_piccfg_v30)) {
                C1140n.m5270b("字符叠加标记：e= ", HCNetSDK.getInstance().NET_DVR_GetLastError());
            }
        }
    }
    /* renamed from: a */
    public static boolean m5244a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (All_id_Info.getInstance().getM_iLogID() < 0) {
            BaseApplication.m4926a(BaseApplication.m4925a().getString(R.string.no_get));
            return false;
        }
        NET_DVR_TIME net_dvr_time = new NET_DVR_TIME();
        net_dvr_time.dwYear = i;
        net_dvr_time.dwMonth = i2;
        net_dvr_time.dwDay = i3;
        net_dvr_time.dwHour = i4;
        net_dvr_time.dwMinute = i5;
        net_dvr_time.dwSecond = i6;
        HCNetSDK instance = HCNetSDK.getInstance();
        int m_iLogID = All_id_Info.getInstance().getM_iLogID();
        HCNetSDK.getInstance();
        boolean NET_DVR_SetDVRConfig = instance.NET_DVR_SetDVRConfig(m_iLogID, 119, All_id_Info.getInstance().getM_iChanNum(), net_dvr_time);
        if (!NET_DVR_SetDVRConfig) {
            C1140n.m5269b("海康时间设置出错，e = " + HCNetSDK.getInstance().NET_DVR_GetLastError());
            BaseApplication.m4926a(BaseApplication.m4925a().getString(R.string.setFall));
            return NET_DVR_SetDVRConfig;
        }
        BaseApplication.m4926a(BaseApplication.m4925a().getString(R.string.setSuccess));
        return NET_DVR_SetDVRConfig;
    }

    /* renamed from: a */
    private static boolean m5245a(NET_DVR_CAMERAPARAMCFG_EX net_dvr_cameraparamcfg_ex) {
        return HCNetSDK.getInstance().NET_DVR_SetDVRConfig(All_id_Info.getInstance().getM_iLogID(), HCNetSDK.NET_DVR_SET_CCDPARAMCFG_EX, All_id_Info.getInstance().getM_iChanNum(), net_dvr_cameraparamcfg_ex);
    }

    /* renamed from: a */
    public static boolean m5246a(boolean z) {
        NET_DVR_CAMERAPARAMCFG_EX b;
        if (All_id_Info.getInstance().getM_iLogID() < 0 || (b = m5247b()) == null) {
            return false;
        }
        NET_DVR_WDR net_dvr_wdr = b.struWdr;
        if (z) {
            net_dvr_wdr.byWDREnabled = 1;
            net_dvr_wdr.byWDRLevel1 = 50;
        } else {
            net_dvr_wdr.byWDREnabled = 0;
            net_dvr_wdr.byWDRLevel1 = 0;
        }
        b.struWdr = net_dvr_wdr;
        return m5245a(b);
    }

    /* renamed from: b */
    private static NET_DVR_CAMERAPARAMCFG_EX m5247b() {
        boolean z;
        All_id_Info instance = All_id_Info.getInstance();
        NET_DVR_CAMERAPARAMCFG_EX net_dvr_cameraparamcfg_ex = new NET_DVR_CAMERAPARAMCFG_EX();
        try {
            z = HCNetSDK.getInstance().NET_DVR_GetDVRConfig(instance.getM_iLogID(), HCNetSDK.NET_DVR_GET_CCDPARAMCFG_EX, instance.getM_iChanNum(), net_dvr_cameraparamcfg_ex);
        } catch (Exception e) {
            C1140n.m5269b("Exception e = " + e.toString());
            z = false;
        }
        if (z) {
            return net_dvr_cameraparamcfg_ex;
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m5248b(boolean z) {
        boolean z2;
        All_id_Info instance = All_id_Info.getInstance();
        if (instance.getM_iLogID() < 0) {
            return false;
        }
        HCNetSDKByJNA instance2 = HCNetSDKJNAInstance.getInstance();
        HCNetSDKByJNA.NET_DVR_FOCUSMODE_CFG net_dvr_focusmode_cfg = new HCNetSDKByJNA.NET_DVR_FOCUSMODE_CFG();
        IntByReference intByReference = new IntByReference();
        intByReference.setValue(76);
        boolean NET_DVR_GetDVRConfig = instance2.NET_DVR_GetDVRConfig(instance.getM_iLogID(), HCNetSDKByJNA.NET_DVR_GET_FOCUSMODECFG, instance.getM_iChanNum(), net_dvr_focusmode_cfg.getPointer(), 76, intByReference);
        net_dvr_focusmode_cfg.read();
        C1140n.m5266a("digtital = " + net_dvr_focusmode_cfg.byDigtitalZoom + " size " + net_dvr_focusmode_cfg.dwSize);
        if (z) {
            net_dvr_focusmode_cfg.byDigtitalZoom = 8;
        } else {
            net_dvr_focusmode_cfg.byDigtitalZoom = 1;
        }
        if (!NET_DVR_GetDVRConfig) {
            return false;
        }
        if (NET_DVR_GetDVRConfig) {
            net_dvr_focusmode_cfg.write();
            net_dvr_focusmode_cfg.setAutoWrite(true);
            C1140n.m5266a("digtital = " + net_dvr_focusmode_cfg.byDigtitalZoom);
            z2 = instance2.NET_DVR_SetDVRConfig(instance.getM_iLogID(), HCNetSDKByJNA.NET_DVR_SET_FOCUSMODECFG, instance.getM_iChanNum(), net_dvr_focusmode_cfg.getPointer(), net_dvr_focusmode_cfg.dwSize);
            net_dvr_focusmode_cfg.write();
        } else {
            z2 = false;
        }
        C1140n.m5266a("digtital = " + net_dvr_focusmode_cfg.byDigtitalZoom);
        return z2;
    }
}
