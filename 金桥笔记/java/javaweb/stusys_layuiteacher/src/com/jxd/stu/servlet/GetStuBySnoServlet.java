package com.jxd.stu.servlet;

import com.jxd.stu.model.Student;
import com.jxd.stu.service.IStudentService;
import com.jxd.stu.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetStuBySnoServlet")
public class GetStuBySnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //和前台请求路径中？后的内容一致
        String sno = request.getParameter("sno");
        int snoNum = Integer.parseInt(sno);

        IStudentService studentService = new StudentServiceImpl();
        Student student = studentService.getOneBySno(snoNum);

        //转发到编辑页面
        request.setAttribute("student",student);
        request.getRequestDispatcher("editStu.jsp").forward(request,response);


    }
}
