package ru.jm.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.jm.dao.UserDao;
import ru.jm.dao.UserDaoImpl;
import ru.jm.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }
    @Override
    public void removeUser(long id) {
        userDao.removeUser(id);
    }
    @Override
    public void add(User user) {
        userDao.add(user);
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
