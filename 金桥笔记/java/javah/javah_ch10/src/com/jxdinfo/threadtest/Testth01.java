package com.jxdinfo.threadtest;

/**
 * @ClassName Testth01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class Testth01 {
            public static void main(String[] args) {


                //开启线程1
                TestThread thread01 = new TestThread();

                //设置Thread01优先级,优先级越高，获取cpu机会越多
                thread01.setPriority(thread01.MAX_PRIORITY);
                thread01.start();//回去执行run方法中的内容

                //保证线程1一旦获取cpu后，全部执行完，才让出cpu
              /*  try {
                    thread01.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                //开启线程2
                TestRunnable testRunnable = new TestRunnable();
                Thread thread02 = new Thread(testRunnable);
                thread02.start();


        for (int i = 0; i < 1000; i++) {
            System.out.println("这是主线程");
        }
    }
}
