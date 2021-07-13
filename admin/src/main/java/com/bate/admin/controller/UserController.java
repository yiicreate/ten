package com.bate.admin.controller;

import com.bate.admin.entity.User;
import com.bate.admin.mapper.UserMapper;
import com.bate.admin.service.UserService;
import com.bate.admin.utils.JwtUtil;
import com.bate.admin.utils.UserUtil;
import com.bate.core.base.BaseController;
import com.bate.core.vo.Page;
import com.bate.core.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author: lh
 * @date: 2021/3/29
 * 用于用户相关接口
 */

@RestController
@RequestMapping(value = "/sys/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    /**
     * 当前用户
     * @return
     */
    @PostMapping("/self")
    public Result self(){
        Result r = new Result();
        r.setSuccess(true);
        r.put("user", UserUtil.getCurrentUser());
        return  r;
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Result save(User user){
        userService.save(user);
        return Result.success();
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Result update(User user){
        userService.update(user);
        return Result.success();
    }


    @GetMapping("/tt")
    public Page test(User user){
        Page<User> page = new Page<>();
        user.setPage(page);
        user.setId("2");
        page.setList(userService.findList(user));
        return page;
    }
}
