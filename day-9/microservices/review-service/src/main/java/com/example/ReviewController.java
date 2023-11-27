package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @GetMapping("/api/review")
    public List<Review> getReview(@RequestParam int productId) {
        Review review1 = new Review();
        review1.setProductId(productId);
        review1.setId(1);
        review1.setAuthor("Who-1");
        review1.setBody("Good product");
        Review review2 = new Review();
        review2.setProductId(productId);
        review2.setId(2);
        review2.setAuthor("Who-2");
        review2.setBody("Bad product");
        return List.of(review2, review1);
    }

}
