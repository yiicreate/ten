package com.bate.admin.controller;

import com.bate.admin.base.BaseController;
import com.bate.admin.entity.User;
import com.bate.admin.service.UserService;
import com.bate.admin.utils.UserUtil;
import com.bate.core.vo.Page;
import com.bate.core.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
    @GetMapping("/self")
    public Result self(){
        Result r = new Result();
        r.setSuccess(true);
        r.put("user", UserUtil.getSelf());
        return  r;
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Result save(User user){
        return Result.success( userService.save(user));
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Result update(User user){
        return Result.success(userService.update(user));
    }

    @PostMapping("/list")
    public Result list(User user, HttpServletRequest request, HttpServletResponse response){
        Page<User> page = new Page<>(request,response);
        page = userService.findPage(page,user);
        return Result.success().put("page",page);
    }

    @PostMapping("/view")
    public Result one(User user){
        Result r = Result.success();
        User u = userService.get(user.getId());
        r.put("data",u);
        return r;
    }
}
