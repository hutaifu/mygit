###01.http协议特点

+ 基于请求和响应，没有请求就没有响应
+ 无状态，服务器不记录浏览器的任何信息
  + 包括浏览器中输入的内容，访问的时间，搜索过的关键字
  + 每次浏览器访问服务器，服务器都会认为这是全新的客户端
+ 记录信息主要有两种方式
  + Cookie
  + Session

### 02.Cookie

+ cookie是服务器控制浏览器存储数据的一种方式

  + 存储位置：浏览器（客户端）

+ 如何使用Cookie

  + 创建Cookie对象

    + cookie只能存字符串
    + name是cookie的名字，value是cookie中的内容

  + 设置Cookie的有效期

    + 如果不设置，则关闭浏览器后，Cookie就失效了
    + 如果设置了，其有效期只和设定的时间有关（不会因为浏览器关闭而提前失效，也不会因为浏览器没关闭了延迟保存）
    + 参数单位是秒
    + 这句话要写在addCookie之前才会生效

  + 向respones对象中添加cookie

  + ```
    response.addCookie(cookie1);
                //登录成功，跳转到welcome.jsp
    ```

  + ​

  + 重定向到浏览器（cookie在下一次请求时生效）

  + ```
    response.sendRedirect("welcom.jsp");
    ```

  + 因为重定向是2次请求，所以使用重定向的话会立即生效

  + 从浏览器端获取cookie

  + ```jsp
    <%
        //把cookie 中的东西取出来
        Cookie[] cookies = request.getCookies();//取出该浏览器所有的cookie对象
        //遍历cookies,找到我要的cookie
        if (cookies != null){
            for (Cookie cookie : cookies){
                //取出cookie的name
                if ("user".equals(cookie.getName())){ //根据cookie的name获取cookie的value
                    out.write("用户名：" + cookie.getValue());
                }
            }
        }
    %>
    ```

  + ```java
      //设置编码格式
            request.setCharacterEncoding("utf-8");
            //获取表单中提交的值
            String user = request.getParameter("user");
            String pwd = request.getParameter("pwd");
            //判断用户名和密码是否正确  admin,123456
            if ("admin".equals(user) && "123456".equals(pwd)){
                //保存用户名和密码 --服务器让浏览器保存
                Cookie cookie = new Cookie("user",user);
                cookie.setMaxAge(60 * 60 * 24 * 7);//设置生效时间
                Cookie cookie1 = new Cookie("pwd",pwd);
                cookie1.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(cookie);//服务器向浏览器下命令
                response.addCookie(cookie1);
                //登录成功，跳转到welcome.jsp
                response.sendRedirect("welcom.jsp");

            }else {
                //携带错误提升，回到登录界面转发，request
            }
        }
    }
    ```

    + 不同的浏览器存储的cookie位置不同，用哪个浏览器访问服务器，那么cookie对象就会存储在哪个浏览器中

### 03-session对象

+ session是记录信息的另一种方式，session是会话的意思

+ 会话，浏览器和服务器之间的一次会话

+ 如果只是单纯的打开浏览器，并没有产生会话，必须由浏览器向服务器发送请求才会构成一个会话

+ session对象和浏览器一一对应

  + 当在一个浏览器中同时打开了login.jsp和welcome.jsp，实际上仍然是同一个session在起作用

  + 在servlet中使用session对象

  + ```
    //如果登录成功，就将用户信息存储在session中
    //设置编码格式
    request.setCharacterEncoding("utf-8");
    //获取表单中提交的值
    String user = request.getParameter("user");
    String pwd = request.getParameter("pwd");
    //判断用户名和密码是否正确  admin,123456
    if ("admin".equals(user) && "123456".equals(pwd)){
        //将用户对象存储在session中
        HttpSession session = request.getSession();//获取session对象
        session.setAttribute("user",user);//根request对象的setAttribute（）类型
        session.setAttribute("pwd",pwd);
        response.sendRedirect("welcom.jsp");
    ```

  + ​

    + 与request类似，但是request对象直接由参数获取，session对象通过request.getSession（）获取

  + 也可以在jsp页面中使用session对象

  + 因为session是内置对象，可以在jsp直接使用

  + ```
    <%
        //如果能从session中取出用户信息，说明用户已登录
        String user = (String) session.getAttribute("user");
        if (user == null){
            //没有用户信息，就跳转到登录页面
            response.sendRedirect("login.jsp");
        }else{
    %>

    <h1>欢迎你<span style="float: right"><a href="/LogOutServlet">注销</a></span></h1>

    <%
        }
    %>
    ```

+ session的销毁

  + 通过invalidate（）方法销毁

  + ```
    //注销session
    HttpSession session = request.getSession();
    session.invalidate();
    response.sendRedirect("login.jsp");//立马又产生了一个新的session
    ```

  + 达到有效非活动时间，自动销毁

    + 默认有效非活动时间为30分钟

    + 当关闭浏览器时，session对象并没有立刻销毁，而是变成一种无法获取，无法操作的状态，当这个session对象达到有效非活动时间时，会自动销毁

    + 这一点可以通过sessionid来验证，关闭浏览器后再打开之后，访问服务器时会产生一个新的会话

    + ```
      session.setMaxInactiveInterval(60 * 60);//设置session的有效非活动时间，单位为秒（s）
      ```



### 04-cookie和session的区别

+ 存储位置
  + cookie在浏览器（客户端）存储
  + session在服务器存储
+ 存储的数据类型
  + cookie只能存储字符串
  + session能够保存任意的数据类型
+ 存储时间
  + cookie默认情况下关闭浏览器就失效，但是设置了存储时间后，实现时间与浏览器再无关系
  + session默认情况下，关闭浏览器后获取不到原session了，默认有效非活动时间为30分钟，但是还未立即失效，也可以设置其有效非活动时间，但无论如何session只在一次会话中生效
+ 存储信息
  + cookie一般存储一些不重要的信息，因为不安全
  + session可以存储一些重要信息，因为存在服务器上，比较安全

### 05-jsp四大范围内置对象

+ 共同点
  + 都是在服务器端存储数据
  + 都有getAttribute（）和setAttribute（）
+ 范围不同
  + page/pageContext:只在一个页面中生效，很少用
  + request：在一次请求中生效
  + session：在一次会话中生效，一次会话中可以有很多请求
  + application：在一次应用中生效（服务启动关闭）



### 06-application对象

+ 全局对象，Tomcat启动时创建，Tomcat终止时销毁

+ 整个服务器启动期间，只有一个实例，所有客户端都可以访问

+ application是jsp的范围内置对象

+ 其他方法

  + ```
    application.getRealPath("login.jsp");//获取相对路径的真实路径
    ```

  + ​

  + ​