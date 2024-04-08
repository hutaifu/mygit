package com.jxd.petstore.dao;

import com.jxd.petstore.model.Pet;
import com.jxd.petstore.model.PetStore;

import java.util.List;

public interface IPetStoreDao {
    /**
     * 查询所有宠物商店信息
     * @return 返回宠物商店列表
     */
    List<PetStore> getAllStore();

    /**
     * 跟新商店元宝
     * @param num 商店id
     * @param money 修改金额
     * @return 是否成功
     */
    boolean updateMoney(int num,double money);

    String getpwt(int id);

    PetStore getPetStrore(int id);

    List<Pet> getpet(int num);
}
