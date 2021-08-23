package com.bate.core.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lh
 * @date: 2021/8/23
 */

@Getter
@Setter
@Configuration
public class ExcelConfig {
    private Long chunkSize = 1024L * 1024L;

    /**
     * 导出地址
     */
    private String exportPath = "/";

    /**
     * 字体
     */
    private String font = "宋体";

    /**
     * 默认列宽
     */
    private Integer width = 20;
}
