package com.jxd.bookmanger.test;

import com.jxd.bookmanger.dao.IBookMangerDao;
import com.jxd.bookmanger.dao.impl.BookMangerDaoImpl;
import com.jxd.bookmanger.model.VoBook;

import java.util.List;

/**
 * @ClassName Text
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/2
 * @Version 1.0
 */

public class Text {
    public static void main(String[] args) {
        IBookMangerDao bookMangerDao = new BookMangerDaoImpl();
        List<VoBook> list = bookMangerDao.selectmore(null,null);
        System.out.println(list.get(0).getBooktype());

    }
}
