package com.jxd.hello.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName testConfig
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/15
 * @Version 1.0
 */

public class testConfig {
    public static void main(String[] args) {
        //去加载DemoConfig类，相当于以前读xml文件的操作
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);
        //以上代码结束后Spring容器被创建，同时demo组件被创建。

        Demo demo = (Demo)applicationContext.getBean("demo");
        System.out.println(demo.getName());
    }
}
