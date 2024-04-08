<%@ page import="com.jxd.student.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/28
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>学生信息修改页面</h3>
<form action="UpdateServletSecond">
                学号<input name="sno" type="text" value=${student.sno}><br>
                姓名<input name="sname" type="text" value=${student.sname}><br>
                性别<input name="ssex" type="text" value=${student.ssex}><br>
                年龄<input name="age" type="text" value=${student.age}><br>
                地址<input name="address" type="text" value=${student.address}><br>
                <button type="submit">提交</button>
</form>
</body>
</html>
