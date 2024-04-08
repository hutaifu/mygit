package ch09.prc.service.impl;

import ch09.prc.dao.IBookDao;
import ch09.prc.dao.impl.BookImpl;
import ch09.prc.model.Book;
import ch09.prc.service.IBookManService;

/**
 * @ClassName BookManServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class BookManServiceImpl implements IBookManService {
    private IBookDao bookDao = new BookImpl();
    @Override
    public boolean add(Book book) {
        return bookDao.insert(book);
    }

    @Override
    public void showAll() {
        bookDao.showAll();
    }
}
