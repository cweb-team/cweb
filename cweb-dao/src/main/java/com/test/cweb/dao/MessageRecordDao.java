package com.test.cweb.dao;

import com.test.cweb.model.MessageRecord;
import com.test.cweb.model.MessageRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageRecordDao {
    int countByExample(MessageRecordExample example);

    int deleteByExample(MessageRecordExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(MessageRecord record);

    int insertSelective(MessageRecord record);

    List<MessageRecord> selectByExample(MessageRecordExample example);

    MessageRecord selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") MessageRecord record, @Param("example") MessageRecordExample example);

    int updateByExample(@Param("record") MessageRecord record, @Param("example") MessageRecordExample example);

    int updateByPrimaryKeySelective(MessageRecord record);

    int updateByPrimaryKey(MessageRecord record);
}