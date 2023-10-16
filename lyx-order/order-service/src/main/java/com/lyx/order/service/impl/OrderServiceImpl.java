package com.lyx.order.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lyx.order.api.service.OrderService;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0",timeout = 10000,interfaceClass = OrderService.class)
public class OrderServiceImpl implements OrderService {
    @Override
    public String test(String name) {
        return "Hello,"+name+",this is a messgae from the order module";
    }
}
