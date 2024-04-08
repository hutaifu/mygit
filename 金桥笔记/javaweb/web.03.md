##01-Servlet原理

+ servlet的创建方式
  + 一，继承HttpServlet父类，重写doGet(),doPost()
  + 这样的servlet只能处理基于HTTP协议的请求

```
@WebServlet(name = "TestServlet01")
public class TestServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

```

+ ​	

  + 二,继承GenericServlet父类，重写service（）方法

    + GenericServlet是一个通用的servlet类，可以处理各种协议的请求

    + 还是HttpServlet的父类

    + ```
      public class TestServlet02 extends GenericServlet {
          @Override
          public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
              //处理用户的请求，并作出响应
      //        这个servlet不止可以处理http协议的的请求

          }
      }

      ```

  + 三，实现servlet接口，重写五个方法

    + GenericServlet也是实现了这个接口

    + ```
      public class TestServlet03 implements Servlet {
          @Override
          public void init(ServletConfig servletConfig) throws ServletException {

          }

          @Override
          public ServletConfig getServletConfig() {
              return null;
          }

          @Override
          public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

          }

          @Override
          public String getServletInfo() {
              return null;
          }

          @Override
          public void destroy() {

          }
      }

      ```

      +

+ 以上三种方式创建的servlet都拥有service这个方法

  + 这个方法是用来接收浏览器请求并作出响应的方法
  + 我们重写的doGet和doPost方法的调用，也是从service方法中进行了请求方式的判断，来选择分发的
  + 前台的请求到了后台，首先执行的是service方法

## 02-Servlet的生命周期

+ 是值servlet对象的生命周期
+ 实例化（创建对象）
  + tomcat启动时会加载web.xml，识别到需要创建对象的类
  + 第一次访问某个servlet时，web容器会创建这个servlet对象，放到容器中
+ 初始化
  + 第一次访问某个servlet时，web容器会先调用servlet对象的init（）方法进行初始化操作
  + init（）只会调用一次
+ 服务
  + 每次浏览器来请求servlet资源时，都会调用service（）方法（doGet（）和doPost（））
  + 会被调用多次
+ 销毁
  + tomcat关闭时，调用destroy（）方法，进行对象的销毁。
  + destroy（）只会调用一次


## 03-request和response

+ HttpServletRequest 请求对象
  + 当浏览器向服务器发送请求时，web容器负责创建这个对象
  + 还会将所有的请求数据封装到该对象中
  + 当容器调用doGet或者doPost方法时，会将request对象作为实参传递到方法中
  + 方法
    + getParameter（）用于获取用户的请求数据
    + setCharactorEncoding（）设置编码字符集
    + getMethod（）获取用户的请求方式
+ HttpServletResponse 响应对象
  + 当浏览器向服务器发送请求时，直接创建的
  + 用于向浏览器做出响应的
  + 方法
    + setContenType（）用于设置响应的内容类型和编码字符集
    + getWriter（）获取输出流对象，用于向浏览器输出内容

## 04-ServletAPI

+ servlet的辅助性对象

+ ServletConfig对象

  + servlet的配置对象，封装了servlet的一些配置信息

  + 当我们第一次访问servlet时，web容器负责创建这个config对象

  + 并且会将web.xml中的一些配置参数封装到这个config对象中

  + ```
    <servlet>
            <servlet-name>login</servlet-name>
            <servlet-class>com.jxd.test.servlet.LoginServlet</servlet-class>
        </servlet>

        <servlet>
            <servlet-name>test01</servlet-name>
            <servlet-class>com.jxd.test02.servlet.TestServlet01</servlet-class>
    <!--        向servlet传递配置信息，外部数据-->
            <init-param>
                <param-name>msg</param-name>
                <param-value>hello servlet</param-value>
            </init-param>
        </servlet>
    ```

  + 我们在servlet的doGet或者doPost方法中就可以通过这个config对象，获取配置信息

  + ```
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("servlet开始处理请求");
    //        获取ServletConfig对象中配置信息
            ServletConfig servletConfig = this.getServletConfig();
            //msg对应的时xml中param-name的值
            String msg = servletConfig.getInitParameter("msg");
            System.out.println(msg);

        }

    ```

+ ServletContext对象

+ 全局对象，所有的servlet共享的一个对象，应用的上下文对象

+ tomcat启动时创建

+ 可以获取xml中的全局配置信息

+ ```
  <!--    全局的配置信息，所有的servlet都可以获取-->
  <!--    被封装到ServletContext对象中-->
      <context-param>
          <param-name>msg</param-name>
          <param-value>hello application</param-value>
      </context-param>

  ```

  + 在任意的servlet中，可以通过servletContext对象获取这些信息

  + ```
    //        获取全局信息
            ServletContext servletContext = this.getServletContext();
            String msgContext = servletContext.getInitParameter("msg");
            System.out.println(msgContext）；
    ```