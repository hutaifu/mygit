package com.jxd.student.servlet;

import com.jxd.student.model.Student;
import com.jxd.student.service.IStudentService;
import com.jxd.student.service.impl.StuentServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetStuBysSnoServlet")
public class GetStuBysSnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //和前台请求路径中问号后的内容一致
        String sno = request.getParameter("sno");
        int snoNum = Integer.parseInt(sno);
        IStudentService studentService = new StuentServiceimpl();
        Student student = studentService.getOneBySno(snoNum);
        //转发到编辑页面
        request.setCharacterEncoding("utf-8");
        request.setAttribute("student",student);
        request.getRequestDispatcher("editStu.jsp").forward(request,response);
    }
}
