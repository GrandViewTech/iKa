package com.gvt.ika.testcase.service;

import com.gvt.ika.app.entity.bo.Product;
import com.gvt.ika.app.entity.bo.UnitOfMeasurement;
import com.gvt.ika.app.entity.bo.sku.StockKeepingUnit;
import com.gvt.ika.app.entity.bo.sku.TexttileSKU;
import com.gvt.ika.app.service.business.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ProductTestCase extends TestCase {


    @Autowired
    private ProductService productService;

    @Test
    public void saveProduct() {

        Product product = new Product();
        product.setName("Polo Men T-Shirt");
        product.setDisplay(true);
        product.setCode("" + UUID.randomUUID());
        product.setDescription("T-Shirts for Mens");

        product.setBrand("Raymond");
        Set<StockKeepingUnit> stockKeepingUnits = new HashSet<>();
        int threshold = 1;
        for (int i = 0; i < threshold; i++) {
            TexttileSKU stockKeepingUnit = new TexttileSKU();
            stockKeepingUnit.setCode("SKU_" + System.currentTimeMillis());
            stockKeepingUnit.setFabric("COTTON");
            stockKeepingUnit.setQuantity(new BigDecimal(10000));
            stockKeepingUnit.setColour("SKY BLUE");
            stockKeepingUnit.setUnitPrice(new BigDecimal(100));

            stockKeepingUnits.add(stockKeepingUnit);

        }
        product.setStockKeepingUnits(stockKeepingUnits);
        UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement("KG");
        product.setUnitOfMeasurement(unitOfMeasurement);
        productService.save(product);
    }
}
