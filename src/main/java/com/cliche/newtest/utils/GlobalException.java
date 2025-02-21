package com.cliche.newtest.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GlobalException extends RuntimeException {
    //返回成功
    public static final int SUCCESS_CODE = 200;
    //错误状态码
    public static final int ERROR_CODE = 500;
    //无权限
    public static final int NO_LOGIN = 600;
    public static final int NO_AUTH = 700;
    /**
     * 保存异常信息
     */
    private String message;

    /**
     * 保存响应状态码
     */
    private Integer code = ERROR_CODE;

    /**
     * 默认构造方法，根据异常信息 构建一个异常实例对象
     * @param message 异常信息
     */
    public GlobalException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * 根据异常信息、响应状态码构建 一个异常实例对象
     * @param message 异常信息
     * @param code 响应状态码
     */
    public GlobalException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    /**
     * 根据异常信息，异常对象构建 一个异常实例对象
     * @param message 异常信息
     * @param e 异常对象
     */
    public GlobalException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    /**
     * 根据异常信息，响应状态码，异常对象构建 一个异常实例对象
     * @param message 异常信息
     * @param code 响应状态码
     * @param e 异常对象
     */
    public GlobalException(String message, Integer code, Throwable e) {
        super(message, e);
        this.message = message;
        this.code = code;
    }
}
