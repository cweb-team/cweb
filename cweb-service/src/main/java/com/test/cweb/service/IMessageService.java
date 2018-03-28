package com.test.cweb.service;

import com.test.cweb.model.Message;
import com.test.cweb.model.MessageRecord;
import com.test.cweb.model.result.ApiResult;

/**
 * @author hyl
 * @data 18/3/28 下午11:05
 */
public interface IMessageService {
    /**
     * 邀请加入分队 消息
     * @param message
     * @return
     */
    ApiResult inviteUserToTeam(Message message, MessageRecord messageRecord);

}
