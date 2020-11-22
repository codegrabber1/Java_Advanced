package daoService.impl;

import dao.UserDao;
import dao.impl.UserCrudImplementation;
import daoService.UserService;
import models.User;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImplementation implements UserService {
    private static Logger LOG = Logger.getLogger(UserServiceImplementation.class);

    private UserDao userDao;
    private static UserService userService;

    private UserServiceImplementation(){
        try {
            userDao = new UserCrudImplementation();
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            LOG.error(e);
        }
    }

    public static UserService getUserService(){
        if(userService == null) {
            userService = new UserServiceImplementation();
        }
        return userService;
    }

    @Override
    public List<User> readAll() {
        return userDao.readAll();
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User read(Integer id) {
        return userDao.read(id);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public User getUserByMail(String email) {
        return userDao.getUserByMail(email);
    }
}
