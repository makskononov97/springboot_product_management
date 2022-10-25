package com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.dao;

import com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Product> getAllProducts() {

        Query query = entityManager.createQuery("from Product "
                + "where activity = 'active'");

        List<Product> allProducts = query.getResultList();

        return allProducts;
    }

    @Override
    public void createProduct(Product product) {

        Product newProduct = entityManager.merge(product);
        product.setId(newProduct.getId());
    }

    @Override
    public void saveChangesProduct(Product product) {

        Product newProduct = entityManager.merge(product);
        product.setId(newProduct.getId());
    }

    @Override
    public Product getProduct(int id) {

        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public void deleteProduct(int id) {

        Query query = entityManager.createQuery("update Product" +
                " set activity = 'deleted' where id =:productId");
        query.setParameter("productId", id);

        query.executeUpdate();

    }

    @Override
    public List<Product> searchProduct(String searchName) {

        Query query = entityManager.createQuery("SELECT c FROM Product c"
                + " WHERE c.name LIKE '%' || :searchName || '%' AND activity = 'active'");
        query.setParameter("searchName", searchName);

        List<Product> searchRes = query.getResultList();

        return searchRes;
    }

    @Override
    public Product getActiveProduct(String name) {

        Product product;

        try {
            product = (Product) entityManager.createQuery("from Product p"
                            + " where p.name = :name and activity = 'active'")
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            product = null;
        }

        return product;
    }
}
