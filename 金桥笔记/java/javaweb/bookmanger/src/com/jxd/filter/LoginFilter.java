package com.jxd.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //先取出白名单
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //通过request对象获取上下文对象
        ServletContext application = request.getServletContext();
        //
        String paths = application.getInitParameter("unCheckURL");
        //将白名单由字符串拆分
        String[] uncheckpaths = paths.split(",");
        //获取当前路径
        String cuurPath = request.getServletPath();
        //判断当前路径是否在白名单中
        for(String path: uncheckpaths){
            if (cuurPath.equals(path)){
                //当前路径在白名单中，直接放行
                chain.doFilter(req,resp);
                return;//直接结束这个方法
            }
        }
        //不再白名单时，判断是否已登录--session中是否由user
        String user =(String) request.getSession().getAttribute("user");
        if (user == null){
            //没有登录，跳转到登录页面
            response.sendRedirect("/booklogin.jsp");
            return;
        }

        //已登录，放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
