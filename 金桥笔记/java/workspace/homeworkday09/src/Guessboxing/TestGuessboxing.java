package Guessboxing;

import java.util.Scanner;

/**
 * @ClassName TestGuessboxing
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class TestGuessboxing {
    public static void main(String[] args) {
        int num4 = 0;
        Scanner input = new Scanner(System.in);
        Computer computer = new Computer();
        Game game = new Game();
        Person person = new Person();
        person.name = "无名氏";
        game.initial();
        System.out.println("出拳规则：1.剪刀2.石头.3.布");
        System.out.println("请选择对方角色（1.刘备2.孙权3.曹操）：");
        int num = input.nextInt();
        computer.name = game.starGame(num);
        System.out.println("请输入你的名字：");
        person.name = input.next();
        System.out.println("要开始吗？（y/n）");
        String s1 = input.next();
        if ("y".equals(s1)){
            do {
                System.out.println("请出拳：1.剪刀2.石头3.布(输入相应数字)：");
                int num3 = input.nextInt();
                int num1 = 0;
                if (num3 == 1 || num3 == 2 || num3 == 3) {
                    num1 = num3;
                } else {
                    System.out.println("输入错误");
                }
                person.showboxing(num1);
                int num2 = computer.getboxing();
                if (num1 == num2 + 1 || num1 + 2 == num2) {
                    System.out.println("结果：恭喜，你赢了！");
                    person.score++;
                } else if (num2 == num1 + 1 || num2 + 2 == num1) {
                    System.out.println("结果说：^-^,你输入了，真笨！");
                    computer.scoer++;
                } else if (num1 == 0) {
                    System.out.println("错误");
                } else {
                    System.out.println("结果：和局，真衰！嘿嘿，等着瞧吧！");
                }
                System.out.println();
                num4 ++;
                System.out.println("是否开始下一轮(y/n)：");
                s1 = input.next();
            }while ("y".equals(s1));
            if ("n".equals(s1)){
                System.out.println(computer.name + "  VS  " + person.name);
                System.out.println("对战次数：" + num4);
                if (computer.scoer > person.score){
                    System.out.println("你输了，真菜啊！");
                }else if (computer.scoer < person.score){
                    System.out.println("你赢了，好厉害啊！");
                }else {
                    System.out.println("打成平手，下次再一决雌雄！");
                }
            }
        }
    }
}
