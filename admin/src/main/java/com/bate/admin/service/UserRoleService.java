package com.bate.admin.service;

import com.bate.admin.entity.UserRole;
import com.bate.admin.ext.CrudService;
import com.bate.admin.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
 * @author: lh
 * @date: 2021/7/21
 */

@Service
public class UserRoleService extends CrudService<UserRole, UserRoleMapper> {
}
