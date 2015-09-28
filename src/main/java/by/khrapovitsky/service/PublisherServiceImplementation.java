package by.khrapovitsky.service;

import by.khrapovitsky.dao.PublisherDAO;
import by.khrapovitsky.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PublisherServiceImplementation implements PublisherService{

    @Autowired
    PublisherDAO publisherDAO;


    @Override
    public void create(Publisher publisher) {
        publisherDAO.create(publisher);
    }

    @Override
    public Publisher read(int publisherId) {
        return publisherDAO.read(publisherId);
    }

    @Override
    public void update(Publisher publisher) {
        publisherDAO.update(publisher);
    }

    @Override
    public void delete(Publisher publisher) {
        publisherDAO.delete(publisher);
    }

    @Override
    public List getAllPublishers() {
        return publisherDAO.getAllPublishers();
    }
}
