package com.jxd.petstore.service;

import com.jxd.petstore.model.Pet;

public interface Breedable {
    /**
     * 培育宠物
     * @param petType 宠物类型
     * @return 返回新生宠物
     */
    Pet breed(String petType);
}
