package com.jxd.stu.servlet;

import com.jxd.stu.model.Cls;
import com.jxd.stu.service.IClsService;
import com.jxd.stu.service.impl.ClsServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/GetClsServlet")
public class GetClsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IClsService clsService = new ClsServiceImpl();
        List<Cls> list = clsService.getClsLsit();
        JSONArray jsonArray = JSONArray.fromObject(list);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonArray);
        pw.flush();
        pw.close();
    }
}
