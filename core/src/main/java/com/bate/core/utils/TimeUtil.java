package com.bate.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: lh
 * @date: 2021/7/13
 *
 * 时间工具类
 */


public class TimeUtil  {

    /**
     * 当前时间（秒）
     * @return
     */
    public static Long currentTime(){
        return System.currentTimeMillis()/1000;
    }

    /**
     * 获取当前时间（yyyy-MM-dd kk:mm:ss）
     */
    public static String currentDate(){
        Date date = new Date();
        SimpleDateFormat current = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        return current.format(date);
    }

    /**
     * 获取当前时间（yyyy-MM-dd）
     */
    public static String currentDay(){
        Date date = new Date();
        SimpleDateFormat current = new SimpleDateFormat("yyyy-MM-dd");
        return current.format(date);
    }

}
