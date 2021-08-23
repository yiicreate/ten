package com.bate.core.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author: lh
 * @date: 2021/3/31
 * 随机类
 */

public class RandUtil {
    private final static String[] dict;
    /**
     * @return  生成uuid
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    static {
        dict = ("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z," +
                "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,0,1,2,3,4,5,6,7,8,9").split(",");
    }

    /**
     *  随机生成一段字符串
     * @param len
     * @return
     */
    public static String ranStr(Integer len){
        String str = "";
        Integer n = dict.length;
        for (int i=0; i<len;i++){
            str = str+dict[(new Random()).nextInt(n)];
        }
        return  str;
    }
}
