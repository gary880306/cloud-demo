package com.atguigu.account.service;

public interface AccountService {

    /**
     * 從帳戶扣減餘額
     * @param userId  用户id
     * @param money   扣减金额
     */
    void debit(String userId, int money);
}
