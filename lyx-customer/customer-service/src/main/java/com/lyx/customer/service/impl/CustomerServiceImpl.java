package com.lyx.customer.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lyx.customer.api.service.CustomerService;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0",timeout = 10000,interfaceClass = CustomerService.class)
public class CustomerServiceImpl implements CustomerService {
    @Override
    public String test(String name) {
        return "Hello,"+name+",this is a messgae from the customer module";
    }
}
