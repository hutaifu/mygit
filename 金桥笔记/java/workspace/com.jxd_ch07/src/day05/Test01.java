package day05;

import java.util.Scanner;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        int highCount = 0;
        Scanner input = new Scanner(System.in);
//        每个班级学生成绩
        int[] scores = new int[4];
        int classCount = 3;
//        和
        int sum = 0;
//        平均分
        double avg = 0;
        for (int i = 0; i < classCount; i++) {
            sum =0;
            System.out.println("请录入第" + (i+1) + "个班级的成绩");
            for (int j = 0; j < scores.length; j++) {
                System.out.println("第" + (j + 1) + "个学员的成绩:");
                scores[j] = input.nextInt();
                sum += scores[j];
                if (scores[j] < 85){
                    continue;
                }
                highCount ++;
            }
            avg = 1.0 * sum / scores.length;
            System.out.println("第" + (i+1) +"个班级的平均分是：" + avg);
        }
        System.out.println("85分以上学员人数为："+highCount);
    }
}
