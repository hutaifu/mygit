package com.jxd.bookmanger.dao;

import com.jxd.bookmanger.model.Book;
import com.jxd.bookmanger.model.VoBook;

import java.util.List;

public interface IBookMangerDao {
    /**
     * 查询多个图书
     * @param snakey 姓名关键字
     * @param typeno 书类型
     * @return 返回图书集合
     */
    List<VoBook> selectmore(String snakey, Integer typeno);

    /**
     * 增加图书
     * @param Book 增加的图书对象
     * @return 是否成功
     */
    boolean addbook(Book Book);

    /**
     * 修改图书
     * @param bookno 要修改的图书编号
     * @param Book 修改后的图书
     * @return 是否成功
     */
    boolean upbook(int bookno, Book Book);

    /**
     * 查询单个图书
     * @param bookno 要查询的图书编号
     * @return 查询的图书对象
     */
    VoBook selectone(int bookno);

    /**
     * 删除多个图书
     * @param booknos 删除的图书编号数组
     * @return 是否成功
     */
    boolean delmore(int[] booknos);
}
