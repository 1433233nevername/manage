package com.zb.manage.web.advice;

import com.zb.manage.web.result.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResult exception(Exception e) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode("1");
        commonResult.setMsg(e.getMessage());
        return commonResult;
    }
}
