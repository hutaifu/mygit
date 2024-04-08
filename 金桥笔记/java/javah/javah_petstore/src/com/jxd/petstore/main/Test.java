package com.jxd.petstore.main;

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
import com.jxd.petstore.model.PetStore;
import com.jxd.petstore.service.IPetOwnerService;
import com.jxd.petstore.service.IPetStoreService;
import com.jxd.petstore.service.impl.PetOwnerServiceImpl;
import com.jxd.petstore.service.impl.PetStoreServiceImpl;
import com.jxd.petstore.util.GetTime;
import com.jxd.petstore.util.INPUT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/15
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        IAccountDao accountDao = new AccountDaoImpl();
        IPetDao petDao = new PetDaoImpl();
        IPetStoreDao petStoreDao = new PetStroreDaoImpl();
        IPetOwnerDao petOwnerDao = new PetOwnerDaoImpl();
        IPetStoreService petStoreService = new PetStoreServiceImpl();
        IPetOwnerService petOwnerService = new PetOwnerServiceImpl();
        Scanner input = new Scanner(System.in);
        Test1 test1 = new Test1();
        test1.starPetShop();
        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2,1,2);
        int opt = INPUT.input(list2);
        switch (opt){
            case 1:
                System.out.println("请先登录，请你输入主人id：");
                int id = input.nextInt();
                System.out.println("请输入主人密码");
                String pwt = input.next();
                if (petOwnerService.login(id,pwt)){
                    System.out.println("恭喜您成功登录");
                    System.out.println("你的基本信息");
                    PetOwner petOwner = petOwnerDao.selectOwner(id);
                    System.out.println("名字：" + petOwner.getName());
                    System.out.println("元宝数：" + petOwner.getMeney());
                    System.out.println("登录成功，你可以买和卖出宠物，购买宠物请输入1，卖出宠物请输入2");
                    System.out.println("1、购买宠物");
                    System.out.println("2、卖出宠物");
                    int opt1 = INPUT.input(list2);
                    switch (opt1){
                        case 1:
                            System.out.println("***********请选择要购买范围，只输入选择的序号********");
                            System.out.println("1.购买库存宠物");
                            System.out.println("2.购买新培育宠物");
                            int opt2 = INPUT.input(list2);
                            switch (opt2){
                                case 1:
                                    List<Pet>  list = petDao.getInstock(1);
                                    for (int i = 0; i < list.size(); i++) {
                                        Pet pet = list.get(i);
                                        System.out.println("序号" + (i+1)+ "我得名字叫"+ pet.getName() + "我是：" + pet.getTypename() + "购买我要花：" + pet.getBalance() + "个元宝");
                                    }
                                    System.out.println("------请选择购买哪一个宠物，并输入选择项的序号--------");
                                    int opt3 = input.nextInt();
                                    if (opt3 <= list.size() + 1){
                                        Pet pet = list.get(opt3-1);
                                        if (petOwner.getMeney() >= pet.getBalance()){
                                            petOwnerDao.updateMoney(id,0-pet.getBalance());
                                            petStoreDao.updateMoney(pet.getStore_id(),pet.getBalance());
                                            Account account = new Account(1,pet.getId(),pet.getStore_id(),pet.getOwner_id(),pet.getBalance(), GetTime.currentime());
                                            if (accountDao.insert(account)){
                                                System.out.println("台账正确插入一条信息");
                                            }else {
                                                System.out.println("插入失败");
                                            }
                                            petDao.updateOwner(pet.getId(),petOwner.getId());
                                        }else {
                                            System.out.println("余额不足");
                                        }
                                    }else {
                                        System.out.println("不存在该宠物");
                                    }
                                    break;
                                case 2:
                                    List<Pet>  list3 = petDao.getInstock(2);
                                    for (int i = 0; i < list3.size(); i++) {
                                        Pet pet = list3.get(i);
                                        System.out.println("序号" + (i+1)+ "我得名字叫"+ pet.getName() + "我是：" + pet.getTypename() + "购买我要花：" + pet.getBalance() + "个元宝");
                                    }
                                    System.out.println("------请选择购买哪一个宠物，并输入选择项的序号--------");
                                    int opt4 = input.nextInt();
                                    if (opt4 <= list3.size() + 1){
                                        Pet pet = list3.get(opt4-1);
                                        if (petOwner.getMeney() >= pet.getBalance()){
                                            petOwnerDao.updateMoney(id,0-pet.getBalance());
                                            petStoreDao.updateMoney(pet.getStore_id(),pet.getBalance());
                                            Account account = new Account(1,pet.getId(),pet.getStore_id(),pet.getOwner_id(),pet.getBalance(), GetTime.currentime());
                                            if (accountDao.insert(account)){
                                                System.out.println("台账正确插入一条信息");
                                            }else {
                                                System.out.println("插入失败");
                                            }
                                            petDao.updateOwner(pet.getId(),petOwner.getId());
                                        }else {
                                            System.out.println("余额不足");
                                        }
                                    }else {
                                        System.out.println("不存在该宠物");
                                    }
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("我的宠物列表");
                            List<Pet> list = petOwnerDao.shwopet(petOwner.getId());
                            for (Pet p:list) {
                                int num = 1;
                                System.out.println("序号：" +num +"我得名字叫：" + p.getName() +"我是：" + p.getType());
                                num++;
                            }
                            System.out.println("-------请选择要出售的宠物序号---------");
                            int num1 = input.nextInt();
                            if (num1 <= list.size()+1){
                                Pet pet = list.get(num1 -1);
                                System.out.println("-------------你要卖出的宠物信息如下----------");
                                System.out.println("宠物名字叫：" + pet.getName() + "宠物类别是：" + pet.getType());
                                System.out.println("请确认是否卖出，y代表卖出，n代表不卖");
                                List<String> list1 = new ArrayList<>();
                                Collections.addAll(list1,"y","n");
                                String opt3 = INPUT.inputStr(list1);
                                if (opt3.equals("y")){
                                    System.out.println("-------------下面是现有的宠物商店，请选择要卖给卖家序号------");
                                    List<PetStore> list3 = petStoreDao.getAllStore();
                                    for (int i = 0; i < list3.size(); i++) {
                                        PetStore petStore = list3.get(i);
                                        System.out.println("序号：" + i+1 +"宠物商店的名字:" + petStore.getName());
                                    }
                                    int opt4 = input.nextInt();
                                    if (opt4 <= list3.size()+1){
                                        PetStore petStore = list3.get(opt4-1);
                                        if (petStore.getBalance() >= pet.getBalance()){
                                            petStoreDao.updateMoney(petStore.getId(),0-pet.getBalance());
                                            petOwnerDao.updateMoney(petOwner.getId(),pet.getBalance());
                                            petDao.updateStore(pet.getId(),petStore.getId());
                                            Account account = new Account(2,pet.getId(),pet.getOwner_id(),pet.getStore_id(),pet.getBalance(), GetTime.currentime());
                                            if (accountDao.insert(account)){
                                                System.out.println("台账正确插入一条信息");
                                            }else {
                                                System.out.println("插入失败");
                                            }
                                        }else {
                                            System.out.println("余额不足");
                                        }
                                    }else {
                                        System.out.println("不存在");

                                    }
                                }else {
                                    System.out.println("取消购买");
                                }

                            }else {
                                System.out.println("不存在该宠物");
                            }
                    }

                }else {
                    System.out.println("登录失败");
                }

                break;
            case 2:
                System.out.println("请先登录，请你输入id：");
                int id1 = input.nextInt();
                System.out.println("请输入商店密码");
                String pwt1 = input.next();
                if (petStoreService.login(id1,pwt1)) {
                    System.out.println("恭喜您成功登录");
                    System.out.println("你的基本信息");
                    PetStore petStore = new PetStroreDaoImpl().getPetStrore(id1);
                    System.out.println("名字：" + petStore.getName());
                    System.out.println("元宝数：" + petStore.getBalance());
                    System.out.println("登录成功，你可以买和卖出宠物，购买宠物请输入1，卖出宠物请输入2");
                    System.out.println("1、购买宠物");
                    System.out.println("2、卖出宠物");
                    int opt1 = INPUT.input(list2);
                    switch (opt1) {
                        case 1:
                            System.out.println("***********请选择要购买范围，只输入选择的序号********");
                            System.out.println("1.购买库存宠物");
                            System.out.println("2.购买新培育宠物");
                            int opt2 = INPUT.input(list2);
                            switch (opt2){
                                case 1:
                                    List<Pet>  list = petDao.getInstock(1);
                                    for (int i = 0; i < list.size(); i++) {
                                        Pet pet = list.get(i);
                                        System.out.println("序号" + i+1+ "我得名字叫"+ pet.getName() + "我是：" + pet.getTypename() + "购买我要花：" + pet.getBalance() + "个元宝");
                                    }
                                    System.out.println("------请选择购买哪一个宠物，并输入选择项的序号--------");
                                    int opt3 = input.nextInt();
                                    if (opt3 <= list.size() + 1){
                                        Pet pet = list.get(opt3-1);
                                        if (petStore.getBalance() >= pet.getBalance()){
                                            petStoreDao.updateMoney(petStore.getId(),0-pet.getBalance());
                                            petOwnerDao.updateMoney(pet.getStore_id(),pet.getBalance());
                                            Account account = new Account(2,pet.getId(),pet.getOwner_id(),pet.getStore_id(),pet.getBalance(), GetTime.currentime());
                                            if (accountDao.insert(account)){
                                                System.out.println("台账正确插入一条信息");
                                            }else {
                                                System.out.println("插入失败");
                                            }
                                            petDao.updateStore(pet.getId(),petStore.getId());
                                        }else {
                                            System.out.println("余额不足");
                                        }
                                    }else {
                                        System.out.println("不存在该宠物");
                                    }
                                    break;
                                case 2:
                                    List<Pet>  list3 = petDao.getInstock(0);
                                    for (int i = 0; i < list3.size(); i++) {
                                        Pet pet = list3.get(i);
                                        System.out.println("序号" + i+1+ "我得名字叫"+ pet.getName() + "我是：" + pet.getTypename() + "购买我要花：" + pet.getBalance() + "个元宝");
                                    }
                                    System.out.println("------请选择购买哪一个宠物，并输入选择项的序号--------");
                                    int opt4 = input.nextInt();
                                    if (opt4 <= list3.size() + 1){
                                        Pet pet = list3.get(opt4-1);
                                        if (petStore.getBalance() >= pet.getBalance()){
                                            petStoreDao.updateMoney(petStore.getId(),0-pet.getBalance());
                                            petOwnerDao.updateMoney(pet.getOwner_id(),pet.getBalance());
                                            Account account = new Account(2,pet.getId(),pet.getOwner_id(),pet.getStore_id(),pet.getBalance(), GetTime.currentime());
                                            if (accountDao.insert(account)){
                                                System.out.println("台账正确插入一条信息");
                                            }else {
                                                System.out.println("插入失败");
                                            }
                                            petDao.updateStore(pet.getId(),petStore.getId());
                                        }else {
                                            System.out.println("余额不足");
                                        }
                                    }else {
                                        System.out.println("不存在该宠物");
                                    }
                                    break;
                            }
                        case 2:
                            System.out.println("我的宠物列表");
                            List<Pet> list = petStoreDao.getpet(petStore.getId());
                            for (Pet p:list) {
                                int num = 1;
                                System.out.println("序号：" +num +"我得名字叫：" + p.getName() +"我是：" + p.getType());
                                num++;
                            }
                            System.out.println("-------请选择要出售的宠物序号---------");
                            int num1 = input.nextInt();
                            if (num1 <= list.size()+1){
                                Pet pet = list.get(num1 -1);
                                System.out.println("-------------你要卖出的宠物信息如下----------");
                                System.out.println("宠物名字叫：" + pet.getName() + "宠物类别是：" + pet.getType());
                                System.out.println("请确认是否卖出，y代表卖出，n代表不卖");
                                List<String> list1 = new ArrayList<>();
                                Collections.addAll(list1,"y","n");
                                String opt3 = INPUT.inputStr(list1);
                                if (opt3.equals("y")){
                                    System.out.println("-------------下面是现有的宠物主人，请选择要卖给卖家序号------");
                                    List<PetOwner> list3 = petOwnerDao.getAllOwner();
                                    for (int i = 0; i < list3.size(); i++) {
                                        PetOwner petOwner = list3.get(i);
                                        System.out.println("序号：" + i+1 +"宠物主人的名字:" + petOwner.getName());
                                    }
                                    int opt4 = input.nextInt();
                                    if (opt4 <= list3.size()+1){
                                        PetOwner petOwner = list3.get(opt4-1);
                                        if (petOwner.getMeney() >= pet.getBalance()){
                                            petStoreDao.updateMoney(petStore.getId(),pet.getBalance());
                                            petOwnerDao.updateMoney(petOwner.getId(),0-pet.getBalance());
                                            petDao.updateOwner(pet.getId(),petOwner.getId());
                                            Account account = new Account(1,pet.getId(),pet.getStore_id(),pet.getOwner_id(),pet.getBalance(), GetTime.currentime());
                                            if (accountDao.insert(account)){
                                                System.out.println("台账正确插入一条信息");
                                            }else {
                                                System.out.println("插入失败");
                                            }
                                        }else {
                                            System.out.println("余额不足");
                                        }
                                    }else {
                                        System.out.println("不存在");

                                    }
                                }else {
                                    System.out.println("取消购买");
                                }

                            }else {
                                System.out.println("不存在该宠物");
                            }
                    }
                }else {
                    System.out.println("登录失败");
                }
        }
    }
}
