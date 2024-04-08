package com.jxd.petstore.service;

import com.jxd.petstore.model.Pet;
import com.jxd.petstore.model.PetOwner;

public interface IPetOwnerService extends Buyable,Sellable {

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
     * 登录
     * @return
     */
    boolean login(int id,String pwt);
}
