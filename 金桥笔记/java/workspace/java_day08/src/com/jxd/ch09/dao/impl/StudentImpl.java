package com.jxd.ch09.dao.impl;

import com.jxd.ch09.model.Student;
import com.jxd.ch09.util.DBUtil;
import com.jxd.ch09.dao.IStudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class StudentImpl implements IStudentDao {

    @Override
    public boolean insert(Student student) {
        Connection connection = DBUtil.getConn();
        PreparedStatement  pst = null;
        boolean isSuccess = false;

        String sql = "insert into student (sname,ssex,birthday) "+
                "values (?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,student.getSname());
            pst.setString(2,student.getSsex());
            pst.setString(3,student.getBirthday());

            int num = pst.executeUpdate();
            if (num > 0){
                isSuccess = true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,pst,null);
        }
        return isSuccess;
    }

    /**
     * 查询全部学生信息
     *
     * @return
     */
    @Override
    public List<Student> selectAll() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();

        String sql = "select stuno,sname,ssex,birthday from student";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            //遍历rs集合，将数据库中的每条数据封装为一个student对象，然后放到
            while (rs.next()){
                Student student = new Student();
                student.setStuno(rs.getInt("stuno"));
                student.setSname(rs.getString("sname"));
                student.setSsex(rs.getString("ssex"));
                student.setBirthday(rs.getString("birthday"));
                list.add(student);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,pst,rs);
        }
        return list;
    }

    /**
     * 更新学生信息
     *
     * @param student 学生全部信息
     * @return
     */
    @Override
    public boolean update(Student student) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        String sql = "update student set sname = ?,ssex = ?,birthday = ? where stuno = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,student.getSname());
            pst.setString(2,student.getSsex());
            pst.setString(3,student.getBirthday());
            pst.setInt(4,student.getStuno());
            int num = pst.executeUpdate();
            if (num > 0){
                isSuccess = true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,pst,null);
        }

        return isSuccess;
    }

    /**
     * 根据主键删除员工信息
     *
     * @param stuno
     * @return
     */
    @Override
    public boolean delete(int stuno) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        String sql = "delete from student where stuno = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,stuno);
            int num = pst.executeUpdate();

            if (num > 0){
                isSuccess = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,pst,null);
        }
        return isSuccess;
    }

    /**
     * 批量删除
     *
     * @param stunos 多个学号信息
     * @return
     */
    @Override
    public boolean deleteBatch(int[] stunos) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        //根据数组的长度动态的拼接sql
        String sql = "delete from student where stuno in (" ;
        for (int i = 0; i < stunos.length; i++) {
            sql += "?";
            if (i < stunos.length -1){
                sql += ",";
            }
        }
               sql += ")";
        try {
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < stunos.length; i++) {
                pst.setInt(i+1,stunos[i]);
            }
            //num中存储的是删除数据条数
            int num = pst.executeUpdate();
            if (num > 0){
                isSuccess = true;
            }





        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,pst,null);

        }
        return isSuccess;
    }


}
