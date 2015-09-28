package by.khrapovitsky.dao;

import by.khrapovitsky.model.Role;

import java.util.List;

public interface RoleDAO {
    void create(Role role);
    Role read(int userRoleId);
    void update(Role role);
    void delete(Role role);
    List getAllRoles();
}
