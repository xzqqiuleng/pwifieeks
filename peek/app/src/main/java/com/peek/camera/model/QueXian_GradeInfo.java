package com.peek.camera.model;

public class QueXian_GradeInfo {
    private String Content;
    private int Level;

    public String getContent() {
        return this.Content;
    }

    public int getLevel() {
        return this.Level;
    }

    public void setContent(String str) {
        this.Content = str;
    }

    public void setLevel(int i) {
        this.Level = i;
    }

    public String toString() {
        return "QueXian_GradeInfo{Level=" + this.Level + ", Content='" + this.Content + '\'' + '}';
    }
}
