package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/api/product/{productId}")
    public Product getProduct(@PathVariable int productId) {
        Product product = new Product();
        product.setId(productId);
        product.setName("product-1");
        product.setPrice(1000.00);
        return product;
    }

}
