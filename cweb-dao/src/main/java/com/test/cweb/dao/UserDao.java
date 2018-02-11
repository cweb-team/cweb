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
    User findByAccount(HashMap<String,Object> search);
}
