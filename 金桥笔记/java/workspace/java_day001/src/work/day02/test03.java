package work.day02;

public class test03 {
    public static void main(String[] args) {
        System.out.println("* * * * * * *消费单* * * * * *");
        System.out.println("购买物品\t单价\t个数\t金额\t ");
        System.out.println("T恤\t\t\t￥245\t2\t\t$490");
        System.out.println("网球拍\t\t$单价\t1\t\t￥320");
        System.out.println();
        System.out.println("折扣\t\t8折");
        System.out.println("消费总金额\t\t\t$1104.0");
        System.out.println("实际交费\t￥1500");
        System.out.println("找钱\t\t$396.0");
        double all = 1104.0;
        int score = (int)(all * 0.03);
        System.out.println("本次购物所获得的积分是："+score);
    }
}
