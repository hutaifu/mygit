package ch12;

/**
 * @ClassName TestPrint
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestPrint {
    public static void main(String[] args) {
        Print print = new Print();
        print.brand = "惠普";
        print.type = "t-10";
        print.color = "black";
        print.print("A4纸");
    }
}
