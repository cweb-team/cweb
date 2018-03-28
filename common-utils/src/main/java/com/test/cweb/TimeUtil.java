package com.test.cweb;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hyl
 * @data 18/3/28 下午10:05
 */
public class TimeUtil {
    /**
     * 返回格式为 yyyy-MM-dd HH:mm:ss.xyz
     * @return
     */
    public static Timestamp getLocalTime_v0(){
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        return  currentTime;
    }

    /**
     * 返回格式为 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Timestamp getLocalTime_v1() {
        //获得系统时间.
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将时间格式转换成符合Timestamp要求的格式.
        String nowTime = sdf.format(currentTimeMillis);
        //把时间转换
        Timestamp currentTime =Timestamp.valueOf(nowTime);
        return currentTime;
    }
}
