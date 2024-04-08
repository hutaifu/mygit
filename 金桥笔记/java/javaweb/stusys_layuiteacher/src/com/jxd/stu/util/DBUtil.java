package com.jxd.stu.util;

import java.sql.*;

/**
 * @ClassName DBUtil
 * @Description TODO
 * @Author lixiaoru
 * @Date 2022/8/9
 * @Version 1.0
 */
public class DBUtil {
    //定义四个静态变量
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
    private static String user = "root";
    private static String password = "root";


    public static Connection getConn(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(Connection connection, PreparedStatement pst, ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }

            if(pst != null){
                pst.close();
            }

            if(connection != null){
                connection.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
