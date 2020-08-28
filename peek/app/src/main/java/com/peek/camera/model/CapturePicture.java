package com.peek.camera.model;

public class CapturePicture {
    private String DefectFilename;
    private String Filename;
    private String PipedefectCode;
    private String Timestamp;

    public CapturePicture() {
    }

    public CapturePicture(String str, String str2, String str3) {
        this.Filename = str;
        this.DefectFilename = str2;
        this.Timestamp = str3;
    }

    public String getDefectFilename() {
        return this.DefectFilename;
    }

    public String getFilename() {
        return this.Filename;
    }

    public String getPipedefectCode() {
        return this.PipedefectCode;
    }

    public String getTimestamp() {
        return this.Timestamp;
    }

    public void setDefectFilename(String str) {
        this.DefectFilename = str;
    }

    public void setFilename(String str) {
        this.Filename = str;
    }

    public void setPipedefectCode(String str) {
        this.PipedefectCode = str;
    }

    public void setTimestamp(String str) {
        this.Timestamp = str;
    }

    public String toString() {
        return "CapturePicture{Filename='" + this.Filename + '\'' + ", DefectFilename='" + this.DefectFilename + '\'' + ", Timestamp='" + this.Timestamp + '\'' + '}';
    }
}
