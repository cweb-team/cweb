package com.test.cweb;

/**
 * @author hyl
 * @data 18/3/15 下午10:29
 */
public class CommonConstant {

    //==权限
    /**
     * 个人信息
     */
     public static final int PERMISSION_COMMON = 1000 ;

    /**
     * 文件权限组
     */
    public static final int PERMISSION_FILE = 2000;

    /**
     * 团队权限组
     */
    public static final int PERMISSION_GROUP = 3000;

    /**
     * 分队权限组
     */
    public static final int PERMISSION_TEAM = 4000;

    /**
     * 任务权限组
     */
    public static final int PERMISSION_MISSION = 5000;

    /**
     * 普通用户/拍手 角色
     */
    public static final String ROLE_COMMON_NAME = "basis";
    public static final int ROLE_COMMON_ID = 5;

    /**
     * 超级管理员 角色
     */
    public static final String ROLE_ROOT_NAME = "root";
    public static final int ROLE_ROOT_ID = 0;

    /**
     * 普通管理员 角色
     */
    public static final String ROLE_ADMIN_NAME = "admin";
    public static final int ROLE_ADMIN_ID = 1;

    /**
     * 团长 角色
     */
    public static final String ROLE_GROUPLEADER_NAME = "groupLeader";
    public static final int ROLE_GROUPLEADER_ID = 2;

    /**
     * 副团长 角色
     */
    public static final String ROLE_GROUPLEADER_SUB_NAME = "groupLeader2";
    public static final int ROLE_GROUPLEADER_SUB_ID = 3;

    /**
     * 分队长 角色
     */
    public static final String ROLE_TEAM_LEADER_NAME = "teamLeader";
    public static final int ROLE_TEAM_LEADER_ID = 4;

    //==
    //==消息
    /**
     * 1——任务消息，关联Mission_ID
     2——团队加入邀请，关联GROUP_ID
     3——团队加入申请，关联GROUP_ID
     4——分队加入邀请，关联TEAM_ID
     5——分队加入申请，关联TEAM_ID
     */
    public static final int MESSAGE_MISSION_ID = 1;
    public static final int MESSAGE_GROUP_INVITE_ID = 2;
    public static final int MESSAGE_GROUP_APPLY_ID = 3;
    public static final int MESSAGE_TEAM_INVITE_ID = 4;
    public static final int MESSAGE_TEAM_APPLY_ID = 5;
}
