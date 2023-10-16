package com.lyx.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lyx.goods.api.service.GoodsService;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0",timeout = 10000,interfaceClass = GoodsService.class)
public class GoodsServiceImpl implements GoodsService {
    @Override
    public String test(String name) {
        return "Hello,"+name+",this is a messgae from the goods module";
    }
}
