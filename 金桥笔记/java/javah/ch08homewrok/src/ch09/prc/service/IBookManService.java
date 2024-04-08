package ch09.prc.service;

import ch09.prc.model.Book;

public interface IBookManService {
    boolean add(Book book);
    void showAll();
}
