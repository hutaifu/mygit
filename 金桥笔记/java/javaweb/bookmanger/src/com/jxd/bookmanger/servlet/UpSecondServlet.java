package com.jxd.bookmanger.servlet;

import com.jxd.bookmanger.model.Book;
import com.jxd.bookmanger.service.IBookService;
import com.jxd.bookmanger.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpSecondServlet")
public class UpSecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book(
                Integer.parseInt(request.getParameter("bookno")),
                request.getParameter("booksname"),
                request.getParameter("eitor"),
                request.getParameter("puber"),
                request.getParameter("pubdate"),
                Integer.parseInt(request.getParameter("booknum")),
                Double.parseDouble(request.getParameter("bookpri")),
                Integer.parseInt(request.getParameter("typeno"))
        );
        IBookService bookService = new BookServiceImpl();
        String upmsg = "修改失败";
        if(bookService.up(book.getBookno(),book)){
            upmsg = "修改成功";
        }
        request.setAttribute("upmsg",upmsg);
        request.getRequestDispatcher("booklist.jsp").forward(request,response);

    }
}

