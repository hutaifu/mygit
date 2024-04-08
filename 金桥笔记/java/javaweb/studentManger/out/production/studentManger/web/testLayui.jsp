<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/28
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="layui/layui.js"></script>
    <link href="layui/css/layui.css">
</head>
<body>
    <table id = "tabledemo"></table>


    <script>
       layui.use('table',function () {
           var table = layui.table;
           //加载数据表格

           table.render({
               id:'tab',
               elem:'#tabledemo',
               height:312,
               url:'/TestServlet',
               cols:[[
                   {field:'sno',title:'ID',width:80,sort:true},
                   {field:'sname',title:'用户名',width:80},
                   {field:'ssex',title:'性别',width:80,sort:true},
                   {field:'age',title:'年龄',width:80,sort:true},
                   {field:'address',title:'地址',width:80,sort:true}
               ]]
           })
       })
    </script>

</body>
</html>
