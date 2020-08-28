package com.peek.camera.model;

import java.io.Serializable;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FileInfo implements Serializable {
    public static final String EXTEND_JPEG = ".jpeg";
    public static final String EXTEND_JPG = ".jpg";
    public static final String EXTEND_PNG = ".png";
    public static final int FLAG_DEFAULT = 0;
    public static final int FLAG_FAILURE = -1;
    public static final int FLAG_SUCCESS = 1;
    public static final int TYPE_JPG = 2;
    private String extra;
    private String filePath;
    private int fileType;
    private String name;
    private long procceed;
    private int result;
    private long size;
    private String sizeDesc;

    public FileInfo() {
    }

    public FileInfo(String str, long j) {
        this.filePath = str;
        this.size = j;
    }

    public static String toJsonArrayStr(List<FileInfo> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (FileInfo next : list) {
                if (next != null) {
                    try {
                        jSONArray.put(new JSONObject(toJsonStr(next)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return jSONArray.toString();
    }

    public static String toJsonStr(FileInfo fileInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("filePath", fileInfo.getFilePath());
            jSONObject.put("fileType", fileInfo.getFileType());
            jSONObject.put("size", fileInfo.getSize());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static FileInfo toObject(String str) {
        FileInfo fileInfo = new FileInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            long j = jSONObject.getLong("size");
            int i = jSONObject.getInt("fileType");
            fileInfo.setFilePath((String) jSONObject.get("filePath"));
            fileInfo.setSize(j);
            fileInfo.setFileType(i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fileInfo;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getFileType() {
        return this.fileType;
    }

    public String getName() {
        return this.name;
    }

    public long getProcceed() {
        return this.procceed;
    }

    public int getResult() {
        return this.result;
    }

    public long getSize() {
        return this.size;
    }

    public String getSizeDesc() {
        return this.sizeDesc;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileType(int i) {
        this.fileType = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setProcceed(long j) {
        this.procceed = j;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setSizeDesc(String str) {
        this.sizeDesc = str;
    }

    public String toString() {
        return "FileInfo{filePath='" + this.filePath + '\'' + ", fileType=" + this.fileType + ", size=" + this.size + '}';
    }
}
