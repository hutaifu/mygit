package com.jxd.student.dao.impl;

import com.jxd.student.dao.IStudentDao;
import com.jxd.student.model.Student;
import com.jxd.student.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/25
 * @Version 1.0
 */

public class StudentDaoImpl implements IStudentDao {
    /**
     * 查询全部学生信息
     *
     * @return 学生对象集合
     */
    @Override
    public List<Student> selectAll(String key) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        boolean flag = false;

        String sql = "select sno,sname,ssex,age,address from student";
        if (key != null){
            sql = sql + " where sname like ?";
            flag = true;
        }

        try {
            pst = conn.prepareStatement(sql);
            if (flag) {
                pst.setString(1, "%" + key + "%");
            }
            rs = pst.executeQuery();

            while (rs.next()) {
                Student pet = new Student(
                rs.getInt("sno"),
                rs.getString("sname"),
                rs.getString("ssex"),
                rs.getInt("age"),
                rs.getString("address")
                );
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
     * 增加学生
     *
     * @param student 要增加的学生对象
     * @return 是否成功
     */
    @Override
    public boolean insert(Student student) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuceess = false;

        String sql = "insert into student (sno,sname,ssex,age,address) values (?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,student.getSno());
            pst.setString(2,student.getSname());
            pst.setString(3,student.getSsex());
            pst.setInt(4,student.getAge());
            pst.setString(5,student.getAddress());
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
     * 删除学生
     *
     * @param nums 删除学生学号
     * @return 是否成功
     */
    @Override
    public boolean delet(int[] nums) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        StringBuffer str = new StringBuffer("");
        for (int i = 0; i < nums.length; i++) {
            str = str.append("," +nums[i]);
        }
        str.replace(0,1,"");
        String str2 = str.toString();


        String sql = "delete from student where sno in (" + str2+ ")";
        try {
            pst = conn.prepareStatement(sql);
            int num1  = pst.executeUpdate();
            if (num1 > 0){
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,pst,null);
        }
        return isSuccess;
    }

    /**
     *
     * @param num 学号
     * @param student 修改后学生
     * @return 是否成功
     */
    @Override
    public boolean set(int num,Student student) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        String sql = "update student set sname = ?,ssex = ?,age = ?,address = ? where sno = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,student.getSname());
            pst.setString(2,student.getSsex());
            pst.setInt(3,student.getAge());
            pst.setString(4,student.getAddress());
            pst.setInt(5,num);
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
     * 查询单个学生
     *
     * @param sno 学号
     * @return 学生
     */
    @Override
    public Student getOne(int sno) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Student student = null;

        String sql = "select sno,sname,ssex,age,address from student where sno = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,sno);
            rs = pst.executeQuery();

            while (rs.next()) {
               student = new Student(
                        rs.getInt("sno"),
                        rs.getString("sname"),
                        rs.getString("ssex"),
                        rs.getInt("age"),
                        rs.getString("address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return student;
    }
}
