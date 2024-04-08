package com.jxd.test.dao.impl;

import com.jxd.test.dao.IMessageDao;
import com.jxd.test.model.Message;
import com.jxd.test.util.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MessageDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/15
 * @Version 1.0
 */

public class MessageDaoImpl implements IMessageDao {
    /**
     * 显示所有留言
     *
     * @return 留言集合
     */
    @Override
    public List<Message> shwo() {
        Connection conn = BaseDao.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Message> list = new ArrayList<>();

        String sql = "select Id,userName,title,contents,createTime from message ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("Id"));
                message.setUserName(rs.getString("userName"));
                message.setTitle(rs.getString("title"));
                message.setContents(rs.getString("contents"));
                message.setCreateTime(rs.getString("createTime"));
                list.add(message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(conn, pst, rs);
        }
        return list;
    }

    /**
     * 添加留言
     *
     * @param message 添加的留言信息
     * @return 是否成功
     */
    @Override
    public boolean insert(Message message) {
        Connection conn = BaseDao.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        String sql = "insert into message (userName,title,contents,createTime) values (?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,message.getUserName());
            pst.setString(2,message.getTitle());
            pst.setString(3,message.getContents());
            pst.setString(4,message.getCreateTime());
            int num = pst.executeUpdate();
            if (num > 0){
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(conn, pst, null);
        }
        return isSuccess;
    }
}
