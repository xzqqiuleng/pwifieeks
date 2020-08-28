package com.peek.camera.jna;
import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_LOG_TYPE;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import java.util.Arrays;
import java.util.List;

public interface HCNetSDKByJNA extends Library {
    public static final int ACCOUNTNUM_LEN = 6;
    public static final int ACCOUNTNUM_LEN_32 = 32;
    public static final int ACS_CARD_NO_LEN = 32;
    public static final int ALARMHOST_MAX_SIREN_NUM = 8;
    public static final int CARD_PASSWORD_LEN = 8;
    public static final int COMM_ALARM_RULE = 4354;
    public static final int COMM_ALARM_V30 = 16384;
    public static final int COMM_ALARM_V40 = 16391;
    public static final int COMM_ITS_PLATE_RESULT = 12368;
    public static final int COMM_UPLOAD_PLATE_RESULT = 10240;
    public static final int ENUM_VCA_EVENT_ADV_REACH_HEIGHT = 22;
    public static final int ENUM_VCA_EVENT_ADV_TRAVERSE_PLANE = 25;
    public static final int ENUM_VCA_EVENT_AUDIO_ABNORMAL = 21;
    public static final int ENUM_VCA_EVENT_COMBINED_RULE = 37;
    public static final int ENUM_VCA_EVENT_ENTER_AREA = 2;
    public static final int ENUM_VCA_EVENT_EXIT_AREA = 3;
    public static final int ENUM_VCA_EVENT_FALL_DOWN = 20;
    public static final int ENUM_VCA_EVENT_GET_UP = 12;
    public static final int ENUM_VCA_EVENT_HIGH_DENSITY = 9;
    public static final int ENUM_VCA_EVENT_HIGH_DENSITY_STATUS = 39;
    public static final int ENUM_VCA_EVENT_HUMAN_ENTER = 29;
    public static final int ENUM_VCA_EVENT_INSTALL_SCANNER = 32;
    public static final int ENUM_VCA_EVENT_INTRUSION = 4;
    public static final int ENUM_VCA_EVENT_KEY_PERSON_GET_UP = 17;
    public static final int ENUM_VCA_EVENT_LEAVE_POSITION = 15;
    public static final int ENUM_VCA_EVENT_LEFT = 13;
    public static final int ENUM_VCA_EVENT_LEFT_TAKE = 6;
    public static final int ENUM_VCA_EVENT_LOITER = 5;
    public static final int ENUM_VCA_EVENT_OVER_TIME = 30;
    public static final int ENUM_VCA_EVENT_PARKING = 7;
    public static final int ENUM_VCA_EVENT_PEOPLENUM_CHANGE = 35;
    public static final int ENUM_VCA_EVENT_REACH_HIGHT = 11;
    public static final int ENUM_VCA_EVENT_RUN = 8;
    public static final int ENUM_VCA_EVENT_SIT_QUIETLY = 38;
    public static final int ENUM_VCA_EVENT_SPACING_CHANGE = 36;
    public static final int ENUM_VCA_EVENT_STANDUP = 18;
    public static final int ENUM_VCA_EVENT_STICK_UP = 31;
    public static final int ENUM_VCA_EVENT_TAKE = 14;
    public static final int ENUM_VCA_EVENT_TOILET_TARRY = 23;
    public static final int ENUM_VCA_EVENT_TRAIL = 16;
    public static final int ENUM_VCA_EVENT_TRAVERSE_PLANE = 1;
    public static final int ENUM_VCA_EVENT_VIOLENT_MOTION = 10;
    public static final int ENUM_VCA_EVENT_YARD_TARRY = 24;
    public static final int EZVIZ_ACCESSTOKEN_LEN = 128;
    public static final int EZVIZ_APPID_LEN = 64;
    public static final int EZVIZ_CLIENTTYPE_LEN = 32;
    public static final int EZVIZ_DEVICEID_LEN = 32;
    public static final int EZVIZ_FEATURECODE_LEN = 64;
    public static final int EZVIZ_NETTYPE_LEN = 32;
    public static final int EZVIZ_OSVERSION_LEN = 32;
    public static final int EZVIZ_REQURL_LEN = 64;
    public static final int EZVIZ_SDKVERSION_LEN = 32;
    public static final int MACADDR_LEN = 6;
    public static final int MAX_ALARMIN = 16;
    public static final int MAX_ALARMIN_V30 = 160;
    public static final int MAX_ALARMOUT = 4;
    public static final int MAX_ALARMOUT_V30 = 96;
    public static final int MAX_ANALOG_ALARMIN = 32;
    public static final int MAX_ANALOG_ALARMOUT = 32;
    public static final int MAX_ANALOG_CHANNUM = 32;
    public static final int MAX_CARD_RIGHT_PLAN_NUM = 4;
    public static final int MAX_CHANNUM = 16;
    public static final int MAX_CHANNUM_V30 = 64;
    public static final int MAX_DETECTOR_NUM = 128;
    public static final int MAX_DISKNUM = 16;
    public static final int MAX_DISKNUM_V30 = 33;
    public static final int MAX_DOOR_NUM = 32;
    public static final int MAX_IP_ALARMIN = 128;
    public static final int MAX_IP_ALARMOUT = 64;
    public static final int MAX_IP_CHANNEL = 32;
    public static final int MAX_IP_DEVICE = 32;
    public static final int MAX_LICENSE_LEN = 16;
    public static final int MAX_NUM_OUTPUT_CHANNEL = 512;
    public static final int MAX_REGION_NUM = 8;
    public static final int MAX_SUBSYSTEM_ID_LEN = 16;
    public static final int NAME_LEN = 32;
    public static final int NET_DVR_DEV_ADDRESS_MAX_LEN = 129;
    public static final int NET_DVR_GET_ALARMHOSTSUBSYSTEM_CFG = 2001;
    public static final int NET_DVR_GET_ALARMHOST_OTHER_STATUS_V50 = 2228;
    public static final int NET_DVR_GET_CARD_CFG = 2116;
    public static final int NET_DVR_GET_FOCUSMODECFG = 3305;
    public static final int NET_DVR_GET_LED_AREA_INFO_LIST = 9295;
    public static final int NET_DVR_GET_LOITERING_DETECTION = 3521;
    public static final int NET_DVR_GET_MULTI_STREAM_COMPRESSIONCFG = 3216;
    public static final int NET_DVR_GET_TIMECFG = 118;
    public static final int NET_DVR_LOGIN_PASSWD_MAX_LEN = 64;
    public static final int NET_DVR_LOGIN_USERNAME_MAX_LEN = 64;
    public static final int NET_DVR_MATRIX_GETWINSTATUS = 9009;
    public static final int NET_DVR_SET_ALARMHOSTSUBSYSTEM_CFG = 2002;
    public static final int NET_DVR_SET_FOCUSMODECFG = 3306;
    public static final int NET_DVR_SET_LOITERING_DETECTION = 3522;
    public static final int NET_DVR_SET_MULTI_STREAM_COMPRESSIONCFG = 3217;
    public static final int NET_DVR_SET_TIMECFG = 119;
    public static final int NET_DVR_START_GET_INPUTVOLUME = 3370;
    public static final int NET_SDK_CALLBACK_TYPE_DATA = 2;
    public static final int NET_SDK_CALLBACK_TYPE_PROGRESS = 1;
    public static final int NET_SDK_CALLBACK_TYPE_STATUS = 0;
    public static final int SERIALNO_LEN = 48;
    public static final int STREAM_ID_LEN = 32;
    public static final int VCA_MAX_POLYGON_POINT_NUM = 10;

    public static class BYTE_ARRAY extends Structure {
        public byte[] byValue;

        public BYTE_ARRAY(int i) {
            this.byValue = new byte[i];
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"byValue"});
        }
    }

    public interface FLoginResultCallBack extends Callback {
        int invoke(int i, int i2, NET_DVR_DEVICEINFO_V30 net_dvr_deviceinfo_v30, Pointer pointer);
    }

    public interface FMSGCallBack extends Callback {
        void invoke(int i, NET_DVR_ALARMER net_dvr_alarmer, Pointer pointer, int i2, Pointer pointer2);
    }

    public static class INT_ARRAY extends Structure {
        public int[] iValue;

        public INT_ARRAY(int i) {
            this.iValue = new int[i];
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"iValue"});
        }
    }

    public static class NET_DVR_ALARMER extends Structure {
        public byte byDeviceIPValid;
        public byte byDeviceNameValid;
        public byte byIpProtocol;
        public byte byLinkPortValid;
        public byte[] byMacAddr = new byte[6];
        public byte byMacAddrValid;
        public byte[] byRes2 = new byte[11];
        public byte bySerialValid;
        public byte bySocketIPValid;
        public byte byUserIDValid;
        public byte byVersionValid;
        public int dwDeviceVersion;
        public int lUserID;
        public byte[] sDeviceIP = new byte[128];
        public byte[] sDeviceName = new byte[32];
        public byte[] sSerialNumber = new byte[48];
        public byte[] sSocketIP = new byte[128];
        public short wLinkPort;

        /* access modifiers changed from: protected */
        public List getFieldOrder() {
            return Arrays.asList(new String[]{"byUserIDValid", "bySerialValid", "byVersionValid", "byDeviceNameValid", "byMacAddrValid", "byLinkPortValid", "byDeviceIPValid", "bySocketIPValid", "lUserID", "sSerialNumber", "dwDeviceVersion", "sDeviceName", "byMacAddr", "wLinkPort", "sDeviceIP", "sSocketIP", "byIpProtocol", "byRes2"});
        }
    }

    public static class NET_DVR_ALARMHOST_OTHER_STATUS_V50 extends Structure {
        public byte[] byDetetorConnection = new byte[128];
        public byte[] byDetetorPower = new byte[128];
        public byte[] byRes = new byte[1024];
        public byte[] bySirenStatus = new byte[8];
        public int dwSize;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "bySirenStatus", "byDetetorPower", "byDetetorConnection", "byRes"});
        }
    }

    public static class NET_DVR_ALARMINFO extends Structure {
        public int dwAlarmInputNumber;
        public int[] dwAlarmOutputNumber = new int[4];
        public int[] dwAlarmRelateChannel = new int[16];
        public int dwAlarmType;
        public int[] dwChannel = new int[16];
        public int[] dwDiskNumber = new int[16];

        /* access modifiers changed from: protected */
        public List getFieldOrder() {
            return Arrays.asList(new String[]{"dwAlarmType", "dwAlarmInputNumber", "dwAlarmOutputNumber", "dwAlarmRelateChannel", "dwChannel", "dwDiskNumber"});
        }
    }

    public static class NET_DVR_ALARMINFO_V30 extends Structure {
        public byte[] byAlarmOutputNumber = new byte[96];
        public byte[] byAlarmRelateChannel = new byte[64];
        public byte[] byChannel = new byte[64];
        public byte[] byDiskNumber = new byte[33];
        public int dwAlarmInputNumber;
        public int dwAlarmType;

        public NET_DVR_ALARMINFO_V30(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List getFieldOrder() {
            return Arrays.asList(new String[]{"dwAlarmType", "dwAlarmInputNumber", "byAlarmOutputNumber", "byAlarmRelateChannel", "byChannel", "byDiskNumber"});
        }
    }

    public static class NET_DVR_ALARMINFO_V40 extends Structure {
        public Pointer pAlarmData;
        public NET_DVR_ALRAM_FIXED_HEADER struAlarmFixedHeader = new NET_DVR_ALRAM_FIXED_HEADER();

        public NET_DVR_ALARMINFO_V40(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struAlarmFixedHeader", "pAlarmData"});
        }
    }

    public static class NET_DVR_ALARMSUBSYSTEMPARAM extends Structure {
        public byte byCenterType;
        public byte byEnableAlarmInDelay;
        public byte byHostageReport;
        public byte byKeyToneOfArmOrDisarm;
        public byte byKeyToneOfManualTestReport;
        public byte byKeyZoneArm;
        public byte byKeyZoneArmEnable;
        public byte byKeyZoneArmReport;
        public byte byKeyZoneArmReportEnable;
        public byte byKeyZoneDisarm;
        public byte byKeyZoneDisarmReport;
        public byte byOneKeySetupAlarmEnable;
        public byte byPublicAttributeEnable;
        public byte[] byRes2 = new byte[565];
        public byte bySingleZoneSetupAlarmEnable;
        public byte[] bySubSystemID = new byte[16];
        public byte bySubsystemEnable;
        public int dwSize;
        public byte[] sCenterAccount = new byte[6];
        public byte[] sCenterAccountV40 = new byte[32];
        public NET_DVR_JOINT_SUB_SYSTEM struJointSubSystem = new NET_DVR_JOINT_SUB_SYSTEM();
        public short wDelayTime;
        public short wEnterDelay;
        public short wExitDelay;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "wEnterDelay", "wExitDelay", "byHostageReport", "bySubsystemEnable", "byKeyToneOfArmOrDisarm", "byKeyToneOfManualTestReport", "wDelayTime", "byEnableAlarmInDelay", "byPublicAttributeEnable", "struJointSubSystem", "byKeyZoneArm", "byKeyZoneArmReport", "byKeyZoneDisarm", "byKeyZoneDisarmReport", "bySubSystemID", "byKeyZoneArmReportEnable", "byKeyZoneArmEnable", "byOneKeySetupAlarmEnable", "bySingleZoneSetupAlarmEnable", "byCenterType", "sCenterAccount", "sCenterAccountV40", "byRes2"});
        }
    }

    public static class NET_DVR_ALRAM_FIXED_HEADER extends Structure {
        public int dwAlarmType;
        public NET_DVR_TIME_EX struAlarmTime = new NET_DVR_TIME_EX();
        public uStruAlarm ustruAlarm = new uStruAlarm();

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwAlarmType", "struAlarmTime", "ustruAlarm"});
        }
    }

    public static class NET_DVR_CALL_ROOM_CFG extends Structure {
        public byte byManageCenter;
        public byte[] byRes = new byte[NET_DVR_LOG_TYPE.MINOR_REMOTE_PLAYBYFILE];
        public int dwSize;
        public short nFloorNumber;
        public short wRoomNumber;

        /* access modifiers changed from: protected */
        public List getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "nFloorNumber", "wRoomNumber", "byManageCenter", "byRes"});
        }
    }

    public static class NET_DVR_CARD_CFG extends Structure {
        public byte[] byCardNo = new byte[32];
        public byte[] byCardPassword = new byte[8];
        public arrayCardRightPlan[] byCardRightPlan = new arrayCardRightPlan[32];
        public byte byCardType;
        public byte byCardValid;
        public byte byLeaderCard;
        public byte byRes1;
        public byte[] byRes2 = new byte[20];
        public int dwBelongGroup;
        public int dwDoorRight;
        public int dwMaxSwipeTime;
        public int dwModifyParamType;
        public int dwSize;
        public int dwSwipeTime;
        public NET_DVR_VALID_PERIOD_CFG struValid = new NET_DVR_VALID_PERIOD_CFG();
        public short wFloorNumber;
        public short wRoomNumber;

        public NET_DVR_CARD_CFG(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "dwModifyParamType", "byCardNo", "byCardValid", "byCardType", "byLeaderCard", "byRes1", "dwDoorRight", "struValid", "dwBelongGroup", "byCardPassword", "byCardRightPlan", "dwMaxSwipeTime", "dwSwipeTime", "wRoomNumber", "wFloorNumber", "byRes2"});
        }
    }

    public static class NET_DVR_CARD_CFG_COND extends Structure {
        public byte byCheckCardNo;
        public byte[] byRes = new byte[31];
        public int dwCardNum;
        public int dwSize;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "dwCardNum", "byCheckCardNo", "byRes"});
        }
    }

    public static class NET_DVR_COMPRESSION_INFO_V30 extends Structure {
        public byte byAudioEncType;
        public byte byBitrateType;
        public byte byENumber;
        public byte byIntervalBPFrame;
        public byte byPicQuality;
        public byte byResolution;
        public byte byStreamType;
        public byte byVideoEncType;
        public byte[] byres = new byte[10];
        public int dwVideoBitrate;
        public int dwVideoFrameRate;
        public short wIntervalFrameI;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"byStreamType", "byResolution", "byBitrateType", "byPicQuality", "dwVideoBitrate", "dwVideoFrameRate", "wIntervalFrameI", "byIntervalBPFrame", "byENumber", "byVideoEncType", "byAudioEncType", "byres"});
        }
    }

    public static class NET_DVR_DEVICEINFO_V30 extends Structure {
        public byte byAlarmInPortNum;
        public byte byAlarmOutPortNum;
        public byte byAudioChanNum;
        public byte byChanNum;
        public byte byDVRType;
        public byte byDiskNum;
        public byte byIPChanNum;
        public byte[] byRes1 = new byte[24];
        public byte byStartChan;
        public byte[] sSerialNumber = new byte[48];

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"sSerialNumber", "byAlarmInPortNum", "byAlarmOutPortNum", "byDiskNum", "byDVRType", "byChanNum", "byStartChan", "byAudioChanNum", "byIPChanNum", "byRes1"});
        }
    }

    public static class NET_DVR_DEVICEINFO_V40 extends Structure {
        public byte byCharEncodeType;
        public byte byPasswordLevel;
        public byte byRes1;
        public byte[] byRes2 = new byte[HCNetSDK.STEP_SEARCH];
        public byte byRetryLoginTime;
        public byte bySupportLock;
        public int dwSurplusLockTime;
        public NET_DVR_DEVICEINFO_V30 struDeviceV30;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struDeviceV30", "bySupportLock", "byRetryLoginTime", "byPasswordLevel", "byRes1", "dwSurplusLockTime", "byCharEncodeType", "byRes2"});
        }
    }

    public static class NET_DVR_FOCUSMODE_CFG extends Structure {
        public byte byAutoFocusMode;
        public byte byDigtitalZoom;
        public byte byFocusMode;
        public byte byFocusSpeedLevel;
        public byte byOpticalZoom;
        public byte[] byRes = new byte[56];
        public byte byZoomSpeedLevel;
        public int dwFocusPos;
        public int dwSize;
        public float fOpticalZoomLevel;
        public short wMinFocusDistance;

        public static class ByReference extends NET_DVR_FOCUSMODE_CFG implements Structure.ByReference {
        }

        public static class ByValue extends NET_DVR_FOCUSMODE_CFG implements Structure.ByValue {
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "byFocusMode", "byAutoFocusMode", "wMinFocusDistance", "byZoomSpeedLevel", "byFocusSpeedLevel", "byOpticalZoom", "byDigtitalZoom", "fOpticalZoomLevel", "dwFocusPos", "byRes"});
        }
    }

    public static class NET_DVR_INPUTVOLUME extends Structure {
        public byte byAudioInputChan;
        public byte[] byRes = new byte[63];
        public int dwSize;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "byAudioInputChan", "byRes"});
        }
    }

    public static class NET_DVR_IPADDR extends Structure {
        public byte[] byRes = new byte[128];
        public byte[] sIpV4 = new byte[16];

        /* access modifiers changed from: protected */
        public List getFieldOrder() {
            return Arrays.asList(new String[]{"sIpV4", "byRes"});
        }

        public String toString() {
            return "NET_DVR_IPADDR.sIpV4: " + new String(this.sIpV4) + "\nNET_DVR_IPADDR.byRes: " + new String(this.byRes) + "\n";
        }
    }

    public static class NET_DVR_JOINT_SUB_SYSTEM extends Union {
        public byte[] byRes = new byte[20];
        public NET_DVR_NOAMAL_SUB_SYSTEM struNormalSubSystem = new NET_DVR_NOAMAL_SUB_SYSTEM();
        public NET_DVR_PUBLIC_SUB_SYSTEM struPublicSubSystem = new NET_DVR_PUBLIC_SUB_SYSTEM();

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struNormalSubSystem", "struPublicSubSystem", "byRes"});
        }
    }

    public static class NET_DVR_LED_AREA_COND extends Structure {
        public byte[] byRes = new byte[32];
        public int dwLEDAreaNo;
        public int dwSize;
        public int dwVideoWallNo;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "dwVideoWallNo", "dwLEDAreaNo", "byRes"});
        }
    }

    public static class NET_DVR_LED_AREA_INFO extends Structure {
        public byte[] byRes = new byte[32];
        public int dwLEDAreaNo;
        public int dwSize;
        public int[] dwaOutputNo = new int[512];
        public NET_DVR_RECTCFG_EX struRect = new NET_DVR_RECTCFG_EX();

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "dwLEDAreaNo", "struRect", "dwaOutputNo", "byRes"});
        }
    }

    public static class NET_DVR_LED_AREA_INFO_LIST extends Structure {
        public byte[] byRes = new byte[32];
        public int dwBufferSize;
        public int dwLEDAreaNum;
        public int dwSize;
        public Pointer lpstruBuffer;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "dwLEDAreaNum", "lpstruBuffer", "dwBufferSize", "byRes"});
        }
    }

    public static class NET_DVR_LOITERING_DETECTION extends Structure {
        public byte byEnabled;
        public byte[] byRes1 = new byte[3];
        public byte[] byRes2 = new byte[128];
        public int dwSize;
        public NET_DVR_LOITERING_REGION[] struRegion = ((NET_DVR_LOITERING_REGION[]) new NET_DVR_LOITERING_REGION().toArray(8));

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "byEnabled", "byRes1", "struRegion", "byRes2"});
        }
    }

    public static class NET_DVR_LOITERING_REGION extends Structure {
        public byte[] byRes = new byte[62];
        public byte bySensitivity;
        public byte byTimeThreshold;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "bySensitivity", "byTimeThreshold", "byRes"});
        }
    }

    public static class NET_DVR_MATRIX_PASSIVEMODE extends Structure {
        public byte[] byRes = new byte[7];
        public byte byStreamType;
        public NET_DVR_IPADDR struMcastIP = new NET_DVR_IPADDR();
        public short wPassivePort;
        public short wTransProtol;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"wTransProtol", "wPassivePort", "struMcastIP", "byStreamType", "byRes"});
        }
    }

    public static class NET_DVR_MULTI_STREAM_COMPRESSIONCFG extends Structure {
        public byte[] byRes = new byte[80];
        public int dwSize;
        public int dwStreamType;
        public NET_DVR_COMPRESSION_INFO_V30 struStreamPara = new NET_DVR_COMPRESSION_INFO_V30();

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "dwStreamType", "struStreamPara", "byRes"});
        }
    }

    public static class NET_DVR_MULTI_STREAM_COMPRESSIONCFG_COND extends Structure {
        public byte[] byRes = new byte[32];
        public int dwSize;
        public int dwStreamType;
        public NET_DVR_STREAM_INFO struStreamInfo = new NET_DVR_STREAM_INFO();

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "struStreamInfo", "dwStreamType", "byRes"});
        }
    }

    public static class NET_DVR_NOAMAL_SUB_SYSTEM extends Structure {
        public byte[] byRes = new byte[16];
        public int dwBeJoinedSubSystem;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwBeJoinedSubSystem", "byRes"});
        }
    }

    public static class NET_DVR_OPEN_EZVIZ_USER_LOGIN_INFO extends Structure {
        public byte[] byRes1 = new byte[3];
        public byte[] byRes2 = new byte[2];
        public byte[] byRes3 = new byte[128];
        public byte[] sAccessToken = new byte[128];
        public byte[] sAppID = new byte[64];
        public byte[] sClientType = new byte[32];
        public byte[] sDeviceID = new byte[32];
        public byte[] sEzvizServerAddress = new byte[129];
        public byte[] sFeatureCode = new byte[64];
        public byte[] sNetType = new byte[32];
        public byte[] sOsVersion = new byte[32];
        public byte[] sSdkVersion = new byte[32];
        public byte[] sUrl = new byte[64];
        public short wPort;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"sEzvizServerAddress", "byRes1", "wPort", "byRes2", "sUrl", "sAccessToken", "sDeviceID", "sClientType", "sFeatureCode", "sOsVersion", "sNetType", "sSdkVersion", "sAppID", "byRes3"});
        }
    }

    public static class NET_DVR_PLATE_INFO extends Structure {
        public byte[] byBelieve = new byte[16];
        public byte byBright;
        public byte byColor;
        public byte byCountry;
        public byte byEntireBelieve;
        public byte byLicenseLen;
        public byte byPlateType;
        public byte byRegion;
        public byte[] byRes = new byte[33];
        public byte[] sLicense = new byte[16];
        public NET_VCA_RECT struPlateRect = new NET_VCA_RECT();

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"byPlateType", "byColor", "byBright", "byLicenseLen", "byEntireBelieve", "byRegion", "byCountry", "byRes", "struPlateRect", "sLicense", "byBelieve"});
        }
    }

    public static class NET_DVR_PLATE_RESULT extends Structure {
        public byte[] byAbsTime = new byte[32];
        public byte byChanIndex;
        public byte byDriveChan;
        public byte byPicNum;
        public byte byRelaLaneDirectionType;
        public byte[] byRes3 = new byte[7];
        public byte byResultType;
        public byte byTrafficLight;
        public byte byVehicleType;
        public int dwBinPicLen;
        public int dwCarPicLen;
        public int dwFarCarPicLen;
        public int dwPicLen;
        public int dwPicPlateLen;
        public int dwRelativeTime;
        public int dwSize;
        public int dwVideoLen;
        public ByteByReference pBuffer1;
        public ByteByReference pBuffer2;
        public ByteByReference pBuffer3;
        public ByteByReference pBuffer4;
        public ByteByReference pBuffer5;
        public NET_DVR_PLATE_INFO struPlateInfo = new NET_DVR_PLATE_INFO();
        public NET_DVR_VEHICLE_INFO struVehicleInfo = new NET_DVR_VEHICLE_INFO();
        public short wAlarmRecordID;

        public NET_DVR_PLATE_RESULT(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "byResultType", "byChanIndex", "wAlarmRecordID", "dwRelativeTime", "byAbsTime", "dwPicLen", "dwPicPlateLen", "dwVideoLen", "byTrafficLight", "byPicNum", "byDriveChan", "byVehicleType", "dwBinPicLen", "dwCarPicLen", "dwFarCarPicLen", "pBuffer3", "pBuffer4", "pBuffer5", "byRelaLaneDirectionType", "byRes3", "struPlateInfo", "struVehicleInfo", "pBuffer1", "pBuffer2"});
        }
    }

    public static class NET_DVR_PUBLIC_SUB_SYSTEM extends Structure {
        public byte[] byRes = new byte[16];
        public int dwJointSubSystem;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwJointSubSystem", "byRes"});
        }
    }

    public static class NET_DVR_RECTCFG_EX extends Structure {
        public byte[] byRes = new byte[4];
        public int dwHeight;
        public int dwWidth;
        public int dwXCoordinate;
        public int dwYCoordinate;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwXCoordinate", "dwYCoordinate", "dwWidth", "dwHeight", "byRes"});
        }
    }

    public static class NET_DVR_SETUPALARM_PARAM extends Structure {
        public byte byAlarmInfoType;
        public byte byBrokenNetHttp;
        public byte byFaceAlarmDetection;
        public byte byLevel;
        public byte[] byRes1 = new byte[6];
        public byte byRetAlarmTypeV40;
        public byte byRetDevInfoVersion;
        public byte byRetVQDAlarmType;
        public byte bySupport;
        public int dwSize;
        public short wTaskNo;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "byLevel", "byAlarmInfoType", "byRetAlarmTypeV40", "byRetDevInfoVersion", "byRetVQDAlarmType", "byFaceAlarmDetection", "bySupport", "byBrokenNetHttp", "wTaskNo", "byRes1"});
        }
    }

    public static class NET_DVR_SMART_REGION_COND extends Structure {
        public int dwChannel;
        public int dwRegion;
        public int dwSize;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "dwChannel", "dwRegion"});
        }
    }

    public static class NET_DVR_STD_ABILITY extends Structure {
        public byte[] byRes = new byte[32];
        public int dwCondSize;
        public int dwOutSize;
        public int dwRetSize;
        public int dwStatusSize;
        public Pointer lpCondBuffer;
        public Pointer lpOutBuffer;
        public Pointer lpStatusBuffer;

        /* access modifiers changed from: protected */
        public List getFieldOrder() {
            return Arrays.asList(new String[]{"lpCondBuffer", "dwCondSize", "lpOutBuffer", "dwOutSize", "lpStatusBuffer", "dwStatusSize", "dwRetSize", "byRes"});
        }
    }

    public static class NET_DVR_STD_CONFIG extends Structure {
        public byte byDataType;
        public byte[] byRes = new byte[23];
        public int dwCondSize;
        public int dwInSize;
        public int dwOutSize;
        public int dwStatusSize;
        public int dwXmlSize;
        public Pointer lpCondBuffer;
        public Pointer lpInBuffer;
        public Pointer lpOutBuffer;
        public Pointer lpStatusBuffer;
        public Pointer lpXmlBuffer;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"lpCondBuffer", "dwCondSize", "lpInBuffer", "dwInSize", "lpOutBuffer", "dwOutSize", "lpStatusBuffer", "dwStatusSize", "lpXmlBuffer", "dwXmlSize", "byDataType", "byRes"});
        }
    }

    public static class NET_DVR_STREAM_INFO extends Structure {
        public byte[] byID = new byte[32];
        public byte[] byRes = new byte[32];
        public int dwChannel;
        public int dwSize;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "byID", "dwChannel", "byRes"});
        }
    }

    public static class NET_DVR_TIME extends Structure {
        public int dwDay;
        public int dwHour;
        public int dwMinute;
        public int dwMonth;
        public int dwSecond;
        public int dwYear;

        /* access modifiers changed from: protected */
        public List getFieldOrder() {
            return Arrays.asList(new String[]{"dwYear", "dwMonth", "dwDay", "dwHour", "dwMinute", "dwSecond"});
        }
    }

    public static class NET_DVR_TIME_EX extends Structure {
        public byte byDay;
        public byte byHour;
        public byte byMinute;
        public byte byMonth;
        public byte byRes;
        public byte bySecond;
        public short wYear;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"wYear", "byMonth", "byDay", "byHour", "byMinute", "bySecond", "byRes"});
        }
    }

    public static class NET_DVR_TIME_V30 extends Structure {
        public byte byDay;
        public byte byHour;
        public byte byMinute;
        public byte byMonth;
        public byte byRes;
        public byte[] byRes1 = new byte[2];
        public byte bySecond;
        public short wMilliSec;
        public short wYear;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"wYear", "byMonth", "byDay", "byHour", "byMinute", "bySecond", "byRes", "wMilliSec", "byRes1"});
        }
    }

    public static class NET_DVR_USER_LOGIN_INFO extends Structure {
        public boolean bUseAsynLogin;
        public byte byRes1;
        public byte[] byRes2 = new byte[128];
        public FLoginResultCallBack cbLoginResult;
        public Pointer pUser;
        public byte[] sDeviceAddress = new byte[129];
        public byte[] sPassword = new byte[64];
        public byte[] sUserName = new byte[64];
        public short wPort;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"sDeviceAddress", "byRes1", "wPort", "sUserName", "sPassword", "cbLoginResult", "pUser", "bUseAsynLogin", "byRes2"});
        }
    }

    public static class NET_DVR_VALID_PERIOD_CFG extends Structure {
        public byte byEnable;
        public byte[] byRes1 = new byte[3];
        public byte[] byRes2 = new byte[32];
        public NET_DVR_TIME_EX struBeginTime = new NET_DVR_TIME_EX();
        public NET_DVR_TIME_EX struEndTime = new NET_DVR_TIME_EX();

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"byEnable", "byRes1", "struBeginTime", "struEndTime", "byRes2"});
        }
    }

    public static class NET_DVR_VEHICLE_INFO extends Structure {
        public byte byColor;
        public byte byColorDepth;
        public byte[] byCustomInfo = new byte[16];
        public byte byIllegalType;
        public byte byRes1;
        public byte[] byRes3 = new byte[14];
        public byte byVehicleLogoRecog;
        public byte byVehicleModel;
        public byte byVehicleSubLogoRecog;
        public byte byVehicleType;
        public int dwIndex;
        public short wLength;
        public short wSpeed;
        public short wVehicleLogoRecog;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwIndex", "byVehicleType", "byColorDepth", "byColor", "byRes1", "wSpeed", "wLength", "byIllegalType", "byVehicleLogoRecog", "byVehicleSubLogoRecog", "byVehicleModel", "byCustomInfo", "wVehicleLogoRecog", "byRes3"});
        }
    }

    public static class NET_DVR_WALLWIN_INFO extends Structure {
        public byte[] byRes = new byte[12];
        public int dwSize;
        public int dwSubWinNum;
        public int dwWallNo;
        public int dwWinNum;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "dwWinNum", "dwSubWinNum", "dwWallNo", "byRes"});
        }
    }

    public static class NET_DVR_WALL_WIN_STATUS extends Structure {
        public byte byDecodeStatus;
        public byte byFpsDecA;
        public byte byFpsDecV;
        public byte byPacketType;
        public byte[] byRes1 = new byte[7];
        public byte[] byRes2 = new byte[31];
        public byte byStreamMode;
        public byte byStreamType;
        public int dwDecodedA;
        public int dwDecodedV;
        public int dwSize;
        public short wImgH;
        public short wImgW;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "byDecodeStatus", "byStreamType", "byPacketType", "byFpsDecV", "byFpsDecA", "byRes1", "dwDecodedV", "dwDecodedA", "wImgW", "wImgH", "byStreamMode", "byRes2"});
        }
    }

    public static class NET_DVR_XML_CONFIG_INPUT extends Structure {
        public byte[] byRes = new byte[32];
        public int dwInBufferSize;
        public int dwRecvTimeOut;
        public int dwRequestUrlLen;
        public int dwSize;
        public Pointer lpInBuffer;
        public Pointer lpRequestUrl;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "lpRequestUrl", "dwRequestUrlLen", "lpInBuffer", "dwInBufferSize", "dwRecvTimeOut", "byRes"});
        }
    }

    public static class NET_DVR_XML_CONFIG_OUTPUT extends Structure {
        public byte[] byRes = new byte[32];
        public int dwOutBufferSize;
        public int dwReturnedXMLSize;
        public int dwSize;
        public int dwStatusSize;
        public Pointer lpOutBuffer;
        public Pointer lpStatusBuffer;

        /* access modifiers changed from: protected */
        public List getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "lpOutBuffer", "dwOutBufferSize", "dwReturnedXMLSize", "lpStatusBuffer", "dwStatusSize", "byRes"});
        }
    }

    public static class NET_ITS_PICTURE_INFO extends Structure {
        public byte[] byAbsTime = new byte[32];
        public byte byCloseUpType;
        public byte byCompatibleAblity;
        public byte byDataType;
        public byte byPicRecogMode;
        public byte[] byRes2 = new byte[7];
        public byte byType;
        public int dwDataLen;
        public int dwRedLightTime;
        public int dwUTCTime;
        public ByteByReference pBuffer;
        public NET_VCA_RECT struPlateRecgRect;
        public NET_VCA_RECT struPlateRect;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwDataLen", "byType", "byDataType", "byCloseUpType", "byPicRecogMode", "dwRedLightTime", "byAbsTime", "struPlateRect", "struPlateRecgRect", "pBuffer", "dwUTCTime", "byCompatibleAblity", "byRes2"});
        }
    }

    public static class NET_ITS_PLATE_RESULT extends Structure {
        public byte byAlarmDataType;
        public byte byBarrierGateCtrlType;
        public byte byChanIndex;
        public byte byCopilotSafebelt;
        public byte byCopilotSunVisor;
        public byte byDangerousVehicles;
        public byte byDataAnalysis;
        public byte byDetSceneID;
        public byte byDetectType;
        public byte[] byDeviceID = new byte[48];
        public byte byDir;
        public byte byDriveChan;
        public byte byFeaturePicNo;
        public byte byGroupNum;
        public byte byIllegalFromatType;
        public byte[] byIllegalSubType = new byte[8];
        public byte[] byMonitoringSiteID = new byte[48];
        public byte byPicNo;
        public byte byPilotCall;
        public byte byPilotSafebelt;
        public byte byPilotSunVisor;
        public byte byPostPicNo;
        public byte byRelaLaneDirectionType;
        public byte[] byRes2 = new byte[2];
        public byte byRes3;
        public byte[] byRes4 = new byte[4];
        public byte bySecondCam;
        public byte byVehicleAttribute;
        public byte byVehicleType;
        public byte byYellowLabelCar;
        public int dwCustomIllegalType;
        public int dwIllegalTime;
        public int dwMatchNo;
        public int dwPicNum;
        public int dwSize;
        public ByteByReference pIllegalInfoBuf;
        public NET_ITS_PICTURE_INFO[] struPicInfo = ((NET_ITS_PICTURE_INFO[]) new NET_ITS_PICTURE_INFO().toArray(6));
        public NET_DVR_PLATE_INFO struPlateInfo = new NET_DVR_PLATE_INFO();
        public NET_DVR_TIME_V30 struSnapFirstPicTime = new NET_DVR_TIME_V30();
        public NET_DVR_VEHICLE_INFO struVehicleInfo = new NET_DVR_VEHICLE_INFO();
        public short wIllegalType;
        public short wSpeedLimit;

        public NET_ITS_PLATE_RESULT(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "dwMatchNo", "byGroupNum", "byPicNo", "bySecondCam", "byFeaturePicNo", "byDriveChan", "byVehicleType", "byDetSceneID", "byVehicleAttribute", "wIllegalType", "byIllegalSubType", "byPostPicNo", "byChanIndex", "wSpeedLimit", "byRes2", "struPlateInfo", "struVehicleInfo", "byMonitoringSiteID", "byDeviceID", "byDir", "byDetectType", "byRelaLaneDirectionType", "byRes3", "dwCustomIllegalType", "byIllegalFromatType", "pIllegalInfoBuf", "byRes4", "byDataAnalysis", "byYellowLabelCar", "byDangerousVehicles", "byPilotSafebelt", "byCopilotSafebelt", "byPilotSunVisor", "byCopilotSunVisor", "byPilotCall", "byBarrierGateCtrlType", "byAlarmDataType", "struSnapFirstPicTime", "dwIllegalTime", "dwPicNum", "struPicInfo"});
        }
    }

    public static class NET_VCA_ADV_REACH_HEIGHT extends Structure {
        public byte[] byRes = new byte[4];
        public int dwCrossDirection;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();

        public NET_VCA_ADV_REACH_HEIGHT(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "dwCrossDirection", "byRes"});
        }
    }

    public static class NET_VCA_ADV_TRAVERSE_PLANE extends Structure {
        public byte[] byRes = new byte[3];
        public byte bySensitivity;
        public int dwCrossDirection;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();

        public NET_VCA_ADV_TRAVERSE_PLANE(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "dwCrossDirection", "bySensitivity", "byRes"});
        }
    }

    public static class NET_VCA_AREA extends Structure {
        public byte byDetectionTarget;
        public byte[] byRes = new byte[7];
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();

        public NET_VCA_AREA(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "byDetectionTarget", "byRes"});
        }
    }

    public static class NET_VCA_AUDIO_ABNORMAL extends Structure {
        public byte byAudioMode;
        public byte byEnable;
        public byte[] byRes = new byte[54];
        public byte bySensitivity;
        public byte byThreshold;
        public short wDecibel;

        public NET_VCA_AUDIO_ABNORMAL(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"wDecibel", "bySensitivity", "byAudioMode", "byEnable", "byThreshold", "byRes"});
        }
    }

    public static class NET_VCA_COMBINED_RULE extends Structure {
        public byte[] byRes = new byte[7];
        public byte[] byRes1 = new byte[36];
        public byte byRuleSequence;
        public int dwMaxInterval;
        public int dwMinInterval;
        public NET_VCA_RELATE_RULE_PARAM struRule1Raram = new NET_VCA_RELATE_RULE_PARAM();
        public NET_VCA_RELATE_RULE_PARAM struRule2Raram = new NET_VCA_RELATE_RULE_PARAM();

        public NET_VCA_COMBINED_RULE(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"byRuleSequence", "byRes", "dwMinInterval", "dwMaxInterval", "struRule1Raram", "struRule2Raram", "byRes1"});
        }
    }

    public static class NET_VCA_DEV_INFO extends Structure {
        public byte byChannel;
        public byte byIvmsChannel;
        public NET_DVR_IPADDR struDevIP = new NET_DVR_IPADDR();
        public short wPort;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struDevIP", "wPort", "byChannel", "byIvmsChannel"});
        }
    }

    public static class NET_VCA_EVENT_UNION extends Union {
        public int[] uLen = new int[23];
    }

    public static class NET_VCA_FALL_DOWN extends Structure {
        public byte byHeightThreshold;
        public byte[] byRes = new byte[4];
        public byte bySensitivity;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_FALL_DOWN(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDuration", "bySensitivity", "byHeightThreshold", "byRes"});
        }
    }

    public static class NET_VCA_GET_UP extends Structure {
        public byte byMode;
        public byte[] byRes = new byte[4];
        public byte bySensitivity;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_GET_UP(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDuration", "byMode", "bySensitivity", "byRes"});
        }
    }

    public static class NET_VCA_HIGH_DENSITY extends Structure {
        public byte byRes;
        public byte bySensitivity;
        public float fDensity;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_HIGH_DENSITY(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "fDensity", "bySensitivity", "byRes", "wDuration"});
        }
    }

    public static class NET_VCA_HIGH_DENSITY_STATUS extends Structure {
        public byte[] byRes = new byte[3];
        public byte bySensitivity;
        public float fDensity;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();

        public NET_VCA_HIGH_DENSITY_STATUS(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "fDensity", "bySensitivity", "byRes"});
        }
    }

    public static class NET_VCA_HUMAN_ENTER extends Structure {
        public int[] dwRes = new int[23];

        public NET_VCA_HUMAN_ENTER(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwRes"});
        }
    }

    public static class NET_VCA_INTRUSION extends Structure {
        public byte byDetectionTarget;
        public byte byRate;
        public byte[] byRes = new byte[3];
        public byte bySensitivity;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_INTRUSION(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDuration", "bySensitivity", "byRate", "byDetectionTarget", "byRes"});
        }
    }

    public static class NET_VCA_LEAVE_POSITION extends Structure {
        public byte byMode;
        public byte byPersonType;
        public byte[] byRes = new byte[2];
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wLeaveDelay;
        public short wStaticDelay;

        public NET_VCA_LEAVE_POSITION(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wLeaveDelay", "wStaticDelay", "byMode", "byPersonType", "byRes"});
        }
    }

    public static class NET_VCA_LEFT extends Structure {
        public byte[] byRes = new byte[5];
        public byte bySensitivity;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_LEFT(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDuration", "bySensitivity", "byRes"});
        }
    }

    public static class NET_VCA_LINE extends Structure {
        public NET_VCA_POINT struEnd = new NET_VCA_POINT();
        public NET_VCA_POINT struStart = new NET_VCA_POINT();

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struStart", "struEnd"});
        }
    }

    public static class NET_VCA_LOITER extends Structure {
        public byte[] byRes = new byte[6];
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_LOITER(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDuration", "byRes"});
        }
    }

    public static class NET_VCA_OVER_TIME extends Structure {
        public byte[] byRes = new byte[6];
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_OVER_TIME(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDuration", "byRes"});
        }
    }

    public static class NET_VCA_PARKING extends Structure {
        public byte[] byRes = new byte[6];
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_PARKING(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDuration", "byRes"});
        }
    }

    public static class NET_VCA_PEOPLENUM_CHANGE extends Structure {
        public byte byDetectMode;
        public byte byNoneStateEffective;
        public byte byPeopleNumThreshold;
        public byte[] byRes = new byte[2];
        public byte bySensitivity;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_PEOPLENUM_CHANGE(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "bySensitivity", "byPeopleNumThreshold", "byDetectMode", "byNoneStateEffective", "wDuration", "byRes"});
        }
    }

    public static class NET_VCA_POINT extends Structure {

        /* renamed from: fX */
        public float f3133fX;

        /* renamed from: fY */
        public float f3134fY;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"fX", "fY"});
        }
    }

    public static class NET_VCA_POLYGON extends Structure {
        public int dwPointNum;
        public NET_VCA_POINT[] struPos = ((NET_VCA_POINT[]) new NET_VCA_POINT().toArray(10));

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwPointNum", "struPos"});
        }
    }

    public static class NET_VCA_REACH_HIGHT extends Structure {
        public byte[] byRes = new byte[6];
        public NET_VCA_LINE struVcaLine = new NET_VCA_LINE();
        public short wDuration;

        public NET_VCA_REACH_HIGHT(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struVcaLine", "wDuration", "byRes"});
        }
    }

    public static class NET_VCA_RECT extends Structure {
        public float fHeight;
        public float fWidth;

        /* renamed from: fX */
        public float f3135fX;

        /* renamed from: fY */
        public float f3136fY;

        /* access modifiers changed from: protected */
        public List getFieldOrder() {
            return Arrays.asList(new String[]{"fX", "fY", "fWidth", "fHeight"});
        }
    }

    public static class NET_VCA_RELATE_RULE_PARAM extends Structure {
        public byte byRes;
        public byte byRuleID;
        public short wEventType;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"byRuleID", "byRes", "wEventType"});
        }
    }

    public static class NET_VCA_RULE_ALARM extends Structure {
        public byte byPicType;
        public byte byRelAlarmPicNum;
        public byte byRes;
        public byte[] byRes2 = new byte[8];
        public byte bySmart;
        public int dwAbsTime;
        public int dwAlarmID;
        public int dwPicDataLen;
        public int dwRelativeTime;
        public int dwSize;
        public ByteByReference pImage;
        public NET_VCA_DEV_INFO struDevInfo = new NET_VCA_DEV_INFO();
        public NET_VCA_RULE_INFO struRuleInfo = new NET_VCA_RULE_INFO();
        public NET_VCA_TARGET_INFO struTargetInfo = new NET_VCA_TARGET_INFO();

        public NET_VCA_RULE_ALARM(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwSize", "dwRelativeTime", "dwAbsTime", "struRuleInfo", "struTargetInfo", "struDevInfo", "dwPicDataLen", "byPicType", "byRelAlarmPicNum", "bySmart", "byRes", "dwAlarmID", "byRes2", "pImage"});
        }
    }

    public static class NET_VCA_RULE_INFO extends Structure {
        public byte byRes;
        public byte byRuleID;
        public byte[] byRuleName = new byte[32];
        public int dwEventType;
        public NET_VCA_EVENT_UNION uEventParam = new NET_VCA_EVENT_UNION();
        public short wEventTypeEx;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"byRuleID", "byRes", "wEventTypeEx", "byRuleName", "dwEventType", "uEventParam"});
        }
    }

    public static class NET_VCA_RUN extends Structure {
        public byte byDetectionTarget;
        public byte byMode;
        public byte byRes;
        public byte bySensitivity;
        public float fRunDistance;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();

        public NET_VCA_RUN(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "fRunDistance", "bySensitivity", "byMode", "byDetectionTarget", "byRes"});
        }
    }

    public static class NET_VCA_SCANNER extends Structure {
        public byte[] byRes = new byte[5];
        public byte bySensitivity;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_SCANNER(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDuration", "bySensitivity", "byRes"});
        }
    }

    public static class NET_VCA_SIT_QUIETLY extends Structure {
        public byte[] byRes = new byte[4];
        public int dwDuration;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();

        public NET_VCA_SIT_QUIETLY(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "dwDuration", "byRes"});
        }
    }

    public static class NET_VCA_SPACING_CHANGE extends Structure {
        public byte byDetectMode;
        public byte bySensitivity;
        public float fSpacingThreshold;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_SPACING_CHANGE(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "fSpacingThreshold", "bySensitivity", "byDetectMode", "wDuration"});
        }
    }

    public static class NET_VCA_STANDUP extends Structure {
        public byte byHeightThreshold;
        public byte[] byRes = new byte[4];
        public byte bySensitivity;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_STANDUP(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "bySensitivity", "byHeightThreshold", "wDuration", "byRes"});
        }
    }

    public static class NET_VCA_STICK_UP extends Structure {
        public byte[] byRes = new byte[5];
        public byte bySensitivity;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_STICK_UP(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDuration", "bySensitivity", "byRes"});
        }
    }

    public static class NET_VCA_TAKE extends Structure {
        public byte[] byRes = new byte[5];
        public byte bySensitivity;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_TAKE(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDuration", "bySensitivity", "byRes"});
        }
    }

    public static class NET_VCA_TAKE_LEFT extends Structure {
        public byte[] byRes = new byte[6];
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_TAKE_LEFT(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDuration", "byRes"});
        }
    }

    public static class NET_VCA_TARGET_INFO extends Structure {
        public byte[] byRes = new byte[4];
        public int dwID;
        public NET_VCA_RECT struRect = new NET_VCA_RECT();

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwID", "struRect", "byRes"});
        }
    }

    public static class NET_VCA_TOILET_TARRY extends Structure {
        public byte[] byRes = new byte[6];
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDelay;

        public NET_VCA_TOILET_TARRY(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDelay", "byRes"});
        }
    }

    public static class NET_VCA_TRAIL extends Structure {
        public byte[] byRes = new byte[5];
        public byte bySensitivity;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wRes;

        public NET_VCA_TRAIL(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wRes", "bySensitivity", "byRes"});
        }
    }

    public static class NET_VCA_TRAVERSE_PLANE extends Structure {
        public byte byDetectionTarget;
        public byte byPlaneHeight;
        public byte[] byRes2 = new byte[37];
        public byte bySensitivity;
        public int dwCrossDirection;
        public NET_VCA_LINE struPlaneBottom = new NET_VCA_LINE();

        public NET_VCA_TRAVERSE_PLANE(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struPlaneBottom", "dwCrossDirection", "bySensitivity", "byPlaneHeight", "byDetectionTarget", "byRes2"});
        }
    }

    public static class NET_VCA_VIOLENT_MOTION extends Structure {
        public byte byMode;
        public byte[] byRes = new byte[4];
        public byte bySensitivity;
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDuration;

        public NET_VCA_VIOLENT_MOTION(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDuration", "bySensitivity", "byMode", "byRes"});
        }
    }

    public static class NET_VCA_YARD_TARRY extends Structure {
        public byte[] byRes = new byte[6];
        public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
        public short wDelay;

        public NET_VCA_YARD_TARRY(Pointer pointer) {
            super(pointer);
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"struRegion", "wDelay", "byRes"});
        }
    }

    public static class arrayCardRightPlan extends Structure {
        public byte[] byDoorRightPlan = new byte[4];

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"byDoorRightPlan"});
        }
    }

    public interface fRemoteConfigCallback extends Callback {
        void invoke(int i, Pointer pointer, int i2, Pointer pointer2);
    }

    public static class struAlarmChannel extends Structure {
        public int dwAlarmChanNum;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwAlarmChanNum"});
        }
    }

    public static class struAlarmHardDisk extends Structure {
        public int dwAlarmHardDiskNum;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwAlarmHardDiskNum"});
        }
    }

    public static class struIOAlarm extends Structure {
        public int dwAlarmInputNo;
        public int dwTrigerAlarmOutNum;
        public int dwTrigerRecordChanNum;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"dwAlarmInputNo", "dwTrigerAlarmOutNum", "dwTrigerRecordChanNum"});
        }
    }

    public static class struRecordingHost extends Structure {
        public byte[] byRes = new byte[NET_DVR_LOG_TYPE.MINOR_START_TRANS_CHAN];
        public byte[] byRes1 = new byte[3];
        public byte bySubAlarmType;
        public NET_DVR_TIME_EX struRecordEndTime = new NET_DVR_TIME_EX();

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"bySubAlarmType", "byRes1", "struRecordEndTime", "byRes"});
        }
    }

    public static class uStruAlarm extends Union {
        public byte[] byUnionLen = new byte[128];
        public struAlarmChannel sstrualarmChannel = new struAlarmChannel();
        public struAlarmHardDisk strualarmHardDisk = new struAlarmHardDisk();
        public struIOAlarm struioAlarm = new struIOAlarm();
        public struRecordingHost strurecordingHost = new struRecordingHost();
    }

    boolean NET_DVR_CapturePicture(int i, String str);

    boolean NET_DVR_CloseAlarmChan_V30(int i);

    int NET_DVR_CreateOpenEzvizUser(Pointer pointer, Pointer pointer2);

    boolean NET_DVR_DeleteOpenEzvizUser(int i);

    boolean NET_DVR_GetDVRConfig(int i, int i2, int i3, Pointer pointer, int i4, IntByReference intByReference);

    boolean NET_DVR_GetDeviceConfig(int i, int i2, int i3, Pointer pointer, int i4, Pointer pointer2, Pointer pointer3, int i5);

    int NET_DVR_GetLastError();

    int NET_DVR_GetSDKVersion();

    boolean NET_DVR_GetSTDAbility(int i, int i2, Pointer pointer);

    boolean NET_DVR_GetSTDConfig(int i, int i2, Pointer pointer);

    int NET_DVR_Login_V40(Pointer pointer, Pointer pointer2);

    boolean NET_DVR_Logout(int i);

    int NET_DVR_MatrixGetPassiveDecodeStatus(int i);

    boolean NET_DVR_MatrixSendData(int i, Pointer pointer, int i2);

    int NET_DVR_MatrixStartPassiveDecode(int i, int i2, Pointer pointer);

    boolean NET_DVR_MatrixStopPassiveDecode(int i);

    boolean NET_DVR_STDXMLConfig(int i, NET_DVR_XML_CONFIG_INPUT net_dvr_xml_config_input, NET_DVR_XML_CONFIG_OUTPUT net_dvr_xml_config_output);

    int NET_DVR_SaveRealData_V30(int i, int i2, String str);

    boolean NET_DVR_SetDVRConfig(int i, int i2, int i3, Pointer pointer, int i4);

    boolean NET_DVR_SetDVRMessageCallBack_V30(FMSGCallBack fMSGCallBack, Pointer pointer);

    boolean NET_DVR_SetDVRMessageCallBack_V50(int i, FMSGCallBack fMSGCallBack, Pointer pointer);

    boolean NET_DVR_SetDeviceConfig(int i, int i2, int i3, Pointer pointer, int i4, Pointer pointer2, Pointer pointer3, int i5);

    boolean NET_DVR_SetSTDConfig(int i, int i2, Pointer pointer);

    int NET_DVR_SetupAlarmChan_V30(int i);

    int NET_DVR_SetupAlarmChan_V41(int i, Pointer pointer);

    int NET_DVR_StartRemoteConfig(int i, int i2, Pointer pointer, int i3, fRemoteConfigCallback fremoteconfigcallback, Pointer pointer2);

    boolean NET_DVR_StopRemoteConfig(int i);

    int NET_DVR_StopSaveRealData_V30(int i);
}
