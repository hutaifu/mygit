package ch006;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = "";
        int sum = 0;
        double aba = 0;
        System.out.print("请输入学生姓名：");
        name = input.next();
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第"+(i+1)+"门课成绩");
            sum += input.nextInt();
        }
        System.out.println("张三的平均分是"+(sum / 5.0));
    }
}
