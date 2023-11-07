package com.example;

import com.example.model.Apple;
import com.example.model.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// SAM ( Single Abstract Method ) Interface
//interface Predicate {
//    boolean test(Apple apple);
//}

public class Ex2 {
    public static void main(String[] args) {
        List<Apple> inventory = List.of(
                new Apple(Color.RED, 60),
                new Apple(Color.RED, 150),
                new Apple(Color.GREEN, 40)
        );
        // User-Req-1: filter all green apples from above inventory
        // User-Req-2: filter all red apples from above inventory
        // User-Req-3: filter all heavy apples from above inventory
        System.out.println(
                //filterApples(inventory, (apple) -> apple.getColor().equals(Color.GREEN))
                //filterApples(inventory, (apple) -> apple.getColor().equals(Color.RED))
                filterApples(inventory,apple -> apple.getColor().equals(Color.RED) && apple.getWeight() ==150)
        );
    }


    public static List<Apple> filterApples(List<Apple> input, Predicate<Apple> predicate) {
        List<Apple> output = new ArrayList<>();
        for (Apple apple : input) {
            if (predicate.test(apple)) {
                output.add(apple);
            }
        }
        return output;
    }


}
