package com.jxd.bank.service.impl;

import com.jxd.bank.dao.IAccountDao;
import com.jxd.bank.dao.IDaterecordDao;
import com.jxd.bank.dao.impl.AccounDaoImpl;
import com.jxd.bank.dao.impl.DaterecordDaoImpl;
import com.jxd.bank.model.Account;
import com.jxd.bank.service.IAccountService;
import com.jxd.bank.util.GetTime;

/**
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccounDaoImpl();
    private IDaterecordDao daterecordDao = new DaterecordDaoImpl();

    /**
     * 开户服务
     *
     * @param name     开户姓名
     * @param paasword 开户密码
     * @param money    开户金额
     * @return 返回开户账号
     */
    @Override
    public int openaccount(String name, String paasword, double money) {
        String currenttime = GetTime.currentime();
        Account account = new Account();
        account.setCustomername(name);
        account.setOpendate(currenttime);
        account.setBalance(money);
        account.setPassword(paasword);
        accountDao.insert(account);
        int num = accountDao.getmaxaccount();
        daterecordDao.insert(num,"开户",money,currenttime);
        return num;
    }

    /**
     * 登录服务
     *
     * @param num 卡号
     * @param pwt 密码
     */
    @Override
    public boolean register(int num, String pwt) {
        boolean isSuccess = false;
        if (accountDao.chekpwt(num).equals(pwt)){
            isSuccess = true;
        }
        return isSuccess;
    }

    /**
     * 存取款服务
     *
     * @param num   账号
     * @param money 修改金额
     */
    @Override
    public void updatemoney(int num, double money) {
        if (accountDao.update(num,money)){
            String curtime = GetTime.currentime();
            if (money>0){
                daterecordDao.insert(num,"存款",money,curtime);
                System.out.println("存款成功");
            }else {
                daterecordDao.insert(num,"取款",0.0-num,curtime);
                System.out.println("取款成功");
            }
        }else {
            System.out.println("操作失败");
        }
    }

    /**
     * 查询当前账号余额
     *
     * @param num 当前账号
     */
    @Override
    public void inquire(int num) {
        accountDao.show(num);
    }

    /**
     * 转账服务
     *
     * @param num1  转出账号
     * @param pwt   转出账号密码
     * @param num2  转入账号
     * @param money 转入金额
     */
    @Override
    public void transaccount(int num1, String pwt, int num2, double money) {
        if (accountDao.tran(num1,pwt,num2,money)){
            String currtime = GetTime.currentime();
            System.out.println("转账成功");
            daterecordDao.insert(num1,"向账户" + num2 + "转账",money,currtime);
        }else {
            System.out.println("转账失败");
        }

    }

    /**
     * 查询当前账号交易信息
     *
     * @param num 当前账号
     */
    @Override
    public void inquirerecord(int num) {
        accountDao.showdealdate(num);
    }

    /**
     * 修改密码服务
     *
     * @param num    修改账号
     * @param pwt    修改账号密码
     * @param newpwt 新密码
     */
    @Override
    public void setpwt(int num, String pwt, String newpwt) {
        if (accountDao.chekpwt(num).equals(pwt)){
            if (accountDao.changepwt(num,newpwt)){
                System.out.println("修改成功");
                accountDao.addoldpwt(pwt,num);
                daterecordDao.insert(num,"修改密码",0.0,GetTime.currentime());
            }else {
                System.out.println("修改失败");
            }
        }
    }

    /**
     * 注销账户服务
     *
     * @param num 注销账号
     */
    @Override
    public void cancelaccount(int num,String pwt) {
        double d = accountDao.show(num);
        if (accountDao.delete(num,pwt)){
            System.out.println("退返金额：" + d);
            System.out.println("注销成功");
            daterecordDao.delete(num);
            System.exit(0);
        }else {
            System.out.println("注销失败");
        }
    }
}
