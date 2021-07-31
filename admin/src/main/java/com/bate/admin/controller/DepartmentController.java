package com.bate.admin.controller;

import com.bate.admin.base.BaseController;
import com.bate.admin.entity.Department;
import com.bate.admin.service.DepartmentService;
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
 * @date: 2021/7/31
 */

@RestController
@RequestMapping("/sys/dept")
public class DepartmentController extends BaseController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/save")
    public Result save(Department department){
        return Result.success(departmentService.save(department));
    }

    @PostMapping("/update")
    public Result update(Department department){
        return Result.success(departmentService.update(department));
    }

    @PostMapping("/list")
    public Result list(Department department, HttpServletRequest request, HttpServletResponse response){
        Page<Department> page = new Page<>(request,response);
        page = departmentService.findPage(page,department);
        return Result.success().put("page",page);
    }

    @PostMapping("/view")
    public Result one(Department department){
        Result r = Result.success();
        Department u = departmentService.get(department.getId());
        r.put("data",u);
        return r;
    }
}
