package com.cliche.newtest.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther: Hades
 * @Date: 2023/9/25
 * @Description: Test
 * @PROJECT_NAME: new-test
 * @Package_name: IntelliJ IDEA
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MyResult {
    /**
     * 是否成功
     **/
    private Boolean isSuccess;
    /**
     * 错误信息
     **/
    private String msg;
    /**
     * 请求状态 200-成功 500-失败 403-无权限
     **/
    private Integer status;
    /**
     * 当前时间戳
     **/
    private Long timestamp;
    /**
     * 返回结果
     **/
    private Object data;

    public static MyResult ok() {
        return new MyResult(true, "调用成功", 200, System.currentTimeMillis(),null);
    }

    public static MyResult ok(String msg) {
        return new MyResult(true, msg, 200, System.currentTimeMillis(),null);
    }

    public static MyResult ok(Object data) {
        return new MyResult(true, null, 200,System.currentTimeMillis(),data);
    }

    public static MyResult ok(List<?> data) {
        return new MyResult(true, null, 200,System.currentTimeMillis(),data);
    }

    public static MyResult fail(String errorMsg) {
        return new MyResult(false, errorMsg, 500,System.currentTimeMillis(),null);
    }

    public static MyResult access(String errorMsg) {
        return new MyResult(false, errorMsg, 403,System.currentTimeMillis(),null);
    }

    public static MyResult success(String token) {
        return new MyResult(true, null, 200,System.currentTimeMillis(),token);
    }
}

