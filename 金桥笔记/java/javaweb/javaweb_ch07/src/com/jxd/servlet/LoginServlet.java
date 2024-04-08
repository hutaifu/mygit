package com.jxd.servlet;

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
        //如果登录成功，就将用户信息存储在session中
        //设置编码格式
//        request.setCharacterEncoding("utf-8");
        //获取表单中提交的值
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        //判断用户名和密码是否正确  admin,123456
        if ("admin".equals(user) && "123456".equals(pwd)){
            //将用户对象存储在session中
            HttpSession session = request.getSession();//获取session对象
            session.setMaxInactiveInterval(60 * 60);//设置session的有效非活动时间，单位为秒（s）
            session.setAttribute("user",user);//根request对象的setAttribute（）类型
            session.setAttribute("pwd",pwd);
            response.sendRedirect("welcom.jsp");

        }else {
            //错误时，携带错误信息回到登录页面
        }











    }

   /* protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        //获取表单中提交的值
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        //判断用户名和密码是否正确  admin,123456
        if ("admin".equals(user) && "123456".equals(pwd)){
            //保存用户名和密码 --服务器让浏览器保存
            Cookie cookie = new Cookie("user",user);
            cookie.setMaxAge(60 * 60 * 24 * 7);//设置生效时间
            Cookie cookie1 = new Cookie("pwd",pwd);
            cookie1.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);//服务器向浏览器下命令
            response.addCookie(cookie1);
            //登录成功，跳转到welcome.jsp
            response.sendRedirect("welcom.jsp");

        }else {
            //携带错误提升，回到登录界面转发，request
        }
    }*/
}
