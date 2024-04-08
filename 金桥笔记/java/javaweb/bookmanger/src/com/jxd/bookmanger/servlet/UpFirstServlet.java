package com.jxd.bookmanger.servlet;

import com.jxd.bookmanger.dao.IBookMangerDao;
import com.jxd.bookmanger.dao.impl.BookMangerDaoImpl;
import com.jxd.bookmanger.model.VoBook;
import com.jxd.bookmanger.service.IBookService;
import com.jxd.bookmanger.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpFirstServlet")
public class UpFirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookno = Integer.parseInt(request.getParameter("bookno"));
        IBookService bookService = new BookServiceImpl();
        VoBook voBook = bookService.queryone(bookno);
        request.setAttribute("voBook",voBook);
        request.getRequestDispatcher("bookup.jsp").forward(request,response);

    }
}
