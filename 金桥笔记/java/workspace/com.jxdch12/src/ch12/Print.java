package ch12;

/**
 * @ClassName Print
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class Print {
    String brand;
    String type;
    String color;
//    打印功能实行时需要的外部数据
    public void print(String paper){
        System.out.println("使用" + paper + "打印文件");

    }
    public void show(){
        System.out.println(brand);
    }
}
