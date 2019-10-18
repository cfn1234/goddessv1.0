package com.goddess.config.expection;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局异常处理
 * com.goddess.config.expection
 *
 * @author caofengnian
 * @Date 2019-10-18
 */
@RestControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ShiroException.class)
    public String handleShiroException(ShiroException e) {
        String eName = e.getClass().getSimpleName();
        logger.error("shiro执行出错：{}",eName);
        return "";
    }

    @ExceptionHandler(UnauthenticatedException.class)
    public String page401(UnauthenticatedException e) {
        logger.error("未经授权:{}",e.getMessage());
        return "";
    }

    @ExceptionHandler(UnauthorizedException.class)
    public String page403(UnauthorizedException e) {
        logger.error("无权限访问:{}",e.getMessage());
        return "";
    }

    @ExceptionHandler(Exception.class)
    public String error(Exception e) {
        logger.error("系统异常:{}",e.getMessage());
        return "";
    }
}