package com.test.cweb.service.impl;

import com.test.cweb.model.User;
import com.test.cweb.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class UserRealmService extends AuthorizingRealm {

    @Resource
    IUserService iUserService;


    /**
     * 验证当前登录的用户，获取认证信息
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String account = (String)token.getPrincipal();  				//得到账号
        String password = new String((char[])token.getCredentials()); 	//得到密码

        User user = iUserService.findByAccount(account);

        /**检测是否有此用户 **/
        if(user == null){
            throw new UnknownAccountException();//没有找到账号异常
        }
//        /**检验账号是否被锁定 **/
//        if(Boolean.TRUE.equals(user.getLocked())){
//            throw new LockedAccountException();//抛出账号锁定异常
//        }
        /**AuthenticatingRealm 使用 CredentialsMatcher 进行密码匹配**/
        if(null != account && null != password){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getAccount(), password, getName());
            Subject currentUser = SecurityUtils.getSubject();
            Session session = currentUser.getSession();
            session.setAttribute("user",user);
            return simpleAuthenticationInfo;
        }else{
            return null;
        }

    }

    //
    /**
     * 为当前登陆成功的用户授予权限和角色，已经登陆成功了
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
     * @see AuthorizingRealm#doGetAuthorizationInfo(PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {

        String account = (String)pc.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        authorizationInfo.setRoles(iUserService.getRoles(account));
        authorizationInfo.setStringPermissions(iUserService.getPermissions(account));
//        System.out.println("Shiro 授权");
        return authorizationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }
}
