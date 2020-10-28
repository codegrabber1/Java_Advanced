package servlet;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<User> lisOfUsers = new ArrayList<>();

    private static UserService userService;

    public UserService() {
    }

    public static UserService getUserService(){
        if(userService == null){
            userService = new UserService();
        }

        return userService;
    }

    public List<User> getListOfUser(){
        return lisOfUsers;
    }
    public void safeUser(User user){
        lisOfUsers.add(user);
    }

    public User getUserEmail(String email){
        return lisOfUsers.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
    }
}
