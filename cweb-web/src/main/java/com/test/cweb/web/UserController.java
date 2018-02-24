package com.test.cweb.web;

import com.test.cweb.ApplicationController;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author caiminjie
 * @date 18/2/1
 */
@Controller
@RequestMapping("/user/login")
public class UserController extends ApplicationController {

    @Resource
    IUserService iUserService;



    @RequestMapping("/")
    public ModelAndView index() {
        return buildMAV("login.jsp", "login");
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
            apiResult.fail("error username");
            return apiResult;
        } catch (IncorrectCredentialsException ice) {
            apiResult.fail("error password");
            return apiResult;
        }
    }

    @RequestMapping("/findByAccount")
    @ResponseBody
    public ApiResult findAll(@RequestParam(value="name",required = true) String name){
        ApiResult apiResult = iUserService.findAll(name);
        return apiResult;
    }

    @RequestMapping("/profile")
    @ResponseBody
    public ModelAndView profile(){
        return buildMAV("profile.jsp", "profile");
    }
}
