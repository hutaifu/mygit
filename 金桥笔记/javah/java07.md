# JDBC

## 01-什么是JDBC

+ java database connectivity
+ 在java中连接数据库的标准格式/模板
+ 数据来自于用户(浏览器)，会首先提交到java中，java中都是临时存储的
+ 只有保存到数据库才是永久性的
+ 我们要在java和数据库之间建立一个连接通道，用于将java中的数据保存到数据库，或是要将数据库中的数据拿到java中在返回给用户看
+ JDBC是java提供的连接数据库的标准语法格式，大部分都是接口
+ 其他的数据库按照JDBC的标准格式，实现了具体的连接语法

## 02-JDBC的使用

+ 引入jar包

  + 各个数据库提供的基于JDBC这个标准的连接数据库的具体实现类
  + 我们连接任意一个数据库时，都要将这个jar包先引入到项目中
  + 这个包一般称之为数据库驱动包

+ 代码的步骤

  + 加载驱动

  + ```java
    //01加载数据库驱动类
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    ```

  + 创建连接对象，建立数据的传输通道

  + ```Java
    Connection conn = DriverManager.getConnection(
            "jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC", "root", "123456");
    ```

    + url指明要链接的数据库所在电脑ip及端口，以及数据库名称
    + 用户名
    + 密码

  + 操作数据库，进行数据的传输，执行增删改查语句

    ```java
    //将数据库中的数据拿到java中显示给用户
                //让数据库执行查询
                String sql = "select stuNum,sname,ssex,birthday from student";
                //创建执行sql语句的statement对象
                statement = conn.createStatement();
                //执行sql,接收返回值
                rs = statement.executeQuery(sql);
                //遍历rs集合
                while (rs.next()) {
                    //当前指向了第一条数据
                    System.out.print(rs.getInt("stuNum") + "\t");
                    System.out.print(rs.getString("sname") + "\t");
                    System.out.print(rs.getString("ssex") + "\t");
                    System.out.println(rs.getString(4));
                }

    /*            int stuNum = 1;
                String sql02 = "select stuNum,sname,ssex,birthday from student where stuNum = " + stuNum;
                rs = statement.executeQuery(sql02);

                String sex = "男";
                String sql03 = "select stuNum,sname,ssex birthday from student where ssex = '" + sex + "'";
                rs = statement.executeQuery(sql03);

                String name = "张";
                String sql04 = "select stuNum,sname,ssex birthday from student where sname like '" + name + "%'";*/

    ```

    ```java
    //将用户数据保存到数据库的过程
                //让数据库执行增删改的操作
                String sname = "王五";
                String sex = "女";
                String birthday = "1998-08-08";

                String sqlAdd = "insert into student (sname,ssex,birthday)" +
                        "values ('" + sname + "','" + sex + "','" + birthday +"')";
                //执行sql
                int num = statement.executeUpdate(sqlAdd);
                if (num > 0){
                    System.out.println("新增成功");
                }
    ```

    + 执行sql语句需要使用statement对象

      ```java
      Statement statement = conn.createStatement();
      ```

    + 执行select语句使用executeQuery()方法

      ```java
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
           //当前指向了第一条数据
           System.out.print(rs.getInt("stuNum") + "\t");
           System.out.print(rs.getString("sname") + "\t");
           System.out.print(rs.getString("ssex") + "\t");
           System.out.println(rs.getString(4));
      }
      ```

    + next()方法会判断结果集中是否有下一条数据，如果有，那么会将光标指向下一条，并返回true

    + rs.getXXX()获取具体的值，可以用列名作为参数，也可以用列索引作为参数

  + 执行insert/update/delete语句，我们都调用executeUpdate()

    ```java
    int num = statement.executeUpdate(sqlAdd);
    ```

    + 返回的是影响的行数

  + 关闭所有资源

    ```java
    finally {
        //关闭连接对象,先创建的后关闭
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    ```

### 03-preparedStatement对象

+ PreparedStatement是Staement的子接口

+ 同样用于数据库的sql执行

+ 使用？占位符替代原来的变量拼接

+ 使用时要提前编译

+ ```java
   try {
              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","root","123456");
              System.out.println("连接成功");
              /*String sql01 = "select stuno,sname,ssex,birthday from student";
              //创建preparedStatement对象，同时提前编译sql语句。
              preparedStatement = conn.prepareStatement(sql01);
              //执行sql,无需将sql传递进去
              resultSet = preparedStatement.executeQuery();

              while (resultSet.next()){
                  System.out.println(resultSet.getString("sname"));
              }
     */

              //通过学号和姓名查询学生信息
             /* int stuno = 1;
              String sname = "张三";

              String sql02 = "select stuno,sname,ssex,birthday from student where stuno = ? and sname = ?";
              //编译sql的过程就是让pst对象检测到？的过程
              preparedStatement = conn.prepareStatement(sql02);
              //设置占位符的具体值
              preparedStatement.setInt(1,stuno);
              preparedStatement.setString(2,sname);
              //执行
              resultSet = preparedStatement.executeQuery();

              if (resultSet.next()){
                  System.out.println(resultSet.getString("sname") + "\t");
                  System.out.println(resultSet.getString("ssex"));
              }
     */

             //模糊查询：性张的学生信息
              String sname = "张";
              String sql03 = "select stuno,sname from student where sname like ?";
              preparedStatement = conn.prepareStatement(sql03);
              preparedStatement.setString(1,"%" + sname + "%");//'%张%'
              //自动加单引号
              resultSet = preparedStatement.executeQuery();
              while (resultSet.next()){
                  System.out.println(resultSet.getString("sname"));
              }
              
              
   try {
              Class.forName("com.mysql.cj.jdbc.Driver");
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }

          Connection conn = null;
          PreparedStatement preparedStatement = null;

          try {
              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","root","123456");
              System.out.println("连接成功");

              String sname = "刘备";
              String ssex = "男";
              String birthday = "1900-01-01";

              String sql01 = "insert into student (sname,ssex,birthday) values (?,?,?)";
              preparedStatement = conn.prepareStatement(sql01);

              //第一个学生的插入
              preparedStatement.setString(1,sname);
              preparedStatement.setString(2,ssex);
              preparedStatement.setString(3,birthday);
              int num = preparedStatement.executeUpdate();
              if (num > 0){
                  System.out.println("新增成功");
              }
              //第二个学生的插入
              preparedStatement.setString(1,"关羽");
              preparedStatement.setString(2,"男");
              preparedStatement.setString(3,"1900-01-02");
              int num1 = preparedStatement.executeUpdate();
   ```









  ```

  + 设置占位符时，根据类型选择方法
    + setInt
    + setString
  + ？下标位置从1开始
  + 调用executeQuery或者executeUpdate无需重复传递sql

+ 优势优点

  + 因为sql提前编译过，所有执行效率高
  + 执行批量的同类型操作时，可以直接复用sql结构
  + 可以有效防止sql注入，用户输入的所有内容都会被看成是一个整体来删选内容

  ```java

             /* String sname = "张";
              String sql = "select stuno,sname from student where like '%" + sname + "%'";
              Statement st = conn.createStatement();
              resultSet = st.executeQuery(sql);*/
  ```

  ### 04-JDBC中事务的控制

  + 事务：数据库中最小的执行单元，包含一条或者多条sql语句。

  + JDBC中通过取消自动提交功能实现事务控制。

  + ```
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","root","123456");
        System.out.println("连接成功");
        
        //模拟转账，更新两个账号的余额
        String sql = "update account set balance = balance - 500 where ano = 1";
        String sql1 = "update account set balance = balance + 500 where ano = 2";
        
        //sql之前将jdbc的自动提交功能关闭。
        conn.setAutoCommit(false);
        
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate();
        
        preparedStatement = conn.prepareStatement(sql1);
        preparedStatement.executeUpdate();
        
        //两句sql执行成功后，我们手动提交
        conn.commit();;
    ```







    } catch (SQLException e) {
        e.printStackTrace();
        //回滚刚才所有的操作
        try {
            conn.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    ​```

### 05-批量处理

+ 批量执行同类型的sql，一般都是增删改

+ 可以先将sql放到batch批处理队列中，最后一起发送到数据库一起执行，减少访问数据库次数。

+ ```java
  try {
              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","root","123456");
              System.out.println("连接成功");

              String sname = "刘备";
              String ssex = "男";
              String birthday = "1900-01-01";

              String sql01 = "insert into student (sname,ssex,birthday) values (?,?,?)";
              preparedStatement = conn.prepareStatement(sql01);

              //第一个学生的插入
              preparedStatement.setString(1,sname);
              preparedStatement.setString(2,ssex);
              preparedStatement.setString(3,birthday);
          
              //添加到批处理中,添加到队列中
              preparedStatement.addBatch();
              //第二个学生的插入
              preparedStatement.setString(1,"关羽");
              preparedStatement.setString(2,"男");
              preparedStatement.setString(3,"1900-01-02");
              //继续放到批处理中
              preparedStatement.addBatch();
              
              //一块执行所有操作,返回每个sql的执行结果，放到数组中
              int[] num = preparedStatement.executeBatch();
  ```


### 06-JDBC APC

+ DriverManager:类，管理着数据库连接的驱动，帮助我们创建数据库连接对象
  + getConnection(url,user,password)
+ Statement:接口，提供了数据库sql的执行方法，规定了参数以及返回值
+ PrepareStatement：接口，继承了Statement，可以再sql中设置占位符，防止sql注入
  + executeQuery()
  + executeUpdate()
+ ResultSet：接口，用于接收查询语句的返回值
  + next()