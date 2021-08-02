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

    /**
     * 根据ids获取菜单列表
     * @param ids
     * @return
     */
    public List<Menu> findMenuByIds(List<String> ids){
        List<Menu>menus = mapper.findMenuByIds(ids);
        return menus;
    };

    /**
     * 获取菜单下的按钮
     * @param id
     * @return
     */
    public List<Menu> findMenuById(String id){
        List<Menu>menus = mapper.findMenuById(id);
        return menus;
    };
}
