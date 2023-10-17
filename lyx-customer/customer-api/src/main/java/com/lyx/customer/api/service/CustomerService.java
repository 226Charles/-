package com.lyx.customer.api.service;

import com.lyx.customer.api.entity.CustomerInfo;

public interface CustomerService {
    String test (String name);

    CustomerInfo findCustomerInfoByPrimary(Integer customerId) throws Exception;
}
