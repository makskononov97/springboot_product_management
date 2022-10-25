package com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.dao;

import com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDAO  extends JpaRepository<Product, Integer> {

    public List<Product> getAllProducts();

    public void createProduct(Product product);

    public void saveChangesProduct(Product product);

    public Product getProduct(int id);

    public void deleteProduct(int id);

    public List<Product> searchProduct(@Param("searchName") String searchName);

    public Product getActiveProduct(String name);

}
