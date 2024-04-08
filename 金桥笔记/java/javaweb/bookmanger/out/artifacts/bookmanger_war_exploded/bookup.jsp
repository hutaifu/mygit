<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/31
  Time: 19:34
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
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>欢迎${user}进入图书信息修改页面</legend>
</fieldset>

<form class="layui-form" action="UpSecondServlet"  method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">图书序号</label>
        <div class="layui-input-block">
            <input type="text" name="bookno" class="layui-input" value="${voBook.bookno}" readonly>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">书名</label>
        <div class="layui-input-block">
            <input type="text" name="booksname" class="layui-input" value="${voBook.booksname}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">作者</label>
        <div class="layui-input-block">
            <input type="text" name="eitor" class="layui-input" value="${voBook.eitor}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">出版社</label>
        <div class="layui-input-block">
            <input type="text" name="puber" class="layui-input" value="${voBook.puber}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">出版日期</label>
        <div class="layui-input-block">
            <input id="birthday" type="text" name="pubdate" class=layui-input value="${voBook.pubdate}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">剩余库存</label>
        <div class="layui-input-block">
            <input type="number" name="booknum" class="layui-input" value="${voBook.booknum}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">单价</label>
        <div class="layui-input-block">
            <input type="number" name="bookpri" class="layui-input" value="${voBook.bookpri}">
        </div>
    </div>



    <div class="layui-form-item">
        <label class="layui-form-label">类型</label>
        <div class="layui-input-block">
<%--            <input type="hidden" id="type_val" value="${voBook.booktype}">--%>
            <select name="typeno" id="typename">
                <option value="${voBook.typeno}" selected>${voBook.booktype}</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn layui-btn-normal" >提交</button>
            <button type="button" class="layui-btn layui-btn-normal" >取消</button>
        </div>
    </div>

</form>

<script>
    layui.use(['form','laydate','jquery'], function(){
        var form = layui.form
            ,laydate = layui.laydate,
            $ = layui.$;


        laydate.render({
            elem:"#birthday",
            triggger:'click'

        })

       /* var typename = $("#type_val").val()
        $("#typename").val(typename)
        form.render()//页面动态的效果都需要重新渲染
*/
        $.ajax({
            url:"GetTypeServlet",
            async:true,
            success:function (data) {
                var json = JSON.parse(data)
                $.each(json,function (i,vobook) {
                    if (vobook.typeno != ${voBook.typeno}) {
                        var obj = $("<option value =" + vobook.typeno + ">" + vobook.booktype + "</option>")
                        $("#typename").append(obj)
                    }
                })
                form.render()
        }



        })

    });
</script>

</body>
</html>

</body>
</html>
