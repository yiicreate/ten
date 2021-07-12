package com.bate.admin.controller;

import com.bate.admin.entity.User;
import com.bate.admin.mapper.UserMapper;
import com.bate.admin.service.UserService;
import com.bate.admin.utils.JwtUtil;
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
@RequestMapping(value = "/system")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestParam("userName") String userName,
                        @RequestParam("passWord") String passWord){
        User user = userService.getByName(userName);
        Result r = new Result();
        if(user!=null&&userService.verify(passWord,user.getPassword())){
            String token = JwtUtil.create(userName,user.getPassword());
            userService.updateTokenById(token,user.getId());
            r.setSuccess(true);
            r.put("token",token);
            return r;
        }else {
            r.setSuccess(false);
            r.setMsg("用户名或密码错误");
            return r;
        }
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
