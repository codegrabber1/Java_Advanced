package dao;

import models.User;
import shared.AbstractCrud;

public interface UserDao extends AbstractCrud<User> {
    User getUserByMail(String email);
}
