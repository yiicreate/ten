package com.bate.core.conf;

import com.bate.core.entity.Header;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lh
 * @date: 2021/1/5
 * @description:
 */

@Getter
@Setter
public class ExcelExport {
    /**
     *  多列头
     */
    private List<Header> headerList;


    /**
     *  列表名
     */
    private String[] header;//头

    /**
     * 列宽
     */
    private Integer[] width;

    /**
     *  列表名 组合
     */
    private List<Map<String, Object>> headers;//头

    /**
     * 列表内容
     */
    private List<String[]> data;

    /**
     * 列表标题
     */
    private String headerName;

    /**
     * 其他属性
     *
     */
    private Map<String, Object> option;//其他

    public ExcelExport(){

    }

    public ExcelExport(String[] header, Integer[] width, String[] field, Object o){
        this.header = header;
        this.width = width;
        getData(field,o);
    }

    public ExcelExport(String[] header, String[] field, Object o){
        this.header = header;
        getData(field,o);
    }

    public ExcelExport(String[] header, Integer[] width, String[] field, Object o, Map<String, Object> option){
        this.option = option;
        this.header = header;
        this.width = width;
        getData(field,o);
    }


    public void optionIni(ExcelConfig excelConfig){
        if(option==null){
            option = new HashMap<>();
            option.put("path", excelConfig.getExportPath());
            option.put("font", excelConfig.getFont());
            option.put("width", excelConfig.getWidth());
        }else {
            if (!option.containsKey("path")){
                option.put("path", excelConfig.getExportPath());
            }
            if (!option.containsKey("width")){
                option.put("width", excelConfig.getWidth());
            }
            if (!option.containsKey("font")){
                option.put("font", excelConfig.getFont());
            }
        }
    }

    /**
     * 利用反射  根据属性名获取属性值
     * */
    private String getValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            if(value instanceof String){
                return (String) value;
            }else {
                return String.valueOf(value);
            }
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 头部初始化
     */
    public void getHeader(){
        do{
            if(this.headers != null || header == null){
                break;
            }
            List<Map<String,Object>> headers = new ArrayList<>();
            for (int i = 0; i<header.length; i++){
                Map<String,Object> map = new HashMap<>();
                map.put("val",header[i]);
                if(width == null){
                    map.put("wid",option.get("width"));
                }else {
                    map.put("wid",width[i]);
                }

                headers.add(map);
            }
            this.headers = headers;
        }while (false);
    }

    /**
     * 通过类获取数据
     * @param field
     * @param o
     */
    private void getData(String[] field,Object o){
        data  = new ArrayList<>();
        for (Object ob:(List<Object>)o){
            String[] str = new String[field.length];
            for (int j = 0; j<field.length; j++ ){
                str[j] =  getValueByName(field[j],ob);
            }
            data.add(str);
        }
    }
}
