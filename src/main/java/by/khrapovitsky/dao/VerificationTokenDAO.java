package by.khrapovitsky.dao;

import by.khrapovitsky.model.User;
import by.khrapovitsky.model.VerificationToken;

public interface VerificationTokenDAO {
    VerificationToken findByToken(String token);
    VerificationToken findByUser(User user);
    void createVerificationTokenForUser(VerificationToken token);
}
