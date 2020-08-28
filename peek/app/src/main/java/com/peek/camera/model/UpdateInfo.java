package com.peek.camera.model;

public class UpdateInfo {
    private String apkName;
    private String description;
    private String url;
    private String version;

    public String getApkName() {
        return this.apkName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public void setApkName(String str) {
        this.apkName = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "UpdateInfo{version='" + this.version + '\'' + ", description='" + this.description + '\'' + ", url='" + this.url + '\'' + '}';
    }
}
