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
    <form id="stuform" class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="sname" lay-verify="required" lay-reqtext="学生姓名不能为空" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-inline">
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
            <div class="layui-input-inline">
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
            <label class="layui-form-label">出生日期</label>
            <div class="layui-input-block">
                <input id="birthday" type="text" name="birthday" placeholder="请选择日期" class=layui-input value="${student.birthday}">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-inline">
<%--                如果没有type=button，那么该按钮默认为提交按钮--%>
                <button id="addsut" class="layui-btn" type="button" lay-filter="formDemo">添加</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">选择框</label>
            <div class="layui-input-inline">
                <input type="hidden" id="ads_val">
                <select name="cls" id="cls">

                </select>
            </div>
        </div>






    </form>
</div>

<script>
    layui.use(['form','laydate','layer'], function(){
        var form = layui.form,
            layer = layui.layer,
            laydate = layui.laydate;
            $ = layui.$;

        $(this).removeAttr("lay-key");
        laydate.render({
            elem:"#birthday",
            triggger:'click'

        })



        //通过ajax调用后台获取所有的班级信息
        $.ajax({
            url:"/GetClsServlet",
            async:true,
            success:function (data) {
                //data代表后台响应的字符串，这是一个json数组
                //【{cno：1，cname：一班}{}】
                //将后台响应回的json数据转换为浏览器可以识别的json格式
                var jsonData = JSON.parse(data)
                $.each(jsonData,function (i,cls) {
                    var obj = $("<option value='" + cls.cno + "'>" + cls.cname + "</option>")
                    $("#cls").append(obj)
                })
                //表单的渲染
                form.render()
            }
        })


        $("#addsut").click(function () {
            //利用ajax提交
            $.ajax({
                url:"AddstuServlet",
                type:"post",
                data:$("#stuform").serialize(),//将表单所有元素封装为json对象
                async:true,//设置异步
                success:function () {//状态码：200
                    //关闭当前弹框
                    //得到当前弹框的索引
                    parent.layui.table.reload("strTab")
                    parent.layer.msg("新增成功")
                    var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前弹框
                    parent.layer.close(index)
                    //刷新表格数据
                   /* parent.table.reload("strTab")
                    parent.layer.msg("新增成功")*/
                },
                error:function () {
                    layer.msg("新增失败")
                }

            })




        })
        $("#cancel").click(function () {
            var index = parent.layer.getFrameIndex(window.name);
            //关闭当前弹框
            parent.layer.close(index)
        })


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
