package com.test.cweb.dao;

import com.test.cweb.model.Group;
import com.test.cweb.model.GroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author hyl
 * @date 2018/02/25
 */
public interface GroupDao {

    int countByExample(GroupExample example);

    int deleteByExample(GroupExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(Group record);

    int insertSelective(Group record);

    List<Group> selectByExample(GroupExample example);

    Group selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
}