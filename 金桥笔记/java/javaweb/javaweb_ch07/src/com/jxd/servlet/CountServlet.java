package com.jxd.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将访问量在原有的基础上增加一
        //获取application对象
        ServletContext application = getServletContext();
        int num = 0;
        if (application.getAttribute("count") != null){
            //获取原有的num值，如果count为null，则说明之前没有访问过服务器，num初始值为0
            num = (Integer)application.getAttribute("count");
        }
        //num在原有的基础上自增
        num++;
        //更新count的值
        application.setAttribute("count",num);
        response.sendRedirect("count.jsp");
    }
}
