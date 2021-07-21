package com.bate.admin.entity;

import com.bate.admin.ext.DataEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: lh
 * @date: 2021/7/21
 */

@Getter
@Setter
public class Role extends DataEntity<Role> {
    private String  name;

    private Integer isUse;

    private String rules;
}
