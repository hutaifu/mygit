package ch08.prc;

import java.sql.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/8
 * @Version 1.0
 */

public class Test {
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

            String sname = "小明";
            String ssex = "男";
            String birthday = "1899-02-28";

            String sname1 = "小虎";
            String ssex1 = "男";
            String birthday1 = "2001-03-30";

            String sql1 = "insert into student (sname,ssex,birthday) values('"+ sname +"','"+ ssex +"','"+ birthday + "')";
            String sql2 = "insert into student (sname,ssex,birthday) values('"+ sname1 +"','"+ ssex1 +"','"+ birthday1 + "')";

            int num01 = statement.executeUpdate(sql1);
            int num02 = statement.executeUpdate(sql2);






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
