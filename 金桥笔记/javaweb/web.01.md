### 01-软件分类

+ 操作系统：系统软件：software
+ 驱动软件：driver
+ 客户端软件：微信、qq、迅雷、百度网盘、wps
+ 通过浏览器访问的软件：百度、12306（网页）、



+ C/S架构软件
  + client/server,客户端/服务器软件
  + 需要在电脑上安装客户端程序，通过客户端去访问服务端的数据
  + 优点
    + 访问完全性较高，因为每个客户端都是针对一位用户服务。
    + 访问速度较快，因为有些数据是缓存在客户端的，相当于是本地访问
  + 缺点
    + 必须安装客户端
    + 客户端程序升级，用户需要重新下载安装
    + 开发两套程序，
+ B/S架构软件
  + brower/server，浏览器/服务器
  + 通过浏览器访问的软件都属于bs架构
  + 通过浏览器去访问服务器上的数据
  + 优点：
    + 不需要安装任何客户端，可以直接访问服务器的数据
    + 程序升级时，用户无需任何操作
    + 只需开发一套服务端的程序
  + 缺点：
    + 依赖网络的，没有网络无法访问
    + 访问数据的速度受到网速影响
    + 信息不够安全

### 02-web资源

+ 通过浏览器访问到来自于服务器的所有信息，我没都称之为web资源
  + 图片，文字，数据信息+
+ 静态资源：
  + html，css和JavaScript开发的网页以及所使用的动态效果都是固定的，不会随着访问人的不同而发生变化。
+ 动态资源
  + 会随着登陆人或者登录时间的不同，展示不同的页面数据或者页面效果
  + 这些效果都是由java代码实现，（jsp，servlet）
+ 浏览器访问服务器的资源
  + 访问静态资源，网址后缀是html，服务器会将这个资源直接响应给浏览器
    + 因为浏览器可以直接解释执行静态资源
  + 访问动态资源，网址后缀是jsp，servlet，这些资源本质都是Java，浏览不认识java，在服务端，需要一个可以认识java可以运行Java程序的一个介质，将这些信息翻译成浏览器认识的html等资源，再发送给浏览器，浏览器可以看到动态的数据。
+ jdk可以编译运行java程序，他的结果无法直接给浏览器，我们需要另外一种叫web服务器的中间件，可以将java中的数据结果转换为浏览器认识的静态资源，并发送给浏览器。

### 03-web服务器

### 为什么需要web服务器

+ 首先我没需要这样一个介质，中间件，帮我们把后台的相关数据或者信息转换为浏览器认识的静态资源，以便浏览器可以正常的解释执行，展示效果。
+ 我没现在所有的程序都是在本地创建，只有我们自己可以访问，其他人没有入口可以访问。如果需要将资源共享，允许同一网络内的其他电脑来访问的话，我们也需要这个web服务器
+ 这个web服务器会在电脑上占用一个端口，其他的电脑通过ip：端口的形式就可以访问到这个服务器，进而访问到这个服务器上的资源。

### 访问资源的方式——URL

+ uniform resource location ，统一资源定位符，浏览器的网址
+ 格式：http://ip:port/资源名称
  + http：超文本传输协议，规定了浏览器和web服务器之间数据传输格式
  + ip：主机地址，安装了web服务器的那部电脑ip
  + port：端口，web服务器占用的端口
  + 资源名称：html，jsp，png

### 什么是web服务器

+ 用于完成浏览器和服务器之间的数据通信的程序。
+ 可以接浏览器的数据，可以将服务器的数据（数据库的数据）发送给浏览器

### web服务器的作用

+ 可以接收浏览器发送的请求，浏览器几乎所有的动作都是在向服务器发送请求，比如查询的请求，新增的请求，删除的请求。
+ 可以将后java的执行结果，相应给浏览器。
+ bs架构的软件，都是浏览器发请求，服务器接收请求并响应。
+ 数据通信的主动方都是浏览器。



### 常见的web服务器

+ tomcat  开源服务器
+ weblogic 收费服务器 大型项目
+ jBoss  收费
+ websphere  收费

### 04-Tomcat服务器

+ 解压到非中文目录下即可

+ 启动服务

  + 点击bin目录下的startup.bat，会出现启动窗口
  + 没有报错，并且提示了服务在多少ms内启动，说明tomcat服务正常启动

+ 访问：

  + http://127.0.0.1:8080
  + 可以访问到tomcat默认首页
  + 8080是tomcat默认端口

+ 端口修改

  + 提升报错：address aready in use

  + 端口冲突

  + conf目录下server.xml中找到,修改port属性值即可

  + <Connector port="8080" protocol="HTTP/1.1"
    ​               connectionTimeout="20000"
    ​               redirectPort="8443" />

    +

+ 服务关闭

  + bin目录下的shutdown.bat

+ 目录

  + 根目录
    + bin：startup.bat用于启动 tomcat，shutdown.bat
    + conf：server.xml修改端口
    + lib：jar包
    + logs：日志
    + webapps：放要发布web资源的目录，html，java
    + work：项目运行时产生的中间文件

### 05-webproject 

+ 所有的资源（静态和动态资源都在web项目下创建），将这个web项目发布到tomcat中
+ tomcat启动后，这些资源就可以被浏览器访问到了
+ 目录结构
  + src：源码目录
    + 存放所有的java文件
    + 动态资源
  + web：静态资源
    + WEB-INF
      + web.xml
    + html、css、js
+ 引用的外部jar包
  + jdk
  + tomcat
  + ​

