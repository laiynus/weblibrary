package by.khrapovitsky.service;

import by.khrapovitsky.model.Role;

import java.util.List;

public interface RoleService {
    void create(Role role);
    Role read(int id);
    void update(Role role);
    void delete(Role role);
    List getAllRoles();
}
