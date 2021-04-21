package ru.jm.service;

import ru.jm.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    void editUser(User user);
    void removeUser(long id);
    void add(User user);
    List<User> getAllUsers();
}
