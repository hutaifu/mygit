<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/26
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="layui/layui.js"></script>
    <link href="layui/css/layui.css">
</head>
<body>
    <%
        pageContext.setAttribute("name",null);
        pageContext.setAttribute("number",1);
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        request.setAttribute("list",list);
    %>

<%--    判断page中的name是否为空--%>
    <c:if test="${empty name}">
        用户名为空
    </c:if>
    <c:if test="${not empty name}">
        ${name}
    </c:if>
    <c:if test="${number == 1}">
        ${number}
    </c:if>

   <%-- <c:choose>
        <c:when test=""></c:when>
        <c:otherwise></c:otherwise>
    </c:choose>--%>
    <ul>
    <c:forEach items="${list}" var="str" varStatus="vs">
        <c:if test="${vs.index % 2 ==0}">
            <li style="background: bisque">
        </c:if>
        <c:if test="${vs.index % 2 != 0}">
            <li>
        </c:if>

<%--        index代表变量下标，从零开始--%>
        ${vs.index +1} --- ${str}<br>
<%--        计数，代表展示了几个变量--%>
        ${vs.count}<br>
<%--        是否是第一个--%>
        ${vs.first}<br>
        </li>

    </c:forEach>
    </ul>
<%--    for循环输出1-5--%>
    <c:forEach begin="1" end="5" step="1" var="num">
        ${num}
    </c:forEach>

<%--通用标签--%>
<%--    定义String msg = "hello" 然后request.setAttribute（"msg",msg）--%>
    <c:set var="msg" value="hello" scope="request"/>
<%--    ${msg}--%>
    <c:out value="${msg}"/>
<%--    移除变量--%>
    <c:remove var="msg" scope="request"/>
    ${msg}

<%--重定向--%>
    <c:redirect url="testEl.jsp"/>

<script>
    //不允许出现el jstl
</script>

</body>
</html>
