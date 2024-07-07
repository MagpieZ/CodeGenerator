package com.zyh.exp;

import com.zyh.utils.ActionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ActionResult handlerException(Exception e) {
        System.out.println("come in GlobalExceptionHandler");
        log.error("全局异常信息：{}", e.getMessage(), e);
        return ActionResult.fail("系统异常:" + e.getMessage());
    }
}
