package com.jxd.bookmanger.service.impl;

import com.jxd.bookmanger.dao.IBookTypeDao;
import com.jxd.bookmanger.dao.impl.BookTypeDaoImpl;
import com.jxd.bookmanger.model.VoBook;
import com.jxd.bookmanger.service.IBookService;
import com.jxd.bookmanger.service.IBooktypeService;

import java.util.List;

/**
 * @ClassName BooktypeServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/2
 * @Version 1.0
 */

public class BooktypeServiceImpl implements IBooktypeService {
    private IBookTypeDao bookTypeDao = new BookTypeDaoImpl();
    /**
     * 得到所有图书类别
     *
     * @return 类别集合
     */
    @Override
    public List<VoBook> getType() {
        return bookTypeDao.selecttype();
    }
}
