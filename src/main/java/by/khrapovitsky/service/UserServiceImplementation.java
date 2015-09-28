package by.khrapovitsky.service;

import by.khrapovitsky.dao.UserDAO;
import by.khrapovitsky.dao.VerificationTokenDAO;
import by.khrapovitsky.model.User;
import by.khrapovitsky.model.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImplementation implements UserService,UserDetailsService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private VerificationTokenDAO verificationTokenDAO;

    @Override
    public void create(User user) {
        userDAO.create(user);
    }

    @Override
    public User read(String username) {
        return userDAO.read(username);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public List getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    @Override
    public void createVerificationTokenForUser(User user, String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        verificationTokenDAO.createVerificationTokenForUser(myToken);
    }

    @Override
    public VerificationToken getVerificationToken(String verificationToken) {
        return verificationTokenDAO.findByToken(verificationToken);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return read(s);
    }


}
