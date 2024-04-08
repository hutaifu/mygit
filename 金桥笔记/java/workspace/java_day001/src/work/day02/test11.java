package work.day02;

import java.util.Scanner;

public class test11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入性别：");
        String sex = input.next();
        System.out.println("请输入年龄：");
        int age = input.nextInt();
        if ((sex.equals("男") && (age > 5)) || ((sex.equals("女")) && (age >7))){
            System.out.println("可以搬动桌子");
        }else {
            System.out.println("不能般动桌子");
        }

    }
}
