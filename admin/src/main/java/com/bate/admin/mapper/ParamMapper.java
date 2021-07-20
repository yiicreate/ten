package com.bate.admin.mapper;

import com.bate.admin.base.BaseMapper;
import com.bate.admin.entity.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: lh
 * @date: 2021/4/21
 */

@Mapper
@Repository
public interface ParamMapper extends BaseMapper<Param> {

}
