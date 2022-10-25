package com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.service;


import com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public void createProduct(Product product);

    public void saveChangesProduct(Product product);

    public Product getProduct(int id);

    public void deleteProduct(int id);

    public List<Product> searchProduct(String searchName);

    public boolean isProductnameAlreadyInUse(String name);
}
