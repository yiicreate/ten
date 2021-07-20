package com.bate.admin.mapper;

import com.bate.admin.base.BaseMapper;
import com.bate.admin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: lh
 * @date: 2021/3/29
 */

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
   public User getByName(String userName);

   public User getByToken(String token);

   public int updateTokenById(String token, String id);

   public int updatePasswordById(String password, String id);
}
