package com.jxd.day08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName Test05
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Test05 {
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

