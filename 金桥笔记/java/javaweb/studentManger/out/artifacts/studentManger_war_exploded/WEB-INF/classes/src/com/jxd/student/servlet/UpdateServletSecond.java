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

@WebServlet("/UpdateServletSecond")
public class UpdateServletSecond extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        IStudentService studentService = new StudentServiceImpl();
        Student student = new Student(
                Integer.parseInt(request.getParameter("sno")),
                request.getParameter("sname"),
                request.getParameter("sex"),
                Integer.parseInt(request.getParameter("age")),
                request.getParameter("address")
        );
        String upmsg = "修改失败";
        if (studentService.upd(student)){
            upmsg = "修改成功";
//            pw.println("增加成功");
        }
//        else {
//            pw.println("增加失败");
//        }
       /* pw.flush();;
        pw.close();*/
        request.setAttribute("upmsg",upmsg);
        request.getRequestDispatcher("layui.stuList.jsp").forward(request,response);
    }
}
