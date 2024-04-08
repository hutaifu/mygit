<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/9/9
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../../static/layui/layui.js" language="JavaScript"></script>
    <link rel="stylesheet" href="../../static/layui/css/layui.css">
</head>

<body>
<table id="tabledemo"></table>
    <script>
        layui.use('table', function() {
            var table = layui.table;
            //加载数据表格
            table.render({
                id: 'tab', elem: '#tabledemo',
                //table表格id ,
                height: 312,
                url: '/getAllEmp',
                //数据接口，查询表格数据的后台url ,
                cols: [[ //表头
                    {field: 'empno', title: '员工编号', width: 80, sort: true, fixed: 'left'},
                    {field: 'ename', title: '员工姓名', width: 80},
                    {field: 'job', title: '工作', },//表头信息，field值要和对应的实体类属性名对应
                    {field: 'hiredate', title: '入职日期',} //表头信息，field值要和对应的实体类属性名对应
                ]]
            });
        })







    </script>
</body>
</html>
