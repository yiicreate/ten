package com.bate.admin.controller;

import com.bate.admin.base.BaseController;
import com.bate.admin.entity.User;
import com.bate.admin.service.UserService;
import com.bate.admin.utils.JwtUtil;
import com.bate.admin.utils.KaptchaUtil;
import com.bate.core.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: lh
 * @date: 2021/7/13
 * 登录
 */

@RestController
public class LoginController extends BaseController {
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

    @GetMapping("/image")
    public void image(HttpServletRequest request, HttpServletResponse response) throws Exception {
        KaptchaUtil.validateCode(request,response);
    }

    @GetMapping("/check")
    public Result check(HttpServletRequest request, @RequestParam("code") String code){
        return KaptchaUtil.check(request,code)?Result.success():Result.error();
    }
}
