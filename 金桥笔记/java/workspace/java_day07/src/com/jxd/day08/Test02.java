package com.jxd.day08;

import java.sql.*;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
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











        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
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

