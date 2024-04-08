package com.jxd.hello.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;

/**
 * @ClassName Config02Controller
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/15
 * @Version 1.0
 */
@Controller
@ConfigurationProperties(prefix = "student")//要获取student这个配置项下的所有子配置项
public class Config02Controller {
//    声明成员变量，变量名称必须和配置文件中的对象属性名完全对应
    private String name;
    private Integer age;

//    必须为这些属性声明set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
