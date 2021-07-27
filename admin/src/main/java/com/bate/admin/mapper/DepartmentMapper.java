package com.bate.admin.mapper;

import com.bate.admin.base.BaseMapper;
import com.bate.admin.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: lh
 * @date: 2021/7/27
 */
@Repository
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

}
