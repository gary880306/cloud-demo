package com.atguigu.account.service.impl;

import com.atguigu.account.mapper.AccountTblMapper;
import com.atguigu.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountTblMapper accountTblMapper;
    @Override
    public void debit(String userId, int money) {
        // 扣減帳戶餘額
        accountTblMapper.debit(userId,money);
    }
}
