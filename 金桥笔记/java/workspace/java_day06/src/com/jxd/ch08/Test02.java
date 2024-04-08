package com.jxd.ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/8
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
        Statement statement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC","root","123456");
            String sex = "男";
            String birthday = "1998-10-10";
            String sql = "update student set ssex = '" + sex + "',birthday = '" + birthday + "' where stuno = 3";
            //创建statenment
            statement = conn.createStatement();
            //执行sql语句
            int num =  statement.executeUpdate(sql);
            if (num > 0){
                System.out.println("更新成功");
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (statement != null){
                    statement.close();
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
