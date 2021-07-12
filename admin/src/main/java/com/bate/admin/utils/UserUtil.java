package com.bate.admin.utils;

import com.bate.admin.entity.User;
import com.bate.admin.service.UserService;
import com.bate.core.utils.AppUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

/**
 * @author: lh
 * @date: 2021/7/12
 */

public class UserUtil {
    public static User getByLoginName(String userName){
        return null;
    }
    /**
     * 通过token 获取用户
     * @param token
     * @return
     */
    public static User getUserByToken(String token){
        return AppUtil.getBean(UserService.class).getByToken(token);
    }

    /**
     * 获取当前用户(根据token)
     * @return
     */
    public static User getCurrentUser(){
        Subject subject = SecurityUtils.getSubject();
        Object token = subject.getPrincipal();
        User u = getUserByToken((String) token);
        return u!=null?u:new User();
    }

}
