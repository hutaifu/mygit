package com.jxd.prc01.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Prc01Servlet")
public class Prc01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        request.setCharacterEncoding("utf-8");
        pw.println("姓名是" + request.getParameter("uname"));
        pw.println("密码是" + request.getParameter("pwd"));
        pw.println("姓别是" + request.getParameter("sex"));
        pw.println("手机号是" + request.getParameter("num"));
        pw.println("邮箱是" + request.getParameter("mail"));
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            String str = request.getParameter(i + "");
            if (str != null){
                list.add(str);
            }
        }

        pw.println("爱好是");
        for (String s: list) {
            pw.println(s);
        }


    }
}
