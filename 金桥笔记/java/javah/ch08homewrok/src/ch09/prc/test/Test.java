package ch09.prc.test;

import ch09.prc.dao.IBookDao;
import ch09.prc.dao.impl.BookImpl;
import ch09.prc.model.Book;

import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        Book book = new Book("三国演义",30,10);
        IBookDao bookDao = new BookImpl();
        bookDao.insert(book);

        List<Book> list = bookDao.showAll();
        for (Book b :list) {
            System.out.println(b.getBookno());
            System.out.println(b.getBookname());
            System.out.println(b.getBookpric());
            System.out.println(b.getBookremai());
        }



    }
}
