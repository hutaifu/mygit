package com.jxd.bookmanger.dao.impl;

import com.jxd.bookmanger.dao.IBookMangerDao;
import com.jxd.bookmanger.model.Book;
import com.jxd.bookmanger.model.VoBook;
import com.jxd.bookmanger.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BookMangerDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/31
 * @Version 1.0
 */

public class BookMangerDaoImpl implements IBookMangerDao {
    /**
     * 查询多个图书
     *
     * @param snakey 姓名关键字
     * @param typeno  书类型
     * @return 返回图书集合
     */
    @Override
    public List<VoBook> selectmore(String snakey, Integer typeno) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<VoBook> list = new ArrayList<>();

        String sql = "select bookno,booksname,eitor,puber,pubdate,booknum,bookpri,typename,b.typeno from bookmanger b left join booktype t on b.typeno = t.typeno";
        if (snakey != null){
            sql += " where booksname like ?";
        }
        if (typeno != null){
            sql += " and b.typeno = ?";
        }
        try {
            pst = conn.prepareStatement(sql);
            if (snakey != null){
                pst.setString(1,"%" +snakey + "%");
            }
            if (typeno != null){
                pst.setInt(2,typeno);
            }

            rs = pst.executeQuery();
            while (rs.next()) {
                VoBook voBook = new VoBook(
                        rs.getInt("bookno"),
                        rs.getString("booksname"),
                        rs.getString("eitor"),
                        rs.getString("puber"),
                        rs.getString("pubdate"),
                        rs.getInt("booknum"),
                        rs.getDouble("bookpri"),
                        rs.getString("typename"),
                        rs.getInt("typeno")
                );
                list.add(voBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return list;
    }


    /**
     * 增加图书
     *
     * @param Book 增加的图书对象
     * @return 是否成功
     */
    @Override
    public boolean addbook(Book Book) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuceess = false;

        String sql = "insert into bookmanger (booksname,eitor,puber,pubdate,booknum,bookpri,typeno) values (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, Book.getBooksname());
            pst.setString(2, Book.getEitor());
            pst.setString(3, Book.getPuber());
            pst.setString(4, Book.getPubdate());
            pst.setInt(5, Book.getBooknum());
            pst.setDouble(6, Book.getBookpri());
            pst.setInt(7, Book.getTypeno());
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
     * 修改图书
     *
     * @param bookno 要修改的图书编号
     * @param book   修改后的图书
     * @return 是否成功
     */
    @Override
    public boolean upbook(int bookno, Book book) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        String sql = "update bookmanger set booksname=?,eitor=?,puber=?,pubdate=?,booknum=?,bookpri=?,typeno=? where bookno = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, book.getBooksname());
            pst.setString(2, book.getEitor());
            pst.setString(3, book.getPuber());
            pst.setString(4, book.getPubdate());
            pst.setInt(5, book.getBooknum());
            pst.setDouble(6, book.getBookpri());
            pst.setInt(7,book.getTypeno());
            pst.setInt(8, bookno);
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
     * 查询单个图书
     *
     * @param bookno 要查询的图书编号
     * @return 查询的图书对象
     */
    @Override
    public VoBook selectone(int bookno) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        VoBook voBook = null;

        String sql = "select bookno,booksname,eitor,puber,pubdate,booknum,bookpri,typename,b.typeno from bookmanger b left join booktype t on b.typeno = t.typeno where bookno = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,bookno);
            rs = pst.executeQuery();
            if (rs.next()) {
                 voBook = new VoBook(
                        rs.getInt("bookno"),
                        rs.getString("booksname"),
                        rs.getString("eitor"),
                        rs.getString("puber"),
                        rs.getString("pubdate"),
                        rs.getInt("booknum"),
                        rs.getDouble("bookpri"),
                        rs.getString("typename"),
                         rs.getInt("typeno")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return voBook;
    }

    /**
     * 删除多个图书
     *
     * @param booknos 删除的图书编号数组
     * @return 是否成功
     */
    @Override
    public boolean delmore(int[] booknos) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        StringBuffer str = new StringBuffer("");
        for (int i = 0; i < booknos.length; i++) {
            str = str.append("," +booknos[i]);
        }
        str.replace(0,1,"");
        String str2 = str.toString();


        String sql = "delete from bookmanger where bookno in (" + str2+ ")";
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
}
