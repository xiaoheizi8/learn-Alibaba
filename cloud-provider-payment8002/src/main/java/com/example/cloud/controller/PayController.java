package com.example.cloud.controller;

import com.example.cloud.entities.Pay;
import com.example.cloud.entities.PayDTO;
import com.example.cloud.resp.ResultData;
import com.example.cloud.resp.ReturnCodeEnum;
import com.example.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 罗佳维
 * @date 2024/2/28 17:02
 * description
 */
@Tag(name = "支付微服务模块",description = "支付CRUD")
@RestController
@Slf4j
public class PayController {
    @Resource
    private PayService payService;
    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串作为参数")
    public ResultData <String> addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());
//        log.info("pay的所有信息:{}",pay.toString());
        int i= payService.add(pay);
        return  ResultData.success("成功插入数据,返回值:"+i);
    }
@DeleteMapping(value = "/pay/del/{id}")
@Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData <Integer> deletePay(@PathVariable("id")Integer id) {

    int i=  payService.delete(id);
    return ResultData.success(i);
}
@PutMapping("/pay/update")
@Operation(summary = "更新",description = "更新支付流水方法")
public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        //Dto暴露
    Pay pay=new Pay();
    BeanUtils.copyProperties(payDTO,pay);
    int i= payService.update(pay);
    return ResultData.success("成功修改记录返回值:"+i);
}
@Operation(summary = "查找",description = "根据id查找订单流水")
@GetMapping(value = "/pay/get/{id}")
    public ResultData <Pay> getById(@PathVariable("id")Integer id) throws Exception {
       Pay pay= payService.getById(id);
       if (id<=0)throw new RuntimeException("当前id非法");
       return ResultData.success(pay);
}
//查询所有
@Operation(summary = "查找",description = "查找全部订单流水")

@GetMapping(value = "/pay/getAll")
    public ResultData< List<Pay>> getAll(){
        log.info("访问全部");
         List list= payService.getAll();
            return ResultData.success(list);
    }
    @GetMapping(value ="/pay/errror")
    public ResultData<Integer> getPayError(){
        Integer integer=Integer.valueOf(200);
        try {
            System.out.println("payError test");
            int age=10/0;
          }catch (Exception e){
            e.printStackTrace();
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
        return ResultData.success(integer);
    }
    @Value("${server.port}")
    private String port;
    @GetMapping(value = "/pay/get/info")
    //获取服务器信息
    public String getInfoByConsul(@Value("${ljw.info}")String ljwInfo){
        return  "ljwInfo:"+ljwInfo+"\t"+"port: "+port;
    }
}
