package com.jxd.petstore.service;

import com.jxd.petstore.model.Account;
import com.jxd.petstore.model.Pet;

import java.util.List;

public interface Accountable {
    /**
     * 拿到记录
     * @param storeId 商店序号
     * @return 返回记录集合
     */
    List<Account> getAccount(int storeId);
}
