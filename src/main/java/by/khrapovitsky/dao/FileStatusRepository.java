package by.khrapovitsky.dao;

import by.khrapovitsky.model.FileStatus;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileStatusRepository implements FileStatusDAO {

    private static final Logger log = Logger.getLogger(FileStatusRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(FileStatus fileStatus) {
        log.info("Creating fileStatus record");
        sessionFactory.getCurrentSession().save(fileStatus);
    }

    @Override
    public FileStatus read(Integer fileStatusId) {
        log.info("Reading fileStatus record");
        return (FileStatus) sessionFactory.getCurrentSession().get(FileStatus.class,fileStatusId);
    }

    @Override
    public void update(FileStatus fileStatus) {
        log.info("Updating fileStatus record");
        sessionFactory.getCurrentSession().update(fileStatus);
    }

    @Override
    public void delete(FileStatus fileStatus) {
        log.info("Deleting fileStatus record");
        sessionFactory.getCurrentSession().delete(fileStatus);
    }

    @Override
    public List getAllFileStatuses() {
        log.info("Getting all fileStatus records");
        return sessionFactory.getCurrentSession().createCriteria(FileStatus.class).list();
    }
}
