package com.test.cweb.web;

import com.test.cweb.ApplicationController;
import com.test.cweb.model.User;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IUserService;
import com.test.cweb.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

//    @RequestMapping("/parseLogin")
//    public ApiResult login(String name,String password){
//        User user = iUserService.findByAccount(name);
//        return apiResult;
//    }
}
