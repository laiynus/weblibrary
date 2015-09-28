package by.khrapovitsky.service;


import by.khrapovitsky.model.Book;

import java.util.List;

public interface BookService {
    void create(Book book);
    Book read(String bookHash);
    void update(Book book);
    void delete(Book book);
    List getAllBooks();
}
