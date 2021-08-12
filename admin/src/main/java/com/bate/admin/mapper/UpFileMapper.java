package com.bate.admin.mapper;

import com.bate.admin.base.BaseMapper;
import com.bate.admin.entity.UpFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: lh
 * @date: 2021/8/12
 */

@Mapper
@Repository
public interface UpFileMapper extends BaseMapper<UpFile> {

}
