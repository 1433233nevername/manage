package com.jacks.login.web.util;

import com.jacks.login.web.result.CommonResult;

public class ResultUtil {

    public static CommonResult ok(Object data) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode("0");
        commonResult.setMsg("成功");
        commonResult.setData(data);
        return commonResult;
    }
}
