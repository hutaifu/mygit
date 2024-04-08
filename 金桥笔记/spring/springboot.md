## SpringBoot框架

### 01-Spring的发展历程

+ xml配置文件阶段
  + 通过xml中的bean标签实现组件的管理
  + xml文件非常庞大
+ 注解+xml阶段 ssm
  + 使用注解替代一部分的xml配置
  + mybatis中的资源，视图解析器依然要使用xml形式
+ java配置类阶段
  + 使用java类替代xml文件
  + 在这样的java类之前会有@Configuration注解

### 02-SSM三大框架的搭建过程

+ 创建maven项目
+ 通过pom文件加载依赖
  + 我们自己去添加依赖，自己考虑版本
  + 容易出现jar包缺失，jar包版本冲突
+ 创建各种xml文件，用于扫描注解，用于创建组件
  + spring-mybatis.xml
  + springmvc.xml
+ web.xml
  + 注册servlet，加载spring的配置文件
+ 整合tomcat
+ 编写业务代码
+ 以上这些重复的繁琐的过程需要被精简，被整合，被封装
+ 能够通过更少的步骤实现一个项目的搭建
+ 引入依赖，可以有一个角色能够将所有必备的jar包全部引入，同时已经做好了版本的兼容测试，也帮我引入了依赖包的依赖包

### 03-springBoot框架

+ 该框架可以解决以上问题

+ 创建一个Springboot项目
  + 创建maven项目

  + 在pom文件中引入依赖

  + ```
        <!--继承的父依赖-->
    <!--    指定了里面的具体依赖的版本-->
        <parent>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.2.13.RELEASE</version>
        </parent>
        <!--web模块的依赖-->
    <!--    web场景启动器-->
        <!--指定了一个web项目所有需要的依赖，比如tomcat，springmvc-->
        <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
    ```

  + 创建一个启动类

    + 必须放在某个包下，不可以直接放在java目录下

    + ```
      @SpringBootApplication
      public class HelloApplication {
          public static void main(String[] args) {
              SpringApplication.run(HelloApplication.class,args);

          }
      }
      ```

    + 启动类前必须添加@SpringBootApplication注解

  + 以上步骤结束后，我们就搭建了一个整合了spirng框架和springmvc框架的项目

  + 可以去编写业务代码，比如创建controller类。

  + 启动项目，通过启动类的main方法，启动项目。

  + 该项目会在tomcat的8080端口上启动

    + 在springBoot框架中直接集成 了tomcat服务器。
    + 访问路径http://localhost:8080/资源名称

+ 优势

  + 对主流框架的集成，使得项目可以快速搭建
  + 内置了大量的开发自动化配置，省去了原先搭建环境时各种复杂的操作
  + 无序配置xml，无代码产生，开箱即用

### 04-springBoot原理解析-POM文件

+ pom主要作用，通过依赖标签，让maven去下载对应的依赖到项目中。
  + 下载依赖时，需要指定三个坐标
    + groupId
    + arifactId
    + version
+ parent标签  父依赖
  + 帮我们指定好了底层依赖的jar包的版本
  + 同时已经做好了版本的兼容性测试
+ web场景启动器
  + spring-boot-starter-web
  + 启动器，可以支撑某个场景正常运行的底层对象，内置了所有当前场景所需要的jar包
  + 引入启动器，就等于引入了当前场景的所有依赖。
  + SpringBoot封装了很多场景启动器，比如web场景，tomcat场景
  + 我们需要实现什么功能，就把对应的场景启动器引入即可。
  + 场景启动器中，只封装了spring这个家族体系中相关的依赖，以及不涉及第三方比如数据库的依赖。
    + 数据库驱动或者maybatis等框架springBoot没有封装

### 05-SpringBoot原理解析-主程序

+ 一般主程序都已Application结尾。

+ 必须添加@SpringBootApplication

+ 该注解下有三个正真起作用的注解

  + ```
    @SpringBootConfiguration
    @EnableAutoConfiguration
    @ComponentScan
    ```

  + 这三个注解可以直接替代@SpringBootApplication放在主程序之前，所有完全相同。

    + SpringBootConfiguration注解的作用：
      + 底层实现为@Configuration注解
      + 添加了@Configuration注解的类都可以看成是一个xml文件，用于创建对象管理对象。
      + 替代了原先的xml文件
      + SprignBoot提供了很多java配置类，用于创建我们需要通过xml创建出来的对象。
    + @EnableAutoConfiguration
      + 底层实现为@AutoConfigurationPackage，@import
      + 主要目的就是开启一个自带配置，程序一旦启动后，该注解负责让内存去加载所有的java配置类，读取到所有的组件，并且回初始化Spirng容器。将主键全部放到容器中，并继续自带装配。
      + 同时，会根据当前的开发场景，我们能回用到的组件并放到容器中。
      + 替代了原先代码中加载xml文件的中的过程。
      + 这是最核心的主键。
    + @ComonentSan
      + 用于扫描我们项目中所有的注解，创建组件并放到容器中
      + 相当于原来代码中的主注解扫描功能：
        + <contex:component-scan-package=：“com.jxd.stu.service”/>
        + 默认扫描的位置是当前主程序所在的包。
        + 所有controller，service包要放在主程序下面的包。

+ Spring配置类的开发方式

  + 首先创建实体类

  + 创建配置类，代表xml，在配置类中创建方法代表bean标签。

  + ```
    @Configuration
    public class DemoConfig {
        //当前类可以看成是一个xnm文件

        /*@Bean注解的方法可以看成是一个bean标签
        * 在该方法创建对象，并返回到容器中
        *
        * */
        @Bean(name = "demo")
        public Demo getDemo(){
            System.out.println("开始创建demo对象");
            Demo demo = new Demo();
            demo.setName("张三");
            demo.setAge(18);
            //返回给spring容器
            return demo;
        }
    }

    ```

  + 加载这些配置类，初始化spring容器，并且创建组件放到容器中

  + ```
    public class testConfig {
        public static void main(String[] args) {
            //去加载DemoConfig类，相当于以前读xml文件的操作
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);
            //以上代码结束后Spring容器被创建，同时demo组件被创建。

            Demo demo = (Demo)applicationContext.getBean("demo");
            System.out.println(demo.getName());
        }
    }
    ```

### 06-热部署

+ 热部署指的是程序在运行过程当中可以直接进行代码的修改或者程序的升级，无需停止服务，可以直接生效的功能。
+ 热部署实现步骤
  + 引入依赖
  + <!--热部署依赖-->
    ​    <dependency>
    ​        <groupId>org.springframework.boot</groupId>
    ​        <artifactId>spring-boot-devtools</artifactId>
    ​        <optional>true</optional>
    ​    </dependency>
  + 修改更新选项
    + file-setting-build-complier
    + 勾选build project  aotumatically 自带构建项目
    + 右上角修改启动类的更新选项
      + update classes and resources
+ 热部署原理
  + devtools中有两个类启动器
  + 一个类启动器，baseclassloader，用于加载读取编译程序中不会发生变化的类，所有jar包，只在程序启动时起作用
  + 另外一个类启动器，restartclassloader，用于加载程序中回发生变化的类，我们自己编写的类。
  + 程序运行状态下，如果代码进行了修改，那么只有restartclassloader启动器才会起作用，负责加载变化了的类。比之前加载全部的类效率要高。

### 07.springboot的配置操作

```
public class Demo {
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

```
@Configuration
public class DemoConfig {
    //当前类可以看成是一个xnm文件

    /*@Bean注解的方法可以看成是一个bean标签
    * 在该方法创建对象，并返回到容器中
    *
    * */
    @Bean(name = "demo")
    public Demo getDemo(){
        System.out.println("开始创建demo对象");
        Demo demo = new Demo();
        demo.setName("张三");
        demo.setAge(18);
        //返回给spring容器
        return demo;
    }
}
```

```
public class testConfig {
    public static void main(String[] args) {
        //去加载DemoConfig类，相当于以前读xml文件的操作
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);
        //以上代码结束后Spring容器被创建，同时demo组件被创建。

        Demo demo = (Demo)applicationContext.getBean("demo");
        System.out.println(demo.getName());
    }
}
```

### 08.整合Mybatis框架

+ 引入依赖

+ ```
         <!--数据库驱动-->
         <dependency>
             <groupId>mysql</groupId>
             <artifactId>mysql-connector-java</artifactId>
             <version>8.0.22</version>
         </dependency>
         <!--mybatis和SpringBoot整合模块-->
         <dependency>
             <groupId>org.mybatis.spring.boot</groupId>
             <artifactId>mybatis-spring-boot-starter</artifactId>
             <version>2.1.4</version>
         </dependency>
       </dependencies>
     <build>
         <resources>
             <!--让项目能够编译src目录下得xml文件-->
             <resource>
                 <directory>src/main/java</directory>
                 <includes>
                     <include>**/*.xml</include>
                 </includes>
                 <filtering>false</filtering>
             </resource>
             <resource>
                 <directory>src/main/resources</directory>
             </resource>

         </resources>
     </build>
     ```
  ```

+ 配置文件

+ ```
  #这个文件中我们需要使用YAML的标记语言
  server:
    port: 8082

  #指定数据源信息
  spring:
    datasource:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://127.0.0.1:3306/htf?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&allowMultiQueries=true
      username: root
      password: 123456


  ```

+ 实体类创建

+ dao接口/mapper接口已经mapper文件的创建

  + dao包
    + EmpMapper.java接口
    + mapping文件夹
      + EmpMapper.xml映射文件

+ service包：service接口和service实现类的创建

+ 需要让springBoot扫描dao包，创建dao的代理对象，放到容器中，service才能依赖到dao层对象，

+ ```
  @SpringBootApplication
  @MapperScan("com.jxd.hello.dao")//让springboot扫描dao接口，然后创建dao层对象，放到容器中
  public class HelloApplication {
      public static void main(String[] args) {
          SpringApplication.run(HelloApplication.class,args);

      }
  }
  ```

+ 注册映射文件，让mybatis能够识别到所有的sql语句，同时还需要设置实体类的别名，在application.yml中进行mybatis的配置

+ ```yaml
  #mybatis配置
  mybatis:
    #告诉mybatis框架映射文件的位置
    mapper-locations: classpath*:com/jxd/hello/dao/mapping/*.xml
    #指定实体类的别名
    type-aliases-package: com.jxd.hello.model
  ```

+ 测试

### 09-单元测试

+ Springboot整合单元测试

+ 单元测试的概念

  + 用一小段可以单独执行的代码来测试一个比较底层的单独的功能。
  + 测试路径短，可以快速进行bug的查找
  + 单元测试是精准测试某个功能，可以更加快速准确的定位bug的位置

+ 步骤

  + 引入依赖

  + ```
    <!--单元测试-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    ```

  + scope代表生效范围，只有我们去执行测试方法时，该依赖才会被加载

+ 在test目录下创建测试类，创建测试方法

  + 测试那一层的代码就注入哪一层的对象

  + ```java
    //这两个注解作用时让spring容易创建出来，并初始化所有组件，放到到容器中
    @RunWith(SpringRunner.class)
    @SpringBootTest(classes = HelloApplication.class)
    public class TestAplication {
        @Autowired
        private EmpMapper empMapper;
    ```


    //    测试方法要求无参无返回值，无静态
        @Test
        public void getEmp(){
            List<Emp> list = empMapper.selectAll();
            System.out.println(list.get(0).getEname());
    
        }
    }
    
    ​```
### 10-mybatis-plus

+ 简称MP框架，也是持久层框架，对JDBC进行了封装

+ 在Mybatis基础的基础上进行了增强，但是没有改变任何mybatis的使用方法，

+ 在引用了MP框架后，依然可以使用Mybatis方式实现数据的操作。

+ MP提供了强大的内置CURD操作，增删改查，已经实现了基于表单的增删改查操作

+ 内置了条件构造器，可以实现条件筛选。

+ 提供了很多插件，包含一个分页插件，可以不再编写sql。

+ 使用步骤

  + 引入依赖，Mybatis和MP的依赖在项目只能有一个

  + ```xml
    <!--        mybatis-plus的依赖-->
    <!--mybatisplus依赖包-->
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.4.3.4</version>
    </dependency>
    ```

  + 配置数据源

  + 创建实体类

    + 类名要和数据库表面完全一致
    + 属性名要和数据库的字段名称完全一致
    + MP会根据对应关系去数据库中查询对应的表和字段

  + Dao层

    + EmpMapper接口

      + 继承MP提供的父接口，从而继承父接口中的抽象方法

      + ```java
        public interface EmpMapper extends BaseMapper<Emp> {
        //该接口继承了MP提供的BaseMapper接口，就直接拥有了常用的增删改查抽象方法，都是从父接口继承过来的


        }
        ```

    + Mapper文件

      + 内置的增删改查的sql语句已经由MP默认提供，我们不需要再进行编辑。
      + 可以省略xml文件

  + service层

    + service接口

      + 继承MP提供的父接口，继承所有的抽象方法

      + ```
        public interface IEmpService extends IService<Emp> {
        }
        ```

    + service实现类

      + 需要实现我们自己定义的service接口，同时要实现里面的抽象方法

      + MP已经提供了这些抽象方法的实现，我们只需继承对应的父类即可

      + ```
        @Service
        public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

        }
        ```

        + ServiceImpl这个父类中是抽象方法的实现

  + 测试

    + 直接调用Service层的方法实现数据的操作即可。

    + ```java
      @RestController
      public class PlusController {
          @Autowired
          private IEmpService empService;

          @RequestMapping("/getEmp")
          public List<Emp> getEmp(){
              return empService.list();


          }
      }
      ```

    + MP提供的所有的增删改查都是针对单表操作的。

    + 如果要实现自定义的sql语句的编写，参考mabatis中的操作

      + 声明dao层抽象方法

      + 创建xml映射文件实现sql语句的编写

      + service和controller不变

      + 配置yml，告诉mybatis-plus的位置

      + ```
        #配置mybatis-plus
        mybatis-plus:
          #告诉MPSql再哪里
          mapper-locations: classpath*:com/jxd/plus/dao/mapping/*.xml
          #配置实体类别名
          type-aliases-package: com.jxd.plus.model
        ```

+ 注解

  + @TableName

    + 当数据库表名和类名不一致时使用

    + ```java
      @TableName(value = "emp_info")
      public class Employee {
          private int empno;
          private String ename;
          private String job;
          private String hiredate;
      ```

  + @TableID

    + 用于标识主键列，使用MP的跟新或者删除时，必须识别主键列

    + ```
      //用于标识主键列，保证删除和更新功能能够正常运行
      //type用于指定主键的生成策略，IdType.AUTO代表执行MP新增功能时，
      //主键使用数据库的自增功能
      //value属性用于对应数据库中的主键列名
      @TableId(value = "empno",type = IdType.AUTO)
      ```

    + value属性：对应数据库中的列名

    + type属性：主键的生成策略

  + @TableField

    + 用于标识普通列，当数据库列名和属性名不一致

    + ```java
      @TableField(value = "ename")
      private String ename;
      ```

+ 条件构造器

  + 现在没有xml文件，没有地方修改sql语句，如果想实现个性化查询，可以通过条件构造器是实现where子句的添加。

  + API

    + AbstractWapper：抽象父类
    + QueryWrapper：用于构造查询条件
    + UpdateWrapper：用于构造增删改的条件

  + 使用方式

    + ```
          @RequestMapping("/getEmp")
          public List<Emp> getEmp(){
              //创建条件构造器对象
              AbstractWrapper querWrapper = new QueryWrapper();
      //        querWrapper.eq("ename","小刚");
              querWrapper.like("ename","刚");
              return empService.list(querWrapper);
          }
      ```

    + ```
       @Test
          public void test01(){
              //多个条件的构造
              AbstractWrapper queryWrapper = new QueryWrapper();
              //where ename like '张' or job = 'clerk'
              queryWrapper.eq("ename","刚");
              queryWrapper.or();
              queryWrapper.eq("job","经理");

      //        queryWrapper.in("ename",)
              queryWrapper.orderByAsc("deptno");

              List<Emp> list = empService.list(queryWrapper);
              System.out.println(list.get(0).getEname());

          }
      ```

+ 内置的CURD方法

  + 参考官网

+ 分页插件

  + 步骤

    + 创建分页插件，交由spring容器管理

    + ```
      //利用当前这个类创建一个分页对象
      @Configuration
      public class MyBatisPlusConfig {
          public MybatisPlusInterceptor getMybtatisPlusInterceptor(){
              //创建插件对象，retrun到spring容器中
              //插件集合对象
              MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
              //创建分页插件,并指定要适配的数据库
              PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
              //将分页插件放到插件集合中
              mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
              //return
              return mybatisPlusInterceptor;
          }

      }
      ```

    + dao层接口声明方法时，需要指定参数IPage，同时返回IPage对象

      + ```java
        IPage<Map<String,Object>> getEmpWithDept(IPage<Map<String,Object>> page);
        ```

      + 参数是为了声明分页数据，当前页码和没页显示条数

      + 返回来的里面存储了当前页面的数据总条数

    + service层

      + ```
        IPage<Map<String,Object>> getEmpWithDept(IPage<Map<String,Object>> page);
        ```

      + 测试

      + ```java
        @Test
        public void testPage(){
            //利用page和limit构造page对象
            IPage<Map<String,Object>> page = new Page<>(1,5);
            //执行分页查询，返回page对象
            IPage<Map<String, Object>> pageRsult = empService.getEmpWithDept(page);
            List<Map<String,Object>> list = pageRsult.getRecords();

            long count = pageRsult.getTotal();

        }
        ```

      + ​