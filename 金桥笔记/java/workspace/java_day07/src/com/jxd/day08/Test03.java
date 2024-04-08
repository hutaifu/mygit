package com.jxd.day08;

import java.sql.*;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Test03 {
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

           /* String sname = "张";
            String sql = "select stuno,sname from student where like '%" + sname + "%'";
            Statement st = conn.createStatement();
            resultSet = st.executeQuery(sql);*/



            //模糊查询：性张的学生信息
            String sname = "张";
            String sql03 = "select stuno,sname from student where sname like ?";
            preparedStatement = conn.prepareStatement(sql03);
            preparedStatement.setString(1,"%" + sname + "%");//'%张%'
            //自动加单引号
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("sname"));
            }








        } catch (SQLException e) {
            e.printStackTrace();
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

