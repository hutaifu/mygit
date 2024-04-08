package com.jxdinfo.account;

/**
 * @ClassName ThreadAccount
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class ThreadAccount extends Thread {
    private Account account;//操作的银行账户
    private int money;//取款金额；
    public void run() {
        //获取对象的锁
        synchronized (account) {
            //取款操作
            if (account.getBalance() > money) {
                System.out.println(getName() + "可以取款并成功取款");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                try {
                    //让当前线程释放掉account锁
                    account.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance() - money);
                System.out.println("余额为：" + account.getBalance());
            } else {
                System.out.println("余额不足");
            }
            //取款操作
        }
    }


    public ThreadAccount(String name,Account account, int money) {
        super(name);  //线程的名字
        this.account = account;
        this.money = money;
    }
}
