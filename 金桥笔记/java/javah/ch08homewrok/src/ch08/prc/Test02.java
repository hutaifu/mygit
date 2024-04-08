package ch08.prc;

import ch08.prc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet resultSet = null;

        String sql = "select stuno,sname,ssex,birthday from student";

        try {
            pst = conn.prepareStatement(sql);
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                System.out.print(resultSet.getInt("stuno") + "\t");
                System.out.print(resultSet.getString("sname") + "\t");
                System.out.print(resultSet.getString("ssex") + "\t");
                System.out.println(resultSet.getString("birthday") + "\t");
            }









        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,pst,resultSet);
        }

    }
}
