package com.jxd.student.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditStuServlet")
public class EditStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sno = request.getParameter("sno");
        String sname = request.getParameter("sname");
        String ssex = request.getParameter("ssex");
        String address = request.getParameter("address");
        String birthday = request.getParameter("birthday");
        //封装为学生对象后，传递到service中

        //成功后跳转到列表页面
//        request.getRequestDispatcher("StuList.jsp").forward(request,response);
        response.getWriter().println("sucesss");
        response.getWriter().flush();
        response.getWriter().close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
