package by.khrapovitsky.dao;


import by.khrapovitsky.model.Book;

import java.util.List;

public interface BookDAO {
    void create(Book book);
    Book read(String bookHash);
    void update(Book book);
    void delete(Book book);
    List getAllBooks();
}

