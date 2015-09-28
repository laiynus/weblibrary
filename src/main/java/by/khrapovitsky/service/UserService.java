package by.khrapovitsky.service;

import by.khrapovitsky.model.User;
import by.khrapovitsky.model.VerificationToken;

import java.util.List;

public interface UserService {
    void create(User user);
    User read(String username);
    void update(User user);
    void delete(User user);
    List getAllUsers();
    User getByEmail(String email);
    void createVerificationTokenForUser(User user, String token);
    VerificationToken getVerificationToken(String verificationToken);
}
