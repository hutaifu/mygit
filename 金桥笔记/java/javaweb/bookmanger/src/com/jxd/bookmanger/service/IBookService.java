package com.jxd.bookmanger.service;

import com.jxd.bookmanger.model.Book;
import com.jxd.bookmanger.model.VoBook;

import java.util.List;

public interface IBookService {

    /**
     * 查询部分图书
     * @param key 姓名关键字
     * @param type 图书类型
     * @return 图书集合
     */
    List<VoBook> querymore(String key, Integer type);

    /**
     * 查询单个图书
     * @param bookno
     * @return
     */
    VoBook queryone(int bookno);

    /**
     * 增加图书
     * @return 是否成功
     */
    boolean addone(Book book);

    /**
     * 修改图书
     * @param book 修改后的图书
     * @return 是否成功
     */
    boolean up(int bookno, Book book);

    /**
     * 删除多个图书
     * @param booknos 删除图书编号数组
     * @return 是否成功
     */
    boolean del(int[] booknos);
}
