package com.jxd.ch08;

import java.sql.*;
import java.util.StringTokenizer;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/8
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        //01.加载数据库的驱动类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //02.连接数据库，创建一个连接对象
        Connection conn = null;
        Statement statement= null;
        ResultSet rs= null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC","root","123456");
            System.out.println("数据库连接成功");

            //查询
            String sql = "select stuno,sname,ssex,birthday from student";
            //创建执行sql语句的statenment对象
            statement = conn.createStatement();
            //执行sql
            rs = statement.executeQuery(sql);
            //遍历rs集合
            while (rs.next()){
                //当前指向了第一条数据
                System.out.print(rs.getInt("stuno")+"\t");
                System.out.print(rs.getString("sname")+"\t");
                System.out.print(rs.getString("ssex")+"\t");
                System.out.println(rs.getString(4));
            }
/*

            int stuno = 1;
            String sql02 = "select stuno,sname,ssex,birthday from student where stuno = " + stuno;
            rs = statement.executeQuery(sql02);

            String sex = "男";
            String sql03 = "select stuno,sname,ssex,birthday from student where ssex = '" + sex + "'";
            rs = statement.executeQuery(sql03);

            String name = "张";
            String sql04 = "select stuno,sname,ssex,birthday from student where name like '" + name + "%'";
            rs = statement.executeQuery(sql04);
*/





            //将用户数据保存到数据库
            //让数据库执行增删改
            String sname = "王五";
            String ssex = "女";
            String birthday = "1999-08-08";

            String sqlAdd = "insert into student (sname,ssex,birthday) values ('"+ sname +"','"+ ssex +"','"+ birthday + "')";
                    //执行sql
            int num = statement.executeUpdate(sqlAdd);
            if (num > 0){
                System.out.println("新增成功");
            }





            //将数据库中的数据拿到java中，显示给用户
            //让数据库查询
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接对象
            try {
                if (rs!=null){
                    rs.close();
                }
                if (statement!=null){
                    statement.close();
                }
                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();

            }
        }
    }
}
