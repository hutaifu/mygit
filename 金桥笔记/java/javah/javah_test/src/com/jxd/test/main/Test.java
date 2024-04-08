package com.jxd.test.main;

import com.jxd.test.service.IMessageBiz;
import com.jxd.test.service.impl.MessageBizImpl;
import com.jxd.test.util.INPUT;
import jdk.internal.util.xml.impl.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/15
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IMessageBiz messageBiz = new MessageBizImpl();
        Scanner input = new Scanner(System.in);


        System.out.println("------欢迎登录留言板系统-------");
        System.out.println("----------主菜单---------------");
        System.out.println("\t1.显示留言\n\t2.添加留言\n\t3.退出系统");
        System.out.println("请选择");
        Collections.addAll(list,1,2,3);
        int opt = INPUT.input(list);
        switch (opt){
            case 1:
                messageBiz.shwomessage();
                break;
            case 2:
                System.out.println("请输入留言人姓名：");
                String name = input.next();
                System.out.println("请输入留言标题：");
                String title = input.next();
                System.out.println("请输入留言内容");
                String contents = input.next();
                messageBiz.addmessage(name,title,contents);
                break;
            case 3:
                System.out.println("谢谢使用再见！");
                System.exit(0);
        }
    }
}
