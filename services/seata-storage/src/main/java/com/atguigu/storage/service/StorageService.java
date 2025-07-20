package com.atguigu.storage.service;

public interface StorageService {


    /**
     * 扣除儲存數量
     * @param commodityCode 商品代碼
     * @param count 數量
     */
    void deduct(String commodityCode, int count);
}
