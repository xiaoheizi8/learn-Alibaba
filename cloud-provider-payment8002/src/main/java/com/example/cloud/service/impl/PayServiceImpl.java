package com.example.cloud.service.impl;

import com.example.cloud.entities.Pay;
import com.example.cloud.mapper.PayMapper;
import com.example.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 罗佳维
 * @date 2024/2/28 17:00
 * description
 */

@Service
public class PayServiceImpl implements PayService {
    @Resource
    private PayMapper payMapper;
    @Override
    public int add(Pay pay)
    {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id)
    {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay)
    {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id)
    {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll()
    {
        return payMapper.selectAll();
    }
}
