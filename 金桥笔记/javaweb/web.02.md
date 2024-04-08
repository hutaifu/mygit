## 00-动态资源

+ jsp和servlet属于动态资源，因为者两种文件都可以写Java代码，
  + jsp是html里嵌套java代码
  + servlet本身就是java类
  + 都可以访问service和dao层，获取数据库中的数据，给浏览器展示。

## 01-第一个servlet程序

+ 本质是一个java类，可以通过浏览器直接访问。

+ 继承自HttpServlet类，

+ 重写了doGet和doPost方法，分别用于接收前台（浏览器）的get请求和post请求

+ 我们在doGet和doPost中处理前台请求

  + 获取前台的请求数据
  + 再去调用业务逻辑层的方法，实现底层的操作
  + 根据业务逻辑层的返回值，向浏览器做出合适的响应动作

+ servlet主要作用

  + 接收用户的请求，并对请求做出响应

  + servlet的注册

  + 所有的servlet都需要创建对象后，才能使用

  + 这个对象是由tomcat web容器赋值创建

  + 需要在web.xml中注册servlet，tomcat启动时，回来加载整个web.xml

  + ```xml
    <!--    注册servlet，告诉tomcat我没想要创建某个servlet类型对象-->
        <servlet>
    <!--        自定义-->
            <servlet-name>hello</servlet-name>
    <!--        servlet 的全路径-->
            <servlet-class>com.jxd.test.servlet.HelloServlet</servlet-class>
        </servlet>

        <servlet>
            <servlet-name>login</servlet-name>
            <servlet-class>com.jxd.test.servlet.LoginServlet</servlet-class>
        </servlet>
    <!--    浏览器访问这个servlet的映射信息-->
        <servlet-mapping>
    <!--        对映上方的servlet名称-->
            <servlet-name>hello</servlet-name>
    <!--        浏览器通过什么路径可以访问到servlet资源-->
    <!--        http：//localhost:8080/hello-->
            <url-pattern>/hello</url-pattern>
        </servlet-mapping>
    ```

  + 还可以通过注解的方式注册

  + @WebServlet（”/TestServlet“）注册servlet

  + 小括号中的内容对应的是前台的请求路径

```
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

```

+ servlet的访问
  + 可以通过浏览器路径直接访问，默认使用的是get方式
    + http：//localhost:8080/hello
  + 可以通过form表单的action访问某一个servlet资源
    + <form action= "login" method="">
    + 通过action的本质其实还是通过浏览器发送这个请求
    + 请求方式根据method的值决定
    + 默认为get方式
  + 如果前台的请求方式在后台没有找到对应的方法，那么浏览器会显示一个405错误码
+ 一个servlet只完成前台的一个请求
  + 登录对应LoginServlet
  + 注册对应RegisterServlet

## 02-http协议的相关特点

+ web通信基于http协议，超文本传输协议。
+ 特点
  + 基于请求和响应的一致协议，浏览器不发请求，服务器不主动响应
  + 不对请求和请求的浏览器做任何的信息记录，每次请求都会作为新的请求处理
    + 无状态
  + 分类
    + 请求协议
    + 数据从浏览器到服务器的传输方式
      + get
        + 将用户数据以？形式拼接在路径上，不同的参数间用&分隔
        + localhost：8080/login?uname=admin&pwd=123
        + 数据不安全
        + url长度有限，所以get方式传输的数据有限
        + 效率高，速度快
        + get式获取，如果要从服务器获取数据式，也就是查询操作时，密码除外，使用get
        + 只有不出现post关键字，都是get方式
      + post
        + 将用户数据封装为数据体或者请求体，发送给后台，在路径上不体现
        + 数据安全
        + 数据大小无限制，可以传输大量数据，附件上次必须使用psot
        + 效率低
        + post时发送，如果在向服务器发送数据，执行增杀删改时，使用post
        + 出现post关键字了，才是post方式
    + 响应协议
      + 阅读的是服务器向浏览器响应数据的传输方式。
      + 响应码
      + 200：服务器运行成功
      + 404：找不到资源
      + 405：找不到请求方法
      + 500：服务器错误
        + java代码错误
        + ​

## 03-tomcat部署项目

+ tomcat用于发布我们的web项目，一般需要将web项目放到tomcat的webapps目录下
+ 但是idea会针对当前的项目单独生成一个目录文件，将tomcat中核心的内容复制过来，我们启动tomcat时，会读取生成的这个新目录内容，将当前项目发布出去。
+ 每个项目，idea都会去生成一个新目录，我们不需要在操作tomcat的webapps这个目录了
+ 访问项目的目录名称
  + 默认情况下tomcat会给当前项目起个名字，就是application_context值
  + 我们访问时，需要在8080端口后加上这个项目名称
  + http://localhost:8080/javaweb day02 war exploded/login.html
  + 我们可以将application_context的值设为/,用于代表当前项目
    + http://localhost:8080/login.html

## 04-请求过程

+ 所有的请求都是浏览器发起，都是通过网址url进行请求。
+ 请求都是web资源，可能是html,jsp或者是servlet
+ 请求过程
  + 浏览器发起请求，服务器接收到这个请求，会将对应的资源响应给浏览器。
+ 静态资源的访问
  + 浏览器请求静态资源，服务器会直接将该资源响应给浏览器，浏览器解释执行。
+ 动态资源
  + jsp：待定
  + servlet：服务器接收到浏览器的servlet资源的请求，会先去web.xml中匹配查询当前的请求路径所对应的servlet资源，找到servlet-name，再根据name名称去查找对应的servlet对象，进而就可以执行这个对象的方法。
  + servlet是java类，由虚拟机运行，服务器将运行结果响应给浏览器。

## 05-数据的编码

+ 分类

  + 请求编码
  + 响应编码

+ 什么时编码

  + 计算机底层数据传输是以二进制的形式进行的。
  + 编码的过程就是将用户数据转换为二进制的过程

+ 什么时编码字符集

  + 就是用户数据转换为二进制对照表，或者字典
  + 有很多套编码字符集

+ 常见的编码字符集

  + 汉字信息转换二进制时，默认使用的是国标的字符集，GBK，GB2312
  + java是国外的，他们默认的字符集是iso-8859-1
  + 万国码，utf-8，适配大部分国家语言

+ 为什么出现乱码

  + 浏览器向服务器发送数据时，会根据gbk这个字符集将汉字转换为二进制
  + 服务器接收后，会根据iso-8859-1字符集将二进制再转换为数据
  + 服务器向浏览器响应数据时，会根据iso-8859-1字符集转为二进制
  + 浏览器接收后，会根据GBK的方式转换为具体数据

+ 如何解决乱码

  + 将浏览器和服务器的编码方式设置为一致的万国码utf-8

  + 请求乱码（post）

    + 设置request对象的编码字符集

    + ```
      request.setCharacterEncoding("utf-8");
      ```

      ​		

    + get方式，tomcat8及以上以及再内部设置了编码字符集

  + 响应乱码（通过printwriter输出流向浏览器响应数据）

    + 设置响应内容类型

    + ```
      response.setContentType("text/html;charset=utf-8");
      ```

