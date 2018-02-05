package com.test.cweb.web;

import com.test.cweb.ApplicationController;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

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

    @RequestMapping("/findOne")
    @ResponseBody
    public ApiResult findOne(@RequestParam(value="name",required = true) String name){
        ApiResult apiResult = iUserService.findOne(name);
        return apiResult;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public ApiResult findAll(@RequestParam(value="name",required = true) String name){
        ApiResult apiResult = iUserService.findAll(name);
        return apiResult;
    }
}
