package com.peek.camera.model;

import java.util.List;

public class QueXianInfo {
    private String code;
    private int index;
    private String name;
    private List<QueXian_StyleInfo> styleList;

    public String getCode() {
        return this.code;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public List<QueXian_StyleInfo> getStyleList() {
        return this.styleList;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStyleList(List<QueXian_StyleInfo> list) {
        this.styleList = list;
    }

    public String toString() {
        return "QueXianInfo{, index=" + this.index + ", name='" + this.name + '\'' + ", code='" + this.code + '\'' + "styleList=" + this.styleList + '}';
    }
}
