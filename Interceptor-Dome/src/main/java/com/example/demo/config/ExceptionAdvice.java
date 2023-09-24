package com.example.demo.config;


import com.example.demo.common.ResultAjax;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice // 相当于是  @ControllerAdvice + @ResponseBody
public class ExceptionAdvice {

    //单一处理
    @ExceptionHandler(NullPointerException.class)
    public ResultAjax doNullPointerException (NullPointerException e) {

        ResultAjax resultAjax = new ResultAjax();
        resultAjax.setCode(-1);
        resultAjax.setMsg("空指针异常" + e.getMessage());
        resultAjax.setData(null);
        return resultAjax;
    }

    //统一处理
    @ExceptionHandler(Exception.class)
    public ResultAjax doException (Exception e) {
        ResultAjax resultAjax = new ResultAjax();
        resultAjax.setCode(-1);
        resultAjax.setMsg("异常" + e.getMessage());
        resultAjax.setData(null);
        return resultAjax;
    }
}
