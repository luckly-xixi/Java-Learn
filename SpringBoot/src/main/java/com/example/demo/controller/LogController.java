package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    //1、得到日志对象
    private static Logger log =
            LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/log")
    public void log() {

        String msg = "这是个自定义日志";

        log.info("info ->" + msg);
        log.debug("debug ->" + msg);
        log.trace("trace ->" + msg);
        log.warn("warn ->"+ msg);
        log.error("error ->" + msg);

        //日志级别：
        //trace:微量、少许、痕迹，日志级别最低
        //debug:调试日志级别
        //info:普通的日志级别
        //warn:警告日志级别
        //error:错误的日志级别
        //fatal:致命的日志级别，只有系统在崩溃的时候才会输出的日志级别，级别最高
    }
}
