package com.jxd.student.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        if ("admin".equals(uname) && "123".equals(pwd)){
            HttpSession session = request.getSession();
            session.setAttribute("uname",uname);
            //重定向到学生列表页面
            response.sendRedirect("layui.stuList.jsp");
        } else {
//            转发会登录页面
            request.setAttribute("msg","用户名或者密码错误");
            request.getRequestDispatcher("layui.login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
