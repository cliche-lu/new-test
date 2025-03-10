package com.cliche.newtest.config.handler;

import com.cliche.newtest.common.MyResult;
import com.cliche.newtest.utils.GlobalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

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
        return MyResult.fail("系统异常:" + e.getMessage());

    }

    /**
     * 处理空指针异常
     * @param e 异常
     * @return 处理结果
     */
    @ExceptionHandler(NullPointerException.class)
    public MyResult handlerNullPointerException(NullPointerException e) {
        logger.error(e.getMessage(), e);
        return MyResult.fail("空指针异常:" + e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public MyResult accessDeniedException(AccessDeniedException e) {
        logger.error(e.getMessage(), e);
        return MyResult.access("无权限:" + e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public MyResult handlerNullPointerException(RuntimeException e) {
        logger.error(e.getMessage(), e);
        return MyResult.serverError("系统异常:" + e.getMessage(), 500);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public MyResult handlerIllegalArgumentException(IllegalArgumentException e) {
        logger.error(e.getMessage(), e);
        return MyResult.serverError("操作异常:" + e.getMessage(),500);
    }
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public MyResult handlerMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        logger.error(e.getMessage(), e);
        return MyResult.serverError("操作异常:" + e.getMessage(),500);
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
