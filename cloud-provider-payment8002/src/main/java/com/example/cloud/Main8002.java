package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 罗佳维
 * @date ${DATE} ${HOUR}:${MINUTE}
 * description
 */
@RefreshScope //服务器更新
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.example.cloud.mapper")
public class Main8002 {
    public static void main(String[] args) {
        SpringApplication.run(Main8002.class,args);
    }
}