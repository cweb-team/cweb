package com.test.cweb.web;

import com.test.cweb.CommonConstant;
import com.test.cweb.model.*;
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
import org.springframework.web.servlet.ModelAndView;
import com.test.cweb.ApplicationController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    ITeamService iTeamService;

    @Resource
    IUserGroupTeamService iUserGroupTeamService;

    @Resource
    HttpSession httpSession;

    @RequestMapping("/")
    public ModelAndView index() {
        return buildMAV("group.jsp", "group");
    }


    //检测是否登录
    //检测是否有创建团队的权限
    @RequestMapping("/createGroup.do")
    @ResponseBody
    public ApiResult createGroup(@RequestParam(value="groupName")String groupName,
                                 @RequestParam(value = "description") String description) {
        User user = (User) httpSession.getAttribute("user");

        Group group = new Group();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        group.setCreateTime(timestamp);
        group.setLeaderId(user.getPkId());
        group.setDescription(groupName);
        group.setGroupName(description);
        ApiResult apiResult = iGroupService.addOneGroup(group);

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
    public ApiResult modifyGroupInfo(@RequestParam(value="groupId")String groupId,
                                     @RequestParam(value="groupName")String groupName,
                                     @RequestParam(value = "description") String description) {

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
    @RequestMapping("/appointDuty.do")
    @ResponseBody
    public ApiResult appointDuty(@RequestParam(value="userId")String userId,
                                 @RequestParam(value="roleId")String roleId,
                                 @RequestParam(value="groupId")String groupId,
                                 @RequestParam(value="teamId",required = false,defaultValue = "")String teamId) {
        ApiResult apiResult = new ApiResult();

        User user = (User) httpSession.getAttribute("user");
        UserRole userRole = new UserRole();
        userRole.setUserId(Integer.parseInt(userId));
        userRole.setRoleId(Integer.parseInt(roleId));
        if (Integer.parseInt(roleId) == CommonConstant.ROLE_TEAM_LEADER_ID){
            UserGroupTeam userGroupTeam = new UserGroupTeam();
            userGroupTeam.setUserId(Integer.parseInt(userId));
            userGroupTeam.setGroupId(Integer.parseInt(groupId));
            userGroupTeam = iUserGroupTeamService.findByUserGroup(userGroupTeam);
            userGroupTeam.setTeamId(Integer.parseInt(teamId));
            apiResult = iUserService.updateUserGroupTeam(userGroupTeam);
            if(apiResult.getStatus() == ApiResult.SUCCESS_STATUS){
                apiResult = iUserService.addRole(userRole);
            }
        }else {
            apiResult = iUserService.addRole(userRole);
        }return apiResult;
    }

    //检测是否登录
    //检查是否有职务撤销的权限
    @RequestMapping("/removeDuty.do")
    @ResponseBody
    @RequiresRoles({CommonConstant.ROLE_GROUPLEADER_NAME, CommonConstant.ROLE_GROUPLEADER_SUB_NAME})
    public ApiResult removeDuty(@RequestParam(value="userId")String userId,
                                 @RequestParam(value="roleId")String roleId,
                                 @RequestParam(value="groupId")String groupId) {
        ApiResult apiResult = new ApiResult();
        User user = (User) httpSession.getAttribute("user");
        // 2. 检测执行者是否和被执行者在同一个团队下
        UserGroupTeam userGroupTeam0 = iUserGroupTeamService.findByUserId(Integer.parseInt(userId));
        if (userGroupTeam0.getGroupId() != Integer.parseInt(groupId)){
             apiResult.fail();
             return apiResult;
        }
        if (Integer.parseInt(roleId) == CommonConstant.ROLE_GROUPLEADER_SUB_ID) {
            Group group = iGroupService.findGroupByGroupId(Integer.parseInt(groupId));
            if (group.getLeaderId().equals(user.getPkId())){
                UserRole userRole = new UserRole();
                userRole.setUserId(Integer.parseInt(userId));
                userRole.setRoleId(Integer.parseInt(roleId));
                    apiResult = iUserService.removeRole(userRole);
            }else{
                apiResult.fail();
            }
        }else if (Integer.parseInt(roleId) == CommonConstant.ROLE_TEAM_LEADER_ID){
            UserRole userRole = new UserRole();
            userRole.setUserId(Integer.parseInt(userId));
            userRole.setRoleId(Integer.parseInt(roleId));
            apiResult = iUserService.removeRole(userRole);
        }else{
            apiResult.fail();
        }

        return apiResult;
    }


    /**
     * 创建新的分队
     * @param groupId
     * @param teamName
     * @param description
     * @return
     */
    @RequestMapping("/createOneTeam.do")
    @ResponseBody
    @RequiresRoles({CommonConstant.ROLE_GROUPLEADER_NAME, CommonConstant.ROLE_GROUPLEADER_SUB_NAME})
    public ApiResult createOneTeam(@RequestParam(value="groupId")String groupId,
                                @RequestParam(value="teamName")String teamName,
                                @RequestParam(value="description")String description) {
        User user = (User) httpSession.getAttribute("user");
        Team team = new Team();
        team.setGroupId(Integer.parseInt(groupId));
        team.setTeamName(teamName);
        team.setDescription(description);

        ApiResult apiResult = iTeamService.addOneTeam(team);
        return apiResult;
    }

    /**
     * 修改分队信息
     * @param teamId
     * @param teamName
     * @param description
     * @return
     */
    @RequestMapping("/modifyOneTeam.do")
    @ResponseBody
    @RequiresRoles({CommonConstant.ROLE_GROUPLEADER_NAME, CommonConstant.ROLE_GROUPLEADER_SUB_NAME})
    public ApiResult modifyOneTeam(@RequestParam(value="teamId")String teamId,
                                   @RequestParam(value="teamName")String teamName,
                                   @RequestParam(value="description")String description) {
        ApiResult apiResult = new ApiResult();
        User user = (User) httpSession.getAttribute("user");
        Team resultTeam = iTeamService.findOneTeam(Integer.parseInt(teamId));
        int groupId = resultTeam.getGroupId();
        UserGroupTeam userGroupTeam = iUserGroupTeamService.findByUserId(user.getPkId());
        if (userGroupTeam != null && userGroupTeam.getGroupId().equals(groupId)){
            Team team = new Team();
            team.setPkId(Integer.parseInt(teamId));
            team.setDescription(description);
            team.setTeamName(teamName);
            apiResult = iTeamService.updateOneTeam(team);
        }else{
            apiResult.fail("修改失败");
        }
        return apiResult;
    }


    @RequestMapping("/deleteOneTeam.do")
    @ResponseBody
    @RequiresRoles({CommonConstant.ROLE_GROUPLEADER_NAME, CommonConstant.ROLE_GROUPLEADER_SUB_NAME})
    public ApiResult deleteOneTeam(@RequestParam(value="groupId")String groupId,
                                   @RequestParam(value="teamId")String teamId) {

        ApiResult apiResult = new ApiResult();

        User user = (User) httpSession.getAttribute("user");
        UserGroupTeam userGroupTeam = iUserGroupTeamService.findByUserId(user.getPkId());
        if (userGroupTeam.getGroupId().equals(Integer.parseInt(groupId))){
            Team team = iTeamService.findOneTeam(Integer.parseInt(teamId));
            if (team.getGroupId().equals(Integer.parseInt(groupId))){
                apiResult= iTeamService.deleteOneTeam(Integer.parseInt(teamId));
            }else{
                apiResult.fail("删除失败");
            }
        }else{
            apiResult.fail("删除失败");
        }

        return apiResult;
    }

    //检测是否登录
    //检查是否有删除团队的权限
    @RequestMapping("/deleteGroup.do")
    @ResponseBody
    public ApiResult deleteGroup(@RequestParam(value="groupId")String groupId) {

        ApiResult apiResult = new ApiResult();

        User user = (User) httpSession.getAttribute("user");
        int userId = user.getPkId();
        Group group = iGroupService.findGroupByGroupId(Integer.parseInt(groupId));
        if (userId == group.getLeaderId()){
            apiResult = iGroupService.deleteGroup(Integer.parseInt(groupId));
        }

        return apiResult;
    }

    /**
     * 查看成员信息
     * @param groupId
     * @return
     */
    @RequestMapping("/checkAllMember.do")
    @ResponseBody
    public ApiResult checkAllMember(@RequestParam(value="groupId")String groupId) {

        ApiResult apiResult = new ApiResult();

        User user = (User) httpSession.getAttribute("user");
        int userId = user.getPkId();
        Group group = iGroupService.findGroupByGroupId(Integer.parseInt(groupId));
        List<User> userList = new ArrayList<User>();
        if (user.getPkId().equals(group.getLeaderId())){

            List<UserGroupTeam>  userGroupTeamList= iUserGroupTeamService.findAllMebmerByGroupId(Integer.parseInt(groupId));
            for (UserGroupTeam userGroupTeam : userGroupTeamList){
                User userResult = iUserService.findOneById(userGroupTeam.getUserId());
                User userTmp = new User();
                userTmp.setRealName(userResult.getRealName());
                userTmp.setPhoneNum(userResult.getPhoneNum());
                userTmp.setPkId(userResult.getPkId());
                userList.add(userTmp);
            }
            apiResult.success(userList);
        }

        return apiResult;
    }

    /**
     * 查看所有分队
     * @param groupId
     * @return
     */
    @RequestMapping("/checkAllTeam.do")
    @ResponseBody
    public ApiResult checkAllTeam(@RequestParam(value="groupId")String groupId) {
        ApiResult apiResult = iTeamService.findTeamsByGroupId(Integer.parseInt(groupId));
        return apiResult;
    }

}
