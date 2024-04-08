package com.jxd.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/14
 * @Version 1.0
 */
@Controller
public class HelloController {


    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello SpringBoot!!!";
    }

    @RequestMapping("/hello01")
    @ResponseBody
    public String hello01(){
        return "hello SpringBoot01!!!";
    }
}
