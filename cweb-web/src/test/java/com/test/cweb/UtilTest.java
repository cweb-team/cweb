package com.test.cweb;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Timestamp;

/**
 * @author hyl
 * @data 18/3/28 下午10:12
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UtilTest {
    @Test
    public void GetLocalTimeTest() {
        Timestamp localTime_v0 = TimeUtil.getLocalTime_v0();
        Timestamp localTime_v1 = TimeUtil.getLocalTime_v1();
    }

}
