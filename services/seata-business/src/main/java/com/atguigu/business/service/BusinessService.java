package com.atguigu.business.service;

public interface BusinessService {

    /**
     * 採購
     * @param userId            用戶id
     * @param commodityCode     商品代碼
     * @param orderCount        購買數量
     */
    void purchase(String userId, String commodityCode, int orderCount);
}
