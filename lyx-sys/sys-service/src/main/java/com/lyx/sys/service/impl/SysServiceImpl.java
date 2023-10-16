package com.lyx.sys.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lyx.sys.api.service.SysService;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0",timeout = 10000,interfaceClass = SysService.class)
public class SysServiceImpl implements SysService {
    @Override
    public String test(String name) {
        return "Hello,"+name+",this is a messgae from the sys module";
    }
}
