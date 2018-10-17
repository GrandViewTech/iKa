package com.gvt.ika.app.service.repository;

import com.gvt.ika.app.entity.bo.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {

    public Product findByProductId(Long productId);

    public Product save(Product product);

    public Product findBySkuCode(String code);
}
