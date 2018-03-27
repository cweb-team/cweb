package com.test.cweb.web;

import com.test.cweb.ApplicationController;
import com.test.cweb.Common;
import com.test.cweb.model.Image;
import com.test.cweb.model.Team;
import com.test.cweb.model.User;
import com.test.cweb.model.UserGroupTeam;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IGroupService;
import com.test.cweb.service.ITeamService;
import com.test.cweb.service.IUserGroupTeamService;
import com.test.cweb.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
    @RequiresRoles({Common.ROLE_TEAM_LEADER_NAME})
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
}
