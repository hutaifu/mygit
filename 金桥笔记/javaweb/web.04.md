## JSP

### 01-为什么使用JSP

+ servlet可以访问到后台数据，也可以将后台数据以PrintWriter输出流方式展示到浏览器，但是如果展示的内容较多，或者较为复杂时，利用输出流的方式效率太低。
+ JSP，也是一种动态资源，可以访问后台数据，并且页面展示直接在JSP中写Html，css，和js即可。

### 02-JSP的定义及使用

+ JSP中可以包含的内容

  + 静态内容：html，css，JavaScript

  + 指令：jsp最开始必须存在的一句话

    + ```
      <%@ page contentType="text/html;charset=UTF-8" language="java" %>
      ```

  + page指令：

    + contentType：jsp向浏览器展示内容的类型和编码字符集
    + language：jsp中可以编写的语言，或者jsp运行时以java方式运行
    + import：用于引入某个java包

  + page指令可以有多个

  + 只有加了page指令的jsp，才能被web服务器正常进行

  + java小脚本

  + ```
    <%--    java小脚本--%>
        <%
            //jsp页面访问时，依次执行
        String name = "admin";
        List<String> list = new ArrayList<>();
        list.add(name);
            System.out.println(list.get(0));



        %>
    ```

    + <%%>分隔符，隔开了java代码和html代码
    + 可以出现多次，可以出现在任意位置

  + java表达式的输出

  + ```
    <%--表达式的输出--%>
    <%--将name变量输出到html中--%>
    <%--类似servlet中的pw.printlin操作--%>
        <%=name%>

    ```

  + 在java小脚本中定义的所有变量都可以通过表达式的方式输出到浏览器

+ java方法或者变量的声明

+ ```
  <%--java方法或者变量的声明--%>
  <%!
      public void show(){
          String str = "hello";
          System.out.println(str);
      }
  %>
  ```

  + 声明的方法可以在小脚本中直接使用

  + ```
    <%
    show();
    %>
    ```

+ jsp的注释

  + <%--  --%>jsp中的注释:浏览器不可见
  + <!--  -->html中的注释 ：浏览器可见
  + 但凡是浏览器能够认识的代码，我们在F12中都可以看到
  + 浏览器不认识的语法，比如<%,F12中不可见

+ jsp的主要功能

  + 通过java代码访问后台数据
  + 通过html结合<%=%>表达式语法实现动态数据的展示

### 03-运行原理

+ 浏览器不认识jsp
+ jsp由服务器负责执行
+ 浏览器通过url请求jsp的资源
+ 服务器接收到这个请求，会判断当前资源是静态还是动态的
+ 服务器识别的这是一个jsp资源时，会对该资源进行处理
+ 服务器中有一个jsp引擎，专门负责执行jsp文件的对象
+ jsp引擎会将jsp文件翻译成为java文件
+ jvm负责编译java，原后生成class二进制，运行二进制文件。
+ 生成后代文件：
  + tomcat部署当前项目所生成的目录下的work文件夹中
+ jsp运行三步走：翻译--》编译--》运行
+ 只有第一次访问jsp时或者jsp发生变化时，才会经过三个步骤
+ 如果访问过之后，属性网页，会直接运行之前生成的class二进制文件

### 04-JSP的内置对象

+ 当我们访问JSP时，web容器会负责创建一些对象，在JSP可以直接访问
+ jsp九大内置对象
  + 浏览器请求jsp时，web容器会创建请求和响应对象，通过参数传递到
  + request对象
  + response对象
  + page对象 ==》当前这个jsp对象，就是this
  + pageContex对象 ==》还是这个页面对象，用于调用各种方法实现功能
  + config对象：对应的jsp配置对象，但是jsp没有配置信息，config几乎不用
  + exception对象：异常对象，正常的jsp没有这个对象，如果将jsp定义为一个错误页面，page指令中isErroPage属性，设置该属性为true，那么jsp就会有exception对象
  + session对象：会话对象，某个浏览器和服务器之间的一次访问过程。
  + application对象：应用对象，对应servletContext全局对象
  + out对象：用于向浏览器输出内容