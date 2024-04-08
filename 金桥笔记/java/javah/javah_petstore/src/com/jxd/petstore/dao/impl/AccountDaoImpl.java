package com.jxd.petstore.dao.impl;

import com.jxd.petstore.dao.IAccountDao;
import com.jxd.petstore.model.Account;
import com.jxd.petstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AccountDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/14
 * @Version 1.0
 */

public class AccountDaoImpl implements IAccountDao {
    /**
     * 添加账目
     *
     * @param account 添加的账目
     * @return 是否成功
     */
    @Override
    public boolean insert(Account account) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuceess = false;

        String sql = "insert into petaccount (ID,DEAL_TYPE,PET_ID,SELLER_ID,BUYER_ID,PRICE,DEAL_TIME) values (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,account.getId());
            pst.setInt(2,account.getDeal_type());
            pst.setInt(3,account.getPet_id());
            pst.setInt(4,account.getSelller_id());
            pst.setInt(5,account.getBuyer_id());
            pst.setDouble(6,account.getPrice());
            pst.setString(7,account.getDeal_time());
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
     * 根据商店id拿到交易记录
     *
     * @param id 商店id
     * @return 返回交易记录集合
     */
    @Override
    public List<Account> shwo(int id) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Account> list = new ArrayList<>();

        String sql = "select ID,DEAL_TYPE,PET_ID,SELLER_ID,BUYER_ID,PRICE,DEAL_TIME, from pet where(DEAL_TYPE = 1 and SELLER_ID = ?) or (DEAL_TYPE = 2 and BUYER_ID = ?) ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("ID"));
                account.setDeal_type(rs.getInt("DEAL_TYPE"));
                account.setPet_id(rs.getInt("PET_ID"));
                account.setSelller_id(rs.getInt("SELLER_ID"));
                account.setSelller_id(rs.getInt("BUYER_ID"));
                account.setPrice(rs.getDouble("PRICE"));
                account.setDeal_time(rs.getString("DEAL_TIME"));
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return list;
    }
}

