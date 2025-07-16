package com.gary.controller;

import com.gary.order.bean.Order;
import com.gary.properties.OrderProperties;
import com.gary.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope() // Nacos 配置中心自動刷新
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @Value("${order.test}")
//    private String orderConfigTest;

    @Autowired
    private OrderProperties orderProperties;

    @GetMapping("/order/create")
    public Order createOrder (@RequestParam("userId") Long userId, @RequestParam("productId") Long productId) {
        Order order = orderService.createOrder(userId, productId);
        return order;
    }

    @GetMapping("/order/seckill")
    public Order seckillOrder (@RequestParam("userId") Long userId, @RequestParam("productId") Long productId) {
        Order order = orderService.createOrder(userId, productId);
        order.setId(Long.MAX_VALUE);
        return order;
    }

    @GetMapping("/order/config")
    public String config () {
        return "order.test=" + orderProperties.getTest1() + ",order.test2=" + orderProperties.getTest2();
    }

    @GetMapping("/order/configDev")
    public String configDev () {
        return "order.timeout=" + orderProperties.getTimeOut() + ",order.auto.confirm=" + orderProperties.getAutoConfirm() + ",order.db.url=" + orderProperties.getDbUrl();
    }

    // 測試流控-關聯(大量寫的時候才會限制讀)
    // 讀
    @GetMapping("/order/read")
    public String read () {
        return "read success ......";
    }
    // 寫
    @GetMapping("/order/write")
    public String write () {
        return "write success ......";
    }


}
