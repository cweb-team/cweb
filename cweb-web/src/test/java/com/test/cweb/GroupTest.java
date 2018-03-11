package com.test.cweb;

import com.test.cweb.model.Group;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IGroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.sql.Timestamp;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class GroupTest {

    @Resource
    IGroupService iGroupService;

    @Test
    public void GroupMybatisTest(){
        Group group = new Group();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        group.setCreateTime(timestamp);
        group.setLeaderId(0);
        group.setDescription("test");
        group.setGroupName("testGroup");
        ApiResult apiResult = iGroupService.addOne(group);

        if(apiResult.getStatus() != 200){
            System.out.println("success");
        }
    }

    @Test
    public void AllGroupMybatisTest(){
        ApiResult apiResult = iGroupService.findAll();

        if(apiResult.getStatus() != 200){
            System.out.println("success");
        }
    }
}
