package com.test.cweb;


import com.test.cweb.model.User;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserLoginTest {

    @Resource
    IUserService iUserService;

    @Test
    public void UserTest(){
        String account="abc123";
        User user = iUserService.findByAccount(account);
        System.out.print(user);
    }

    @Test
    public void LoginTest(){
        ApiResult apiResult = new ApiResult();
        String account= "abc123";
        String password = "abc123";
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
//        token.setRememberMe(userValidate.getRememberme());
        try {
            SecurityUtils.getSubject().login(token);
            apiResult.success("login success");
            System.out.println(apiResult);
        } catch (UnknownAccountException uae) {
            apiResult.fail("error username");
            System.out.println(apiResult);
        } catch (IncorrectCredentialsException ice) {
            apiResult.fail("error password");
            System.out.println(apiResult);
        }
    }


    @Test
    public void testHelloworld() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
         Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
    }

//    @Test
//    public void RealmServiceTest(){
//        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
//        SecurityManager securityManager = factory.getInstance();
//        SecurityUtils.setSecurityManager(securityManager);
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
//        try {
//            //4、登录，即身份验证
//            subject.login(token);
//        } catch (AuthenticationException e) {
//            //5、身份验证失败
//        }
//        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
//        //6、退出
//        subject.logout();
//    }

}
