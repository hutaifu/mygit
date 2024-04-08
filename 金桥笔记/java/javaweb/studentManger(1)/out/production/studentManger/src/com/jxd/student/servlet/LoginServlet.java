package com.jxd.student.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
            Cookie cookie = new Cookie("user",uname);
            cookie.setMaxAge(60 * 60 * 24 * 7);//设置生效时间
            Cookie cookie1 = new Cookie("pwd",pwd);
            cookie1.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);//服务器向浏览器下命令
            response.addCookie(cookie1);
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
