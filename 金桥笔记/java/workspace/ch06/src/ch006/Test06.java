package ch006;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Test06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int stuCount = 0;
        int highCount = 0;
        System.out.print("请输入学生数量：");
        stuCount = input.nextInt();
        for (int i = 0; i < stuCount; i++) {
            System.out.println("请输入第"+(i+1)+"个学生的成绩");
            int score = input.nextInt();
            if (score < 80){
                continue;
            }
            highCount++;

        }
        System.out.println("80分以上的 比例是" + highCount / 1.0 * stuCount * 100.0 + "%");
    }
}
