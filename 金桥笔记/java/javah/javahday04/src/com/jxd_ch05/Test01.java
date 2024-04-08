package com.jxd_ch05;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/4
 * @Version 1.0
 */

public class Test01 {
    //创建日志工具对象
    private static Logger log = Logger.getLogger(Test01.class);
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("请输入被除数：");
            int num01 = input.nextInt();
            //记录用户操作
            log.info("用户输入了被除数：" + num01);
            System.out.println("请输入除数：");
            int num02 = input.nextInt();
            log.info("用户输入了除数：" + num02);

            System.out.println("结果是" + num01 / num02);
            log.info("用户执行了除法操作，结果是：" + num01 / num02);


        } catch (InputMismatchException e){
            System.out.println("请输入整数");
//            System.exit(1);
            e.printStackTrace();
            log.error("用户输入的内容不是整数");
            //记录堆栈信息
            log.error(e.getMessage());
        } catch (ArithmeticException e){
            System.out.println("零不能为除数");
            e.printStackTrace();
            log.error("用户输入了0作为除数");
        } catch (Exception e) {
            //捕获try块中出现的异常对象
            System.out.println("用户输入有误");
            //记录异常信息
            e.printStackTrace();
            log.error("错误");

        } finally {
            System.out.println("感谢使用本程序");
        }

    }
}
