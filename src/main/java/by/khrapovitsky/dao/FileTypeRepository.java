package by.khrapovitsky.dao;

import by.khrapovitsky.model.FileType;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileTypeRepository implements FileTypeDAO{

    private static final Logger log = Logger.getLogger(FileTypeRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(FileType fileType) {
        log.info("Creating fileType record");
        sessionFactory.getCurrentSession().save(fileType);
    }

    @Override
    public FileType read(String fileType) {
        log.info("Reading fileType record");
        return (FileType) sessionFactory.getCurrentSession().get(FileType.class,fileType);
    }

    @Override
    public void update(FileType fileType) {
        log.info("Updating fileType record");
        sessionFactory.getCurrentSession().update(fileType);
    }

    @Override
    public void delete(FileType fileType) {
        log.info("Deleting fileType record");
        sessionFactory.getCurrentSession().delete(fileType);
    }

    @Override
    public List getAllFileTypes() {
        log.info("Getting all fileType records");
        return sessionFactory.getCurrentSession().createCriteria(FileType.class).list();
    }
}
