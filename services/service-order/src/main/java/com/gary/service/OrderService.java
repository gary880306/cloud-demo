package com.gary.service;

import com.gary.bean.Order;

public interface OrderService {

    Order createOrder(Long productId, Long userId);
}
