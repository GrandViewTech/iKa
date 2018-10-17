package com.gvt.ika.app.service.business.impl;

import com.gvt.ika.app.entity.bo.Product;
import com.gvt.ika.app.entity.bo.UnitOfMeasurement;
import com.gvt.ika.app.service.business.MiscellaniousService;
import com.gvt.ika.app.service.business.ProductService;
import com.gvt.ika.app.service.business.StockKeeptingUnitService;
import com.gvt.ika.app.service.repository.ProductRepository;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    private static Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MiscellaniousService miscellaniousService;

    @Autowired
    private StockKeeptingUnitService stockKeeptingUnitService;

    @Override
    public Product findByProductId(Long productId) {
        return productRepository.findByProductId(productId);
    }

    @Transactional
    public Product save(Product product) {

        UnitOfMeasurement unitOfMeasurement = product.getUnitOfMeasurement();
        if (unitOfMeasurement != null) {
            String uom = unitOfMeasurement.getUom();
            unitOfMeasurement = miscellaniousService.findByUom(uom);
            product.setUnitOfMeasurement(unitOfMeasurement);
        }
        product = stockKeeptingUnitService.saveOrUpdate(product);
        return productRepository.save(product);
    }
}
