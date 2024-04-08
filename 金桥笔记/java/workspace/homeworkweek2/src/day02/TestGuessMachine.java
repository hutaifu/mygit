package day02;

import java.util.Scanner;

/**
 * @ClassName TestGuessMachine
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestGuessMachine {
    public static void main(String[] args) {
        GuessMachine guessMachine = new GuessMachine();
        guessMachine.firm();
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.println("请输入猜测价格：");
            int guessvalue = input.nextInt();
            String anwer = guessMachine.guess(guessvalue);
            System.out.println(anwer);
            if (anwer.equals("猜对了")){
                break;
            }
        }
    }
}
