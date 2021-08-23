package com.bate.core.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: lh
 * @date: 2021/8/12
 */

@Data
@Configuration
public class UpFileConfig {
    @Value("${upfiles.basePath}")
    private String basePath;

    @Value("${upfiles.allowed}")
    private String allowed;

    @Value("${upfiles.ext.files}")
    private String fileExt;

    @Value("${upfiles.fileSize}")
    private Long fileSize;

    /**
     * 文件大小及类型验证
     * @param fileName
     * @param size
     * @return
     */
    public boolean isAvailable(String fileName,Long size) {
        switch (allowed){
            case "all":
                return isSizeComparison(size);
            case "file":
                if(isContain (fileExt, fileName)&&isSizeComparison(size)){
                    return true;
                };
        }
        return false;
    }

    /**
     * 验证文件类型
     * @param extensions
     * @param fileName
     * @return
     */
    public  boolean isContain(String extensions, String fileName){
        String[] extensionArray = extensions.split (",");
        String fileExtension = fileName.substring (fileName.lastIndexOf (".")+1).toLowerCase();
        for(String extension: extensionArray){
            if(extension.trim ().equals (fileExtension)){
                return true;
            }
        }
        return false;
    }

    public boolean isSizeComparison(Long size){
        if(size <=0){
            return false;
        }
        size = size/1024/1024;
        if(size > fileSize){
            return  false;
        }
        return true;
    }
}
