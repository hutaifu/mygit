package com.jxd_ch04;

/**
 * @ClassName Child
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Child implements IFather,IMather {
    @Override
    public void buycar() {
        System.out.println("给爸爸卖车");
    }

    @Override
    public void show() {

    }

    @Override
    public void buyBag() {
        System.out.println("给妈妈买包");
    }
}
