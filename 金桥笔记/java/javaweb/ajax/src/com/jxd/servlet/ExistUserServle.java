package com.jxd.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ExistUserServlet")
public class ExistUserServle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取前台传递过来的user
        //data：{"user":user}
        String user = request.getParameter("user");
        PrintWriter pw = response.getWriter();
        //判断用户名是否可用
        if ("张三".equals(user)){
            //向前台发送消息“该用户名不可以”
            pw.write("该用户名不可用");
        } else {
            pw.write("用户名可用");
        }
        pw.flush();
        pw.close();
    }
}
