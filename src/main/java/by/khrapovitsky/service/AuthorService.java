package by.khrapovitsky.service;


import by.khrapovitsky.model.Author;

import java.util.List;

public interface AuthorService {
    void create(Author author);
    Author read(String authorId);
    void update(Author author);
    void delete(Author author);
    List getAllAuthors();
}
