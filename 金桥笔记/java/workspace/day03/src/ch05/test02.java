package ch05;

import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //存储老师的检查结果
        String answer = "";
        System.out.println("张三进行测试");
        System.out.println("合格了吗？（y/n）");
        answer = input.next();

        while ("n".equals(answer)){
            System.out.println("上线学习理论，下午上机编程");
            System.out.println("测试，检查，合格了吗？");
//            保证条件有成立的时候
            answer = input.next();
        }
        System.out.println("完成学习任务");
    }
}
