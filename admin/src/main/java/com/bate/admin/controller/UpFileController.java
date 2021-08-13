package com.bate.admin.controller;

import com.bate.admin.base.BaseController;
import com.bate.core.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: lh
 * @date: 2021/8/12
 */

@RestController
@RequestMapping("/file")
public class UpFileController extends BaseController {

    /**
     * 文件上传
     * @return
     */
    @PostMapping("/upload")
    public Result upload(){
        return null;
    }

    /**
     * 用于文件下载
     */
    @GetMapping("/download/{id}")
    public void download(@PathVariable String id, HttpServletResponse response){

    }

    /**
     * 用于文件展示
     * @param id
     * @param response
     */
    @GetMapping("/view/{id}")
    public void view(@PathVariable String id, HttpServletResponse response){

    }
    
}
