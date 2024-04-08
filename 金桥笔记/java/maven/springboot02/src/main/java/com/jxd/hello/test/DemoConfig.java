package com.jxd.hello.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DemoConfig
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/15
 * @Version 1.0
 */

@Configuration
public class DemoConfig {
    //当前类可以看成是一个xnm文件

    /*@Bean注解的方法可以看成是一个bean标签
    * 在该方法创建对象，并返回到容器中
    *
    * */
    @Bean(name = "demo")
    public Demo getDemo(){
        System.out.println("开始创建demo对象");
        Demo demo = new Demo();
        demo.setName("张三");
        demo.setAge(18);
        //返回给spring容器
        return demo;
    }
}
