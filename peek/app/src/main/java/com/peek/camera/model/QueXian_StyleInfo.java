package com.peek.camera.model;

import java.util.List;

public class QueXian_StyleInfo {
    private String code;
    private String define;
    private List<QueXian_GradeInfo> gradeList;
    private int index;
    private String name;

    public String getCode() {
        return this.code;
    }

    public String getDefine() {
        return this.define;
    }

    public List<QueXian_GradeInfo> getGradeList() {
        return this.gradeList;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setDefine(String str) {
        this.define = str;
    }

    public void setGradeList(List<QueXian_GradeInfo> list) {
        this.gradeList = list;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "QueXian_StyleInfo{, index=" + this.index + ", name='" + this.name + '\'' + ", code='" + this.code + '\'' + ", define='" + this.define + '\'' + "gradeList=" + this.gradeList + '}';
    }
}
