package com.jxd.test02.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TestServlet01 extends HttpServlet {
    @Override
    public void init(){
        System.out.println("servlet初始化");
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet开始处理请求");
//        获取ServletConfig对象中配置信息
        ServletConfig servletConfig = this.getServletConfig();
        String msg = servletConfig.getInitParameter("msg");
        System.out.println(msg);
//        获取全局信息
        ServletContext servletContext = this.getServletContext();
        String msgContext = servletContext.getInitParameter("msg");
        System.out.println(msgContext);

    }

    @Override
    public void destroy() {
        System.out.println("servlet实例正在被销毁");
    }
}
