package com.bate.core.utils;

import com.bate.core.conf.ExcelExport;
import com.bate.core.conf.ExcelConfig;
import com.bate.core.conf.UpFileConfig;
import com.bate.core.parser.ExcelParser;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;

/**
 * @author: lh
 * @date: 2021/8/20
 */


public class FileUtils{
    private static String basePath;

    /**
     * 初始化
     */
    public static void init(){
        UpFileConfig upFileConfig = AppUtil.getBean(UpFileConfig.class);
        basePath = upFileConfig.getBasePath();
        File file =new File(basePath);
        if(!file.exists()){
            file.mkdirs();
        }
    }
    /**
     * 上传
     * @param file
     * @return
     */
    public static String upload(MultipartFile file){
        init();
        if(file.isEmpty()){
            return null;
        }
        String fileName = "/"+TimeUtil.getDateSting("yyyyMMdd")+"/";
        String filePath = basePath+fileName;
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdirs();
        }
        String[] doc = file.getOriginalFilename().split("\\.");

        String name = RandUtil.uuid()+"."+doc[1];

        File newFile = new File(filePath,name);
        if (newFile.exists()) {
            throw  new RuntimeException("存在该文件");
        }

        try{
            file.transferTo(newFile);
            return fileName+name;
        } catch (IOException e) {
            throw  new RuntimeException(e.getMessage());
        }
    }

    public static void fileLoad(String path,String fileName,String contentType,HttpServletResponse response)  {
        init();
        File file = new File(basePath+path);
        Image image = null;
        try{
            image = ImageIO.read(file);
        }catch (IOException e){

        }

        if(image == null){
            download(file,fileName,response);
        }else {
            try {
                view(file,contentType,response);
            }catch (IOException e){
                throw new RuntimeException("图片问题");
            }
        }
    }

    public static void download(File file,String fileName, HttpServletResponse response){
        if(!file.exists()){
            return;
        }
        OutputStream os = null;
        InputStream is= null;
        try {
            // 取得输出流
            os = response.getOutputStream();
            // 清空输出流
            response.reset();
            response.setContentType("application/x-download;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.setHeader("Content-Length", String.valueOf(file.length()));
            is = new FileInputStream(file);
            if (is == null) {
                return;
            }
            //复制
            IOUtils.copy(is, response.getOutputStream());
            response.getOutputStream().flush();
        }catch (IOException e){

        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void download(String path,String fileName, HttpServletResponse response){
        init();
        File file = new File(basePath+path);
        if(!file.exists()){
            return;
        }
        OutputStream os = null;
        InputStream is= null;
        try {
            // 取得输出流
            os = response.getOutputStream();
            // 清空输出流
            response.reset();
            response.setContentType("application/x-download;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.setHeader("Content-Length", String.valueOf(file.length()));
            is = new FileInputStream(file);
            if (is == null) {
                return;
            }
            //复制
            IOUtils.copy(is, response.getOutputStream());
            response.getOutputStream().flush();
        }catch (IOException e){

        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void view(File file,String contentType,HttpServletResponse response) throws IOException {
        if(!file.exists()){
            return;
        }
        InputStream is = new FileInputStream(file);

        response.reset();
        response.addHeader("access-control-allow-origin", "*");
        response.addHeader("timing-allow-origin", "*");
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setContentType(contentType);

        ServletOutputStream out = response.getOutputStream();
        //复制
        IOUtils.copy(is, out);

        try {
            out.flush();
        }finally {
            out.close();
        }
    }

    public static void view(String path,String contentType,HttpServletResponse response) throws IOException {
        init();
        File file = new File(basePath+path);
        if(!file.exists()){
            return;
        }
        InputStream is = new FileInputStream(file);

        response.reset();
        response.addHeader("access-control-allow-origin", "*");
        response.addHeader("timing-allow-origin", "*");
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setContentType(contentType);

        ServletOutputStream out = response.getOutputStream();
        //复制
        IOUtils.copy(is, out);

        try {
            out.flush();
        } finally {
            out.close();
        }
    }


    public String export(ExcelExport excelExport) throws IOException {
        ExcelConfig excelConfig = AppUtil.getBean(ExcelConfig.class);
        excelExport.optionIni(excelConfig);
        excelExport.getHeader();
        return ExcelParser.out(excelExport);
    }
}
