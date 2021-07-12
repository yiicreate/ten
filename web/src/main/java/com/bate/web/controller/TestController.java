package com.bate.web.controller;

import com.bate.admin.entity.User;
import com.bate.admin.service.UserService;
import com.bate.core.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lh
 * @date: 2021/6/3
 */

@RestController
public class TestController {
    @GetMapping("/t")
    public String test(){
        return  "hello";
    }

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public Page test(User user){
        Page<User> page = new Page<>();
        user.setPage(page);
        user.setId("2");
        page.setList(userService.findList(user));
        return page;
    }
}
