package com.jxd.hello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName HelloApplication
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/14
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.jxd.hello.dao")//让springboot扫描dao接口，然后创建dao层对象，放到容器中
public class HelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class,args);

    }
}
