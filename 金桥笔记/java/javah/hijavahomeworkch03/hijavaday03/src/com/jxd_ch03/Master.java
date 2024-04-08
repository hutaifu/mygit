package com.jxd_ch03;

/**
 * @ClassName Master
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Master {
    public void cure(Dog dog){
        if (dog.getHealth() < 60){
            System.out.println("宠物小狗生病了，需要打针。");
            dog.setHealth(60);
        }
    }

    public void cure(Penguin penguin){
        if (penguin.getHealth() < 60){
            System.out.println("QQ生病了，需要吃药");
            penguin.setHealth(60);
        }
    }

   //主人只需要带着宠物去看病即可
    //治疗方式在宠物对象本身里
   public void curePet(Pet pet){
       if (pet.getHealth() < 60){
           //调用宠物自己的治疗方法
           pet.cure();
           pet.setHealth(60);
       }
   }

}
