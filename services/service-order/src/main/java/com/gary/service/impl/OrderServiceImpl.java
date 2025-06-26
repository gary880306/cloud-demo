package com.gary.service.impl;

import com.gary.bean.Order;
import com.gary.service.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(Long productId, Long userId) {
        Order order = new Order();
        order.setId(1L);
        // 遠程調用product
        order.setTotalAmt(new BigDecimal(0));
        order.setUserId(userId);
        order.setNickName("gary");
        order.setAddress("文山區");
        // 遠程調用product
        order.setProductList(null);
        return order;
    }
}
