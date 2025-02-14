package com.example.newtest.config.handler;

import com.example.newtest.common.MyResult;
import com.example.newtest.utils.GlobalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理 Exception 异常
     * @param e 异常
     * @return 处理结果
     */
    @ExceptionHandler(Exception.class)
    public MyResult handlerException(Exception e) {
        logger.error(e.getMessage(), e);
        return MyResult.fail("系统异常");

    }

    /**
     * 处理空指针异常
     * @param e 异常
     * @return 处理结果
     */
    @ExceptionHandler(NullPointerException.class)
    public MyResult handlerNullPointerException(NullPointerException e) {
        logger.error(e.getMessage(), e);
        return MyResult.fail("空指针异常");
    }

    /**
     * 处理自定义异常
     *
     * @param e 异常
     * @return 处理结果
     */
    @ExceptionHandler(GlobalException.class)
    public MyResult handlerGlobalException(GlobalException e) {
        logger.error(e.getMessage(), e);
        return MyResult.fail(e.getMessage());
    }
}
