package com.bate.admin.entity;

import com.bate.admin.ext.DataEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: lh
 * @date: 2021/7/27
 */

@Setter
@Getter
public class Department extends DataEntity<Department> {
    private String name;
    private Integer type;
    private String pid;
    private Integer isUse;
    private Integer sort;

}
