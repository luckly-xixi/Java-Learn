package com.example.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j   //Lombok提供的这个注解相当于 private static Logger log = LoggerFactory.getLogger(LogController.class);
public class LogController2 {

    @RequestMapping("/log2")
    public void log2() {
        log.trace("trace log2");
        log.debug("debug.log2");
        log.info("info log2");
        log.warn("warn log2");
        log.error("error log2");
    }
}

