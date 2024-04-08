package com.jxd.emp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName EmpApplication
 * @Description TODO
 * @Author lixiaoru
 * @Date 2020/11/18
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.jxd.emp.dao")
public class EmpApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmpApplication.class);
    }
}
