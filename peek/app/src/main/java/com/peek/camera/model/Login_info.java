package com.peek.camera.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.peek.camera.BaseApplication;

public class Login_info {
    public static final String ALL_URL_INFOMATION = "ALL_URL_INFOMATION";
    public static final String FILE_IS_SAVE_SDCARD = "FILE_IS_SAVE_SDCARD";
    public static final String RECORDHEAD_IS_SHOW_FIRSTNAME = "RECORDHEAD_IS_SHOW_FIRSTNAME";
    public static final String SOCKET_IP = "SOCKET_IP";
    public static final String SOCKET_PORT = "SOCKET_PORT";
    public static final String VIDEO_ACCOUNT = "VIDEO_ACCOUNT";
    public static final String VIDEO_IP = "VIDEO_IP";
    public static final String VIDEO_PASSWORD = "VIDEO_PASSWORD";
    public static final String VIDEO_PORT = "VIDEO_PORT";
    public static final String VIDEO_ZIMALIU = "VIDEO_ZIMALIU";
    public static final String WIFI_AUTO = "WIFI_AUTO";
    public static final String WIFI_IS_REPEATER = "WIFI_IS_REPEATER";
    public static final String WIFI_PASSWORD = "WIFI_PASSWORD";
    public static final String WIFI_SSID = "WIFI_SSID";
    public static final String YINGJIEMA = "YINGJIEMA";
    public static final boolean baseIsRecordHeadShowFirstName = true;
    public static final boolean baseIsSaveToExSdcard = false;
    public static final boolean baseIsYingJieMa = false;
    public static final String baseMainFrameWifiPassword = "bmwpeek2shost";
    public static final String baseMainFrameWifiSSID = "IMDT_WH";
    public static final String baseRepeaterWifiPassword = "bmwpeek2shost";
    public static final String baseRepeaterWifiSSID = "IMDT_WH";
    public static final boolean baseWifiIsRepeater = false;
    public static final String base_socket_ip = "192.168.2.64";
    public static final int base_socket_port = 50001;
    public static final String base_video_account = "admin";
    public static final String base_video_ip = "192.168.2.64";
    public static final String base_video_password = "qwe123456";
    public static final int base_video_port = 8000;
    public static final boolean base_video_zimaliu = false;
    public static final boolean base_wifi_auto = true;
    private static Login_info instance = null;
    public static boolean isAddKanban = false;
    public static boolean isPause = true;

    public static String local_kanban_path = "/peek2s_data/kanban/";
    public static String local_peek2s_path = "/peek2s_data/";
    public static String local_picture_path = "/peek2s_data/capture/";
    public static String local_video_path = "/peek2s_data/video/";
    public static String manufacturer = null;
    public static String url = "http://192.168.191.1:8080/Banben";
    private SharedPreferences.Editor editor;
    private boolean isBanTouShow;
    private boolean isPermisionLog;
    private boolean isSaveToExSdcard;
    private boolean isShowFirstName;
    private boolean isYingJieMa;
    private SharedPreferences sharedPreferences;
    private String socket_ip;
    private int socket_port;
    private String video_account;
    private String video_ip;
    private String video_password;
    private int video_port;
    private boolean video_zimaliu;
    private boolean wifiIsRepeater;
    private String wifi_Password;
    private String wifi_SSID;
    private boolean wifi_auto;

    private Login_info() {
    }

    public static Login_info getInstance() {
        if (instance == null) {
            synchronized (All_id_Info.class) {
                if (instance == null) {
                    instance = new Login_info();
                }
            }
        }
        return instance;
    }

    private void initData() {
        this.video_ip = this.sharedPreferences.getString(VIDEO_IP, base_video_ip);
        this.video_port = this.sharedPreferences.getInt(VIDEO_PORT, 8000);
        this.video_account = this.sharedPreferences.getString(VIDEO_ACCOUNT, base_video_account);
        this.video_password = this.sharedPreferences.getString(VIDEO_PASSWORD, base_video_password);
        this.socket_ip = this.sharedPreferences.getString(SOCKET_IP, base_socket_ip);
        this.socket_port = this.sharedPreferences.getInt(SOCKET_PORT, base_socket_port);
        this.wifi_SSID = this.sharedPreferences.getString(WIFI_SSID, baseRepeaterWifiSSID);
        this.wifi_Password = this.sharedPreferences.getString(WIFI_PASSWORD, "bmwpeek2shost");
        this.wifi_auto = this.sharedPreferences.getBoolean(WIFI_AUTO, true);
        this.video_zimaliu = this.sharedPreferences.getBoolean(VIDEO_ZIMALIU, false);
        this.wifiIsRepeater = this.sharedPreferences.getBoolean(WIFI_IS_REPEATER, false);
        this.isYingJieMa = this.sharedPreferences.getBoolean(YINGJIEMA, false);
        this.isSaveToExSdcard = this.sharedPreferences.getBoolean(FILE_IS_SAVE_SDCARD, false);
        this.isShowFirstName = this.sharedPreferences.getBoolean(RECORDHEAD_IS_SHOW_FIRSTNAME, true);
    }

    public String getSocket_ip() {
        return this.socket_ip;
    }

    public int getSocket_port() {
        return this.socket_port;
    }

    public String getVideo_account() {
        return this.video_account;
    }

    public String getVideo_ip() {
        return this.video_ip;
    }

    public String getVideo_password() {
        return this.video_password;
    }

    public int getVideo_port() {
        return this.video_port;
    }

    public String getWifi_Password() {
        return this.wifi_Password;
    }

    public String getWifi_SSID() {
        return this.wifi_SSID;
    }

    public void initLoginInfo(Context context) {
        this.sharedPreferences = BaseApplication.m4928b();
        this.editor = this.sharedPreferences.edit();
        initData();
    }

    public boolean isBanTouShow() {
        return this.isBanTouShow;
    }

    public boolean isPermisionLog() {
        return this.isPermisionLog;
    }

    public boolean isSaveToExSdcard() {
        return this.isSaveToExSdcard;
    }

    public boolean isShowFirstName() {
        return this.isShowFirstName;
    }

    public boolean isVideo_zimaliu() {
        return this.video_zimaliu;
    }

    public boolean isWifiIsRepeater() {
        return this.wifiIsRepeater;
    }

    public boolean isWifi_auto() {
        return this.wifi_auto;
    }

    public boolean isYingJieMa() {
        return this.isYingJieMa;
    }

    public void release() {
        instance = null;
    }

    public void setBanTouShow(boolean z) {
        this.isBanTouShow = z;
    }

    public void setData(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, boolean z, boolean z2) {
        this.editor = this.sharedPreferences.edit();
        this.editor.putString(VIDEO_IP, str);
        this.editor.putInt(VIDEO_PORT, Integer.valueOf(str2).intValue());
        this.editor.putString(VIDEO_ACCOUNT, str3);
        this.editor.putString(VIDEO_PASSWORD, str4);
        this.editor.putString(SOCKET_IP, str5);
        this.editor.putInt(SOCKET_PORT, i);
        this.editor.putString(WIFI_SSID, str6);
        this.editor.putString(WIFI_PASSWORD, str7);
        this.editor.putBoolean(WIFI_AUTO, z);
        this.editor.putBoolean(VIDEO_ZIMALIU, z2);
        this.editor.commit();
        initData();
    }

    public void setPermisionLog(boolean z) {
        this.isPermisionLog = z;
    }

    public void setSaveToExSdcard(boolean z) {
        this.isSaveToExSdcard = z;
        this.editor.putBoolean(FILE_IS_SAVE_SDCARD, this.isSaveToExSdcard);
        this.editor.commit();
    }

    public void setShowFirstName(boolean z) {
        this.isShowFirstName = z;
        this.editor.putBoolean(RECORDHEAD_IS_SHOW_FIRSTNAME, z);
        this.editor.commit();
    }

    public void setWifiIsRepeater(boolean z) {
        this.wifiIsRepeater = z;
        this.editor.putBoolean(WIFI_IS_REPEATER, z);
        this.editor.commit();
    }

    public void setWifi_auto(boolean z, boolean z2) {
        this.wifi_auto = z;
        if (z2) {
            this.editor.putBoolean(WIFI_AUTO, z);
            this.editor.commit();
            initData();
        }
    }

    public void setYingJieMa(boolean z) {
        this.isYingJieMa = z;
        this.editor.putBoolean(YINGJIEMA, z);
        this.editor.commit();
        initData();
    }
}
