package com.peek.camera.model;

import java.io.Serializable;
import java.util.ArrayList;

public class PipeDefectImage implements Serializable {
    private String Filename;
    private String PipeSection;
    private ArrayList<PipeDefectDetail> pipeDefectDetails;

    public PipeDefectImage() {
        this.pipeDefectDetails = new ArrayList<>();
    }

    public PipeDefectImage(ArrayList<PipeDefectDetail> arrayList, String str, String str2) {
        this.pipeDefectDetails = arrayList;
        this.PipeSection = str;
        this.Filename = str2;
    }

    public void addDefectDetail(PipeDefectDetail pipeDefectDetail) {
        this.pipeDefectDetails.add(pipeDefectDetail);
    }

    public String getFilename() {
        return this.Filename;
    }

    public ArrayList<PipeDefectDetail> getPipeDefectDetails() {
        return this.pipeDefectDetails;
    }

    public String getPipeSection() {
        return this.PipeSection;
    }

    public void setFilename(String str) {
        this.Filename = str;
    }

    public void setPipeDefectDetails(ArrayList<PipeDefectDetail> arrayList) {
        this.pipeDefectDetails = arrayList;
    }

    public void setPipeSection(String str) {
        this.PipeSection = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.PipeSection != null) {
            sb.append("管道号:").append(this.PipeSection).append("\n");
        }
        if (this.pipeDefectDetails.size() > 0) {
            sb.append("此处一共有").append(this.pipeDefectDetails.size()).append("处缺陷,详情如下:\n");
        } else {
            sb.append("此处无缺陷！");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.pipeDefectDetails.size()) {
                return sb.toString();
            }
            sb.append("\n").append(i2 + 1).append(".").append(this.pipeDefectDetails.get(i2).toString());
            i = i2 + 1;
        }
    }
}
