package com.jxd.bank.main;

import com.jxd.bank.dao.impl.AccounDaoImpl;
import com.jxd.bank.service.impl.AccountServiceImpl;
import com.jxd.bank.util.GetTime;
import com.jxd.bank.util.INPUT;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AccountServiceImpl accountService = new AccountServiceImpl();
        AccounDaoImpl accounDao = new AccounDaoImpl();

        System.out.println("******************************");
        System.out.println("\t银行管理系统");
        System.out.println("******************************");
        System.out.println("\t1、开户\n\t2、登录\n\t3、退出");
        System.out.println("*******************************");
        System.out.println("请选择服务种类：");
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3);
        int opt = INPUT.input(list);
        switch (opt){
            case 1:
                try {

                    System.out.println("请输入姓名");
                    String name = input.next();
                    String pwt = "";
                    while (true) {
                        System.out.println("请输入密码");
                        pwt = input.next();
                        System.out.println("请再次确认密码");
                        String pwt1 = input.next();
                        if (pwt.equals(pwt1)) {
                            break;
                        }
                    }
                    System.out.println("请缴纳预存金额");
                    double d = input.nextDouble();
                    int num = accountService.openaccount(name,pwt,d);
                    System.out.println("开户成功");
                    System.out.println("你的卡号为" + num);
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("出现错误");
                }
                break;
            case 2:
                System.out.println("*********用户登录界面**********");
                System.out.println("请输入卡号：" );
                try {
                    int num = input.nextInt();
                    System.out.println("请输入密码：");
                    String pwt = input.next();
                    if (accountService.register(num,pwt)){
                        System.out.println("登录成功！");
                        System.out.println("欢迎您" + accounDao.getname(num));
                        System.out.println("1.存钱\n2.取钱\n3.查询账号余额\n4.查询交易记录\n5.转账\n6.修改密码\n7.注销账号\n8.退出");
                        System.out.println("请选择要进行的业务：");
                        Collections.addAll(list,4,5,6,7,8);
                        int opt1 = INPUT.input(list);
                        switch (opt1){
                            case 1:
                                System.out.println("请输入要存的金额");
                                double d = input.nextDouble();
                                accountService.updatemoney(num,d);
                                break;
                            case 2:
                                double d1 = 0;
                                while (true) {
                                    System.out.println("请输入要取金额");
                                    d1 = input.nextDouble();
                                    if (d1 >= 100 && d1 % 100 == 0) {
                                        break;
                                    }else {
                                        System.out.println("金额不得小于100，且须为100的整数倍");
                                    }
                                }
                                accountService.updatemoney(num,0.0-d1);
                                break;
                            case 3:
                                accountService.inquire(num);
                                break;
                            case 4:
                                accountService.inquirerecord(num);
                                break;
                            case 5:
                                System.out.println("请输入要转到的账号");
                                int num1 = input.nextInt();
                                System.out.println("请输入要转的金额：");
                                double d2 = input.nextDouble();
                                accountService.transaccount(num,pwt,num1,d2);
                                break;
                            case 6:
                                while (true) {
                                    System.out.println("请输入旧密码");
                                    String oldpwt = input.next();
                                    if (oldpwt.equals(pwt)){
                                        break;
                                    }else {
                                        System.out.println("密码错误");
                                    }
                                }
                                String newpwt = "";
                                while (true) {
                                    System.out.println("请输入新密码");
                                    newpwt = input.next();
                                    System.out.println("请确认新密码");
                                    String newpwt1 = input.next();
                                    if (newpwt.equals(newpwt1)){
                                        break;
                                    }else {
                                        System.out.println("两次密码不一致，请重新输入");
                                    }
                                }
                                accountService.setpwt(num,pwt,newpwt);
                                pwt = newpwt;
                                break;
                            case 7:
                                accountService.cancelaccount(num,pwt);
                                break;
                            case 8:
                                System.exit(0);
                        }
                    }else {
                        System.out.println("登录失败");
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("出现错误");
                }finally {
                    System.out.println("感谢使用本程序");
                }
            case 3:
                System.exit(0);
        }
    }
}
