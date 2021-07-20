package com.bate.admin.mapper;

import com.bate.admin.base.BaseMapper;
import com.bate.admin.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: lh
 * @date: 2021/4/27
 */

@Mapper
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

}
