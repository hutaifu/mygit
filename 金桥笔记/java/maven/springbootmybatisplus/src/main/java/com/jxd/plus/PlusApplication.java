package com.jxd.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName PlusApplication
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/16
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.jxd.plus.dao")
public class PlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlusApplication.class,args);
    }
}
