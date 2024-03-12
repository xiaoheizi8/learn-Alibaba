package com.example.cloud.mapper;

import com.example.cloud.entities.Pay;
import com.example.cloud.entities.PayDTO;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

//@org.apache.ibatis.annotations.Mapper
public interface PayMapper extends Mapper<Pay> {
//   Pay selectById(Integer id);
//
//   List<Pay> selectPay();
}