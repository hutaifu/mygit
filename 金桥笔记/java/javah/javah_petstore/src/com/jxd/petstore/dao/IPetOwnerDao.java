package com.jxd.petstore.dao;

import com.jxd.petstore.model.Pet;
import com.jxd.petstore.model.PetOwner;

import java.util.List;

public interface IPetOwnerDao {
    /**
     * 查询所有宠物主人信息
     * @return 返回宠物主人集合
     */
    List<PetOwner> getAllOwner();


    /**
     * 根据id查找密码
     * @param id 主人id
     * @return 返回密码
     */
    String selecPasswore(int id);

    /**
     * 根据id查询信息
     * @param id 主人id
     * @return 返回宠物主人
     */
    PetOwner selectOwner(int id);

    /**
     * 更新主人元宝
     * @param id 主人id
     * @param money 修改的金额
     * @return 是否成功
     */
    boolean updateMoney(int id,double money);

    /**
     * 显示主人宠物列表
     * @param num 主人id
     * @return 返回宠物列表
     */
    List<Pet> shwopet(int num);

}
