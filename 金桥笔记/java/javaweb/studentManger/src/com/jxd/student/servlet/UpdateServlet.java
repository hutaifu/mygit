package com.jxd.student.servlet;

import com.jxd.student.dao.IStudentDao;
import com.jxd.student.dao.impl.StudentDaoImpl;
import com.jxd.student.model.Student;
import com.jxd.student.service.IStudentService;
import com.jxd.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IStudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.getOne(Integer.parseInt(request.getParameter("sno")));

        request.setAttribute("student",student);
        request.getRequestDispatcher("layui.up.jsp").forward(request,response);

    }
}
