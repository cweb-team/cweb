package com.test.cweb.model;

import java.util.Date;

public class MissionLicenseInfo {
    private Integer pkId;

    private Integer userId;

    private Integer missionId;

    private Integer signInStatus;

    private Date signInTime;

    private Integer firstScreenUploadStatus;

    private Integer finalScreenUploadStatus;

    private Integer videoUploadStatus;

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

    public Integer getSignInStatus() {
        return signInStatus;
    }

    public void setSignInStatus(Integer signInStatus) {
        this.signInStatus = signInStatus;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    public Integer getFirstScreenUploadStatus() {
        return firstScreenUploadStatus;
    }

    public void setFirstScreenUploadStatus(Integer firstScreenUploadStatus) {
        this.firstScreenUploadStatus = firstScreenUploadStatus;
    }

    public Integer getFinalScreenUploadStatus() {
        return finalScreenUploadStatus;
    }

    public void setFinalScreenUploadStatus(Integer finalScreenUploadStatus) {
        this.finalScreenUploadStatus = finalScreenUploadStatus;
    }

    public Integer getVideoUploadStatus() {
        return videoUploadStatus;
    }

    public void setVideoUploadStatus(Integer videoUploadStatus) {
        this.videoUploadStatus = videoUploadStatus;
    }
}