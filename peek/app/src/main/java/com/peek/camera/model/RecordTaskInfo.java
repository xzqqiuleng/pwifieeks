package com.peek.camera.model;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

import java.io.Serializable;

@Table(execAfterTableCreated = "", name = "RecordTaskInfo")
public class RecordTaskInfo implements Serializable, Comparable {
    @Id(column = "key")

    /* renamed from: id */
    private int f3138id;
    @Column(column = "task_computer")
    private String task_computer;
    @Column(column = "task_date")
    private String task_date;
    @Column(column = "task_diameter")
    private String task_diameter;
    @Column(column = "task_direction")
    private String task_direction;
    @Column(column = "task_end")
    private String task_end;
    @Column(column = "task_guancai")
    private String task_guancai;
    @Column(column = "task_id")
    private String task_id;
    @Column(column = "task_name")
    private String task_name;
    @Column(column = "task_people")
    private String task_people;
    @Column(column = "task_place")
    private String task_place;
    @Column(column = "task_sort")
    private String task_sort;
    @Column(column = "task_start")
    private String task_start;

    public RecordTaskInfo() {
    }

    public RecordTaskInfo(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.task_id = str;
        this.task_name = str2;
        this.task_place = str3;
        this.task_start = str4;
        this.task_end = str5;
        this.task_direction = str6;
        this.task_sort = str7;
        this.task_guancai = str8;
        this.task_diameter = str9;
        this.task_computer = str10;
        this.task_people = str11;
    }

    public RecordTaskInfo(String str) {
        this.task_id = str;
    }

    public int compareTo(Object obj) {
        return Integer.valueOf(this.f3138id).compareTo(Integer.valueOf(((RecordTaskInfo) obj).getId()));
    }

    public int getId() {
        return this.f3138id;
    }

    public String getTask_computer() {
        return this.task_computer;
    }

    public String getTask_date() {
        return this.task_date;
    }

    public String getTask_diameter() {
        return this.task_diameter;
    }

    public String getTask_direction() {
        return this.task_direction;
    }

    public String getTask_end() {
        return this.task_end;
    }

    public String getTask_guancai() {
        return this.task_guancai;
    }

    public String getTask_id() {
        return this.task_id;
    }

    public String getTask_name() {
        return this.task_name;
    }

    public String getTask_people() {
        return this.task_people;
    }

    public String getTask_place() {
        return this.task_place;
    }

    public String getTask_sort() {
        return this.task_sort;
    }

    public String getTask_start() {
        return this.task_start;
    }

    public void setId(int i) {
        this.f3138id = i;
    }

    public void setTask_computer(String str) {
        this.task_computer = str;
    }

    public void setTask_date(String str) {
        this.task_date = str;
    }

    public void setTask_diameter(String str) {
        this.task_diameter = str;
    }

    public void setTask_direction(String str) {
        this.task_direction = str;
    }

    public void setTask_end(String str) {
        this.task_end = str;
    }

    public void setTask_guancai(String str) {
        this.task_guancai = str;
    }

    public void setTask_id(String str) {
        this.task_id = str;
    }

    public void setTask_name(String str) {
        this.task_name = str;
    }

    public void setTask_people(String str) {
        this.task_people = str;
    }

    public void setTask_place(String str) {
        this.task_place = str;
    }

    public void setTask_sort(String str) {
        this.task_sort = str;
    }

    public void setTask_start(String str) {
        this.task_start = str;
    }
}
