package com.jxd.day08;

import java.sql.*;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

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








        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null){
                    resultSet.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }


    }
}
