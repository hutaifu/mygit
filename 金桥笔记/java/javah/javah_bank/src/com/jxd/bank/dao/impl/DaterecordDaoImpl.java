package com.jxd.bank.dao.impl;

import com.jxd.bank.dao.IDaterecordDao;
import com.jxd.bank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName DaterecordDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class DaterecordDaoImpl implements IDaterecordDao {
    /**
     * 向操作记录表中添加记录
     *
     * @param num        账号
     * @param transType  操作类型
     * @param transMoney 操作金额
     * @param transDate  操作时间
     */
    @Override
    public void insert(int num, String transType, Double transMoney, String transDate) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;

        String sql = "insert into daterecord (cardID,transType,transMoney,transdate) values (?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,num);
            pst.setString(2,transType);
            pst.setDouble(3,transMoney);
            pst.setString(4,transDate);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,pst,null);
        }
    }

    /**
     * 删除一个账号所有信息
     *
     * @param num 要删除的账号
     */
    @Override
    public void delete(int num) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;

        String sql = "delete from daterecord where cardID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,num);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,pst,null);
        }
    }
}
