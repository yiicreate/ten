package com.bate.admin.controller;

import com.bate.admin.base.BaseController;
import com.bate.core.conf.UpFileConfig;
import com.bate.core.utils.FileUtils;
import com.bate.core.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: lh
 * @date: 2021/8/12
 */

@RestController
@RequestMapping("/file")
public class UpFileController extends BaseController {
    @Autowired
    UpFileConfig upFileConfig;

    /**
     * 文件上传
     * @return
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("file")MultipartFile file){
        //文件验证
        if(!upFileConfig.isAvailable(file.getOriginalFilename(),file.getSize())){
            return Result.error().put("data","文件大小过大或格式不允许");
        }
        FileUtils.upload(file);
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
