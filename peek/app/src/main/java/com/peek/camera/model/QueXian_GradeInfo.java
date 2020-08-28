package com.peek.camera.model;

public class QueXian_GradeInfo {
    private String content;
    private int level;

    public String getContent() {
        return this.content;
    }

    public int getLevel() {
        return this.level;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public String toString() {
        return "QueXian_GradeInfo{level=" + this.level + ", content='" + this.content + '\'' + '}';
    }
}
