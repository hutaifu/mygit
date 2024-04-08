<%--
  Created by IntelliJ IDEA.
  User: 76382
  Date: 2022/8/25
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>

    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="layui/layui.js"></script>
    <link href="layui/css/layui.css" rel="stylesheet"/>

    <style>

    </style>
</head>
<body>
<div>
    <form class="layui-form" action="AddServlet" method="post" onsubmit="return checkAll()">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="sname" lay-verify="required" lay-reqtext="学生姓名不能为空" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="ssex" value="男" title="男">
                <input type="radio" name="ssex" value="女" title="女" checked>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-inline">
                <input type="text" name="age" lay-verify="checkage" placeholder="请输入学生年龄" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">年龄在1-120岁之间</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">籍贯</label>
            <div class="layui-input-block">
                <select name="address" lay-verify="required">
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                    <option value="广州">广州</option>
                    <option value="深圳">深圳</option>
                    <option value="杭州">杭州</option>
                    <option value="济南">济南</option>
                    <option value="青岛">青岛</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>

    </form>
</div>

<script>
    layui.use('form', function(){
        var form = layui.form;

        form.verify({
            checkage: [
                /^(?:[1-9][0-9]?|1[01][0-9]|120)$/
                ,'年龄不能为空，且在1-120岁之间'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });
    });
</script>
</body>
</html>
