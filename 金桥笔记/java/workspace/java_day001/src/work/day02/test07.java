package work.day02;

public class test07 {
    public static void main(String[] args) {
        double cap = 1000;
        System.out.println("一年的本息为："+cap * (1+0.02));
        System.out.println("三年的本息为："+cap * (1+0.03)*(1+0.03)*(1+0.03));
        System.out.println("五年的本息为："+cap * (1+0.04)*(1+0.04)*(1+0.04)*(1+0.04)*(1+0.04));
    }
}
