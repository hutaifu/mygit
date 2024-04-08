package com.jxd.student.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelStuServlet")
public class DelStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String snos = request.getParameter("snos");
        String[] sonArr = snos.split(",");
        int[] snoNums = new int[sonArr.length];

        for (int i = 0; i < sonArr.length; i++) {
            snoNums[i] = Integer.parseInt(sonArr[i]);
        }
        //调用service方法，
        //跳转到列表页面

    }
}
