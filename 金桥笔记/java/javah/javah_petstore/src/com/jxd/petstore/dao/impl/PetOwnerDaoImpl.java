package com.jxd.petstore.dao.impl;

import com.jxd.petstore.dao.IPetOwnerDao;
import com.jxd.petstore.model.Pet;
import com.jxd.petstore.model.PetOwner;
import com.jxd.petstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PetOwnerDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/14
 * @Version 1.0
 */

public class PetOwnerDaoImpl implements IPetOwnerDao {

    /**
     * 查询所有宠物主人信息
     *
     * @return 返回宠物主人集合
     */
    @Override
    public List<PetOwner> getAllOwner() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<PetOwner> list = new ArrayList<>();

        String sql = "select ID,NAME,PASSWORD,MONEY from petowner";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                PetOwner petOwner = new PetOwner();
                petOwner.setId(rs.getInt("ID"));
                petOwner.setName(rs.getString("NAME"));
                petOwner.setPassword(rs.getString("PASSWORD"));
                petOwner.setMeney(rs.getDouble("MONEY"));
                list.add(petOwner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return list;
    }

    /**
     * 根据id查找密码
     *
     * @param id 主人id
     * @return 返回密码
     */
    @Override
    public String selecPasswore(int id) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String password = "";

        String sql = "select PASSWORD from petowner where ID = ?";
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

    /**
     * 根据id查询信息
     *
     * @param id 主人id
     * @return 返回宠物主人
     */
    @Override
    public PetOwner selectOwner(int id) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        PetOwner petOwner = new PetOwner();

        String sql = "select ID,NAME,PASSWORD,MONEY from petowner where ID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            while (rs.next()) {
                petOwner.setId(rs.getInt("ID"));
                petOwner.setName(rs.getString("NAME"));
                petOwner.setPassword(rs.getString("PASSWORD"));
                petOwner.setMeney(rs.getDouble("MONEY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return petOwner;
    }

    /**
     * 更新主人元宝
     *
     * @param id    主人id
     * @param money 修改的金额
     * @return 是否成功
     */
    @Override
    public boolean updateMoney(int id, double money) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        String sql = "update petowner set MONEY = MONEY + ? where ID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setDouble(1,money);
            pst.setInt(2,id);
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

    /**
     * 显示主人宠物列表
     *
     * @param num 主人id
     * @return 返回宠物列表
     */
    @Override
    public List<Pet> shwopet(int num) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Pet> list = new ArrayList<>();

        String sql = "select ID,NAME,TYPENAME from pet where OWNER_ID = ?";
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
