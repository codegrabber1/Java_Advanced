package daoService.impl;

import dao.UserDao;
import dao.impl.UserCrudImplementation;
import daoService.UserService;
import models.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImplementation implements UserService {

    private UserDao userDao;

    public UserServiceImplementation(){
        try {
            userDao = new UserCrudImplementation();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
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
}
