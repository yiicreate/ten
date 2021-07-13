package com.bate.admin.service;

import com.bate.admin.entity.User;
import com.bate.admin.ext.CrudService;
import com.bate.admin.mapper.UserMapper;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

/**
 * @author: lh
 * @date: 2021/6/3
 */
@Service
public class UserService extends CrudService<User, UserMapper> {
    private static final String salt = "PAS_SS";
    public User getByName(String name){
        return mapper.getByName(name);
    };

    public User getByToken(String token){
        return mapper.getByToken(token);
    };

    @Override
    public int save(User t){
        t.preInsert();
        t.setPassword(encodePass(t.getPassword()));
        return mapper.save(t);
    }

    /**
     * 生成密码
     * @param passWord
     * @return
     */
    public String encodePass(String passWord){
        return new Sha256Hash(passWord,salt).toString();
    }

    /**
     * 对比密码
     * @param now 上传的登录密码
     * @param old 原加密的密码
     * @return
     */
    public boolean verify(String now,String old){
        String a = encodePass(now);
        if(old.equals(a)){
            return true;
        }
        return false;
    }

    public int updateTokenById(String token,String id){
        return  mapper.updateTokenById(token,id);
    };
    public int updatePasswordById(String password,String id){
        return  mapper.updateTokenById(password,id);
    };

}
