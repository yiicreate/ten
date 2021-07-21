package com.bate.admin.service;

import com.bate.admin.entity.Role;
import com.bate.admin.ext.CrudService;
import com.bate.admin.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
 * @author: lh
 * @date: 2021/7/21
 */

@Service
public class RoleService extends CrudService<Role, RoleMapper> {
}
