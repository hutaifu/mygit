###1.三层架构

+ 视图层：向用户展示内容，收集用户的数据，与用户进行交互
  + html，jsp，servlet
  + controller层 ···springMVC
+ 业务逻辑层：处理具体的业务功能
  + service层	···spring
+ 数据访问层（持久层）：和数据库打交道，进行数据库处理，被业务逻辑层调用
  + dao层···Mybatis
+ 视图层----》业务逻辑层---》数据访问层---》数据库

### 2.jdbc回顾

+ jdbc开发的困扰
  + 需要自己建立连接，一旦url发生改变，需要修改程序：
  + 需要自己拼接sql，拼接过程容易出错
  + 需要自己创建执行spl的Ststement对象，自己执行sql
  + 需要自己对sql的结果集进行遍历，取数据并进行封装
  + 需要自己关闭资源，并对异常进行处理说明
  + jdbc操作数据库与java程序存在高度耦合，也叫硬编码现象，会加大开发维护成本
    + 硬编码，是将数据直接嵌入到程序或者其他可执行对象的原代码中
    + 硬编码的数据通常表示不变的信息
+ 要解决的刚需
  + 将连接数据库的四大参数提取到外部文件中，在需要修改时可以快速找到改文件并进行修改
  + 不再拼接sql，参数自动传递，
  + sql自动执行
  + 结果集自动封装
  + 将sql与java文件解耦，解决硬编码现象

### 03.Mybatis

+ 是一个优秀的持久层访问框架
  + mybatis可以让我们dao层编码更简单
+ Mybatis是一个优先的持久型框架，它对jdbc操作数据库的过程进行了封装，使开发者只关注sql本身，而不需要花费精力取处理驱动的注册，connection连接的建立，Statement的创建，手动设置参数，结果集的获取和遍历等繁琐的jdbc代码过程
+ 什么是框架
  + 框架是一组程序的集合，包含一系列最佳的实现，作用是解决某个领域的问题，不同的框架解决不同的问题
  + 框架定义号了一些功能，这些功能是可以用的，比如我们引用的jar包
  + 我们自己想要添加功能，可以利用框架中写好的功能。
  + 框架是一个半成品的软件，定义号一些基础功能，需要加入你的功能完善，基础功能可以重复利用，可升级。

### 04.使用mybatis

+ 创建Maven项目

+ 在pom文件中导入mysql和mybatis依赖

+ 创建表

+ model包创建实体类，dao包创建Dao

+ mybatis不再创建dao层接口的实现类，而是以mapper.xml文件代替

  + 在dao包下创建mapping，

  + 在mapping包，右键===》new==》File==》EmpMapper.xml

  + mapper文件基本结构

  + ```
    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
            "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <!-- namespace 目前可以自定义要唯一，将来面向接口编程时对应dao接口，一 接口，一
    个 个mapper 相当于一个dao 接口的实现类 -->
    <!--namespace翻译过来叫命名空间，拥有唯一的值，值是dao接口的全限定名称（包名加类名）-->
    <!--mapper根标签，-->
    <mapper namespace="com.jxd.emp.dao.IEmpDap">
    <!--    select表示查询操作
              id属性：要执行sql语句的唯一标识，要求使用接口定义的抽象方法的名称-->
    <!--
    List<Emp> getAllEmp();
    -->
    <!--    resultType 返回类型；或者返回值为集合时，是集合的泛型类型，查询必须要写resulType-->
        <select id="getAllEmp" resultType="com.jxd.emp.model.Emp">
            select empno,ename,job,hiredate from emp
        </select>
    </mapper>
    ```

+ 在接口中添加方法，在mapper文件中定义对应的标签

+ ```
  <select id="getAllEmp" resultType="com.jxd.emp.model.Emp">
      select empno,ename,job,hiredate from emp
  </select>
  ```

+ id和方法命完全对应

+ select表示查询操作

+ id属性：要执行sql语句的唯一标识，要求接口中定义的抽象方法名称。

  + 接口中的方法不能重载，否则冲突

+ resultType 返回值类型，或者返回值集合时，是集合的泛型，查询必须要写。

+ 添加配置文件到resources文件夹中

  + db.properties 存放了数据四大参数

  + mybatis配置文件，可以命名为config.xml获取mybatis.xml

  + 一般一个项目就一个主配置文件

  + ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
    <!-- mybatis的核心配置信息 -->
    <configuration>
        <!--引入外部数据库参数属性文件-->
        <properties resource="db.properties"></properties>
        <!--设置运行时的一些参数-->
        <settings>
            <!--在控制台打印sql-->
            <setting name="logImpl" value="STDOUT_LOGGING"/>
            <!--配置log4j-->
            <!--<setting name="logImpl" value="LOG4J"></setting>-->
        </settings>
       <!-- <typeAliases>
            &lt;!&ndash;mybatis会在该包名下搜索需要的实体类&ndash;&gt;
            <package name="com.jxd.model"></package>
        </typeAliases>-->
        <environments default="development">
            <!--配置数据源环境-->
            <environment id="development">
                <!--事务管理采用jdbc方式-->
                <transactionManager type="jdbc"></transactionManager>
                <!--配置连接池方式的数据源，属性为连接数据库的四大参数-->
                <dataSource type="POOLED">
                    <property name="driver" value="${driver}"></property>
                    <property name="url" value="${url}"></property>
                    <property name="username" value="${username}"></property>
                    <property name="password" value="${password}"></property>
                </dataSource>
            </environment>
        </environments>
        <!--注册映射文件-->
        <mappers>
            <!--告诉mybatis去哪里执行sql-->
            <mapper resource="com/jxd/emp/dao/mapping/EmpMapper.xml"></mapper>
    <!--        <mapper resource="mapper/DeptMapper.xml"></mapper>-->
        </mappers>
    </configuration>

    ```

+ Mapper文件需要在类路径下生成

  + 在pom.xml文件的bulid标签下添加一些代码（清空再添加）

  + ```
    <resources>
      <resource>
        <!--所在的目录-->
        <directory>src/main/java</directory>
        <includes>
          <!--包括目录下的.properties、.xml文件都会扫描到-->
          <include>**/*.properties</include>
          <include>**/*.xml</include>
        </includes>
        <filtering>false</filtering>
      </resource>
    </resources>
    ```

+ 测试

  + 使用了单元测试，

  + maven项目自动引入了junit单元测试的jar包

  + 单元：指方法，一个类中有很多方法，一个方法就称为一个单元

  + 步骤

    + 创建与main同级的文件夹，再test下创建java文件夹
    + 右键mark directory as Test Source Root（绿色文件夹）
    + 创建测试类，测试类不要叫Test，因为注解是@Test，方法前面就多出一个启动按钮
    + 方法命名时以Test + 功能来命名
    + 访问修饰符public，无参，无返回值
    + ​

  + ```java
     @Test
        public void testGetAllEmp() throws IOException {
            //读取配置文件
            Reader reader = Resources.getResourceAsReader("config.xml");
            //创建
            SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
            //创建对象
            SqlSessionFactory sf = sfb.build(reader);//根据配置文件加载数据
            //获得一个sql对象
            SqlSession session = sf.openSession();
            //获取dao层实现类对象
            IEmpDap empDap = session.getMapper(IEmpDap.class);
            //执行方法，获取结果
            List<Emp> emps = empDap.getAllEmp();
            //遍历结果
            for (Emp emp : emps){
                System.out.println(emp);
            }
            //关闭会话
            session.close();
        }
       }
     ```

    ```

    ```

### 案例--新增

+ 在dao接口中添加方法

+ ```
  /**
   * 新增员工
   * @param emp 新增员工对象
   * @return 新增条数
   */
  int addEmp(Emp emp);
  ```

+ 在mapper文件中添加标签

  + ```
    <insert id="addEmp">
        insert into emp (ename,job,hiredate)
        values (#{ename},#{job},#{hiredate})
    </insert>
    ```

+ 测试

  + 因为有部分代码重复，封装为工具类减少代码冗余

  + 测试

  + ```
    @Test
    public void testAddEmp(){
        SqlSession session = MybatisUtil.openSession();
        IEmpDap empDap = session.getMapper(IEmpDap.class);
        //新增员工
        int num = empDap.addEmp(new Emp(null,"张三","清洁工","2020-1-1"));
        if (num > 0){
            System.out.println("新增成功");
        }else {
            System.out.println("新增失败");
        }
        session.commit();
        session.close();
    ```

  + 因为mybaitis的事务不自动提交，所有需要我们手动提交（session.commit())

  + 增删改的方法返回值类型可以选择int或者Boolean，mybatis会自动处理返回值，不用写resultType

### 6.mybatis用到的类和接口

+ Resource：mybatis中的一个类，负责读取主配置文件

+ SplSessionFactoryBulider：创建SqlSessionFactory对象

+ ```
  //读取配置文件
  Reader reader = Resources.getResourceAsReader("config.xml");
  //创建
  SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
  //创建对象
  SqlSessionFactory sf = sfb.build(reader);//根据配置文件加载数据
  //获得一个sql对象
  SqlSession session = sf.openSession();
  //获取dao层实现类对象
  ```

+ SqlSessionFactory：重量级对象，创建耗时较长，使用资源较多，整个项目中有一个即可

+ ```
  SqlSession session = sf.openSession();
  //获取dao层实现类对象
  ```

+ openSession()可以填写参数

  + 参数为true，获取到的是自动提交事务的SqlSession对象
  + 参数为false，不自动提交，与不填写相同

+ SqlSession是一个接口，定义了操作数据的方法

  + 通过getMapper能获取到接口的实现类对象

  + ```
    //获取dao层实现类对象
    IEmpDap empDap = session.getMapper(IEmpDap.class);
    ```

  + 注意：SqlSession对象不是线程安全的，需要在方法内部使用，在执行sql之前通过openSession（）获取sql会话，执行完sql后，使用close（）关闭会话，这样能保证它的使用线程是安全的

### 7.mybatis主配置文件

+ 命名一般为config.xml或者mybatis.xml

+ 标签的顺序是固定的

+ properties标签

  + 对属性进行设置，可以引用外部的文件

  + ```
    <properties resource="db.properties"></properties>
    ```

+ settings：控制mybatis的运行时行为

+ ```
  <settings>
      <!--在控制台打印sql-->
      <setting name="logImpl" value="STDOUT_LOGGING"/>
      <!--配置log4j-->
      <!--<setting name="logImpl" value="LOG4J"></setting>-->
  </settings>
  ```

+ STDOUT_LOGGING在控制台打印

+ typeAliases:设置类型别名

  + 方式一：捉个设置类的别名

    + <typeAliases>
        <typeAlias alias="Author" type="domain.blog.Author"/>
        <typeAlias alias="Blog" type="domain.blog.Blog"/>
        <typeAlias alias="Comment" type="domain.blog.Comment"/>
        <typeAlias alias="Post" type="domain.blog.Post"/>
        <typeAlias alias="Section" type="domain.blog.Section"/>
        <typeAlias alias="Tag" type="domain.blog.Tag"/>
          </typeAliases>

  + 方式二：通过包名设置，扫描整个包，类名就是类名首字母小写

    + ```
      <typeAliases>
          <!--mybatis会在该包名下搜索需要的实体类-->
          <package name="com.jxd.model"></package>
      </typeAliases>
      ```

+ envionments:环境配置

  + 一个enviomens标签就是一个数据源

  + ```
    <environment id="development">
        <!--事务管理采用jdbc方式-->
        <transactionManager type="jdbc"></transactionManager>
        <!--配置连接池方式的数据源，属性为连接数据库的四大参数-->
        <dataSource type="POOLED">
            <property name="driver" value="${driver}"></property>
            <property name="url" value="${url}"></property>
            <property name="username" value="${username}"></property>
            <property name="password" value="${password}"></property>
        </dataSource>
    </environment>
    ```

+ mapper：注册映射文件

  + ```
     <mappers>
            <!--告诉mybatis去哪里执行sql-->
            <mapper resource="com/jxd/emp/dao/mapping/EmpMapper.xml"></mapper>
       <!--        <mapper resource="mapper/DeptMapper.xml"></mapper>-->
        </mappers>
     ```
    ```

  + 注意：文件层级间用/分隔，而不是用.
    ```

### 8.mybatis的执行原理

+ mybatis通过主配置文件构造和数据库通信的SqlsessionFactory对象，它相当与一个数据池
+ 在SQLSessionFactory中获取与数据库合适的会话对象，相当于从连接池拿到一个连接数据库对象，mabatis时通过SQLSession对象来操作数据的
+ sqlSession对象不能直接操作系统，它时通过一个底层对象MappedStatement对象中，该对象包括sql
  + 输入参数和输出结果的映射类型包括：简单类型（java的八个基本类型加String），HashMap，pojo对象（实体类对象），

### 9.映射文件解析

+ 添加mapper-xml模板

+ setting==》File and Code Templates

+ mapper

  + ```
    <!-- namespace 目前可以自定义要唯一，将来面向接口编程时对应dao接口，一 接口，一
    个 个mapper 相当于一个dao 接口的实现类 -->
    <!--namespace翻译过来叫命名空间，拥有唯一的值，值是dao接口的全限定名称（包名加类名）-->
    <!--mapper根标签，-->
    <mapper namespace="com.jxd.emp.dao.IEmpDap">
    <!--    select表示查询操作
              id属性：要执行sql语句的唯一标识，要求使用接口定义的抽象方法的名称-->
    <!--
    List<Emp> getAllEmp();
    -->
    <!--    resultType 返回类型；或者返回值为集合时，是集合的泛型类型，查询必须要写resulType-->
        <select id="getAllEmp" resultType="emp">
            select empno,ename,job,hiredate from emp
        </select>
    <!--    int addEmp(Emp emp)-->
    <!--    因为增删改返回值类型比较简单，可以自动处理，不用写resultType-->
        <insert id="addEmp">
            insert into emp (ename,job,hiredate)
            values (#{ename},#{job},#{hiredate})
        </insert>
    </mapper>
    ```

  + 跟标签

  + namespace 命名空间，拥有唯一的值，值是dao层接口的全限定名称（包名+类名），或者类有定义的话，也可以写类的别名

+ select

  + 表示查询操作

  + id：要执行的sql语句的唯一标识，要求使用接口中定义的抽象方法的名称

  + resultType：结果集类型，返回值类型，或者方法返回值为集合时，集合的泛型类型

    + mybatis自动将结果封装成对象进行返回，代替了jdbc自己遍历resultset的过程

    + 其值为类的全限定名称或别名

    + mybatis为我们提供了一些常用类的别名，基本数据类型的保装类，其别名就是它的原本的类型

    + String 类型的别名是string

    + ParameterType；输入参数的类型，如果sql中的参数为对象类型，可以将参数的类型直接直接指定为该对象类型，不需要写这个属性。但是要保证#{}中的参数名和对象的属性名一致

      + 这个属性不是必须的

    + resultMap

      + 当实体类的属性与表中的字段不一致时，使用resultMap配置映射关系，例is_adopt可能时字段名，但是java中变量命名采用驼峰命名法，会将其改为isAdopt，

      + ```xml
        <!--    当实体类属性不能和表中自段完全对应时，可以使用resultMap配置映射关系
        <resultMap>的id可以被<select>的resultMap属性所引用，查询结果会封装按照配置的映射关系封装，type属性，实体类，查询结果封装到这个类中-->
         <select id="getAllEmp2" resultMap="empMap">
                select empno,ename,job,hiredate from emp
            </select>
            主键列用id标签来配置，非主键用result标签来配置
            colunm属性 数据库字段名
            property属性：实体类属性名
            <resultMap id="empMap" type="emp2">
                <id column="empno" property="eno"></id>
                <result column="ename" property="ename"></result>
                <result column="job" property="job"></result>
                <result column="hiredate" property="hiredate"></result>
            </resultMap>
        ```

      + 创建一个新的Emp2，empno改为eno

      + 当进行多表连接查询时，如果是一对多的关系，需要用resultMap把查询出的多表数据与实体类中的属性对应起来

      + 查询必须写resultType或者resultMap，二者选一个

+ Insert

+ ```
  <!--    int addEmp(Emp emp)-->
  <!--    因为增删改返回值类型比较简单，可以自动处理，不用写resultType-->
      <insert id="addEmp">
          insert into emp (ename,job,hiredate)
          values (#{ename},#{job},#{hiredate})
      </insert>
  ```

+ sql

  + 引用sql片段

  + ```
    <sql id="basesql">
        empno,ename,job,hiredate
    </sql>
    <select id="getEmpByNo">
        select <include refid="basesql"></include>
        from emp
        where empno = #{empno}
    </select>
    ```

### 10.mybatis整合log4j

+ 1.引入依赖，在pom文件中添加log4j的dependency标签

+ 改主配置文件中的setting

+ ```
  settings>
          <!--在控制台打印sql-->
  <!--        <setting name="logImpl" value="STDOUT_LOGGING"/>-->
          <!--配置log4j-->
          <setting name="logImpl" value="LOG4J"></setting>
      </settings>
  ```

  + value值为STDOUT_LOGGING时，在控制台输出sql
  + value值为LOG4时，按照LOG4的配置输出sql

+ 在resources目录下添加log4j。properties

  + 注意log4j。logger.com.jxd.emp.dao=TRACE需要自己项目的dao包的路径

+ log4j的作用：项目上线以后，可以通过日志查看程序运行过程中的sql，以帮助我们分析问题

### 11.输入参数

+ parameterType:写在mapper文件中的一个属性，表示dao接口方法的参数类型，该属性可以省略，mybatis通过反射机制能够发现接口中方法参数的数据类型

+ 传入一个简单类型的参数

  + 简单类型：8种基本数据类型 + String
  + 99999#{任意字符}即可接收，mybatis不会做任何处理
  + 为了见名知意，建议写形参的名字

+ 传入多个参数

  + mybatis会把多个参数封装成map

    + key默认是arg0，arg1，arg2，
    + 或者param1，param2，param3 
    + value按照参数的顺序填充，value是实参的值

  + 方式一

  + 按map的arg取值，不推荐，因为做不到就见名之意

  + 方式二，添加注解

  + ```
    /**
     * 通过员工的姓名和工作查找
     * @param ename 姓名
     * @param job 工作
     * @return 员工对象
     */
    Emp getEmpByNameAndJob(@Param("ename") String ename, @Param("job") String job);
    ```

  + ```
    <select id="getEmpByNameAndJob" resultType="emp">
        select empno,ename,job,hiredate from emp where ename = #{ename} and job = #{job}
    </select>
    ```

  + key变成注解的名字

  + 方式三

    + 将多个参数封装成一个实体类对象，比如上述参数改为Emp emp

  + 方式四

    + 将参数封装成map对象

    + mapper文件中可以直接用#{key}取value

    + ```
      /**
       * 根据姓名和工作查询信息
       * @param map map中封装了姓名和工作
       * @return 对象
       */
      Emp getEmpByNameAndJob2(Map<String,String> map);
      ```

+ ```
  <select id="getEmpByNameAndJob2" resultType="emp">
      select empno,ename,job,hiredate from emp where ename = #{ename} and job = #{job}
  </select>
  ```

+ ```
  @Test
  public void testGetEmpBy2(){
      SqlSession session = MybatisUtil.openSession();
      IEmpDap empDap = session.getMapper(IEmpDap.class);
      Map<String,String> map = new HashMap();
      map.put("ename","李四");
      map.put("job","扫地");
      Emp emp = empDap.getEmpByNameAndJob2(map);
      System.out.println(emp);
  }
  ```

+ 传入一个封装了ename和job的map对象

  + 推荐方式二（@param注解）和方式三（封装成实体类），如果二，三都不合适，就用四

+ 传入实体类对象


### 12.输出参数

+ 简单类型

  + 查询张三的工作

  + ```
    <!--    String getJobByEname(String ename);
    -->
        <select id="getJobByEname" resultType="string">
            select job from emp where ename = #{ename}
        </select>
    ```

  + 简单类型在mybatis中有自己的别名

  + Integer ==》int  integer

  + Float==》float

  + String==》string

+ 实体类

  + resultType= “实体类的全限定名称”
  + 如果有起别名，也可以起别名
  + 查询结果会字段映射到实体类对象中，此时要求字段名（或者字段别名），与属性一致。

+ 实体类集合

  + resultType = “实体类全限定名称”
  + 如果有起别名，也可以起别名
  + 查询结果会字段映射到实体类对象中，此时要求字段名（或者字段别名），与属性一致。
  + 与上一种情况不同的是接口的方法不一样
  + 返回值类型为List<实体类>，也就是说resultType的值是集合发泛型。

+ 查询结果无法直接封装到实体类中，使用resultMap，手动定义那一列的数据封装到那一列的属性中。

+ <id>专门映射主键的标签，

+ <result>用来映射非主键列的标签

+ ```
  <!--    当实体类属性不能和表中自段完全对应时，可以使用resultMap配置映射关系
  <resultMap>的id可以被<select>的resultMap属性所引用，查询结果会封装按照配置的映射关系封装，type属性，实体类，查询结果封装到这个类中-->
     <!-- <select id="getAllEmp2" resultMap="empMap">
          select empno,ename,job,hiredate from emp
      </select>
      主键列用id标签来配置，非主键用result标签来配置
      colunm属性 数据库字段名
      property属性：实体类属性名
      <resultMap id="empMap" type="emp2">
          <id column="empno" property="eno"></id>
          <result column="ename" property="ename"></result>
          <result column="job" property="job"></result>
          <result column="hiredate" property="hiredate"></result>
      </resultMap>-->
  <!--
  ```

+ 增删改可以不设置返回值类型，其方法返回值要么是int，要么是Boolean，mybatis会自动处理，

  + 对应查询resultType和resultMap必须选择一个。

+ 当查询结果无法封装到而忽视的实体类中，可以将其封装为map

  + resultType = map

### 13.${}和#{}的区别

+ mybatis执行sql使用PreparedStatement为对象，采用预编译处理，会将#{}替换为？占位符，正真执行时替换为实参，采用这中方法可以提高效率，放在sql注入------------#{}
+ ${}表示拼接字符串，将收到的参数不加任何东西拼接在sql中，采用Statement对象执行sql，效率低，有sql注入的风险。

### 14.模糊查询

+ ename like ‘%张三%’
+ 方式一：在java代码中拼接好like的内容(不推荐)
  + String ename = “%” + ename + "%",
  + String job = empDao.getJobByEname(ename);
  + xml文件中ename like #{enamej}
+ 方式二：在sql语句只能拼接

```
<!--    % 和#{}之间留空格-->
    <select id="getJobByEname" resultType="string">
        select job from emp
        where ename like '%' #{ename} '%'
    </select>
```

+ 方式三，使用sql函数concat（）进行拼接

+ ```
  <!--    % 和#{}之间留空格-->
      <select id="getJobByEname" resultType="string">
          select job from emp
          where ename like concat('%',#{ename},'%')
      </select>
  ```

+ 在sql中尽量不要使用函数，也不要在sql中处理复杂的业务逻辑

+ MyBatis根据主键识别数据，然后封装对象，结果集类型实际上设置的是数据库中每条数据要封装的类型，所以即使查询多条数据，resultType也是对象类型。 

+  resultType还可以是java.util.Map集合类型。  

+  ${}可以用在动态排序上，直接将排序字段拼接上order by之后。

+  oracle中的分页注意大于和小于，和标签的尖括号冲突，使用&gt;和&lt;代替

### 15.动态SQL

+ 案例一：按照姓名和工作模糊查询员工

  + 假如在页面中有2个输入框（姓名，工作），点击擦好像按钮时，如果用户输入了姓名，在sql语句中就要拼接姓名相关的擦好像条件，如果没有数据，就不拼接，同理

  + ```
    <!--    if标签如果test的值为真，则拼接if中的sql，为假则不拼接-->
    <!--    where标签：where后面的条件至少有一条成立时才会拼接where关键字，条件都不成立时，不拼接where关键字
    会将多余的and和or去掉-->
        <select id="getEmpByNameAndJob" resultType="emp">
            select empno,ename,job,hiredate from emp
            <where>
            <if test="ename != '' and ename != null"> ename like '%' #{ename} '%' </if>
             <if test="job != ''and job != null">
             and job like '%' #{job} '%'
             </if>
            </where>
        </select>
    ```

  + where标签和if标签经常搭配使用

  + 注意test中的表达式的逻辑运算符是and ro not，而不是&&  ！  ||

  + 单条件查询使用单个if即可

  +  多条件查询使用where-if

  +  where中第一个if中不要添加任何的and或者or

+ 案例：

  + 批量删除员工信息

  + ```
    <!--     boolean deleteBatch(int[] empnos);-->
        <delete id="deleteBatch">
            delete from emp where empno in <foreach collection="array" separator="," item="empno" open="(" close=")">
            #{empno}
        </foreach>
        </delete>
    ```

  + <foreach> 可以对集合或者数据进行遍历，（尤其是在构建in条件语句的时候）

  + 属性

    + collection：要构建的集合
      + 如果List，collection = “list”
      + 如果是数组，collection = “array”
      + 如果使用了@param注解，collection = "注解内容"
      + separator：集合成员之间的分隔符
      + item 循环项（每次循环时的集合元素），自定义名称，代表集合中的成员变量
        + 取item，使用#{
        + ； }
      + open循环开始的字符
      + close循环结束的字符
        + index循环项的下标	

  ### 16.关联查询

  + 案例：员工和部门表关联查询

  + 一对一映射：一个员工只属于一个部门

    + 查询主体是员工，查询得到的信息是员工信息，所有是在IEmDao和EmpMapper中写代码

  + 没有一个实体类可以存储这些属性

    + 可以将其封装成一个map

    + 可以将其封装成一个Vo对象

    + ```
      /**
       * 查询员工的信息及其部门 一个员工有一个部门，一对一
       * 这种一对一的关系没有合适的实体类存储时，可以封装成map
       * @return map
       */
      List<Map<String,Object>> getEmpAndDept();
      ```

    + ```
      <!--     List<Map<String,Object>> getEmpAndDept();-->
      <!--    封装成map时，key为查询的字段名，值为查询的数据-->
          <select id="getEmpAndDept" resultType="map">
              select e.empno, e.ename, e.job,e.deptno,d.dname,hiredate from emp e join dept d on e.deptno = d.deptno
          </select>
      ```


### 16多表关联


  + 1.多表关联和之前一样，可以封装为map，也可以封装为一个VO对象。
    2.查询时分析映射关系，主要看要查询的主要对象是什么，如果现在要查员工的信息，那么员工对部门就是一对一，如果想查询某个部门的详细信息，那么部门对员工就是一对多的关系，具体看应用场景。
    3.一般一对多查询的应用场景是查询一个部门的详细信息，返回值是一个Dept对象，里面嵌套一个员工的List集合。

+ 一对多映射：一个部门多个员工

  + 给部门类添加收到属性有（部门编号，部门名，员工集合）

  + 查询的主体是部门，要查询的信息是部门的信息，所有要在IDeptDao和DeptMapper中添加代码

  + ```
    <select id="getDeptByDao" resultMap="deptMap">
         select e.empno, e.ename, e.job,e.deptno,d.dname,hiredate from emp e join dept d on e.deptno = d.deptno
          where d.deptno = #{deptno}
    </select>
    ```

  + ```
     <resultMap id="deptMap" type="dept">
            <id column="deptno" property="deptno"></id>
            <result column="dname" property="dname"></result>
       <!--
            collection dept 的属性List<Emp> emps 是一个集合，所有使用collection标签
            javaTaype：集合的类型
            offType：泛型的类型（每个对象的类型）
            property：属性名，要给那个属性名赋值
       -->
            <collection property="emps" ofType="emp" javaType="list">
                <id property="empno" column="empno"></id>
                <result property="ename" column="ename"></result>
                <result property="job" column="job"></result>
                <result property="hiredate" column="hiredate"></result>
       <!--            <result property="deptno" column="deptno"></result>-->
            </collection>
        </resultMap>
     ```
    ```

    ```

### 17.批量操作

+ 批量新增

  + 在mysql中，批量新增可以这样写

  + 值列表之间用逗号分隔

  + insert into emp(ename, job, hiredate, deptno)
    values ('小樱','清洁工','2021-1-10',1),
    ('小明','保安','2012-2-2',3)

  + ```
    <!--     boolean addBatchEmp(List<Emp> emps);-->
        <insert id="addBatchEmp">
            insert into emp (ename,job,hiredate,deptno)
            values <foreach collection="list" item="emp" separator=",">
            (#{emp.ename},#{emp.job},#{emp.hiredate},#{emp.deptno})
        </foreach>
        </insert>
    ```

  + 此次foreach的使用，集合元素为对象类型，可以通过#{对象名.属性}来获取对象的属性值

+ 批量更新

  + 方式一

  + 需要开启批处理功能，在db.properties参数后添加&allowMultiQueries=true，实现多语句执行（每句后面加";",

  + ```
    <!--    boolean updateBatchEmp(List<Emp> emps);-->
        <update id="updateBatchEmp">
    <foreach collection="list" item="emp" separator=";">
            update emp set ename = #{emp.ename},job= #{emp.job},hiredate = #{emp.hiredate},deptno = #{emp.deptno} where
            empno = #{emp.empno}
    </foreach>
        </update>
    ```

  + 方式二

  + ```xml
    》批量更新：
    		》01-语法实现
    			UPDATE emp SET
    				ename = CASE empno
    					WHEN 1 THEN "张三"
    					WHEN 2 THEN "李四"
    					WHEN 3 THEN "王五"
    				END,
    				job = CASE empno
    					WHEN 1 THEN 'CLERK'
    					WHEN 2 THEN 'CLERK'
    					WHEN 3 THEN 'MANAGER'
    				END
    			WHERE empno IN (1,2,3)
    		》02-foreach标签实现
    			<update id="updateBatch" parameterType="java.util.List">
    				update emp
    				<trim prefix="set" suffixOverrides=",">
    					<trim prefix="ename = case" suffix="end,">
    						<foreach collection="list" item="emp" index="index">
    							<if test="emp.empno!=null">
    								when empno=#{emp.empno} then #{emp.ename}
    							</if>
    						</foreach>
    					</trim>
    					<trim prefix="job = case" suffix="end,">
    						<foreach collection="list" item="emp" index="index">
    							<if test="emp.empno!=null">
    								when empno=#{emp.empno} then #{emp.job}
    							</if>
    						</foreach>
    					</trim>
    					<trim prefix="sal = case" suffix="end,">
    						<foreach collection="list" item="emp" index="index">
    							<if test="emp.empno!=null">
    								when empno=#{emp.empno} then #{emp.sal}
    							</if>
    						</foreach>
    					</trim>
    				</trim>
    				where empno in
    				<foreach collection="list"  item="emp" index="index" open="(" separator="," close=")">
    					#{emp.empno}
    				</foreach>
    			</update>

    ```

### 18.mybatis的优点

+ sql的使用非常灵活，将整个项目用到的sql语句全部放在映射文件中统一管理，和java代码进行解耦，一般在项目中sql出错的几率非常大，使用mybatis可以快速定位出错点，解决问题。