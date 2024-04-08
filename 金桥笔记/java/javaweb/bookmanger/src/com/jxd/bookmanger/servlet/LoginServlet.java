package com.jxd.bookmanger.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        HttpSession session = request.getSession();
        if ("admin".equals(uname) && "123".equals(pwd)) {
            Cookie cookie = new Cookie("uname",uname);
            Cookie cookie1 = new Cookie("pwd",pwd);
            cookie.setMaxAge(60 * 60);
            cookie1.setMaxAge(60 * 60);
            response.addCookie(cookie);
            response.addCookie(cookie1);
            session.setAttribute("user", uname);
            response.sendRedirect("booklist.jsp");
        } else {
            request.setAttribute("msg", "登录失败");
            request.getRequestDispatcher("booklogin.jsp").forward(request, response);
        }
    }
}
