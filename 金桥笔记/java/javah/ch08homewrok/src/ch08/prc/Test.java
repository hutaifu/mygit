package ch08.prc;

import ch08.prc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        String sql = "insert into student (sname,ssex,birthday) values (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);

            pst.setString(1,"刘备");
            pst.setString(2,"男");
            pst.setString(3,"2000-11-12");
            int num1 = pst.executeUpdate();
            if (num1 > 0){
                System.out.println("增加成功");
            }

            pst.setString(1,"张飞");
            pst.setString(2,"男");
            pst.setString(3,"2000-03-01");

            int num = pst.executeUpdate();
            if (num > 0){
                System.out.println("增加成功");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,pst,null);
        }

    }
}
