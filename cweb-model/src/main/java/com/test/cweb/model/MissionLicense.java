package com.test.cweb.model;

import java.util.Date;

public class MissionLicense {
    private Integer pkId;

    private Integer groupId;

    private Date licenseTagTime;

    private String description;

    private Boolean publishTime;

    private Boolean bookNum;

    private Boolean signUpNum;

    private Boolean updateTime;

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Date getLicenseTagTime() {
        return licenseTagTime;
    }

    public void setLicenseTagTime(Date licenseTagTime) {
        this.licenseTagTime = licenseTagTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Boolean publishTime) {
        this.publishTime = publishTime;
    }

    public Boolean getBookNum() {
        return bookNum;
    }

    public void setBookNum(Boolean bookNum) {
        this.bookNum = bookNum;
    }

    public Boolean getSignUpNum() {
        return signUpNum;
    }

    public void setSignUpNum(Boolean signUpNum) {
        this.signUpNum = signUpNum;
    }

    public Boolean getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Boolean updateTime) {
        this.updateTime = updateTime;
    }
}