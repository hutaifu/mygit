<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/9/9
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>欢迎${emp.ename},${emp.job}来到登录页面</h1>
    <form action="/login4" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="登录" id="login1">
                <input type="button" value="前后台参数不一致" id="login2">
                <input type="button" value="前后台参数不一致" id="login3">
                <input type="submit" value="提交" id="form1">
                <input type="button" id="addBat" value="批量新增">
                <input type="button" id="login5" value="占位符传参">

            </td>
        </tr>
    </table>
    </form>


   <%-- <script src="../../static/js/jquery-3.1.1.min.js"></script>--%>
    <script src="../../static/layui/layui.js"></script>
    <script>
        $=layui.$;
        $(function () {
            //批量新增员工
            var emps = [
            {
                empno:1, ename:"喜羊羊",job:"科学家",hiredate:"2000-01-02"
            },
            {
                empno:1, ename:"喜羊羊",job:"科学家",hiredate:"2000-01-02"
            },
            {
                empno:1, ename:"喜羊羊",job:"科学家",hiredate:"2000-01-02"
            }
            ]
            $("#addBat").click(function () {
                console.log(emps);
                console.log(JSON.stringify(emps));
                //先把json数组转换成json字符串
                //默认的提交方式是json格式，要将其改为json字符串
                //注意如果使用json字符串，提交方式必须为post
                $.ajax({
                    url:"addBatch",
                    type:"post",
                    contentType:"application/json;charset=utf-8",
                    data:JSON.stringify(emps),
                    dataType:"text",
                    success:function (res) {
                        alert(res)
                    },
                    error:function () {
                        alert("服务器执行失败")
                    }
                })




            })
            $("#login1").click(function () {
                $.ajax({
                    url:"/login",
                    data:{
                        username:$("input[name=username]").val(),
                        password:$("input[name=password]").val()
                    },
                    type:"post",
                    dataType:"text",
                    success:function (res) {
                        alert(res)
                    },
                    error:function () {
                        alert("服务器访问失败")
                    }
                })
            })

            $("#login2").click(function () {
                $.ajax({
                    url:"/login2",
                    data:{
                        username:$("input[name=username]").val(),
                        password:$("input[name=password]").val()
                    },
                    type:"post",
                    dataType:"text",
                    success:function (res) {
                        alert(res)
                    },
                    error:function () {
                        alert("服务器访问失败")
                    }
                })
            })
            $("#login3").click(function () {
                $.ajax({
                    url:"/login3",
                    data:{
                        ename:$("input[name=username]").val(),
                        empno:1,
                        job:"经理",
                        hiredate:"2022-3-4"
                    },
                    type:"post",
                    dataType:"text",
                    success:function (res) {
                        alert(res)
                    },
                    error:function () {
                        alert("服务器访问失败")
                    }
                })
            })
            $("#form1").click(function () {
                alert("提交")

            })
            //在地址栏拼接数据可以采用/login5?key=value1&key2=value2
            $("#login5").click(function () {
                var user =  $("input[name=username]")
                var pwd = $("input[name=password]")
                $.ajax({
                    url:"/login5/" + user + "/" + pwd,
                    type:"post",
                    dataType:"text",
                    success:function (res) {
                        alert(res)
                    },
                    error:function () {
                        alert("服务器访问失败")
                    }
                })
            })
        })


    </script>
</body>
</html>
