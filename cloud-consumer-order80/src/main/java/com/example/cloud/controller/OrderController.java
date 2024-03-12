package com.example.cloud.controller;

import com.example.cloud.entities.PayDTO;
import com.example.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 罗佳维
 * @date 2024/3/3 14:24
 * description
 */
@RestController
public class OrderController {
//    public static final String PaymentSrv_URL="http://localhost:8001";
    //注册后拿名字
    public static final String PaymentSrv_URL="http://cloud-payment-service";
    //传url,RequestMap
    @Resource
    private RestTemplate restTemplate;
    @GetMapping ("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
    return     restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO,ResultData.class);
    }
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getOrderById(  @PathVariable ("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/"+id,ResultData.class,id);

    }


//    @DeleteMapping("/consumer/pay/deleteOrder/{id}")
//    public ResultData deleteOrder(@PathVariable("id") Integer id) {
//        restTemplate.delete(PaymentSrv_URL + "/pay/deleteOrder/" + id);
//
//        // 返回 ResultData 对象
//        return ResultData.success(200);
//    }

    @PutMapping("/consumer/pay/updateOrder")
    public ResultData updateOrder(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/updateOrder",payDTO, ResultData.class);
    }
    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul(){
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/info",String.class);
    }
    //来自官网发现客户端
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/discovery")
    public String discovery(){
        List<String> servers=discoveryClient.getServices();
        for (String element:servers){
            System.out.println(element);
        }
        System.out.println("=========================");
        List<ServiceInstance> instances=discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element:instances){
            System.out.println(element.getInstanceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }
        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }

}
