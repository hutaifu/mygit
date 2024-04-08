package com.jxd.bank.dao;

import com.jxd.bank.model.Account;

public interface IAccountDao {
    /**
     * 添加账户信息
     * @param account 添加的账户
     * @return 是否添加成功
     */
    boolean insert (Account account);

    /**
     * 修改账户余额
     * @param d  要修改的金额
     * @param num 修改的账户
     * @return  是否修改成功
     */
    boolean update(int num,double d);

    /**
     * 转帐
     * @param give  给出的账号
     * @param password 转出账号密码
     * @param get  转到的账号
     * @param money   要转的金额
     * @return  是否成功
     */
    boolean tran(int give,String password,int get,double money);

    /**
     * 查询账余额
     * @param num 需要查询的账号
     */
    double show(int num);


    /**
     * 查询交易信息
     * @param num 查询的账号
     */
    void showdealdate(int num);

    /**
     * 修改账号的密码
     * @param num  账号
     * @param pwt  新密码
     * @return 是否成功
     */
    boolean changepwt(int num,String pwt);

    /**
     * 删除账户
     * @param num 删除的账户账号
     * @param pwt 密码
     * @return  是否删除成功
     */
    boolean delete(int num,String pwt);

    /**
     * 查看密码
     * @param num 查看密码的账号
     * @return 返回密码
     */
    String chekpwt(int num);

    /**
     * 插入旧密码信息
     * @param oldpwt 旧密码
     * @param num 账号
     */
    void addoldpwt(String oldpwt,int num);

    /**
     * 得到最大的账号
     * @return 返回最大账号
     */
    int getmaxaccount();

    /**
     * 得到账号姓名
     * @param num 账号
     * @return 返回姓名
     */
    String getname(int num);
}
