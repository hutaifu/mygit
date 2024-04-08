package ch03work;

import ch03prc02.Penguin;

/**
 * @ClassName LightPrinter
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class LightPrinter extends Printer {

    @Override
    public void print() {
        System.out.println("打印速度快，噪音小");
    }
}
