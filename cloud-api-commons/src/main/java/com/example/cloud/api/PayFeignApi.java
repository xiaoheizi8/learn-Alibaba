package com.example.cloud.api;

import com.example.cloud.entities.PayDTO;
import com.example.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 罗佳维
 * @date 2024/3/10 14:13
 * description支付接口
 */
@FeignClient(value = "cloud-payment-service")
public interface PayFeignApi {
    //新增支付流水
    @PostMapping(value = "/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);
    //主键查询支付流水信息
    @GetMapping(value = "/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id")Integer id);
    //openFeign支持天然负载均衡
    @GetMapping(value ="/pay/get/info" )
    public String mylb();

}
