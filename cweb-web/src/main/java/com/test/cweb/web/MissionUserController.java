package com.test.cweb.web;

import com.test.cweb.model.Mission;
import com.test.cweb.model.MissionLicenseInfo;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IMissionLicenseInfoService;
import com.test.cweb.service.IMissionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户执行任务时的一些接口
 *
 * @author zgh
 */
@Controller
@RequestMapping("/mission")
public class MissionUserController {

    private Logger logger = Logger.getLogger(MissionUserController.class);
    @Resource
    IMissionService missionService;

    @Resource
    IMissionLicenseInfoService missionLicenseInfoServer;

    /**
     * 根据用户Id获取用户的mission列表
     * 需要参数 userId 用户ID， state 任务状态，未开始，已开始，或已完成
     * 查询数据表：T_MISSION_LICENSE_INFO（用户拍牌任务表）, T_MISSION（任务表）
     * 方式一：1、根据userId查询 用户拍牌任务表 ， 获取该用户对应的missionId列表
     *        2、遍历得到的missionId列表，根据missionId和state查询T_MISSION表，将符合条件的结果放入mission列表，再放入ApiResult中返回
     * 方式二：多表连接查询，需要在Dao接口中添加方法以及在Mapper文件中添加相应的sql语句代码。注意返回值和传入参数。也可用百度的其他方法。
     *
     * @param userId
     * @return
     */
    @RequestMapping("queryMissionList")
    public ApiResult queryMissionList(@RequestParam(value = "userId", required = true) Integer userId,
                                      @RequestParam(value = "state", required = true) Integer state) {
        ApiResult result = new ApiResult();
        List<MissionLicenseInfo> missionLicenseList = new ArrayList<>();
        List<Mission> missionList = new ArrayList<>();
        try {
            missionLicenseList =missionLicenseInfoServer.queryLicenseByUserId(userId);
        } catch (Exception e) {
            logger.error("获取missionLicenseList出错");
            logger.error(e.getMessage());
            e.printStackTrace();
            result.fail("获取mission列表出错");
        }
        if(missionLicenseList==null){
            result.success("任务列表为空");
        }
        else {
            try {
            for (int i = 0; i < missionLicenseList.size(); i++) {
                MissionLicenseInfo missionLicenseInfo = missionLicenseList.get(i);
                Mission mission = missionService.queryMissionInfo(missionLicenseInfo.getMissionId());
                if (mission != null && mission.getState() == state)
                    missionList.add(mission);
            }
                } catch (Exception e) {
                    logger.error("获取missionList出错");
                    logger.error(e.getMessage());
                    e.printStackTrace();
                    result.fail("获取mission列表出错");
                }
            result.success(missionList);
        }
        return result;
    }

    /**
     * 获取mission详情
     * 需要参数 missionID 任务ID
     * 查询数据表：T_MISSION
     * 将查询出来的mission放入ApiResult的data中返回。
     *
     * @param missionID
     * @return
     */
    public ApiResult queryMissionInfo(@RequestParam(value = "missionID", required = true) Integer missionID) {
        ApiResult result = new ApiResult();
        Mission mission;
        try {
           mission=missionService.queryMissionInfo(missionID);
           if(mission==null){
               logger.info("mission查询为空: missionId = " + missionID);
               result.success("任务信息为空");
           }
           else{
               result.success(mission);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取用户执行任务进度
     * 需要参数：userId, missionId
     * 查询数据表：T_MISSION_LICENSE_INFO
     * 根据userId和missionId查询数据，并将查询出来的数据放到APIResult中返回。
     * @param missionId
     * @param userId
     * @return
     */
    public ApiResult missionProgress(@RequestParam(value = "userId", required = true) Integer userId,
                                     @RequestParam(value = "missionId", required = true) Integer missionId) {
        ApiResult result = new ApiResult();
        try {
            MissionLicenseInfo missionLicenseInfo=missionLicenseInfoServer.queryLicenseByMissionIdUserId(missionId,userId);
            if(missionLicenseInfo==null){
                logger.info("missionLicenseInfo查询为空: missionId = " + missionId);
                result.success("任务信息为空");
            }
        } catch (Exception e) {
            logger.error("查询missionLicenseInfo信息出错:missionId = " + missionId);
            e.printStackTrace();
            result.fail("获取missionLicenseInfo信息出错");
            return result;
        }
        return result;
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
