package com.jxd.emp.service.impl;


import com.jxd.emp.dao.IBookMangerDao;
import com.jxd.emp.model.VoBook;
import com.jxd.emp.service.IBookService;
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
    IBookMangerDao bookMangerDao;

    /**
     * 查询部分图书
     *
     * @param key  姓名关键字
     * @param type 图书类型
     * @return 图书集合
     */
    @Override
    public List<VoBook> querymore(String key, Integer type) {
        return bookMangerDao.selectMore(key,type);
    }


}
