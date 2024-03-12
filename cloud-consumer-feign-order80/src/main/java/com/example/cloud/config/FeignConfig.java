package com.example.cloud.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 罗佳维
 * @date 2024/3/10 15:35
 * description
 */
@Configuration
public class FeignConfig {
@Bean
    public Retryer myRetryer(){
    //但是Feign默认配置不走重试
//    return Retryer.NEVER_RETRY

    //最大请求次数为3，1+2，初始间隔为100ms 重试间隔1s
    return new Retryer.Default(100,1,3);
}

}
