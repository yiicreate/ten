package com.bate.admin.controller;

import com.bate.admin.entity.Dictionary;
import com.bate.admin.service.DictionaryService;
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
 * @date: 2021/7/31
 * 数据字典类
 */

@RestController
@RequestMapping("/sys/dic")
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;

    @PostMapping("/save")
    public Result save(Dictionary dictionary){
        dictionaryService.save(dictionary);
        return Result.success();
    }

    @PostMapping("/update")
    public Result update(Dictionary dictionary){
        dictionaryService.update(dictionary);
        return Result.success();
    }

    @PostMapping("/list")
    public Result list(Dictionary dictionary, HttpServletRequest request, HttpServletResponse response){
        Page<Dictionary> page = new Page<>(request,response);
        page = dictionaryService.findPage(page,dictionary);
        return Result.success().put("page",page);
    }

    @PostMapping("/view")
    public Result one(Dictionary dictionary){
        Result r = Result.success();
        Dictionary u = dictionaryService.get(dictionary.getId());
        r.put("data",u);
        return r;
    }
}
