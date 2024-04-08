package com.jxd.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName SprignMvcController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/14
 * @Version 1.0
 */
@Controller
@RequestMapping("/stu")
public class SprignMvcController {


    @RequestMapping("/hello")
    public String toWord(){
        System.out.println("hello");
        //跳转到另外一个请求方法中
        //重定向到world
        return "redirect:world";

        //转发到world
        //return "forward:world"
    }

    @RequestMapping("/world")
    @ResponseBody
    public String world(){
        return "hello world";
    }
}
