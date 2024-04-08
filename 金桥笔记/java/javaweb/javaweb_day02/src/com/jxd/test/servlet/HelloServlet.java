package com.jxd.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过浏览器直接访问该servlet是，会调用doGet方法
        //告诉浏览器，输出的内容为文本或者htmll标签
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        String name = "admin";
        pw.println("<h3>hello javaweb" + name + "</h3>");
        pw.flush();
        pw.close();


    }
}
