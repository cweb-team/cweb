package com.test.cweb;

import com.test.cweb.dao.MissionDao;
import com.test.cweb.model.Mission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by feir4 on 2018/3/31.
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class MissionTest {

    @Resource
    MissionDao missionDao;

    @Test
    public void testInsertMission(){
        Mission mission = new Mission();
        mission.setState(0);
        mission.setCreateTime(new Date());
        mission.setUpdateTime(new Date());
        mission.setBookNum(10);
        mission.setDescription("测试数据");
        mission.setBeginTime(new Date());
        mission.setEndTime(new Date());
        mission.setMissionType(1);
        mission.setGroupId(1);
        int resultLine = missionDao.insert(mission);
        System.out.println("插入条数:" + resultLine);
        System.out.println(mission.toString());
    }
}
