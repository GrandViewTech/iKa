package com.gvt.ika.client.rest;

import com.gvt.ika.app.entity.bo.Product;
import com.gvt.ika.app.service.business.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{productId}")
    @ResponseBody
    public ResponseEntity<Product> getProductByProductId(@PathVariable("productId") Long productId)
    {
        Product resultset=productService.findByProductId(productId);
        return new ResponseEntity<Product>(resultset, HttpStatus.OK);
    }
}
