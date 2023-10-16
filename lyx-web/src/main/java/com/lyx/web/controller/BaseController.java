package com.lyx.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lyx.customer.api.service.CustomerService;
import com.lyx.goods.api.service.GoodsService;
import com.lyx.order.api.service.OrderService;
import com.lyx.sys.api.service.SysService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/lyx/")
public class BaseController {

    @Reference(version = "1.0.0")
    private GoodsService goodsService;

    @Reference(version = "1.0.0")
    private CustomerService customerService;

    @Reference(version = "1.0.0")
    private OrderService orderService;

    @Reference(version = "1.0.0")
    private SysService sysService;

    @RequestMapping(value = "goods",method = RequestMethod.GET)
    public Object testGoods(HttpServletRequest request){
        String name = request.getParameter("name");
        return goodsService.test(name);
    }

    @RequestMapping(value = "customer",method = RequestMethod.GET)
    public Object testCustomer(HttpServletRequest request){
        String name = request.getParameter("name");
        return goodsService.test(name);
    }

    @RequestMapping(value = "order",method = RequestMethod.GET)
    public Object testOrder(HttpServletRequest request){
        String name = request.getParameter("name");
        return goodsService.test(name);
    }

    @RequestMapping(value = "sys",method = RequestMethod.GET)
    public Object testSys(HttpServletRequest request){
        String name = request.getParameter("name");
        return goodsService.test(name);
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public Object test(HttpServletRequest request){
        return "test information!";
    }
}
