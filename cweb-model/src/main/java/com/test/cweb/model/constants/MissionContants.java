package com.test.cweb.model.constants;

/**
 * Created by feir4 on 2018/3/25.
 */
public class MissionContants {
    /**
     * 任务类型
     */
    public static class MissionType{
        /**
         * 1——拍牌任务
         */
        public static final Integer LICENSE = 1;
    }

    public static class MissionState{

        /**
         * 0——草稿
         */
        public static final Integer DRAFT = 0;
        /**
         * 1——已发布
         */
        public static final Integer PUBLISHED = 1;
        /**
         * 2——进行中
         */
        public static final Integer UNDERWAY = 2;
        /**
         * 3——已结束
         */
        public static final Integer FINISHED = 3;
    }

    /**
     * 任务管理相关操作类型
     */
    public static class MissionManage{
        /**
         * 1——新建
         */
        public static final Integer ADD = 1;
        /**
         * 2——修改
         */
        public static final Integer UPDATE = 2;
        /**
         * 3——发布
         */
        public static final Integer PUBLISH = 3;
        /**
         * 4——删除
         */
        public static final Integer DELETE = 4;
    }
}
