package com.jxd_DVD;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName DvdAdministration
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/22
 * @Version 1.0
 */

public class DvdAdministration {
    Dvd[] dvds = new Dvd[20];

    public void inital(){
        dvds[0].name = "罗马假日";
        dvds[0].islend = true;
        dvds[0].lenddate = "2010-7-1";
        dvds[1].name = "风声鹤唳";
        dvds[2].name = "浪漫满屋";
    }

    public void start(DvdAdministration dvdAdministration){
        dvdAdministration.inital();
        Scanner input = new Scanner(System.in);
        dvdAdministration.returnMain();
        int num = 0;
        do{
        System.out.println("请选择：");
        num = input.nextInt();
        dvdAdministration.startMenu(num,dvdAdministration);
            System.out.println("输入0返回：");
            int num1 = input.nextInt();
            if (num1 ==0){
                dvdAdministration.returnMain();
            }else {
                System.out.println("输入错误！");
                break;
            }
        }while (num != 6);
    }

    public void returnMain(){
            System.out.println("欢迎使用迷你DVD管理器");
            System.out.println("---------------------------------");
            System.out.println("0.借出排行榜");
            System.out.println("1.新增DVD");
            System.out.println("2.查看DVD");
            System.out.println("3.删除DVD");
            System.out.println("4.借出DVD");
            System.out.println("5.归还DVD");
            System.out.println("6.退出");
    }

    public void startMenu(int num,DvdAdministration dvdAdministration){
        Scanner input = new Scanner(System.in);
        switch (num){
            case 0:
                System.out.println("--->排行榜");
                System.out.println();
                dvdAdministration.sortdvd();
                break;
            case 1:
                System.out.println("--->新增DVD");
                System.out.println();
                System.out.println("请输入DVD名称：");
                String name = input.next();
                dvdAdministration.addDvd(name);
                break;
            case 2:
                System.out.println("--->查看DVD");
                System.out.println();
                dvdAdministration.showDvd();
                break;
            case 3:
                System.out.println("--->删除DVD");
                System.out.println();
                System.out.println("请输入DVD名称：");
                String name3 = input.next();
                dvdAdministration.delete(name3);
                break;
            case 4:
                System.out.println("--->借出DVD");
                System.out.println();
                System.out.println("请输入DVD名称：");
                String name4 = input.next();
                System.out.println("请输入借出日期：");
                String lenddate = input.next();
                dvdAdministration.lenddvd(name4,lenddate);
                break;
            case 5:
                System.out.println("--->归还DVD");
                System.out.println();
                System.out.println("请输入归还DVD名称：");
                String name5 = input.next();
                System.out.println("请输入归还日期（年-月-日）：");
                String date5 = input.next();
                System.out.println();
                dvdAdministration.returndvd(name5,date5);
                break;
            case 6:
                System.out.println();
                System.out.println("谢谢使用！");
        }
    }

    public void addDvd(String name){
        for (int i = 0; i < dvds.length; i++) {
            if (dvds[i].name == null){
                dvds[i].name = name;
                break;
            }
        }
        System.out.println("新增" + name + "成功!");
    }




    public void showDvd(){
        String str = "";
        System.out.println("序号\t状态\t\t名称\t\t\t借出日期");
        for (int i = 0; i < dvds.length && dvds[i].name != null; i++) {
            if (!dvds[i].islend){
                str = "可借";
            }else {
                str = "已借出";
            }
            if (dvds[i].lenddate == null){
                dvds[i].lenddate = "";
            }
            System.out.println(i+1+"\t\t"+str+"\t\t"+dvds[i].name+"\t\t"+dvds[i].lenddate);
        }
    }

    public void delete(String name){
        for (int i = 0; i < dvds.length && dvds[i] != null; i++) {
            if (name.equals(dvds[i].name) && !dvds[i].islend){
                for (int j = i; j < dvds.length-1 && dvds[j+1] != null; j++) {
                    dvds[j] = dvds[j+1];
                }
                System.out.println("已删除");
                break;
            }else if (name.equals(dvds[i].name) && dvds[i].islend){
                System.out.println( name + "为借出状态，不能删除！");
                break;
            }else if (i == dvds.length-1){
                System.out.println("不存在指定DVD");
            }
        }
    }

    public void lenddvd(String name,String lengdate){
        for (int i = 0; i < dvds.length && dvds[i] != null; i++) {
            if(name.equals(dvds[i].name)){
                if (!dvds[i].islend){
                    dvds[i].lenddate = lengdate;
                    System.out.println("借出" + name + "成功");
                    dvds[i].count++;
                }else {
                    System.out.println("已被借出");
                }
                break;
            }else if (i == dvds.length-1){
                System.out.println("没有找到该DVD");
            }
        }
    }

    public void returndvd(String name,String returndate){
        for (int i = 0; i < dvds.length && dvds[i] != null; i++) {
            if (name.equals(dvds[i].name)){
                if (dvds[i].islend){
                    dvds[i].islend = false;
                    Date d1 = new Date();
                    Date d2 = new Date();
                    SimpleDateFormat sd = new SimpleDateFormat(("yyyy-MM-dd"));
                    try {
                        d1 = sd.parse(dvds[i].lenddate);
                        d2 = sd.parse(returndate);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    long charg = (d2.getTime()-d1.getTime())/(24*60*60*1000);
                    System.out.println();
                    System.out.println("归还"+ name +"成功！");
                    System.out.println("借出日期为：" + dvds[i].lenddate);
                    System.out.println("归还日期为："+ returndate);
                    System.out.println("应付租金（元）：" + charg);
                }else {
                    System.out.println("该书未被借出");
                }
                break;
            }else if (i == dvds.length-1){
                System.out.println("不存在该书！");
            }
        }
    }

    public void sortdvd(){
        Dvd[] dvds1 = new Dvd[dvds.length];
        dvds1 = dvds;
        for (int i = 0; i < dvds1.length-1 && dvds1[i] != null; i++) {
            for (int j = i; j < dvds1.length-1 && dvds1[j+1] != null; j++) {
                if (dvds1[j].count < dvds1[j+1].count){
                    Dvd dvd1 ;
                    dvd1 = dvds1[j+1];
                    dvds1[j+1] = dvds1[j];
                    dvds1[j] = dvd1;
                }
            }
        }
        for (int i = 0; i < dvds1.length && dvds1[i].name != null; i++) {
            System.out.println("次数\t\t\t\t名称");
            System.out.println(dvds1[i].count+"\t\t\t\t"+dvds1[i].name);
        }
        
        
        
    }
}
