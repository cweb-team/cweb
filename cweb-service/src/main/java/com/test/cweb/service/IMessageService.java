package com.test.cweb.service;

import com.test.cweb.model.Message;
import com.test.cweb.model.MessageRecord;
import com.test.cweb.model.result.ApiResult;

import java.util.List;

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

    /**
     * 消息推送
     * 生成新的消息，依次插入message和message_record表中
     * @param message           消息主体
     * @param targetUserList    推送的用户列表
     * @return
     */
    ApiResult pushMessage(Message message, List<Integer> targetUserList);

    /**
     * 用户处理消息
     * @param record        message_record
     * @param messageType   消息类型
     * @return
     */
    ApiResult dealMessage(MessageRecord record, Integer messageType);
}
