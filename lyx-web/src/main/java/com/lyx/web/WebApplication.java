package com.lyx.web;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = {"com.lyx.web","com.lyx.common"})
@EnableDubbo
@ServletComponentScan(basePackages = "com.lyx.web.filter")
public class WebApplication {
    public static void main(String args[]){
        SpringApplication.run(WebApplication.class,args);
    }
}
