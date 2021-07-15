package com.bate.core.vo;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: lh
 * @date: 2021/3/30
 */

@Getter
@Setter
public class Page<T> implements Serializable {

    private Integer pageNo = 1;

    private Integer pageSize = 10;

    private long total = 0;

    private List<T> list = new ArrayList<T>();

    private String orderBy = "";

    public Page(){}

    public Page(Integer pageNo,Integer pageSize){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Page(Integer pageNo,Integer pageSize,Long total){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = total;
    }

    public Page(HttpServletRequest request, HttpServletResponse response) {
        // 设置页码参数（传递repage参数，来记住页码）
        this.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
        // 设置页面大小参数（传递repage参数，来记住页码大小）
        this.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
        // 设置排序参数
        String orderBy = request.getParameter("orderBy");
        if (StringUtils.isNotBlank(orderBy)) {
            this.setOrderBy(orderBy);
        }
    }

    public int getFirst(){
        int first = (getPageNo() -1)*getPageSize();
        if(first > getTotal() || first < 0 ){
            first = 0;
        }
        return first;
    }

}
