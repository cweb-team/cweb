package com.test.cweb.dao;

import java.util.HashMap;
import java.util.List;

import com.test.cweb.model.User;
import com.test.cweb.model.UserExample;
import org.apache.ibatis.annotations.Param;

/**
 * @author caiminjie
 * @date 18/2/1
 */
public interface UserDao {

    User findOne(HashMap<String,Object> search);
    User findAll(HashMap<String,Object> search);

    User selectByAccount(HashMap<String,Object> search);

    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}

