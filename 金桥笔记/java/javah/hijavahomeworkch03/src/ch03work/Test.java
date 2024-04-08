package ch03work;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        Printer printer = new InkPrinter();
        Printer printer1 = new LightPrinter();
        Printer printer2 = new NeedlePrinter();
        Master master = new Master();
        master.print(printer);
        master.print(printer1);
        master.print(printer2);
    }
}
