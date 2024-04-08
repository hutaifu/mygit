package ch01;

import java.util.Scanner;

/**
 * @ClassName Pet
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

class Pet {
    void start(){
        Scanner input = new Scanner(System.in);
        String pettype = "";
        boolean flag = true;
        Dog dog = new Dog();
        Penguin penguin = new Penguin();






        System.out.println("欢迎来到宠物店");
        System.out.println("请输入要领养的宠物名字：");
        String name = input.next();
        do {
            System.out.println("请输入要领养的宠物类型：（1.狗狗2.企鹅）");
            int num = input.nextInt();
            switch (num) {
                case 1:
                    dog.setName(name);
                    pettype = "狗";
                    flag = false;
                    break;
                case 2:
                    penguin.setName(name);
                    pettype = "企鹅";
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误");
            }
        }while (flag);
        if (pettype.equals("狗")) {
            System.out.println("请选择狗的品种：（1.聪明的拉布拉多犬2.酷酷的雪瑞娜）");
            int num = input.nextInt();
            dog.setType(num);
            System.out.println("请输入狗狗的健康值（1到100之间）：");
            int health = input.nextInt();
            dog.setHealth(health);
            dog.showinfo();
        }else {
            System.out.println("请选择企鹅的性别：（1.Q仔2.Q妹）");
            int num = input.nextInt();
            penguin.setSex(num);
            System.out.println("请输入狗狗的健康值（1到100之间）：");
            int health = input.nextInt();
            penguin.setHealth(health);
            penguin.showinfo();
        }







    }
}
