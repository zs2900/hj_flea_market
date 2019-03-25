/*
 * 文 件 名:  MyControllerAdvice.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2018年11月1日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.exception;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.common.enums.ResultCode;
import com.ecjtu.common.exception.InnerException;

/**
 * 
 * 全局异常处理
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2018年11月1日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@RestControllerAdvice
public class MyControllerAdvice
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MyControllerAdvice.class);
    
    /**
     * 
     * 全局异常捕捉处理
     * <功能详细描述>
     * @param e 服务器异常
     * @return 500页面
     * @see [类、类#方法、类#成员]
     */
    @ExceptionHandler(Exception.class)
    public BaseResponse handleException(Exception e)
    {
        LOGGER.error("通用异常:{}", ResultCode.INNER_ERROR.getResultMsg());
        BaseResponse resp = new BaseResponse();
        resp.setRetCode(ResultCode.INNER_ERROR.getResultCode());
        resp.setRetMsg(e.getMessage());
        
        return resp;
    }
    
    /**
     * 
     * 拦截捕捉自定义异常 InnerException.class
     * <功能详细描述>
     * @param e 自定义的服务器内部异常对象
     * @return 响应实体
     * @see [类、类#方法、类#成员]
     */
    @ExceptionHandler(InnerException.class)
    public BaseResponse myErrorHandler(InnerException e)
    {
        LOGGER.error("服务器内部异常:{}", e.getErrorDesc());
        BaseResponse resp = new BaseResponse(e);
        
        return resp;
    }
    
    /**
     * 
     * 捕获文件IO异常
     * <功能详细描述>
     * @param e IO异常对象
     * @return 响应实体
     * @see [类、类#方法、类#成员]
     */
    @ExceptionHandler(IOException.class)
    public BaseResponse ioExceptionHandler(IOException e)
    {
        LOGGER.error("IO异常:{}", ResultCode.UNKNOW_ERROR.getResultMsg());
        BaseResponse resp = new BaseResponse();
        resp.setRetCode(ResultCode.INNER_ERROR.getResultCode());
        resp.setRetMsg(ResultCode.INNER_ERROR.getResultMsg());
        
        return resp;
    }
    
    /**
     * 
     * 404 - Not Found
     * <功能详细描述>
     * @param e 404异常对象
     * @return 404页面
     * @see [类、类#方法、类#成员]
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public String noHandlerFoundException(NoHandlerFoundException e)
    {
        LOGGER.error("Not Found:{}", e);
        return "error/404";
    }
    
}
