package com.peek.camera.model;

import java.util.List;

public class QueXianInfo {
    private String Code;
    private int Index;
    private String Name;
    private List<QueXian_StyleInfo> Defect;

    public String getCode() {
        return this.Code;
    }

    public int getIndex() {
        return this.Index;
    }

    public String getName() {
        return this.Name;
    }

    public List<QueXian_StyleInfo> getDefect() {
        return this.Defect;
    }

    public void setCode(String str) {
        this.Code = str;
    }

    public void setIndex(int i) {
        this.Index = i;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setDefect(List<QueXian_StyleInfo> list) {
        this.Defect = list;
    }

    public String toString() {
        return "QueXianInfo{, Index=" + this.Index + ", Name='" + this.Name + '\'' + ", Code='" + this.Code + '\'' + "Defect=" + this.Defect + '}';
    }
}
