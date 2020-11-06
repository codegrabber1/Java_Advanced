package dao.impl;

import dao.ProductDao;
import models.Product;
import utills.ConnectionsUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCrudImplementation implements ProductDao {

    private static String READ_ALL = "select * from products";
    private static String CREATE = "insert into products (`name`, `description`, `price`) values (?,?,?)";
    private static String READ_BY_ID = "select * from products where id = ?";
    private static String UPDATE_BY_ID = "update products set name=?, description=?, price=? where id = ?";
    private static String DELETE_BY_ID = "delete from products where id = ?";

    private Connection connection;
    private PreparedStatement preparedStatement;


    public ProductCrudImplementation() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection connection = ConnectionsUtils.openConection();
    }

    @Override
    public List<Product> readAll() {
        List<Product> products = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Double price = resultSet.getDouble("price");

                products.add(new Product("name", "description", price));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return products;
    }

    @Override
    public Product create(Product product) {
        try {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, "name");
            preparedStatement.setString(2, "description");
            preparedStatement.setDouble(3, product.getPrice());

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            product.setId(resultSet.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public Product read(Integer id) {
        Product product = null;

        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            String name = resultSet.getString("name");
            String description = resultSet.getNString("description");
            Double price = resultSet.getDouble("price");

            product = new Product("name", "description", price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
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
