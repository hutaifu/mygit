package com.jxd.vehmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Application
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/28
 * @Version 1.0
 */

@SpringBootApplication
@MapperScan("com.jxd.vehmanage.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
