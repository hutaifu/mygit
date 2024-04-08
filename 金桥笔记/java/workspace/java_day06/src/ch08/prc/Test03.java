package ch08.prc;

import java.sql.*;
import java.util.Scanner;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/8
 * @Version 1.0
 */

public class Test03 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC","root","123456");
            System.out.println("连接数据库成功");

            statement = connection.createStatement();

            Scanner input = new Scanner(System.in);
            System.out.println("请输入学号");
            int strno = input.nextInt();
            System.out.println("请输入姓名");
            String strname = input.next();

            String sql2 = "select sname from student where stuno = " + strno;
            resultSet = statement.executeQuery(sql2);
            while (resultSet.next()){
                //当前指向了第一条数据
               String strname1 = resultSet.getString("sname");
               if (strname1.equals(strname )){
                   System.out.println("存在改学生");
               }else {
                   System.out.println("不存在改学生");
               }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }
}
