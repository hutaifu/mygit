package com.jxd.emp.controller;

import com.jxd.emp.model.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/9
 * @Version 1.0
 */
/*
* @Controller
* springmvc提供的注解，可以创建Controller对象
*
*
* */
@Controller
@SessionAttributes({"username","password","emp"})
public class TestController {

    /*
    * 接收请求，其参数是请求的url
    *@RequestMapping，默认参数是value = url
    *属性produces 用于设置响应流相关
    *
    * */
    @RequestMapping(value = "/hello",produces = "text/html;charset=utf-8")
    public String hello(){
        //当不做任何处理时，方法返回字符串，实际上是请求字符串的资源。
        return "login";
    }


    /*
    * 如果希望以流的方式响应给前台就要添加@ResponsBody
    *
    * */
    @RequestMapping(value = "/sayHello",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String sayHello(String name){
        return "Hello "+name + "springmvc";

    }


    /*
    * 前台以ajax的方式传输了一个json对象，后台接参时，形参要与json中个对象名对应
    *
    *
    * */
    @RequestMapping(value = "/login",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login(String username, String password, Model model){
        if ("admin".equals(username) && "123".equals(password)){
            model.addAttribute("username",username);
            model.addAttribute("password",password);
            return "登录成功";
        }else {
            return "登录失败";
        }


    }
    /*
    * 前台发送的json对象的属性，应当与后台形参名一致，如果不一致， 匹配不上的参数只能拿到null了，
    *(@RequestParam可以接收前台指定属性的值赋给形参
    * */
    @RequestMapping(value = "/login2",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login2(@RequestParam("username") String uname, @RequestParam("password") String pwd){
        if ("admin".equals(uname) && "123".equals(pwd)){
            return "登录成功";
        }else {
            return "登录失败";
        }
    }
    @RequestMapping(value = "/login3",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login3(Emp emp,Model model){
        model.addAttribute("emp",emp);
        return "报存成功";

    }
    /*
    * 当前台以表单的类型提交时，后台可以以简单类型接收，
    * 1.简单类型接收
    * 2.名字不匹配，用@RequestParam注解接收
    * 3.以实体类接收
    *
    *
    * */
    @RequestMapping(value = "/login4",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login4(String username,String password){
      return "报存成功";

    }
    @RequestMapping(value = "/addBatch",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addBatch(@RequestBody List<Emp> emps){
        for (Emp emp:emps){
            System.out.println(emp);
        }
        return "新增成功";
    }
//   /login5/admin/123
    @RequestMapping(value = "/login5/{uname)/{pwd}",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login5(@PathVariable("uname") String username,@PathVariable("pwd") String passwrod){
        if ("admin".equals(username) && "123".equals(passwrod)){
            return "登录成功";
        }else {
            return "登录失败";
        }
     }
     @RequestMapping("/gologin")
    public String goLogin(){
        return "login";
     }
}
