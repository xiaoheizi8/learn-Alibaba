package com.example.cloud.controller;

import com.example.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗佳维
 * @date 2024/3/17 15:52
 * description
 */
@RestController
public class FlowLimitController {
    @GetMapping("/test1")
    public String test01(){
        return "----test01";
    }
    @GetMapping("/test2")
    public String test02(){
        return "----test2";
    }
    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping("/testC")
    public String testC()
    {
        flowLimitService.common();
        return "------testC";
    }
    @GetMapping("/testD")
    public String testD()
    {
        flowLimitService.common();
        return "------testD";
    }
}
