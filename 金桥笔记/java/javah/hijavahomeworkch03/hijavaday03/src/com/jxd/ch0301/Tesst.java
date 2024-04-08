package com.jxd.ch0301;

/**
 * @ClassName Tesst
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Tesst {
    public static void main(String[] args) {
        Printer printer = new BlackPrinter();
        printer.print();

        Printer printer1 = new ColorPrinter();
        printer1.print();



    }
}
