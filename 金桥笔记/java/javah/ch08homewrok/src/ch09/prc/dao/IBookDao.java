package ch09.prc.dao;

import ch09.prc.model.Book;

import java.util.List;

public interface IBookDao {
    boolean insert(Book book);

    List<Book> showAll();
}
