package ch08.prc;

import ch08.prc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Test04 {
    public static void main(String[] args) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        Scanner input = new Scanner(System.in);

        String sql = "select sname from student where stuno = ?";
        try {
            System.out.println("请输入学号");
            int num = input.nextInt();
            System.out.println("请输入姓名");
            String sname1 = input.next();

            pst = conn.prepareStatement(sql);
            pst.setInt(1,num);
            resultSet = pst.executeQuery();
            if (resultSet.next()){
                String sname2 = resultSet.getString("sname");
                if (sname1.equals(sname2)){
                    System.out.println("存在该学生");
                }else {
                    System.out.println("不存在改学生");
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, resultSet);
        }

    }
}
