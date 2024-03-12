package com.example.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 罗佳维
 * @date 2024/3/2 15:26
 * description
 */
@Data
@Accessors(chain = true)
public class ResultData<T> {
    public String code;
    public String message;
    public T data;
    private long timestamp;
    public ResultData(){
        this.timestamp=System.currentTimeMillis();
    }
    public static <T>ResultData<T>success(T data){
        ResultData resultData=new ResultData<>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setCode(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return  resultData;
    }
    public static <T>ResultData<T>fail(String code,String message){
        ResultData resultData=new ResultData();
        resultData.setCode(code);
        resultData.setCode(message);
        resultData.setData(null);//失败返回null
        return  resultData;
    }

}
