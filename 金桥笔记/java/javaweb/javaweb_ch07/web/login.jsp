<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/30
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        out.write(session.getId());
    %>
    <%
        Cookie[] cookies = request.getCookies();
        String user = "";
        String pwd = "";
        if (cookies != null){
            for (Cookie cookie:cookies){
                if ("user".equals(cookie.getName())){
                    user = cookie.getValue();//找到了用户名
                }
                if ("pwd".equals(cookie.getName())){
                    pwd = cookie.getValue();
                }
            }
        }
     %>
<form action="/LoginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="user" value="<%=user%>"></td>
            <td></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="pwd" value="<%=pwd%>"></td>
            <td></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
            <td></td>
        </tr>
    </table>
</form>

</body>
</html>
