package com.jxd.petstore.dao.impl;

import com.jxd.petstore.dao.IPetStoreDao;
import com.jxd.petstore.model.Pet;
import com.jxd.petstore.model.PetOwner;
import com.jxd.petstore.model.PetStore;
import com.jxd.petstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PetStroreDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/14
 * @Version 1.0
 */

public class PetStroreDaoImpl implements IPetStoreDao {

    /**
     * 查询所有宠物商店信息
     *
     * @return 返回宠物商店列表
     */
    @Override
    public List<PetStore> getAllStore() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<PetStore> list = new ArrayList<>();

        String sql = "select ID,NAME,PASSWORD,BALANCE from petstore";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                PetStore petStore = new PetStore();
                petStore.setId(rs.getInt("ID"));
                petStore.setName(rs.getString("NAME"));
                petStore.setPasswore(rs.getString("PASSWORD"));
                petStore.setBalance(rs.getDouble("BALANCE"));
                list.add(petStore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return list;
    }

    /**
     * 跟新商店元宝
     *
     * @param num   商店id
     * @param money 修改金额
     * @return 是否成功
     */
    @Override
    public boolean updateMoney(int num, double money) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        String sql = "update petstore set BALANCE = BALANCE + ? where ID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setDouble(1,money);
            pst.setInt(2,num);
            int num2 = pst.executeUpdate();
            if (num2 > 0){
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst,null);
        }
        return isSuccess;
    }

    @Override
    public String getpwt(int id) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String password = "";

        String sql = "select PASSWORD from petstore where ID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            if (rs.next()){
                password = rs.getString("PASSWORD");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return password;
    }

    @Override
    public PetStore getPetStrore(int id) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        PetStore petOwner = new PetStore();

        String sql = "select ID,NAME,PASSWORD,BALANCE from petstore where ID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            while (rs.next()) {
                petOwner.setId(rs.getInt("ID"));
                petOwner.setName(rs.getString("NAME"));
                petOwner.setPasswore(rs.getString("PASSWORD"));
                petOwner.setBalance(rs.getDouble("MONEY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return petOwner;
    }

    @Override
    public List<Pet> getpet(int num) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Pet> list = new ArrayList<>();

        String sql = "select ID,NAME,TYPENAME from pet where STORE_ID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,num);
            rs = pst.executeQuery();
            while (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getInt("ID"));
                pet.setName(rs.getString("NAME"));
                pet.setTypename(rs.getString("TYPENAME"));
                list.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return list;
    }



}
