package com.jxd.petstore.service;

import com.jxd.petstore.model.Pet;

public interface Sellable {
    /**
     * 卖宠物
     * @param pet 宠物
     */
    void sell(Pet pet);
}
