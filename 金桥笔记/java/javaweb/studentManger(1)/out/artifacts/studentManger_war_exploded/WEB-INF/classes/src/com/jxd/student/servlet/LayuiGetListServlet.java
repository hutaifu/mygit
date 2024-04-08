package com.jxd.student.servlet;

import com.jxd.student.model.Student;
import com.jxd.student.service.IStudentService;
import com.jxd.student.service.impl.StudentServiceImpl;
import com.jxd.student.util.ToJson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/LayuiGetListServlet")
public class LayuiGetListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建sercice对象
        IStudentService studentService = new StudentServiceImpl();
        request.setCharacterEncoding("utf-8");
        String key = request.getParameter("key");
        List<Student> list = studentService.selectAll(key);
        JSONObject json = ToJson.getjson(list);
        // 将json对象直接返回到前台
         response.setContentType("text/html;charset=utf-8");
         PrintWriter out = response.getWriter();
         out.print(json);
         out.flush();
         out.close();
    }
}
