### 01-框架搭建

+ 创建maven项目
+ 通过pom文件下载依赖
  + 数据库驱动包
  + mybatis依赖
  + spring依赖
  + spirng整合mybatis依赖
  + springMvc依赖
+ 配置文件
  + db.properties
  + log4j.propertises
  + Spring_mybatis.xml
    + spring配置，管理了我们自己的资源和mybait中用到的资源
  + SpringMVC.xml
    + spring配置文件，管理了springmvc框架中的资源，视图解析器，文件解析器，
+ web项目配置
  + web.xml：由web服务器负责读取加载
    + 设置了编码字符集的过滤器
    + 注册了springMvc提供了前端分发器，一个大的servlet
    + 设置欢迎首页
+ 整合tomcat
  + tomcat负责发布项目

## 02-springMvc

+ 使用体验
  + 使用后台的controller类负责接收浏览器的请求
  + 后台的一个方法就可以对应一个请求
  + 请求参数的获取通过方法的形参接收，转换也可以自动
  + 以return返回值的方式做出响应
+ 访问过程
  + 首先浏览器输入http://localhost:8080/toLogin,回车
  + 这个请求会被前端分发器接收也就是SpringMVC提供Servlet接收到
  + 再由前端分发器根据具体的请求路径去后台controller中查找对应的请求方法
  + 对应的是后台@RequestMapping注解的路径，
  + 一个请求方法可以看成是一个处理器
  + 在处理器中，接收参数，调用service层方法，拿到返回值
  + 根据返回值向前台作响应
+ 和servlet的比较
  + 在传统的servlet中，我们要创建多个servlet接收不同的请求，springMVc一个大的servlet负责接收所有的请求，然后通过后台的一个请求方法处理一个请求。
  + servlet中通过request对象，单个接收参数，自己封装对象。Sprignmvc中通过形参直接接收参数，可以单个接收，也可以直接接收一个对象或者list，或者map。
  + servlet中的页面跳转通过转发或者重定向实现，springMvc是以return方式直接跳转，return的值就是前台页面的文件名。
  + servlet当中直接向浏览器响应数据，通过pringWriter对象。springMVc中通过@ResponseBody注解加在请求方法前，直接将对象或者list，或者map作为return返回值即可。
+ pringMVc是什么
  + 用于开发web项目一个组件，对原生的servlet中参数的获取，响应的方式等等进行了封装
  + 本质提供了一个大的servlet，用于接收前台所有的请求
  + 替代了我们原先的servlet，实现了请求的处理，以及对浏览器的响应。

### 03.-mvc架构

+ M，model，数据模型，代表用户所有数据
+ V，view视图，用户看到的界面，
+ C，controller，控制器，负责m和v之间的数据传输，将底层数据获取响应给页面或者将页面中的数据获取传递给底层
+ 所有web项目或者其他类型的软件（带页面的软件），基本上都是从MVC开发模式
  + 因为他们的本质都是数据的展示和数据的存储。
+ 因为数据模型和视图不能直接交互，所有都是通过中间的控制器负责数据的传输。
+ 在原生web项目中，servlet负责控制器的功能，在框架阶段，是由springmvc负责数据的接收和传递。

### 04-spring以及springmvc中的注解

+ @Component
  + 用在任意类之前，（实体类）除外。
  + 万能注解，作用是创建当前类在组件，放到spring容器
+ @Repository
  + 放在dao层实现类
+ @Service
  + 用在service实现类之前，作用同上，用于创建service层对象
+ @Controller，
  + 用在Controller类之前，作用还是创建对象。
+ 以上文件都需要在配置文件中配置扫描路径
+ @SessionAttributes("")
  + 将model中的数据set到session对象中。用在controller类之前，
+ @Autowired/@Resource
+ 用于某个类的成员变量前
+ 用于给这个成员变量赋值，从spring容器中找到对应的组件或者对象给这个成员变量赋值。
+ @RequestMapping（"/url"）
  + 用在controller中的请求方法之前，作用是将当前这个方法注解称为springmvc中的一个处理器对象，可以接收请求做出响应。

  + 还可以用在Controller类之前，单独添加一个url的前缀。

  + ```
    @Controller
    @RequestMapping("/stu")
    public class SprignMvcController {

    ```
+ @ResponseBody
  + 用在处理器方法前，作用是告诉springmvc当前方法要以响应流的方式向前台输出内容
  + 一般用在前台使用了ajax调用后台的情况
+ @RequestParam（”“）
  + 用在请求方法的形参之前，用于对应前台请求参数，一般用在前台请求参数名称和后台形参名称不一致的情况。
+ @RequestBody
  + 用在请求方法的形参之前
  + 一般用于接收前台的json数组字符串或者json对象字符串，在后台接收为list<泛型>或者list<map>，map。
+ @PathVarble
  + 用在请求方法的形参前，用于接收在url中以斜杠形式拼接的参数

### 05-springmvc对前台请求参数的封装

+ 原生servlet中就是通过request.getParameter()接收到字符串
+ 单个参数接收，
  + 只需要将形参名称和前台请求参数对应，可以接收为String和所有的基本数据类型及其包装类。当接收为String外的数类型时，要保证数据能过正常转换为对应的类型，比如接收了一个int，或者integer，那么要包证前台传递的数据必须是一个数字字符串，否则会出现400错误。
+ 接收为一个实体类对象，那么要包装前台的请求参数和后台的属性名一一对应。
+ 接收为map集合或者list集合
+ 如果前台传递的是普通json对象，后台接收为map要加@RequestParam
+ 前台请求参数是json字符串，后台接收成map时，需要添加@RequestBody
+ 接收为一个数组对象，前台请求参数为delEmp？sno=1&sno=2&sno=3
+ 那么后台可以直接接收为一个String[] sno数组或者int[] sno或者List<Integer> sno
+ 接收为List集合
  + 批量更新，前台向后台传递了一个json字符串
  + 后台可以接收为List<实体类> 或者ListL<Map>

### 06.springMvc向前台的响应

+ 响应一个页面
  + 请求方法前不用加@ResponseBody，默认方式
  + 本质响应了一个视图器
  + 如果需要向前台返回，使用Model存储
+ 向浏览器响应数据
  + 直接将数据返回给浏览器，底层实现为Printwriter响应流
  + 在请求方法前添加@ResponseBody注解
  + 可以返回的类型
    + String 对象类型，List，Map集合
  + 只有向前台响应单个字符串，并且是中文信息时，才需要设置produce属性，

### 07-SpringMvc资源间的请求

+ 如果需要从后台的一个请求方法跳转到另外一个请求方法，可以使用转发或者重定向。


  @Controller
  public class SprignMvcController {

      @RequestMapping("/hello")
      public String toWord(){
          System.out.println("hello");
          //跳转到另外一个请求方法中
          //重定向到world
          return "redirect:world";
    
          //转发到world
          //return "forward:world"
      }
    
      @RequestMapping("/world")
      @ResponseBody
      public String world(){
          return "hello world";
      }
  }

+ 重定向：return ”redirect：world“

  + 底层原理合web中重定向完全相同
  + 属于浏览器二次请求的行为

+ 转发：return：”forward：world“

  + 底层原理和我web中转发完全相同
  + 服务器内部的资源的调度

+ 如果方法的返回值为void

  + 当前请求方法结束后，控制权会回到请求该方法的位置去。

### 8.SpringMVC,中/和/*的区别

+ servlet


+ /用于匹配所有的/XXX的后台请求
+ filter
+ /*匹配所有的资源

### 9.ajax和json的应用

### 10-常见的错误

+ 400，参数封装错误，接收类型为String以为的类型可能出现，无法调试，只能看参数，比如前台传abc，后台接int，前台传手机号，后台接int，
+ 406，后台向前台响应的是list集合或者实体类对象，又在请求方法前加produces=”text/html;charset=utf-8“
+ 415,前台向后台传递json字符串，或者json数组字符串，但是没有设置ContentType属性
+ 后台的异常都会体现为500，
  + 空指针异常
  + sql异常
  + error creant bean：创建组件失败
    + 配置文件
  + 可以通过调试找到具体报错原因。

### 11.spirngmvc运行原理

+ 浏览器发送请求，被前端分发器DispatchServlet接收到
+ 签到分发器回去处理器映射器HanderMappingx对象中，去查询当前url所对应的处理器（请求方法），查询到的结果会被返回给前端分发器。
+ 前端分发器就将改请求分发给对应的处理器（请求方法）
+ 处理器接收参数，调用后台，作出响应。return结果。
+ 返回i结果会被spirngmvc封装为一个视图模型ModelAndbView，返回给前端分发器。
+ 前端分发器调用视图解析器解析改视图模型，找到对应的前台页面资源，
  + 会将model对象中的数据渲染到对应的内置文件中
+ 前端分发器拿到这个页面资源后，如果是静态文件，直接向浏览器响应，如果是动态资源，那么服务器进行翻译和编译，将结果响应给浏览器
+ 涉及到的组件
  + 前端分发器，servlet对象，负责接收所有的前台请求，再将请求分发出去
  + 处理器映射器，里面存储了所有的url和处理器的映射关系，路由。
  + 处理器，真正处理请求的对象，对应的是我们的请求方法。接收参数，调用后台，做出响应
  + 处理器适配器，在处理器外面包装了一层适配器，让处理器可以接收不同的请求。
  + 视图解析器，用于解析视图模型的。
+ 后台所有的请求方法的注解路径都不可以重复，他们都是被服务器映射器统一管理。