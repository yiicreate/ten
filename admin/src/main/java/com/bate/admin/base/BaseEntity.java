package com.bate.admin.base;

import com.bate.core.vo.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: lh
 * @date: 2021/3/31
 */

@Setter
public abstract class BaseEntity<T> implements Serializable {

    private String id;

    protected Page<T> page;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date createTime;

    /**
     * 自定义sql查询条件
     */
    protected String dataScope;

    protected boolean isAuto = false;

    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }

    @JsonIgnore
    @XmlTransient
    public Page<T> getPage() {
        if (page == null){
            page = new Page<T>();
        }
        return page;
    }


    public Page<T> setPage(Page<T> page) {
        this.page = page;
        return page;
    }

    public String getId(){
        return id;
    }

    public boolean isAuto(){
        return isAuto || StringUtils.isBlank(getId());
    }

    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
