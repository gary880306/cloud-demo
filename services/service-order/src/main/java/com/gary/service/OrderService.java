package com.gary.service;

import com.gary.order.bean.Order;

public interface OrderService {

    Order createOrder(Long productId, Long userId);
}
