package com.jxd.bookmanger.servlet;

import com.jxd.bookmanger.model.VoBook;
import com.jxd.bookmanger.service.IBookService;
import com.jxd.bookmanger.service.impl.BookServiceImpl;
import com.jxd.bookmanger.util.LayuiToJson;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IBookService bookService = new BookServiceImpl();
        String key = request.getParameter("key");
        String str = request.getParameter("type");
        Integer type = null;
        if (str != null && !"".equals(str)){
            type = Integer.parseInt(str);
        }
        List<VoBook> list = bookService.querymore(key,type);
        JSONObject jsonObject = LayuiToJson.getjson(list);
        PrintWriter pw = response.getWriter();
        pw.println(jsonObject);
        pw.flush();
        pw.close();
    }
}
