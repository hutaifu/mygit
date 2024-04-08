package com.jxd.petstore.service;

import com.jxd.petstore.model.Pet;

public interface Buyable {
    /**
     * 买宠物
     * @param pet 要买的宠物
     */
    void buy(Pet pet);
}
