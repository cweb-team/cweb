package com.test.cweb.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Role {
    /** 角色Id**/
    private int id;

    /** 角色描述**/
    private String description;

    /** 角色名称**/
    private String roleName;

    private Set<Permission> permissions = new HashSet<Permission>();

    /**
     * 创建时间
     */
    private Timestamp createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
