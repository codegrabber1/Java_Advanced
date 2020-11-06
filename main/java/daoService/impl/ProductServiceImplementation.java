package daoService.impl;

import dao.ProductDao;
import dao.impl.ProductCrudImplementation;
import models.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImplementation implements ProductDao {

    private ProductDao productCrud;

    public ProductServiceImplementation(){
        try {
            productCrud = new ProductCrudImplementation();
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
