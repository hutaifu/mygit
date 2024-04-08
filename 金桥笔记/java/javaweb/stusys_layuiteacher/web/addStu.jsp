<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/8/30
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="layui/layui.js"></script>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>

<form id="stuForm" class="layui-form"  lay-filter="stuForm">
   <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="sname" placeholder="请输入姓名"  class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-inline">
            <input type="radio" name="ssex" value="男" title="男" checked>
            <input type="radio" name="ssex" value="女" title="女">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-inline">
            <input type="text" name="sage" placeholder="请输入年龄"  class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">籍贯</label>
        <div class="layui-input-inline">
            <select id="address" name="address" >
                <option value="山东济南">山东济南</option>
                <option value="山东青岛">山东青岛</option>
                <option value="山东烟台">山东烟台</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">出生日期</label>
        <div class="layui-input-inline">
            <input type="text" id="birthday" name="birthday" placeholder="请选择日期"  class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">所属班级</label>
        <div class="layui-input-inline">
            <select id="cls" name="cls" >
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-inline">
            <%--如果没有type=button这个属性，那么该按钮默认为是提交按钮--%>
            <button type="button" id="addStu" class="layui-btn">提交</button>
            <button type="button" id="cancel" class="layui-btn layui-btn-primary">取消</button>
        </div>
    </div>
</form>

<script>
    layui.use(['form','laydate'],function () {
        var form = layui.form
        var laydate = layui.laydate
        $ = layui.jquery

        //渲染日期选择框
        laydate.render({
            elem:"#birthday",
            trigger:"click"
        })

        //通过ajax调用后台，获取所有的班级信息
        $.ajax({
           url:"GetClsServlet",
           async:true,
           success: function (data) {
               //data代表后台响应的字符串，这是一个json数组
               //[{cno：1,cname:一班},{},{}]
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



        $("#addStu").click(function () {
            //利用ajax方式提交数据
            $.ajax({
                url:"AddStuServlet",
                type:"post",
                data: $("#stuForm").serialize(), //序列化操作会直接将表单所有元素封装为一个json
                async: true, //设置异步
                success: function(){ //状态码 200
                    //刷新表格
                    parent.layui.table.reload("stuTab")
                    parent.layui.layer.msg("新增成功")

                    //关闭当前页面
                    //得到当前弹框的索引
                    var index = parent.layui.layer.getFrameIndex(window.name);
                    //关闭当前弹框
                    parent.layer.close(index)

                },
                error:function () {
                   layer.msg("新增失败")
                }

            })
        })

        $("#cancel").click(function () {
            //得到当前弹框的索引
            var index = parent.layui.layer.getFrameIndex(window.name);
            //关闭当前弹框
            parent.layer.close(index)
        })
    })
</script>

</body>
</html>
