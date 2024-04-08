package com.jxd.petstore.main;

import com.jxd.petstore.dao.IAccountDao;
import com.jxd.petstore.dao.IPetDao;
import com.jxd.petstore.dao.IPetOwnerDao;
import com.jxd.petstore.dao.IPetStoreDao;
import com.jxd.petstore.dao.impl.AccountDaoImpl;
import com.jxd.petstore.dao.impl.PetDaoImpl;
import com.jxd.petstore.dao.impl.PetOwnerDaoImpl;
import com.jxd.petstore.dao.impl.PetStroreDaoImpl;
import com.jxd.petstore.model.PetOwner;
import com.jxd.petstore.model.PetStore;

import java.util.List;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/15
 * @Version 1.0
 */

public class Test1 {
    IPetDao petDao = new PetDaoImpl();
    IPetOwnerDao petOwnerDao = new PetOwnerDaoImpl();
    IPetStoreDao petStoreDao = new PetStroreDaoImpl();
    IAccountDao accountDao = new AccountDaoImpl();

    void starPetShop(){
        System.out.println("宠物商店启动");
        System.out.println("Wonderland醒来，所有宠物从mysql中醒来");
        System.out.println("***********************************************");
        petDao.getAllPet();
        System.out.println("************************************************");
        System.out.println();
        System.out.println("所有宠物主人从mysql中醒来");
        System.out.println("**********************************************");
        List<PetOwner> list = petOwnerDao.getAllOwner();
        for (PetOwner p: list) {
            int num = 1;
            System.out.println("第" + num + "个宠物主人，名字叫：" + p.getName());
            num ++;
        }
        System.out.println("*************************************************");
        System.out.println();
        System.out.println("所有宠物商店从mysql中醒来");
        List<PetStore> list1 = petStoreDao.getAllStore();
        for (PetStore p:list1) {
            System.out.println("我的名字叫：" + p.getName());
        }
        System.out.println("请选择登录模式,输入1为宠物主人登录，输入2为宠物商店登录");
    }

    boolean ownerLogin(){
        return false;
    }

    void wonerSell(){

    }
}
