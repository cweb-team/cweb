package com.test.cweb.dao;

import java.util.HashMap;
import com.test.cweb.model.User;

/**
 * @author caiminjie
 * @date 18/2/1
 */
public interface UserDao {

    User findOne(HashMap<String,Object> search);
    User findAll(HashMap<String,Object> search);

    User selectByAccount(HashMap<String,Object> search);

    int deleteByPrimaryKey(Integer pkId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}

