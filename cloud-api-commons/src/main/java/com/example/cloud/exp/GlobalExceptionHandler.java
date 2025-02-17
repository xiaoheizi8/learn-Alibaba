package com.example.cloud.exp;

import com.example.cloud.resp.ResultData;
import com.example.cloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 罗佳维
 * @date 2024/3/2 15:43
 * description 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e){
        System.out.println("全局异常");
        log.error("全局异常信息:{}",e.getMessage(),e);
    return     ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
