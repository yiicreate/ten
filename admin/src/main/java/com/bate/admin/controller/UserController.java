package com.bate.admin.controller;

import com.bate.admin.entity.User;
import com.bate.admin.mapper.UserMapper;
import com.bate.core.base.BaseController;
import com.bate.core.vo.Page;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: lh
 * @date: 2021/3/29
 * 用于用户相关接口
 */

@RestController
public class UserController extends BaseController {
    @Autowired
    private UserMapper userService;

    @GetMapping("/tt")
    public Page test(User user){
        Page<User> page = new Page<>();
        user.setPage(page);
        user.setId("2");
        page.setList(userService.findList(user));
        return page;
    }
}
