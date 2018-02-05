package com.test.cweb.web;

import com.test.cweb.ApplicationController;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IUserService;
import com.test.cweb.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/logintest")
public class LoginController extends ApplicationController{
    @RequestMapping("/")
    
    public ModelAndView index() {
        return buildMAV("test.jsp");
    }
}
