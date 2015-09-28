package by.khrapovitsky.dao;

import by.khrapovitsky.model.Book;
import by.khrapovitsky.model.Role;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository implements BookDAO{

    private static final Logger log = Logger.getLogger(BookRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Book book) {
        log.info("Creating book record");
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public Book read(String bookHash) {
        log.info("Reading book record");
        return (Book) sessionFactory.getCurrentSession().get(Book.class,bookHash);
    }

    @Override
    public void update(Book book) {
        log.info("Updating book record");
        sessionFactory.getCurrentSession().update(book);
    }

    @Override
    public void delete(Book book) {
        log.info("Deleting book record");
        sessionFactory.getCurrentSession().delete(book);
    }

    @Override
    public List getAllBooks() {
        log.info("Getting all book records");
        return sessionFactory.getCurrentSession().createCriteria(Role.class).list();
    }
}
