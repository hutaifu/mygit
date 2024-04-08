package ch08.prc;

import ch08.prc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet resultSet = null;

        String sql = "select count(stuno) count_stu  from student";
        String sql1 = "select sname,ssex,birthday from student where stuno = (select max(stuno) from student)";
        try {
            pst = conn.prepareStatement(sql);
            resultSet = pst.executeQuery();
            resultSet.next();
            int num = resultSet.getInt("count_stu");
            System.out.println("一共有" + num + "名学生");

            pst = conn.prepareStatement(sql1);
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("sname"));
                System.out.println(resultSet.getString("ssex"));
                System.out.println(resultSet.getString("birthday"));
            }






        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,pst,resultSet);
        }

    }
}
