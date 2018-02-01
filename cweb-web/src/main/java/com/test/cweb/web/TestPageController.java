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

import javax.annotation.Resource;

/**
 * @author caiminjie
 * @date 18/1/23
 */
@Controller
public class TestPageController extends ApplicationController{

    @RequestMapping("/")
    public ModelAndView index() {
        return buildMAV("index.jsp");
    }
}
