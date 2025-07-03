package com.gary.controller;

import com.gary.order.bean.Order;
import com.gary.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope() // Nacos 配置中心自動刷新
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${order.test}")
    private String orderConfigTest;

    @GetMapping("/order/create")
    public Order createOrder (@RequestParam("userId") Long userId, @RequestParam("productId") Long productId) {
        Order order = orderService.createOrder(userId, productId);
        return order;
    }

    @GetMapping("/order/config")
    public String config () {
        return "order.test=" + orderConfigTest;
    }
}
