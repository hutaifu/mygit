package com.jxd.stu.dao.impl;

import com.jxd.stu.dao.IStudentDao;
import com.jxd.stu.model.Student;
import com.jxd.stu.util.DBUtil;

import java.awt.image.DataBuffer;
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
 * @Author lixiaoru
 * @Date 2022/8/29
 * @Version 1.0
 */
public class StudentDaoImpl implements IStudentDao {
    @Override
    public List<Student> selectStuBySname(String sname) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();

        String sql = "select sno,sname,ssex,sage,address,birthday from student ";
        if(sname != null){
            sql += " where sname like ?";
        }

        try {
            pst = conn.prepareStatement(sql);
            if(sname != null){
                pst.setString(1,"%" + sname + "%");
            }
            rs = pst.executeQuery();

            while(rs.next()){
                Student student = new Student();
                student.setSno(rs.getInt("sno"));
                student.setSname(rs.getString("sname"));
                student.setSsex(rs.getString("ssex"));
                student.setSage(rs.getInt("sage"));
                student.setAddress(rs.getString("address"));
                student.setBirthday(rs.getString("birthday"));

                list.add(student);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,pst,rs);
        }

        return list;
    }

    @Override
    public List<Student> selectStuByPage(String sname, int page, int limit) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();

        String sql = "select sno,sname,ssex,sage,address,birthday from student ";
        if(sname != null){
            sql += " where sname like ?";
        }
        sql += " limit ?,?";

        try {
            pst = conn.prepareStatement(sql);
            if(sname != null){
                pst.setString(1,"%" + sname + "%");
                pst.setInt(2,(page - 1) * limit);
                pst.setInt(3,limit);
            } else  {
                pst.setInt(1,(page - 1) * limit);
                pst.setInt(2,limit);
            }

            rs = pst.executeQuery();

            while(rs.next()){
                Student student = new Student();
                student.setSno(rs.getInt("sno"));
                student.setSname(rs.getString("sname"));
                student.setSsex(rs.getString("ssex"));
                student.setSage(rs.getInt("sage"));
                student.setAddress(rs.getString("address"));
                student.setBirthday(rs.getString("birthday"));

                list.add(student);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,pst,rs);
        }

        return list;
    }

    @Override
    public Student selectOneBySno(int sno) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Student student = new Student();

        String sql = "select sno,sname,ssex,sage,address,birthday from student where sno = ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,sno);
            rs = pst.executeQuery();

            if(rs.next()){
                student.setSno(rs.getInt("sno"));
                student.setSname(rs.getString("sname"));
                student.setSsex(rs.getString("ssex"));
                student.setSage(rs.getInt("sage"));
                student.setAddress(rs.getString("address"));
                student.setBirthday(rs.getString("birthday"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,pst,rs);
        }

        return student;
    }

    @Override
    public boolean addStu(Student student) {
        return false;
    }

    @Override
    public boolean updateStu(Student student) {
        return false;
    }

    @Override
    public List<Map<String, Object>> selectStuWithCls(String sname, int page, int limit) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Map<String, Object>> list = new ArrayList<>();

        String sql = "select sno,sname,ssex,sage,address,birthday,cname from student s " +
                "left join cls c on s.cls = c.cno ";
        if(sname != null){
            sql += " where sname like ?";
        }
        sql += " limit ?,?";

        try {
            pst = conn.prepareStatement(sql);
            if(sname != null){
                pst.setString(1,"%" + sname + "%");
                pst.setInt(2,(page - 1) * limit);
                pst.setInt(3,limit);
            } else  {
                pst.setInt(1,(page - 1) * limit);
                pst.setInt(2,limit);
            }

            rs = pst.executeQuery();

            while(rs.next()){
                Map<String,Object> map = new HashMap<>();
                map.put("sno",rs.getInt("sno"));
                map.put("sname",rs.getString("sname"));
                map.put("ssex",rs.getString("ssex"));
                map.put("sage",rs.getInt("sage"));
                map.put("address",rs.getString("address"));
                map.put("birthday",rs.getString("birthday"));
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
