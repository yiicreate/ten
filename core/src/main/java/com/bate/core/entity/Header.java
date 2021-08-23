package com.bate.core.entity;

import lombok.Getter;

/**
 * @author: lh
 * @date: 2021/1/6
 * excel  头列表展示
 */

@Getter
public class Header {
    /**
     * 名
     */
    private String[] name;

    /**
     * 合并单元格
     */
    private Integer[] row;

    /**
     *  合并单元格
     */
    private Integer[] col;

    public Header(String[] name){
        this.name = name;
    }

    public Header(String[] name, Integer[] row, Integer[] col){
        this.name = name;
        this.row = row;
        this.col = col;
    }
}
