<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/30
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%--  如果用户已经登录，可以访问welcome.jsp
           如果用户没有登录，使用户跳转到登录页面

    <%
        //如果能从session中取出用户信息，说明用户已登录
        String user = (String) session.getAttribute("user");
        if (user == null){
            //没有用户信息，就跳转到登录页面
            response.sendRedirect("login.jsp");
        }else{
    %>--%>

    <h1>欢迎你${sessionScope.user}<span style="float: right"><a href="/LogOutServlet">注销</a></span></h1>

   <%-- <%
        }
    %>--%>
  <h2>当前在线人数为${num}</h2>
    <%
        //把cookie 中的东西取出来
        Cookie[] cookies = request.getCookies();//取出该浏览器所有的cookie对象
        //遍历cookies,找到我要的cookie
        if (cookies != null){
            for (Cookie cookie : cookies){
                //取出cookie的name
                if ("user".equals(cookie.getName())){ //根据cookie的name获取cookie的value
                    out.write("用户名：" + cookie.getValue());
                }

                if ("pwd".equals(cookie.getName())){ //根据cookie的name获取cookie的value
                    out.write("密码：" + cookie.getValue());
                }
            }
        }
    %>
</body>
</html>
