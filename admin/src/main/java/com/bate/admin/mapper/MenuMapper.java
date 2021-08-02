package com.bate.admin.mapper;

import com.bate.admin.base.BaseMapper;
import com.bate.admin.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: lh
 * @date: 2021/4/27
 */

@Mapper
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 获取菜单根据ids
     * @param ids
     * @return
     */
    public List<Menu> findMenuByIds(List<String> ids);

    /**
     * 获取菜单下的按钮
     * @param id
     * @return
     */
    public List<Menu> findMenuById(String id);
}
