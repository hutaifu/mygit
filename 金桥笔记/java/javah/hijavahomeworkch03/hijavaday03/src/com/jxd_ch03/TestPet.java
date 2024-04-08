package com.jxd_ch03;

/**
 * @ClassName TestPet
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class TestPet {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setHealth(50);

        Master master = new Master();
        master.cure(dog);

        Pet pet = new Dog();
        pet.setHealth(50);
        master.curePet(pet);

        Pet pet1 = new Penguin();
        pet1.setHealth(50);
        master.curePet(pet1);

        //pet是父类类型，不能直接调用子类中存在的方法
        //pet.play()

        //需要将pet中的小狗对象拿出来称为真正的小狗对象才能调用小狗的方法
        //大范围转小范围
        Dog dog1 = (Dog)pet;
        dog.playFlydisc();


        //在类型转换之前判断一些pet1中到底是什么类型。
        if (pet1 instanceof Dog) {
            Dog dog2 = (Dog) pet1;
        }else {
            Penguin penguin = (Penguin)pet1;
            penguin.swim();
        }

        if ("hello" instanceof Object){

        }

        if (pet instanceof Object){

        }

    }

}
