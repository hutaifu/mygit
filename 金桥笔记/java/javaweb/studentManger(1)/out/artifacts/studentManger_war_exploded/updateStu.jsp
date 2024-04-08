<%--
  Created by IntelliJ IDEA.
  User: 76382
  Date: 2022/8/26
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL的标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="layui/layui.js"></script>
    <link href="layui/css/layui.css" rel="stylesheet"/>
</head>
<body>
<form class="layui-form" action="UpdateServletSecond" method="post" onsubmit="return checkAll()">
    <%--设置一个隐藏域，用来获取id--%>
    <input type="hidden" value="${student.sno}" id="sno" name="sno"/>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="sname" value="${student.sname}" lay-verify="required" lay-reqtext="学生姓名不能为空" placeholder="请输入" autocomplete="off" class="layui-input">
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
        <div class="layui-input-inline">
            <input type="text" name="age" value="${student.age}" lay-verify="checkage" placeholder="请输入学生年龄" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">年龄在1-120岁之间</div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">籍贯</label>
        <div class="layui-input-block">
            <%--设置一个隐藏域，用来获取addr--%>
            <input type="hidden" value="${student.address}" id="stuAddr"/>
            <select name="address" id="addr" lay-verify="required">
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
            <button class="layui-btn" lay-submit lay-filter="formDemo">确认修改</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
    layui.use(['form','jquery'], function(){
        var form = layui.form;
        var $ = layui.jquery
        form.verify({
            checkage: [
                /^(?:[1-9][0-9]?|1[01][0-9]|120)$/
                ,'年龄不能为空，且在1-120岁之间'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

        var addr = $("#stuAddr").val()
        $(function () {
            console.log(addr)
            $("option").each(function () {
                console.log($(this).val())
                if (addr === $(this).val()) {
                    console.log(1)

                    $(this).prop("selected",true)

                    form.render('select'); //这个很重要
                }
            })
        })

    });
</script>
</body>
</html>
