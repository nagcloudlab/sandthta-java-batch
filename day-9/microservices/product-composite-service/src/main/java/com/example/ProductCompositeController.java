package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductCompositeController {


    private RestTemplate restTemplate=new RestTemplate();

    @GetMapping("/api/product-composite/{productId}")
    public Product getProductComposite(@PathVariable int productId){

        // Note : Sync-Request + Tight-coupling with Endpoint URLs

        // get product

        ResponseEntity<Product> r1 =restTemplate
                .getForEntity("http://localhost:7001/api/product/"+productId,Product.class);

        // get reviews
//        ResponseEntity<List> r2 =restTemplate
//                .getForEntity("http://localhost:7002/api/reviews?productId"+productId,List.class);
//
//        // get recommendations
//        ResponseEntity<List> r3 =restTemplate
//                .getForEntity("http://localhost:7002/api/recommendations?productId"+productId,List.class);

        // composite
        // TODO...

        return r1.getBody();

    }

}
