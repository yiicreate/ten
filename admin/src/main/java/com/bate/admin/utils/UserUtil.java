package com.bate.admin.utils;

import com.bate.admin.entity.User;
import com.bate.admin.service.UserService;
import com.bate.core.utils.AppUtil;
import com.bate.core.utils.CacheUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author: lh
 * @date: 2021/7/12
 */

public class UserUtil {
    public static final String USER_CACHE = "userCache";
    public static final String USER_CACHE_ID_ = "user_Id_";
    public static final String USER_CACHE_LOGIN_ = "user_Id_";

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

    public static User getUserById(String id){
        User user = (User) CacheUtil.get(USER_CACHE,USER_CACHE_ID_+id);
        if(user == null){
            user = AppUtil.getBean(UserService.class).get(id);
            if(user != null){
                CacheUtil.put(USER_CACHE,USER_CACHE_ID_+user.getId(),user);
                CacheUtil.put(USER_CACHE,USER_CACHE_LOGIN_+user.getUserName(),user);
            }
        }
        return user;
    }

}
