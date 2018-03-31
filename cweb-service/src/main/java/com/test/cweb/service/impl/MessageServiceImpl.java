package com.test.cweb.service.impl;

import com.test.cweb.CommonConstant;
import com.test.cweb.dao.MessageDao;
import com.test.cweb.dao.MessageRecordDao;
import com.test.cweb.model.Message;
import com.test.cweb.model.MessageRecord;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IMessageService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hyl
 * @data 18/3/28 下午11:06
 */
@Component
public class MessageServiceImpl implements IMessageService {
    @Resource
    MessageDao messageDao;

    @Resource
    MessageRecordDao messageRecordDao;

    @Override
    public ApiResult inviteUserToTeam(Message message, MessageRecord messageRecord) {
        ApiResult apiResult = new ApiResult();
        message.setType(CommonConstant.MESSAGE_TEAM_INVITE_ID);
        int result = messageDao.insertSelective(message);
        if (result != 0){
            messageRecord.setMessageId(message.getPkId());
            int recordResult = messageRecordDao.insertSelective(messageRecord);
            if (recordResult != 0){
                apiResult.success();
            }else{
                apiResult.fail();
            }
        }else {
            apiResult.fail();
        }
        return apiResult;
    }
}
