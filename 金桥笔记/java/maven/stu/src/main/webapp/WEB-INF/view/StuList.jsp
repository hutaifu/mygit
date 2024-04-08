<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/8/29
  Time: 15:25
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
    <div align="center">
        <h3>欢迎${uname}登录本系统</h3>
    </div>
    <div class="layui-row">
        <div class="layui-col-lg5 layui-col-lg-offset2">
            <div class="layui-form-item">
                <label class="layui-form-label">姓名：</label>
                <div class="layui-input-inline">
                    <input id="sname" type="text" name="sname" placeholder="请输入学生姓名" class="layui-input">
                </div>
                <div class="layui-input-inline">
                    <button id="query" type="button" class="layui-btn">查询</button>
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
        <div class="layui-col-lg6 layui-col-lg-offset3">
            <table id="tab"></table>
        </div>
    <script>
        //类似于$(function)
        //[]用于引入当前页面要用到的模块
        layui.use(['table','layer','laydate'],function () {
            //赋值操作,将layui中各个模块赋给一个变量
            var table = layui.table
            var layer = layui.layer
            $ = layui.jquery


            //加载表格数据
            table.render({
                id:"stuTab",//方便layui识别这个表格
                elem:"#tab",
                height: 450,
                url:"/GetByPage",//后台获取数据的servlet，后台api
                page:true,//layui会在请求路径拼接两个参数，一个page代表当前页面，一个limit，每页显示条数，默认10条
                limit:5,
                limits:[5,10,15],
                cols:[[//双中括号代表可以有多级表头
                    {type:"checkbox"},//开启复选框
                    {type:"numbers"},//显示序号列
                    //后台list类型为实体类类型，field对应对象属性名
                    //field对应的是对象的属性名称
                    //field对应map的key值
                    {field:"sno",title:"学号",width:80,sort:true},
                    {field:"sname",title:"姓名",width:80},
                    {field:"ssex",title:"性别",width:80},
                    {field:"age",title:"年龄",width:80},
                    {field:"address",title:"籍贯",width:150},
                    {field:"birthday",title:"生日",width:80},
                    {field:"cname",title:"所属班级",width:80},
                ]]
            })
            //查询按钮的点击事件
            $("#query").click(function () {
                //重载表格
                table.reload("stuTab",{
                    where:{"sname":$("#sname").val()}
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
                layer.open({
                    type:2,//打开一个fram框架页面
                    area:['450px','500px'],//设置弹出框的宽高
                    title:"新增学生信息",
                    content:"toAddStu"
                })
            })
            //修改按钮
            $("#update").click(function () {
                //获取表格的选中数据
                var checkStuatus = table.checkStatus("stuTab")
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
                var sno = checkStuatus.data[0].sno
                //根据主键查询所有的学生信息
                // window.location.href = "GetStuBysSnoServlet?sno=" + sno
                layer.open({
                    type:2,
                    area:["450px","500px"],
                    tltle:"修改学生信息",
                    content:"GetStuBysSnoServlet?sno=" + sno

                })

            })
            $("#del").click(function () {
                var checkStatus = table.checkStatus("stuTab")
                if(checkStatus.data.length == 0){
                    layer.msg("请选择要删除的数据")
                    return;
                }
                //删除确认
                layer.msg("确定要删除所选记录吗？"),{
                    time:0,//不自动关闭当前提升框
                    btn:['确定','取消'],
                    yes:function () {
                        //点击了确定按钮后执行的动作
                        //获取学生主键信息
                        var snos = ""
                        $.each(checkStatus.data,function (i,stu) {
                            //i代表下标，stu代表数组中每个元素
                            snos += stu.sno + ","
                        })
                        snos = snos.substring(0,snos.length - 1)
                        //调用后台，传参
                        // window.location.href = "DelStuServlet?snos" + snos
                        $.ajax({
                            url:"",
                            type:post,
                            data:{"snos":snos},
                            async:true,
                            success:function () {
                                //刷新列表
                                table.reload("stuTab")
                                layer.msg("删除成功")
                            }


                        })
                    }
                }
            })




        })

    </script>
</body>
</html>
