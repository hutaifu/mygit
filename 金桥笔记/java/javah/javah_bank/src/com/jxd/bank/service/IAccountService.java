package com.jxd.bank.service;

import com.sun.deploy.config.WinPlatform;

import java.util.stream.Stream;

public interface IAccountService {
    /**
     * 开户服务
     * @param name 开户姓名
     * @param paasword 开户密码
     * @param money 开户金额
     * @return 返回开户账号
     */
    int openaccount(String name,String paasword,double money);

    /**
     * 登录服务
     * @param num 卡号
     * @param pwt 密码
     */
    boolean register(int num,String pwt);

    /**
     * 存取款服务
     * @param num 账号
     * @param money 修改金额
     */
    void updatemoney(int num,double money);

    /**
     * 查询当前账号余额
     * @param num  当前账号
     */
    void inquire(int num);

    /**
     * 转账服务
     * @param num1 转出账号
     * @param pwt 转出账号密码
     * @param num2 转入账号
     * @param money 转入金额
     */
    void transaccount(int num1,String pwt,int num2,double money);

    /**
     * 查询当前账号交易信息
     * @param num 当前账号
     */
    void inquirerecord(int num);

    /**
     * 修改密码服务
     * @param num 修改账号
     * @param pwt 修改账号密码
     * @param newpwt 新密码
     */
    void setpwt(int num,String pwt,String newpwt);

    /**
     * 注销账户服务
     * @param num 注销账号
     * @param pwt 密码
     */
    void cancelaccount(int num,String pwt);
}
