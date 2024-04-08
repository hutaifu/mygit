package com.jxd.petstore.service.impl;

import com.jxd.petstore.dao.IAccountDao;
import com.jxd.petstore.dao.IPetDao;
import com.jxd.petstore.dao.IPetOwnerDao;
import com.jxd.petstore.dao.IPetStoreDao;
import com.jxd.petstore.dao.impl.AccountDaoImpl;
import com.jxd.petstore.dao.impl.PetDaoImpl;
import com.jxd.petstore.dao.impl.PetOwnerDaoImpl;
import com.jxd.petstore.dao.impl.PetStroreDaoImpl;
import com.jxd.petstore.model.Account;
import com.jxd.petstore.model.Pet;
import com.jxd.petstore.model.PetOwner;
import com.jxd.petstore.service.IPetStoreService;

import java.util.List;

/**
 * @ClassName PetStoreServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/14
 * @Version 1.0
 */

public class PetStoreServiceImpl implements IPetStoreService {
    IAccountDao accountDao = new AccountDaoImpl();
    IPetDao petDao = new PetDaoImpl();
    IPetOwnerDao petOwnerDao = new PetOwnerDaoImpl();
    IPetStoreDao petStoreDao = new PetStroreDaoImpl();
    /**
     * 买宠物
     *
     * @param pet 要买的宠物
     */
    @Override
    public void buy(Pet pet) {

    }

    /**
     * 卖宠物
     *
     * @param pet 要卖的宠物
     */
    @Override
    public void sell(Pet pet) {

    }

    /**
     * 繁殖
     *
     * @param petType 宠物类型
     * @return 返回出生的宠物
     */
    @Override
    public Pet breed(String petType) {
        return null;
    }

    /**
     * 拿到库存宠物
     *
     * @param storeId 商店序号
     * @return 返回库存宠物名单
     */
    @Override
    public List<Pet> getPetsInStock(int storeId) {
        return null;
    }

    /**
     * 拿到新培育宠物
     *
     * @param storeId 商店序号
     * @return 返回宠物名单
     */
    @Override
    public List<Pet> getPetBreed(int storeId) {
        return null;
    }

    /**
     * 生成记录
     *
     * @param account 交易记录
     */
    @Override
    public void charge(Account account) {

    }

    @Override
    public List<Account> getAccount(int storeId) {
        return null;
    }

    /**
     * 登录
     *
     * @return
     */
    @Override
    public boolean login(int id,String pwt) {
        boolean isSuccess = false;
        if (petStoreDao.getpwt(id).equals(pwt)){
            isSuccess = true;
        }
        return isSuccess;
    }
}
