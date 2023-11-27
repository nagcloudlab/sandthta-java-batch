package com.example;

import lombok.Data;

@Data
public class Review {
    private Integer productId;
    private Integer id;
    private String author;
    private String body;
}
