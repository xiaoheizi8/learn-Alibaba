package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 罗佳维
 * @date ${DATE} ${HOUR}:${MINUTE}
 * description
 */
@EnableFeignClients//开启OpenFeign
@EnableDiscoveryClient
@SpringBootApplication
public class MainOpenFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(MainOpenFeign80.class,args);
    }
}