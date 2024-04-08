package com.jxd.bookmanger.service.impl;

import com.jxd.bookmanger.dao.IBookMangerDao;
import com.jxd.bookmanger.dao.impl.BookMangerDaoImpl;
import com.jxd.bookmanger.model.Book;
import com.jxd.bookmanger.model.VoBook;
import com.jxd.bookmanger.service.IBookService;

import java.util.List;

/**
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/31
 * @Version 1.0
 */

public class BookServiceImpl implements IBookService {
    private IBookMangerDao bookMangerDao = new BookMangerDaoImpl();

    /**
     * 查询部分图书
     *
     * @param key  姓名关键字
     * @param typeno 图书类型
     * @return 图书集合
     */
    @Override
    public List<VoBook> querymore(String key, Integer typeno) {
        return bookMangerDao.selectmore(key,typeno);
    }

    /**
     * 查询单个图书
     *
     * @param bookno
     * @return
     */
    @Override
    public VoBook queryone(int bookno) {
        return bookMangerDao.selectone(bookno);
    }

    /**
     * 增加图书
     *
     * @param book
     * @return 是否成功
     */
    @Override
    public boolean addone(Book book) {
        return bookMangerDao.addbook(book);
    }

    /**
     * 修改图书
     *
     * @param book 修改后的图书
     * @return 是否成功
     */
    @Override
    public boolean up(int bookno, Book book) {
        return bookMangerDao.upbook(bookno, book);
    }

    /**
     * 删除多个图书
     *
     * @param booknos 删除图书编号数组
     * @return 是否成功
     */
    @Override
    public boolean del(int[] booknos) {
       return bookMangerDao.delmore(booknos);
    }
}
