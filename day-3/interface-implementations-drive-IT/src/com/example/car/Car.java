package com.example.car;

import com.example.wheel.MRFWheel;
import com.example.wheel.Wheel;

public class Car {

    private Wheel wheel;

    public  Car(Wheel wheel) {
        this.wheel = wheel;
        System.out.println("Car instance created..");
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public void move(){
        int rpm=wheel.rotate(100);
        System.out.println("Car moving..."+rpm);
    }
}
