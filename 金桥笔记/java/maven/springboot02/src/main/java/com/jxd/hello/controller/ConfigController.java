package com.jxd.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ConfigController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/15
 * @Version 1.0
 */
@Controller
public class ConfigController {

//    获取yml的配置项
//    用于获取配置文件中单个的name配置项
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;
//    用于或者配置文件中带层级关系的配置项的值
    @Value("${student.name}")
    private String sname;
    @Value("${student.age}")
    private Integer sage;
//    用于获取配置文件中数组信息
    @Value("${stus[0].name}")
    private String sname01;
    @Value("${stus[0].age}")
    private Integer sage01;
    @RequestMapping(value = "/getConfig",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getConfig(){
        return name + age;
    }

    @RequestMapping("/getConfigs")
    @ResponseBody
    public String getStudent(){
        return sname + sage;
    }

    @RequestMapping("/getConfigss")
    @ResponseBody
    public String getStudent1(){
        return sname01 + sage01;
    }
}
