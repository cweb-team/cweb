package com.test.cweb.web;

import com.test.cweb.model.Group;
import com.test.cweb.model.User;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IGroupService;
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
    HttpSession httpSession;

    @RequestMapping("/")
    public ModelAndView index() {
        return buildMAV("group.jsp", "group");
    }


    //检测是否登录
    //检测是否有创建团队的权限
    @RequestMapping("/addOneGroup.do")
    @ResponseBody
    public ApiResult addOneGroup(@RequestParam(value="groupName",required = true)String groupName,@RequestParam(value = "description",required = true) String description) {
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


}
