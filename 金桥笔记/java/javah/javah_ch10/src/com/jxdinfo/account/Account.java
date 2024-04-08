package com.jxdinfo.account;

/**
 * @ClassName Account
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class Account {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public Account(int balance) {
        this.balance = balance;
    }
}
