package com.jxd.student.servlet;

import com.jxd.student.model.Student;
import com.jxd.student.service.IStudentService;
import com.jxd.student.service.impl.StudentServiceImpl;
import com.jxd.student.util.ToJson;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/GetAllStuServlet")
public class GetAllStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建sercice对象
        IStudentService studentService = new StudentServiceImpl();
        List<Student> list = studentService.selectAll(null);
        //通过转发带入到列表页面
        request.setAttribute("stuList",list);
        request.getRequestDispatcher("stuList.jsp").forward(request,response);
    }
}
