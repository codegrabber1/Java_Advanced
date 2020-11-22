package daoService.impl;

import dao.ProductDao;
import dao.impl.ProductCrudImplementation;
import daoService.ProductService;
import models.Product;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImplementation implements ProductService {

    private static Logger LOG = Logger.getLogger(ProductServiceImplementation.class);

    private ProductDao productCrud;
    private static ProductServiceImplementation productService;

    private ProductServiceImplementation(){
        try {
            productCrud = new ProductCrudImplementation();
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            LOG.error(e);
        }
    }

    public static ProductService getProductService(){
        if(productService == null) {
            productService = new ProductServiceImplementation();
        }

        return productService;
    }

    @Override
    public List<Product> readAll() {
        return productCrud.readAll();
    }

    @Override
    public Product create(Product product) {
        return productCrud.create(product);
    }

    @Override
    public Product read(Integer id) {
        return productCrud.read(id);
    }

    @Override
    public Product update(Product product) {
        return productCrud.update(product);
    }

    @Override
    public void delete(Integer id) {
        productCrud.delete(id);
    }
}
