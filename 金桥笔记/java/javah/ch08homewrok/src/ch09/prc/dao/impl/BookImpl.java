package ch09.prc.dao.impl;

import ch08.prc.util.DBUtil;
import ch09.prc.dao.IBookDao;
import ch09.prc.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BookDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class BookImpl implements IBookDao {
    @Override
    public boolean insert(Book book) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        String sql = "insert into bookmanage (bookname,bookpric,bookrema) values (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,book.getBookname());
            pst.setDouble(2,book.getBookpric());
            pst.setInt(3,book.getBookremai());
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

    @Override
    public List<Book> showAll() {
        List<Book> list = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        String sql = "select bookno,bookname,bookpric,bookrema from bookmanage";
        try {
            pst = conn.prepareStatement(sql);
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setBookno(resultSet.getInt("bookno"));
                book.setBookname(resultSet.getString("bookname"));
                book.setBookpric(resultSet.getDouble("bookpric"));
                book.setBookremai(resultSet.getInt("bookrema"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,pst,resultSet);
        }
        return list;
    }
}
