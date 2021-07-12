package com.bate.core.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lh
 * @date: 2021/7/12
 */

@Data
@Configuration(value = "baseConf")
public class BaseConfig {
    @Value("${baseConf.accessToken.expireTime}")
    public long EXPIRE_TIME;


}
