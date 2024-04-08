<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/31
  Time: 19:33
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
<div align="center">
    <h3>欢迎${user}登录本系统</h3>
</div>
<div class="layui-row">
    <div class="layui-col-lg8 layui-col-lg-offset2">
        <div class="layui-form-item">
            <label class="layui-form-label">书名：</label>
            <div class="layui-input-inline">
                <input id="booksname" type="text" name="booksname" placeholder="请输入图书名关键字" class="layui-input">
            </div>

            <%--<div class="layui-input-inline">
                <button name="query" id="query" type="button" class="layui-btn">查询</button>
            </div>--%>

            <label class="layui-form-label">类型：</label>
            <form action="" class="layui-form">
            <div class="layui-input-inline">
               <select name="typeno" id="typeno">
                   <option></option>
               </select>
            </div>
            </form>





            <div class="layui-input-inline">
                <button name="query" type="button" class="layui-btn">查询</button>
            </div>
        </div>





        <%--  <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
              <input type="text" class="layui-input" id="test1"> </div>--%>
    </div>
</div>
<div class="layui-row">
    <div class="layui-col-lg4 layui-col-lg-offset8">
        <div class="layui-input-inline">
            <button id="add" type="button" class="layui-btn">新增</button>
        </div>
        <div class="layui-input-inline">
            <button id="update" type="button" class="layui-btn">修改</button>
        </div>
        <div class="layui-input-inline">
            <button id="del" type="button" class="layui-btn">删除</button>
        </div>
    </div>
</div>






<div class="layui-row"></div>
<div class="layui-col-lg12">
    <table id="tab" lay-filter="test"></table>
</div>
<div align="center" style="color: red">
    ${addmsg}  ${upmsg} ${delmsg}
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>



<script>
    //类似于$(function)
    //[]用于引入当前页面要用到的模块
    layui.use(['table','layer','laydate','form'],function () {
        //赋值操作,将layui中各个模块赋给一个变量
        var table = layui.table
        var layer = layui.layer
        var form = layui.form;
        $ = layui.jquery


        //加载表格数据
        table.render({
            id:"bookTab",//方便layui识别这个表格
            elem:"#tab",
            height: 450,
            url:"/ListServlet",//后台获取数据的servlet，后台api
            toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: [, { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            ,layEvent: 'LAYTABLE_TIPS'
            ,icon: 'layui-icon-tips'
        }],
            page:true,//layui会在请求路径拼接两个参数，一个page代表当前页面，一个limit，每页显示条数，默认10条
            limit:5,
            limits:[5,10,15],
            cols:[[//双中括号代表可以有多级表头
                {type:"checkbox"},//开启复选框
                {type:"numbers"},//显示序号列
                {field:"bookno",title:"序号",sort:true},
                {field:"booksname",title:"书名"},
                {field:"eitor",title:"作者"},
                {field:"puber",title:"出版社"},
                {field:"pubdate",title:"出版日期"},
                {field:"booknum",title:"剩余数量"},
                {field:"bookpri",title:"价格"},
                {field:"booktype",title:"类型"},
                {fixed: 'right', title:'操作', toolbar: '#barDemo'}
            ]]
        })

        $.ajax({
            url: "GetTypeServlet",
            async: true,
            success: function (data) {
                var json = JSON.parse(data)
                $.each(json, function (i, vobook) {
                    var obj = $("<option value =" + vobook.typeno + ">" + vobook.booktype + "</option>")
                    $("#typeno").append(obj)
                })
                form.render()
            }
        })


        //查询按钮的点击事件
        $("[name = query]").click(function () {
            //重载表格
            table.reload("bookTab",{
                where:{"key":$("#booksname").val(),
                       "type":$("#typeno").val()}
            })
        })


        var laydate = layui.laydate;//执行一个laydate实例
        laydate.render({ elem: '#test1', //指定元素
            //由于窗口比较小，预留的空间不够日期控件所展现，所以可能会出现日期控件一闪而过的情况
            triggger:'click' //此语句解决弹出框显示问题
        });
        //新增按钮
        $("#add").click(function () {
            //打开新增页面
            location.href = "bookadd.jsp"
        })
        //修改按钮
        $("#update").click(function () {
            //获取表格的选中数据
            var checkStuatus = table.checkStatus("bookTab")
            //判断选中条数是否符合要求
            if(checkStuatus.data.length == 0){
                layer.msg("请选择要修改的记录")
                return;
            }
            if (checkStuatus.data.length > 1){
                layer.msg("只能选中一条数据进行修改")
                return;
            }
            //获取选中数据的主键
            var bookno = checkStuatus.data[0].bookno
            window.location.href = "UpFirstServlet?bookno=" + bookno
        })

        $("#del").click(function () {
            var checkStatus = table.checkStatus("bookTab")
            if (checkStatus.data.length == 0) {
                layer.msg("请选择要删除的数据")
                return
            }
            //删除确认
            layer.msg("确定要删除所选记录么？", {
                time: 0,  //不自动关闭
                btn: ['确定', '取消'],
                yes: function () {
                    //点击了确定按钮后执行的动作
                    //获取学生主键
                    var booknos = ""
                    $.each(checkStatus.data, function (i, book) {
                        //i代表下标，stu代表数组中每个元素
                        booknos += book.bookno + ","
                    })
                    booknos = booknos.substring(0, booknos.length - 1)

                    //调用后台，传参
                    window.location.href = "DelServlet?booknos=" + booknos

                }
            })
        })

        table.on('tool(test)', function(obj){
            var data = obj.data;
            var booknos = data.bookno
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    // obj.del();
                    window.location.href = "DelServlet?booknos=" + booknos
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
               /* layer.prompt({
                    formType: 2
                    ,value: data.email
                }, function(value, index){
                    obj.update({
                        email: value
                    });
                    layer.close(index);*/
                // });
                window.location.href = "UpFirstServlet?bookno=" + booknos


            }
        });


    })


</script>
</body>
</html>
