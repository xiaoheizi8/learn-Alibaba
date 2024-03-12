package com.example.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 罗佳维
 * @date 2024/2/28 16:55
 * description
 * dto层携带数据传输 需要暴露的字段
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayDTO implements Serializable {
    private Integer id;
    //支付流水
    private String payNo;
    //订单流水
    private String orderNo;
    //用户账户ID
    private String userId;
    //交易金额
    private BigDecimal amount;
}
