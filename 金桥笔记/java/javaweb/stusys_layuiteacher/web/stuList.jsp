<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/8/29
  Time: 15:24
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
        <h3>欢迎${uname}登录本系统</h3>
    </div>
    <div class="layui-row">
        <div class="layui-col-lg5 layui-col-lg-offset2">
            <div class="layui-form-item">
                <label class="layui-form-label">姓名：</label>
                <div class="layui-input-inline">
                    <input type="text" id="sname" name="sname"  placeholder="请输入学生姓名"  class="layui-input">
                </div>
                <div class="layui-input-inline">
                    <button type="button" id="query" class="layui-btn">查询</button>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-lg3 layui-col-lg-offset9">
            <div class="layui-input-inline">
                <button type="button" id="add" class="layui-btn">新增</button>
            </div>
            <div class="layui-input-inline">
                <button type="button" id="edit" class="layui-btn">修改</button>
            </div>
            <div class="layui-input-inline">
                <button type="button" id="del" class="layui-btn">删除</button>
            </div>
        </div>
    </div>
   <div class="layui-row">
       <div class="layui-col-lg8 layui-col-lg-offset2">
           <table id="tab"></table>
       </div>
   </div>


    <script>
        //类似于$(function)
        //[]用于引入当前页面要用到的模块
        layui.use(['table','layer'],function(){
            //赋值操作,将layui中各个模块赋给一个变量
            var table = layui.table
            var layer = layui.layer
            $ = layui.jquery


            //加载表格数据
            table.render({
                id:"stuTab", //方便layui识别这个表格
                elem: "#tab",
                height: 450,
                url: "/GetByPageServlet",//后台获取数据的servlet，后台api
                page:true, // layui会在请求路径上拼接两个参数，一个是page代表当前页面，一个是limit每页显示条数，默认为10条
                limit: 5, //每页显示5条，
                limits: [5,10,15],
                cols:[[ //双中括号代表可以有多级表头
                    {type:"checkbox"}, //开启复选框
                    {type:"numbers"}, //显示序号列
                    /*后台lsit泛型为实体类类型，field对应的是对象的属性名称*/
                    /*后台list泛型为map集合，field对应map的key*/
                    {field: "sno",title:"学号",width:80,sort:true},
                    {field: "sname",title:"姓名",width:140},
                    {field: "ssex",title:"性别",width:120},
                    {field: "sage",title:"年龄",width:80},
                    {field: "address",title:"籍贯",width:150},
                    {field: "birthday",title:"出生日期",width:150},
                    {field: "cname",title:"所属班级",width:150}
                ]]
            })


            //查询按钮的点击事件
            $("#query").click(function () {
                //重载表格
                table.reload("stuTab",{
                    where:{"sname":$("#sname").val()}
                })
            })

            //新增按钮
            $("#add").click(function () {
                //打开新增页面的弹出框
                layer.open({
                    type: 2,   //打开一个frame框架页面
                    area: ['450px','600px'], //弹出框的宽高
                    title: "新增学生信息",
                    content:"addStu.jsp"
                })
            })
            
            //修改按钮
            $('#edit').click(function () {
                //获取表格的选中数据
                var checkStuatus = table.checkStatus("stuTab")
                //判断选中条数是否符合要求
                if(checkStuatus.data.length == 0){
                    layer.msg("请选择要修改的记录")
                    return
                }

                if(checkStuatus.data.length > 1){
                    layer.msg("只能选择一条数据进行修改")
                    return
                }

                //获取选中数据的主键
                var sno = checkStuatus.data[0].sno
                //根据主键查询所有的学生信息
               // window.location.href = "GetStuBySnoServlet?sno=" + sno

                layer.open({
                   type:2,
                   area:["450px","500px"],
                   title:"修改学生信息",
                   content: "GetStuBySnoServlet?sno=" + sno
                })

            })

            $("#del").click(function () {
                var checkStatus = table.checkStatus("stuTab")
                if(checkStatus.data.length == 0){
                    layer.msg("请选择要删除的数据")
                    return
                }

                //删除确认
                layer.msg("确定要删除所选记录么？",{
                    time:0,  //不自动关闭
                    btn:['确定','取消'],
                    yes:function () {
                        //点击了确定按钮后执行的动作
                        //获取学生主键
                        var snos = ""
                        $.each(checkStatus.data,function (i,stu) {
                            //i代表下标，stu代表数组中每个元素
                            snos += stu.sno + ","
                        })
                        snos = snos.substring(0,snos.length - 1)

                       /* //调用后台，传参
                        window.location.href = "DelStuServlet?snos=" + snos*/

                       $.ajax({
                           url:"DelStuServlet",
                           type:"post",
                           data: {"snos":snos},
                           async:true,
                           success:function () {
                               //刷新列表
                               table.reload("stuTab")
                               layer.msg("删除成功")
                           }
                       })


                    }
                })

            })
        })


    </script>

</body>
</html>
