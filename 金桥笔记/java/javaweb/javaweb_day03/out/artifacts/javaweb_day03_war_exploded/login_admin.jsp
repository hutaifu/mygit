<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/25
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div align="center">
        <h3>欢迎登录测试管理系统</h3>
        <form action="LoginServlet" method="post">
            <table>
                <tr>
                    <td align="right">用户名</td>
                    <td><input type="text" name="uname"></td>

                </tr>
                <tr>
                    <td align="right">密码</td>
                    <td><input type="password" name="pwd"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="登录">
                    </td>
                </tr>
            </table>
        </form>
    </div>


    <%
    //我们可以直接访问request对象，这个对象中就有刚才set进去的msg变量
        String msg = "";
        if (request.getAttribute("msg") != null) {
//            登录失败转发回来的情况
//            Object o = request.getAttribute("msg");
            msg = (String)request.getAttribute("msg") ;
//            msg = (String)o;
        }
//    如果条件不满做，msg为null，代表从浏览器直接访问这个页面

    %>
    <div align="center" style="color: red">
        <%=msg%>
    </div>


</body>
</html>
