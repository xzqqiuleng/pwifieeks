package com.peek.camera.model;
import com.peek.camera.p034b.C1155v;

import java.io.Serializable;

public class PipeDefectDetail implements Serializable {
    private String ClockExpression;
    private String DefectCode;
    private String DefectDescription;
    private String DefectLength;
    private String DefectLevel;
    private String DefectType;
    private String Distance;

    public PipeDefectDetail() {
    }

    public PipeDefectDetail(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.Distance = str;
        this.DefectType = str2;
        this.DefectCode = str3;
        this.DefectLevel = str4;
        this.ClockExpression = str5;
        this.DefectLength = str6;
        this.DefectDescription = str7;
    }

    public String getClockExpression() {
        return this.ClockExpression;
    }

    public String getDefectCode() {
        return this.DefectCode;
    }

    public String getDefectDescription() {
        return this.DefectDescription;
    }

    public String getDefectLength() {
        return this.DefectLength;
    }

    public String getDefectLevel() {
        return this.DefectLevel;
    }

    public String getDefectType() {
        return this.DefectType;
    }

    public String getDistance() {
        return this.Distance;
    }

    public void setClockExpression(String str) {
        this.ClockExpression = str;
    }

    public void setDefectCode(String str) {
        this.DefectCode = str;
    }

    public void setDefectDescription(String str) {
        this.DefectDescription = str;
    }

    public void setDefectLength(String str) {
        this.DefectLength = str;
    }

    public void setDefectLevel(String str) {
        this.DefectLevel = str;
    }

    public void setDefectType(String str) {
        this.DefectType = str;
    }

    public void setDistance(String str) {
        this.Distance = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!C1155v.m5330a(this.DefectType)) {
            sb.append("缺陷类型:").append(this.DefectType).append("\n");
        }
        if (!C1155v.m5330a(this.DefectCode)) {
            sb.append("缺陷名:").append(this.DefectCode).append("\n");
        }
        if (!C1155v.m5330a(this.DefectLevel)) {
            sb.append("等级:").append(this.DefectLevel).append("\n");
        }
        if (!C1155v.m5330a(this.Distance)) {
            sb.append("距离:").append(this.Distance).append("m\n");
        }
        if (!C1155v.m5330a(this.ClockExpression)) {
            sb.append("时钟表示:").append(this.ClockExpression).append("\n");
        }
        if (!C1155v.m5330a(this.DefectLength)) {
            sb.append("长度:").append(this.DefectLength).append("m\n");
        }
        return sb.toString();
    }
}
