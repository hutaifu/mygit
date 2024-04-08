<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/28
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>欢迎登录学生管理系统</legend>
</fieldset>
<blockquote class="layui-elem-quote layui-text"></blockquote>
<form class="layui-form" action="LoginServlet">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block" style="width: 300px;margin: 0 auto">
            <input type="text" name="uname" lay-verify="title" autocomplete="off" placeholder="请输入用户名" class="layui-input" value="<%=user%>">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block" style="width: 300px;margin: 0 auto">
            <input type="password" name="pwd" lay-verify="title" autocomplete="off" placeholder="请输入密码" class="layui-input" value="<%=pwd%>">
        </div>
    </div>
    <div style="text-align: center">
    <button type="submit" class="layui-btn layui-btn-lg">登陆</button>
    </div>
    <div align="center" style="color: red">
        <%--        <%=msg%>--%>
        <%--        首先回获取msg，然后进行空值判断，如果不为空，才会在页面显示--%>
<%--        ${requestScope.msg}--%>
        ${msg}
    </div>

</form>
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;
    });
</script>

</body>
</html>
