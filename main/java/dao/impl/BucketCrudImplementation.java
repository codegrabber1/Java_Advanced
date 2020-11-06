package dao.impl;

import dao.BucketDao;
import models.Bucket;
import utills.ConnectionsUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BucketCrudImplementation implements BucketDao {

    private static String READ_ALL = "select * from bucket";
    private static String CREATE = "insert into bucket (`user_id`, `product_id`, `purchace_date`) values (?,?,?)";
    private static String READ_BY_ID = "select * from bucket where id = ?";
    private static String UPDATE_BY_ID = "update bucket set user_id=?, product_id=?, purchace_date=? where id = ?";
    private static String DELETE_BY_ID = "delete from bucket where id = ?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public BucketCrudImplementation() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        connection = ConnectionsUtils.openConection();
    }

    @Override
    public List<Bucket> readAll() {
        List<Bucket> buckets = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer userId = resultSet.getInt("user_id");
                Integer productId = resultSet.getInt("product_id");
                Date purchaseDate = resultSet.getDate("purchace_date");

                buckets.add(new Bucket(userId, productId,purchaseDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buckets;
    }

    @Override
    public Bucket create(Bucket bucket){
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,bucket.getUserId());
            preparedStatement.setInt(2,bucket.getProductId());
            preparedStatement.setDate(3, new Date(bucket.getPurchaseDate().getTime()));
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            bucket.setId(resultSet.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bucket;
    }

    @Override
    public Bucket read(Integer id) {
        Bucket bucket = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Integer bucketId = resultSet.getInt(id);
            Integer userId = resultSet.getInt("user_id");
            Integer productId = resultSet.getInt("product_id");
            Date purchaseDate = resultSet.getDate("purchace_date");

            bucket = new Bucket(bucketId, userId, productId,purchaseDate);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bucket;
    }

    @Override
    public Bucket update(Bucket bucket) {
        throw new IllegalStateException("There's no such method");
    }

    @Override
    public void delete(Integer id){
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
