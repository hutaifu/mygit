package com.jxd.bookmanger.dao;

import com.jxd.bookmanger.model.Book;
import com.jxd.bookmanger.model.VoBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBookDao {
    /**
     * 查询多个图书
     * @param snakey 姓名关键字
     * @param typeno 书类型
     * @return 返回图书集合
     */
    List<VoBook> selectMore(@Param("snakey") String snakey, @Param("typeno") Integer typeno,@Param("count") Integer count,@Param("limit") Integer limit);

    /**
     * 增加图书
     * @param Book 增加的图书对象
     * @return 是否成功
     */
    boolean addBook(Book Book);

    /**
     * 修改图书
     * @param Book 修改后的图书
     * @return 是否成功
     */
    boolean upBook(Book Book);

    /**
     * 查询单个图书
     * @param bookno 要查询的图书编号
     * @return 查询的图书对象
     */
    Book selectOne(int bookno);

    /**
     * 删除多个图书
     * @param booknos 删除的图书编号数组
     * @return 是否成功
     */
    boolean delMore(int[] booknos);
}
