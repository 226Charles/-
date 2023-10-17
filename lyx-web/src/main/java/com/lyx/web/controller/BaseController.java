package com.lyx.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lyx.common.cache.CacheService;
import com.lyx.customer.api.service.CustomerService;
import com.lyx.goods.api.entity.GoodsInfo;
import com.lyx.goods.api.service.GoodsService;
import com.lyx.order.api.service.OrderService;
import com.lyx.sys.api.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public Object detail(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        GoodsInfo goods = (GoodsInfo) cacheService.getCacheByKey("lyx_goods:"+id);
        System.out.println("cache"+goods);
        if(null == goods){
            goods = goodsService.findGoodsInfoByPrimary(Integer.parseInt(id));
            System.out.println("mysql"+goods);
            cacheService.setCacheToRedis("lyx_goods:"+id,goods,1800);
        }
        return goods;
    }

    @RequestMapping(value = "goods",method = RequestMethod.GET)
    public Object testGoods(HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        int id = Integer.parseInt(name);
        System.out.println(id);
        GoodsInfo goodsInfo = goodsService.findGoodsInfoByPrimary(id);
        System.out.println(goodsInfo.toString());
        return goodsInfo.getGoodsName();
    }

    @RequestMapping(value = "customer",method = RequestMethod.GET)
    public Object testCustomer(HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        return customerService.test(name);
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
