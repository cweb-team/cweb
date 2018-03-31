package com.test.cweb.model;

import java.util.Date;

public class UserGroupTeam {
    private Integer pkId;

    private Integer userId;

    private Integer groupId;

    private Integer teamId;

    private Date groupTime;

    private Date teamTime;

    private User user;

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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Date getGroupTime() {
        return groupTime;
    }

    public void setGroupTime(Date groupTime) {
        this.groupTime = groupTime;
    }

    public Date getTeamTime() {
        return teamTime;
    }

    public void setTeamTime(Date teamTime) {
        this.teamTime = teamTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}