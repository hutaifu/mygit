package com.jxdinfo.threadtest;

/**
 * @ClassName TestThread
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class TestThread extends Thread{
    public void run(){
        //这是另外一条线程的顺序控制流
        for (int i = 0; i < 100; i++) {
            System.out.println("这是线程1的内容");
            //执行一次后，让出cpu
            Thread.yield();
        }
    }
}
