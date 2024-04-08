package ch006;

import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
        boolean isSuccesss = true;
        int score = 0;
        Scanner input = new Scanner(System.in);
        String name = "";
        int sum = 0;
        double aba = 0;
        System.out.print("请输入学生姓名：");
        name = input.next();
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第"+(i+1)+"门课成绩");
            score = input.nextInt();
            if (score < 0){
                isSuccesss = false;
                break;
            }
            sum += score;
        }
        if (isSuccesss) {
            System.out.println("张三的平均分是" + (sum / 5.0));
        }else {
            System.out.println("录入错误，请重新录入");
        }

    }
}
