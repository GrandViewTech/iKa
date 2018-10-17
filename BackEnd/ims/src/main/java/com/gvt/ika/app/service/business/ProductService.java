package com.gvt.ika.app.service.business;

import com.gvt.ika.app.entity.bo.Product;

public interface ProductService {

     public Product findByProductId(Long productId);

     public Product save(Product product);
}

