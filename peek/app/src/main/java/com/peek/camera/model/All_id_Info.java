package com.peek.camera.model;

import com.hikvision.netsdk.NET_DVR_DEVICEINFO_V30;

public class All_id_Info {
    private static All_id_Info instance = null;
    private boolean isWifiConnectRunning;
    private int m_iChanNum = -1;
    private int m_iLogID = -1;
    private int m_iPlayID = -1;
    private int m_iPort = -1;
    private int m_iStartChan = -1;
    private NET_DVR_DEVICEINFO_V30 m_oNetDvrDeviceInfoV30;
    private int multi_chan_num = -1;

    private All_id_Info() {
    }

    public static All_id_Info getInstance() {
        if (instance == null) {
            synchronized (All_id_Info.class) {
                if (instance == null) {
                    instance = new All_id_Info();
                }
            }
        }
        return instance;
    }

    public int getM_iChanNum() {
        return this.m_iChanNum;
    }

    public int getM_iLogID() {
        return this.m_iLogID;
    }

    public int getM_iPlayID() {
        return this.m_iPlayID;
    }

    public int getM_iPort() {
        return this.m_iPort;
    }

    public int getM_iStartChan() {
        return this.m_iStartChan;
    }

    public NET_DVR_DEVICEINFO_V30 getM_oNetDvrDeviceInfoV30() {
        return this.m_oNetDvrDeviceInfoV30;
    }

    public int getMulti_chan_num() {
        return this.multi_chan_num;
    }

    public boolean isWifiConnectRunning() {
        return this.isWifiConnectRunning;
    }

    public void resetData() {
        this.m_iPlayID = -1;
        this.m_iLogID = -1;
        this.m_oNetDvrDeviceInfoV30 = null;
        this.m_iStartChan = -1;
        this.m_iChanNum = -1;
        this.m_iPort = -1;
        this.multi_chan_num = -1;
    }

    public void setM_iChanNum(int i) {
        this.m_iChanNum = i;
    }

    public void setM_iLogID(int i) {
        this.m_iLogID = i;
    }

    public void setM_iPlayID(int i) {
        this.m_iPlayID = i;
    }

    public void setM_iPort(int i) {
        this.m_iPort = i;
    }

    public void setM_iStartChan(int i) {
        this.m_iStartChan = i;
    }

    public void setM_oNetDvrDeviceInfoV30(NET_DVR_DEVICEINFO_V30 net_dvr_deviceinfo_v30) {
        if (net_dvr_deviceinfo_v30.byChanNum > 0) {
            this.m_iStartChan = net_dvr_deviceinfo_v30.byStartChan;
            this.m_iChanNum = net_dvr_deviceinfo_v30.byChanNum;
        } else if (net_dvr_deviceinfo_v30.byIPChanNum > 0) {
            this.m_iStartChan = net_dvr_deviceinfo_v30.byStartDChan;
            this.m_iChanNum = net_dvr_deviceinfo_v30.byIPChanNum + (net_dvr_deviceinfo_v30.byHighDChanNum * 256);
        }
        this.m_oNetDvrDeviceInfoV30 = net_dvr_deviceinfo_v30;
    }

    public void setMulti_chan_num(int i) {
        this.multi_chan_num = i;
    }

    public void setWifiConnectRunning(boolean z) {
        this.isWifiConnectRunning = z;
    }
}
