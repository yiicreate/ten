package com.bate.core.utils;

import java.util.UUID;

/**
 * @author: lh
 * @date: 2021/3/31
 * 随机类
 */

public class RandUtil {
    /**
     * @return  生成uuid
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
