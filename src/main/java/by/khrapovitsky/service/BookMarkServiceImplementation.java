package by.khrapovitsky.service;

import by.khrapovitsky.dao.BookMarkDAO;
import by.khrapovitsky.model.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookMarkServiceImplementation implements BookMarkService{

    @Autowired
    BookMarkDAO bookMarkDAO;

    @Override
    public void create(Bookmark bookmark) {
        bookMarkDAO.create(bookmark);
    }

    @Override
    public Bookmark read(String bookmarkId) {
        return bookMarkDAO.read(bookmarkId);
    }

    @Override
    public void update(Bookmark bookmark) {
        bookMarkDAO.update(bookmark);
    }

    @Override
    public void delete(Bookmark bookmark) {
        bookMarkDAO.delete(bookmark);
    }

    @Override
    public List getAllBookMarks() {
        return bookMarkDAO.getAllBookMarks();
    }
}
