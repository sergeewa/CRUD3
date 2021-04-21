package ru.jm.dao;

import ru.jm.model.User;
import java.util.List;

public interface UserDao {
    void editUser(User user);
    void removeUser(long id);
    void add(User user);
    List<User> getAllUsers();
}
