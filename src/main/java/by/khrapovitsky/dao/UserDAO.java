package by.khrapovitsky.dao;


import by.khrapovitsky.model.User;

import java.util.List;

public interface UserDAO {
    void create(User user);
    User read(String username);
    void update(User user);
    void delete(User user);
    List getAllUsers();
    User getByEmail(String email);
}
