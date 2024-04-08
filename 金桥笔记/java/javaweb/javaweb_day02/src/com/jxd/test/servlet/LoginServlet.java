package com.jxd.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户的请求数据request对象中存储着用户的数据
        //小括号对应的是前台input的name属性值

//        post请求在传输中文信息时，会出现乱码问题
//        解决乱码，需要设置编码字符集
        request.setCharacterEncoding("utf-8");
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();

//        将用户信息传递给service层，校验用户是否存在
//        创建service对象，调用登录方法，获取返回值
        if("张三".equals(uname) && "123".equals(pwd)){
            pw.println("登录成功，欢迎你，" + uname);
        }else {
            pw.println("用户名或者密码错误");
        }
        pw.flush();
        pw.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
