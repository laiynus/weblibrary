package by.khrapovitsky.dao;

import by.khrapovitsky.model.Bookmark;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookMarkRepository implements BookMarkDAO{

    private static final Logger log = Logger.getLogger(BookMarkRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(Bookmark bookmark) {
        log.info("Creating bookmark record");
        sessionFactory.getCurrentSession().save(bookmark);
    }

    @Override
    public Bookmark read(String bookmarkId) {
        log.info("Reading bookmark record");
        return (Bookmark) sessionFactory.getCurrentSession().get(Bookmark.class,bookmarkId);
    }

    @Override
    public void update(Bookmark bookmark) {
        log.info("Updating bookmark record");
        sessionFactory.getCurrentSession().update(bookmark);
    }

    @Override
    public void delete(Bookmark bookmark) {
        log.info("Deleting bookmark record");
        sessionFactory.getCurrentSession().delete(bookmark);
    }

    @Override
    public List getAllBookMarks() {
        log.info("Getting all bookmark records");
        return sessionFactory.getCurrentSession().createCriteria(Bookmark.class).list();
    }
}
