package com.jxdinfo.account;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        //余额为1000的银行账户
        Account account = new Account(1000);

        ThreadAccount thread01 = new ThreadAccount("张三",account,700);
        TreadAccount02 tread02 = new TreadAccount02("李四",account,700);

        thread01.start();
        tread02.start();
    }
}
