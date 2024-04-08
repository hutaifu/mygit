package com.jxd.bank.model;

/**
 * @ClassName Account
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class Account {
    private int cardid;
    private String customername;
    private String password;
    private String oldpassword;
    private double balance;
    private String opendate;

    public int getCardid() {
        return cardid;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOpendate() {
        return opendate;
    }

    public void setOpendate(String opendate) {
        this.opendate = opendate;
    }

    public Account() {
    }

    public Account(int cardid, String customername, String password, String oldpassword, double balance, String opendate) {
        this.cardid = cardid;
        this.customername = customername;
        this.password = password;
        this.oldpassword = oldpassword;
        this.balance = balance;
        this.opendate = opendate;
    }
}
