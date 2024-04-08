package com.jxd.bookmanger.service.impl;

import com.jxd.bookmanger.dao.IBookDao;
import com.jxd.bookmanger.model.Book;
import com.jxd.bookmanger.model.VoBook;
import com.jxd.bookmanger.service.IBookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/31
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookDao bookMangerDao;

    /**
     * 查询部分图书
     *
     * @param snakey  姓名关键字
     * @param typeno 图书类型
     * @return 图书集合
     */
    @Override
    public List<VoBook> querymore(String snakey, Integer typeno,Integer limit,Integer page) {
        Integer count = (page-1) * limit;
        return bookMangerDao.selectMore(snakey,typeno,count,limit);
    }

    /**
     * 查询单个图书
     *
     * @param bookno
     * @return
     */
    @Override
    public Book queryone(int bookno) {
        return bookMangerDao.selectOne(bookno);
    }

    /**
     * 增加图书
     *
     * @param book
     * @return 是否成功
     */
    @Override
    public boolean addone(Book book) {
        return bookMangerDao.addBook(book);
    }

    /**
     * 修改图书
     *
     * @param book 修改后的图书
     * @return 是否成功
     */
    @Override
    public boolean up(Book book) {
        return bookMangerDao.upBook(book);
    }

    /**
     * 删除多个图书
     *
     * @param booknos 删除图书编号数组
     * @return 是否成功
     */
    @Override
    public boolean del(int[] booknos) {
       return bookMangerDao.delMore(booknos);
    }
}
