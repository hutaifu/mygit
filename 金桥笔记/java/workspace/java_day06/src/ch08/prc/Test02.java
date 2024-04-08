package ch08.prc;

import java.sql.*;

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

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC","root","123456");
            System.out.println("连接数据库成功");

            statement = connection.createStatement();

            String sql2 = "select stuno,sname,ssex,birthday from student ";
            resultSet = statement.executeQuery(sql2);
            while (resultSet.next()){
                //当前指向了第一条数据
                System.out.print(resultSet.getInt("stuno")+"\t");
                System.out.print(resultSet.getString("sname")+"\t");
                System.out.print(resultSet.getString("ssex")+"\t");
                System.out.println(resultSet.getString(4));
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
