package com.jxd.petstore.service.impl;

import com.jxd.petstore.dao.IAccountDao;
import com.jxd.petstore.dao.IPetDao;
import com.jxd.petstore.dao.IPetOwnerDao;
import com.jxd.petstore.dao.IPetStoreDao;
import com.jxd.petstore.dao.impl.AccountDaoImpl;
import com.jxd.petstore.dao.impl.PetDaoImpl;
import com.jxd.petstore.dao.impl.PetOwnerDaoImpl;
import com.jxd.petstore.dao.impl.PetStroreDaoImpl;
import com.jxd.petstore.model.Pet;
import com.jxd.petstore.model.PetOwner;
import com.jxd.petstore.service.IPetOwnerService;

/**
 * @ClassName PetOwnerServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/14
 * @Version 1.0
 */

public class PetOwnerServiceImpl implements IPetOwnerService  {
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
     * 登录
     *
     * @return
     */
    @Override
    public boolean login(int id,String pwt) {
        boolean isSuccess = false;
        if (petOwnerDao.selecPasswore(id).equals(pwt)){
            isSuccess = true;
        }
        return isSuccess;
    }
}
