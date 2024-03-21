package com.example.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗佳维
 * @date 2024/3/17 14:17
 * description
 */
@RestController
public class PayAlibabaController {
    @Value("${server.port}")
    private String serverPort;//本地端口

    @GetMapping(value = "/pay/nacos/{id}")
    public String getPayInfo(@PathVariable("id") Integer id){
        return "nacos resgistry,serverPort"+serverPort+"\t id"+id;
    }
}
