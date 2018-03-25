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

    private Integer result;

    private Integer bid;

    private Date createTime;

    private Date updateTime;

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

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}