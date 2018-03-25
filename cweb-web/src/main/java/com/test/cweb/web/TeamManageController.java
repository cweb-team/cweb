package com.test.cweb.web;

import com.test.cweb.ApplicationController;
import com.test.cweb.model.Team;
import com.test.cweb.model.User;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IGroupService;
import com.test.cweb.service.ITeamService;
import com.test.cweb.service.IUserService;
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
    HttpSession httpSession;

    //检测是否登录
    //检查是否有删除分队的权限
    @RequestMapping("/deleteOneTeam.do")
    @ResponseBody
    public ApiResult deleteOneTeam(@RequestParam(value="groupId",required = true)String groupId,
                                   @RequestParam(value="teamId",required = true)String teamId) {

        ApiResult apiResult = new ApiResult();

        User user = (User) httpSession.getAttribute("user");
        Team team = iTeamService.findOneTeam(Integer.parseInt(teamId));
        int resultGroupId = team.getGroupId();
        if (resultGroupId == Integer.parseInt(groupId)){
            apiResult= iTeamService.deleteOneTeam(Integer.parseInt(teamId));
        }else{
            apiResult.fail("删除失败");
        }

        return apiResult;
    }

    public ApiResult modifyOneTeam(@RequestParam(value="teamId",required = true)String teamId,
                                   @RequestParam(value="teamName",required = true)String teamName,
                                   @RequestParam(value="description",required = true)String description) {
        User user = (User) httpSession.getAttribute("user");
        Team team = new Team();
        team.setPkId(Integer.parseInt(teamId));
        team.setTeamName(teamName);
        team.setDescription(description);

        ApiResult apiResult = iTeamService.updateOneTeam(team);
        return apiResult;
    }
}
