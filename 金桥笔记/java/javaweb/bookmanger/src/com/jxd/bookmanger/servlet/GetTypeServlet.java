package com.jxd.bookmanger.servlet;

import com.jxd.bookmanger.model.VoBook;
import com.jxd.bookmanger.service.IBookService;
import com.jxd.bookmanger.service.IBooktypeService;
import com.jxd.bookmanger.service.impl.BooktypeServiceImpl;
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

@WebServlet("/GetTypeServlet")
public class GetTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IBooktypeService booktypeService = new BooktypeServiceImpl();
        List<VoBook> list = booktypeService.getType();
        JSONArray jsonArray = JSONArray.fromObject(list);
        PrintWriter pw = response.getWriter();
        pw.println(jsonArray);
        pw.flush();
        pw.close();
    }
}
