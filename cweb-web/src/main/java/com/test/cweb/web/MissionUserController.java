package com.test.cweb.web;

import com.test.cweb.model.result.ApiResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户执行任务时的一些接口
 *
 * @author zgh
 */
@Controller
@RequestMapping("/mission")
public class MissionUserController {

    private Logger logger = Logger.getLogger(MissionUserController.class);

    /**
     * 根据用户Id获取用户的mission列表
     * 需要参数 userId 用户ID， state 任务状态，未开始，已开始，或已完成
     * 查询数据表：T_MISSION_LICENSE_INFO（用户拍牌任务表）, T_MISSION（任务表）
     * 方式一：1、根据userId查询 用户拍牌任务表 ， 获取该用户对应的missionId列表
     *        2、遍历得到的missionId列表，根据missionId和state查询T_MISSION表，将符合条件的结果放入mission列表，再放入ApiResult中返回
     * 方式二：多表连接查询，需要在Dao接口中添加方法以及在Mapper文件中添加相应的sql语句代码。注意返回值和传入参数。也可用百度的其他方法。
     *
     * @param request
     * @return
     */
    @RequestMapping("queryMissionList")
    public ApiResult queryMissionList(HttpServletRequest request) {
        return null;
    }

    /**
     * 获取mission详情
     * 需要参数 missionID 任务ID
     * 查询数据表：T_MISSION
     * 将查询出来的mission放入ApiResult的data中返回。
     *
     * @param request
     * @return
     */
    public ApiResult queryMissionInfo(HttpServletRequest request) {
        return null;
    }

    /**
     * 获取用户执行任务进度
     * 需要参数：userId, missionId
     * 查询数据表：T_MISSION_LICENSE_INFO
     * 根据userId和missionId查询数据，并将查询出来的数据放到APIResult中返回。
     * @param request
     * @return
     */
    public ApiResult missionProgress(HttpServletRequest request) {
        return null;
    }

    /**
     * 任务报名
     * @param request
     * @return
     */
    public ApiResult applyMission(HttpServletRequest request) {
        return null;
    }

    /**
     * 取消报名
     * @param request
     * @return
     */
    public ApiResult cancelApply(HttpServletRequest request) {
        return null;
    }

    /**
     * 签到
     *
     * @param request
     * @return
     */
    public ApiResult sign(HttpServletRequest request) {
        return null;
    }

    /**
     * 截屏上传
     *
     * @param request
     * @return
     */
    public ApiResult uploadPhoto(HttpServletRequest request) {
        return null;
    }

    /**
     * 拍牌结果确认
     *
     * @param request
     * @return
     */
    public ApiResult confirmResult(HttpServletRequest request) {
        return null;
    }
}
