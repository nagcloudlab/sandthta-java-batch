package com.example;

import com.example.model.Apple;
import com.example.model.Color;

import java.util.List;

public class Ex2 {
    public static void main(String[] args) {

        List<Apple> inventory = List.of(
                new Apple(Color.RED, 60),
                new Apple(Color.RED, 150),
                new Apple(Color.GREEN, 40)
        );

        // exercise: filter all red apples from above inventory

    }
}
