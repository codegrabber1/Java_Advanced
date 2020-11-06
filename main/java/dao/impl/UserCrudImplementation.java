package dao.impl;

import dao.UserDao;
import models.User;
import utills.ConnectionsUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserCrudImplementation implements UserDao {

    private static String READ_ALL = "select * from user";

    private static String CREATE = "insert into user (`email`, `first_name`, `last_name`, `role`) values (?,?,?,?)";
    private static String READ_BY_ID = "select * from user where id = ?";
    private static String UPDATE_BY_ID = "update user set email=?, first_name=?, last_name=?, role=? where id = ?";
    private static String DELETE_BY_ID = "delete from user where id = ?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserCrudImplementation() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        connection = ConnectionsUtils.openConection();
    }

    @Override
    public List<User> readAll() {
        List<User> userList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String email = resultSet.getString("email");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String role = resultSet.getString("role");

                userList.add(new User("email", "firstName","lastName","role"));
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return userList;
    }

    @Override
    public User create(User user) {

        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setString(4,user.getRole());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){

                user.setId(resultSet.getInt(1));
            } else {
                System.out.println("No result");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user;
    }

    @Override
    public User read(Integer id) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            String email = resultSet.getString("email");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String role = resultSet.getString("role");

            user = new User("email", "firstName", "lastName", "role");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User update(User user) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
