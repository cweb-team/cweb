package com.test.cweb.web;

import com.test.cweb.dao.GroupDao;
import com.test.cweb.model.Group;
import com.test.cweb.model.User;
import com.test.cweb.model.UserGroupTeam;
import com.test.cweb.model.UserRole;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IGroupService;
import com.test.cweb.service.IUserService;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.test.cweb.ApplicationController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 *  @author HYL
 *  @date 18/3/11
 */

@Controller
@RequestMapping("/user/profile/Group")
public class GroupManageController extends ApplicationController{

    @Resource
    IGroupService iGroupService;

    @Resource
    IUserService iUserService;

    @Resource
    HttpSession httpSession;

    @RequestMapping("/")
    public ModelAndView index() {
        return buildMAV("group.jsp", "group");
    }


    //检测是否登录
    //检测是否有创建团队的权限
    @RequestMapping("/addOneGroup.do")
    @ResponseBody
    public ApiResult addOneGroup(@RequestParam(value="groupName",required = true)String groupName,
                                 @RequestParam(value = "description",required = true) String description) {
        User user = (User) httpSession.getAttribute("user");

        Group group = new Group();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        group.setCreateTime(timestamp);
        group.setLeaderId(user.getPkId());
        group.setDescription(groupName);
        group.setGroupName(description);
        ApiResult apiResult = iGroupService.addOne(group);

        return apiResult;
    }

    //检测是否登录
    @RequestMapping("/checkGroupInfo.do")
    @ResponseBody
    public ApiResult checkGroupInfo() {
        User user = (User) httpSession.getAttribute("user");
        ApiResult apiResult = iGroupService.findGroupByUserId(user.getPkId());
        return apiResult;
    }

    //检测是否登录
    //检查是否有修改团队信息的权限
    @RequestMapping("/modifyGroupInfo.do")
    @ResponseBody
    public ApiResult modifyGroupInfo(@RequestParam(value="groupId",required = true)String groupId,
                                     @RequestParam(value="groupName",required = true)String groupName,
                                     @RequestParam(value = "description",required = true) String description) {

        User user = (User) httpSession.getAttribute("user");
        Group group = new Group();
        group.setPkId(Integer.parseInt(groupId));
        group.setDescription(description);
        group.setGroupName(groupName);
        ApiResult apiResult = iGroupService.updateGroup(group);
        return apiResult;
    }

    //检测是否登录
    //检查是否有职务任命的权限
    @RequestMapping("/appointRole.do")
    @ResponseBody
    public ApiResult appointDuty(@RequestParam(value="userId",required = true)String userId,
                                 @RequestParam(value="roleId",required = true)String roleId,
                                 @RequestParam(value="groupId",required = true)String groupId,
                                 @RequestParam(value="teamId",required = false)String teamId) {
        ApiResult apiResult = new ApiResult();

        User user = (User) httpSession.getAttribute("user");
        UserRole userRole = new UserRole();
        userRole.setUserId(Integer.parseInt(userId));
        userRole.setRoleId(Integer.parseInt(roleId));
        if (Integer.parseInt(roleId) == 4){
            UserGroupTeam userGroupTeam = new UserGroupTeam();
            userGroupTeam.setUserId(Integer.parseInt(userId));
            userGroupTeam.setGroupId(Integer.parseInt(groupId));
            userGroupTeam = iUserService.findByUserGroup(userGroupTeam);
            userGroupTeam.setTeamId(Integer.parseInt(teamId));
            apiResult = iUserService.updateUserGroupTeam(userGroupTeam);
            if(apiResult.getStatus() == 200){
                apiResult = iUserService.addRole(userRole);
            }
        }else {
            apiResult = iUserService.addRole(userRole);
        }return apiResult;
    }

}
