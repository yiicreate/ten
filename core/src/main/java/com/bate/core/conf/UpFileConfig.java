package com.bate.core.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

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

    public boolean isAvailable(String fileName) {
        switch (allowed){
            case "all":
                return true;
            case "file":
                return isContain (fileExt, fileName);
        }
        return false;
    }

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
}
