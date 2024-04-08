package com.jxd.bookmanger.util;

import java.sql.*;

/**
 * @ClassName DBUTL
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class DBUtil {
    //定义四个静态变量
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url ="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
    private static String user = "root";
    private static String pwt = "123456";

    public static Connection getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,user,pwt);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
