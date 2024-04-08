<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/25
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Scanner" %>
<%@page import="java.util.Map,java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    java小脚本--%>
    <%
        //jsp页面访问时，依次执行
    String name = "admin";
    List<String> list = new ArrayList<>();
    list.add(name);
        System.out.println(list.get(0));
        //调用方法
        show();
    %>

<%--表达式的输出--%>
<%--将name变量输出到html中--%>
<%--类似servlet中的pw.printlin操作--%>
<h3><%=name%></h3>

<%--java方法或者变量的声明--%>
<%!
    public void show(){
        String str = "hello";
        System.out.println(str);
    }
%>
    <%
    String method = request.getMethod();
    out.print(method);

    %>

<%--    --%>
<!--   -->
    <div>
        <form action="" method="post"></form>
            用户名：<input type="text" name="uname"/><br>
            密码:<input type="password" name="pwd"><br>
            <input type="submit" value="登录">
    </div>


<script>

</script>
</body>
</html>
