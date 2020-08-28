package com.peek.camera.model;

import java.util.ArrayList;

public class VideoInfo {
    private String CapturePictureDirectoryName;
    private String DeviceModel;
    private String InspectionStandard;
    private String VideoFilename;
    private ArrayList<CapturePicture> capturePictures;
    private RecordTaskInfo recordTaskInfo;

    public VideoInfo() {
        this.DeviceModel = "Peek2S";
        this.InspectionStandard = "GJBB";
        this.CapturePictureDirectoryName = "capture";
        this.capturePictures = new ArrayList<>();
    }

    public VideoInfo(RecordTaskInfo recordTaskInfo2, String str, ArrayList<CapturePicture> arrayList) {
        this.DeviceModel = "Peek2S";
        this.InspectionStandard = "GJBB";
        this.CapturePictureDirectoryName = "capture";
        this.recordTaskInfo = recordTaskInfo2;
        this.VideoFilename = str;
        this.capturePictures = arrayList;
    }

    public void addCapturePic(CapturePicture capturePicture) {
        this.capturePictures.add(capturePicture);
    }

    public String getCapturePictureDirectoryName() {
        return this.CapturePictureDirectoryName;
    }

    public ArrayList<CapturePicture> getCapturePictures() {
        return this.capturePictures;
    }

    public String getDeviceModel() {
        return this.DeviceModel;
    }

    public String getInspectionStandard() {
        return this.InspectionStandard;
    }

    public RecordTaskInfo getRecordTaskInfo() {
        return this.recordTaskInfo;
    }

    public String getVideoFilename() {
        return this.VideoFilename;
    }

    public void setCapturePictureDirectoryName(String str) {
        this.CapturePictureDirectoryName = str;
    }

    public void setCapturePictures(ArrayList<CapturePicture> arrayList) {
        this.capturePictures = arrayList;
    }

    public void setDeviceModel(String str) {
        this.DeviceModel = str;
    }

    public void setInspectionStandard(String str) {
        this.InspectionStandard = str;
    }

    public void setRecordTaskInfo(RecordTaskInfo recordTaskInfo2) {
        this.recordTaskInfo = recordTaskInfo2;
    }

    public void setVideoFilename(String str) {
        this.VideoFilename = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.capturePictures.size()) {
                return "VideoInfo{\nrecordTaskInfo=" + this.recordTaskInfo + ", DeviceModel='" + this.DeviceModel + '\'' + ", InspectionStandard='" + this.InspectionStandard + '\'' + ", VideoFilename='" + this.VideoFilename + '\'' + ", CapturePictureDirectoryName='" + this.CapturePictureDirectoryName + '\'' + ", capturePictures=" + sb.toString() + '}';
            }
            sb.append("\n").append(this.capturePictures.get(i2).getFilename()).append("\n").append(this.capturePictures.get(i2).getDefectFilename()).append("\n").append(this.capturePictures.get(i2).getPipedefectCode()).append("\n").append(this.capturePictures.get(i2).getTimestamp()).append("\n");
            i = i2 + 1;
        }
    }
}
