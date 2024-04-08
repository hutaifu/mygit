<%@ page import="com.jxd.student.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/25
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL的标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<div>当前用户：<%=session.getAttribute("uname")%></div>--%>
<%--从seesion范围内获取uanem这个变量，并显示在页面中--%>
<div align="right">当前用户：${sessionScope.uname}</div>
<div><button onclick="addStu()">新增</button></div>
    <div align="center">
        <table>
            <thead>
                <tr>
                    <th><input type="checkbox"></th>
                    <th>序号</th>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>籍贯</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach items="${stuList}" var="stu" varStatus="vs">

                    <tr>
                        <td><input type="checkbox"></td>
                        <td>${vs.index +1}</td>
                        <td>${stu.sno}</td>
                        <td>${stu.sname}</td>
                        <td>${stu.ssex}</td>
                        <td>${stu.age}</td>
                        <td>${stu.address}</td>
                    </tr>
                </c:forEach>
            </tbody>
           <%-- <%
                List<Student> list = (ArrayList)request.getAttribute("stuList");
            %>
            <tbody>
                <%
                    for (Student s:list) {
                %>
                <tr>
                    <td><input type="checkbox"></td>
                    <td><%=s.getSno()%></td>
                    <td><%=s.getSname()%></td>
                    <td><%=s.getSsex()%></td>
                    <td><%=s.getAge()%></td>
                    <td><%=s.getAddress()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>--%>
        </table>
    </div>
<script>
    function addStu() {
        //跳转到新增页面
        window.location.href = "addstu.html"
    }
</script>
</body>
</html>
