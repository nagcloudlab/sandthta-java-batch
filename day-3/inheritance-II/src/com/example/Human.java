package com.example;

/**
 * author: Team-1
 */

// Human 'is-a' LivingThing

public class Human extends  LivingThing {
    public void study(){
        System.out.println("Human-study()");
    }
    // re-implement super-class's behavior with different logic ( Overriding )
    public void work(){
        System.out.println("Human-work() with study knowledge");
    }
}
