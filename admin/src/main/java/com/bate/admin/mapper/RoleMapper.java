package com.bate.admin.mapper;

import com.bate.admin.base.BaseMapper;
import com.bate.admin.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: lh
 * @date: 2021/7/21
 */

@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {
}
