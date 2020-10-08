package com.peek.camera.p032a.p033a;
import android.util.Log;

import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_JPEGPARA;
import com.hikvision.netsdk.RealPlayCallBack;
import com.peek.camera.BaseApplication;
import com.peek.camera.R;
import com.peek.camera.jna.SystemTransformByJNA;
import com.peek.camera.jna.SystemTransformJNAInstance;
import com.peek.camera.model.All_id_Info;
import com.peek.camera.model.FileInfo;
import com.peek.camera.model.Login_info;
import com.peek.camera.p032a.C1102g;
import com.peek.camera.p034b.C1129g;
import com.peek.camera.p034b.C1140n;
import com.peek.camera.p034b.C1141o;
import com.peek.camera.view.p039c.C1237b;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.MediaPlayer.PlayM4.Constants;
import org.MediaPlayer.PlayM4.Player;

/* renamed from: com.bmw.peek2.a.a.g */
public class C1084g implements C1102g {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1237b f3009a;

    /* renamed from: b */
    private boolean f3010b;

    /* renamed from: c */
    private SystemTransformByJNA.SYS_TRANS_PARA f3011c;

    /* renamed from: d */
    private boolean f3012d;

    /* renamed from: e */
    private String f3013e;

    public C1084g(C1237b bVar) {
        this.f3009a = bVar;
        C1129g.m5232b();
        C1129g.m5235c();
        mo4571c();
    }

    /* renamed from: a */
    private void m5072a(String str, String str2) {
        m5077d(str);
        m5074b(str2);
    }

    /* renamed from: a */
    private void m5073a(boolean z) {
        if (this.f3009a != null) {
            this.f3009a.mo5116a(1, z, (String) null);
        }
        this.f3010b = false;
    }

    /* renamed from: b */
    private void m5074b(String str) {
        if (this.f3009a != null) {
            this.f3009a.mo5116a(0, true, this.f3013e);
        }
        this.f3010b = true;
        if (str == null) {
            Login_info.isPause = false;
        } else {
            m5075c(str);
        }
    }

    /* renamed from: c */
    private void m5075c(final String str) {
        new Thread(new Runnable() {
            public void run() {
                File file = new File(str + "_index");
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)));
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(Integer.valueOf(readLine));
                    }
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (C1084g.this.f3009a != null) {
                            C1084g.this.f3009a.mo5121s();
                        }
                        byte[] bArr = new byte[((Integer) arrayList.get(i)).intValue()];
                        bufferedInputStream.read(bArr);
                        SystemTransformJNAInstance.getInstance().SYSTRANS_InputData(SystemTransformByJNA.handle.getValue(), 0, bArr, bArr.length);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                if (C1084g.this.f3009a != null) {
                    C1084g.this.f3009a.mo5122t();
                }
                HCNetSDK.getInstance().NET_DVR_MakeKeyFrame(All_id_Info.getInstance().getM_iLogID(), All_id_Info.getInstance().getM_iChanNum());
                Login_info.isPause = false;
            }
        }).start();
    }

    /* renamed from: d */
    private void m5076d() {
        Login_info.isPause = true;
        int NET_DVR_RealPlay_V40 = BaseApplication.m4928b().getInt("NET_DVR_RealPlay_V40",0);
     boolean SYSTRANS_Stop=   HCNetSDK.getInstance().NET_DVR_StopSaveRealData (NET_DVR_RealPlay_V40);
//        int SYSTRANS_Stop = SystemTransformJNAInstance.getInstance().SYSTRANS_Stop(SystemTransformByJNA.handle.getValue());
//        int SYSTRANS_Release = SystemTransformJNAInstance.getInstance().SYSTRANS_Release(SystemTransformByJNA.handle.getValue());
        if (SYSTRANS_Stop) {
            m5073a(true);
        } else {
            m5073a(false);
        }
        C1129g.m5227a(this.f3013e);
    }

    /* renamed from: d */
    private void m5077d(String str) {
//        int NET_DVR_RealPlay_V40 = HCNetSDK.getInstance().NET_DVR_RealPlay_V40(m_iLogID, net_dvr_previewinfo, (RealPlayCallBack) null);
        int NET_DVR_RealPlay_V40 = BaseApplication.m4928b().getInt("NET_DVR_RealPlay_V40",0);
        HCNetSDK.getInstance().NET_DVR_SaveRealData(NET_DVR_RealPlay_V40,str);
//        if (SystemTransformJNAInstance.getInstance().SYSTRANS_Create(SystemTransformByJNA.handle, this.f3011c) != 0) {
//            m5078e();
//        } else if (SystemTransformJNAInstance.getInstance().SYSTRANS_Start(SystemTransformByJNA.handle.getValue(), (String) null, str) != 0) {
//            m5078e();
//        }
    }

    /* renamed from: e */
    private void m5078e() {
        C1140n.m5270b("海康：抓拍：开始录制失败：", HCNetSDK.getInstance().NET_DVR_GetLastError());
        if (this.f3009a != null) {
            this.f3009a.mo5116a(0, false, (String) null);
        }
    }

    /* renamed from: a */
    public void mo4567a(String str) {
        int m_iPort = All_id_Info.getInstance().getM_iPort();
        if (m_iPort < 0) {
            C1140n.m5271b("海康：抓拍：截图失败，未登录！", "");
            this.f3009a.mo5117d(BaseApplication.m4925a().getString(R.string.captureFall));
            return;
        }
        File file = new File(str + FileInfo.EXTEND_JPG);
        if (file.exists()) {
            File file2 = file;
            int i = 0;
            while (file2.exists()) {
                i++;
                file2 = new File(str + "_" + i + FileInfo.EXTEND_JPG);
            }
            str = str + "_" + i;
        }

        final String str2 = str + FileInfo.EXTEND_JPG;
        if (Login_info.getInstance().isYingJieMa()) {
            NET_DVR_JPEGPARA net_dvr_jpegpara = new NET_DVR_JPEGPARA();
            net_dvr_jpegpara.wPicQuality = 0;
            net_dvr_jpegpara.wPicSize = 0;
            HCNetSDK.getInstance().NET_DVR_CaptureJPEGPicture(All_id_Info.getInstance().getM_iLogID(), All_id_Info.getInstance().getM_iChanNum(), net_dvr_jpegpara, str2);
            this.f3009a.mo5118e(str2);
            C1129g.m5227a(str2);
            return;
        }
        Player.MPInteger mPInteger = new Player.MPInteger();
        Player.MPInteger mPInteger2 = new Player.MPInteger();
        if (!Player.getInstance().getPictureSize(m_iPort, mPInteger, mPInteger2)) {
            C1140n.m5270b("海康：抓拍：截图失败，getPictureSize failed with error code:", Player.getInstance().getLastError(m_iPort));
            return;
        }
        int i2 = mPInteger.value * 5 * mPInteger2.value;
        final byte[] bArr = new byte[i2];
        final Player.MPInteger mPInteger3 = new Player.MPInteger();
        if (!Player.getInstance().getJPEG(m_iPort, bArr, i2, mPInteger3)) {
            C1140n.m5270b("海康：抓拍：截图失败，未登录！getBMP failed with error code:", Player.getInstance().getLastError(m_iPort));
        } else {
            new Thread(new Runnable() {
                public void run() {
                    try {

                        FileOutputStream fileOutputStream = new FileOutputStream(str2);
                        fileOutputStream.write(bArr, 0, mPInteger3.value);
                        fileOutputStream.close();
                        C1084g.this.f3009a.mo5118e(str2);
                        C1129g.m5227a(str2);
                    } catch (Exception e) {
                        C1140n.m5271b("海康：抓拍：截图失败:", e.toString());
                    }
                }
            }).start();
        }
    }

    /* renamed from: a */
    public void mo4568a(String str, boolean z, String str2) {
        String endM ;
        if (BaseApplication.m4928b().getInt("avi_mp4",0) == 0){
            endM = ".avi";
        }else {
            endM = ".mp4";
        }
        String str3;
        int i = 0;
        this.f3012d = z;
        int m_iPlayID = All_id_Info.getInstance().getM_iPlayID();
        if (!this.f3010b && m_iPlayID < 0 && !Login_info.getInstance().isYingJieMa()) {
            BaseApplication.m4926a(BaseApplication.m4925a().getString(R.string.mainFrameNoConnect));
        } else if (!this.f3010b) {
            if (C1141o.m5272a().mo4667c()) {
                C1140n.m5266a("自定义接口录像！");
                if (z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(C1129g.m5220a());
                    sb.append(Login_info.local_kanban_path);
                    String d = BaseApplication.m4925a().mo4484d();
                    File file = new File(sb.toString() + d);
                    if (file.exists()) {
                        while (file.exists()) {
                            i++;
                            file = new File(sb.toString() + d + "_" + i);
                        }
                        str3 = d + "_" + i;
                        BaseApplication.m4925a().mo4481b(str3);
                    } else {
                        str3 = d;
                    }
                    sb.append(str3);
                    sb.append(endM);
                    this.f3013e = sb.toString();
                    m5077d(sb.toString());
                    Login_info.isAddKanban = true;
                    m5074b((String) null);
                    return;
                }
                File file2 = new File(str + endM);
                if (file2.exists()) {
                    while (file2.exists()) {
                        i++;
                        file2 = new File(str + "_" + i + endM);
                    }
                    str = str + "_" + i;
                }
                String str4 = str + endM;
                this.f3013e = str4;
                m5072a(str4, str2);
            } else if (this.f3009a != null) {
                this.f3009a.mo5116a(0, false, (String) null);
            }
        } else if (z) {
            Login_info.isAddKanban = false;
            m5076d();
        } else {
            m5076d();
        }
    }

    /* renamed from: a */
    public boolean mo4569a() {
        return this.f3010b;
    }

    /* renamed from: b */
    public void mo4570b() {
        int NET_DVR_RealPlay_V40 = BaseApplication.m4928b().getInt("NET_DVR_RealPlay_V40",0);
        HCNetSDK.getInstance().NET_DVR_StopSaveRealData (NET_DVR_RealPlay_V40);
//        SystemTransformJNAInstance.getInstance().SYSTRANS_Stop(SystemTransformByJNA.handle.getValue());
//        SystemTransformJNAInstance.getInstance().SYSTRANS_Release(SystemTransformByJNA.handle.getValue());
        if (this.f3010b) {
            C1140n.m5268a("海康：抓拍：视图退出，停止录像", "");
            mo4568a((String) null, this.f3012d, (String) null);
        }
    }

    /* renamed from: c */
    public void mo4571c() {
        this.f3011c = new SystemTransformByJNA.SYS_TRANS_PARA();
        this.f3011c.dwSrcInfoLen = 40;
        this.f3011c.dwTgtPackSize = Constants.AUDIO_MPEG;
        this.f3011c.dwSrcDemuxSize = 0;
        this.f3011c.enTgtType = 7;
        SystemTransformByJNA.PLAYSDK_MEDIA_INFO.ByReference byReference = SystemTransformByJNA.media_info;
        byReference.media_fourcc = Constants.FOURCC_HKMI;
        byReference.media_version = 257;
        byReference.device_id = 0;
        byReference.audio_bits_per_sample = 16;
        byReference.audio_bitrate = 8000;
        byReference.system_format = 4;
        byReference.video_format = 256;
        byReference.audio_format = 4096;
        byReference.audio_channels = 0;
        byReference.audio_samplesrate = 0;
        byReference.write();
        this.f3011c.pSrcInfo = byReference;
        this.f3011c.write();
    }
}
