package by.khrapovitsky.dao;

import by.khrapovitsky.model.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserDAO{

    private static final Logger log = Logger.getLogger(UserRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(User user) {
        log.info("Creating user record");
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User read(String username) {
        log.info("Reading user record");
        return (User) sessionFactory.getCurrentSession().get(User.class,username);
    }

    @Override
    public void update(User user) {
        log.info("Updating user record");
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(User user) {
        log.info("Deleting user record");
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public List getAllUsers() {
        log.info("Getting all user records");
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public User getByEmail(String email) {
        log.info("Reading user by email record");
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("email", email)).uniqueResult();
    }
}
