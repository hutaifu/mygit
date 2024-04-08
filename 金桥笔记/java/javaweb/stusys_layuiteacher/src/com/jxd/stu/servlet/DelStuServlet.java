package com.jxd.stu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelStuServlet")
public class DelStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String snos = request.getParameter("snos");
        String[]  snoArr = snos.split(",");
        int[] snoNums = new int[snoArr.length];

        for (int i = 0; i < snoArr.length; i++) {
            snoNums[i] = Integer.parseInt(snoArr[i]);
        }

        //调用service
        //跳转到列表页面

    }
}
