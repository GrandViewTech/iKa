package com.gvt.ika.app.service.business.impl;

import com.gvt.ika.app.entity.bo.Product;
import com.gvt.ika.app.entity.bo.sku.StockKeepingUnit;
import com.gvt.ika.app.service.business.StockKeeptingUnitService;
import com.gvt.ika.app.service.repository.StockKeeptingUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StockKeeptingUnitServiceImpl implements StockKeeptingUnitService {

    @Autowired
    StockKeeptingUnitRepository stockKeeptingUnitRepository;

    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public Product saveOrUpdate(Product product) {
        Set<StockKeepingUnit> updatedskus = new HashSet<>();
        for (StockKeepingUnit stockKeepingUnit : product.getStockKeepingUnits()) {
            StockKeepingUnit existing = stockKeeptingUnitRepository.findBySkuCode(stockKeepingUnit.getCode());
            if (existing != null) {
                stockKeepingUnit = existing.update(stockKeepingUnit);
            }
            stockKeepingUnit.setProduct(product);
            updatedskus.add(stockKeepingUnit);
        }
        updatedskus = stockKeeptingUnitRepository.saveOrUpdate(updatedskus);
        product.setStockKeepingUnits(updatedskus);
        return product;
    }
}
