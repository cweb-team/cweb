package com.test.cweb.service.impl;

import com.test.cweb.model.Permission;
import com.test.cweb.model.Role;
import com.test.cweb.model.User;
import com.test.cweb.dao.UserDao;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IUserService;
import org.springframework.stereotype.Service;
import org.apache.shiro.realm.Realm;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author caiminjie
 * @date 18/2/1
 */
@Service
public class UserService implements IUserService {

    @Resource
    UserDao userDao;

    @Override
    public ApiResult findOne(String name){
        ApiResult apiResult = new ApiResult();

        HashMap<String, Object> search = new HashMap<>();
        search.put("name", name);
        User user  = userDao.findOne(search);

        if(user != null) {
            apiResult.success(user);
        }else{
            apiResult.fail("用户不存在！");
        }

        return apiResult;
    }

    @Override
    public ApiResult findAll(String name){
        ApiResult apiResult = new ApiResult();

        HashMap<String,Object> search = new HashMap<>();
        search.put("name",name);
        User user = userDao.findAll(search);

        if(user != null) {
            apiResult.success(user);
        }else{
            apiResult.fail("用户不存在！");
        }

        return apiResult;
    }

    @Override
    public User findByAccount(String account){
        HashMap<String,Object> search = new HashMap<>();
        search.put("account",account);
        User user = userDao.selectByAccount(search);
        return user;
    }

    @Override
    public Set getRolesStr(String account){
        User user = this.findByAccount(account);

        Set<String> roles_str = user.getRolesStr();
        return roles_str;
    }

    @Override
    public Set getPermissionsStr(String account){
        User user= this.findByAccount(account);

        Set<String> perms_str = user.getPermissionsStr();
        return perms_str;
    }


}


