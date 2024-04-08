package com.jxd.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(filterName = "EncodeFilter")
public class EncodeFilter implements Filter {
    FilterConfig filterConfig = null;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //从配置文件中获取编码格式
        String encode = filterConfig.getInitParameter("encode");
        //在doFiler方法中写预处理的指令
        //获取当前请求的路径
        HttpServletRequest request = (HttpServletRequest) req;//向下转型
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getServletPath();//获取请求的路径
        //path可能是/login.jsp或者/login.servlet--通过后四个字符是否为.jsp判断请求的类型
        String stuffx = path.substring(path.length()-4);//截取后四位字符
        //判断如果不是.jsp结尾就设置编码格式
        if (!".jsp".equals(stuffx)){
            request.setCharacterEncoding(encode);

            response.setContentType("text/html;charset=" + encode);
        }
        //将请求向下传递
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {
        filterConfig = config;
    }

}
