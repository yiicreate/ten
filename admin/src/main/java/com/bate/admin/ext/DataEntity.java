package com.bate.admin.ext;

import com.bate.admin.entity.User;
import com.bate.admin.utils.UserUtil;
import com.bate.core.base.BaseEntity;
import com.bate.core.utils.RandUtil;
import com.bate.core.utils.TimeUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author: lh
 * @date: 2021/3/31
 */


public abstract class DataEntity<T> extends BaseEntity<T> {

    /**
     * 创建者
     */
    protected String createBy;


    public DataEntity(){
        super();
    }

    public DataEntity(String id){
        super(id);
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert(){
        if (StringUtils.isBlank(this.getId())&&!this.isAuto){
            setId(RandUtil.uuid());
            User user = UserUtil.getCurrentUser();
            if (StringUtils.isNotBlank(user.getId())){
                this.createBy = user.getId();
            }
            this.createTime = new Date();
        }
    }


    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
