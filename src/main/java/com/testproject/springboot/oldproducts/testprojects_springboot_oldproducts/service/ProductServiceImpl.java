package com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.service;


import com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.dao.ProductDAO;
import com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    @Transactional
    public void createProduct(Product product) {
        productDAO.createProduct(product);
    }

    @Override
    @Transactional
    public void saveChangesProduct(Product product) {
        productDAO.saveChangesProduct(product);
    }

    @Override
    @Transactional
    public Product getProduct(int id) {
        return productDAO.getProduct(id);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }

    @Override
    @Transactional
    public List<Product> searchProduct(String searchName) {
        return productDAO.searchProduct(searchName);
    }

    @Override
    @Transactional
    public boolean isProductnameAlreadyInUse(String name) {

        boolean productInDb = true;
        if (productDAO.getActiveProduct(name) == null) productInDb = false;
        return productInDb;
    }
}
