package com.jxd.stu.dao.impl;

import com.jxd.stu.dao.IClsDao;
import com.jxd.stu.model.Cls;
import com.jxd.stu.model.Student;
import com.jxd.stu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ClsDaoImpl
 * @Description TODO
 * @Author lixiaoru
 * @Date 2022/9/1
 * @Version 1.0
 */
public class ClsDaoImpl implements IClsDao {
    @Override
    public List<Cls> selectAllCls() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Cls> list = new ArrayList<>();

        String sql = "select cno,cname from cls ";


        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()){
                Cls cls = new Cls(rs.getInt("cno"),
                        rs.getString("cname"));
                list.add(cls);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,pst,rs);
        }

        return list;
    }
}
