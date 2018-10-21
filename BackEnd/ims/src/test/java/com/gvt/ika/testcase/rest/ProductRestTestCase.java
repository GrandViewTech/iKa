package com.gvt.ika.testcase.rest;

import com.gvt.ika.app.entity.bo.Product;
import com.gvt.ika.common.rest.entity.dto.Response;
import com.gvt.ika.common.rest.plugin.RestPlugin;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;

public class ProductRestTestCase {


    String baseUrl = "http://localhost:8092/ims/product";

    @Test
    public void findProductById() {

        int productId = 2;
        RestPlugin<Void, Product> restPlugin = new RestPlugin<>( new ParameterizedTypeReference<Response<Product>>(){});
        restPlugin.setHttpHeader("XCID", "1");
        ResponseEntity<Response<Product>> responseEntity = restPlugin.get(baseUrl + "/" + 2);
        Assert.assertTrue("Api Status Call Failed", responseEntity.getStatusCode().is2xxSuccessful());
        Response<Product> response = responseEntity.getBody();
        Assert.assertTrue("Unable to fetch data from API ", (response != null));
        Product product = response.getPayload();
        Assert.assertTrue("Request Data didnt Matched", (product != null) && product.getId() == productId);
    }

}
