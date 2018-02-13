package com.test.cweb.web;

import com.test.cweb.ApplicationController;
import com.test.cweb.model.User;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IUserService;
import com.test.cweb.service.impl.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/login")
public class LoginController extends ApplicationController{

    @Resource
    IUserService iUserService;

    @RequestMapping("/")
    public ModelAndView index() {
        return buildMAV("login.jsp","login");
    }

    @RequestMapping("/tryLogin")
    @ResponseBody
    public ApiResult tryLogin(@RequestParam(value="account",required = true) String account,@RequestParam(value="password",required = true) String password){
        ApiResult apiResult = new ApiResult();
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
//        token.setRememberMe(userValidate.getRememberme());
        try {
            SecurityUtils.getSubject().login(token);
            apiResult.success("login success");
            return apiResult;
        } catch (UnknownAccountException uae) {
            apiResult.success("error username");
            return apiResult;
        } catch (IncorrectCredentialsException ice) {
            apiResult.success("error password");
            return apiResult;
        }
    }
//    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
//    @ResponseBody
//    public User adduser(@RequestBody User u) {
//        String pwd = u.getPassword();
//        String newpwd = passwordService.encryptPassword(pwd);
//        u.setPassword(newpwd);
//        User user = iUserService.createUser(u);
//        int uid = user.getUserid();
//        List<Mapping_UR> urlist = u.getMapping_UR();
//        if (urlist != null) {
//            for (Mapping_UR ur : urlist) {
//                if (ur != null) {
//                    int roleid = ur.getRole().getRoleid();
//                    userService.correlationRoles(uid, roleid);
//                }
//            }
//        }
//
//        return user;
//    }
}
