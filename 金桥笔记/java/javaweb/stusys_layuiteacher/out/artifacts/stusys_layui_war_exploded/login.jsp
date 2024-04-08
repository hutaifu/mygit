<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/31
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="layui/layui.js"></script>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
    <div class="layui-row">
    <%--栅格系统   div在其中占四份，然后再偏移四份--%>
    <div class="layui-col-lg-4 layui-col-lg-offset4">
        <h3>欢迎登录学生管理系统</h3>
        <fieldset class="layui-elem-field site-demo-button" style="margin-top:30px;">
            <legend>用户登录</legend>
            <form action="LoginServlet" method="post">
                <%--这个div是表单中的一项--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名:</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" name="uname" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码:</label>
                    <div class="layui-input-inline">
                        <input type="password" class="layui-input" name="pwd" placeholder="请输入密码">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn" lay-submit="">登录</button>
                    </div>
                </div>
            </form>
        </fieldset>
    </div>

</div>
    <div style="color:red" align="center">
        ${msg}
    </div>
</body>
</html>
