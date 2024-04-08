package day02;

import java.util.Random;

/**
 * @ClassName GuessMachine
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class GuessMachine {
    String name1 = "千鹤电动车";
    String name2 = "60寸电视机";
    String name3 = "新飞双开门冰箱";
    int value1 = 2000;
    int value2 = 8000;
    int value3 = 9000;
    int num;
    int value;
    String name;
    public void firm(){
        Random random = new Random();
        num = random.nextInt(10);
        switch (num){
            case 1:
            case 2:
            case 3:
                name = name1;
                value = value1;
                System.out.println(name);
                break;
            case 6:
            case 4:
            case 5:
                name = name2;
                value = value2;
                System.out.println(name);
                break;
            case 7:
            case 8:
            case 9:
                name = name3;
                value = value3;
                System.out.println(name);
                break;
        }

    }

    public String guess(int guessvalue){
        if (guessvalue > value){
            return "猜大了";
        }else if (guessvalue < value){
            return "猜小了";
        }else if (guessvalue == value){
            return "猜对了";
        }
        return "出错了";
    }
}
