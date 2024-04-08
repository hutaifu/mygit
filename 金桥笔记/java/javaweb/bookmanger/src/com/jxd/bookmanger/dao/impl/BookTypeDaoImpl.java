package com.jxd.bookmanger.dao.impl;

import com.jxd.bookmanger.dao.IBookTypeDao;
import com.jxd.bookmanger.model.VoBook;
import com.jxd.bookmanger.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BookTypeDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/2
 * @Version 1.0
 */

public class BookTypeDaoImpl implements IBookTypeDao {
    /**
     * 查询全部图书类别
     *
     * @return 类别集合
     */
    @Override
    public List<VoBook> selecttype() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<VoBook> list = new ArrayList<>();

        String sql = "select typename,typeno from booktype";

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                VoBook voBook = new VoBook();
                voBook.setTypeno(rs.getInt("typeno"));
                voBook.setBooktype(rs.getString("typename"));
                list.add(voBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return list;

    }
}
