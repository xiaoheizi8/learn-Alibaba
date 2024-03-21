package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 罗佳维
 * @date ${DATE} ${HOUR}:${MINUTE}
 * description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Main83 {
    public static void main(String[] args) {
        SpringApplication.run(Main83.class,args);
    }
}