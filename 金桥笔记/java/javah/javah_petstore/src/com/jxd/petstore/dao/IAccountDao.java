package com.jxd.petstore.dao;

import com.jxd.petstore.model.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 添加账目
     * @param account 添加的账目
     * @return 是否成功
     */
    boolean insert(Account account);

    /**
     * 根据商店id拿到交易记录
     * @param id 商店id
     * @return 返回交易记录集合
     */
    List<Account> shwo(int id);
}
