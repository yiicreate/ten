package com.bate.admin.entity;

import com.bate.admin.ext.DataEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: lh
 * @date: 2021/7/27
 */

@Getter
@Setter
public class Dictionary extends DataEntity<Dictionary> {
    private String code;

    private String name;

    private String type;

    private Integer isUse;

    private Integer sort;

    private String remark;
}
