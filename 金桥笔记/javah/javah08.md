## 数据访问层

### 01.数据持久化

+ java中的数据，是保存在内存中的，都是临时瞬时的数据。
+ 用户的数据需要永久的保存到数据库中
+ 将java中的临时数据，保存到数据库中的过程，就是数据持久化。
  + 通过JDBC保存到数据库
  + 通过IO流保存到文件中

### 02-数据持久层/数据访问层

+ JDBC是数据持久化的底层实现。

+ 数据访问层是真正应用在代码中实现数据持久化的标准格式。

+ 数据访问层，又可以称为DAO层

+ DAO：data access object，数据存取对象。

+ java和数据库的关系

  + java中接收用户的数据，然后将数据保存在某个对象中
  + 一个对象数据，保存到数据库中，会成为一条记录

+ DAO层的主要作用：

  + 将Java中的一个或者多个对象，转化为数据库中的一条或者多条记录
  + 将数据库中的数据查询到Java中，封装成为对象，将对象响应给用户（浏览器）

+ Dao层或者Dao模式的组成

  + dao接口

    + 声明针对某一张表的增删改查四类方法

    + ```java
      public interface IStudentDao {
          /**
           * 新增学生
           * @param student   学生对象
           * @return 是否新增成功
           */
          boolean insert(Student student);

          /**
           * 查询全部学生信息
           * @return
           */

          List<Student> selectAll();

          /**
           * 更新学生信息
           * @param student 学生全部信息
           * @return
           */
          boolean update(Student student);

          /**
           * 根据主键删除员工信息
           * @param stuno
           * @return
           */
          boolean delete(int stuno);

          /**
           * 批量删除
           * @param stunos 多个学号信息
           * @return
           */
          boolean deleteBatch(int[] stunos);
      }
      ```

  + dao实现类

    + 实现dao接口中的抽象方法

    + ```java
      public class StudentImpl implements IStudentDao {

          @Override
          public boolean insert(Student student) {
              Connection connection = DBUtil.getConn();
              PreparedStatement  pst = null;
              boolean isSuccess = false;

              String sql = "insert into student (sname,ssex,birthday) "+
                      "values (?,?,?)";
              try {
                  pst = connection.prepareStatement(sql);
                  pst.setString(1,student.getSname());
                  pst.setString(2,student.getSsex());
                  pst.setString(3,student.getBirthday());

                  int num = pst.executeUpdate();
                  if (num > 0){
                      isSuccess = true;
                  }

              }catch (SQLException e){
                  e.printStackTrace();
              }finally {
                  DBUtil.closeAll(connection,pst,null);
              }
              return isSuccess;
          }

          /**
           * 查询全部学生信息
           *
           * @return
           */
          @Override
          public List<Student> selectAll() {
              Connection conn = DBUtil.getConn();
              PreparedStatement pst = null;
              ResultSet rs = null;
              List<Student> list = new ArrayList<>();

              String sql = "select stuno,sname,ssex,birthday from student";
              try {
                  pst = conn.prepareStatement(sql);
                  rs = pst.executeQuery();
                  //遍历rs集合，将数据库中的每条数据封装为一个student对象，然后放到
                  while (rs.next()){
                      Student student = new Student();
                      student.setStuno(rs.getInt("stuno"));
                      student.setSname(rs.getString("sname"));
                      student.setSsex(rs.getString("ssex"));
                      student.setBirthday(rs.getString("birthday"));
                      list.add(student);
                  }

              }catch (SQLException e){
                  e.printStackTrace();
              }finally {
                  DBUtil.closeAll(conn,pst,rs);
              }
              return list;
          }

          /**
           * 更新学生信息
           *
           * @param student 学生全部信息
           * @return
           */
          @Override
          public boolean update(Student student) {
              Connection conn = DBUtil.getConn();
              PreparedStatement pst = null;
              boolean isSuccess = false;

              String sql = "update student set sname = ?,ssex = ?,birthday = ? where stuno = ?";
              try {
                  pst = conn.prepareStatement(sql);
                  pst.setString(1,student.getSname());
                  pst.setString(2,student.getSsex());
                  pst.setString(3,student.getBirthday());
                  pst.setInt(4,student.getStuno());
                  int num = pst.executeUpdate();
                  if (num > 0){
                      isSuccess = true;
                  }


              } catch (SQLException e) {
                  e.printStackTrace();
              }finally {
                  DBUtil.closeAll(conn,pst,null);
              }

              return isSuccess;
          }

          /**
           * 根据主键删除员工信息
           *
           * @param stuno
           * @return
           */
          @Override
          public boolean delete(int stuno) {
              Connection conn = DBUtil.getConn();
              PreparedStatement pst = null;
              boolean isSuccess = false;

              String sql = "delete from student where stuno = ?";

              try {
                  pst = conn.prepareStatement(sql);
                  pst.setInt(1,stuno);
                  int num = pst.executeUpdate();

                  if (num > 0){
                      isSuccess = true;
                  }
              }catch (SQLException e){
                  e.printStackTrace();
              }finally {
                  DBUtil.closeAll(conn,pst,null);
              }
              return isSuccess;
          }

          /**
           * 批量删除
           *
           * @param stunos 多个学号信息
           * @return
           */
          @Override
          public boolean deleteBatch(int[] stunos) {
              Connection conn = DBUtil.getConn();
              PreparedStatement pst = null;
              boolean isSuccess = false;

              //根据数组的长度动态的拼接sql
              String sql = "delete from student where stuno in (" ;
              for (int i = 0; i < stunos.length; i++) {
                  sql += "?";
                  if (i < stunos.length -1){
                      sql += ",";
                  }
              }
                     sql += ")";
              try {
                  pst = conn.prepareStatement(sql);
                  for (int i = 0; i < stunos.length; i++) {
                      pst.setInt(i+1,stunos[i]);
                  }
                  //num中存储的是删除数据条数
                  int num = pst.executeUpdate();
                  if (num > 0){
                      isSuccess = true;
                  }





              } catch (SQLException e) {
                  e.printStackTrace();
              }finally {
                  DBUtil.closeAll(conn,pst,null);

              }
              return isSuccess;
          }


      }

      ```

+ dao层的使用

  + 创建dao层对象，再调用相关方法

+ Dao模式编写规范

  + 一张表对应一个dao模式，包括一个dao接口和一个dao实现类
  + 不同数据表的操作，需要定义不同的dao模式
  + 分包结构
    + com.jxd.ch09
      + model包:实体类
      + dao
        + dao接口
        + impl包
          + dao层实现类
      + util包
        + 工具类

### 03-分层开发

+ 表现层/表示层：浏览器上的页面，直接面对用户的。
+ 业务逻辑层：用户的数据会先进入java的业务逻辑层
  + 接收用户的数据，实现一些业务逻辑上的处理
  + 处理完成后，将数据继续传递给数据访问层，实现数据的存取
  + 创建dao层的对象，调用dao层的方法
+ 数据访问层：实现数据的增删改查
  + 实现了对象和数据的转换
+ 数据库
+ 代码结构
  + com.jxd.ch09
    + model包：
      + 所有的实体类
    + dao包
      + dao接口
      + impl
        + dao层实现类
    + service包
      + service接口
      + impl包
        + service实现类
    + util包
      + 工具类
    + test包
      + main