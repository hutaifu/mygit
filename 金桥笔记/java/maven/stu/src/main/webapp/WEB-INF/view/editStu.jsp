<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/30
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="../../static/layui/layui.js"></script>
    <link rel="../../static/stylesheet" href="layui/css/layui.css">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>学生信息修改页面</legend>
</fieldset>

<form id="stuform" class="layui-form" >
    <div class="layui-form-item">
        <label class="layui-form-label">学号</label>
        <div class="layui-input-block">
            <input type="text" name="sno" placeholder="请输入学号" class="layui-input" value="${requestScope.student.sno}" readonly>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="sname" placeholder="请输入姓名" class="layui-input" value="${student.sname}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <c:if test="${student.ssex == '男'}">
                <input type="radio" name="ssex" value="男" title="男" checked>
                <input type="radio" name="ssex" value="女" title="女">
            </c:if>
            <c:if test="${student.ssex == '女'}">
                <input type="radio" name="ssex" value="男" title="男">
                <input type="radio" name="ssex" value="女" title="女" checked>
            </c:if>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-block">
            <input type="text" name="age" placeholder="请输入年龄" class=layui-input value="${student.age}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">选择框</label>
        <div class="layui-input-block">
            <input type="hidden" id="ads_val" value="${student.address}">
            <select name="address" id="address">
                <option value=""></option>
                <option value="山东济南">山东济南</option>
                <option value="山东青岛">山东青岛</option>
                <option value="山东烟台">山东烟台</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">出生日期</label>
        <div class="layui-input-block">
            <input id="birthday" type="text" name="birthday" placeholder="请选择日期" class=layui-input>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button id="editstu" type="button" class="layui-btn layui-btn-normal" >提交</button>
            <button type="button" class="layui-btn layui-btn-normal" >取消</button>
        </div>
    </div>

</form>

<script>
    layui.use(['form','laydate','jquery'], function(){
        var form = layui.form
            ,laydate = layui.laydate;
            $ = layui.$;

        // $(this).removeAttr("lay-key");



        laydate.render({
            elem:"#birthday",
            triggger:'click'

        })

        var address = $("#ads_val").val()
        $("#address").val(address)
        form.render()//页面动态的效果都需要重新渲染

        $("#editstu").click(function () {
            $.ajax({
                url:"EditStuServlet",
                type:"post",
                data:$("#stuform").serialize(),
                async:true,
                success:function () {



                }



            })
        })

    });
</script>

</body>
</html>

</body>
</html>
