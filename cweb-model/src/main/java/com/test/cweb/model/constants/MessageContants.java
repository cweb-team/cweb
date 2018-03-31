package com.test.cweb.model.constants;

/**
 * Created by feir4 on 2018/3/31.
 */
public class MessageContants {
    public static class MessageType {
        /**
         * 1——任务消息
         2——团队加入邀请
         3——团队加入申请
         4——分队加入邀请
         5——分队加入申请
         */
        public static final int MESSAGE_MISSION_ID = 1;
        public static final int GROUP_INVITE = 2;
        public static final int GROUP_APPLY = 3;
        public static final int TEAM_INVITE = 4;
        public static final int TEAM_APPLY = 5;
    }
    public static class MessageDealFlag {

        /**
         * 0——未处理
         */
        public static final Integer NOT_DEAL = 0;
        /**
         * 1——同意
         */
        public static final Integer APPROVE = 1;
        /**
         * 2——拒绝
         */
        public static final Integer REJECT = 2;
        /**
         * 9——已读
         */
        public static final Integer READ = 9;
    }
}
