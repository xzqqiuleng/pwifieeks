package com.peek.camera.model;

import java.util.List;

public class QueXian_StyleInfo {
    private String Code;
    private String Define;
    private List<QueXian_GradeInfo> DefectDescribe;
    private int Index;
    private String Name;

    public String getCode() {
        return this.Code;
    }

    public String getDefine() {
        return this.Define;
    }

    public List<QueXian_GradeInfo> getDefectDescribe() {
        return this.DefectDescribe;
    }

    public int getIndex() {
        return this.Index;
    }

    public String getName() {
        return this.Name;
    }

    public void setCode(String str) {
        this.Code = str;
    }

    public void setDefine(String str) {
        this.Define = str;
    }

    public void setDefectDescribe(List<QueXian_GradeInfo> list) {
        this.DefectDescribe = list;
    }

    public void setIndex(int i) {
        this.Index = i;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public String toString() {
        return "QueXian_StyleInfo{, Index=" + this.Index + ", Name='" + this.Name + '\'' + ", Code='" + this.Code + '\'' + ", Define='" + this.Define + '\'' + "DefectDescribe=" + this.DefectDescribe + '}';
    }
}
