package com.jxd.petstore.dao;

import com.jxd.petstore.model.Pet;

import java.util.List;

public interface IPetDao {
    /**
     * 查询所有宠物信息
     */
    void getAllPet();

    /**
     * 根据输入数字查询所有库存或者培育宠物
     * @param num 输入数字代表库存或者培育
     */
    List<Pet> getInstock(int num);

    /**
     * 更新宠物主人
     * @param num 宠物id
     * @param num1 主人id
     * @return 返回是否成功
     */
    boolean updateOwner(int num,int num1);

    boolean updateStore(int num,int num1);
}
