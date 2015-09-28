package by.khrapovitsky.service;

import by.khrapovitsky.dao.AuthorDAO;
import by.khrapovitsky.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImplementation implements AuthorService{

    @Autowired
    AuthorDAO authorDAO;

    @Override
    public void create(Author author) {
        authorDAO.create(author);
    }

    @Override
    public Author read(String authorId) {
        return authorDAO.read(authorId);
    }

    @Override
    public void update(Author author) {
        authorDAO.update(author);
    }

    @Override
    public void delete(Author author) {
        authorDAO.delete(author);
    }

    @Override
    public List getAllAuthors() {
        return authorDAO.getAllAuthors();
    }
}
