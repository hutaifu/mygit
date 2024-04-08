package ch07;

import java.util.Scanner;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/14
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] scores = new int[5];
        int sum = 0;
        double avg = 0.0;
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请输入第"+(i+1)+"个学生的成绩：");
            scores[i] = input.nextInt();
            sum += scores[i];
        }
        avg = 1.0 * sum / scores.length;
        System.out.println("平均分是"+avg);
        for (int i = 0; i < 5; i++) {
            System.out.println(scores[i]);

        }
//        求最高分
        int max = scores[0];
        for (int i = 1; i <scores.length ; i++) {
            if (max > scores[i]){
            }else {
                max = scores[i];
            }

        }
        System.out.println("最高分是" + max);
     }
}
