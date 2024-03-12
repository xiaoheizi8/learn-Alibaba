package com.example.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.example.cloud.api.PayFeignApi;
import com.example.cloud.entities.PayDTO;
import com.example.cloud.resp.ResultData;
import com.example.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 罗佳维
 * @date 2024/3/3 14:24
 * description
 */
@Slf4j
@RestController
public class OrderController {
    @Resource
    private PayFeignApi payFeignApi;//通过暴露的接口获取
    @PostMapping("/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        ResultData resultData=payFeignApi.addPay(payDTO);
        log.info("模拟把本地Order新增删除，再开启addPay支付微服务的远程调用");
        return  resultData;
    }
    @GetMapping("/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        log.info("----支付微服务远程调用，按照id查询订单支付流水信息");
        ResultData resultData=null;
        try {
            System.out.println("调用开始"+ DateUtil.now());
             resultData=payFeignApi.getPayInfo(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("调用结束"+DateUtil.now());
            ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }

        return  resultData;
    }
    //天然负载均衡
    @GetMapping("/feign/pay/mylb")
    public String mylb(){
        return payFeignApi.mylb();
    }
}
