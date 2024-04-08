package com.jxd_homework;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/22
 * @Version 1.0
 */

public class Employee {

    /*姓名
     * 工资
     *加班补贴
     * */

    String name;
    double salary;
    double subsidy;

   //计算税后工资并输出

    public void getter(){
        double fee1 = salary + subsidy;
        double tax =0 ;
        if (fee1 < 2000){
            tax = 0;
        }else if (fee1 < 2500){
            tax = (fee1 - 2000) * 0.05;
        }else if (fee1 < 4000){
            tax = (fee1 - 2000) * 0.1;
        }else if (fee1 < 7000){
            tax = (fee1-2000) * 0.15;
        }else if (fee1 < 22000){
            tax = (fee1 - 2000) * 0.2;
        }else if (fee1 >= 22000){
            tax = (fee1 - 2000) * 0.3;
        }
        System.out.println("税前收入为" + fee1 + "，税后收入为" + (fee1 - tax) + "你缴纳的个人收的税为" + tax);
    }
}
