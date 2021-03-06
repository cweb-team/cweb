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

    UserGroupTeam selectMultiUserByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") UserGroupTeam record, @Param("example") UserGroupTeamExample example);

    int updateByExample(@Param("record") UserGroupTeam record, @Param("example") UserGroupTeamExample example);

    int updateByPrimaryKeySelective(UserGroupTeam record);

    int updateByPrimaryKey(UserGroupTeam record);

    /**
     * 将Team字段设成null 用于删除team时级联操作
     * @param teamId
     * @return
     */
    int updateTeamToNull(int teamId);

    /**
     * 根据userId将Team字段设成null
     * @param userId
     * @return
     */
    int updateTeamToNullByUserId(int userId);
}