package com.peek.camera.model;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;



import java.io.Serializable;

@Table(execAfterTableCreated = "", name = "BZInfo")
public class BZInfo implements Serializable, Comparable {
    @Id(column = "key")

    /* renamed from: id */
    private int f3137id;
    @Column(column = "msg")
    private String msg;
    @Column(column = "row")
    private int row;
    @Column(column = "time")
    private long time;

    public BZInfo() {
    }

    public BZInfo(int i, String str, long j, int i2) {
        this.f3137id = i;
        this.msg = str;
        this.time = j;
        this.row = i2;
    }

    public int compareTo(Object obj) {
        return Integer.valueOf(this.f3137id).compareTo(Integer.valueOf(((BZInfo) obj).getId()));
    }

    public int getId() {
        return this.f3137id;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getRow() {
        return this.row;
    }

    public long getTime() {
        return this.time;
    }

    public void setId(int i) {
        this.f3137id = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setRow(int i) {
        this.row = i;
    }

    public void setTime(long j) {
        this.time = j;
    }
}
