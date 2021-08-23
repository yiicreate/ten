package com.bate.core.parser;

import com.bate.core.conf.ExcelExport;
import com.bate.core.entity.Header;
import com.bate.core.utils.RandUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: lh
 * @date: 2021/8/23
 */


public class ExcelParser {
    /**
     * 每个sheet 导出最大值
     */
    private static Integer size = 1000;

    /**
     * 生成单元格格式
     * @param wb
     * @param font
     * @param size
     * @return
     */
    public static CellStyle cellCreate(Workbook wb, String font, int size){
        // 创建字体
        Font f = wb.createFont();

        // 创建字体样式
        f.setColor(IndexedColors.BLACK.getIndex());
        f.setFontName(font);
        f.setFontHeightInPoints((short)size);

        // 创建单元格格式
        CellStyle cs = wb.createCellStyle();
        cs.setFont(f);
        cs.setBorderLeft(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        return cs;
    }

    /**
     * 合并单元格边框
     * @param cellRangeAddress
     * @param sheet
     */
    private static void region(CellRangeAddress cellRangeAddress, Sheet sheet){
        // 使用RegionUtil类为合并后的单元格添加边框
        RegionUtil.setBorderTop(BorderStyle.THIN, cellRangeAddress, sheet); // 上边框
        RegionUtil.setBorderBottom(BorderStyle.THIN, cellRangeAddress, sheet); // 下边框
        RegionUtil.setBorderLeft(BorderStyle.THIN, cellRangeAddress, sheet); // 左边框
        RegionUtil.setBorderRight(BorderStyle.THIN, cellRangeAddress, sheet); // 右边框

    }

    /**
     * 生成execl
     * @param excelExport
     * @return
     * @throws IOException
     */
    public static String out(ExcelExport excelExport) throws IOException {
        Map<String, Object> option = excelExport.getOption();
        if(excelExport.getHeaderName() != null){
            option.put("headerName",excelExport.getHeaderName());
        }
        if(excelExport.getHeaders() == null){
            return out(excelExport.getHeaderList(),excelExport.getData(),option,excelExport.getWidth());
        }else {
            return out(excelExport.getHeaders(),excelExport.getData(),option);
        }
    }

    /**
     * 根据头，数据列，路径生成execl
     * @param header
     * @param list
     * @param option
     * @return
     * @throws IOException
     */
    private static String out(List<Header> header, List<String[]> list, Map<String, Object> option, Integer[] width) throws IOException {
        String path = (String) option.get("path");
        String font = (String) option.get("font");
        Integer length = header.get(header.size()-1).getName().length;
        if(width == null){
            for (int k = 0; k<length;k++){
                width[k] = (Integer) option.get("width");
            }
        }

        Workbook wb = new HSSFWorkbook();
        Integer len = (int)Math.ceil((double)list.size()/(double)size);
        for (int n =1;n<=len;n++){
            Sheet sheet = wb.createSheet("Sheet"+n);
            //数据分页
            List<String[]> list1= list.subList((n-1)*size,list.size()<=n*size?list.size():n*size);
            int r = 0;
            if(option.containsKey("headerName")){
                setHeaderName(sheet,(String) option.get("headerName"),length-1,r,cellCreate(wb,font,20));
                r++;
            }
            r = setHeaderList(sheet,header,r,cellCreate(wb,font,16),width);
            setList(sheet,list1,r,cellCreate(wb,font,14));
        }
        return  fileOut(path,wb);
    }


    /**
     * 根据头，数据列，路径生成execl
     * @param header
     * @param list
     * @param option
     * @return
     * @throws IOException
     */
    public static String out(List<Map<String, Object>> header, List<String[]> list, Map<String, Object> option) throws IOException {
        String path = (String) option.get("path");
        String font = (String) option.get("font");

        Workbook wb = new HSSFWorkbook();
        Integer len = (int)Math.ceil((double)list.size()/(double)size);

        for (int n =1;n<=len;n++){
            Sheet sheet = wb.createSheet("Sheet"+n);
            //数据分页
            List<String[]> list1= list.subList((n-1)*size,list.size()<=n*size?list.size():n*size);
            int r = 0;
            if(option.containsKey("headerName")){
                setHeaderName(sheet,(String) option.get("headerName"),header.size()-1,r,cellCreate(wb,font,20));
                r++;
            }
            r = setHeader(sheet,header,r,cellCreate(wb,font,16));
            setList(sheet,list1,r,cellCreate(wb,font,14));
        }

        return  fileOut(path,wb);
    }


    /**
     * 生成文件
     * @param path
     * @param wb
     * @return
     * @throws IOException
     */
    private static  String fileOut(String path,Workbook wb) throws IOException {
        File file = new File(path);
        file.mkdirs();
        String  name = fileName(".xls");
        String  fileName = path+name;
        FileOutputStream fos = new FileOutputStream(fileName);
        wb.write(fos);
        fos.close();
        return  name;
    }

    /**
     * 随机生成文件名
     * @param ext
     * @return
     */
    private static String fileName(String ext){
        String name = RandUtil.ranStr(20);
        SimpleDateFormat s =  new SimpleDateFormat("HHmmss");
        Date date = new Date();
        String aa = s.format(date);
        return  name+aa+ext;
    }

    /**
     * 设置标题
     * @param sheet
     * @param headerName
     * @param size
     * @param r
     * @param cs
     */
    private static void setHeaderName(Sheet sheet,String headerName,Integer size,Integer r,CellStyle cs){
        CellRangeAddress cellRangeAddress = new CellRangeAddress(r,r,0,size);
        Cell cell = sheet.createRow(r).createCell(0);
        cell.setCellValue(headerName);
        cell.setCellStyle(cs);
        region(cellRangeAddress,sheet);
        sheet.addMergedRegion(cellRangeAddress);
    }

    /**
     * 多列头处理
     * @param sheet
     * @param headers
     * @param r
     * @param cs
     * @return 下一个行号
     */
    private static Integer setHeaderList(Sheet sheet,List<Header> headers,Integer r,CellStyle cs,Integer[] width){
        for (int i=0;i<headers.size();i++,r++){
            Header header = headers.get(i);
            if(header.getName() == null){
                break;
            }
            Integer[] row = header.getRow();
            Integer[] col = header.getCol();
            String[] name = header.getName();
            Row row1 = sheet.createRow(r);
            for (int j = 0,c = 0;j<name.length;j++){
                if (name[j] != "") {
                    if (row!=null && col!= null && (row[j] > 1 || col[j] > 1)) {
                        CellRangeAddress cra = new CellRangeAddress(r, r + row[j] - 1, c, c + col[j] - 1);
                        Cell cell = row1.createCell(c);
                        cell.setCellValue(name[j]);
                        cell.setCellStyle(cs);
                        region(cra,sheet);
                        sheet.addMergedRegion(cra);
                    }else {
                        Cell cell = row1.createCell(c);
                        cell.setCellValue(name[j]);
                        cell.setCellStyle(cs);
                    }
                }else{
                    Cell cell = row1.createCell(c);
                    cell.setCellStyle(cs);
                }
                c += col!= null?col[j]:1;
                if(i == headers.size()-1){
                    sheet.setColumnWidth(j,width[j]*256);
                }
            }

        }
        return  r;
    }

    /**
     * 设置表头
     * @param sheet
     * @param header
     * @param r
     * @param cs
     */
    private static Integer setHeader(Sheet sheet,List<Map<String, Object>> header,Integer r,CellStyle cs){
        // 创建行
        Row row = sheet.createRow(r);
        //创建表头
        for(short i=0;i<header.size();i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(header.get(i).get("val").toString());
            cell.setCellStyle(cs);
            sheet.setColumnWidth(i,Integer.parseInt(header.get(i).get("wid").toString())*256);
        }
        return  ++r;
    }

    /**
     * 设置值列
     * @param sheet
     * @param list
     * @param r
     * @param cs
     */
    private static void setList(Sheet sheet,List<String[]> list,Integer r,CellStyle cs){
        for (short j=0;j<list.size();j++,r++){
            Row row1 = sheet.createRow(r);
            String [] rows = list.get(j);
            for (short k = 0;k<rows.length;k++){
                Cell cell = row1.createCell(k);
                cell.setCellValue(rows[k]);
                cell.setCellStyle(cs);
            }
        }
    }
}
