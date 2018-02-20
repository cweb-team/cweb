package com.test.cweb.model;

public class MissionLicenseInfo {
    private Integer pkId;

    private Integer userId;

    private Integer missionId;

    private Boolean signInStatus;

    private Boolean signInTime;

    private Boolean firstScreenUploadStatus;

    private Boolean finalScreenUploadStatus;

    private Boolean videoUploadStatus;

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMissionId() {
        return missionId;
    }

    public void setMissionId(Integer missionId) {
        this.missionId = missionId;
    }

    public Boolean getSignInStatus() {
        return signInStatus;
    }

    public void setSignInStatus(Boolean signInStatus) {
        this.signInStatus = signInStatus;
    }

    public Boolean getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Boolean signInTime) {
        this.signInTime = signInTime;
    }

    public Boolean getFirstScreenUploadStatus() {
        return firstScreenUploadStatus;
    }

    public void setFirstScreenUploadStatus(Boolean firstScreenUploadStatus) {
        this.firstScreenUploadStatus = firstScreenUploadStatus;
    }

    public Boolean getFinalScreenUploadStatus() {
        return finalScreenUploadStatus;
    }

    public void setFinalScreenUploadStatus(Boolean finalScreenUploadStatus) {
        this.finalScreenUploadStatus = finalScreenUploadStatus;
    }

    public Boolean getVideoUploadStatus() {
        return videoUploadStatus;
    }

    public void setVideoUploadStatus(Boolean videoUploadStatus) {
        this.videoUploadStatus = videoUploadStatus;
    }
}