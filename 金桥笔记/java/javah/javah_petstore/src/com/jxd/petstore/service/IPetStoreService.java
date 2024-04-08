package com.jxd.petstore.service;

import com.jxd.petstore.model.Account;
import com.jxd.petstore.model.Pet;
import com.jxd.petstore.model.PetOwner;

import java.util.List;

public interface IPetStoreService extends Buyable,Sellable,Breedable,Accountable {
    /**
     * 买宠物
     * @param pet 要买的宠物
     */
    void buy(Pet pet);

    /**
     * 卖宠物
     * @param pet 要卖的宠物
     */
    void sell(Pet pet);

    /**
     * 繁殖
     * @param petType 宠物类型
     * @return 返回出生的宠物
     */
    Pet breed(String petType);

    /**
     * 拿到库存宠物
     * @param storeId 商店序号
     * @return 返回库存宠物名单
     */
    List<Pet> getPetsInStock(int storeId);

    /**
     * 拿到新培育宠物
     * @param storeId 商店序号
     * @return 返回宠物名单
     */
    List<Pet> getPetBreed(int storeId);

    /**
     * 生成记录
     * @param account 交易记录
     */
    void charge(Account account);

    List<Account> getAccount(int storeId);

    /**
     * 登录
     * @return
     */
    boolean login(int id,String pwt);


}
