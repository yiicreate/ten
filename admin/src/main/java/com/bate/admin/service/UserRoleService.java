package com.bate.admin.service;

import com.bate.admin.entity.Role;
import com.bate.admin.entity.User;
import com.bate.admin.entity.UserRole;
import com.bate.admin.ext.CrudService;
import com.bate.admin.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lh
 * @date: 2021/7/21
 */

@Service
public class UserRoleService extends CrudService<UserRole, UserRoleMapper> {
    @Autowired
    RoleService roleService;

    /**
     * 初始化用户的角色
     * @param user
     * @return
     */
    public List<Role> findByUser(User user){
        List<UserRole> userRoles= mapper.findByUser(user.getId());
        List<Role> roles= new ArrayList<>();
        for (UserRole u:userRoles) {
            roles.add(roleService.get(u.RoleId));
        }
        return roles;
    };
}
