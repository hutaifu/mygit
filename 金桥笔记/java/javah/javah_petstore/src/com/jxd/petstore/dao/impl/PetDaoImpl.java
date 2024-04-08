package com.jxd.petstore.dao.impl;

import com.jxd.petstore.dao.IPetDao;
import com.jxd.petstore.model.Pet;
import com.jxd.petstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PetDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/14
 * @Version 1.0
 */

public class PetDaoImpl implements IPetDao {
    /**
     * 查询所有宠物信息
     */
    @Override
    public void getAllPet() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Pet> list = new ArrayList<>();

        String sql = "select ID,NAME from pet ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getInt("ID"));
                pet.setName(rs.getString("NAME"));
                list.add(pet);
            }
            for (Pet p: list) {
                System.out.println("第" + p.getId() + "个宠物，名字叫：" + p.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
    }

    /**
     * 根据输入数字查询所有库存或者培育宠物
     *
     * @param num 输入数字代表库存或者培育
     * @return  宠物集合
     */
    @Override
    public List<Pet> getInstock(int num) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Pet> list = new ArrayList<>();

        String sql = "select ID,NAME,TYPENAME,OWNER_ID,STORE_ID,Balance from pet where TYPE = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,num);
            rs = pst.executeQuery();
            while (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getInt("ID"));
                pet.setName(rs.getString("NAME"));
                pet.setTypename(rs.getString("TYPENAME"));
                pet.setOwner_id(rs.getInt("OWNER_ID"));
                pet.setStore_id(rs.getInt("STORE_ID"));
                pet.setBalance(rs.getDouble("Balance"));
                list.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return list;
    }

    /**
     * 更新宠物主人
     *
     * @param num  宠物id
     * @param num1 主人id
     * @return 返回是否成功
     */
    @Override
    public boolean updateOwner(int num, int num1) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        String sql = "update pet set OWNER_ID = ? and STORE_ID = 0 where ID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,num1);
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

    public boolean updateStore(int num, int num1) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        String sql = "update pet set STORE_ID = ? and OWNER_ID = 0 where ID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,num1);
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
}
