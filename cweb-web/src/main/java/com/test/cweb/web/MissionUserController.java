package com.test.cweb.web;

import com.test.cweb.model.result.ApiResult;
import org.apache.http.protocol.HTTP;
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
     * @param request
     * @return
     */
    @RequestMapping("queryMissionList")
    ApiResult queryMissionList(HttpServletRequest request) {
        return null;
    }

    /**
     * 获取mission详情
     *
     * @param request
     * @return
     */
    ApiResult queryMissionInfo(HttpServletRequest request) {
        return null;
    }

    /**
     * 获取用户执行任务进度
     *
     * @param request
     * @return
     */
    ApiResult missionProgress(HttpServletRequest request) {
        return null;
    }

    /**
     * 任务报名
     * @param request
     * @return
     */
    ApiResult applyMission(HttpServletRequest request) {
        return null;
    }

    /**
     * 取消报名
     * @param request
     * @return
     */
    ApiResult cancelApply(HttpServletRequest request) {
        return null;
    }

    /**
     * 签到
     *
     * @param request
     * @return
     */
    ApiResult sign(HttpServletRequest request) {
        return null;
    }

    /**
     * 截屏上传
     *
     * @param request
     * @return
     */
    ApiResult uploadPhoto(HttpServletRequest request) {
        return null;
    }

    /**
     * 拍牌结果确认
     *
     * @param request
     * @return
     */
    ApiResult confirmResult(HttpServletRequest request) {
        return null;
    }
}
