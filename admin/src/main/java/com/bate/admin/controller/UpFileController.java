package com.bate.admin.controller;

import com.bate.admin.base.BaseController;
import com.bate.core.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 文件下载
     */
    @GetMapping("/download")
    public void download(){

    }
    
}
