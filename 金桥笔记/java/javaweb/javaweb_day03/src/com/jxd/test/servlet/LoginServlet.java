package com.jxd.test.servlet;

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
        //接收用户数据实现登录验证
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        if ("admin".equals(name) && "123".equals(pwd)){
//            将用户名信息存储到session对象中
//            session对象浏览器第一次访问服务器时由web容器创建的对象
            //在整个访问期间，这个对象始终存在
            HttpSession session = request.getSession();
            session.setAttribute("uname",name);




            //登录成功，让浏览器显示欢迎页面
            //重定向：服务器告诉浏览器去请求的资源名称，浏览器会在响应信息中得到新资源的名称
            //然后发起对这个资源的请求
            //浏览器会认为这是相对路径，会从当前项目下查找这个资源
            response.sendRedirect("welcome.jsp");
            //让浏览器访问项目之外的其他资源
//            response.sendRedirect("http://www.baidu.com");

        } else {
           //登录失败
//            response.sendRedirect("login_admin.jsp");
            //转发的方式：服务器控制浏览器的显示内容，并没有让浏览器发送新的请求
//            可以在跳转页面的同时将数据一块待人到下一个页面
//            request本身封装了用户的请求数据
//            我们可以将它看成是一个数据容器，也往里面封装我们自定义的数据
            request.setAttribute("msg","用户名或者密码错误");
            request.getRequestDispatcher("login_admin.jsp").forward(request,response);

//            转发不能访问外部资源，只能访问服务器上有的资源
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
