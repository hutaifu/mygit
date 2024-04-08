package com.jxd.test02.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @ClassName TestServlet02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/24
 * @Version 1.0
 */

public class TestServlet02 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //处理用户的请求，并作出响应
//        这个servlet不止可以处理http协议的的请求

    }
}
