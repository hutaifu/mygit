package com.jxd.bookmanger.service.impl;

import com.jxd.bookmanger.dao.IBookTypeDao;
import com.jxd.bookmanger.model.VoBook;
import com.jxd.bookmanger.service.IBooktypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BooktypeServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/2
 * @Version 1.0
 */
@Service
public class BooktypeServiceImpl implements IBooktypeService {
    @Autowired
    IBookTypeDao bookTypeDao;
    /**
     * 得到所有图书类别
     *
     * @return 类别集合
     */
    @Override
    public List<VoBook> getType() {
        return bookTypeDao.selectType();
    }
}
