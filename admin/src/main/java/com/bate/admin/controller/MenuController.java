package com.bate.admin.controller;

import com.bate.admin.base.BaseController;
import com.bate.admin.entity.Menu;
import com.bate.admin.service.MenuService;
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
 * @date: 2021/7/19
 * 菜单类
 */

@RestController
@RequestMapping(value = "/sys/menu")
public class MenuController extends BaseController {
    @Autowired
    MenuService menuService;

    @PostMapping("/save")
    public Result save(Menu menu){
        menuService.save(menu);
        return Result.success();
    }

    @PostMapping("/update")
    public Result update(Menu user){
        menuService.update(user);
        return Result.success();
    }

    @PostMapping("/list")
    public Result list(Menu menu, HttpServletRequest request, HttpServletResponse response){
        Page<Menu> page = new Page<>(request,response);
        page = menuService.findPage(page,menu);
        return Result.success().put("page",page);
    }

    @PostMapping("/view")
    public Result one(Menu user){
        Result r = Result.success();
        Menu u = menuService.get(user.getId());
        r.put("data",u);
        return r;
    }
}
