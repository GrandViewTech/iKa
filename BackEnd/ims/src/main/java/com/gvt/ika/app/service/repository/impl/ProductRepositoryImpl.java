package com.gvt.ika.app.service.repository.impl;

import com.gvt.ika.app.entity.bo.Product;
import com.gvt.ika.app.service.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Product findBySkuCode(String code) {
        String jpql = "SELECT product FROM Product product WHERE product.code=:code";
        TypedQuery<Product> typedQuery = entityManager.createQuery(jpql, Product.class);
        typedQuery.setParameter("code", code);
        List<Product> resultSet = typedQuery.getResultList();
        if (!resultSet.isEmpty()) {
            return resultSet.get(0);
        }
        return null;
    }

    public Product findByProductId(Long productId) {
        String jpql = "SELECT product FROM Product product WHERE product.id=:productId";
        TypedQuery<Product> typedQuery = entityManager.createQuery(jpql, Product.class);
        typedQuery.setParameter("productId", productId);
        List<Product> resultSet = typedQuery.getResultList();
        if (!resultSet.isEmpty()) {
            return resultSet.get(0);
        }
        return null;
    }

    public Product save(Product product) {

        entityManager.persist(product);
        return product;
    }


}
