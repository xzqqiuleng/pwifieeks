package com.peek.camera.model;

public class Environment {
    public static final String QIYA_MAX = "QIYAMAX";
    public static final String QIYA_MIN = "QIYAMIN";
    public static final String SHAREPREFERENCES = "ENVIRONMENT";
    private float current_num;
    private float max_num;
    private float min_num;
    private String name;
    private int stat;

    public float getCurrent_num() {
        return this.current_num;
    }

    public float getMax_num() {
        return this.max_num;
    }

    public float getMin_num() {
        return this.min_num;
    }

    public String getName() {
        return this.name;
    }

    public int getStat() {
        return this.stat;
    }

    public void setCurrent_num(float f) {
        this.current_num = f;
    }

    public void setMax_num(float f) {
        this.max_num = f;
    }

    public void setMin_num(float f) {
        this.min_num = f;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStat(int i) {
        this.stat = i;
    }

    public String toString() {
        return "Environment{name='" + this.name + '\'' + ", current_num=" + this.current_num + ", min_num=" + this.min_num + ", max_num=" + this.max_num + ", stat=" + this.stat + '}';
    }
}
