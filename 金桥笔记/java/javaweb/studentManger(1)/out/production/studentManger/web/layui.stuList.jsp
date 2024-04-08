<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/28
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"    media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<%
    //如果能从session中取出用户信息，说明用户已登录
    String user = (String) session.getAttribute("uname");
    if (user == null){
        //没有用户信息，就跳转到登录页面
        response.sendRedirect("layui.login.jsp");
    }else{
%>

<h3>欢迎你${sessionScope.uname}<span style="float: right"></span></h3>

<table class="layui-hide" id="test" lay-filter="test"></table>

<div align="center" style="color: red">
    <%--        <%=msg%>--%>
    <%--        首先回获取msg，然后进行空值判断，如果不为空，才会在页面显示--%>
    <%--        ${requestScope.msg}--%>
    ${addmsg}  ${upmsg}  ${delmsg}
</div>

<%
    }
%>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" onclick="location.href = 'addStudent.jsp'">增加</button>
        <button id="del" class="layui-btn layui-btn-sm" onclick="">删除</button>
        <button id="up" class="layui-btn layui-btn-sm" onclick="">修改</button>
        <button id="search" class="layui-btn layui-btn-sm">查询</button>
        <input id="query" class="layui-input-inline" placeholder="请输入学生姓名关键字" style="font-size: large">

    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->

<script>
    layui.use(['table','form'], function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'/LayuiGetListServlet'
            ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            ,title: '用户数据表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'},
                {field:'sno', width:80, title: 'ID', sort: true}
                ,{field:'sname', width:80, title: '用户名'}
                ,{field:'ssex', width:80, title: '性别', sort: true}
                ,{field:'age', width:80, title: '年龄'}
                ,{field:'address', title: '地址', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
            ]]
            ,page: true
        });
        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选');
                    break;

                //自定义头工具栏右侧图标 - 提示
                case 'LAYTABLE_TIPS':
                    layer.alert('这是工具栏右侧自定义的一个图标按钮');
                    break;
            };

        });
        //第一种：主动加载jquery模块
        layui.use(['jquery', 'layer'], function(){
            var $ = layui.$ //重点处
                ,layer = layui.layer;

            //后面就跟你平时使用jQuery一样
            $("#up").click(function () {
                var checkStatus = table.checkStatus('test');//是表格的id
                var ids = [];
                $(checkStatus.data).each(function (i, o) {//o即为表格中一行的数据
                    //数组.push(o.字段名)
                    ids.push(o.sno);//需要其他数据可以在添加
                });
                if (ids.length < 1) {
                    layer.msg('无选中项');
                    return false;
                }
                //ids = JSON.stringify(ids);//拿到所选中数据的id
                console.log(ids[0])
                window.location.href = "UpdateServlet?sno=" + ids[0]
                //接着就可以写你要请求的方法了，把拿到的值传到后台
            });
            $("#del").click(function () {
                var checkStatus = table.checkStatus('test');//是表格的id
                var ids = [];
                $(checkStatus.data).each(function (i, o) {//o即为表格中一行的数据
                    //数组.push(o.字段名)
                    ids.push(o.sno);//需要其他数据可以在添加
                });
                if (ids.length < 1) {
                    layer.msg('无选中项');
                    return false;
                }
                //ids = JSON.stringify(ids);//拿到所选中数据的id
                console.log(ids[0])
                var str = ids.join(",")
                console.log(str);
                window.location.href = "DelServlet?sno=" + str
                //接着就可以写你要请求的方法了，把拿到的值传到后台
            });
            $('#search').on('click', function () {
                // 搜索条件
                var selName = $('#query').val();
                console.log(selName);
                table.reload('test', {
                    method: 'get'
                    , where: {
                        'key': selName
                    }

                });
            });





        });
    });
</script>


</body>
</html>