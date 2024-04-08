+ 00-Maven工具
+ 下载jar包
+ 下载项目依赖
+ jar包中一堆class文件
+ java框架都是有maven负责下载
+ 数据驱动包，日志包，
+ 只能下载开源的jar包
+ 默认从中央仓库下载，下载到本地仓库中
+ 镜像 阿里云下载jar
+ 私服，公司内部的服务器，不对外开放
+ pom文件
+ 01mybatis框架
+ 持久层框架
+ 数据持久化：java数据和数据库数据来回转换的过程
+ JDBC标准语法实现了数据持久化
+ JDBC是在dao层实现
+ 封装了JDBC连接数据库操作数据库的繁琐过程
+ 最大好处：将SQL语句从java代码中解耦，单独的mapper文件实现sql的编写
+ 提供了很多动态的sql标签，实现sql的拼接功能
+ 执行原理
  + sqlSessionFactory  会话工厂  相当于连接池
  + splSession  会话对象 java程序和数据库之间的连接通道 相当于Connection对象
  + 在mapper文件中可以写的标签
    + select
    + insert
    + update
    + delete
    + 后三中本质就是一种，都是update

02-spring框架

+ web容器负责servlet相关对象的创建
+ spring容器负责项目中dao层资源，service层资源，controller资源，mybatis中用到的所有资源
+ 负责对象的创建和销毁，初始化等等
+ 核心思想
  + 控制反转
    + 以前是我们自己创建对象，现在是容器帮我们创建对象
    + xml：<bean>
    + 注解：@Service servlet实现类，@Controller
    + Spring会扫描注解，然后创建这个类的对象
   + 依赖注入
        + 本质就是给某个对象的属性赋值
        + 从容器中找到一个合适的对象赋值给了某个对象的属性
        + xml：<property>
        + 注解：@Autowried  @Resouce

03-Spring-mybatis

+ 整合的本质就是由spring容器赋值管理mybatis这个框架的资源
+ 比如数据源，会话工厂等

04-Springmvc框架

+ ​

05-ssm框架整合

+ spring和mybatis整合
+ springMvc，是spring中的一个web模块
  + 本质还是spring框架，在配置文件中创建了一些springMvc中的一些对象
+ web.xml
  + 注册了一个前端分发器，本质就是一个servlet
  + 能够接收浏览器的请求并对浏览器做出响应
  + ​