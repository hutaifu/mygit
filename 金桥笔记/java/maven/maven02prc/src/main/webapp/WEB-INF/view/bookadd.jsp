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
    <script src="../../static/layui/layui.js"></script>
    <link rel="stylesheet" href="../../static/layui/css/layui.css">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>欢迎${user}进入图书增加修改页面}</legend>
</fieldset>

<form class="layui-form" action="AddServlet"  method="post" onsubmit="return chkAll()">

    <div class="layui-form-item">
        <label class="layui-form-label">书名</label>
        <div class="layui-input-block">
            <input type="text" name="booksname" class="layui-input" placeholder="请输入书名">
            <span style="display: none">不能为空</span>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">作者</label>
        <div class="layui-input-block">
            <input type="text" name="eitor" class="layui-input" placeholder="请输入作者">
            <span style="display: none">不能为空</span>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">出版社</label>
        <div class="layui-input-block">
            <input type="text" name="puber" class="layui-input" placeholder="请输入出版社">
            <span style="display: none">不能为空</span>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">出版日期</label>
        <div class="layui-input-block">
            <input id="birthday" type="text" name="pubdate" class=layui-input placeholder="请输入出版日期">
            <span style="display: none">不能为空</span>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">剩余库存</label>
        <div class="layui-input-block">
            <input type="number" name="booknum" class="layui-input" placeholder="请输入剩余库存">
            <span style="display: none">不能为空且大于等于零</span>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">单价</label>
        <div class="layui-input-block">
            <input type="number" name="bookpri" class="layui-input" placeholder="请输入单价">
            <span style="display: none">不能为空且大于等于零</span>
        </div>
    </div>



    <div class="layui-form-item">
        <label class="layui-form-label">类型</label>
        <div class="layui-input-block">
            <%--            <input type="hidden" id="type_val" value="${voBook.booktype}">--%>
            <select name="typeno" id="typename">
                <option></option>
            </select>
                <span style="display: none">不能为空</span>
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
                var jsonDat = JSON.stringify(data)
                var keyList = eval(jsonDat)
                for(var i = 0; i< keyList.length;i++){
                    var obj = $("<option value =" + keyList[i].typeno + ">" + keyList[i].typename + "</option>")
                    $("#typename").append(obj)
                }
               /* var json = JSON.parse(data)
                $.each(json,function (i,book) {
                        var obj = $("<option value =" + book.typeno + ">" + book.booktype + "</option>")
                        $("#typename").append(obj)
                })*/
                form.render()
            }
        })

        var arr = []
        arr[0] = /^.+$/
        arr[1] = /^.+$/
        arr[2] = /^.+$/
        arr[3] = /^[0-9].+$/;
        arr[4] =/^[0-9].+$/;
        arr[5] = /^.+$/;
        arr[6] = /^.+$/;

        var isture = new Array()
        for (var i = 0; i < isture.length; i++) {
            isture[i] = false;
        }


            $("input").blur(function () {
                var num = $("input").index(this)
                if(!arr[num].test(this.value)){
                    $(this).next().css("display","inline")
                    isture[num] = false
                }else {
                    $(this).next().css("display","none")
                    isture[num] = true
                }
            })

        function chkAll() {
            var isAll = true;
            for (var i = 0; i < isture.length; i++) {
                if (isture[i] == false){
                    isAll = false
                }
            }
            return isAll;
        }




    });
</script>

</body>
</html>
