## 过滤器和监听器

### 01-过滤器

+ Filter，在web项目中，过滤器的本质是一个类

+ 主要作用是，在用户的请求到达servlet之前进行一些预处理操作

  + 请求从浏览器出发，先到过滤器中进行一些预处理，然后才抵达Servlet

+ 过滤器的应用--设置编码字符集

  + 创建过滤器new --->create new Filter

  + 配置过滤器

    + 先注释掉自带的注解

    + ```
      <filter> 
              <filter-name>encodeFilter</filter-name>
              <filter-class>com.jxd.filter.EncodeFilter</filter-class>
              <init-param>
                  <param-name>encode</param-name>
                  <param-value>utf-8</param-value>
              </init-param>
          </filter>
          <filter-mapping>
              <filter-name>encodeFilter</filter-name>
      <!--        /*是所有的资源都被拦截，包括jsp和servlet-->
              <url-pattern>/*</url-pattern>
          </filter-mapping>
      ```

  + 在过滤器的初始化方法中（init）中，给全局遍历FilterConfig赋值，方便我们在doFilter方法中获取配置信息

  + ```
    FilterConfig filterConfig = null;
    ```

  + ```
     //从配置文件中获取编码格式
            String encode = filterConfig.getInitParameter("encode");
            //在doFiler方法中写预处理的指令
            //获取当前请求的路径，所有的请求都是web容器来创建的，过滤器的请求是web容器根据请求协议创建的，如果请求协议是http协议，web容器就会一多态的形式创建一个http的request对象
            HttpServletRequest request = (HttpServletRequest) req;//向下转型
            HttpServletResponse response = (HttpServletResponse) resp;
            String path = request.getServletPath();//获取请求的路径
            //path可能是/login.jsp或者/login.servlet--通过后四个字符是否为.jsp判断请求的类型
            String stuffx = path.substring(path.length()-4);//截取后四位字符
            //判断如果不是.jsp结尾就设置编码格式
            if (!".jsp".equals(stuffx)){
                request.setCharacterEncoding(encode);

                response.setContentType("text/html;charset=" + encode);
            }
            //将请求向下传递
            chain.doFilter(req,resp);
        }

        public void init(FilterConfig config) throws ServletException {
            filterConfig = config;
        }

    }
    ```

  + ```
    public void init(FilterConfig config) throws ServletException {
        filterConfig = config;
    }
    ```

  + 过滤器的声明周期

    + 实例化，第一次发送请求就进行实例化操作，
    + 初始化，在实例化之后进行初始化操作，也就是执行init（）方法
    + 预处理操作，各个请求的提前设置，也就是doFilter
    + 销毁，在Tomcat关闭之后，进行销毁操作，也就是destroy

  + init（）和destroy()只执行一次，Dofilger执行此时和请求此时有关

+ 过滤器链

  + 一个项目中可能有多个过滤器，实现不同的功能
  + 这些过滤器会根据注册顺序形成一个链式结构
  + 所有的过滤器会依次被经过 ，直到最后一个

+ 创建loginFilter

+ ```
  <context-param>
  <!--        将数据存在上下文对象中-->
          <param-name>unCheckURL</param-name>
          <param-value>/login.jsp,/LoginServlet</param-value>
      </context-param>
      <filter>
          <filter-name>loginFilter</filter-name>
          <filter-class>com.jxd.filter.LoginFilter</filter-class>
      </filter>
      <filter-mapping>
          <filter-name>loginFilter</filter-name>
          <url-pattern>/*</url-pattern>
      </filter-mapping>
  ```

+ ```
  //先取出白名单
  HttpServletRequest request = (HttpServletRequest) req;
  HttpServletResponse response = (HttpServletResponse) resp;
  //通过request对象获取上下文对象
  ServletContext application = request.getServletContext();
  //
  String paths = application.getInitParameter("unCheckURL");
  //将白名单由字符串拆分
  String[] uncheckpaths = paths.split(",");
  //获取当前路径
  String cuurPath = request.getServletPath();
  //判断当前路径是否在白名单中
  for(String path: uncheckpaths){
      if (cuurPath.equals(path)){
          //当前路径在白名单中，直接放行
          chain.doFilter(req,resp);
          return;//直接结束这个方法
      }
  }
  //不再白名单时，判断是否已登录--session中是否由user
  String user =(String) request.getSession().getAttribute("user");
  if (user == null){
      //没有登录，跳转到登录页面
      response.sendRedirect("/login.jsp");
      return;
  }
  ```

### 02-监听器

+ 用于监听web中某些对象的状态变化，比如创建，销毁等

+ 统计服务器中session的个数

  + 创建监听器new ===》create new Listener

  + ```
    public class TestListener implements ServletContextListener,
            HttpSessionListener, HttpSessionAttributeListener {
        private int num = 0;//当前服务器中session的个数
        // Public constructor is required by servlet spec
        public TestListener() {
        }

        // -------------------------------------------------------
        // ServletContextListener implementation
        // -------------------------------------------------------
        public void contextInitialized(ServletContextEvent sce) {
          /* This method is called when the servlet context is
             initialized(when the Web application is deployed). 
             You can initialize servlet context related data here.
          */
        }

        public void contextDestroyed(ServletContextEvent sce) {
          /* This method is invoked when the Servlet Context 
             (the Web application) is undeployed or 
             Application Server shuts down.
          */
        }

        // -------------------------------------------------------
        // HttpSessionListener implementation
        // -------------------------------------------------------
        public void sessionCreated(HttpSessionEvent se) {
            /* Session is created. */
            num++;
            //让所有用户都能看到当前在线人数，将其存在application对象中
            ServletContext application =  se.getSession().getServletContext();
            application.setAttribute("num",num);
        }

        public void sessionDestroyed(HttpSessionEvent se) {
            /* Session is destroyed. */
            num--;
            //让所有用户都能看到当前在线人数，将其存在application对象中
            ServletContext application =  se.getSession().getServletContext();
            application.setAttribute("num",num);
        }

    ```

  + ```
    <h2>当前在线人数为${num}</h2>
    ```

+ 分类

  + 按照监听对象划分
    + 监听session对象，监听session的创建和销毁
    + 监听application对象，创建和销毁
    + 按照监听的动作划分
    + 监听对象的创建和销毁
    + 监听对象的属性的添加，移除，更改

+ session的销毁

  + 通过调用invalidate注销session
  + 达到有效非活动时间自动销毁

+ 生命周期

  + 当tomcat启动时创建，
  + tomcat关闭时销毁

### 03-web开发三大组件

+ Servlet
+ Filter
+ Listener
+ Servlet是必须要有的，Filter和Listener 是可选的
+ ​