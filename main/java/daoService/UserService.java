package daoService;

import models.User;
import shared.AbstractCrud;

public interface UserService extends AbstractCrud<User> {
    User getUserByMail(String email);
}
