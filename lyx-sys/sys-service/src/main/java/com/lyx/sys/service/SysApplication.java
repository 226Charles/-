package com.lyx.sys.service;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class SysApplication {
    public static void main(String args[]){
        SpringApplication.run(SysApplication.class,args);
    }
}
