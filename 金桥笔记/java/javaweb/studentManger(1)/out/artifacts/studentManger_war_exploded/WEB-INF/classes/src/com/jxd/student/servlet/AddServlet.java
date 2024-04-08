package com.jxd.student.servlet;

import com.jxd.student.model.Student;
import com.jxd.student.service.IStudentService;
import com.jxd.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();*/
        request.setCharacterEncoding("utf-8");
        IStudentService studentService = new StudentServiceImpl();
        Student student = new Student(
                request.getParameter("sname"),
                request.getParameter("ssex"),
                Integer.parseInt(request.getParameter("age")),
                request.getParameter("address")
        );
        String addmsg = "增加失败";
        if (studentService.add(student)){
            addmsg = "增加成功";
//            pw.println("增加成功");
        }
//        else {
//            pw.println("增加失败");
//        }
       /* pw.flush();;
        pw.close();*/
       request.setAttribute("addmsg",addmsg);
       request.getRequestDispatcher("layui.stuList.jsp").forward(request,response);
    }
}
