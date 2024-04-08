## 学生管理系统-原生方式

+ 学生的增删改查

+ 学生查询

  + 通过登录页面，输入用户名和密码，将数据提交到后台的LonginServlet

  + 在LoginServlet中，获取用户名和密码信息，进行验证

  + 验证通过

    + 登录成功后去数据库查询所有的学生信息
    + 创建getAllservlet用于获取学生数据，
    + 重定向
    +  String pwd = request.getParameter("pwd");
    + 在getAllServlet中，直接调用Service方法
    + 通过转发的方式将list传给StuList
    + 进入列表页面，列表页面负责将学生信息展示到页面中
    + 首先获取list对象，通过for循环将数据展示在表格中
             if ("admin".equals(uname) && "123".equals(pwd)){
                 HttpSession session = request.getSession();
                 session.setAttribute("uname",uname);
                 //重定向到学生列表页面
                 response.sendRedirect("GetAllStuServlet");
             } else {//            转发会登录页面
                 request.setAttribute("msg","用户名或者密码错误")           request.getRequestDispatcher("login_admin.jsp").forward(request,response);
             }

         + ```jsp
           <%@ page contentType="text/html;charset=UTF-8" language="java" %>
           <html>
           <head>
               <title>Title</title>
           </head>
           <body>
               <div align="center">
                   <table>
                       <thead>
                           <tr>
                               <th><input type="checkbox"></th>
                               <th>学号</th>
                               <th>姓名</th>
                               <th>性别</th>
                               <th>年龄</th>
                               <th>籍贯</th>
                           </tr>
                       </thead>
                       <%
                           List<Student> list = (ArrayList)request.getAttribute("stuList");
                       %>
                       <tbody>
                           <%
                               for (Student s:list) {
                           %>
                           <tr>
                               <td><input type="checkbox"></td>
                               <td><%=s.getSno()%></td>
                               <td><%=s.getSname()%></td>
                               <td><%=s.getSex()%></td>
                               <td><%=s.getAge()%></td>
                               <td><%=s.getAddress()%></td>
                           </tr>

                           <%
                               }
                           %>
                       </tbody>
                   </table>
               </div>

           </body>
           ```

         + ​

         + ​

  + 验证不通过

    + 回到登录页面，提升错误信息

    + 转发回登录页面，将提升信息放到了request对象中

    + 在登录页面通过getAttribute（）获取信息，对信息做非空校验

    + ​

      ​

+ Web项目jar包引入

  + 在WEB-INF目录下，创建lib目录下
  + 在项目的构建菜单中，将整个lib文件夹作为依赖添加到项目上
  + 之后再有jar包引入，直接放到lib目录下即可





+ 学生新增

  + 在列表上方，通过新增按钮，在浏览器展示新增页面，或者以弹出框的形式展示新增页面

  + ```
    function addStu() {
        //跳转到新增页面
        window.location.href = "prc02rej.html"
    }
    ```

  + 在新增页面，填写学生的基本信息，完成后将数据提交到后台的addServlet

  + 在这个servlet中，首先获取用户的请求数据，也就是学生的信息

  + 将学生信息封装为一个学生对象，

  + 再去调用service的新增方法，service调用dao层方法，最终将数据报存再数据库中

  + 如果新增成功，在servlet中获取到了service的返回值为true，要去请求getAllServlet重新获取学生的全部信息。

  + 如果新增失败，转发回到新增页面，提升错误信息

## 学生管理系统-Layui

+ 登录页面：
  + 使用layui的表单模块实现
  + 登录信息提交到loginServlet中进行验证
  + 验证通过，重定向到stuList.jsp列表页面
+ 列表页面
  + 通过layui实现表格数据的加载
  + 列表上方放增删改单个按钮
+ 新增
  + 通过新增按钮进入新增页面，window.location.href = “addStu.jsp"
  + 通过layui的表单实现新增页面
  + 通过提交按钮实现数据的提交，提交到后台的addStuServlet
  + 在后台获取数据，封装对象，调用service方法
  + 获取到返回值后，重定向到列表页面
+ 修改
  + 点击修改按钮，根据当前选择行的数据获取到当前被选中的学生的学号信息
  + 根据学号查询当前学生的全部信息，在js中获取学号后，访问servlet资源
  + window.location.href = "getStuBySnoServlet?sno=" + sno
  + getStuBySnoServlet中调用service的Student.selectBySno(int sno)方法
  + 最终会获取学生对象，转发到编辑页面
  + 在编辑页面，展示学生，el表达式，<input value="${stu.sname}">
  + 进行数据修改，完成后数据提交到后台的ediStuServlet
  + 在这个servlet获取请求数据，封装对象，调用update方法
  + 得到结果，回到列表页面重定向
+ 删除
  + 可以选择多行进行删除
  + 点击删除按钮，我们要获取所有选中行的学号信息
  + 可以将所有的学号拼接为一个字符串，一起传递到后台，在后台使用split方法分割为字符串数组，需要转为int数组
  + 调用service方法
  + 也可以直接将所有的sno学号拼接在路径上
  + window.location.href = "delServlet?sno=" + 拼接后的全部学号
  + window.location.href = "delServlet?sno="+sno+"&sno="+sno+"&sno="+sno
  + 在后台可以直接接收为一个字符串数组
  + 获取结果后，回到列表页面
+ 查询
  + 学生姓名的模糊查询
  + 后台同一个service，servlet，同一个dao方法
  + 在dao层判断是否要拼接where方法
  + ​