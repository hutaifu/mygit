package work.day02;

public class test04 {
    public static void main(String[] args) {
        double basePay = 3000;
        System.out.println("请输入基本工资：");
        System.out.println(3000);
        System.out.println("该员工的工资细目为：");
        System.out.println("基本工资为：3000");
        System.out.println("物价津贴为：1200.0");
        System.out.println("房租津贴为：750.0");
        double pay = basePay + 1200.0+750.0;
        System.out.println("员工薪水是："+pay);
    }
}
