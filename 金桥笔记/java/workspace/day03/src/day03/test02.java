package day03;

import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入张三的成绩");
        int score = input.nextInt();

        if (score >= 90){
            System.out.println("优秀");
        }

        if (score >=80 && score < 90){
            System.out.println("良好");
        }

        if (score >= 60 && score < 80){
            System.out.println("及格");
        }

        if (score <60){
            System.out.println("不及格");
        }
//        连续区间的判断使用多重if注意顺序，不能随意改变
        if (score >=90){
            System.out.println("优秀");
        }else if (score >=80){
            System.out.println("良好");
        }else if(score >= 60){
            System.out.println("及格");
        }else {
            System.out.println("不及格");
        }
    }
}
