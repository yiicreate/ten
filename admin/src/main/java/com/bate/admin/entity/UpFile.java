package com.bate.admin.entity;

import com.bate.admin.ext.DataEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: lh
 * @date: 2021/8/12
 */

@Setter
@Getter
public class UpFile extends DataEntity<UpFile> {
    private String diskPath;
    private String name;
    private String path;
    private String type;
}
