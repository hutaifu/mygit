package day02;

/**
 * @ClassName Accout
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class Accout {
    double fee;
    public void add(double num){
        fee += num;
        System.out.println("存款成功");
        System.out.println("当前余额为" + fee);
    }
    public void get(double num){
        if (fee >= num) {
            fee -= num;
            System.out.println("取款成功");
        }else {
            System.out.println("错误");
        }
        System.out.println("当前余额为" + fee);
    }
    public void exit(){
        System.out.println("谢谢使用！");
    }

}
