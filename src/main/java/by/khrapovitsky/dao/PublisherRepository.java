package by.khrapovitsky.dao;

import by.khrapovitsky.model.Publisher;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PublisherRepository implements PublisherDAO{

    private static final Logger log = Logger.getLogger(PublisherRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(Publisher publisher) {
        log.info("Creating publisher record");
        sessionFactory.getCurrentSession().save(publisher);
    }

    @Override
    public Publisher read(int publisherId) {
        log.info("Reading publisher record");
        return (Publisher) sessionFactory.getCurrentSession().get(Publisher.class,publisherId);
    }

    @Override
    public void update(Publisher publisher) {
        log.info("Updating publisher record");
        sessionFactory.getCurrentSession().update(publisher);
    }

    @Override
    public void delete(Publisher publisher) {
        log.info("Deleting publisher record");
        sessionFactory.getCurrentSession().delete(publisher);
    }

    @Override
    public List getAllPublishers() {
        log.info("Getting all publisher records");
        return sessionFactory.getCurrentSession().createCriteria(Publisher.class).list();
    }
}
