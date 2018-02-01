package com.test.cweb.service;

import com.test.cweb.model.result.ApiResult;

/**
 * @author caiminjie
 * @date 18/2/1
 */

public interface IUserService {
    ApiResult findOne(String name);
}
