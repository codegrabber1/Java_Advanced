import daoService.UserService;
import daoService.impl.UserServiceImplementation;
import models.User;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImplementation();

        userService.create(new User("a@a.com", "test", "test", "test"));
    }
}
