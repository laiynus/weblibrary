package by.khrapovitsky.dao;

import by.khrapovitsky.model.Role;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository implements RoleDAO{

    private static final Logger log = Logger.getLogger(RoleRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(Role role) {
        log.info("Creating role record");
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public Role read(int userRoleId) {
        log.info("Reading role record");
        return (Role) sessionFactory.getCurrentSession().get(Role.class,userRoleId);
    }

    @Override
    public void update(Role role) {
        log.info("Updating role record");
        sessionFactory.getCurrentSession().update(role);
    }

    @Override
    public void delete(Role role) {
        log.info("Deleting role record");
        sessionFactory.getCurrentSession().delete(role);
    }

    @Override
    public List getAllRoles() {
        log.info("Getting all role records");
        return sessionFactory.getCurrentSession().createCriteria(Role.class).list();
    }
}
