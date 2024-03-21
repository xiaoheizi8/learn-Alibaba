package com.example.cloud.controller;

import com.example.cloud.config.RestTemplateConfig;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 罗佳维
 * @date 2024/3/17 14:31
 * description
 */
@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    private String serverURL;//当前URL
    @GetMapping("/consumer/pay/nacos/{id}")
    public String paymentInfo(@PathVariable ("id")Integer id){
        String result=restTemplate.getForObject(serverURL+"/pay/nacos/"+id,String.class);
        return result+"\t"+"Nacos83端口订单的调用者";
    }
}
