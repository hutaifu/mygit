## 转发和重定向

+ Servlet和jsp是一体两面的结构，他们可以互相替代
+ 完成的功能：
  + 接收用户的数据，无论访问jsp还是servlet，web容器都会创建request和response对象，request对象中就是用户的请求数据。
  + 调用service后台获取数据库
  + 可以对用户做出响应
  + 都可以向浏览器输出内容
+ 区分：
  + servlet侧重于接收用户数据，调用后台获取数据库数据，并响应给浏览器
  + jsp侧重于将后台获取的数据展示在浏览器上
+ 页面的跳转
  + 不通功能的展示会防止不同的jsp中
  + 业务场景直接的转换就需要不断的切换页面，跳转页面
  + 通过转发或者重定向的方式跳转到jsp页面中

###01-重定向

+ 语法：

+ ```
   if ("admin".equals(name) && "123".equals(pwd)){
              //登录成功，让浏览器显示欢迎页面
              //重定向：服务器告诉浏览器去请求的资源名称，浏览器会在响应信息中得到新资源的名称
              //然后发起对这个资源的请求
              //浏览器会认为这是相对路径，会从当前项目下查找这个资源
  //            response.sendRedirect("welcome.jsp");
              //让浏览器访问项目之外的其他资源
              response.sendRedirect("http://www.baidu.com");

      }
  ```

+ 原理

  + 服务器通知浏览器去请求新的资源，通过代码改变了浏览器的网址
  + 地址栏会变化显示最终的资源路径
  + 核心是浏览器行为
  + 浏览器发起了二次请求

+ 特点

  + 重定向可以访问外部的资源，比如百度
  + 无法带入数据到新资源中

### 02-转发

+ ```java

          } else {
             //登录失败
  //            response.sendRedirect("login_admin.jsp");
              //转发的方式：服务器控制浏览器的显示内容，并没有让浏览器发送新的请求
  //            可以在跳转页面的同时将数据一块待人到下一个页面
  //            request本身封装了用户的请求数据
  //            我们可以将它看成是一个数据容器，也往里面封装我们自定义的数据
              request.setAttribute("msg","用户名或者密码错误");
              request.getRequestDispatcher("login_admin.jsp").forward(request,response);

  //            转发不能访问外部资源，只能访问服务器上有的资源
          }
  ```

+ 原理

  + 本质上服务器内部的控制权的转移，或者内部一个调度
  + 核心是服务器的行为，是服务器将资源的内容直接响应给了浏览器
  + 浏览器没有发起新的请求所以地址栏依然停在servlet资源上
  + 从用户点击登录按钮开始一直到回显到登录页面，展示错误信息，浏览器只请求了servlet，只有这一次请求

+ 特点：

  + 这一次请求过程中request对象和response对象，一直保留，没有回收，也没有新的request和response对象被创建
  + 我们可以将request做为一个数据容器，存储相应的信息，随着转发动作带人到任意的页面中
  + 在新的页面中，可以直接从request对象中获取信息
  + 转发可以连续执行，从servlet转发到jsp，在从jsp继续转发到其他的jsp，数据也会随着向下传递
  + 转发多次就是服务器内部不断的进行资源的调度
  + 只能访问服务器的内部资源，不能访问外网资源

+ 转发和重定向都可以跳转到某个jsp或者某个servlet

### 03-session对象

+ session会话，浏览器和服务器会话

+ 当浏览器第一次访问服务器上某个资源时，由web容器创建的对象

+ 在整个访问期间，这个对象一直存在，除非浏览器关闭了，这个对象不能再使用

+ 服务器会针对每个来访问的浏览器都去创建一个session对象

+ session对象可以再任意的jsp或者servlet中获取到

+ 我们可以将通用的数据存储到session对象中，

+ ```java
      if ("admin".equals(name) && "123".equals(pwd)){
  //            将用户名信息存储到session对象中
  //            session对象浏览器第一次访问服务器时由web容器创建的对象
              //在整个访问期间，这个对象始终存在
              HttpSession session = request.getSession();
              session.setAttribute("uname",name);


  ```

+ ```jsp
  <body>
      欢迎登录测试管理平台
      欢迎你，<%=session.getAttribute("uname")%>
  </body>
  ```

+ ​