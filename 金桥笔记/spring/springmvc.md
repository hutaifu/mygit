### 1.简介

+ springMVC就是一个大大的servlet
+ 在javaweb阶段，每一个请求都要写一个servlet去处理，但是使用springMVC可用用Controller代替Servlet，Controller每一个方法都能处理一个请求，相当于一个servlet

### 2.使用springMVC

+ 1.导入依赖

+ 2.配置web.xml

+ 3.添加主配置文件springMVC.xml

  + 需要改动的是扫描web相关的bean

  + ```
    <!--扫描web相关的bean-->
    <context:component-scan base-package="com.jxd.emp.controller"/>
    ```

+ 4.创建Controller层和类，并添加注解和方法

  + ```
    /*
    * @Controller
    * springmvc提供的注解，可以创建Controller对象
    *
    *
    * */
    @Controller
    public class TestController {

        /*
        * 接收请求，其参数是请求的url
        *@RequestMapping，默认参数是value = url
        *属性produces 用于设置响应流相关
        *
        * */
        @RequestMapping(value = "/hello",produces = "text/html;charset=utf-8")
        public String hello(){
            //当不做任何处理时，方法返回字符串，实际上是请求字符串的资源。
            return "index.jsp";
        }
    ```


        /*
        * 如果希望以流的方式响应给前台就要添加@ResponsBody
        *
        * */
        @RequestMapping("/sayHello")
        @ResponseBody
        public String sayHello(String name){
            return "Hello "+name + "springmvc";
    
        }
    }
    ​```

### 3.注解

+ Controller
  + 注解在Controller类上，将类注解为一个后端控制器，表示创建控制器对象，将对象放在springmvc容器中
  + 该类中的每一个方法对应一个请求，这个方法自定义，可用有多种返回值类型，多种参数
+ @RequestMapping
  + 请求映射，表示哪个url到方法上
  + 一个请求要给方法
  + value属性，默认的属性，表示请求的url地址，value必须是唯一的以”/“开头
  + produces属性，设置返回值的编码格式，只能通过输出流向浏览器输出含有中文的内容时设置
+ @ResponseBody
  + 如果只有@RequesMapping，返回值会被解析为跳转页面
  + 如果返回值被解析为响应流，可用添加@ResponseBody注解
  + 一般会在ajax请求中，可用返回文本，也可以返回json数据

### 4.视图解析器

+ jsp页面放在webapp目录下可以直接被外界访问到，不安全

+ WEB-INF文件夹时私有文件夹，只有服务器内部可以访问，把jsp页面放在这个文件夹中会更安全

+ 但是每次访问将商品页面都要写前后缀

+ 配置视图解析器，可以减少代码量

+ ```
  <!-- 支持返回json end -->
  <!--配置jsp的视图解析器-->
  <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
      <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
      <property name="prefix" value="/WEB-INF/view/"/>
      <property name="suffix" value=".jsp"/>
  </bean>
  ```

### 5.案例一：使用ajax登录，并将用户名存储在session中

+ 前台传输json对象，后天以简单类型参数接收

+ ```
  <script>
      $(function () {
          $("#login1").click(function () {
              $.ajax({
                  url:"/login",
                  data:{
                      username:$("input[name=username]").val(),
                      password:$("input[name=password]").val()
                  },
                  type:"post",
                  dataType:"text",
                  success:function (res) {
                      alert(res)
                  },
                  error:function () {
                      alert("服务器访问失败")
                  }
  ```


              })
          })
      })


  </script>
  ```

+ ```
  /*
  * 前台以ajax的方式传输了一个json对象，后台接参时，形参要与json中个对象名对应
  *
  *
  * */
  @RequestMapping(value = "/login",produces = "text/html;charset=utf-8")
  @ResponseBody
  public String login(String username, String password, Model model){
      if ("admin".equals(username) && "123".equals(password)){
          model.addAttribute("username",username);
          model.addAttribute("password",password);
          return "登录成功";
      }else {
          return "登录失败";
      }


  }
  ```

+ 后台方法的参数名要和前台传过来的json对象属性一致

+ 如果要存储在session中，需要使用Model对象

  + 在Controller上添加注解@SessionAttributes，就会将model中同名属性存储到session中

  + ```
    * */
    @Controller
    @SessionAttributes({"username","password"})
    public class TestController {
    ```


### 案例二:前后台参数不一致

+ 前台传json对象，后台还是以简单类型接收，只是参数名和json对象不一致


+ ```java
  /*
  * 前台发送的json对象的属性，应当与后台形参名一致，如果不一致， 匹配不上的参数只能拿到null了，
  *(@RequestParam可以接收前台指定属性的值赋给形参
  * */
  @RequestMapping(value = "/login2",produces = "text/html;charset=utf-8")
  @ResponseBody
  public String login2(@RequestParam("username") String uname, @RequestParam("password") String pwd){
      if ("admin".equals(uname) && "123".equals(pwd)){
          return "登录成功";
      }else {
          return "登录失败";
      }
  }
  ```

+ ```javascript
  data:{
      username:$("input[name=username]").val()
      password:$("input[name=password]").val()
  },
    
  ```

##案例三：使用实体类作为方法形参

+ 前台传json对象，后台用实体类接收
+ json对象的属性和实体类的属性对应上就可以赋值
+ 这是springmvc自动帮我们封装的


+ ```
  @RequestMapping(value = "/login3",produces = "text/html;charset=utf-8")
  @ResponseBody
  public String login3(Emp emp,Model model){
      model.addAttribute("emp",emp);
      return "报存成功";

  }

  ```

### 案例四，使用表单自带的提交功能发起请求

+ 在form标签的action属性添加请求地址

+ 表单元素的name属性与后台参数名匹配上时可自动赋值

+ 或者与实体类属性名匹配上时可自动封装为实体类

+ ```
  @RequestMapping(value = "/login4",produces = "text/html;charset=utf-8")
  @ResponseBody
  public String login4(String username,String password){
    return "报存成功";

  }
  ```

### 案例五，批量新增

```
$(function () {
    //批量新增员工
    var emps = [
    {
        empno:1, ename:"喜羊羊",job:"科学家",hiredate:"2000-01-02"
    },
    {
        empno:1, ename:"喜羊羊",job:"科学家",hiredate:"2000-01-02"
    },
    {
        empno:1, ename:"喜羊羊",job:"科学家",hiredate:"2000-01-02"
    }
    ]
    $("#addBat").click(function () {
        //先把json数组转换成json字符串
        //默认的提交方式是json格式，要将其改为json字符串
        //注意如果使用json字符串，提交方式必须为post
        $.ajax({
            url:"addBatch",
            type:"post",
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify(emps),
            dataType:"text",
            success:function (res) {
                alert(res)
            },
            error:function () {
                alert("服务器执行失败")
            }
        })
```

+ 从前台向后台传递一个json字符串

+ 注意：比之前传json对象多了几个步骤，

  + 1.将json转换为字符串

  + 2.contenType属性设置json字符串的解析方式

  + 3.如果添加了contentType，提交方式必须为post。

  + 4.使用@RequestBody，注解将其封装为一个集合

  + ```
    @RequestMapping(value = "/addBatch",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addBatch(@RequestBody List<Emp> emps){
        for (Emp emp:emps){
            System.out.println(emp);
        }
        return "新增成功";
    }
    ```

### 案例六占位符传参

+ ```
  //在地址栏拼接数据可以采用/login5?key=value1&key2=value2
  $("#login5").click(function () {
      var user =  $("input[name=username]")
      var pwd = $("input[name=password]")
      $.ajax({
          url:"/login5/" + user + "/" + pwd,
          type:"post",
          dataType:"text",
          success:function (res) {
              alert(res)
          },
          error:function () {
              alert("服务器访问失败")
          }
      })
  })
  ```

+ ```
  //   /login5/admin/123
      @RequestMapping(value = "/login5/(uname)/(pwd)",produces = "text/html;charset=utf-8")
      @ResponseBody
      public String login5(@PathVariable("uname") String username,@PathVariable("pwd") String passwrod){
          if ("admin".equals(username) && "123".equals(passwrod)){
              return "登录成功";
          }else {
              return "登录失败";
          }
  }
  ```

+ @RequestMapping的url的{}中的值必须和@PathVariab的参数一致。