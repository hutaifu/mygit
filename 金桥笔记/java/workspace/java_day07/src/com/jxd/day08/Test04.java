package com.jxd.day08;

import java.sql.*;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Test04 {
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







        } catch (SQLException e) {
            e.printStackTrace();
            //回滚刚才所有的操作
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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

