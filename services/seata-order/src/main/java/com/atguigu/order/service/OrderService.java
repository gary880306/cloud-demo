package com.atguigu.order.service;

import com.atguigu.order.bean.OrderTbl;

public interface OrderService {
    /**
     * 創建訂單
     * @param userId    用戶id
     * @param commodityCode  商品代碼
     * @param orderCount  商品數量
     */
    OrderTbl create(String userId, String commodityCode, int orderCount);
}
