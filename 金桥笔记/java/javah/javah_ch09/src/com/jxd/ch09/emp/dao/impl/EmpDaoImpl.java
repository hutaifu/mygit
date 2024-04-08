package com.jxd.ch09.emp.dao.impl;

import com.jxd.ch09.emp.dao.IEmpDao;
import com.jxd.ch09.emp.util.DBUtil;
import com.jxd.ch09.emp.vo.EmpWithDeptVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/10
 * @Version 1.0
 */

public class EmpDaoImpl implements IEmpDao {
    @Override
    public List<Map<String, Object>> selectEmpwithDept(String name) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Map<String, Object>> list = new ArrayList<>();
        String sql = "select empno,ename,job,hirdate,sal,dename from emp e " +
                "inner join dept d on e.deptno = d.deptno";

        if (name != null){
            sql += "where ename like ?";
        }
        try {
            pst = conn.prepareStatement(sql);
            if (name != null){
                pst.setString(1,"%" + name + "%");
            }
            rs = pst.executeQuery();

            //遍历结果集其中每一条数据封装称Map对象，然后把map放到list中
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("empno", rs.getInt("empno"));
                map.put("ename", rs.getString("ename"));
                map.put("job", rs.getString("job"));
                map.put("hirdate", rs.getString("hirdate"));
                map.put("sal", rs.getDouble("sal"));
                map.put("dename", rs.getString("dename"));
                list.add(map);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }


        return list;
    }

    @Override
    public List<EmpWithDeptVO> selectEmpWithDept02() {
        return null;
    }
}

    /*@Override
    public List<EmpWithDept> selectEmpWithDept02() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Map<String,Object>> list = new ArrayList<>();
        String sql = "select empno,ename,job,hirdate,sal,dename from emp e " +
                "inner join dept d on e.deptno = d.deptno";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            //遍历结果集其中每一条数据封装称Map对象，然后把map放到list中
            while (rs.next()){
                EmpWithDept map = new EmpWithDept();
                map.setDename(rs."dename");
                map.setEmpno("empno");
                map.setEname("ename");
                map.setHirdate("hirdate");
                list.add(map);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,pst,rs);
        }


        return list;
    }
}
*/