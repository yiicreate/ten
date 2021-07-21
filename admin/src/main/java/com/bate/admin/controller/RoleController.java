package com.bate.admin.controller;

import com.bate.admin.base.BaseController;
import com.bate.admin.entity.Role;
import com.bate.admin.service.RoleService;
import com.bate.core.vo.Page;
import com.bate.core.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: lh
 * @date: 2021/7/21
 */

@RestController
@RequestMapping(value = "/sys/role")
public class RoleController extends BaseController {
    @Autowired
    RoleService roleService;

    @PostMapping("/save")
    public Result save(Role role){
        roleService.save(role);
        return Result.success();
    }

    @PostMapping("/update")
    public Result update(Role role){
        roleService.update(role);
        return Result.success();
    }

    @PostMapping("/list")
    public Result list(Role role, HttpServletRequest request, HttpServletResponse response){
        Page<Role> page = new Page<>(request,response);
        page = roleService.findPage(page,role);
        return Result.success().put("page",page);
    }

    @PostMapping("/view")
    public Result one(Role role){
        Result r = Result.success();
        Role u = roleService.get(role.getId());
        r.put("data",u);
        return r;
    }
}
