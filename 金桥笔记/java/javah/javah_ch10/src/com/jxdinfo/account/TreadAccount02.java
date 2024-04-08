package com.jxdinfo.account;

/**
 * @ClassName TreadAccount02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class TreadAccount02 extends Thread {
    private Account account;//操作的银行账户
    private int money;//取款金额；
    public void run() {
        //获取对象的锁
        synchronized (account) {
            //准备获取对象
            account.notify();//判断其他线程是不是通过wait方法释放了对象的锁

            //取款操作
            if (account.getBalance() > money) {
                System.out.println(getName() + "可以取款并成功取款");
                try {
                    Thread.sleep(1000);
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


    public TreadAccount02(String name, Account account, int money) {
        super(name);  //线程的名字
        this.account = account;
        this.money = money;
    }
}
