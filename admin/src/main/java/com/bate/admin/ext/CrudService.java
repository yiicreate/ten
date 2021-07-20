package com.bate.admin.ext;


import com.bate.admin.base.BaseMapper;
import com.bate.admin.base.BaseService;
import com.bate.core.utils.RandUtil;
import com.bate.core.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author: lh
 * @date: 2021/3/31
 */


public abstract class CrudService<T extends DataEntity<T>,M extends BaseMapper<T>> extends BaseService {
    @Autowired
    protected M mapper;

    public T get(String id){
        return mapper.get(id);
    };

    public void del(String id){
        mapper.del(id);
    };

    public List<T> findAll(){
        return mapper.findAll();
    }

    public List<T> findList(T entity){
        return mapper.findList(entity);
    }

    public int update(T t){
        return mapper.update(t);
    };


    public int save(T t){
        t.preInsert();
        return mapper.save(t);
    }

    /**
     * 查询分页数据
     * @param page 分页对象
     * @param entity
     * @return
     */
    public Page<T> findPage(Page<T> page, T entity) {
        entity.setPage(page);
        page.setList(mapper.findList(entity));
        return page;
    }
}
