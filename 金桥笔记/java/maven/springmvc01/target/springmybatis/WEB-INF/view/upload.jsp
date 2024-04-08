<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/9/13
  Time: 7:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传页面</title>
    <script src="../../static/js/jquery-3.1.1.min.js"></script>
</head>
<body>
    <form id="uploadForm" type="file" method="post" enctype="multipart/form-data">
        <input type="file" id="upload" name="upload" style="display: none">
        <a href="javascript:$('#upload').click()">上传</a>
        <a>删除</a>
    </form>
<div id="uploadDiv"></div>
<script>
    $(function () {
        $("#upload").change(function () {
            //获取上传数据
            //使用Fordata实现ajax提交
            var formData = new FormData($("#uploadForm")[0]);
            $.ajax({
                url:"uploadFile",
                data:formData,
                cache:false,//是否缓存
                contentType:false,//必须设定为false，及告诉服务器从浏览器提交过来的数据采用默认的数据格式
                processData:false,//不对数据进行任何处理,防止jequery对formdata的默认处理
                success:function (data) {
                    alert(data)
                },
                error:function (data) {
                    alert("执行失败")
                }


            })



        })




    })
</script>
</body>
</html>
