package by.khrapovitsky.dao;

import by.khrapovitsky.model.User;
import by.khrapovitsky.model.VerificationToken;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VerificationTokenRepository implements VerificationTokenDAO{

    private static final Logger log = Logger.getLogger(UserRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public VerificationToken findByToken(String token) {
        log.info("Finding VerificationToken by token");
        return (VerificationToken) sessionFactory.getCurrentSession().createCriteria(VerificationToken.class).add(Restrictions.eq("token", token)).uniqueResult();
    }

    @Override
    public VerificationToken findByUser(User user) {
        log.info("Finding VerificationToken by user");
        return (VerificationToken) sessionFactory.getCurrentSession().createCriteria(VerificationToken.class).add(Restrictions.eq("username", user.getUsername())).uniqueResult();
    }

    @Override
    public void createVerificationTokenForUser(VerificationToken token) {
        log.info("Creating token record");
        sessionFactory.getCurrentSession().save(token);
    }

    @Override
    public void deleteVerificationTokenForUser(VerificationToken token) {
        log.info("Deleting token record");
        sessionFactory.getCurrentSession().delete(token);
    }

}
