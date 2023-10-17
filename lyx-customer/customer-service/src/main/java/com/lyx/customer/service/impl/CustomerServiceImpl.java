package com.lyx.customer.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lyx.customer.api.entity.CustomerInfo;
import com.lyx.customer.api.service.CustomerService;
import com.lyx.customer.service.mapper.CustomerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0",timeout = 10000,interfaceClass = CustomerService.class)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    @Override
    public String test(String name) {
        return "Hello,"+name+",this is a messgae from the customer module";
    }


    @Override
    public CustomerInfo findCustomerInfoByPrimary(Integer customerId) throws Exception {
        return customerInfoMapper.selectByPrimaryKey(customerId);
    }

}
