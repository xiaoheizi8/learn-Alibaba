package com.example.cloud.resp;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author 罗佳维
 * @date 2024/3/2 14:01
 * description
 */
@Getter
public enum ReturnCodeEnum {

    //举值
    RC999("999","操作xxx失败"),
    RC200("200","success"),
    RC201("201","服务器开启降级保护,请稍后再试"),
    RC202("202","热点参数限流请稍后再试"),
    RC203("203","系统规则不满足要求,请稍后再试"),
    RC204("204","授权规则不通过,请稍后再试"),
    RC403("403","无访问权限，请联系管理员授予权限"),
    RC401("401","匿名用户访问无权限资源时的异常"),
    RC404("404","404页面找不到异常"),
    RC500("500","系统异常，请稍后再试"),
    RC375("375","算法运算异常,请稍后再试"),

    INVALID_TOKEN("2001","访问令牌不合法"),
    ACCESS_DENIED("2003","没有权限访问该资源"),
    CLIENT_AUTHENTICATION_FAILED("1001","客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR("1002","用户名或密码错误"),
    UNSUPPORTED_GRANT_TYPE("1003","不支持的认证模式"),
    BUSINESS_ERROR("1004","业务逻辑异常");
    //如何定义一个通用的枚举类 举值-构造-遍历

    //构造
 private final String code;//自定义状态码
 private final String message;//自定义描述信息

    ReturnCodeEnum(String code,String message) {
        this.code=code;
        this.message=message;
    }
    //3.遍历
    //传统写法
    public static ReturnCodeEnum getReturnCodeEnumV1(String code){
        for(ReturnCodeEnum element:ReturnCodeEnum.values()){
            //状态🐎等于传过来的时候
            if (element.getCode().equalsIgnoreCase(code))
                return element;
        }
        return null;
    }
    //3.2Stream流计算
    public static ReturnCodeEnum getReturnCodeEnumV2(String code){
        //枚举转Stream流执行筛选流
       return  Arrays.stream(ReturnCodeEnum.values()).filter(x->x.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }
//测试枚举
//    public static void main(String[] args) {
//        System.out.println(getReturnCodeEnumV1("200"));
//        System.out.println(getReturnCodeEnumV1("200").getCode());
//        System.out.println(getReturnCodeEnumV1("200").getMessage());
//        System.out.println("---------------");
//        System.out.println(getReturnCodeEnumV2("404"));
//        System.out.println(getReturnCodeEnumV2("404").getCode());
//        System.out.println(getReturnCodeEnumV2("404").getMessage());
//    }

}
