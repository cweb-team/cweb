package com.test.cweb.service.impl;

import com.test.cweb.CommonConstant;
import com.test.cweb.dao.MessageDao;
import com.test.cweb.dao.MessageRecordDao;
import com.test.cweb.model.Message;
import com.test.cweb.model.MessageRecord;
import com.test.cweb.model.constants.MessageContants;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IMessageService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public ApiResult pushMessage(Message message, List<Integer> targetUserList) {
        ApiResult result;

        //1、插入message到数据库，获取新的message_id

        //2、批量生成message_record

        return null;
    }

    @Override
    public ApiResult dealMessage(MessageRecord record, Integer messageType) {
        ApiResult result = new ApiResult();
        //TODO:数据是否有效

        if (record.getDealFlag().equals(MessageContants.MessageDealFlag.APPROVE)) {
            //操作类型为接收，根据messageType调用相应接口处理
            switch (messageType) {
                case MessageContants.MessageType.GROUP_INVITE:
                    //TODO:调用用户加入团队 入参：userId, GroupId,   返回：处理结果
                    break;
                case MessageContants.MessageType.GROUP_APPLY:
                    break;
                case MessageContants.MessageType.TEAM_INVITE:
                    break;
                case MessageContants.MessageType.TEAM_APPLY:
                    break;
                default:
                    break;
            }
        }
        //TODO:更新message_record相应数据

        return result;
    }
}
