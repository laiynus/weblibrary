package by.khrapovitsky.dao;


import by.khrapovitsky.model.Publisher;

import java.util.List;

public interface PublisherDAO {
    void create(Publisher publisher);
    Publisher read(int publisherId);
    void update(Publisher publisher);
    void delete(Publisher publisher);
    List getAllPublishers();
}
