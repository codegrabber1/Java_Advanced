package daoService.impl;

import dao.BucketDao;
import dao.impl.BucketCrudImplementation;
import daoService.BucketService;
import models.Bucket;

import java.sql.SQLException;
import java.util.List;

public class BucketServiceImplementation implements BucketService {

    private BucketDao bucketCrud;

    public BucketServiceImplementation(){
        try {
            bucketCrud = new BucketCrudImplementation();
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
    public List<Bucket> readAll() {
        return bucketCrud.readAll();
    }

    @Override
    public Bucket create(Bucket bucket) {
        return bucketCrud.create(bucket);
    }

    @Override
    public Bucket read(Integer id) {
        return bucketCrud.read(id);
    }

    @Override
    public Bucket update(Bucket bucket) {
        return bucketCrud.update(bucket);
    }

    @Override
    public void delete(Integer id) {
        bucketCrud.delete(id);
    }
}
