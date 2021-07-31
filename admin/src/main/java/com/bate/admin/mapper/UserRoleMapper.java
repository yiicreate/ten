package com.bate.admin.mapper;

import com.bate.admin.base.BaseMapper;
import com.bate.admin.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: lh
 * @date: 2021/7/21
 */

@Mapper
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {
    public List<UserRole> findByUser(String userId);
}
