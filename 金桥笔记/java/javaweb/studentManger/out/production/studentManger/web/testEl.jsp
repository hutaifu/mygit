<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.jxd.student.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/26
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //将数据存储到page对象中
        pageContext.setAttribute("name","张三");
        Map<String,String> map = new HashMap<>();
        map.put("sno","001");map.put("sname","李四");
        //将map存储到request对象中
        request.setAttribute("map",map);

        Student stu = new Student();
        stu.setSname("刘备");
        request.setAttribute("stu",stu);
    %>
    ${name} <br>
    ${map.sname}<br>
    ${stu.sname}




</body>
</html>
