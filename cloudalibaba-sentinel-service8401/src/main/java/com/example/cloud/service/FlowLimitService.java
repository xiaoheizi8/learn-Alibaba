package com.example.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author 罗佳维
 * @date 2024/3/17 17:33
 * description
 */
@Service
public class FlowLimitService {
    @SentinelResource(value = "common")
    public void common()
    {
        System.out.println("------FlowLimitService come in");
    }
}
