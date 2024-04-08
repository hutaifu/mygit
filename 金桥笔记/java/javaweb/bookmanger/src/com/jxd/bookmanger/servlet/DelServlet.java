package com.jxd.bookmanger.servlet;

import com.jxd.bookmanger.service.IBookService;
import com.jxd.bookmanger.service.impl.BookServiceImpl;

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
        String str = request.getParameter("booknos");
        String[] strs = str.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        IBookService bookService = new BookServiceImpl();
        String delmsg = "删除失败";
        if (bookService.del(nums)){
            delmsg = "删除成功";
        }
        request.setAttribute("delmsg",delmsg);
        request.getRequestDispatcher("booklist.jsp").forward(request,response);
    }
}
