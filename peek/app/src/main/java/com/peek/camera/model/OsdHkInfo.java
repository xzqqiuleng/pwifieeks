package com.peek.camera.model;

public class OsdHkInfo {
    private int osdX;
    private int osdY;
    private String sString;
    private int showStr;
    private int strSize;

    public OsdHkInfo() {
    }

    public OsdHkInfo(String str, int i, int i2, int i3) {
        this.sString = str;
        this.showStr = i;
        this.osdX = i2;
        this.osdY = i3;
    }

    public OsdHkInfo(String str, int i, int i2, int i3, int i4) {
        this.sString = str;
        this.showStr = i;
        this.strSize = i2;
        this.osdX = i3;
        this.osdY = i4;
    }

    public int getOsdX() {
        return this.osdX;
    }

    public int getOsdY() {
        return this.osdY;
    }

    public int getShowStr() {
        return this.showStr;
    }

    public int getStrSize() {
        return this.strSize;
    }

    public String getsString() {
        return this.sString;
    }

    public void setOsdX(int i) {
        this.osdX = i;
    }

    public void setOsdY(int i) {
        this.osdY = i;
    }

    public void setShowStr(int i) {
        this.showStr = i;
    }

    public void setStrSize(int i) {
        this.strSize = i;
    }

    public void setsString(String str) {
        this.sString = str;
    }

    public String toString() {
        return "OsdHkInfo{sString='" + this.sString + '\'' + ", showStr=" + this.showStr + ", strSize=" + this.strSize + ", osdX=" + this.osdX + ", osdY=" + this.osdY + '}';
    }
}
