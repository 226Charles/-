package com.lyx.web.exception;

import com.lyx.common.exception.DescribeException;
import com.lyx.common.exception.ExceptionEnum;
import com.lyx.common.message.Result;
import com.lyx.common.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>异常切面</p>
 *
 * @author lft
 * @version 1.0
 * @date 2019/6/15 0015
 * @since jdk1.8
 */
@ControllerAdvice
public class ExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionGet(Exception e){
        if(e instanceof DescribeException){
            DescribeException exception = (DescribeException) e;
            return ResultUtils.error(exception.getCode(),exception.getMessage());
        }
        LOGGER.error("【系统异常】{}",e.getMessage());
        return ResultUtils.exception(ExceptionEnum.SERVICE_ERROR);
    }
}