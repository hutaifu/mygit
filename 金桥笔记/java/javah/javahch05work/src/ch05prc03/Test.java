package ch05prc03;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/4
 * @Version 1.0
 */

public class Test {
    private static Logger log = Logger.getLogger(Test.class);
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("请输入被除数：");
            int num01 = input.nextInt();
            log.info("用户输入了被除数：" + num01);
            System.out.println("请输入除数：");
            int num02 = input.nextInt();
            log.info("用户输入了除数：" + num02);
            System.out.println("结果是" + num01 / num02);
            log.info("用户执行了除法操作，结果是：" + num01 / num02);
        } catch (InputMismatchException e){
            System.out.println("请输入整数");
            e.printStackTrace();
            log.error("用户输入的内容不是整数");
            log.error(e.getMessage());
        } catch (ArithmeticException e){
            System.out.println("零不能为除数");
            e.printStackTrace();
            log.warn("用户输入了0作为除数");
            log.warn(e.getMessage());
        } catch (Exception e) {
            //捕获try块中出现的异常对象
            System.out.println("用户输入有误");
            //记录异常信息
            e.printStackTrace();
            log.error("错误");
            log.error(e.getMessage());
        } finally {
            System.out.println("感谢使用本程序");
        }

    }
}
