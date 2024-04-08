### 1.spring概述

+ Spring框架，是一个项目管理框架，可以看作一个容器，用来管理bean创建对象，给对象赋值）
+ Spring方便解耦，（模块和模块之间，类之间的解耦，简化开发）
+ Spring方便继承各种框架，比如Mybatis，SprignMVC，
+ Spring提供了面向切面编程AOP

### 2.使用Spring

+ 传统方式创建对象

  + Hello hello = new Hello（）；
  + IEmpDao empDao = new EmpDao；
  + 每次都要通过new关键字自己创建

+ 使用Spring创建对象

  + 引入依赖

  + 创建类，Hello

  + 添加Spring的配置文件

    + new==》XML Configurationg ==》Spring Config

    + ```
      <!--
        注册bean，就是将这个类的创建交给Spring
        id，自定义的对象名，唯一值，Spring通过id值找到对象
        class,类的全限定名称，表示创建哪个类的对象
        整个bean的标签相当于Hello hello = new Hello();
         -->
          <bean id="hello" class="com.jxd.emp.model.Hello"></bean>
      </beans>
      ```

    + 注意：class 不能写抽象类或接口

    + 一个bean标签能创建一个对象

    + Spring容器初始化的时候，（加载配置文件的时候）就会被创建。

    + 测试

    + ```
         @Test
          public void testHello(){
              //Tomcat 不光是容器，还是服务器，服务器一启动，就会读配置文件，
              //Sring只是容器，要手动读配置文件
           //        1.创建Sring容器
              String config = "spring.xml";//resources目录文件会直接出现在类路径下
              //创建spring容器是，加载配置文件==会根据bean的配置信息创建对象
              ApplicationContext context = new ClassPathXmlApplicationContext(config);
              //2.找spring容器要一个对象
              Hello hello = (Hello)context.getBean("hello");
              //3.调用对象的方法进行测试
              hello.show();
          }
           }
         ```

      ```

    + 使用Sring也可以以管理非自定义对象

    + ```
      <bean id="date" class="java.util.Date"></bean>
      ```

    + 创建的日期对象是当前系统时间

    + Spring容器在创建对象时调用的为对象的无参构造方法，如果没有，则会保错。

### 4.Spring的核心思想之控制反转IOC

+ IOC inverse of control
+ 传统程序中，对象通过new由应用程序创建，对象就是资源，资源的创建权控制在应用程序手中，
+ 应用了Spring之后，对象由Spring容器来管理（创建对象，给对象属性赋值），这样就不用通过new关键字来创建对象，而是由Spring容器根据配置文件来创建对象，这种思想就是控制反转，简单来说，就是对象的创建权从应用程序手中转移到Spring容器中，由Spring来管理。
+ 正转：应用程序通过new关键字来创建对象
+ 反转：由容器代替开发人员创建对象

### 5.什么是容器

+ 用来管理对象，从创建到使用到销毁，即管理对象的生命周期
+ Tomcat容器管理servlet，filter，listener的生命周期
+ Tomcat的IOC的体系：创建servlet类之后，在web容器中注册servlet，使用servlet时，没有通过new来创建对象，而是由tomcat帮我们创建的
+ Spring保证我们管理项目中的资源或对象，我们需要的实例都是可以由Spirng帮我们创建的，所以Spring也是一个容器

### 6.Spring核心思想之依赖注入DI

+ DI dependency Injection

+ 类和类之间的关系，

  + 继承，is-a 子类继承父类
  + has - a 在一个类中需要另一个除String引用数据类型类的对象作为该类的属性
  + 实现依赖注入，有两种方式，基于XML的DI，在Spring的配置文件中使用标签和属性完成
  + 使用Spring的注解，基于注解的DI，完成属性的赋值

+ 使用set方式给属性赋值。

+ 使用构造方法赋值

+ ```
      <bean id="dept" class="com.jxd.emp.model.Dept">
  <!--        <property>能给对象的属性赋值，name，属性名，value属性值
  通过value给简单类型属性赋值，值是死的
  -->
          <property name="deptno" value="1"></property>
          <property name="dname" value="行政部"></property>
      </bean>
      <bean id="emp" class="com.jxd.emp.model.Emp">
          <property name="empno" value="1"></property>
          <property name="ename" value="小时"></property>
          <property name="job" value="保安"></property>
          <property name="hiredate" value="2021-10-09"></property>
  <!--        emp的属性dept不是简单类型，不能之间赋值，emp依赖于dept，需要进行依赖注入，
  也就是Spring容器将要创建的dept对象交给emp使用，给emp的属性dept赋值
  ref 依赖注入所使用的属性，用于给引用数据类型的属性赋值，指向一个装配好的bean
  其值为这个bean的id
  -->
          <property name="dept" ref="dept"></property>
      </bean>
  <!--    可以给一个类创建多个bean，但是在正真项目中不会这样做-->
  <!--    使用构造方法给属性赋值，index表示构造方法中形参的下标，从零开始
          name，构造方法中的形参名
          value，简单类型赋值
          ref，引用类型赋值，另一个bean的id
  -->
      <bean id="emp2" class="com.jxd.emp.model.Emp">
          <constructor-arg name="empno" value="2"></constructor-arg>
          <constructor-arg name="ename" value="小霞"></constructor-arg>
          <constructor-arg name="job" value="文员"></constructor-arg>
          <constructor-arg name="hiredate" value="2010-9-9"></constructor-arg>
          <constructor-arg name="dept" ref="dept"></constructor-arg>
      </bean>
  ```

+ 第一种要保证类的set方法可用，否则Spring文件会报错

+ 第二种，要保证有匹配的构造方法，否则Spring文件会报错

  + 使用spring进行分层开发，项目种不会让spring管理实体类，而是使用spring管理dao，service，servlet，controller

  + EmpDao

  + ```
    public boolean addEmp(Emp emp) {
        return true;
    }
    ```

  + ```
    boolean addEmp(Emp emp);
    ```

  + 在配置文件种注册bean，使用spring容器创建dao层类对象

  + ```
    /**
     *
     * @param emp
     * @return
     */
    boolean addEmp(Emp emp);
    ```

  + ```
    public class EmpServiceImpl implements IEmpService {
    //  private IEmpDao empDao = new EmpDaoImpl();
        private IEmpDao empDao;
    ```


        /**
         * @param emp
         * @return
         */
        @Override
        public boolean addEmp(Emp emp) {
            return empDao.addEmp(emp);
        }
    
        public IEmpDao getEmpDao() {
            return empDao;
        }
    
        public void setEmpDao(IEmpDao empDao) {
            this.empDao = empDao;
        }
    }
    
    ​```

  + ```
    <bean id="emp2" class="com.jxd.emp.model.Emp">
        <constructor-arg name="empno" value="2"></constructor-arg>
        <constructor-arg name="ename" value="小霞"></constructor-arg>
        <constructor-arg name="job" value="文员"></constructor-arg>
        <constructor-arg name="hiredate" value="2010-9-9"></constructor-arg>
        <constructor-arg name="dept" ref="dept"></constructor-arg>
    </bean>
    <bean id="empDao" class="com.jxd.emp.dao.impl.EmpDaoImpl">

    </bean>
    <bean id="empService" class="com.jxd.emp.service.impl.EmpServiceImpl">
        <property name="empDao" ref="empDao"></property>

    </bean>
    ```

  + 在spring配置文件种配置bean，由spring来创建service对象，这个对象有个依赖empDao，需要spring通过依赖注入给它emp赋值

  + 测试

  + ```
    public void testAddEmp(){
        String config = "spring.xml";//resources目录文件会直接出现在类路径下
        //创建spring容器是，加载配置文件==会根据bean的配置信息创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        IEmpService empService = (IEmpService) context.getBean("empService");
        boolean isSucee = empService.addEmp(new Emp());
        System.out.println(isSucee
        );

    }
    ```

+ 依赖注入：通俗来说，就是在程序运行过程种spring动态的向某个对象提供需要的对象。

+ 把这个有依赖关系的两个或者多个对象进行解耦。

+ 控制反转和依赖注入是从不同的方面描述spring核心思想，应用程序需要的对象不再由应用程序创建，而是由spring创建，对象的依赖属性不是由自己创建，而是由spirng创建

### 7.spring的注解开发模式

+ 1.导入依赖

+ 2.创建spring.xml配置文件

  + 声明组件扫描器

  + ```
    <!--
        声明组件扫描器，组件就是java对象
        base-package，指明注解在项目中的位置
        spring会扫描base-package指定包以及子包下所有的类型类，找到相关注解
        按照注解的功能创建对象或者属性赋值
    -->
    <context:component-scan base-package="com.jxd.emp"></context:component-scan>
    ```

+ 3.在类上添加注解(控制反转)

  + @Component  注解在除了dao，service，controller层之外的其它类上

  + ```
    @Component("emp")
    public class Emp {
        private Integer empno;
        private String ename;
        private String job;
        private String hiredate;
        ···
        }
    ```

  + 注解的参数是对象名，不写参数时，默认首字母小写

  + 相当于

  + ```
    <bean id = "emp" class = "com.jxd.emp.model.Emp">
    ```

  + 其属性没有赋值，都是null

  + 注解创建出的对象都放在spring容器中，由spring管理

+ @Repository 注解在dao层实现类上

  + 相当于<bean id = "empDaoimp" class = "com.jxd.emp.dao.empDaoImpl">

  + ```
    @Repository
    public class EmpDaoImpl implements IEmpDao {
        @Override
        public boolean addEmp(Emp emp) {
            return true;
        }
    }
    ```

+ @Service

+ ```
  /*
  * @Service创建Service类实现对象
  * <bean id = "empServiceImpl" class = "com.jxd.>
  * */
  @Service
  public class EmpServiceImpl implements IEmpService {
  ```


      /*
      * 用于依赖注入的注解
      * <property name = "empDao" ref = "empDao">
      默认注入方式为byType，Spring容器会查找改类型的对象，类型匹配上就可以注入进来@Repository 以经创建改类对象，然后注入
      * */
      @Autowired
      IEmpDao empDao;
      /**
       * @param emp
       * @return
       */
      @Override
      public boolean addEmp(Emp emp) {
          return empDao.addEmp(emp);
      }

+ @Controller 注解在Controller层

4.在属性上添加注解，依赖注入

+ Autowired 实现引用数据类型的赋值，是spring提供的注解

+ 默认注入方式为byType，如果一个接口有多个实现类，就会注入失败，所有这个时候需要Byname根据id查找bean

+ ```
  @Autowired
  @Qualifier("empDaoImpl")
  IEmpDao empDao;
  ```

+ 添加@Qualifier(),注解后，改为通过id注入

+ @Resource ，jdk提供的注解，页支持byType，默认方式为byname

+ ```
  @Resource(name = "empDaoImpl")
   IEmpDao empDao;
  ```

+ spring会在spring容器中寻找根name属性同名的对象注入进来，如果name缺省，会按照属性名进行查找和注入。

+ 如果byname没有找到对应对象，就会按照byType方式取查找。

### 8.spring整合mybatis

+ 1.导入依赖

+ 2.添加配置文件db.properties和spring-mybatis.xml

  + spring帮我们创建了一些mybatis对象
  + 注意修改别名路径
  + 扫描映射文件.路径以/分隔
  + 自动扫描dao接口的路径
  + 业务逻辑层的bean路径

+ 3.mybatis需要mapping文件夹和与接口对应的mapping.xml文件

+ 4.spring需要给类和属性添加注解@Service，@Controller，@AutoWired

+ 5.测试

+ ```
  public class Test01 {

      @Test
      public void testAddEmp(){
          Emp emp = new Emp(null,"小刚","经理","2014-10-08");
          //1.配置文件
          String config = "spring-mybatis.xml";
          //创建容器
          ApplicationContext context = new ClassPathXmlApplicationContext(config);
          //3.问spring容器要对象
          IEmpService empService = (IEmpService)context.getBean("empServiceImpl");
          boolean isSucess = empService.addEmp(emp);
          if (isSucess){
              System.out.println("插入成功");
          }else {
              System.out.println("插入失败");
          }

      }
  }

  ```