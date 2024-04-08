<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/31
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="layui/layui.js"></script>
</head>
<body>
    <div>
        <form id="form1" action="">
            用户名<input type="text" name="user"></input><span id="msg"></span>
        </form>
    </div>
    <script>
         // layui.use('form'),function () {
        /*layui.use('jquery'),function () {
                   $ = layui.jquery*/
         /*layui.use(['table','layer','laydate'],function () {
             //赋值操作,将layui中各个模块赋给一个变量
             var table = layui.table
             var layer = layui.layer
             $ = layui.jquery
*/

         layui.use('jquery',function () {
             $ = layui.$
                   // $(function () {


                $("input[name=user]").blur(function () {
                    //当输入框失去焦点时，校验用户名是否可用
                    var user = $(this).val();//获取当前元素的value值
                    //使用jQuery提供的Ajax请求后台
                    $.ajax({
                        url: "/ExistUserServlet",
                        data: {"user": user},
                        // data:$("#form1").serialize(),
                        type: "get",
                        async: true,
                        dataType: "text",
                        success: function (msg) {//小括号中的参数就是后台传回来的数据
                            //后台没有出现异常就执行success内容
                            $("#msg").html(msg)
                        },
                        error: function (err) {
                            alert("服务器响应失败")
                        }
                    })
                })
        // })
           })
         // }


    </script>
</body>
</html>
