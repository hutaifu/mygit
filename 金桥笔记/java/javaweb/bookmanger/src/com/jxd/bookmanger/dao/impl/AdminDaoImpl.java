package com.jxd.bookmanger.dao.impl;

import com.jxd.bookmanger.dao.IAdminDao;
import com.jxd.bookmanger.model.Admin;
import com.jxd.bookmanger.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName AdminDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/31
 * @Version 1.0
 */

public class AdminDaoImpl implements IAdminDao {
    /**
     * 增加管理员
     *
     * @param admin 要增加的管理员对象
     * @return 是否成功
     */
    @Override
    public boolean addone(Admin admin) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuceess = false;

        String sql = "insert into admin (aduser,adpwd,adright) values (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,admin.getAduser());
            pst.setString(2,admin.getAdpwd());
            pst.setInt(3,admin.getAdright());

            int num = pst.executeUpdate();
            if (num > 0){
                isSuceess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,pst,null);
        }
        return  isSuceess;
    }

    /**
     * 查询单个图书管理员对象
     *
     * @param adno 要查询对象的编号
     * @return 查询的对象
     */
    @Override
    public Admin selectone(int adno) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Admin admin = null;

        String sql = "select adno,aduser,adpwd,adright from admin where adno = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,adno);
            rs = pst.executeQuery();
            if (rs.next()) {
               admin = new Admin(
                        rs.getInt("adno"),
                        rs.getString("aduser"),
                        rs.getString("adpwd"),
                        rs.getInt("adright")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return admin;
    }
}
