package com.test.cweb.web;

import com.test.cweb.ApplicationController;
import com.test.cweb.CommonConstant;
import com.test.cweb.TimeUtil;
import com.test.cweb.model.*;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hyl
 * @data 18/3/21 下午10:04
 */
@Controller
@RequestMapping("/user/profile/Team")
public class TeamManageController extends ApplicationController {

    @Resource
    IGroupService iGroupService;

    @Resource
    IUserService iUserService;

    @Resource
    ITeamService iTeamService;

    @Resource
    IUserGroupTeamService iUserGroupTeamService;

    @Resource
    HttpSession httpSession;

    @Resource
    IMessageService iMessageService;

    /**
     * 修改分队信息
     * @param teamId
     * @param teamName
     * @param description
     * @return
     */
    @RequestMapping("/modifyMyTeam.do")
    @ResponseBody
    public ApiResult modifyMyTeam(@RequestParam(value="teamId",required = true)String teamId,
              @RequestParam(value="teamName",required = true)String teamName,
              @RequestParam(value="description",required = true)String description) {
        ApiResult apiResult = new ApiResult();
        User user = (User) httpSession.getAttribute("user");
        Team resultTeam = iTeamService.findOneTeam(Integer.parseInt(teamId));
        if (resultTeam.getLeaderId().equals(user.getPkId())){
            Team team = new Team();
            team.setPkId(Integer.parseInt(teamId));
            team.setTeamName(teamName);
            team.setDescription(description);
            apiResult = iTeamService.updateOneTeam(team);
        }else{
            apiResult.fail("修改失败");
        }

        return apiResult;
    }

    @RequestMapping("/removeMember.do")
    @ResponseBody
    @RequiresRoles({CommonConstant.ROLE_TEAM_LEADER_NAME})
    public ApiResult removeMember(@RequestParam(value="userId")String userId,
              @RequestParam(value="teamId",required = true)String teamId) {
        ApiResult apiResult = new ApiResult();
        User user = (User) httpSession.getAttribute("user");
        int userIdInt = Integer.parseInt(userId);
        int teamIdInt = Integer.parseInt(teamId);
        UserGroupTeam userGroupTeam0 = iUserGroupTeamService.findByUserId(user.getPkId());
        if (userGroupTeam0.getTeamId().equals(teamIdInt)){
            UserGroupTeam userGroupTeam1 = iUserGroupTeamService.findByUserId(userIdInt);
            if (userGroupTeam1.getTeamId().equals(teamIdInt)){
                apiResult = iTeamService.removeOneMember(userIdInt);
            }else{
                apiResult.fail("删除失败");
            }
        }

        return apiResult;
    }

    @RequestMapping("/inviteMember.do")
    @ResponseBody
    @RequiresRoles({CommonConstant.ROLE_TEAM_LEADER_NAME})
    public ApiResult inviteMember(@RequestParam(value="userId")String userId,
              @RequestParam(value="teamId",required = true)String teamId) {
        ApiResult apiResult = new ApiResult();
        User user = (User) httpSession.getAttribute("user");
        int userIdInt = Integer.parseInt(userId);
        int teamIdInt = Integer.parseInt(teamId);
        UserGroupTeam invitingUserGroupTeam = iUserGroupTeamService.findByUserId(user.getPkId());
        UserGroupTeam invitedUserGroupTeam = iUserGroupTeamService.findByUserId(userIdInt);
        Boolean invitable = invitedUserGroupTeam == null ||
                (invitedUserGroupTeam != null
                    && invitingUserGroupTeam.getGroupId().equals(invitedUserGroupTeam.getGroupId())
                    && invitedUserGroupTeam.getTeamId() == null);
        if (invitable){
            if (invitingUserGroupTeam.getTeamId().equals(teamIdInt)){
                Message message = new Message();
                message.setAuthor(user.getPkId());
                message.setCreateTime(TimeUtil.getLocalTime_v1());

                MessageRecord messageRecord = new MessageRecord();
                messageRecord.setUserId(userIdInt);
                apiResult = iMessageService.inviteUserToTeam(message,messageRecord);

                if (apiResult.getStatus().equals(ApiResult.SUCCESS_STATUS)){
                    apiResult.success("发出邀请成功");
                }
            }else{
                apiResult.fail("发出邀请失败");
            }
        }else{
            apiResult.fail("发出邀请失败");
        }

        return apiResult;
    }

    /**
     * 查看分队成员信息
     * @param teamId
     * @return
     */
    @RequestMapping("/checkAllMember.do")
    @ResponseBody
    @RequiresRoles({CommonConstant.ROLE_TEAM_LEADER_NAME})
    public ApiResult checkAllMember(@RequestParam(value="teamId")String teamId) {

        ApiResult apiResult = new ApiResult();

        User user = (User) httpSession.getAttribute("user");
        int teamIdInt = Integer.parseInt(teamId);
        Team team = iTeamService.findOneTeam(teamIdInt);
        List<User> userList = new ArrayList<User>();
        if (user.getPkId().equals(team.getLeaderId())){
            List<UserGroupTeam>  userGroupTeamList= iUserGroupTeamService.findAllMemberByTeamId(teamIdInt);
            for (UserGroupTeam userGroupTeam : userGroupTeamList){
                userList.add(userGroupTeam.getUser());
            }
            apiResult.success(userList);
        }

        return apiResult;
    }


}
//                if (invitedUserGroupTeam == null){
//                    invitedUserGroupTeam = new UserGroupTeam();
//                    invitedUserGroupTeam.setGroupId(invitingUserGroupTeam.getGroupId());
//                    invitedUserGroupTeam.setTeamId(teamIdInt);
//                    invitedUserGroupTeam.setUserId(userIdInt);
//                    invitedUserGroupTeam.setGroupTime(TimeUtil.getLocalTime_v1());
//                    invitedUserGroupTeam.setTeamTime(TimeUtil.getLocalTime_v1());
//                    apiResult =iUserGroupTeamService.addOneRecord(invitedUserGroupTeam);
//                }else{
//                    invitedUserGroupTeam.setTeamId(teamIdInt);
//                    invitedUserGroupTeam.setTeamTime(TimeUtil.getLocalTime_v1());
//                    apiResult = iUserGroupTeamService.updateOneRecord(invitedUserGroupTeam);
//                }