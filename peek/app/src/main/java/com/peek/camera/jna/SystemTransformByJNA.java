package com.peek.camera.jna;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import java.util.Arrays;
import java.util.List;

public interface SystemTransformByJNA extends Library {
    public static final IntByReference file_handle = new IntByReference();
    public static final IntByReference handle = new IntByReference();
    public static final PLAYSDK_MEDIA_INFO.ByReference media_info = new PLAYSDK_MEDIA_INFO.ByReference();

    public static class OUTPUTDATA_INFO extends Structure {
        public int dwDataLen;
        public int dwDataType;
        public int dwFlag;
        public byte[] pData;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"pData", "dwDataLen", "dwDataType", "dwFlag"});
        }
    }

    public interface OutputDataCallBack extends Callback {
        void outputDataCallBack(OUTPUTDATA_INFO outputdata_info, int i);
    }

    public static class PLAYSDK_MEDIA_INFO extends Structure {
        public int audio_bitrate;
        public char audio_bits_per_sample;
        public char audio_channels;
        public short audio_format;
        public int audio_samplesrate;
        public short device_id;
        public int media_fourcc;
        public short media_version;
        public int[] reserved = new int[4];
        public short system_format;
        public short video_format;

        public static class ByReference extends PLAYSDK_MEDIA_INFO implements Structure.ByReference {
        }

        public static class ByValue extends PLAYSDK_MEDIA_INFO implements Structure.ByValue {
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"media_fourcc", "media_version", "device_id", "system_format", "video_format", "audio_format", "audio_channels", "audio_bits_per_sample", "audio_samplesrate", "audio_bitrate", "reserved"});
        }
    }

    public static class SYSTEM_TYPE extends Structure {
        public int TRANS_SYSTEM_AVI = 7;
        public int TRANS_SYSTEM_FLV = 10;
        public int TRANS_SYSTEM_GB_PS = 8;
        public int TRANS_SYSTEM_HIK = 1;
        public int TRANS_SYSTEM_HLS_TS = 9;
        public int TRANS_SYSTEM_MPEG2_PS = 2;
        public int TRANS_SYSTEM_MPEG2_TS = 3;
        public int TRANS_SYSTEM_MPEG4 = 5;
        public int TRANS_SYSTEM_MPEG4_FRONT = 11;
        public int TRANS_SYSTEM_NULL = 0;
        public int TRANS_SYSTEM_RAW = 16;
        public int TRANS_SYSTEM_RTP = 4;

        public static class ByReference extends SYSTEM_TYPE implements Structure.ByReference {
        }

        public static class ByValue extends SYSTEM_TYPE implements Structure.ByValue {
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[0]);
        }
    }

    public static class SYS_TRANS_PARA extends Structure {
        public int dwAggregate;
        public int dwChunkStreamID;
        public int dwMessageStreamID;
        public int dwSrcDemuxSize;
        public int dwSrcInfoLen;
        public int dwTgtPackSize;
        public int enTgtType;
        public PLAYSDK_MEDIA_INFO.ByReference pSrcInfo;

        public static class ByReference extends SYS_TRANS_PARA implements Structure.ByReference {
        }

        public static class ByValue extends SYS_TRANS_PARA implements Structure.ByValue {
        }

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"pSrcInfo", "dwSrcInfoLen", "enTgtType", "dwTgtPackSize", "dwSrcDemuxSize", "dwAggregate", "dwMessageStreamID", "dwChunkStreamID"});
        }
    }

    public static class SYS_TRANS_SESSION_PARA extends Structure {
        public int eTgtType;
        public int nSessionInfoLen;
        public int nSessionInfoType;
        public int nTgtPackSize;
        public byte[] pSessionInfoData;

        /* access modifiers changed from: protected */
        public List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"nSessionInfoType", "nSessionInfoLen", "pSessionInfoData", "eTgtType", "nTgtPackSize"});
        }
    }

    int SYSTRANS_Create(IntByReference intByReference, SYS_TRANS_PARA sys_trans_para);

    int SYSTRANS_CreateEx(IntByReference intByReference, int i, SYS_TRANS_PARA sys_trans_para);

    int SYSTRANS_GetTransPercent(int i, int i2);

    int SYSTRANS_InputData(int i, int i2, byte[] bArr, int i3);

    long SYSTRANS_OpenStreamAdvanced(IntByReference intByReference, int i, SYS_TRANS_SESSION_PARA sys_trans_session_para);

    int SYSTRANS_RegisterOutputDataCallBack(int i, OutputDataCallBack outputDataCallBack, int i2);

    int SYSTRANS_Release(int i);

    int SYSTRANS_Start(int i, String str, String str2);

    int SYSTRANS_Stop(int i);
}
