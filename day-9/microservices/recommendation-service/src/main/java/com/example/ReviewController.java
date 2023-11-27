package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @GetMapping("/api/recommendations")
    public List<Recommendation> getRecommendations(@RequestParam int productId) {
        Recommendation r1 = new Recommendation();
        r1.setProductId(productId);
        r1.setId(1);
        r1.setName("product-456");
        r1.setPrice(100.00);

        Recommendation r2 = new Recommendation();
        r2.setProductId(productId);
        r2.setId(1);
        r2.setName("product-789");
        r2.setPrice(100.00);
        return List.of(r1, r2);
    }

}
