package com.test.cweb.web;

import com.test.cweb.model.Mission;
import com.test.cweb.model.MissionLicenseInfo;
import com.test.cweb.model.constants.MissionContants;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IMissionLicenseInfoService;
import com.test.cweb.service.IMissionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by feir4 on 2018/3/20.
 */
@Controller
@RequestMapping("/mission")
public class MissionManageController {

    private Logger logger = Logger.getLogger(MissionManageController.class);

    @Resource
    IMissionService missionService;

    @Resource
    IMissionLicenseInfoService missionLicenseInfoServer;


    /**
     * 测试用接口
     * @param request
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    public ApiResult test(HttpServletRequest request){
        ApiResult result = new ApiResult();
        String id = request.getParameter("id");
        logger.info("id = " + id);
        logger.debug("id = " + id);
        logger.error("id = " + id);
        result.success(200);
        return result;
    }

    /**
     * 参数为groupId, 任务类型type, 任务状态state, 返回这个group下的mission列表
     * @author zgh
     * @param groupId
     * @param state
     * @param type
     * @return ApiResult
     */
    @RequestMapping("/missionList.do")
    @ResponseBody
    public ApiResult missionList(@RequestParam(value = "groupId", required = true) Integer groupId,
                                 @RequestParam(value = "type", required = true) Integer type,
                                 @RequestParam(value = "state", required = true) Integer state) {
        ApiResult result = new ApiResult();
        List<Mission> missionList = new ArrayList<>();
        try {
            missionList = missionService.queryMissionList(groupId, type, state);
            if (!CollectionUtils.isEmpty(missionList)) {
                result.success(missionList);
            } else {
                result.success("任务列表为空");
            }
        } catch (Exception e) {
            logger.error("获取missionList出错  groupId = " + groupId);
            logger.error(e.getMessage());
            e.printStackTrace();
            result.fail("获取mission列表出错");
        } finally {
            return result;
        }
    }

    /**
     * 根据 missionId 获取mission详情信息
     * 信息包括mission本身的信息和报名信息
     * @author zgh
     * @param missionId
     * @return ApiResult
     */
    @RequestMapping("/missionInfo")
    @ResponseBody
    public ApiResult missionInfo(@RequestParam(value = "missionId", required = true) Integer missionId) {
        ApiResult result = new ApiResult();
        Map<String, Object> resultMap = new HashMap<>();
        //查询mission信息
        try {
            Mission mission = missionService.queryMissionInfo(missionId);
            if (null == mission) {
                logger.info("mission查询为空: missionId = " + missionId);
                result.success("任务信息为空");
            } else {
                resultMap.put("mission", mission);
            }
        } catch (Exception e) {
            logger.error("查询mission信息出错:missionId = " + missionId);
            e.printStackTrace();
            result.fail("获取mission信息出错");
            return result;
        }
        //查询报名成员列表
        try {
            List<MissionLicenseInfo> licenseInfoList = missionLicenseInfoServer.queryLicenseListByMissionId(missionId);
            resultMap.put("licenseList", licenseInfoList);
        } catch (Exception e) {
            logger.error("查询报名信息出错:missionId = " + missionId);
            e.printStackTrace();
            result.fail("查询报名信息出错");
            return result;
        }
        result.success(resultMap);
        return result;
    }

    /**
     * 保存mission，根据operate参数决定新建还是修改，最终保存的mission状态为草稿状态
     * @author zgh
     * @param groupId       任务所属团队
     * @param type          任务类型    1——拍牌任务
     * @param beginTime     任务开始时间
     * @param endTime       任务结束时间
     * @param description   任务描述
     * @param bookNum       标书数量
     * @param operate       操作类型    1——新建  2——修改
     * @return apiResult    data部分为新任务ID
     */
    @RequestMapping("/save")
    @ResponseBody
    public ApiResult saveMission(@RequestParam(value = "groupId", required = true)Integer groupId,
                                   @RequestParam(value = "type", required = true, defaultValue = "1")Integer type,
                                   @RequestParam(value = "beginTime", required = true)Date beginTime,
                                   @RequestParam(value = "endTime", required = true)Date endTime,
                                   @RequestParam(value = "description", required = true)String description,
                                   @RequestParam(value = "bookNum", required = true)Integer bookNum,
                                   @RequestParam(value="operate", required = true)Integer operate) {
        ApiResult result = new ApiResult();
        try {
            //构建一个mission
            Mission newMission = new Mission();
            newMission.setGroupId(groupId);
            newMission.setMissionType(type);
            newMission.setBeginTime(beginTime);
            newMission.setEndTime(endTime);
            newMission.setDescription(description);
            newMission.setBookNum(bookNum);
            //新建时修改时间和创建时间相同
            newMission.setUpdateTime(new Date());
            newMission.setState(MissionContants.MissionState.draft);

            //根据operate决定操作
            if (null == operate) {
                logger.info("参数不能为空!");
                result.fail("新建任务出错");
                return result;
            } else if (operate.equals(1)) {
                //新建保存
                Integer newMissionId = missionService.createMission(newMission);
                if (null == newMissionId) {
                    logger.info("新建任务失败" + newMission.toString());
                    result.fail("新建任务失败");
                } else {
                    logger.info("新建任务成功! missionId = " + newMissionId);
                    result.success(newMissionId);
                }
            } else if (operate.equals(2)) {
                //修改保存

            }

        } catch (Exception e) {
            logger.error("新建任务出错" + e.getMessage());
            e.printStackTrace();
            result.fail("新建任务失败");
        }
        return result;
    }

    /**
     * 修改Mission
     * @author zgh
     * @param request
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public ApiResult updateMission(HttpServletRequest request) {

        return null;
    }

    /**
     * 删除Mission
     * @author zgh
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ApiResult deleteMission(HttpServletRequest request) {

        return null;
    }

    /**
     * 将任务名额分配给分队
     * 传入参数中应有MissionId, GroupID, TeamId, TeamLicenseCount
     * @param request
     * @return
     */
    @RequestMapping("/allocate")
    @ResponseBody
    public ApiResult allocateMission(HttpServletRequest request) {

        return null;
    }

    /**
     * 发布Mission
     * @author zgh
     * @param missionID
     * @return
     */
    @RequestMapping("/publish")
    @ResponseBody
    public ApiResult publishMission(@RequestParam(value = "missionId", required = true)Integer missionID) {
        ApiResult result = new ApiResult();
        //任务状态修改为已发布
        try {
            Integer updateResult = missionService.modifyMissionState(missionID, 1);
            if (null == updateResult) {
                logger.info("发布失败");
            } else if (1 == updateResult) {
                logger.info("任务发布成功! missionId = " + missionID);
                result.success("发布成功");
            }
        } catch (Exception e) {
            logger.error("发布失败 missionId = " + missionID + e.getMessage());
            e.printStackTrace();
            result.fail("发布失败");
            return result;
        }
        //TODO:任务推送到消息表

        return result;
    }
}
