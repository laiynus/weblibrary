package by.khrapovitsky.dao;

import by.khrapovitsky.model.Author;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository implements AuthorDAO{

    private static final Logger log = Logger.getLogger(AuthorRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(Author author) {
        log.info("Creating author record");
        sessionFactory.getCurrentSession().save(author);
    }

    @Override
    public Author read(String authorId) {
        log.info("Reading author record");
        return (Author) sessionFactory.getCurrentSession().get(Author.class,authorId);
    }

    @Override
    public void update(Author author) {
        log.info("Updating author record");
        sessionFactory.getCurrentSession().update(author);
    }

    @Override
    public void delete(Author author) {
        log.info("Deleting author record");
        sessionFactory.getCurrentSession().delete(author);
    }

    @Override
    public List getAllAuthors() {
        log.info("Getting all author records");
        return sessionFactory.getCurrentSession().createCriteria(Author.class).list();
    }
}
