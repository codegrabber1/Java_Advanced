package daoService.impl;

import dao.BucketDao;
import dao.impl.BucketCrudImplementation;
import daoService.BucketService;
import models.Bucket;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class BucketServiceImplementation implements BucketService {
    private static Logger LOG = Logger.getLogger(BucketServiceImplementation.class);

    private static BucketServiceImplementation bucketServiceImplementation;

    private BucketDao bucketCrud;

    private BucketServiceImplementation(){
        try {
            bucketCrud = new BucketCrudImplementation();
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            LOG.error(e);
        }
    }

    public static BucketService getBucketService(){
        if(bucketServiceImplementation == null) {
            bucketServiceImplementation = new BucketServiceImplementation();
        }
        return bucketServiceImplementation;
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
