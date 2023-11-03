package com.example;

import com.example.car.Car;
import com.example.wheel.CEATWheel;
import com.example.wheel.MRFWheel;
import com.example.wheel.Wheel;

public class Application {
    public static void main(String[] args) {

        Wheel mrfWheel = new MRFWheel();
        Wheel ceatWheel = new CEATWheel();

        System.out.println("-".repeat(50));

        Car car=new Car(mrfWheel);
        System.out.println();

        car.move();
        System.out.println();
        car.move();
        System.out.println();
        car.setWheel(ceatWheel);
        car.move();

        System.out.println("-".repeat(50));

    }
}
