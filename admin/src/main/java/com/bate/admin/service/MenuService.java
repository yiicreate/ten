package com.bate.admin.service;

import com.bate.admin.entity.Menu;
import com.bate.admin.ext.CrudService;
import com.bate.admin.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lh
 * @date: 2021/7/19
 */

@Service
public class MenuService extends CrudService<Menu, MenuMapper> {

    public List<Menu> findMenuByIds(String ids){
        List<Menu>menus = mapper.findMenuByIds(ids);
        return menus;
    };
}
