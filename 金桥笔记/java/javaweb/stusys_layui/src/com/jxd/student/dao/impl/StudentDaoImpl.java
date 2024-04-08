package com.jxd.student.dao.impl;

import com.jxd.student.dao.IStudentDao;
import com.jxd.student.model.Student;
import com.jxd.student.util.DBUtil;
import javafx.beans.binding.ObjectExpression;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/29
 * @Version 1.0
 */

public class StudentDaoImpl implements IStudentDao {

    /**
     * 查询全部或者按照姓名模糊查询
     *
     * @param sname 查询添加
     * @return
     */
    @Override
    public List<Student> selectStuSname(String sname) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();

        String sql = "select sno,sname,ssex,age,address,birthday from student ";
        if (sname != null){
            sql += "where sname like ?";
        }
        try {
            pst = conn.prepareStatement(sql);
            if (sname != null){
                pst.setString(1,"%" + sname + "%");
            }
            rs = pst.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setSno(rs.getInt("sno"));
                student.setSname(rs.getString("sname"));
                student.setAge(rs.getInt("age"));
                student.setAddress(rs.getString("address"));
                student.setBirthday(rs.getString("birthday"));
                student.setSsex(rs.getString("ssex"));
                list.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,pst,rs);
        }
        return list;
    }

    /**
     * 分页查询
     *
     * @param sname 条件
     * @param page  当前页码
     * @param limit 每页显示条数
     * @return
     */
    @Override
    public List<Student> selectByPage(String sname, int page, int limit) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();

        String sql = "select sno,sname,ssex,age,address,birthday from student ";
        if (sname != null){
            sql += "where sname like ?";
        }
        sql += " limit ?,?";

        try {
            pst = conn.prepareStatement(sql);
            if (sname != null){
                pst.setString(1,"%" + sname + "%");
                pst.setInt(2,(page-1)*limit);
                pst.setInt(3,limit);
            }
            pst.setInt(1,(page-1)*limit);
            pst.setInt(2,limit);
            rs = pst.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setSno(rs.getInt("sno"));
                student.setSname(rs.getString("sname"));
                student.setAge(rs.getInt("age"));
                student.setAddress(rs.getString("address"));
                student.setBirthday(rs.getString("birthday"));
                student.setSsex(rs.getString("ssex"));
                list.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,pst,rs);
        }
        return list;
    }

    /**
     * 根据学号获取学生信息
     *
     * @param sno
     * @return
     */
    @Override
    public Student selectOneBySno(int sno) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Student student = new Student();

        String sql = "select sno,sname,ssex,age,address,birthday from student where sno = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,sno);
            rs = pst.executeQuery();
            if (rs.next()){
                student.setSno(rs.getInt("sno"));
                student.setSname(rs.getString("sname"));
                student.setAge(rs.getInt("age"));
                student.setAddress(rs.getString("address"));
                student.setBirthday(rs.getString("birthday"));
                student.setSsex(rs.getString("ssex"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,pst,rs);
        }
        return student;
    }

    /**
     * 修改学生信息
     *
     * @param student
     * @return
     */
    @Override
    public boolean addStu(Student student) {
        return false;
    }


    @Override
    public List<Map<String, Object>> selectStuWithCls(String sname, int page, int limit) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Map<String,Object>> list = new ArrayList<>();

        String sql = "select sno,sname,ssex,age,address,birthday,cname from student s " +
                "left join cls c on s.cno = c.cno ";
        if (sname != null){
            sql += "where sname like ?";
        }
        sql += " limit ?,?";

        try {
            pst = conn.prepareStatement(sql);
            if (sname != null){
                pst.setString(1,"%" + sname + "%");
                pst.setInt(2,(page-1)*limit);
                pst.setInt(3,limit);
            }
            pst.setInt(1,(page-1)*limit);
            pst.setInt(2,limit);
            rs = pst.executeQuery();
            while (rs.next()){
                Map<String, Object> map = new HashMap<>();
                map.put("sno",rs.getInt("sno"));
                map.put("sname",rs.getString("sname"));
                map.put("age",rs.getInt("age"));
                map.put("address",rs.getString("address"));
                map.put("birthday",rs.getString("birthday"));
                map.put("ssex",rs.getString("ssex"));
                map.put("cname",rs.getString("cname"));
                list.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,pst,rs);
        }
        return list;
    }
}
