package com.gvt.ika.client.rest;

import com.gvt.ika.app.entity.bo.Product;
import com.gvt.ika.app.service.business.ProductService;
import com.gvt.ika.common.rest.entity.dto.Response;
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

    public ResponseEntity<Response<Product>> getProductByProductId(@PathVariable("productId") Long productId) {
        Response<Product> companyResponse = new Response<Product>();
        Product resultset = productService.findByProductId(productId);
        if (resultset == null) {
            companyResponse.setStatus(HttpStatus.NOT_FOUND.value());
            companyResponse.setMessage("Product with productId = " + productId + " not Found.");
            return new ResponseEntity<Response<Product>>(companyResponse, HttpStatus.OK);
        } else {
            companyResponse.setPayload(resultset);
            companyResponse.setStatus(HttpStatus.OK.value());
            companyResponse.setMessage("Product with productId = " + productId + " Found.");
            return new ResponseEntity<Response<Product>>(companyResponse, HttpStatus.OK);
        }

    }

}
