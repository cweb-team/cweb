package com.test.cweb.web;

import com.test.cweb.model.*;
import com.test.cweb.model.constants.MessageContants;
import com.test.cweb.model.constants.MissionContants;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.*;
import com.test.cweb.utils.JsonObjectMapper;
import net.sf.json.JSONArray;
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

    @Resource
    IMessageService messageService;

    @Resource
    IUserGroupTeamService userGroupTeamService;

    @Resource
    IMissionLicenseAllocationService missionLicenseAllocationService;
    /**
     * 测试用接口
     *
     * @param request
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    public ApiResult test(HttpServletRequest request) {
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
     *
     * @param groupId
     * @param state
     * @param type
     * @return ApiResult
     * @author zgh
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
     *
     * @param missionId
     * @return ApiResult
     * @author zgh
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
     *
     * @param missionId   任务ID（修改任务时传入）
     * @param groupId     任务所属团队
     * @param type        任务类型    1——拍牌任务
     * @param beginTime   任务开始时间
     * @param endTime     任务结束时间
     * @param description 任务描述
     * @param bookNum     标书数量
     * @param operate     操作类型    1——新建  2——修改
     * @return apiResult    data部分为新任务ID
     * @author zgh
     */
    @RequestMapping("/save")
    @ResponseBody
    public ApiResult saveMission(@RequestParam(value = "missionId", required = false) Integer missionId,
                                 @RequestParam(value = "groupId", required = true) Integer groupId,
                                 @RequestParam(value = "type", required = true, defaultValue = "1") Integer type,
                                 @RequestParam(value = "beginTime", required = true) Integer beginTime,
                                 @RequestParam(value = "endTime", required = true) Integer endTime,
                                 @RequestParam(value = "description", required = true) String description,
                                 @RequestParam(value = "bookNum", required = true) Integer bookNum,
                                 @RequestParam(value = "operate", required = true) Integer operate) {
        ApiResult result = new ApiResult();
        try {
            //构建一个mission
            Mission mission = new Mission();
            if (null != missionId) {
                mission.setPkId(missionId);
            }
            mission.setGroupId(groupId);
            mission.setMissionType(type);
            mission.setBeginTime(new Date(beginTime));
            mission.setEndTime(new Date(endTime));
            mission.setDescription(description);
            mission.setBookNum(bookNum);
            //新建时修改时间和创建时间相同
            mission.setUpdateTime(new Date());
            mission.setState(MissionContants.MissionState.DRAFT);

            //根据operate决定操作
            if (null == operate) {
                logger.info("参数不能为空!");
                result.fail("新建任务出错");
                return result;
            } else if (operate.equals(MissionContants.MissionManage.ADD)) {
                //新建保存
                mission.setCreateTime(new Date());
                Integer newMissionId = missionService.createMission(mission);
                if (null == newMissionId) {
                    logger.info("新建任务失败" + mission.toString());
                    result.fail("新建任务失败");
                } else {
                    logger.info("新建任务成功! missionId = " + newMissionId);
                    result.success(newMissionId);
                }
            } else if (operate.equals(MissionContants.MissionManage.UPDATE)) {
                //修改保存
                int updateCount = missionService.updateMission(mission);
                if (1 == updateCount) {
                    result.success("任务修改成功");
                } else {
                    logger.info("任务修改失败");
                    result.fail("任务修改失败");
                }
            }

        } catch (Exception e) {
            logger.error("新建任务出错" + e.getMessage());
            e.printStackTrace();
            result.fail("新建任务失败");
        }
        return result;
    }

    /**
     * 删除Mission
     *
     * @param missionId 任务ID
     * @return
     * @author zgh
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ApiResult deleteMission(@RequestParam(value = "missionId", required = true) Integer missionId) {
        ApiResult result = new ApiResult();
        try {

            Integer deleteCount = missionService.deleteMission(missionId);
            if (deleteCount.equals(1)) {
                logger.info("任务删除成功：missionId: " + missionId);
                result.success("任务删除成功");
            } else {
                logger.info("任务删除失败：missionId: " + missionId);
                result.success("任务删除失败");
            }
        } catch (Exception e) {
            logger.error("删除任务出错");
            e.printStackTrace();
            result.fail("删除失败");
        } finally {
            return result;
        }
    }

    /**
     * 将任务名额分配给分队
     * 传入参数中应有MissionId, GroupID, TeamId, TeamLicenseCount
     *
     * @param missionId  任务ID
     * @param groupId    团队ID
     * @param allocation 任务分配
     * @return
     */
    @RequestMapping("/allocateLicense")
    @ResponseBody
    public ApiResult allocateLicense(@RequestParam(value = "missionId", required = true) Integer missionId,
                                     @RequestParam(value = "groupId", required = true) Integer groupId,
                                     @RequestParam(value = "allocation", required = true) String allocation) {
        ApiResult result = new ApiResult();
        try {
            if (null == missionId || null == groupId || null == allocation) {
                logger.info("参数不能为空");
                result.fail();
                return result;
            }

            //TODO:调用分配任务服务
        } catch (Exception e) {
            logger.error("任务分配出错" + e.getMessage());
            e.printStackTrace();
            result.fail();
        } finally {
            return result;
        }
    }

    /**
     * 发布Mission
     *
     * @param missionID 任务ID
     * @param userId    发布者ID
     * @param groupId   团队ID
     * @return
     * @author zgh
     */
    @RequestMapping("/publish")
    @ResponseBody
    public ApiResult publishMission(@RequestParam(value = "missionId", required = true) Integer missionID,
                                    @RequestParam(value = "userId", required = true) Integer userId,
                                    @RequestParam(value = "groupId", required = true) Integer groupId) {
        ApiResult result = new ApiResult();
        //任务状态修改为已发布
        try {
            Integer updateResult = missionService.modifyMissionState(missionID, 1);
            if (null == updateResult) {
                logger.info("发布失败");
                result.fail("发布失败");
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
        //任务推送到消息表
        try {
            //查询任务详情信息
            Mission mission = missionService.queryMissionInfo(missionID);
            //生成message实体
            Message message = new Message();
            message.setAuthor(userId);
            message.setMessageInfoId(missionID);
            message.setCreateTime(new Date());
            message.setUpdateTime(new Date());
            message.setTitle("拍牌任务发布");
            message.setType(MessageContants.MessageType.MESSAGE_MISSION_ID);

            //查询要推送的人群
            List<UserGroupTeam> userList = userGroupTeamService.findAllMebmerByGroupId(groupId);
            List<Integer> userIdList = new ArrayList<>();
            for (UserGroupTeam userGroupTeam : userList) {
                if (null != userGroupTeam.getUserId()) {
                    userIdList.add(userGroupTeam.getUserId());
                }
            }
            //消息推送
            result = messageService.pushMessage(message, userIdList);
        } catch (Exception e) {
            logger.error("推送到消息表出错 missionId = " + missionID);
            e.printStackTrace();
            result.fail();
        }
        return result;
    }

    /**
     * 查看报名情况
     * 返回数据包括任务名额综述，已报名数，分队——报名人数
     *
     * @param groupId   团队ID
     * @return ApiResult
     * @author zgh
     */
    @RequestMapping("/checkApply")
    @ResponseBody
    public ApiResult checkApplyCondition(@RequestParam(value = "groupId", required = true) Integer groupId,
                                         @RequestParam(value = "missionId", required = true) Integer missionId) {
        ApiResult result = new ApiResult();
        Map<String, Object> data = new HashMap<>();
        try {
            //查询任务情况，获取名额总数和已报名数
            Mission mission = new Mission();
            mission = missionService.queryMissionInfo(missionId);
            if (null != mission) {
                data.put("mission", mission);
            } else {
                logger.info("查无此任务 missionId = " + missionId);
                result.fail("没有这个任务");
                return result;
            }
            //查看分队报名情况
            List<MissionLicenseAllocation> teamSignUp = new ArrayList<>();
            teamSignUp = missionLicenseAllocationService.queryAllocationByMissionId(missionId);
            data.put("teamSignUp", teamSignUp);
            result.success(data);
        } catch (Exception e) {
            logger.error("查看报名情况发生错误");
            e.printStackTrace();
            result.fail();
        } finally {
            return result;
        }
    }

    /**
     * 查看屏幕截图
     *
     * @param request
     * @return
     */
    public ApiResult checkScreen(HttpServletRequest request) {
        return null;
    }

    /**
     * 查看成员完成某个任务的进度
     *
     * @param userId    用户ID
     * @param missionId 任务ID
     * @return ApiResult
     * @author zgh
     */
    @RequestMapping("/checkMemberProgress")
    @ResponseBody
    public ApiResult checkMemberProgress(@RequestParam(value = "userId", required = true) Integer userId,
                                         @RequestParam(value = "missionId", required = true) Integer missionId) {
        ApiResult result = new ApiResult();
        try {
            MissionLicenseInfo missionLicenseInfo = missionLicenseInfoServer.queryLicenseByMissionIdUserId(missionId, userId);
            if (null != missionLicenseInfo) {
                result.success(missionLicenseInfo);
            } else {
                result.fail("未查询到任务信息");
            }
        } catch (Exception e) {
            logger.error("查询成员进度出错");
            e.printStackTrace();
            result.fail("查询出错");
        } finally {
            return result;
        }
    }

    /**
     * 查看团队或分队任务汇总情况
     *
     * @param request
     * @return
     */
    public ApiResult checkSummary(HttpServletRequest request) {
        return null;
    }
}