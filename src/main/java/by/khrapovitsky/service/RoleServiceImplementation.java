package by.khrapovitsky.service;

import by.khrapovitsky.dao.RoleDAO;
import by.khrapovitsky.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImplementation implements RoleService{

    @Autowired
    RoleDAO roleDAO;

    @Override
    public void create(Role role) {
        roleDAO.create(role);
    }

    @Override
    public Role read(int id) {
        return roleDAO.read(id);
    }

    @Override
    public void update(Role role) {
        roleDAO.update(role);
    }

    @Override
    public void delete(Role role) {
        roleDAO.delete(role);
    }

    @Override
    public List getAllRoles() {
        return roleDAO.getAllRoles();
    }
}
