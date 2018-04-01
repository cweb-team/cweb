package com.test.cweb.web;

import com.test.cweb.ApplicationController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/user/profile")
    public ModelAndView userProfile() {
        return buildMAV("profile.jsp","profile");
    }

    @RequestMapping("/indexMain")
    public ModelAndView indexMain() {return buildMAV("indexMain.jsp", "indexMain");}
}
