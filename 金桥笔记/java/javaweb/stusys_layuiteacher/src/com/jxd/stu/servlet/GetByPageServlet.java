package com.jxd.stu.servlet;

import com.jxd.stu.model.Student;
import com.jxd.stu.service.IStudentService;
import com.jxd.stu.service.impl.StudentServiceImpl;
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
import java.util.Map;

@WebServlet("/GetByPageServlet")
public class GetByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前台请求参数
        //获取layui传递过来的page和limit
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        int pageNum = Integer.parseInt(page);
        int limitNum = Integer.parseInt(limit);

        String sname = request.getParameter("sname");

        IStudentService studentService = new StudentServiceImpl();
        List<Map<String,Object>> list = studentService.getStuWithCls(sname,pageNum,limitNum);
        List<Student> listAll = studentService.getStuBySname(sname);


        //将list集合转换为layui表格能够识别的json格式数据
        JSONArray jsonArray = JSONArray.fromObject(list);
        //创建json对象
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",listAll.size()); //表中数据总条数
        jsonObject.put("data",jsonArray);

        //前台我们先进入了页面，又请求了后台获取数据
        //layui的表格只需要我们的数据，不能刷新
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonObject.toString());
        pw.flush();
        pw.close();



    }
}
