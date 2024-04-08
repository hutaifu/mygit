package com.jxd.student.servlet;

import com.jxd.student.service.IStudentService;
import com.jxd.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelServlet")
public class DelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IStudentService studentService = new StudentServiceImpl();
        String snos = request.getParameter("sno");
        String[] strs = snos.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        String delmsg = "删除失败";
        if (studentService.del(nums)){
            delmsg = "删除成功";
        }
        request.setAttribute("delmsg",delmsg);
        request.getRequestDispatcher("layui.stuList.jsp").forward(request,response);
    }
}
