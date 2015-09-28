package by.khrapovitsky.service;

import by.khrapovitsky.dao.BookDAO;
import by.khrapovitsky.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImplementation implements BookService{

    @Autowired
    BookDAO bookDAO;


    @Override
    public void create(Book book) {
        bookDAO.create(book);
    }

    @Override
    public Book read(String bookHash) {
        return bookDAO.read(bookHash);
    }

    @Override
    public void update(Book book) {
        bookDAO.update(book);
    }

    @Override
    public void delete(Book book) {
        bookDAO.delete(book);
    }

    @Override
    public List getAllBooks() {
        return bookDAO.getAllBooks();
    }
}
