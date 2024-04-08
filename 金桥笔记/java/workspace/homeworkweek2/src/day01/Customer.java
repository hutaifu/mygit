package day01;

/**
 * @ClassName Customer
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/18
 * @Version 1.0
 */

public class Customer {
    int rescores = 0;
    double score;
    String vary;
    public void show(){
        System.out.print("积分是："+score+",");
        System.out.println("卡类型："+vary);
    }
    public void rascore(){
        if (("金卡".equals(vary) && score > 1000) || ("普卡".equals(vary) && score > 5000)){
            System.out.println("回馈积分是500分！");
            rescores = 500;


        }
    }



}
