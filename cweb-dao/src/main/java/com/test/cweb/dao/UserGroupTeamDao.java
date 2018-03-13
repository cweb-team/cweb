package com.test.cweb.dao;

import com.test.cweb.model.UserGroupTeam;
import com.test.cweb.model.UserGroupTeamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupTeamDao {
    int countByExample(UserGroupTeamExample example);

    int deleteByExample(UserGroupTeamExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(UserGroupTeam record);

    int insertSelective(UserGroupTeam record);

    List<UserGroupTeam> selectByExample(UserGroupTeamExample example);

    UserGroupTeam selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") UserGroupTeam record, @Param("example") UserGroupTeamExample example);

    int updateByExample(@Param("record") UserGroupTeam record, @Param("example") UserGroupTeamExample example);

    int updateByPrimaryKeySelective(UserGroupTeam record);

    int updateByPrimaryKey(UserGroupTeam record);
}