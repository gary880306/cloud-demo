package com.atguigu.order.service.impl;

import com.atguigu.order.bean.OrderTbl;
import com.atguigu.order.feign.AccountFeignClient;
import com.atguigu.order.mapper.OrderTblMapper;
import com.atguigu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderTblMapper orderTblMapper;
    @Autowired
    AccountFeignClient accountFeignClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderTbl create(String userId, String commodityCode, int orderCount) {
        // 1、計算訂單價格
        int orderMoney = calculate(commodityCode, orderCount);

        // 2、扣減帳戶餘額
        accountFeignClient.debit(userId, orderMoney);

        //3、保存訂單
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setUserId(userId);
        orderTbl.setCommodityCode(commodityCode);
        orderTbl.setCount(orderCount);
        orderTbl.setMoney(orderMoney);

        orderTblMapper.insert(orderTbl);

        // 模擬異常
        int i = 10/0;

        return orderTbl;
    }

    // 計算價格
    private int calculate(String commodityCode, int orderCount) {
        return 9*orderCount;
    }
}
