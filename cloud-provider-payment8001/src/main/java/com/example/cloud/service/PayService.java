package com.example.cloud.service;

import com.example.cloud.entities.Pay;

import java.util.List;

/**
 * @author 罗佳维
 * @date 2024/2/28 16:58
 * description
 */
public interface PayService {
    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);

    public Pay getById(Integer id);

    public List<Pay> getAll();
}
